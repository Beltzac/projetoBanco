/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista7;

/**
 *
 * @author Codification
 */
public class UsaRetangulo {

    public static void main(String[] args) {
        Retangulo meuRetangulo = new Retangulo();
        try {
            meuRetangulo.setAltura(-1);
            meuRetangulo.setLargura(50);
            System.out.println("A area do meu retângulo é = " + meuRetangulo.area());
        } catch (Exception ex) {
            System.out.println("Erro ao criar o retângulo:" + ex.getMessage());
        }       
    }
}