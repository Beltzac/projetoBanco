/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista11.desafio;

/**
 *
 * @author Codification
 */
class Threads implements Runnable {

    int[][] m1;
    int[][] m2;
    int[][] m3;
    int inicio;
    int tamanho;

    public Threads(int[][] m1, int[][] m2, int[][] m3, int inicio, int tamanho) throws Exception {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.inicio = inicio;
        this.tamanho = tamanho;
    }


    @Override
    public void run() {
         for (int j = 0; j < m1.length; j++) {
            for (int k = inicio; k < inicio + tamanho; k++) {

                for (int l = 0; l < m1[0].length; l++) {
                    m3[j][k] += m1[j][l] * m2[l][k];
                }

            }
        }
    }
}
