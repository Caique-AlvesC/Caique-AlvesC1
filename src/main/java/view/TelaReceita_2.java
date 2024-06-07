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

public void LoadUpdate(int cod_receita2) throws SQLException, ClassNotFoundException {
    ReceitaDao dao = new ReceitaDao();
    Receita receita = dao.fetchProductById(cod_receita2);

    if (receita != null) {
        AddNomeReceitaTextField.setText(receita.getCod_Receita());
        TempoGastoTextField.setText(String.valueOf(receita.getTempo_Gasto()));
        horMinComboBox.setSelectedItem(receita.getMod_tempo());
        MargemLucroTextField1.setText(String.valueOf(receita.getMargem_Lucro()));
        listarIngredietesReceitaTable(AddNomeReceitaTextField.getText());
        updateTotalCostLabel();
        calcTimeButtonActionPerformed(null);
        calcFinalActionPerformed(null);
        
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
        calcTimeButton = new javax.swing.JButton();
        custoFixoTextField = new javax.swing.JLabel();
        calcFinal = new javax.swing.JButton();
        SalvarReceitaButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        receitaReturn.setBackground(new java.awt.Color(255, 204, 204));
        receitaReturn.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        receitaReturn.setForeground(new java.awt.Color(255, 255, 255));
        receitaReturn.setText("Voltar");
        receitaReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaReturnActionPerformed(evt);
            }
        });
        getContentPane().add(receitaReturn);
        receitaReturn.setBounds(1140, 10, 110, 50);

        AddNomeReceitaTextField.setBackground(new java.awt.Color(255, 204, 204));
        AddNomeReceitaTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        AddNomeReceitaTextField.setForeground(new java.awt.Color(255, 255, 255));
        AddNomeReceitaTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Receita de :"));
        getContentPane().add(AddNomeReceitaTextField);
        AddNomeReceitaTextField.setBounds(10, 10, 460, 48);

        IngredientesComboBox.setBackground(new java.awt.Color(255, 204, 204));
        IngredientesComboBox.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        IngredientesComboBox.setForeground(new java.awt.Color(255, 255, 255));
        IngredientesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione o Ingrediente>" }));
        IngredientesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredientesComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(IngredientesComboBox);
        IngredientesComboBox.setBounds(480, 10, 190, 42);

        QuantIngredieTextField.setBackground(new java.awt.Color(255, 204, 204));
        QuantIngredieTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        QuantIngredieTextField.setForeground(new java.awt.Color(255, 255, 255));
        QuantIngredieTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade do Ingrediente usado:"))));
        QuantIngredieTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantIngredieTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(QuantIngredieTextField);
        QuantIngredieTextField.setBounds(680, 10, 230, 42);

        IngredietesReceitaTable.setBackground(new java.awt.Color(255, 204, 204));
        IngredietesReceitaTable.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        IngredietesReceitaTable.setForeground(new java.awt.Color(255, 255, 255));
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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 1230, 190);

        TempoGastoTextField.setBackground(new java.awt.Color(255, 204, 204));
        TempoGastoTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        TempoGastoTextField.setForeground(new java.awt.Color(255, 255, 255));
        TempoGastoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Tempo gasto:"));
        TempoGastoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempoGastoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(TempoGastoTextField);
        TempoGastoTextField.setBounds(230, 340, 174, 57);

        horMinComboBox.setBackground(new java.awt.Color(255, 204, 204));
        horMinComboBox.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        horMinComboBox.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(horMinComboBox);
        horMinComboBox.setBounds(410, 340, 170, 51);

        DTTempoGastoLabel.setBackground(new java.awt.Color(255, 204, 204));
        DTTempoGastoLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        DTTempoGastoLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("13° e ferias pelo tempo de produção:"));
        getContentPane().add(DTTempoGastoLabel);
        DTTempoGastoLabel.setBounds(271, 400, 230, 51);

        SalarioTempoGastoLabel1.setBackground(new java.awt.Color(255, 204, 204));
        SalarioTempoGastoLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        SalarioTempoGastoLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Salário pelo tempo de produção:"));
        getContentPane().add(SalarioTempoGastoLabel1);
        SalarioTempoGastoLabel1.setBounds(20, 400, 250, 51);

        MargemLucroTextField1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        MargemLucroTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Margem de Lucro:"));
        MargemLucroTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MargemLucroTextField1FocusLost(evt);
            }
        });
        getContentPane().add(MargemLucroTextField1);
        MargemLucroTextField1.setBounds(950, 402, 150, 50);

        LucroLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        LucroLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Receber de Lucro:"));
        getContentPane().add(LucroLabel);
        LucroLabel.setBounds(1107, 402, 130, 50);

        ReceitaValorFinalLabel.setBackground(new java.awt.Color(0, 0, 0));
        ReceitaValorFinalLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        ReceitaValorFinalLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor final do Produto :"));
        getContentPane().add(ReceitaValorFinalLabel);
        ReceitaValorFinalLabel.setBounds(780, 510, 450, 88);

        AtualizarReceitaButton.setBackground(new java.awt.Color(255, 204, 204));
        AtualizarReceitaButton.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        AtualizarReceitaButton.setForeground(new java.awt.Color(255, 255, 255));
        AtualizarReceitaButton.setText("Atualizar");
        AtualizarReceitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarReceitaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AtualizarReceitaButton);
        AtualizarReceitaButton.setBounds(20, 520, 370, 88);

        metricaRecComboBox.setBackground(new java.awt.Color(255, 204, 204));
        metricaRecComboBox.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        metricaRecComboBox.setForeground(new java.awt.Color(255, 255, 255));
        metricaRecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Escolha uma opção de Metrica>", "Ml(mililitros)", "L (Litros)", "g (gramas)", "kg (Quilos)", "U (Unidades)" }));
        metricaRecComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metricaRecComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(metricaRecComboBox);
        metricaRecComboBox.setBounds(920, 10, 210, 42);

        addReceita.setBackground(new java.awt.Color(255, 204, 204));
        addReceita.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        addReceita.setForeground(new java.awt.Color(255, 255, 255));
        addReceita.setText("Add");
        addReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReceitaActionPerformed(evt);
            }
        });
        getContentPane().add(addReceita);
        addReceita.setBounds(10, 70, 350, 42);

        custoTotalTextLabel.setEditable(false);
        custoTotalTextLabel.setBackground(new java.awt.Color(255, 204, 204));
        custoTotalTextLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        custoTotalTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        custoTotalTextLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Custo total de ingredientes usados :"));
        custoTotalTextLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoTotalTextLabelActionPerformed(evt);
            }
        });
        getContentPane().add(custoTotalTextLabel);
        custoTotalTextLabel.setBounds(10, 340, 210, 60);

        totalAntLucro.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        totalAntLucro.setBorder(javax.swing.BorderFactory.createTitledBorder("Total até aqui:"));
        getContentPane().add(totalAntLucro);
        totalAntLucro.setBounds(741, 400, 200, 51);

        calcTimeButton.setBackground(new java.awt.Color(255, 204, 204));
        calcTimeButton.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        calcTimeButton.setForeground(new java.awt.Color(255, 255, 255));
        calcTimeButton.setText("Calcular Gasto por tempo:");
        calcTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcTimeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calcTimeButton);
        calcTimeButton.setBounds(810, 330, 430, 57);

        custoFixoTextField.setBackground(new java.awt.Color(255, 204, 204));
        custoFixoTextField.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        custoFixoTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Custo fixo de :"));
        getContentPane().add(custoFixoTextField);
        custoFixoTextField.setBounds(514, 400, 220, 51);

        calcFinal.setBackground(new java.awt.Color(255, 204, 204));
        calcFinal.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        calcFinal.setForeground(new java.awt.Color(255, 255, 255));
        calcFinal.setText("Calcular lucro e valor final");
        calcFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcFinalActionPerformed(evt);
            }
        });
        getContentPane().add(calcFinal);
        calcFinal.setBounds(20, 460, 1210, 40);

        SalvarReceitaButton1.setBackground(new java.awt.Color(255, 204, 204));
        SalvarReceitaButton1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        SalvarReceitaButton1.setForeground(new java.awt.Color(255, 255, 255));
        SalvarReceitaButton1.setText("Salvar");
        SalvarReceitaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarReceitaButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(SalvarReceitaButton1);
        SalvarReceitaButton1.setBounds(400, 520, 360, 88);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-06-04 212012.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

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

    private void calcTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcTimeButtonActionPerformed
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
    }//GEN-LAST:event_calcTimeButtonActionPerformed

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
        receita.setCod_receita2(cod_receita2);
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
    private javax.swing.JButton calcTimeButton;
    private javax.swing.JLabel custoFixoTextField;
    private javax.swing.JTextField custoTotalTextLabel;
    private javax.swing.JComboBox<String> horMinComboBox;
    private javax.swing.JLabel jLabel1;
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
