/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import arquivs.java.Usuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao {
public boolean checkLogin(String login ,String senha) throws SQLException, ClassNotFoundException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1,login);
            stmt.setString(2,senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("Id"));
                user.setLogin(rs.getString("Login"));
                user.setSenha(rs.getString("Senha"));
                check = true; 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }

    public void cadastrar(Usuario usuario) throws SQLException, ClassNotFoundException {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("INSERT INTO usuario (login, senha)VALUES (?,?)");
                stmt.setString(1, usuario.getLogin());
                stmt.setString(2, usuario.getSenha());
           stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
    
    
         }




}
