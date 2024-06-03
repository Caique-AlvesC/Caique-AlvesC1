
package arquivs.java;

public class Receita {
    private String cod_Receita; 
    private double Custo_total_ingredie;
    private int tempo_Gasto;
    private String mod_tempo;
    private double salario_aReceber;
    private double a13_ferias;
    private double custo_Fixo;
    private double totalAntsLucro;

    public double getTotalAntsLucro() {
        return totalAntsLucro;
    }

    public void setTotalAntsLucro(double totalAntsLucro) {
        this.totalAntsLucro = totalAntsLucro;
    }
    private double margem_Lucro;
    private double receber_Lucro;
    private double receber_Total;
    private int User_codUsuario;
    private int cod_receita2;

    public String getCod_Receita() {
        return cod_Receita;
    }

    public void setCod_Receita(String cod_Receita) {
        this.cod_Receita = cod_Receita;
    }

    public double getCusto_total_ingredie() {
        return Custo_total_ingredie;
    }

    public void setCusto_total_ingredie(double Custo_total_ingredie) {
        this.Custo_total_ingredie = Custo_total_ingredie;
    }

    public int getTempo_Gasto() {
        return tempo_Gasto;
    }

    public void setTempo_Gasto(int tempo_Gasto) {
        this.tempo_Gasto = tempo_Gasto;
    }

    public String getMod_tempo() {
        return mod_tempo;
    }

    public void setMod_tempo(String mod_tempo) {
        this.mod_tempo = mod_tempo;
    }

    public double getSalario_aReceber() {
        return salario_aReceber;
    }

    public void setSalario_aReceber(double salario_aReceber) {
        this.salario_aReceber = salario_aReceber;
    }

    public double getA13_ferias() {
        return a13_ferias;
    }

    public void setA13_ferias(double a13_ferias) {
        this.a13_ferias = a13_ferias;
    }

    public double getCusto_Fixo() {
        return custo_Fixo;
    }

    public void setCusto_Fixo(double custo_Fixo) {
        this.custo_Fixo = custo_Fixo;
    }

    public double getMargem_Lucro() {
        return margem_Lucro;
    }

    public void setMargem_Lucro(double margem_Lucro) {
        this.margem_Lucro = margem_Lucro;
    }

    public double getReceber_Lucro() {
        return receber_Lucro;
    }

    public void setReceber_Lucro(double receber_Lucro) {
        this.receber_Lucro = receber_Lucro;
    }

    public double getReceber_Total() {
        return receber_Total;
    }

    public void setReceber_Total(double receber_Total) {
        this.receber_Total = receber_Total;
    }

    public int getUser_codUsuario() {
        return User_codUsuario;
    }

    public void setUser_codUsuario(int User_codUsuario) {
        this.User_codUsuario = User_codUsuario;
    }

    public int getCod_receita2() {
        return cod_receita2;
    }

    public void setCod_receita2(int cod_receita2) {
        this.cod_receita2 = cod_receita2;
    }
  


public Receita(){
this.cod_Receita = cod_Receita;
this.Custo_total_ingredie = Custo_total_ingredie;
this.tempo_Gasto = tempo_Gasto;
this.mod_tempo = mod_tempo;
this.salario_aReceber = salario_aReceber;
this.a13_ferias = a13_ferias;
this.custo_Fixo = custo_Fixo;
this.margem_Lucro = margem_Lucro;
this.receber_Lucro = receber_Lucro;
this.receber_Total = receber_Total;
this.User_codUsuario =User_codUsuario;
this.cod_receita2 = cod_receita2;
this.totalAntsLucro = totalAntsLucro;
}
}
