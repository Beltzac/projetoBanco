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

    Object[] dados;
    int ponteiro = 0;
    int tamanho;

    public Pilha(int tamanho) {
        this.dados = new Object[tamanho];
        this.tamanho = tamanho;
    }

    public Pilha() {
        this(100);
    }

    public void empilha(T i) throws Exception {
        if (ponteiro < tamanho) {
            dados[ponteiro] = i;
            ponteiro++;
        } else {
            throw new Exception("Estouro de pilha");
        }
    }

    public void desempilha() {
        if (ponteiro > 0) {
            ponteiro--;
        }
    }

    @Override
    public String toString() {
        String texto = "[ ";

        for (int i = 0; i < ponteiro; i++) {
            texto += dados[i];
            if (i != ponteiro - 1) {
                texto += " , ";
            }
        }

        texto += " ]";

        return texto;

    }
}
