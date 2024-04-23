package model.dao;

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

public class IngredienteDao {
    public void create(Ingredientes ingredientes) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("INSERT INTO tableingrediente (Produto, Preco, Quantidade, Metrica, Descricao) VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, ingredientes.getProduto());
                stmt.setDouble(2, ingredientes.getPreco());
                stmt.setDouble(3, ingredientes.getQuantidade());
                stmt.setString(4, ingredientes.getMetrica());
                stmt.setString(5, ingredientes.getDescricao());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"produto adicionado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    
         }

    public List<Ingredientes>listar() throws SQLException, ClassNotFoundException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ingredientes> ingredientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tableingrediente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Ingredientes ingredie = new Ingredientes();
                ingredie.setProduto(rs.getString("Produto"));
                ingredie.setPreco(rs.getDouble("Preco"));
                ingredie.setQuantidade(rs.getDouble("Quantidade"));
                ingredie.setMetrica(rs.getString("Metrica"));
                ingredie.setDescricao(rs.getString("Descricao"));
                ingredientes.add(ingredie);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ingredientes;
    }
   
    public List<String> fetchAllProducts() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> products = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM tableingrediente");
            rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(rs.getString("Produto"));
            }
        } catch (SQLException e) {
        }
        return products;
    }
    
    
    
    
    
    
    }