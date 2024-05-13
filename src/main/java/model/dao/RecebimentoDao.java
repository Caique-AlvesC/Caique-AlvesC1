package model.dao;

import arquivs.java.Recebimento1;
import arquivs.java.Usuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RecebimentoDao {
    public void create (Recebimento1 recebimento1) throws SQLException, ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(
    "INSERT INTO tablerecebimentos (salario, decimoTerceiro, ferias, horasTrabalhadas, horasTotais, valorHora, valorMinuto, valorHoraD, valorMinutoD, valorHoraF, valorMinutoF, IDReb, User_codUsuario) " +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
    "ON DUPLICATE KEY UPDATE " +
    "salario = VALUES(salario), " +
    "decimoTerceiro = VALUES(decimoTerceiro), " +
    "ferias = VALUES(ferias), " +
    "horasTrabalhadas = VALUES(horasTrabalhadas), " +
    "horasTotais = VALUES(horasTotais), "+
    "valorHora = VALUES (valorHora), "+       
    "valorMinuto = VALUES (valorMinuto), "+         
    "valorHoraD = VALUES (valorHoraD), "+         
    "valorMinutoD = VALUES (valorMinutoD), "+         
    "valorHoraF = VALUES (valorHoraF), "+         
    "valorMinutoF = VALUES (valorMinutoF)");
            stmt.setDouble(1, recebimento1.getSalario());
            stmt.setDouble(2, recebimento1.getDecimoTerceiro());
            stmt.setDouble(3, recebimento1.getFerias());
            stmt.setDouble(4, recebimento1.getHorasTrabalhadas());
            stmt.setDouble(5, recebimento1.getHorasTotais());
            stmt.setDouble(6, recebimento1.getValorHora());
            stmt.setDouble(7, recebimento1.getValorMinuto());
            stmt.setDouble(8, recebimento1.getValorHoraD());
            stmt.setDouble(9, recebimento1.getValorMinutoD());
            stmt.setDouble(10, recebimento1.getValorHoraF());
            stmt.setDouble(11, recebimento1.getValorMinutoF());
            stmt.setInt(12, recebimento1.getIDReb());
            stmt.setInt(13, recebimento1.getUser_codUsuario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Valor adicionado com sucesso");            
}
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
        }
            finally{
                    ConnectionFactory.closeConnection(con,stmt);
                    }         
        }
    public List <Recebimento1> listar() throws SQLException, ClassNotFoundException {
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
            Recebimento1 recebiment = new Recebimento1();
            recebiment.setSalario(rs.getDouble("salario"));
            recebiment.setDecimoTerceiro(rs.getDouble("decimoTerceiro"));
            recebiment.setFerias(rs.getDouble("ferias"));
            recebiment.setHorasTrabalhadas(rs.getDouble("horasTrabalhadas"));
            recebiment.setHorasTotais(rs.getDouble("horasTotais"));
            recebiment.setIDReb(rs.getInt("IDReb"));
            recebiment.setUser_codUsuario(rs.getInt("User_codUsuario"));
            recebimentos.add(recebiment); // This line was missing.
        }
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    return recebimentos;
    }
    public void delete(int IDReb) throws SQLException, ClassNotFoundException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM tablerecebimentos WHERE IDReb = ?");
        stmt.setInt(1, IDReb);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Id não encontrado");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt);
    }
   }
}
