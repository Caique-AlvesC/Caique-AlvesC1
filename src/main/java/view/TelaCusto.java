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
        jScrollPane1 = new javax.swing.JScrollPane();
        CustoTable = new javax.swing.JTable();
        totalCustoFixoText = new javax.swing.JTextField();
        DescricaoCustoTextField = new javax.swing.JTextField();
        NomeCustoTextField = new javax.swing.JTextField();
        updateCustoButton1 = new javax.swing.JButton();
        ExcluirCustoButton = new javax.swing.JButton();
        AddCustoButton = new javax.swing.JButton();
        ValorCustoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        custReturnInicio.setBackground(new java.awt.Color(255, 204, 204));
        custReturnInicio.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        custReturnInicio.setForeground(new java.awt.Color(255, 255, 255));
        custReturnInicio.setText("Voltar");
        custReturnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custReturnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(custReturnInicio);
        custReturnInicio.setBounds(990, 590, 250, 50);

        CustoTable.setBackground(new java.awt.Color(255, 204, 204));
        CustoTable.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        CustoTable.setForeground(new java.awt.Color(255, 255, 255));
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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 370, 1216, 210);

        totalCustoFixoText.setBackground(new java.awt.Color(255, 204, 204));
        totalCustoFixoText.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        totalCustoFixoText.setForeground(new java.awt.Color(255, 255, 255));
        totalCustoFixoText.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Custos Fixos:"));
        totalCustoFixoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCustoFixoTextActionPerformed(evt);
            }
        });
        getContentPane().add(totalCustoFixoText);
        totalCustoFixoText.setBounds(30, 590, 530, 59);

        DescricaoCustoTextField.setBackground(new java.awt.Color(255, 204, 204));
        DescricaoCustoTextField.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        DescricaoCustoTextField.setForeground(new java.awt.Color(255, 255, 255));
        DescricaoCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do Custo:"));
        DescricaoCustoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescricaoCustoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(DescricaoCustoTextField);
        DescricaoCustoTextField.setBounds(30, 240, 1210, 110);

        NomeCustoTextField.setBackground(new java.awt.Color(255, 204, 204));
        NomeCustoTextField.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        NomeCustoTextField.setForeground(new java.awt.Color(255, 255, 255));
        NomeCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do Custo:"));
        NomeCustoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCustoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NomeCustoTextField);
        NomeCustoTextField.setBounds(30, 20, 1210, 55);

        updateCustoButton1.setBackground(new java.awt.Color(255, 204, 204));
        updateCustoButton1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        updateCustoButton1.setForeground(new java.awt.Color(255, 255, 255));
        updateCustoButton1.setText("Atualizar");
        updateCustoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustoButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(updateCustoButton1);
        updateCustoButton1.setBounds(30, 100, 390, 40);

        ExcluirCustoButton.setBackground(new java.awt.Color(255, 204, 204));
        ExcluirCustoButton.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        ExcluirCustoButton.setForeground(new java.awt.Color(255, 255, 255));
        ExcluirCustoButton.setText("Excluir");
        ExcluirCustoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirCustoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ExcluirCustoButton);
        ExcluirCustoButton.setBounds(850, 100, 390, 40);

        AddCustoButton.setBackground(new java.awt.Color(255, 204, 204));
        AddCustoButton.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        AddCustoButton.setForeground(new java.awt.Color(255, 255, 255));
        AddCustoButton.setText("Add");
        AddCustoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddCustoButton);
        AddCustoButton.setBounds(440, 100, 400, 40);

        ValorCustoTextField.setBackground(new java.awt.Color(255, 204, 204));
        ValorCustoTextField.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        ValorCustoTextField.setForeground(new java.awt.Color(255, 255, 255));
        ValorCustoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor do Custo:"));
        ValorCustoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorCustoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ValorCustoTextField);
        ValorCustoTextField.setBounds(30, 160, 1216, 62);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-05-31 140311.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 740);

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

    private void ValorCustoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorCustoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorCustoTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustoButton;
    private javax.swing.JTable CustoTable;
    private javax.swing.JTextField DescricaoCustoTextField;
    private javax.swing.JButton ExcluirCustoButton;
    private javax.swing.JTextField NomeCustoTextField;
    private javax.swing.JTextField ValorCustoTextField;
    private javax.swing.JButton custReturnInicio;
    private javax.swing.JLabel jLabel1;
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
