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
            try {
                Bicicleta bicicleta = new Bicicleta(5, 20, 8);
            } catch (Exception ex) {
                System.out.println("Erro ao criar a bicicleta:" + ex.getMessage());
            }        
    }
}
