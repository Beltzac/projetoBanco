/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

/**
 *
 * @author Codification
 */
public interface ContaI {

    public boolean deposita(double valor);

    public boolean saca(double valor);

    public Cliente getDono();

    public int getNumero();

    public double getSaldo();

    public void remunera();
}
