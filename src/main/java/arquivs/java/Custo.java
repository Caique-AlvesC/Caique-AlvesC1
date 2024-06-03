/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivs.java;

public class Custo {
    private String nomeCusto;
    private double valorCusto;
    private String descricaoCusto;
    private int IDCUSTO;
    private int User_codUsuario;
    

   
    
public Custo() {
    this.nomeCusto = nomeCusto;
    this.valorCusto = valorCusto;
    this.descricaoCusto = descricaoCusto;
    this.IDCUSTO = IDCUSTO;
    this.User_codUsuario = User_codUsuario;
}    

   Custo(String string, double aDouble, String string0, int aInteger){
       throw new UnsupportedOperationException("Not supported yet.");
   } 
   
   public String getnomeCusto(){
       return nomeCusto;
   }
   
   public double getvalorCusto(){
       return valorCusto;
   }
   
   public String getdescricaoCusto(){
       return descricaoCusto;
   }
   
   public int getIDCUSTO(){
       return IDCUSTO;
   }
   
   public void setnomeCusto(String nomeCusto){
       this.nomeCusto = nomeCusto;
   }
   
   public void setvalorCusto(double valorCusto){
       this.valorCusto = valorCusto;
   }
   
   public void setdescricaoCusto(String descricaoCusto){
       this.descricaoCusto = descricaoCusto;
   }
   
   public void setIDCUSTO(int IDCUSTO){
       this.IDCUSTO = IDCUSTO;
   }
   
    public int getUser_codUsuario() {
        return User_codUsuario;
    }

    public void setUser_codUsuario(int User_codUsuario) {
        this.User_codUsuario = User_codUsuario;
    }
   
   public void add(Custo custo){
       throw new UnsupportedOperationException("Not supported yet.");
   }
   
}
