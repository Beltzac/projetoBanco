/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista11;

/**
 *
 * @author Codification
 */
public class Threads {
    
   public static void main(String[] args){ 
    new Thread(new Contador(10, "A")).start();
    new Thread(new Contador(20, "B")).start();
   } 
}
