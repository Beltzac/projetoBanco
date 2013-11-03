/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

/**
 *
 * @author Codification
 */
public class ContaInvestimento extends Conta{
private double montanteMinimo;
private double depositoMinimo;
    @Override
    public boolean deposita(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saca(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remunera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
