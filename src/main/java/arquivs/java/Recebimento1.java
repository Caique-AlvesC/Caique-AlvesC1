package arquivs.java;

public class Recebimento1 {

    private double salario;
    private double decimoTerceiro;
    private double ferias;
    private double horasTrabalhadas;
    private double horasTotais;
    private double valorHora;
    private double valorMinuto;
    private double valorHoraD;
    private double valorMinutoD;
    private double valorHoraF;
    private double valorMinutoF;
    
    
    private int IDReb;
    private int User_codUsuario;
    
    public Recebimento1(){
        this.salario = salario;
        this.decimoTerceiro = decimoTerceiro;
        this.ferias = ferias;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasTotais = horasTotais;
        this.valorHora = CalcValorHora();
        this.valorMinuto = CalcValorMinuto();
        this.valorHoraD = CalcValorHoraD();
        this.valorMinutoD = CalcValorMinutoD();
        this.valorHoraF = CalcValorHoraF();
        this.valorMinutoF = CalcValorMinutoF();
        this.IDReb = IDReb;
        this.User_codUsuario = User_codUsuario;
    }

    
    
    public double CalcValorHora(){
        if (horasTotais ==0)return 0;
        return salario /horasTotais; 
    }
    
    public double CalcValorMinuto(){
        if (horasTotais ==0)return 0;
        return valorHora /60; 
    }
    
    public double CalcValorHoraD(){
        if (horasTotais ==0)return 0;
        return decimoTerceiro /(horasTotais*11); 
    }
    
    public double CalcValorMinutoD(){
        if (horasTotais ==0)return 0;
        return valorHoraD /60; 
    }    
    
     public double CalcValorHoraF(){
        if (horasTotais ==0)return 0;
        return ferias /(horasTotais*11); 
    }
    
    public double CalcValorMinutoF(){
        if (horasTotais ==0)return 0;
        return valorHoraF /60; 
    }   
//----------------------------------------------
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
        this.valorHora = CalcValorHora();
        this.valorMinuto = CalcValorMinuto();
    }

    public double getDecimoTerceiro() {
        return decimoTerceiro;
    }

    public void setDecimoTerceiro(double decimoTerceiro) {
        this.decimoTerceiro = decimoTerceiro;
        this.valorHoraD = CalcValorHoraD();
        this.valorMinutoD = CalcValorMinutoD();    
        
    }

    public double getFerias() {
        return ferias;
    }

    public void setFerias(double ferias) {
        this.ferias = ferias;
        this.valorHoraF = CalcValorHoraF();
        this.valorMinutoF = CalcValorMinutoF();        
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(double horasTotais) {
        this.horasTotais = horasTotais;
        this.valorHora = CalcValorHora();
        this.valorMinuto = CalcValorMinuto();
        this.valorHoraD = CalcValorHoraD();
        this.valorMinutoD = CalcValorMinutoD();
        this.valorHoraF = CalcValorHoraF();
        this.valorMinutoF = CalcValorMinutoF();   
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public double getValorHoraD() {
        return valorHoraD;
    }

    public void setValorHoraD(double valorHoraD) {
        this.valorHoraD = valorHoraD;
    }

    public double getValorMinutoD() {
        return valorMinutoD;
    }

    public void setValorMinutoD(double valorMinutoD) {
        this.valorMinutoD = valorMinutoD;
    }

    public double getValorHoraF() {
        return valorHoraF;
    }

    public void setValorHoraF(double valorHoraF) {
        this.valorHoraF = valorHoraF;
    }

    public double getValorMinutoF() {
        return valorMinutoF;
    }

    public void setValorMinutoF(double valorMinutoF) {
        this.valorMinutoF = valorMinutoF;
    }

    public int getIDReb() {
        return IDReb;
    }

    public void setIDReb(int IDReb) {
        this.IDReb = IDReb;
    }

    public int getUser_codUsuario() {
        return User_codUsuario;
    }

    public void setUser_codUsuario(int User_codUsuario) {
        this.User_codUsuario = User_codUsuario;
    }
    
    
    
    
    
    
    
    
}
  
    
