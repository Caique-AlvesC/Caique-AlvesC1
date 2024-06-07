/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import arquivs.java.Ingredientes;
import arquivs.java.Usuario;
import model.dao.IngredienteDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaIngredientes extends javax.swing.JFrame {
    public TelaIngredientes(){
    super("Tela de Ingredientes");
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel modelo = (DefaultTableModel) IngredientesTable.getModel();
        IngredientesTable.setRowSorter(new TableRowSorter (modelo));
        try {
        listarIngredientesTable();
        } catch (SQLException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
    
    
    public void listarIngredientesTable() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) IngredientesTable.getModel();
      modelo.setNumRows(0);
      IngredienteDao idao = new IngredienteDao();
      for(Ingredientes ingredientes: idao.listar()){
              modelo.addRow(new Object[]{
              ingredientes.getProduto(),
              ingredientes.getPreco(),
              ingredientes.getQuantidade(),
              ingredientes.getMetrica(),
              ingredientes.getDescricao(),
              ingredientes.getIDIngr(),
              ingredientes.getUser_codUsuario()
                      
          });
          
      }
      
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        IngredientesTable = new javax.swing.JTable();
        salvarAddIngred = new javax.swing.JButton();
        UpdateButtonTabIng = new javax.swing.JButton();
        IngredReturnInicio = new javax.swing.JButton();
        deleteIngButton = new javax.swing.JButton();
        descriptionTextField = new javax.swing.JTextField();
        metricaBox = new javax.swing.JComboBox<>();
        quantTextField = new javax.swing.JTextField();
        precoTextField = new javax.swing.JTextField();
        produtoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        IngredientesTable.setBackground(new java.awt.Color(255, 204, 204));
        IngredientesTable.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        IngredientesTable.setForeground(new java.awt.Color(255, 255, 255));
        IngredientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preco", "Quantidade", "Metrica", "Descricao", "ID", "ID Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IngredientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                IngredientesTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(IngredientesTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 320, 651, 340);

        salvarAddIngred.setBackground(new java.awt.Color(255, 204, 204));
        salvarAddIngred.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        salvarAddIngred.setForeground(new java.awt.Color(255, 255, 255));
        salvarAddIngred.setText("ADD");
        salvarAddIngred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAddIngredActionPerformed(evt);
            }
        });
        getContentPane().add(salvarAddIngred);
        salvarAddIngred.setBounds(320, 271, 140, 40);

        UpdateButtonTabIng.setBackground(new java.awt.Color(255, 204, 204));
        UpdateButtonTabIng.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        UpdateButtonTabIng.setForeground(new java.awt.Color(255, 255, 255));
        UpdateButtonTabIng.setText("Atualizar Tabela");
        UpdateButtonTabIng.setMaximumSize(new java.awt.Dimension(72, 23));
        UpdateButtonTabIng.setMinimumSize(new java.awt.Dimension(72, 23));
        UpdateButtonTabIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonTabIngActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButtonTabIng);
        UpdateButtonTabIng.setBounds(470, 270, 140, 40);

        IngredReturnInicio.setBackground(new java.awt.Color(255, 204, 204));
        IngredReturnInicio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        IngredReturnInicio.setForeground(new java.awt.Color(255, 255, 255));
        IngredReturnInicio.setText("Voltar");
        IngredReturnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredReturnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(IngredReturnInicio);
        IngredReturnInicio.setBounds(790, 270, 180, 40);

        deleteIngButton.setBackground(new java.awt.Color(255, 204, 204));
        deleteIngButton.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        deleteIngButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteIngButton.setText("Excluir Ingrediente");
        deleteIngButton.setPreferredSize(new java.awt.Dimension(72, 23));
        deleteIngButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteIngButton);
        deleteIngButton.setBounds(630, 270, 150, 40);

        descriptionTextField.setBackground(new java.awt.Color(255, 204, 204));
        descriptionTextField.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        descriptionTextField.setForeground(new java.awt.Color(255, 255, 255));
        descriptionTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do produto (opcional)"));
        getContentPane().add(descriptionTextField);
        descriptionTextField.setBounds(320, 120, 653, 144);

        metricaBox.setBackground(new java.awt.Color(255, 204, 204));
        metricaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha uma opção de Metrica>", "Ml(mililitros)", "L (Litros)", "g (gramas)", "kg (Quilos)", "U (Unidades)" }));
        metricaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricaBoxActionPerformed(evt);
            }
        });
        getContentPane().add(metricaBox);
        metricaBox.setBounds(850, 40, 119, 60);

        quantTextField.setBackground(new java.awt.Color(255, 204, 204));
        quantTextField.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        quantTextField.setForeground(new java.awt.Color(255, 255, 255));
        quantTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade do item:"));
        getContentPane().add(quantTextField);
        quantTextField.setBounds(680, 40, 164, 63);

        precoTextField.setBackground(new java.awt.Color(255, 204, 204));
        precoTextField.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        precoTextField.setForeground(new java.awt.Color(255, 255, 255));
        precoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço do produto"));
        precoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(precoTextField);
        precoTextField.setBounds(490, 40, 178, 63);

        produtoTextField.setBackground(new java.awt.Color(255, 204, 204));
        produtoTextField.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        produtoTextField.setForeground(new java.awt.Color(255, 255, 255));
        produtoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do Produto:"));
        produtoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(produtoTextField);
        produtoTextField.setBounds(324, 40, 160, 63);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-06-04 212110.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -250, 1300, 1220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngredReturnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngredReturnInicioActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }//GEN-LAST:event_IngredReturnInicioActionPerformed

    private void UpdateButtonTabIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonTabIngActionPerformed
if (IngredientesTable.getSelectedRow() != -1) {

            try {
                Ingredientes ingrediente = new Ingredientes();
                IngredienteDao dao = new IngredienteDao();
                int IDIngr = Integer.parseInt(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 5).toString());
                int user_codUsuario = Integer.parseInt(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 6).toString());
                
                ingrediente.setProduto(produtoTextField.getText());
                ingrediente.setPreco(Double.parseDouble(precoTextField.getText()));
                ingrediente.setQuantidade(Double.parseDouble(quantTextField.getText()));
                ingrediente.setMetrica(metricaBox.getSelectedItem().toString());
                ingrediente.setDescricao(descriptionTextField.getText());
                ingrediente.setIDIngr(IDIngr);
                ingrediente.setUser_codUsuario(user_codUsuario);
                
                
                dao.update(ingrediente);
                listarIngredientesTable();
                
                produtoTextField.setText("");
                precoTextField.setText("");
                quantTextField.setText("");
                metricaBox.setSelectedItem("");
                descriptionTextField.setText("");

            } catch (SQLException ex) {
                Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }//GEN-LAST:event_UpdateButtonTabIngActionPerformed

    private void precoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoTextFieldActionPerformed

    }//GEN-LAST:event_precoTextFieldActionPerformed

    private void metricaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metricaBoxActionPerformed
        JComboBox<String> metricaBox = new JComboBox <>();
        metricaBox.addItem("Ml(mililitros)");
        metricaBox.addItem("L (Litros)");
        metricaBox.addItem("g (gramas)");
        metricaBox.addItem("kg (Quilos)");
        metricaBox.addItem("U (Unidades)");

        String metricaSelect = (String)metricaBox.getSelectedItem();

    }//GEN-LAST:event_metricaBoxActionPerformed

    private void salvarAddIngredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAddIngredActionPerformed

        try {
            Ingredientes ingredientes = new Ingredientes();
            IngredienteDao dao = new IngredienteDao();
            ingredientes.setProduto(produtoTextField.getText());
            ingredientes.setPreco(Double.parseDouble(precoTextField.getText()));
            ingredientes.setQuantidade(Double.parseDouble(quantTextField.getText()));
            ingredientes.setMetrica(metricaBox.getSelectedItem().toString());
            ingredientes.setDescricao(descriptionTextField.getText());
            ingredientes.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            
            dao.create(ingredientes);
            listarIngredientesTable();

            produtoTextField.setText("");
            precoTextField.setText("");
            quantTextField.setText("");
            metricaBox.setSelectedItem("");
            descriptionTextField.setText("");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarAddIngredActionPerformed

    private void produtoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoTextFieldActionPerformed

    }//GEN-LAST:event_produtoTextFieldActionPerformed

    private void deleteIngButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngButtonActionPerformed
        if (IngredientesTable.getSelectedRow() != -1) {
        int selectedRow = IngredientesTable.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) IngredientesTable.getModel();
        int IDIngr = Integer.parseInt(modelo.getValueAt(selectedRow, 5).toString());

        IngredienteDao dao = new IngredienteDao();
        try {
            dao.delete(IDIngr);
            modelo.removeRow(selectedRow);
            
                produtoTextField.setText("");
                precoTextField.setText("");
                quantTextField.setText("");
                metricaBox.setSelectedItem("");
                descriptionTextField.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir o ingrediente: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Classe não encontrada: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione um ingrediente para excluir");
    }
    }//GEN-LAST:event_deleteIngButtonActionPerformed

    private void IngredientesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngredientesTableMouseReleased
        if (IngredientesTable.getSelectedRow() != -1) {
        produtoTextField.setText(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 0).toString());
        precoTextField.setText(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 1).toString());
        quantTextField.setText(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 2).toString());
        metricaBox.setSelectedItem(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 3).toString());
        descriptionTextField.setText(IngredientesTable.getValueAt(IngredientesTable.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_IngredientesTableMouseReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngredReturnInicio;
    private javax.swing.JTable IngredientesTable;
    private javax.swing.JButton UpdateButtonTabIng;
    private javax.swing.JButton deleteIngButton;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metricaBox;
    private javax.swing.JTextField precoTextField;
    private javax.swing.JTextField produtoTextField;
    private javax.swing.JTextField quantTextField;
    private javax.swing.JButton salvarAddIngred;
    // End of variables declaration//GEN-END:variables

}
