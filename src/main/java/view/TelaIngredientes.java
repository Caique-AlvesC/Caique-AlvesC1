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
        UpdateButtonTabIng = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpdateButtonTabIng.setText("Atualizar Tabela");
        UpdateButtonTabIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonTabIngActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(IngredientesTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateButtonTabIng, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButtonTabIng)
                    .addComponent(IngredReturnInicio))
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
                    .addComponent(salvarAddIngred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(salvarAddIngred, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        try {
            listarIngredientesTable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
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

            
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaIngredientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarAddIngredActionPerformed

    private void produtoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoTextFieldActionPerformed

    }//GEN-LAST:event_produtoTextFieldActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngredReturnInicio;
    private javax.swing.JTable IngredientesTable;
    private javax.swing.JButton UpdateButtonTabIng;
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
