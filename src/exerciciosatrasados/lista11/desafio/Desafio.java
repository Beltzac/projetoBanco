/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista11.desafio;

import java.util.ArrayList;

/**
 *
 * @author Codification
 */
public class Desafio {

    public static void main(String[] args) throws Exception {

        int[][] m1 = preenche(1500, 1500);
        int[][] m2 = preenche(1500, 1500);
        //print(m1);
        System.out.println("");
        timer.inicia();
        int[][] m3 = multiplicaSequencial(m1, m2, 1);
        timer.para("Sequencial");
        //print(m3);


        for (int i = 1; i <= 24; i++) {
            timer.inicia();
            m3 = multiplica(m1, m2, i);
            timer.para("Multithread " + i);
        }

    }

    private static int[][] multiplicaSequencial(int[][] m1, int[][] m2, int i) throws Exception {

        if (m1.length != m2[0].length) {
            throw new Exception("tamanhos incompativeis");
        }

        int[][] m3 = new int[m1.length][m2[0].length];

        for (int j = 0; j < m1.length; j++) {
            for (int k = 0; k < m2[0].length; k++) {

                for (int l = 0; l < m1[0].length; l++) {
                    m3[j][k] += m1[j][l] * m2[l][k];
                }


            }
        }


        return m3;
    }

    private static int[][] preenche(int x, int y) {
        int[][] m1 = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                m1[i][j] = i + j;
            }
        }
        return m1;
    }

    private static void print(int[][] m3) {
        for (int j = 0; j < m3.length; j++) {
            for (int k = 0; k < m3[0].length; k++) {
                System.out.print(m3[j][k] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] multiplica(int[][] m1, int[][] m2, int i) throws Exception {
        ArrayList<Thread> t = new ArrayList<>();

        if (m1.length != m2[0].length) {
            throw new Exception("tamanhos incompativeis");
        }

        int[][] m3 = new int[m1.length][m2[0].length];

        int inicio = 0;
        int tamanho = m2[0].length / i;

        for (int j = 0; j < i; j++) {

            if (j < i - 1) {
                t.add(new Thread(new Threads(m1, m2, m3, inicio, tamanho)));
            } else {
                t.add(new Thread(new Threads(m1, m2, m3, inicio, tamanho + m2[0].length % i)));
            }
            inicio += tamanho;
        }

        for (Thread a : t) {
            a.start();
        }

        for (Thread a : t) {
            a.join();
        }


        return m3;

    }

    private static class timer {

        static long ini = 0;

        private static void inicia() {
            ini = System.nanoTime();
        }

        private static void para(String t) {
            System.out.println("Thread " + t + " , " + nanoToString(System.nanoTime() - ini));
            ini = 0;
        }

        private static String nanoToString(long tempo) {
            return String.valueOf(tempo / 1000000000.0);
        }
    }
}
