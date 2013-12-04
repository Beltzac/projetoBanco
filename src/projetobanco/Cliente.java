/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

/**
 *
 * @author Codification
 */
public class Cliente implements Comparable<Cliente> {

    private int codigo;
    private String Nome;
    private String sobrenome;
    private String RG;
    private String CPF;
    private String Endereco;
    private double salario;

    // Which field should be considered for sorting
    public enum campoOrdenacao {

        nome, sobrenome, salario
    }

    // Sorting direction ASCENDING or DESCENDING
    public enum direcaoOrdenacao {

        ASCENDING, DESCENDING
    }
    // default sorting would be ascending
    public static campoOrdenacao CAMPO_ORDENACAO = campoOrdenacao.nome;
    // default sorting would be on name
    public static direcaoOrdenacao DIRECAO_ORDENACAO = direcaoOrdenacao.ASCENDING;

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the Endereço
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereço the Endereço to set
     */
    public void setEndereco(String Endereço) {
        this.Endereco = Endereço;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Cliente o) {
        if (CAMPO_ORDENACAO == campoOrdenacao.nome) {
            if (DIRECAO_ORDENACAO == direcaoOrdenacao.ASCENDING) {
                return this.Nome.compareTo(o.Nome);
            } else {
                return o.Nome.compareTo(this.Nome);
            }

        } else if (CAMPO_ORDENACAO == campoOrdenacao.sobrenome) {
            if (DIRECAO_ORDENACAO == direcaoOrdenacao.ASCENDING) {
                return this.sobrenome.compareTo(o.sobrenome);
            } else {
                return o.sobrenome.compareTo(this.sobrenome);
            }
        } else if (CAMPO_ORDENACAO == campoOrdenacao.salario) {
            if (DIRECAO_ORDENACAO == direcaoOrdenacao.ASCENDING) {
                return (int) (this.salario - o.salario);
            } else {
                return (int) (o.salario - this.salario);
            }
        }

        return 0;
    }
}
