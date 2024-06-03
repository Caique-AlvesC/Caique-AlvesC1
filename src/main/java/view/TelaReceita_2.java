/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import arquivs.java.Ingredientes;
import arquivs.java.IngredientesUse;
import arquivs.java.Recebimento1;
import arquivs.java.Receita;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.IngredienteDao;
import model.dao.IngredienteUseDao;
import model.dao.ReceitaDao;


public class TelaReceita_2 extends javax.swing.JFrame {
    private JTable receitasTable;
    boolean isByHour;
    String cod_Receita;
    String hXm;
    double totalAntLuc;
    double custoFixo ;
    double salario;
    double decimoFerias ;
    double custoIngTotal ;
   
    public TelaReceita_2(JTable receitasTable) throws SQLException, ClassNotFoundException {
        super("Tela de adicionar Receitas");
        this.receitasTable = receitasTable;
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
            horMinComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horMinComboBoxActionPerformed(evt);
            }
        });
 
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

void LoadUpdate(int codReceita2) throws SQLException, ClassNotFoundException {
    ReceitaDao dao = new ReceitaDao();
    Receita receita = dao.fetchAllProducts(codReceita2);
    

    // Verifica se a receita foi encontrada
    if (receita != null) {
        AddNomeReceitaTextField.setText(receita.getCod_Receita());
        TempoGastoTextField.setText(String.valueOf(receita.getTempo_Gasto()));
        horMinComboBox.setSelectedItem(receita.getMod_tempo());
        MargemLucroTextField1.setText(String.valueOf(receita.getMargem_Lucro()));
    } else {
        JOptionPane.showMessageDialog(this, "Receita não encontrada.");
    }
}




private void updateTotalCostLabel() {
    try {
        IngredienteUseDao dao = new IngredienteUseDao(); // Create an instance of IngredienteUseDao
        String cod_Receita = AddNomeReceitaTextField.getText(); // Get the recipe code
        double totalCusto = dao.listarSoma(cod_Receita); // Use the listarSoma method from IngredienteUseDao
        custoTotalTextLabel.setText(String.format("Total Custo: %.2f", totalCusto)); // Update the JLabel with the total cost
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        horMinComboBox = new javax.swing.JComboBox<>();
        DTTempoGastoLabel = new javax.swing.JLabel();
        SalarioTempoGastoLabel1 = new javax.swing.JLabel();
        MargemLucroTextField1 = new javax.swing.JTextField();
        LucroLabel = new javax.swing.JLabel();
        ReceitaValorFinalLabel = new javax.swing.JLabel();
        AtualizarReceitaButton = new javax.swing.JButton();
        metricaRecComboBox = new javax.swing.JComboBox<>();
        addReceita = new javax.swing.JButton();
        custoTotalTextLabel = new javax.swing.JTextField();
        totalAntLucro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        custoFixoTextField = new javax.swing.JLabel();
        calcFinal = new javax.swing.JButton();
        SalvarReceitaButton1 = new javax.swing.JButton();

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
        TempoGastoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempoGastoTextFieldActionPerformed(evt);
            }
        });

        horMinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horas", "Minutos", " " }));
        horMinComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo gasto em :"));
        horMinComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                horMinComboBoxFocusLost(evt);
            }
        });
        horMinComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horMinComboBoxActionPerformed(evt);
            }
        });

        DTTempoGastoLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("13° e ferias pelo tempo de produção:"));

        SalarioTempoGastoLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Salário pelo tempo de produção:"));

        MargemLucroTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Margem de Lucro:"));
        MargemLucroTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MargemLucroTextField1FocusLost(evt);
            }
        });

        LucroLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Receber de Lucro:"));

        ReceitaValorFinalLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor final do Produto :"));

        AtualizarReceitaButton.setText("Atualizar");
        AtualizarReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarReceitaButtonActionPerformed(evt);
            }
        });

        metricaRecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha uma opção de Metrica>", "Ml(mililitros)", "L (Litros)", "g (gramas)", "kg (Quilos)", "U (Unidades)" }));
        metricaRecComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricaRecComboBoxActionPerformed(evt);
            }
        });

        addReceita.setText("Add");
        addReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReceitaActionPerformed(evt);
            }
        });

        custoTotalTextLabel.setEditable(false);
        custoTotalTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        custoTotalTextLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Custo total de ingredientes usados :"));
        custoTotalTextLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoTotalTextLabelActionPerformed(evt);
            }
        });

        totalAntLucro.setEditable(false);
        totalAntLucro.setBorder(javax.swing.BorderFactory.createTitledBorder("Total até aqui:"));

        jButton1.setText("Calcular Gasto por tempo:");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        custoFixoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Custo fixo de :"));

        calcFinal.setText("Calcular lucro e valor final");
        calcFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcFinalActionPerformed(evt);
            }
        });

        SalvarReceitaButton1.setText("Salvar");
        SalvarReceitaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarReceitaButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                .addComponent(ReceitaValorFinalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SalvarReceitaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AtualizarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MargemLucroTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SalarioTempoGastoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTTempoGastoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(custoFixoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAntLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(custoTotalTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TempoGastoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horMinComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custoTotalTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TempoGastoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(horMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(custoFixoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalarioTempoGastoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(DTTempoGastoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(totalAntLucro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MargemLucroTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LucroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ReceitaValorFinalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SalvarReceitaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AtualizarReceitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(180, 180, 180))
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

    private void horMinComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horMinComboBoxActionPerformed
        hXm = (String) horMinComboBox.getSelectedItem();
        isByHour = hXm.equals("Horas");  
    }//GEN-LAST:event_horMinComboBoxActionPerformed

    private void addReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReceitaActionPerformed
    try {
        Ingredientes selectedIngredient = (Ingredientes) IngredientesComboBox.getSelectedItem();
        if (selectedIngredient != null) {
            IngredientesUse ingredientesUse = createIngredientesUse(selectedIngredient);
            IngredienteUseDao dao = new IngredienteUseDao();
            dao.createUse(ingredientesUse);
            listarIngredietesReceitaTable(AddNomeReceitaTextField.getText());
            updateTotalCostLabel();
        }
    } catch (SQLException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Database error", ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Class not found", ex);
    } catch (NumberFormatException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Invalid number format", ex);
    }
    }//GEN-LAST:event_addReceitaActionPerformed

    private void custoTotalTextLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoTotalTextLabelActionPerformed

    }//GEN-LAST:event_custoTotalTextLabelActionPerformed

    private void TempoGastoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempoGastoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TempoGastoTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    calculateAndUpdateLabels(isByHour);
try {
        // Obtenha os textos dos campos e remova qualquer texto não numérico
        String custoFixoText = custoFixoTextField.getText().replace("Custo fixo: ", "").trim().replace(",", ".");
        String salarioText = SalarioTempoGastoLabel1.getText().replace("Salário: ", "").trim().replace(",", ".");
        String decimoFeriasText = DTTempoGastoLabel.getText().replace("Décimo e Férias: ", "").trim().replace(",", ".");
        String custoIngTotalText = custoTotalTextLabel.getText().replace("Total Custo:", "").trim().replace(",",".");

        // Converta os textos para double
       custoFixo = Double.parseDouble(custoFixoText);
       salario = Double.parseDouble(salarioText);
       decimoFerias = Double.parseDouble(decimoFeriasText);
       custoIngTotal = Double.parseDouble(custoIngTotalText);

        // Calcule a soma
        totalAntLuc = custoFixo + salario + decimoFerias + custoIngTotal ;

        // Defina o valor calculado no campo totalAntLucro
        totalAntLucro.setText(String.format("%.2f", totalAntLuc));

    } catch (NumberFormatException e) {
        // Trate o erro de formato de número
        System.err.println("Erro ao converter valores para número: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void horMinComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_horMinComboBoxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_horMinComboBoxFocusLost

    private void MargemLucroTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MargemLucroTextField1FocusLost

    }//GEN-LAST:event_MargemLucroTextField1FocusLost
 double lucro;
 double saldoLucro;
 double totalFinal;
    private void calcFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcFinalActionPerformed
                try {
                    lucro = Double.parseDouble(MargemLucroTextField1.getText().trim().replace(",", "."));
                    System.out.println("Lucro de : " + lucro + "%");
                    saldoLucro = totalAntLuc / (1 - (lucro / 100));
                    LucroLabel.setText(String.format("%.2f", saldoLucro));
                    totalFinal = totalAntLuc + saldoLucro;
                    ReceitaValorFinalLabel.setText(String.format("Preço final de : %.2f", totalFinal));
                } catch (NumberFormatException ex) {
                    System.err.println("Erro ao converter lucro: " + ex.getMessage());
                }

    }//GEN-LAST:event_calcFinalActionPerformed

    private void AtualizarReceitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarReceitaButtonActionPerformed
if (receitasTable.getSelectedRow() != -1) {
    try {
        Receita receita = new Receita();
        ReceitaDao dao = new ReceitaDao();
        int cod_receita2 = Integer.parseInt(receitasTable.getValueAt(receitasTable.getSelectedRow(), 4).toString());
        receita.setCod_Receita(AddNomeReceitaTextField.getText());
        receita.setCusto_total_ingredie(custoIngTotal);
        receita.setTempo_Gasto(timeSpent);
        receita.setMod_tempo(horMinComboBox.getSelectedItem().toString());
        receita.setSalario_aReceber(salario);
        receita.setA13_ferias(decimoFerias);
        receita.setCusto_Fixo(custoFixo);
        receita.setTotalAntsLucro(totalAntLuc);
        receita.setMargem_Lucro(lucro);
        receita.setReceber_Lucro(saldoLucro);
        receita.setReceber_Total(totalFinal);
        receita.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
        dao.update(receita);
        JOptionPane.showMessageDialog(this, "Receita atualizada com sucesso!");
    } catch (SQLException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a receita.");
    }
        }
    }//GEN-LAST:event_AtualizarReceitaButtonActionPerformed

    private void SalvarReceitaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarReceitaButton1ActionPerformed
    try {
            Receita receita = new Receita();
            ReceitaDao dao = new ReceitaDao();
            receita.setCod_Receita(AddNomeReceitaTextField.getText());
            receita.setCusto_total_ingredie(custoIngTotal);
            receita.setTempo_Gasto(timeSpent);
            receita.setMod_tempo(horMinComboBox.getSelectedItem().toString());
            receita.setSalario_aReceber(salario);
            receita.setA13_ferias(decimoFerias);
            receita.setCusto_Fixo(custoFixo);
            receita.setTotalAntsLucro(totalAntLuc);
            receita.setMargem_Lucro(lucro);
            receita.setReceber_Lucro(saldoLucro);
            receita.setReceber_Total(totalFinal);
            receita.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            
            dao.create(receita);

     } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SalvarReceitaButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddNomeReceitaTextField;
    private javax.swing.JButton AtualizarReceitaButton;
    private javax.swing.JLabel DTTempoGastoLabel;
    private javax.swing.JComboBox IngredientesComboBox;
    private javax.swing.JTable IngredietesReceitaTable;
    private javax.swing.JLabel LucroLabel;
    private javax.swing.JTextField MargemLucroTextField1;
    private javax.swing.JTextField QuantIngredieTextField;
    private javax.swing.JLabel ReceitaValorFinalLabel;
    private javax.swing.JLabel SalarioTempoGastoLabel1;
    private javax.swing.JButton SalvarReceitaButton1;
    private javax.swing.JTextField TempoGastoTextField;
    private javax.swing.JButton addReceita;
    private javax.swing.JButton calcFinal;
    private javax.swing.JLabel custoFixoTextField;
    private javax.swing.JTextField custoTotalTextLabel;
    private javax.swing.JComboBox<String> horMinComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metricaRecComboBox;
    private javax.swing.JButton receitaReturn;
    private javax.swing.JTextField totalAntLucro;
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
    } else if ("L (Litros)".equals(metrica) && "Ml (mililitros)".equals(metricaRec)) {
        return (preco / (quantidade * 1000)) * quantidadeAtual;
    } else if ("Ml (mililitros)".equals(metrica) && "L (Litros)".equals(metricaRec)) {
        return (preco / (quantidade / 1000)) * quantidadeAtual;
    } else {
        throw new IllegalArgumentException("Métricas não compatíveis ou não implementadas.");
    }
}
int timeSpent;
private void calculateAndUpdateLabels(boolean isByHour) {
    try {
        timeSpent = Integer.parseInt(TempoGastoTextField.getText());
        IngredienteUseDao dao = new IngredienteUseDao();
        double totalCusto = dao.listarSoma(cod_Receita); // Calculate total cost
        List<Recebimento1> recebimentosHM = dao.calculoHorasxMinutos();

        Recebimento1 recebimento = recebimentosHM.get(0);


        double recebimentosS;
        double recebimentosD;
        double recebimentosF;
        double recebimentosCH;
        double recebimentosCM;
        double salarioRec;
        double decimoFeriasRec;
        double custoFixoAt;

        if (isByHour) {
            recebimentosS = recebimento.getValorHora();
            recebimentosD = recebimento.getValorHoraD();
            recebimentosF = recebimento.getValorHoraF();
            recebimentosCH = recebimento.getCustoFixoH();
            salarioRec = recebimentosS * timeSpent;
            decimoFeriasRec = (recebimentosD * timeSpent) + (recebimentosF * timeSpent);
            custoFixoAt = recebimentosCH * timeSpent;

            // Adicionando logs para depuração
            System.out.println("Recebimentos Hora: " + recebimentosS);
            System.out.println("Custo Fixo Hora: " + recebimentosCH);
            System.out.println("Time Spent: " + timeSpent);
            System.out.println("Custo Fixo At (Horas): " + custoFixoAt);
        } else {
            recebimentosS = recebimento.getValorMinuto();
            recebimentosD = recebimento.getValorMinutoD();
            recebimentosF = recebimento.getValorMinutoF();
            recebimentosCM = recebimento.getCustoFixoM();
            salarioRec = recebimentosS * timeSpent;
            decimoFeriasRec = (recebimentosD * timeSpent) + (recebimentosF * timeSpent);
            custoFixoAt = recebimentosCM * timeSpent;

            // Adicionando logs para depuração
            System.out.println("Recebimentos Minuto: " + recebimentosS);
            System.out.println("Custo Fixo Minuto: " + recebimentosCM);
            System.out.println("Time Spent: " + timeSpent);
            System.out.println("Custo Fixo At (Minutos): " + custoFixoAt);

            // Verificação adicional
            if (recebimentosCM == 0.0) {
                System.out.println("Erro: custoFixoM está zerado.");
            }
        }

        SalarioTempoGastoLabel1.setText(String.format("Salário: %.2f", salarioRec));
        DTTempoGastoLabel.setText(String.format("Décimo e Férias: %.2f", decimoFeriasRec));
        custoFixoTextField.setText(String.format("Custo fixo: %.2f", custoFixoAt));

    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NumberFormatException ex) {
        Logger.getLogger(TelaReceita_2.class.getName()).log(Level.SEVERE, "Invalid time input", ex);
    }
}
}
