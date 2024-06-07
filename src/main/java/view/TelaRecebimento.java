package view;

import arquivs.java.Recebimento1;
import arquivs.java.Usuario;
import view.TelaInicial;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.RecebimentoDao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaRecebimento extends javax.swing.JFrame{

    public TelaRecebimento() throws SQLException, ClassNotFoundException {
        super("Tela de Recebimentos");
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel modelo = (DefaultTableModel) tablerecebimentos.getModel();
        tablerecebimentos.setRowSorter(new TableRowSorter (modelo));
        listartablerecebimentos(); 
}
    public void listartablerecebimentos() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) tablerecebimentos.getModel();
      modelo.setNumRows(0);
      RecebimentoDao rdao = new RecebimentoDao();
      for(Recebimento1 recebimento1: rdao.listar()){
              modelo.addRow(new Object[]{
              recebimento1.getSalario(),
              recebimento1.getDecimoTerceiro(),
              recebimento1.getFerias(),
              recebimento1.getHorasTrabalhadas(),
              recebimento1.getHorasTotais(),
              recebimento1.getIDReb(),
              recebimento1.getUser_codUsuario()
          });
      }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salarioTextField = new javax.swing.JTextField();
        DecimoTerceiroTextField = new javax.swing.JTextField();
        FeriasTextField = new javax.swing.JTextField();
        HorasTrabalhadasTextField = new javax.swing.JTextField();
        HorasTotaisTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRecebimento = new javax.swing.JTable();
        back = new javax.swing.JButton();
        save = new javax.swing.JButton();
        DelRebButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        salarioTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Salario:"));
        salarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(salarioTextField);
        salarioTextField.setBounds(10, 60, 180, 68);

        DecimoTerceiroTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Decimo terceiro"));
        DecimoTerceiroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecimoTerceiroTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(DecimoTerceiroTextField);
        DecimoTerceiroTextField.setBounds(210, 60, 220, 68);

        FeriasTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Ferias"));
        FeriasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeriasTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FeriasTextField);
        FeriasTextField.setBounds(460, 60, 250, 68);

        HorasTrabalhadasTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas de Produção"));
        getContentPane().add(HorasTrabalhadasTextField);
        HorasTrabalhadasTextField.setBounds(730, 60, 240, 68);

        HorasTotaisTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas trabalhadas totais"));
        getContentPane().add(HorasTotaisTextField);
        HorasTotaisTextField.setBounds(990, 60, 200, 68);

        TableRecebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Salário", "Décimo Terceiro", "Férias", "Horas Trabalhadas", "Horas Totais", "ID", "ID USUARIO"
            }
        ));
        TableRecebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableRecebimentoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableRecebimento);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 1180, 360);

        back.setText("voltar");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(850, 150, 340, 60);

        save.setText("Salvar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(13, 150, 420, 60);

        DelRebButton.setText("Excluir dados");
        DelRebButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelRebButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DelRebButton);
        DelRebButton.setBounds(470, 150, 340, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-06-04 212012.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioTextFieldActionPerformed

    private void DecimoTerceiroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecimoTerceiroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecimoTerceiroTextFieldActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
 this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
try {
            Recebimento1 recebimento1 = new Recebimento1();
            RecebimentoDao dao = new RecebimentoDao();
            recebimento1.setSalario(Double.parseDouble(salarioTextField.getText()));
            recebimento1.setDecimoTerceiro(Double.parseDouble(DecimoTerceiroTextField.getText()));
            recebimento1.setFerias(Double.parseDouble(FeriasTextField.getText()));
            recebimento1.setHorasTrabalhadas(Double.parseDouble(HorasTrabalhadasTextField.getText()));
            recebimento1.setHorasTotais(Double.parseDouble(HorasTotaisTextField.getText()));
            
            recebimento1.CalcValorHora();
            recebimento1.CalcValorHoraD();
            recebimento1.CalcValorHoraF();
            recebimento1.CalcValorMinuto();
            recebimento1.CalcValorMinutoD();
            recebimento1.CalcValorMinutoF();
            recebimento1.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            dao.create(recebimento1);
            listartablerecebimentos();
            
            salarioTextField.setText("");
            DecimoTerceiroTextField.setText("");
            FeriasTextField.setText("");
            HorasTrabalhadasTextField.setText("");
            HorasTotaisTextField.setText("");    
    }//GEN-LAST:event_saveActionPerformed
 catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaRecebimento.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void FeriasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeriasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeriasTextFieldActionPerformed

    private void DelRebButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelRebButtonActionPerformed
        if (tablerecebimentos.getSelectedRow() != -1) {
        int selectedRow = tablerecebimentos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tablerecebimentos.getModel();
        int IDReb = Integer.parseInt(modelo.getValueAt(selectedRow, 5).toString());

        RecebimentoDao dao = new RecebimentoDao();
        try {
            dao.delete(IDReb);
            modelo.removeRow(selectedRow);
            
            salarioTextField.setText("");
            DecimoTerceiroTextField.setText("");
            FeriasTextField.setText("");
            HorasTrabalhadasTextField.setText("");
            HorasTotaisTextField.setText(""); 
        } catch (SQLException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir os dados de Recibemento: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Classe não encontrada: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione para excluir");
    }
    }//GEN-LAST:event_DelRebButtonActionPerformed

    private void tablerecebimentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablerecebimentosMouseReleased
       if (tablerecebimentos.getSelectedRow() != -1) {
        salarioTextField.setText(tablerecebimentos.getValueAt(tablerecebimentos.getSelectedRow(), 0).toString());
        DecimoTerceiroTextField.setText(tablerecebimentos.getValueAt(tablerecebimentos.getSelectedRow(), 1).toString());
        FeriasTextField.setText(tablerecebimentos.getValueAt(tablerecebimentos.getSelectedRow(), 2).toString());
        HorasTrabalhadasTextField.setText(tablerecebimentos.getValueAt(tablerecebimentos.getSelectedRow(), 3).toString());
        HorasTotaisTextField.setText(tablerecebimentos.getValueAt(tablerecebimentos.getSelectedRow(), 4).toString());
       }
    }//GEN-LAST:event_tablerecebimentosMouseReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DecimoTerceiroTextField;
    private javax.swing.JButton DelRebButton;
    private javax.swing.JTextField FeriasTextField;
    private javax.swing.JTextField HorasTotaisTextField;
    private javax.swing.JTextField HorasTrabalhadasTextField;
    private javax.swing.JTable TableRecebimento;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField salarioTextField;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}