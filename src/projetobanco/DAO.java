/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Codification
 */
public class DAO {
    
    private Connection connection;
    
    public DAO() { // desabilitado pra teste
       // this.connection = new ConnectionFactory().getConnection();
    }
    /*
     public void adicionaCliente(Cliente cliente) {
     String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
     try {
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEmail());
     stmt.setString(3, contato.getEndereco());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
     throw new RuntimeException(e);
     }
     }
     */

    //Apenas para testes
    public ArrayList<Cliente> pesquisaCliente(String texto) {
        ArrayList<Cliente> c = new ArrayList<>();
        
        Cliente a = new Cliente();
        a.setNome("João");
        a.setCPF("545.446.454-11");
        a.setRG("6.456.465-5");
        a.setCodigo(0);
        a.setSobrenome("da Silva");
        a.setEndereco("Rua Aristides Cooper Nº 30");
        a.setSalario(3500.00);
        
        Cliente b = new Cliente();
        b.setNome("Maria");
        b.setCPF("345.346.454-45");
        b.setRG("9.776.345-5");
        b.setCodigo(1);
        b.setSobrenome("Carvalho");
        b.setEndereco("Rua Aristides Cooper Nº 31");
        b.setSalario(1200.00);
        
        c.add(b);
        c.add(a);
        
        
        
        return c;
    }
    /*
     public void deletaCliente(String cpf) {
     String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
     try {
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEmail());
     stmt.setString(3, contato.getEndereco());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
     throw new RuntimeException(e);
     }
     }
       
     public void adicionaConta(Conta conta) {
     String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
     try {
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEmail());
     stmt.setString(3, contato.getEndereco());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
     throw new RuntimeException(e);
     }
     }
    
     public Conta carregaConta(String cpf) {
           
     String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
     try {
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEmail());
     stmt.setString(3, contato.getEndereco());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
     throw new RuntimeException(e);
     }
     return null;
     }
       
     public void deletaConta(String codigo) {
     String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
     try {
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEmail());
     stmt.setString(3, contato.getEndereco());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
     throw new RuntimeException(e);
     }
     }
     */
}
