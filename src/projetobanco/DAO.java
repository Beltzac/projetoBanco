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
public class DAO implements IDAO {

    private IDAO dao;

    public DAO() {

        if (Config.prop.getProperty("persistence").equalsIgnoreCase("sgbd")) {
            dao = new SGBDDAO();
        } else if(Config.prop.getProperty("persistence").equalsIgnoreCase("file")){
            dao = new FileDAO();
        }
    }

    //Apenas para testes
    @Override
    public ArrayList<Cliente> pesquisaCliente(String texto) throws Exception {
        return dao.pesquisaCliente(texto);
    }

    @Override
    public Conta carregaConta(int codigoCliente) throws Exception {
        return dao.carregaConta(codigoCliente);
    }

    @Override
    public void deletaContaCorrente(int codigoConta) throws Exception {
        dao.deletaContaCorrente(codigoConta);
    }

    @Override
    public void deletaContaInvestimento(int codigoConta) throws Exception {
        dao.deletaContaInvestimento(codigoConta);
    }

    @Override
    public void atualizaConta(Conta conta) throws Exception {
        dao.atualizaConta(conta);
    }

    @Override
    public void atualizaCliente(Cliente cliente) throws Exception {
        dao.atualizaCliente(cliente);
    }

    @Override
    public void deletaCliente(Cliente cliente) throws Exception {
        dao.deletaCliente(cliente);
    }

    @Override
    public void criaContaCorrente(Conta conta) throws Exception {
        dao.criaContaCorrente(conta);
    }

    @Override
    public void criaContaInvestimento(Conta conta) throws Exception {
        dao.criaContaInvestimento(conta);
    }

    @Override
    public void criaCliente(Cliente cliente) throws Exception {
        dao.criaCliente(cliente);
    }

    @Override
    public Cliente carregaCliente(int codigoCliente) throws Exception {
        return dao.carregaCliente(codigoCliente);
    }
}
