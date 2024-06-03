/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import arquivs.java.Custo;
import arquivs.java.Recebimento1;
import arquivs.java.Usuario;
import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import model.dao.CustosDao;
/**
 *
 * @author Kaique Alves
 */
public class TelaCusto extends javax.swing.JFrame {
    private double totalCusto;

    public TelaCusto() throws SQLException, ClassNotFoundException {
        super("Tela de Custos Fixos");
        initComponents();
        this.setLocationRelativeTo(null);
        
        DefaultTableModel modelo = (DefaultTableModel) CustoTable.getModel();
        TableColumnModel tcm = CustoTable.getColumnModel();
        System.out.println("Number of columns: " + CustoTable.getColumnCount());
        listarCustoTable();
        listarSomaCustoFixo();
        CalculoCustoFixoHxM();
    
       
        
    }
    public void listarCustoTable() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) CustoTable.getModel();
      modelo.setNumRows(0);
      CustosDao cdao = new CustosDao();
      for(Custo custo: cdao.listar()){
              modelo.addRow(new Object[]{
              custo.getnomeCusto(),
              custo.getvalorCusto(),
              custo.getdescricaoCusto(),
              custo.getIDCUSTO(),
              custo.getUser_codUsuario()
              
          });
          
      }
    }
    
public void listarSomaCustoFixo() {
    CustosDao fdao = new CustosDao();
        try {
        totalCusto = fdao.listarSoma();      
        totalCustoFixoText.setText(String.format("%.2f", totalCusto));
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
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
        ExcluirCustoButton = new javax.swing.JButton();
        updateCustoButton1 = new javax.swing.JButton();
        AddCustoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustoTable = new javax.swing.JTable();
        totalCustoFixoText = new javax.swing.JTextField();

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

        ExcluirCustoButton.setText("Excluir");
        ExcluirCustoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCustoButtonActionPerformed(evt);
            }
        });

        updateCustoButton1.setText("Atualizar");
        updateCustoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustoButton1ActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExcluirCustoButton)
                    .addComponent(updateCustoButton1)
                    .addComponent(AddCustoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(NomeCustoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(ValorCustoTextField)
                    .addComponent(AddCustoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DescricaoCustoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ExcluirCustoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateCustoButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        CustoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Custos", "Valores", "Descrições", "IDCUSTO", "ID USUARIO"
            }
        ));
        CustoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustoTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CustoTableMouseReleased(evt);
            }
        });
        CustoTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CustoTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CustoTable);

        totalCustoFixoText.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Custos Fixos:"));
        totalCustoFixoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCustoFixoTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalCustoFixoText, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(custReturnInicio))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalCustoFixoText, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custReturnInicio))
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

    private void ExcluirCustoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirCustoButtonActionPerformed
    if (CustoTable.getSelectedRow() != -1) {
        int selectedRow = CustoTable.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) CustoTable.getModel();
        int idCusto = Integer.parseInt(modelo.getValueAt(selectedRow, 3).toString());

        CustosDao dao = new CustosDao();
        try {
            dao.delete(idCusto);
            modelo.removeRow(selectedRow);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir o custo: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Classe não encontrada: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione um custo para excluir");
    }
    }//GEN-LAST:event_ExcluirCustoButtonActionPerformed

    private void updateCustoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCustoButton1ActionPerformed
        if (CustoTable.getSelectedRow() != -1) {

            try {
                Custo custo = new Custo();
                CustosDao dao = new CustosDao();
                int idCusto = Integer.parseInt(CustoTable.getValueAt(CustoTable.getSelectedRow(), 3).toString());
                int user_codUsuario = Integer.parseInt(CustoTable.getValueAt(CustoTable.getSelectedRow(), 4).toString());
                
                custo.setnomeCusto(NomeCustoTextField.getText());
                custo.setvalorCusto(Double.parseDouble(ValorCustoTextField.getText()));
                custo.setdescricaoCusto(DescricaoCustoTextField.getText());
                custo.setIDCUSTO(idCusto);
                custo.setUser_codUsuario(user_codUsuario);
                
                
                dao.update(custo);
                listarCustoTable();
                CalculoCustoFixoHxM();
                NomeCustoTextField.setText("");
                ValorCustoTextField.setText("");
                DescricaoCustoTextField.setText("");
            JOptionPane.showMessageDialog(null, "Updating: " + custo.getnomeCusto() + ", " + custo.getvalorCusto() + ", " + custo.getdescricaoCusto() + ", " + custo.getIDCUSTO()+ ", " +custo.getUser_codUsuario());    
            } catch (SQLException ex) {
                Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                
    }//GEN-LAST:event_updateCustoButton1ActionPerformed

    private void AddCustoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustoButtonActionPerformed
         try {
            Custo custo = new Custo();
            CustosDao dao = new CustosDao();
            
            custo.setnomeCusto(NomeCustoTextField.getText());
            custo.setvalorCusto(Double.parseDouble(ValorCustoTextField.getText()));
            custo.setdescricaoCusto(DescricaoCustoTextField.getText());
            custo.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            dao.create(custo);
            listarCustoTable();
            listarSomaCustoFixo();
            CalculoCustoFixoHxM();
            NomeCustoTextField.setText("");
            ValorCustoTextField.setText("");
            DescricaoCustoTextField.setText("");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddCustoButtonActionPerformed

    private void CustoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustoTableMouseClicked
         
    }//GEN-LAST:event_CustoTableMouseClicked

    private void CustoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustoTableKeyReleased
     
    }//GEN-LAST:event_CustoTableKeyReleased

    private void CustoTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustoTableMouseReleased
         if (CustoTable.getSelectedRow() != -1) {
        NomeCustoTextField.setText(CustoTable.getValueAt(CustoTable.getSelectedRow(), 0).toString());
        ValorCustoTextField.setText(CustoTable.getValueAt(CustoTable.getSelectedRow(), 1).toString());
        DescricaoCustoTextField.setText(CustoTable.getValueAt(CustoTable.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_CustoTableMouseReleased

    private void totalCustoFixoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCustoFixoTextActionPerformed

    }//GEN-LAST:event_totalCustoFixoTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustoButton;
    private javax.swing.JTable CustoTable;
    private javax.swing.JTextField DescricaoCustoTextField;
    private javax.swing.JButton ExcluirCustoButton;
    private javax.swing.JTextField NomeCustoTextField;
    private javax.swing.JTextField ValorCustoTextField;
    private javax.swing.JButton custReturnInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalCustoFixoText;
    private javax.swing.JButton updateCustoButton1;
    // End of variables declaration//GEN-END:variables

    public void CalculoCustoFixoHxM(){
        try {
    CustosDao dao = new CustosDao();
    double horasTrabalhadas = dao.getHorasTrabalhadas(Usuario.getInstance().getCodUsuario());        
    double totalCusto = dao.listarSoma();
  
    
    Recebimento1 recebimento1= new Recebimento1();
    recebimento1.setHorasTrabalhadas(horasTrabalhadas);
    recebimento1.setCustoFixo(totalCusto);
    
    double custoFixoH = recebimento1.CalcValorCustoFixoH();
    double custoFixoM = recebimento1.CalcValorCustoFixoM();
    
    recebimento1.setCustoFixoH(custoFixoH);
    recebimento1.setCustoFixoM(custoFixoM);
    recebimento1.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
    dao.CalcCustoFixoHxM(recebimento1);
}       catch (SQLException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCusto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
