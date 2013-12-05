/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.util.ArrayList;

/**
 *
 * @author Codification
 */
public interface IDAO {
    
    public ArrayList<Cliente> pesquisaCliente(String texto) throws Exception;
    public Cliente carregaCliente(int codigoCliente) throws Exception;
    public Conta carregaConta(int codigoCliente) throws Exception;
    public void deletaContaCorrente(int codigoConta) throws Exception;
    public void deletaContaInvestimento(int codigoConta) throws Exception;
    public void atualizaConta(Conta conta) throws Exception;
    public void atualizaCliente(Cliente cliente) throws Exception;
    public void deletaCliente(Cliente cliente) throws Exception;
    public void criaContaCorrente(Conta conta) throws Exception;
    public void criaContaInvestimento(Conta conta) throws Exception;
    void criaCliente(Cliente cliente) throws Exception;
    

}
