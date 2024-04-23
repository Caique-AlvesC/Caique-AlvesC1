package model.dao;

import arquivs.java.Recebimento1;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RecebimentoDao {
    public void create (Recebimento1 recebimento1) throws SQLException, ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO tablerecebimentos (salario, decimoTerceiro, ferias, horasTrabalhadas, horasTotais) VALUES (?, ?, ?, ?, ?)");
            stmt.setDouble(1, recebimento1.getSalario());
            stmt.setDouble(2, recebimento1.getDecimoTerceiro());
            stmt.setDouble(3, recebimento1.getFerias());
            stmt.setDouble(4, recebimento1.getHorasTrabalhadas());
            stmt.setDouble(5, recebimento1.getHorasTotais());
            
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
        stmt = con.prepareStatement("SELECT * FROM tablerecebimentos");
        rs = stmt.executeQuery();
        while (rs.next()) {
            Recebimento1 recebiment = new Recebimento1();
            recebiment.setSalario(rs.getDouble("salario"));
            recebiment.setDecimoTerceiro(rs.getDouble("decimoTerceiro"));
            recebiment.setFerias(rs.getDouble("ferias"));
            recebiment.setHorasTrabalhadas(rs.getDouble("horasTrabalhadas"));
            recebiment.setHorasTotais(rs.getDouble("horasTotais"));
            recebimentos.add(recebiment); // This line was missing.
        }
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    return recebimentos;
    }
}

