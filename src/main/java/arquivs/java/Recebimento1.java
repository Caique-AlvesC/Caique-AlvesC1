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
    private double custoFixo;
    private double custoFixoH;
    private double custoFixoM;
    private int IDReb;
    private int User_codUsuario;
    
    
    

    public Recebimento1() {
    
    }


    public double CalcValorCustoFixoH() {
        if (horasTrabalhadas == 0) return 0;
        return custoFixo / horasTrabalhadas;
    }

    public double CalcValorCustoFixoM() {
        if (horasTrabalhadas == 0) return 0;
        return CalcValorCustoFixoH() / 60;
    }

    public double CalcValorHora() {
        if (horasTrabalhadas == 0) return 0;
        return salario / horasTrabalhadas;
    }

    public double CalcValorMinuto() {
        if (horasTrabalhadas == 0) return 0;
        return CalcValorHora() / 60;
    }

    public double CalcValorHoraD() {
        if (horasTrabalhadas == 0) return 0;
        return decimoTerceiro / (horasTrabalhadas * 11);
    }

    public double CalcValorMinutoD() {
        if (horasTrabalhadas == 0) return 0;
        return CalcValorHoraD() / 60;
    }

    public double CalcValorHoraF() {
        if (horasTotais == 0) return 0;
        return ferias / (horasTrabalhadas * 11);
    }

    public double CalcValorMinutoF() {
        if (horasTotais == 0) return 0;
        return CalcValorHoraF() / 60;
    }

    // Getters e setters para os outros campos
    

    public void setSalario(double salario) {
        this.salario = salario;
        this.valorHora = CalcValorHora();
        this.valorMinuto = CalcValorMinuto();
    }

    

    public void setDecimoTerceiro(double decimoTerceiro) {
        this.decimoTerceiro = decimoTerceiro;
        this.valorHoraD = CalcValorHoraD();
        this.valorMinutoD = CalcValorMinutoD();
    }

    

    public void setFerias(double ferias) {
        this.ferias = ferias;
        this.valorHoraF = CalcValorHoraF();
        this.valorMinutoF = CalcValorMinutoF();
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
        this.custoFixo = custoFixo;
        this.custoFixoH = CalcValorCustoFixoH();
        this.custoFixoM = CalcValorCustoFixoM();
    }

    
    public double getSalario() {
        return salario;
    }
  
    public double getFerias() {
        return ferias;
    }
    
    
    public double getDecimoTerceiro() {
        return decimoTerceiro;
    }
    
    public double getCustoFixo() {
        return custoFixo;
    }
    public void setCustoFixo(double custoFixo) {
        this.custoFixo = custoFixo;
    }
   
    public double getCustoFixoH() {
        return custoFixoH;
    }

    public void setCustoFixoH(double custoFixoH) {
        this.custoFixoH = custoFixoH;
    }    
    
    public double getCustoFixoM() {
        return custoFixoM;
    }
    public void setCustoFixoM(double custoFixoM) {
       this.custoFixoM = custoFixoM; 
    }
    
    
    
// carga horaria de produção    
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    
    //salario hora gett e sett.
    
    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

// salario minuto sett e gett.    
    
    public double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    
    // get e setts horas decimo 
    public double getValorHoraD() {
        return valorHoraD;
    }

    public void setValorHoraD(double valorHoraD) {
        this.valorHoraD = valorHoraD;
    }

    
    //getter e setter minutos decimo
    public double getValorMinutoD() {
        return valorMinutoD;
    }

    public void setValorMinutoD(double valorMinutoD) {
        this.valorMinutoD = valorMinutoD;
    }

    
    
    
    // getter e setter horas ferias 
    public double getValorHoraF() {
        return valorHoraF;
    }

    public void setValorHoraF(double valorHoraF) {
        this.valorHoraF = valorHoraF;
    }

    

// get e set minutos ferias 

public double getValorMinutoF() {
        return valorMinutoF;
    }
    
      public void setValorMinutoF(double valorMinutoF) {
        this.valorMinutoF = valorMinutoF;
    }  
    
    
// Id recebimento

    public int getIDReb() {
        return IDReb;
    }

    public void setIDReb(int IDReb) {
        this.IDReb = IDReb;
    }

    // usuario 
     public int getUser_codUsuario() {
        return User_codUsuario;
    }

    public void setUser_codUsuario(int User_codUsuario) {
        this.User_codUsuario = User_codUsuario;
    }   
    
    
    
    
    
    
    
    
    
}
    
