/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Codification
 */
public class FileDAO implements IDAO {

    String arquivo;

    public FileDAO() {
        arquivo = Config.prop.getProperty("file");
    }

    private ArrayList<Cliente> carregarListaClientes() throws Exception {
        BufferedReader br;
        ArrayList<Cliente> c = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(arquivo));

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                String[] split = line.split(";");
                for (String string : split) {
                    System.out.println(string);
                }
                
                

                Cliente cliente = new Cliente();
                cliente.setCodigo(Integer.parseInt(split[0]));
                cliente.setNome(split[1]);
                cliente.setSobrenome(split[2]);
                cliente.setRG(split[3]);
                cliente.setCPF(split[4]);
                cliente.setEndereco(split[5]);
                cliente.setSalario(Double.valueOf(split[6]));
                c.add(cliente);
                line = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    private void gravaListaClientes(ArrayList<Cliente> c) {
        try {
            PrintWriter writer = new PrintWriter(arquivo, "UTF-8");
            for (Cliente cliente : c) {
                writer.println(cliente.getCodigo() + ";" + cliente.getNome() + ";" + cliente.getSobrenome() + ";" + cliente.getRG() + ";" + cliente.getCPF() + ";" + cliente.getEndereco() + ";" + cliente.getSalario());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criaCliente(Cliente cliente) throws Exception {
        ArrayList<Cliente> c = carregarListaClientes();
        c.add(cliente);
        gravaListaClientes(c);
    }

    @Override
    public void deletaCliente(Cliente cliente) throws Exception {
        ArrayList<Cliente> c = carregarListaClientes();
        
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getCodigo() == cliente.getCodigo())
            c.remove(i);          
        }
 
        gravaListaClientes(c);
    }

    @Override
    public ArrayList<Cliente> pesquisaCliente(String texto) throws Exception {
        ArrayList<Cliente> c = carregarListaClientes();
        ArrayList<Cliente> r = new ArrayList<>();
        for (Cliente cliente : c) {
            if (cliente.getNome().contains(texto) || cliente.getSobrenome().contains(texto) || cliente.getCPF().contains(texto)) {
                r.add(cliente);
            }
        }
        return r;
    }

    @Override
    public Cliente carregaCliente(int codigoCliente) throws Exception {
        ArrayList<Cliente> c = carregarListaClientes();
        for (Cliente cliente : c) {
            if (cliente.getCodigo() == codigoCliente) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Conta carregaConta(int codigoCliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletaContaCorrente(int codigoConta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletaContaInvestimento(int codigoConta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaConta(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaCliente(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaContaCorrente(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaContaInvestimento(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
