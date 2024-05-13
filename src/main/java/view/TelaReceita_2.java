/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import arquivs.java.Ingredientes;
import arquivs.java.IngredientesUse;
import arquivs.java.Usuario;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;


import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.IngredienteDao;
import model.dao.IngredienteUseDao;


/**
 *
 * @author Kaique Alves
 */
public class TelaReceita_2 extends javax.swing.JFrame {
    
    public TelaReceita_2() throws SQLException, ClassNotFoundException {
        super("Tela de adicionar Receitas");
        initComponents();
        this.setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        loadIngredients();
        
        DefaultTableModel modelo = (DefaultTableModel) IngredietesReceitaTable.getModel();
        IngredietesReceitaTable.setRowSorter(new TableRowSorter (modelo));
        try {
        listarIngredietesReceitaTable(AddNomeReceitaTextField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
        }    
}
    
    public void listarIngredietesReceitaTable(String cod_Receita) throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) IngredietesReceitaTable.getModel();
      modelo.setNumRows(0);
      IngredienteUseDao idao = new IngredienteUseDao();
      for(IngredientesUse ingredientesUse: idao.listar(cod_Receita)){
              modelo.addRow(new Object[]{
              ingredientesUse.getNomeIngrediente(),
              ingredientesUse.getQuantidadeAtual(),
              ingredientesUse.getMetricaUsoAtual(),
              ingredientesUse.getIngredietCustoAtual(),
              ingredientesUse.getIdIngUsado(),
              ingredientesUse.getIDIngr(),
              ingredientesUse.getUser_codUsuario(),
              ingredientesUse.getCod_Receita()          
          });
          
      }  
    }

    private void IngredReturnInicioActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }
private void loadIngredients() throws SQLException, ClassNotFoundException{
        IngredienteDao dao = new IngredienteDao();
    List<Ingredientes> products = dao.fetchAllProducts();
    IngredientesComboBox.removeAllItems(); // Clear previous items
    for (Ingredientes product : products) {
        IngredientesComboBox.addItem(product);
    }
    IngredientesComboBox.setRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Ingredientes) {
            setText(((Ingredientes) value).getProduto());
        }
        return this;
    }
});
    IngredientesComboBox.addItemListener(e -> {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Ingredientes selectedIngredient = (Ingredientes) e.getItem();
            System.out.println("IDIngr: " + selectedIngredient.getIDIngr());
            // Considerar atualizar outros componentes de UI com mais detalhes do ingrediente
        }
    });
    
    
    
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receitaReturn = new javax.swing.JButton();
        AddNomeReceitaTextField = new javax.swing.JTextField();
        IngredientesComboBox = new javax.swing.JComboBox();
        QuantIngredieTextField = new javax.swing.JTextField();
        AddIngReceita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IngredietesReceitaTable = new javax.swing.JTable();
        TempoGastoTextField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        DTTempoGastoLabel = new javax.swing.JLabel();
        SalarioTempoGastoLabel1 = new javax.swing.JLabel();
        MargemDescTextField = new javax.swing.JTextField();
        DescontoLabel = new javax.swing.JLabel();
        MargemLucroTextField1 = new javax.swing.JTextField();
        LucroLabel = new javax.swing.JLabel();
        ReceitaValorFinalLabel = new javax.swing.JLabel();
        SalvarReceitaButton = new javax.swing.JButton();
        metricaRecComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        receitaReturn.setText("Voltar");
        receitaReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaReturnActionPerformed(evt);
            }
        });

        AddNomeReceitaTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Receita de :"));

        IngredientesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione o Ingrediente>" }));
        IngredientesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredientesComboBoxActionPerformed(evt);
            }
        });

        QuantIngredieTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade do Ingrediente usado:"))));
        QuantIngredieTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantIngredieTextFieldActionPerformed(evt);
            }
        });

        AddIngReceita.setText("Add");
        AddIngReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIngReceitaActionPerformed(evt);
            }
        });

        IngredietesReceitaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ingrediente:", "Quantidade:", "Metrica:", "Custo Atual:", "ID Ingr. Usado:", "ID Ingr", "User_codUsuario", "cod_Receita:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(IngredietesReceitaTable);

        TempoGastoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo gasto:"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horas", "Minutos", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo gasto em :"));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        DTTempoGastoLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("13° e ferias pelo tempo de produção:"));

        SalarioTempoGastoLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Salário pelo tempo de produção:"));

        MargemDescTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Margem de Desconto:"));

        DescontoLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor de Desconto:"));

        MargemLucroTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Margem de Lucro:"));

        LucroLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Receber de Lucro:"));

        ReceitaValorFinalLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor final do Produto :"));

        SalvarReceitaButton.setText("Salvar");

        metricaRecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha uma opção de Metrica>", "Ml(mililitros)", "L (Litros)", "g (gramas)", "kg (Quilos)", "U (Unidades)" }));
        metricaRecComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricaRecComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddNomeReceitaTextField)
                        .addGap(18, 18, 18)
                        .addComponent(receitaReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IngredientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(QuantIngredieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(metricaRecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddIngReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TempoGastoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SalarioTempoGastoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DTTempoGastoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MargemLucroTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MargemDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DescontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ReceitaValorFinalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SalvarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receitaReturn)
                    .addComponent(AddNomeReceitaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IngredientesComboBox)
                    .addComponent(QuantIngredieTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(metricaRecComboBox)
                    .addComponent(AddIngReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TempoGastoTextField)
                        .addComponent(jComboBox1)
                        .addComponent(SalarioTempoGastoLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addComponent(DTTempoGastoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DescontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MargemLucroTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MargemDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReceitaValorFinalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(SalvarReceitaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receitaReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaReturnActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }//GEN-LAST:event_receitaReturnActionPerformed

    private void QuantIngredieTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantIngredieTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantIngredieTextFieldActionPerformed

    private void IngredientesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngredientesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngredientesComboBoxActionPerformed

    private void metricaRecComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metricaRecComboBoxActionPerformed
 JComboBox<String> metricaRecComboBox = new JComboBox <>();
        metricaRecComboBox.addItem("Ml(mililitros)");
        metricaRecComboBox.addItem("L (Litros)");
        metricaRecComboBox.addItem("g (gramas)");
        metricaRecComboBox.addItem("kg (Quilos)");
        metricaRecComboBox.addItem("U (Unidades)");

        String metricaSelect = (String)metricaRecComboBox.getSelectedItem();        // TODO add your handling code here:
    }//GEN-LAST:event_metricaRecComboBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void AddIngReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIngReceitaActionPerformed
     
        try {
            Ingredientes selectedIngredient = (Ingredientes) IngredientesComboBox.getSelectedItem();
        if (selectedIngredient != null) {
            IngredientesUse ingredientesUse = new IngredientesUse();
            IngredienteUseDao dao = new IngredienteUseDao();

        ingredientesUse.setNomeIngrediente(selectedIngredient.getProduto());
        double preco = selectedIngredient.getPreco();
        double quantidade = selectedIngredient.getQuantidade();
        String metrica = selectedIngredient.getMetrica(); // Supondo que exista um método getMetrica.
        double quantidadeAtual = Double.parseDouble(QuantIngredieTextField.getText());
        double custoAtual = (preco / quantidade) * quantidadeAtual;

            
            
            ingredientesUse.setIngredietCustoAtual(custoAtual);
            ingredientesUse.setQuantidadeAtual(Double.parseDouble(QuantIngredieTextField.getText()));
            ingredientesUse.setMetricaUsoAtual(metricaRecComboBox.getSelectedItem().toString());
            ingredientesUse.setIDIngr(selectedIngredient.getIDIngr());
            ingredientesUse.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            ingredientesUse.setCod_Receita(AddNomeReceitaTextField.getText());
            
            dao.createUse(ingredientesUse);
            listarIngredietesReceitaTable(AddNomeReceitaTextField.getText());
}

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_AddIngReceitaActionPerformed

    
    
    
    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddIngReceita;
    private javax.swing.JTextField AddNomeReceitaTextField;
    private javax.swing.JLabel DTTempoGastoLabel;
    private javax.swing.JLabel DescontoLabel;
    private javax.swing.JComboBox IngredientesComboBox;
    private javax.swing.JTable IngredietesReceitaTable;
    private javax.swing.JLabel LucroLabel;
    private javax.swing.JTextField MargemDescTextField;
    private javax.swing.JTextField MargemLucroTextField1;
    private javax.swing.JTextField QuantIngredieTextField;
    private javax.swing.JLabel ReceitaValorFinalLabel;
    private javax.swing.JLabel SalarioTempoGastoLabel1;
    private javax.swing.JButton SalvarReceitaButton;
    private javax.swing.JTextField TempoGastoTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metricaRecComboBox;
    private javax.swing.JButton receitaReturn;
    // End of variables declaration//GEN-END:variables
}
