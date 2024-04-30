
package arquivs.java;

public class Ingredientes {
    private String produto;
    private double preco;
    private double quantidade;
    private String metrica;
    private String descricao;
    private int IDIngr;
    private int User_codUsuario;	
   
public Ingredientes(){
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.metrica = metrica;
        this.descricao = descricao;
        this.IDIngr = IDIngr;
        this.User_codUsuario = User_codUsuario;
        
}

    public int getIDIngr() {
        return IDIngr;
    }

    public void setIDIngr(int IDIngr) {
        this.IDIngr = IDIngr;
    }

    public int getUser_codUsuario() {
        return User_codUsuario;
    }

    public void setUser_codUsuario(int User_codUsuario) {
        this.User_codUsuario = User_codUsuario;
    }

    Ingredientes(String string, double aDouble, double aDouble0, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//Getters
public String getProduto(){
        return produto;
}
public double getPreco(){
        return preco;
}
public double getQuantidade(){
        return quantidade;
}
public String getMetrica(){
        return metrica;
}
public String getDescricao(){
        return descricao;
}

//Setters
public void setProduto(String produto){
    this.produto = produto;
}
public void setPreco(double preco){
    this.preco = preco;
}
public void setQuantidade(double quantidade){
    this.quantidade = quantidade;
}
public void setMetrica(String metrica){
    this.metrica = metrica;
}
public void setDescricao(String descricao){
    this.descricao = descricao;
}

    public void add(Ingredientes ingredientes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //---------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
}
