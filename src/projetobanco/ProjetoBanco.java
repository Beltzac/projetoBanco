/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

/**
 *
 * @author Codification
 */
public class ProjetoBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Config.load();
        new TelaCliente().setVisible(true);
    }
}
