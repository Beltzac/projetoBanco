/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Codification
 */
public class DAO {

    private Connection con;

    public DAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Apenas para testes
    public ArrayList<Cliente> pesquisaCliente(String texto) throws Exception {
        ArrayList<Cliente> c = new ArrayList<>();
        if (texto == null || texto.equals("")) {            
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobreNome"));
                cliente.setRG(rs.getString("rg"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setSalario(rs.getDouble("salario"));
                c.add(cliente);
            }
        } else {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? OR sobreNome LIKE ? OR cpf LIKE ? OR rg LIKE ?");
            texto = "%" + texto + "%";
            stmt.setString(1, texto);
            stmt.setString(2, texto);
            stmt.setString(3, texto);
            stmt.setString(4, texto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobreNome"));
                cliente.setRG(rs.getString("rg"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setSalario(rs.getDouble("salario"));
                c.add(cliente);
            }
        }
        return c;
    }

    public Conta carregaConta(int codigoCliente) throws Exception {
        Conta conta = null;
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM contaCorrente WHERE cliente = ?");
        stmt.setInt(1, codigoCliente);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            conta = new ContaCorrente();
            conta.setNumero(rs.getInt("numero"));
            conta.setDono(rs.getInt("cliente"));
            conta.setDepositoInicial(rs.getDouble("depositoInicial"));
            conta.setSaldo(rs.getDouble("saldo"));
            ((ContaCorrente) conta).setLimite(rs.getDouble("limite"));
        }
        PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM contaInvestimento WHERE cliente = ?");
        stmt2.setInt(1, codigoCliente);
        ResultSet rs2 = stmt2.executeQuery();
        if (rs2.next()) {
            conta = new ContaInvestimento();
            conta.setNumero(rs2.getInt("numero"));
            conta.setDono(rs2.getInt("cliente"));
            conta.setDepositoInicial(rs2.getDouble("depositoInicial"));
            conta.setSaldo(rs2.getDouble("saldo"));
            ((ContaInvestimento) conta).setMontanteMinimo(rs2.getDouble("montanteMinimo"));
            ((ContaInvestimento) conta).setDepositoMinimo(rs2.getDouble("depositoMinimo"));
        }
        return conta;
    }

    public void deletaContaCorrente(int codigoConta) throws Exception{
    	PreparedStatement stmt = con.prepareStatement("DELETE FROM contaCorrente WHERE numero = ?");
        stmt.setInt(1, codigoConta);
        stmt.executeUpdate();
    }
    
    public void deletaContaInvestimento(int codigoConta) throws Exception{
    	PreparedStatement stmt = con.prepareStatement("DELETE FROM contaInvestimento WHERE numero = ?");
        stmt.setInt(1, codigoConta);
        stmt.executeUpdate();
    }

    void atualizaConta(Conta conta) throws Exception{
    	PreparedStatement stmt;
    	if(conta instanceof ContaInvestimento){
    		stmt = con.prepareStatement("UPDATE contaInvestimento SET saldo = ? WHERE cliente = ?");
    	}else{
    		stmt = con.prepareStatement("UPDATE contaCorrente SET saldo = ? WHERE cliente = ?");
    	}
        stmt.setDouble(1, conta.getSaldo());
        stmt.setInt(2, conta.getDono().getCodigo());
        stmt.executeUpdate();
    }

    void atualizaCliente(Cliente cliente) throws Exception{
    	PreparedStatement stmt = con.prepareStatement("UPDATE cliente SET nome = ?,sobreNome = ?,rg = ?,cpf = ?,endereco = ?,salario = ? WHERE codigo = ?");
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getSobrenome());
        stmt.setString(3, cliente.getRG());
        stmt.setString(4, cliente.getCPF());
        stmt.setString(5, cliente.getEndereco());
        stmt.setDouble(6, cliente.getSalario());
        stmt.setDouble(7, cliente.getCodigo());
        stmt.executeUpdate();
    }

    void deletaCliente(Cliente cliente) throws Exception{
    	PreparedStatement stmt = con.prepareStatement("DELETE FROM contaCorrente WHERE cliente = ?");
        stmt.setInt(1, cliente.getCodigo());
        stmt.executeUpdate();
        stmt = con.prepareStatement("DELETE FROM contaInvestimento WHERE cliente = ?");
        stmt.setInt(1, cliente.getCodigo());
        stmt.executeUpdate();
    	stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
        stmt.setInt(1, cliente.getCodigo());
        stmt.executeUpdate();
        
    }

    void criaContaCorrente(Conta conta) throws Exception {
        PreparedStatement stmt;
        stmt = con.prepareStatement("INSERT INTO contaCorrente VALUES(0,?,?,?,?)");
        stmt.setInt(1, conta.getDono().getCodigo());
        stmt.setDouble(2, conta.getSaldo());
        stmt.setDouble(3, conta.getDepositoInicial());
        stmt.setDouble(4, ((ContaCorrente) conta).getLimite());
        stmt.executeUpdate();
    }

    void criaContaInvestimento(Conta conta) throws Exception {
        PreparedStatement stmt;
        stmt = con.prepareStatement("INSERT INTO contaInvestimento VALUES(0,?,?,?,?,?)");
        stmt.setInt(1, conta.getDono().getCodigo());
        stmt.setDouble(2, conta.getSaldo());
        stmt.setDouble(3, conta.getDepositoInicial());
        stmt.setDouble(4, ((ContaInvestimento) conta).getMontanteMinimo());
        stmt.setDouble(5, ((ContaInvestimento) conta).getDepositoMinimo());
        stmt.executeUpdate();
    }

    void criaCliente(Cliente cliente) throws Exception {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente VALUES(0,?,?,?,?,?,?)");
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getSobrenome());
        stmt.setString(3, cliente.getRG());
        stmt.setString(4, cliente.getCPF());
        stmt.setString(5, cliente.getEndereco());
        stmt.setDouble(6, cliente.getSalario());
        stmt.executeUpdate();
    }

    Cliente carregaCliente(int codigoCliente) throws SQLException {
         PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");
         stmt.setInt(1, codigoCliente);
            ResultSet rs = stmt.executeQuery();
             Cliente cliente = new Cliente();
            while (rs.next()) {                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobreNome"));
                cliente.setRG(rs.getString("rg"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setSalario(rs.getDouble("salario"));     
                return cliente;
            }
            return null;
            
    }
}
