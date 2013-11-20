/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista11;

/**
 *
 * @author Codification
 */
class Contador implements Runnable {

    int contador;
    String nome;

    public Contador(int i, String nome) {
        contador = i;
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 0; i <= contador; i++) {
            System.out.println(nome + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
