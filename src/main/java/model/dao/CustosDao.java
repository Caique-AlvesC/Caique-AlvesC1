/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import arquivs.java.Custo;
import arquivs.java.Ingredientes;
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

public class CustosDao {
  public void create(Custo custo) throws SQLException, ClassNotFoundException{
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
      try{
         stmt = con.prepareStatement("INSERT INTO tablecustosfixos (nomeCusto, valorCusto, descricaoCusto, IDCUSTO, User_codUsuario) VALUES (?, ?, ?, ?, ?)");
         stmt.setString(1, custo.getnomeCusto());
         stmt.setDouble(2, custo.getvalorCusto());
         stmt.setString(3, custo.getdescricaoCusto());
         stmt.setInt(4, custo.getIDCUSTO());
         stmt.setInt(5, custo.getUser_codUsuario());
         
         stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Custo adicionado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
 
      }
      
  public List<Custo>listar() throws SQLException, ClassNotFoundException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Custo> custo = new ArrayList<>();
        
        try {
            int codUsuario = Usuario.getInstance().getCodUsuario();
            stmt = con.prepareStatement("SELECT * FROM tablecustosfixos WHERE User_codUsuario = ?");
            stmt.setInt(1, codUsuario);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Custo custos = new Custo();
                custos.setnomeCusto(rs.getString("nomeCusto"));
                custos.setvalorCusto(rs.getDouble("valorCusto"));
                custos.setdescricaoCusto(rs.getString("descricaoCusto"));
                custos.setIDCUSTO(rs.getInt("IDCUSTO"));
                custos.setUser_codUsuario(rs.getInt("User_codUsuario"));
                custo.add(custos);  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return custo;
    }

 public void update(Custo custo) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        
        stmt = con.prepareStatement("UPDATE tablecustosfixos SET nomeCusto = ?, valorCusto = ?, descricaoCusto = ? WHERE IDCUSTO = ? AND User_codUsuario = ?");
        
        stmt.setString(1, custo.getnomeCusto());
        stmt.setDouble(2, custo.getvalorCusto());
        stmt.setString(3, custo.getdescricaoCusto());
        stmt.setInt(4, custo.getIDCUSTO());
        stmt.setInt(5, custo.getUser_codUsuario());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Custo atualizado com sucesso");
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar custo: " + ex);
    } finally {
        
        ConnectionFactory.closeConnection(con, stmt);
    }
}
  
  public void delete(int idCusto) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM tablecustosfixos WHERE IDCUSTO = ?");
        stmt.setInt(1, idCusto);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Custo removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Custo não encontrado");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao remover custo: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
}
  
  }
    

