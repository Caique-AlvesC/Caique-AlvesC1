/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import arquivs.java.Receita;
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
public class ReceitaDao {
    
    public void create(Receita receita) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            try{
                stmt = con.prepareStatement("INSERT INTO tablereceitas (cod_Receita, Custo_total_ingredie, tempo_Gasto, mod_tempo, salario_aReceber, a13_ferias, custo_Fixo, TotalAntsLucro, margem_Lucro, receber_Lucro, receber_Total, User_codUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
                stmt.setString(1, receita.getCod_Receita());
                stmt.setDouble(2, receita.getCusto_total_ingredie());
                stmt.setInt(3, receita.getTempo_Gasto());
                stmt.setString(4, receita.getMod_tempo());
                stmt.setDouble(5, receita.getSalario_aReceber());
                stmt.setDouble(6, receita.getA13_ferias());
                stmt.setDouble(7, receita.getCusto_Fixo());
                stmt.setDouble(8, receita.getTotalAntsLucro());
                stmt.setDouble(9, receita.getMargem_Lucro());
                stmt.setDouble(10, receita.getReceber_Lucro());
                stmt.setDouble(11, receita.getReceber_Total());
                stmt.setInt(12, receita.getUser_codUsuario());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Receita criada com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao salvar Receita" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
   
         }
    
    public List<Receita>listar() throws SQLException, ClassNotFoundException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Receita> receita = new ArrayList<>();
        
        try {
            int codUsuario = Usuario.getInstance().getCodUsuario();
            stmt = con.prepareStatement("SELECT * FROM tablereceitas WHERE User_codUsuario = ?");
            stmt.setInt(1, codUsuario);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Receita receit = new Receita();
                receit.setCod_Receita(rs.getString("Cod_Receita"));
                receit.setReceber_Total(rs.getDouble("receber_Total"));
                receit.setCusto_total_ingredie(rs.getDouble("Custo_total_ingredie"));
                receit.setReceber_Lucro(rs.getDouble("receber_Lucro"));
                receit.setCod_receita2(rs.getInt("cod_receita2"));
                receita.add(receit);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return receita;
    }
    
     public void delete(int cod_receita2) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM tablereceitas WHERE cod_receita2 = ?");
        stmt.setInt(1, cod_receita2);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Ingrediente removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrediente não encontrado");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao remover receitnte: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}
    
        public void update(Receita receita) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("UPDATE tablereceitas SET cod_Receita = ?, Custo_total_ingredie = ?, tempo_Gasto = ?,mod_tempo = ?, salario_aReceber = ?, a13_ferias = ?, custo_Fixo = ?, margem_Lucro = ?, receber_Lucro = ?, receber_Total = ?,   WHERE cod_receita2 = ? AND User_codUsuario = ?");
                stmt.setString(1, receita.getCod_Receita());
                stmt.setDouble(2, receita.getCusto_total_ingredie());
                stmt.setInt(3, receita.getTempo_Gasto());
                stmt.setString(4, receita.getMod_tempo());
                stmt.setDouble(5, receita.getSalario_aReceber());
                stmt.setDouble(6, receita.getA13_ferias());
                stmt.setDouble(7, receita.getCusto_Fixo());
                stmt.setDouble(8, receita.getTotalAntsLucro());
                stmt.setDouble(9, receita.getMargem_Lucro());
                stmt.setDouble(10, receita.getReceber_Lucro());
                stmt.setDouble(11, receita.getReceber_Total());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"produto atualizado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao atualizar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    
         }
    
public Receita fetchAllProducts(int cod_receita2) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codUsuario = Usuario.getInstance().getCodUsuario();
        Receita receita = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM tablereceita WHERE User_codUsuario = ? and cod_receita2 = ?");
            stmt.setInt(1, codUsuario);
             stmt.setInt(2,cod_receita2);
            rs = stmt.executeQuery();
            while (rs.next()) {
               receita = new Receita();
                receita.setCod_Receita(rs.getString("cod_Receita"));
                receita.setTempo_Gasto(rs.getInt("tempo_Gasto"));
                receita.setMod_tempo(rs.getString("mod_tempo"));
                receita.setMargem_Lucro(rs.getDouble("margem_Lucro"));
                receita.setUser_codUsuario(rs.getInt("User_codUsuario"));
                receita.setCod_receita2(rs.getInt("cod_receita2"));
                                 
            }
        } catch (SQLException e) {
        }
        return receita;
    }

     
    
    
    
}
