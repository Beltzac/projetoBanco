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


     public Conta carregaConta(int codigoCliente) {
         
        return null;          
     }
       
     public void deletaConta(int codigoConta) {

     }

    void atualizaConta(Conta conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void atualizaCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deletaCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void criaConta(Conta conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Cliente carregaCliente(int codigoCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
