/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import arquivs.java.Custo;
import com.mycompany.precification.Ingredientes;
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
         stmt = con.prepareStatement("INSERT INTO tablecustosfixos (nomeCusto, valorCusto, descricaoCusto, IDCUSTO) VALUES (?, ?, ?, ?)");
         stmt.setString(1, custo.getnomeCusto());
         stmt.setDouble(2, custo.getvalorCusto());
         stmt.setString(3, custo.getdescricaoCusto());
         stmt.setInt(4, custo.getIDCUSTO());
         
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
            stmt = con.prepareStatement("SELECT * FROM tablecustosfixos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Custo custos = new Custo();
                custos.setnomeCusto(rs.getString("nomeCusto"));
                custos.setvalorCusto(rs.getDouble("valorCusto"));
                custos.setdescricaoCusto(rs.getString("descricaoCusto"));
                custos.setIDCUSTO(rs.getInt("IDCUSTO"));
                custo.add(custos);  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return custo;
    }

  }
    

