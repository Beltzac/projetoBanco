/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Codification
 */
public abstract class Conta implements ContaI {

    private double depositoInicial;
    private int numero;
    private int dono;
    private double saldo;

    @Override
    public Cliente getDono() {
        DAO dao = new DAO();
        try {
            return dao.carregaCliente(dono);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * @return the depositoInicial
     */
    public double getDepositoInicial() {
        return depositoInicial;
    }

    /**
     * @param depositoInicial the depositoInicial to set
     */
    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(int dono) {
        this.dono = dono;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
