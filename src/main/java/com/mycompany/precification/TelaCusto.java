/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.precification;
import arquivs.java.Custo;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.CustosDao;
/**
 *
 * @author Kaique Alves
 */
public class TelaCusto extends javax.swing.JFrame {

    /**
     * Creates new form TelaCusto
     */
    public TelaCusto() throws SQLException, ClassNotFoundException {
        super("Tela de Custos Fixos");
        initComponents();
        this.setLocationRelativeTo(null);
        
        DefaultTableModel modelo = (DefaultTableModel) CustoTable.getModel();
        CustoTable.setRowSorter(new TableRowSorter (modelo));
        listarCustoTable();
    }

    public void listarCustoTable() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) CustoTable.getModel();
      modelo.setNumRows(0);
      CustosDao cdao = new CustosDao();
      for(Custo custo: cdao.listar()){
              modelo.addRow(new Object[]{
              custo.getnomeCusto(),
              custo.getvalorCusto(),
              custo.getdescricaoCusto()
              
          });
          
      }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        custReturnInicio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        NomeCustoTextField = new javax.swing.JTextField();
        ValorCustoTextField = new javax.swing.JTextField();
        DescricaoCustoTextField = new javax.swing.JTextField();
        AddCustoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustoTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        custReturnInicio.setText("Voltar");
        custReturnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custReturnInicioActionPerformed(evt);
            }
        });

        NomeCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do Custo:"));
        NomeCustoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCustoTextFieldActionPerformed(evt);
            }
        });

        ValorCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor do Custo:"));

        DescricaoCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do Custo:"));
        DescricaoCustoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescricaoCustoTextFieldActionPerformed(evt);
            }
        });

        AddCustoButton.setText("Add");
        AddCustoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(DescricaoCustoTextField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NomeCustoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ValorCustoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddCustoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddCustoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NomeCustoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(ValorCustoTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DescricaoCustoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        CustoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Custos", "Valores", "Descrições"
            }
        ));
        jScrollPane1.setViewportView(CustoTable);
        if (CustoTable.getColumnModel().getColumnCount() > 0) {
            CustoTable.getColumnModel().getColumn(0).setHeaderValue("Custos");
            CustoTable.getColumnModel().getColumn(1).setHeaderValue("Valores");
            CustoTable.getColumnModel().getColumn(2).setHeaderValue("Descrições");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 447, Short.MAX_VALUE)
                        .addComponent(custReturnInicio))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custReturnInicio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custReturnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custReturnInicioActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }//GEN-LAST:event_custReturnInicioActionPerformed

    private void NomeCustoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCustoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCustoTextFieldActionPerformed

    private void DescricaoCustoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescricaoCustoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescricaoCustoTextFieldActionPerformed

    private void AddCustoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustoButtonActionPerformed
        try {
            Custo custo = new Custo();
            CustosDao dao = new CustosDao();
            
            custo.setnomeCusto(NomeCustoTextField.getText());
            custo.setvalorCusto(Double.parseDouble(ValorCustoTextField.getText()));
            custo.setdescricaoCusto(DescricaoCustoTextField.getText());
            dao.create(custo);
            listarCustoTable();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_AddCustoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustoButton;
    private javax.swing.JTable CustoTable;
    private javax.swing.JTextField DescricaoCustoTextField;
    private javax.swing.JTextField NomeCustoTextField;
    private javax.swing.JTextField ValorCustoTextField;
    private javax.swing.JButton custReturnInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
