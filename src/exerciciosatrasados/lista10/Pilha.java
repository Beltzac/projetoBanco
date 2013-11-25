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
            anterior = next;
            next = next.getProximo();            
        }
      if (anterior != null){      
      anterior.setProximo(null);
      }
    }

    @Override
    public String toString() {
        String texto = "[ ";
        texto += imprime(n);
        texto += " ]";
        return texto;
    }
    
    String imprime(Nodo n){        
        if(n== null) return ""; 
        String s= String.valueOf(n.getDado());
        if (n.getProximo() != null) 
            s = "," + s;
        return imprime(n.getProximo()) + s;
    }
}
