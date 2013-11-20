/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista7;

import java.util.Scanner;

/**
 *
 * @author Codification
 */
public class Tarefa6 {

    public static void main(String[] args) {
        String entrada;
        Scanner sc = new Scanner(System.in);
        int soma = 0;
        
        int contador = 0;
        while (true) {
            entrada = sc.next();
            if (entrada.equalsIgnoreCase("s")) {
                break;
            } else {
                try {
                    soma += Integer.valueOf(entrada);                    
                    contador++;
                } catch (Exception ex) {
                    System.out.println("Não é um numérico válido. Tente novamente ou digite S para sair. ");
                    continue;
                }
            }
        }
        
        System.out.println("Média é:" + (double)soma / contador);
    }
}
