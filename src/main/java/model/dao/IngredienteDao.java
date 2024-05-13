package model.dao;

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

public class IngredienteDao {
    public void create(Ingredientes ingredientes) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("INSERT INTO tableingrediente (Produto, Preco, Quantidade, Metrica, Descricao, IDIngr, User_codUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, ingredientes.getProduto());
                stmt.setDouble(2, ingredientes.getPreco());
                stmt.setDouble(3, ingredientes.getQuantidade());
                stmt.setString(4, ingredientes.getMetrica());
                stmt.setString(5, ingredientes.getDescricao());
                stmt.setInt(6, ingredientes.getIDIngr());
                stmt.setInt(7, ingredientes.getUser_codUsuario());
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
            int codUsuario = Usuario.getInstance().getCodUsuario();
            stmt = con.prepareStatement("SELECT * FROM tableingrediente WHERE User_codUsuario = ?");
            stmt.setInt(1, codUsuario);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Ingredientes ingredie = new Ingredientes();
                ingredie.setProduto(rs.getString("Produto"));
                ingredie.setPreco(rs.getDouble("Preco"));
                ingredie.setQuantidade(rs.getDouble("Quantidade"));
                ingredie.setMetrica(rs.getString("Metrica"));
                ingredie.setDescricao(rs.getString("Descricao"));
                ingredie.setIDIngr(rs.getInt("IDIngr"));
                ingredie.setUser_codUsuario(rs.getInt("User_codUsuario"));
                ingredientes.add(ingredie);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ingredientes;
    }
   
public List<Ingredientes> fetchAllProducts() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int codUsuario = Usuario.getInstance().getCodUsuario();
        List<Ingredientes> products = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM tableingrediente WHERE User_codUsuario = ?");
            stmt.setInt(1, codUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
               Ingredientes ingrediente = new Ingredientes();
                ingrediente.setProduto(rs.getString("Produto"));
                ingrediente.setPreco(rs.getDouble("Preco"));
                ingrediente.setQuantidade(rs.getDouble("Quantidade"));
                ingrediente.setMetrica(rs.getString("Metrica"));
                ingrediente.setDescricao(rs.getString("Descricao"));
                ingrediente.setIDIngr(rs.getInt("IDIngr"));
                ingrediente.setUser_codUsuario(rs.getInt("User_codUsuario"));
                products.add(ingrediente); 
   
            }
        } catch (SQLException e) {
        }
        return products;
    }
    
    
      public void delete(int IDIngr) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM tableingrediente WHERE IDIngr = ?");
        stmt.setInt(1, IDIngr);

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
    
        public void update(Ingredientes ingredientes) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("UPDATE tableingrediente SET Produto = ?, Preco = ?, Quantidade = ?,Metrica = ?, Descricao = ?  WHERE IDIngr = ? AND User_codUsuario = ?");
                stmt.setString(1, ingredientes.getProduto());
                stmt.setDouble(2, ingredientes.getPreco());
                stmt.setDouble(3, ingredientes.getQuantidade());
                stmt.setString(4, ingredientes.getMetrica());
                stmt.setString(5, ingredientes.getDescricao());
                stmt.setInt(6, ingredientes.getIDIngr());
                stmt.setInt(7, ingredientes.getUser_codUsuario());
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
        
        
        
        
        
        
        
        
        
    
    
    