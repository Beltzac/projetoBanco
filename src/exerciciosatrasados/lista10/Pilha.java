/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista10;

/**
 *
 * @author Codification
 */
public class Pilha<T> {

    private Nodo n;
 
    public void empilha(T i) throws Exception {

    if (n == null){
        n = new Nodo(i);
    }else{
        Nodo next = n;
        while(next.getProximo() != null){
            next = next.getProximo();
        }
      next.setProximo(new Nodo(i)) ;
    }
   
    }

    public void desempilha() {
    Nodo next = n;
    Nodo anterior = null;
        while(next.getProximo() != null){
            next = next.getProximo();
            anterior = next;
        }
      if (anterior != null){
      anterior.setProximo(null);
      }
    }

    @Override
    public String toString() {
        String texto = "[ ";

        texto += imprime(texto, n);

        texto += " ]";

        return texto;

    }
    
    String imprime(String s, Nodo n){        
        if(n!= null){
        s += n.getDado()+" ";
        imprime(s, n);
        }
        
        return null;        
    }
}
