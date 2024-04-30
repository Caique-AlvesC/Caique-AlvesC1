package com.mycompany.precification;

import arquivs.java.Recebimento1;
import arquivs.java.Usuario;
import com.mycompany.precification.TelaInicial;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.RecebimentoDao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaRecebimento extends javax.swing.JFrame{

    public TelaRecebimento() throws SQLException, ClassNotFoundException {
        super("Tela de Recebimentos");
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel modelo = (DefaultTableModel) TableRecebimento.getModel();
        TableRecebimento.setRowSorter(new TableRowSorter (modelo));
        listarTableRecebimento(); 
}
    public void listarTableRecebimento() throws SQLException, ClassNotFoundException{
      DefaultTableModel modelo = (DefaultTableModel) TableRecebimento.getModel();
      modelo.setNumRows(0);
      RecebimentoDao rdao = new RecebimentoDao();
      for(Recebimento1 recebimento1: rdao.listar()){
              modelo.addRow(new Object[]{
              recebimento1.getSalario(),
              recebimento1.getDecimoTerceiro(),
              recebimento1.getFerias(),
              recebimento1.getHorasTrabalhadas(),
              recebimento1.getHorasTotais(),
              recebimento1.getIDReb(),
              recebimento1.getUser_codUsuario()
          });
      }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salarioTextField = new javax.swing.JTextField();
        DecimoTerceiroTextField = new javax.swing.JTextField();
        FeriasTextField = new javax.swing.JTextField();
        HorasTrabalhadasTextField = new javax.swing.JTextField();
        HorasTotaisTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRecebimento = new javax.swing.JTable();
        back = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        salarioTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Salario:"));
        salarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioTextFieldActionPerformed(evt);
            }
        });

        DecimoTerceiroTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Decimo terceiro"));
        DecimoTerceiroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecimoTerceiroTextFieldActionPerformed(evt);
            }
        });

        FeriasTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Ferias"));
        FeriasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeriasTextFieldActionPerformed(evt);
            }
        });

        HorasTrabalhadasTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas de Produção"));

        HorasTotaisTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas trabalhadas totais"));

        TableRecebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Salário", "Décimo Terceiro", "Férias", "Horas Trabalhadas", "Horas Totais", "ID", "ID USUARIO"
            }
        ));
        jScrollPane1.setViewportView(TableRecebimento);

        back.setText("voltar");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        save.setText("Salvar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecimoTerceiroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FeriasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HorasTrabalhadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HorasTotaisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecimoTerceiroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FeriasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HorasTrabalhadasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HorasTotaisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioTextFieldActionPerformed

    private void DecimoTerceiroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecimoTerceiroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DecimoTerceiroTextFieldActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
 this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
try {
            Recebimento1 recebimento1 = new Recebimento1();
            RecebimentoDao dao = new RecebimentoDao();
            recebimento1.setSalario(Double.parseDouble(salarioTextField.getText()));
            recebimento1.setDecimoTerceiro(Double.parseDouble(DecimoTerceiroTextField.getText()));
            recebimento1.setFerias(Double.parseDouble(FeriasTextField.getText()));
            recebimento1.setHorasTrabalhadas(Double.parseDouble(HorasTrabalhadasTextField.getText()));
            recebimento1.setHorasTotais(Double.parseDouble(HorasTotaisTextField.getText()));
            recebimento1.setUser_codUsuario(Usuario.getInstance().getCodUsuario());
            dao.create(recebimento1);
            listarTableRecebimento();
    }//GEN-LAST:event_saveActionPerformed
 catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaRecebimento.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void FeriasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeriasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeriasTextFieldActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DecimoTerceiroTextField;
    private javax.swing.JTextField FeriasTextField;
    private javax.swing.JTextField HorasTotaisTextField;
    private javax.swing.JTextField HorasTrabalhadasTextField;
    private javax.swing.JTable TableRecebimento;
    private javax.swing.JButton back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField salarioTextField;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}