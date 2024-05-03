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

        jPanel1 = new javax.swing.JPanel();
        IngredReturnInicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IngredientesTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        precoTextField = new javax.swing.JTextField();
        quantTextField = new javax.swing.JTextField();
        metricaBox = new javax.swing.JComboBox<>();
        descriptionTextField = new javax.swing.JTextField();
        salvarAddIngred = new javax.swing.JButton();
        produtoTextField = new javax.swing.JTextField();
        UpdateButtonTabIng = new javax.swing.JButton();
        deleteIngButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IngredReturnInicio.setText("Voltar");
        IngredReturnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredReturnInicioActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IngredReturnInicio)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IngredReturnInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        precoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço do produto"));
        precoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoTextFieldActionPerformed(evt);
            }
        });

        quantTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade do item:"));

        metricaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha uma opção de Metrica>", "Ml(mililitros)", "L (Litros)", "g (gramas)", "kg (Quilos)", "U (Unidades)" }));
        metricaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricaBoxActionPerformed(evt);
            }
        });

        descriptionTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição do produto (opcional)"));

        salvarAddIngred.setText("ADD");
        salvarAddIngred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAddIngredActionPerformed(evt);
            }
        });

        produtoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do Produto:"));
        produtoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoTextFieldActionPerformed(evt);
            }
        });

        UpdateButtonTabIng.setText("Atualizar Tabela");
        UpdateButtonTabIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonTabIngActionPerformed(evt);
            }
        });

        deleteIngButton.setText("Excluir Ingrediente");
        deleteIngButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(descriptionTextField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(produtoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metricaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(salvarAddIngred, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpdateButtonTabIng, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteIngButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantTextField)))
                    .addComponent(metricaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvarAddIngred, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(UpdateButtonTabIng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteIngButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metricaBox;
    private javax.swing.JTextField precoTextField;
    private javax.swing.JTextField produtoTextField;
    private javax.swing.JTextField quantTextField;
    private javax.swing.JButton salvarAddIngred;
    // End of variables declaration//GEN-END:variables

}
