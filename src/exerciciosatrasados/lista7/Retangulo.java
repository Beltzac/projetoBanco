/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciosatrasados.lista7;

/**
 *
 * @author Codification
 */
class Retangulo {
    private int altura;
    private int largura;

    int area() {
        return getAltura() * getLargura();
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) throws Exception {
        if (altura < 0 )
            throw new Exception("Altura não pode ser negativa");
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) throws Exception {
                if (largura < 0 )
            throw new Exception("Largura não pode ser negativa");
        this.largura = largura;
    }
    
}
