/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista7;

/**
 *
 * @author Codification
 */
class Bicicleta {

    int cadencia = 0;
    int velocidade = 0;
    int marcha = 1;

    public Bicicleta(int cadencia, int velocidade, int marcha) throws Exception {
        mudarMarcha(marcha);
        mudarCadencia(cadencia);
        setVelocidade(velocidade);

    }

    void mudarCadencia(int novoValor) throws Exception {
        if (novoValor < 0) {
            throw new Exception("Cadência não pode ser negativa");
        } else {
            cadencia = novoValor;
        }
    }

    void mudarMarcha(int novoValor) throws Exception {
        if (novoValor < 0) {
            throw new Exception("Marcha não pode ser negativa");
        } else if (novoValor > 24) {
            throw new Exception("Marcha não pode pode ultrapassar 24");
        } else {
            marcha = novoValor;
        }
    }

    private void setVelocidade(int v) throws Exception {
        if (v > 100) {
            throw new Exception("Velocidade não pode ultapassar 100 km/h");
        } else if (v < 0) {
            throw new Exception("Velocidade não pode ser negativa");
        } else {
            velocidade = v;
        }
    }

    void aumentarVelocidade(int incremento) throws Exception {
        setVelocidade(velocidade + incremento);
    }

    void aplicarFreios(int decremento) throws Exception {
        setVelocidade(velocidade - decremento);
    }

    void printStates() {
        System.out.println("cadencia=" + cadencia + " velocidade=" + velocidade + "marcha=" + marcha);
    }
}