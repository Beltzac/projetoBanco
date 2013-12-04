/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import javax.swing.JOptionPane;

/**
 *
 * @author Codification
 */
public class ContaInvestimento extends Conta {

    private double montanteMinimo;
    private double depositoMinimo;

    @Override
    public boolean deposita(double valor) {
        if (valor >= depositoMinimo) {
            this.setSaldo(getSaldo() + valor);
            return true;
        }
        return false;

    }

    @Override
    public boolean saca(double valor) {
        if ((getSaldo() - valor) > montanteMinimo) {
            if ((getSaldo() - valor) > 0) {
                this.setSaldo(getSaldo() - valor);
                return true;
            } else {
                JOptionPane.showConfirmDialog(null, "Saldo insulficiente. Ação cancelada.");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Montante Minimo deve ser respeitado. Ação cancelada.");
        }
        return false;
    }

    @Override
    public void remunera() {
          this.setSaldo(getSaldo() + getDono().getSalario());
    }

    /**
     * @return the montanteMinimo
     */
    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    /**
     * @param montanteMinimo the montanteMinimo to set
     */
    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    /**
     * @return the depositoMinimo
     */
    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    /**
     * @param depositoMinimo the depositoMinimo to set
     */
    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }
}
