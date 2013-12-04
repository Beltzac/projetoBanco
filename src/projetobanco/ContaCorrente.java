package projetobanco;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Codification
 */
public class ContaCorrente extends Conta {

    private double limite;

    @Override
    public boolean deposita(double valor) {
        this.setSaldo(getSaldo() + valor);
        return true;
    }

    @Override
    public boolean saca(double valor) {
        if ((getSaldo() - valor) > 0) {
            this.setSaldo(getSaldo() - valor);
            return true;
        } else {
            JOptionPane.showConfirmDialog(null, "Saldo insulficiente. Ação cancelada.");
        }
        return false;
    }

    @Override
    public void remunera() {
        this.setSaldo(getSaldo() + getDono().getSalario());
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }
}
