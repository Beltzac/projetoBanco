/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista10;

/**
 *
 * @author LAB
 */
public class Nodo<P> {

    private P dado;
    private Nodo n;

    public Nodo(P dado) {
        this.dado = dado;        
    }

    /**
     * @return the dado
     */
    public P getDado() {
        return dado;
    }

    /**
     * @return the n
     */
    public Nodo getProximo() {
        return n;
    }
    
    public void setProximo(Nodo n) {
        this.n = n;
    }
    
    
}
