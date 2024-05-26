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
        custoTotalTextLabel = new javax.swing.JLabel();
        addReceita = new javax.swing.JButton();

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

        custoTotalTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        custoTotalTextLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Custo total dos Ingredientes :"));

        addReceita.setText("Add");
        addReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReceitaActionPerformed(evt);
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
                        .addComponent(IngredientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(QuantIngredieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(metricaRecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(custoTotalTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(addReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custoTotalTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TempoGastoTextField)
                        .addComponent(jComboBox1)
                        .addComponent(SalarioTempoGastoLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DTTempoGastoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DescontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MargemLucroTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MargemDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReceitaValorFinalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalvarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void addReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReceitaActionPerformed
    try {
        Ingredientes selectedIngredient = (Ingredientes) IngredientesComboBox.getSelectedItem();
        if (selectedIngredient != null) {
            IngredientesUse ingredientesUse = createIngredientesUse(selectedIngredient);
            IngredienteUseDao dao = new IngredienteUseDao();
            dao.createUse(ingredientesUse);
            listarIngredietesReceitaTable(AddNomeReceitaTextField.getText());
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Database error", ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Class not found", ex);
    } catch (NumberFormatException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Invalid number format", ex);
    }
    }//GEN-LAST:event_addReceitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton addReceita;
    private javax.swing.JLabel custoTotalTextLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metricaRecComboBox;
    private javax.swing.JButton receitaReturn;
    // End of variables declaration//GEN-END:variables

private IngredientesUse createIngredientesUse(Ingredientes selectedIngredient) {
    IngredientesUse ingredientesUse = new IngredientesUse();
    double preco = selectedIngredient.getPreco();
    double quantidade = selectedIngredient.getQuantidade();
    String metrica = selectedIngredient.getMetrica();
    String metricaRec = (String) metricaRecComboBox.getSelectedItem();
    double quantidadeAtual = Double.parseDouble(QuantIngredieTextField.getText());
    double custoAtual = calculateCost(preco, quantidade, metrica, metricaRec, quantidadeAtual);
    
    ingredientesUse.setNomeIngrediente(selectedIngredient.getProduto());
    ingredientesUse.setIngredietCustoAtual(custoAtual);
    ingredientesUse.setQuantidadeAtual(quantidadeAtual);
    ingredientesUse.setMetricaUsoAtual(metricaRec);
    ingredientesUse.setIDIngr(selectedIngredient.getIDIngr());
    ingredientesUse.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
    ingredientesUse.setCod_Receita(AddNomeReceitaTextField.getText());
    
    return ingredientesUse;
}

private double calculateCost(double preco, double quantidade, String metrica, String metricaRec, double quantidadeAtual) {
    if (metrica == null ? metricaRec == null : metrica.equals(metricaRec)) {
        return (preco / quantidade) * quantidadeAtual;
    } else if ("kg (Quilos)".equals(metrica) && "g (gramas)".equals(metricaRec)) {
        return (preco / (quantidade * 1000)) * quantidadeAtual;
    } else if ("g (gramas)".equals(metrica) && "kg (Quilos)".equals(metricaRec)) {
        return (preco / (quantidade / 1000)) * quantidadeAtual;
    } else if ("L (Litros)".equals(metrica) && "Ml(mililitros)".equals(metricaRec)) {
        return (preco / (quantidade * 1000)) * quantidadeAtual;
    } else if ("Ml(mililitros)".equals(metrica) && "L (Litros)".equals(metricaRec)) {
        return (preco / (quantidade / 1000)) * quantidadeAtual;
    } else {
        throw new IllegalArgumentException("Métricas não compatíveis ou não implementadas.");
    }
}
}
