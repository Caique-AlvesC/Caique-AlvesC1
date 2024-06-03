/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import arquivs.java.IngredientesUse;
import arquivs.java.Recebimento1;
import arquivs.java.Usuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaique Alves
 */
public class IngredienteUseDao {
        public void createUse(IngredientesUse ingredientesUse) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("INSERT INTO tableingredientesrec (nomeIngrediente,IngredietCustoAtual, quantidadeAtual, metricaUsoAtual,idIngUsado, IDIngr, User_codUsuario, cod_Receita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, ingredientesUse.getNomeIngrediente());
                stmt.setDouble(2, ingredientesUse.getIngredietCustoAtual());
                stmt.setDouble(3, ingredientesUse.getQuantidadeAtual());
                stmt.setString(4, ingredientesUse.getMetricaUsoAtual());
                stmt.setInt(5, ingredientesUse.getIdIngUsado());
                stmt.setInt(6, ingredientesUse.getIDIngr());
                stmt.setInt(7, ingredientesUse.getUser_codUsuario());
                stmt.setString(8, ingredientesUse.getCod_Receita());
                
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"produto adicionado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
}
        public List<IngredientesUse>listar(String cod_Receita) throws SQLException, ClassNotFoundException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<IngredientesUse> ingredientesUse = new ArrayList<>();
        
        try {
            int codUsuario = Usuario.getInstance().getCodUsuario();
            stmt = con.prepareStatement("SELECT * FROM tableingredientesrec WHERE User_codUsuario = ? and cod_Receita = ?");
            stmt.setInt(1, codUsuario);
            stmt.setString(2,cod_Receita);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                IngredientesUse ingredieUse = new IngredientesUse();
                ingredieUse.setNomeIngrediente(rs.getString("nomeIngrediente"));
                ingredieUse.setQuantidadeAtual(rs.getDouble("quantidadeAtual"));
                ingredieUse.setMetricaUsoAtual(rs.getString("metricaUsoAtual"));
                ingredieUse.setIngredietCustoAtual(rs.getDouble("IngredietCustoAtual"));
                ingredieUse.setIdIngUsado(rs.getInt("idIngUsado"));
                ingredieUse.setIDIngr(rs.getInt("IDIngr"));
                ingredieUse.setUser_codUsuario(rs.getInt("User_codUsuario"));
                ingredieUse.setCod_Receita(rs.getString("cod_Receita"));
                ingredientesUse.add(ingredieUse);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ingredientesUse;
    }
        
     public double listarSoma(String cod_Receita) throws ClassNotFoundException, SQLException {
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double totalCusto = 0;
        
        try {
        int codUsuario = Usuario.getInstance().getCodUsuario();
        stmt = con.prepareStatement("SELECT SUM(IngredietCustoAtual) AS TotalCusto FROM tableingredientesrec WHERE User_codUsuario = ? AND cod_Receita = ?");
        stmt.setInt(1, codUsuario);
        stmt.setString(2, cod_Receita);
        rs = stmt.executeQuery();

        
        if (rs.next()) {
            totalCusto = rs.getDouble("TotalCusto"); 
        }}catch (SQLException ex) {
        throw ex;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return totalCusto;
     }
     
    public List<Recebimento1> calculoHorasxMinutos() throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Recebimento1> recebimentos = new ArrayList<>();
    try {
        int codUsuario = Usuario.getInstance().getCodUsuario();
        stmt = con.prepareStatement("SELECT * FROM tablerecebimentos WHERE User_codUsuario = ?");
        stmt.setInt(1, codUsuario);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Recebimento1 recebimentos1 = new Recebimento1();
            recebimentos1.setValorHora(rs.getDouble("valorHora"));
            recebimentos1.setValorMinuto(rs.getDouble("valorMinuto"));
            recebimentos1.setValorHoraD(rs.getDouble("valorHoraD"));
            recebimentos1.setValorMinutoD(rs.getDouble("valorMinutoD"));
            recebimentos1.setValorHoraF(rs.getDouble("valorHoraF"));
            recebimentos1.setValorMinutoF(rs.getDouble("valorMinutoF"));
            recebimentos1.setCustoFixoH(rs.getDouble("custoFixoH"));
            recebimentos1.setCustoFixoM(rs.getDouble("custoFixoM"));
            recebimentos1.setUser_codUsuario(rs.getInt("User_codUsuario"));
            recebimentos.add(recebimentos1);

            // Adicionando logs para depuração
            System.out.println("Valor Hora: " + rs.getDouble("valorHora"));
            System.out.println("Custo Fixo Hora: " + rs.getDouble("custoFixoH"));
            System.out.println("Custo Fixo Minuto: " + rs.getDouble("custoFixoM"));
        }

        return recebimentos;

    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
}
    
    
   public void delete(int IdIngUsado) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM tableingredientesrec WHERE IdIngUsado = ?");
        stmt.setInt(1, IdIngUsado);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Ingrediente removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrediente não encontrado");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao remover ingrediente: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}
    
        public void update(IngredientesUse ingredientesUse) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("UPDATE tableingredientesrec SET nomeIngrediente = ?, IngredietCustoAtual = ?, quantidadeAtual = ?,metricaUsoAtual = ?, IDIngr = ?  WHERE IdIngUsado = ? AND User_codUsuario = ? AND cod_Receita = ?");
                stmt.setString(1, ingredientesUse.getNomeIngrediente());
                stmt.setDouble(2, ingredientesUse.getIngredietCustoAtual());
                stmt.setDouble(3, ingredientesUse.getQuantidadeAtual());
                stmt.setString(4, ingredientesUse.getMetricaUsoAtual());
                stmt.setInt(5, ingredientesUse.getIDIngr());
                stmt.setInt(6, ingredientesUse.getIdIngUsado());
                stmt.setInt(7, ingredientesUse.getUser_codUsuario());
                stmt.setString(8, ingredientesUse.getCod_Receita());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"produto atualizado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao atualizar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    
         }  
    
}
