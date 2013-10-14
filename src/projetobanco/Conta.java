/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

/**
 *
 * @author Codification
 */
public abstract class Conta implements ContaI{

    
double depositoInicial; 
int numero; 
Cliente dono;
double saldo;


   
    @Override
    public Cliente getDono() {
        return this.dono;
    }

    @Override
    public int getNumero() {
       return this.numero;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

 
  
}
