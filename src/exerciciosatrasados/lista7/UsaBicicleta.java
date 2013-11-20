/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista7;

/**
 *
 * @author Codification
 */
public class UsaBicicleta {
        public static void main(String[] args) {
             Bicicleta bicicleta = null;
            try {
                bicicleta = new Bicicleta(5, 20, 8);
            } catch (Exception ex) {
                System.out.println("Erro ao criar a bicicleta:" + ex.getMessage());
            }        
            
            try {
                bicicleta.aplicarFreios(50); 
                bicicleta.mudarCadencia(-2);           
                bicicleta.mudarMarcha(25);
            } catch (Exception ex) {
                 System.out.println("Erro ao usar a bicicleta:" + ex.getMessage());
            }
           
    }
}
