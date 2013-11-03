/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;


/**
 *
 * @author Codification
 */
public class Cliente implements Comparable{
    private int codigo;
    private String Nome;
    private String sobrenome;
    private String RG;
    private String CPF;
    private String Endereco;
    private double salario;

   
            

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


    @Override
    public int compareTo(Object o) {
        Cliente c = (Cliente) o;
       return  (int) (c.getSalario() - this.getSalario());
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
   
}
