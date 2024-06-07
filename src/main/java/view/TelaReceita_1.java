/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import arquivs.java.Receita;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.ReceitaDao;

/**
 *
 * @author Kaique Alves
 */
public class TelaReceita_1 extends javax.swing.JFrame {
private int codReceita2;
    public TelaReceita_1() {
        super("Tela de Receitas");
        initComponents();
        this.setLocationRelativeTo(null);
       DefaultTableModel modelo = (DefaultTableModel) receitasTable.getModel();
       receitasTable.setRowSorter(new TableRowSorter (modelo));
       
     try {
        listarReceitaTable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  

    
    
    public void listarReceitaTable() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) receitasTable.getModel();
      modelo.setNumRows(0);
      ReceitaDao rdao = new ReceitaDao();
      for(Receita receita: rdao.listar()){
              modelo.addRow(new Object[]{
              receita.getCod_Receita(),
              receita.getReceber_Total(),
              receita.getCusto_total_ingredie(),
              receita.getReceber_Lucro(),
              receita.getCod_receita2(),
          
          });
          
      } 
  }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        editarRecButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        deleteReceita = new javax.swing.JButton();
        receitaReturn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receitasTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        textField1.setText("textField1");

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel2.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel2.setLayout(null);

        editarRecButton.setBackground(new java.awt.Color(255, 204, 204));
        editarRecButton.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        editarRecButton.setForeground(new java.awt.Color(255, 255, 255));
        editarRecButton.setText("Abrir Receita Selecionada");
        editarRecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarRecButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editarRecButton);
        editarRecButton.setBounds(20, 20, 280, 100);

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Ingredientes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(320, 20, 280, 100);

        deleteReceita.setBackground(new java.awt.Color(255, 204, 204));
        deleteReceita.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        deleteReceita.setForeground(new java.awt.Color(255, 255, 255));
        deleteReceita.setText("Excluir Receita");
        deleteReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReceitaActionPerformed(evt);
            }
        });
        jPanel2.add(deleteReceita);
        deleteReceita.setBounds(670, 20, 280, 100);

        receitaReturn.setBackground(new java.awt.Color(255, 204, 204));
        receitaReturn.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        receitaReturn.setForeground(new java.awt.Color(255, 255, 255));
        receitaReturn.setText("Voltar");
        receitaReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaReturnActionPerformed(evt);
            }
        });
        jPanel2.add(receitaReturn);
        receitaReturn.setBounds(970, 20, 280, 100);

        receitasTable.setBackground(new java.awt.Color(255, 204, 204));
        receitasTable.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        receitasTable.setForeground(new java.awt.Color(255, 255, 255));
        receitasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Receita de:", "Preço Final", "Custo Ingredientes", "Lucros", "ID Receita"
            }
        ));
        receitasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                receitasTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(receitasTable);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 1230, 510);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-05-31 140311.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receitasTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receitasTableMouseReleased
        if (receitasTable.getSelectedRow() != -1) {
            // Obtenha o valor do cod_receita2 da tabela e armazene na variável de instância
            codReceita2 = Integer.parseInt(receitasTable.getValueAt(receitasTable.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_receitasTableMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaIngredientes().setVisible(true);
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void receitaReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaReturnActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }//GEN-LAST:event_receitaReturnActionPerformed

    private void deleteReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReceitaActionPerformed
        if (receitasTable.getSelectedRow() != -1) {
            int selectedRow = receitasTable.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel) receitasTable.getModel();
            int cod_receita2 = Integer.parseInt(modelo.getValueAt(selectedRow, 4).toString());

            ReceitaDao dao = new ReceitaDao();
            try {
                dao.delete(cod_receita2);
                modelo.removeRow(selectedRow);

            } catch (SQLException ex) {
                Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao excluir a Receita: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Classe não encontrada: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Receita para excluir");
        }
    }//GEN-LAST:event_deleteReceitaActionPerformed

    private void editarRecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarRecButtonActionPerformed

        if (codReceita2 != 0) {
            try {
                this.dispose();
                TelaReceita_2 telaEdicao = new TelaReceita_2(receitasTable);
                telaEdicao.LoadUpdate(codReceita2);
                telaEdicao.setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(TelaReceita_1.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao carregar a receita: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma receita para editar.");
        }
    }//GEN-LAST:event_editarRecButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteReceita;
    private javax.swing.JButton editarRecButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton receitaReturn;
    private javax.swing.JTable receitasTable;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
