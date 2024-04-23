package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kaique Alves
 */
public class ConnectionFactory {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/precification";
    private static String USER = "root";
    private static String PASS = "";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        try{
     Class.forName(DRIVER);
     return DriverManager.getConnection(URL, USER, PASS);
    }catch (ClassNotFoundException | SQLException ex){
        throw new RuntimeException("Erro na conexão:",ex);
    }  
    }
  
    public static void closeConnection(Connection con){
            try {
                 if(con!=null){
                con.close();
                 }
                }catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
            try {
                 if(stmt!=null){
                stmt.close();
                 }
                }catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
           try {
                if(rs!=null){
                rs.close();
                 }
                }catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

