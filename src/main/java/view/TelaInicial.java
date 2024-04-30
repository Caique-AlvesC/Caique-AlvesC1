/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import arquivs.java.Usuario;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaInicial extends javax.swing.JFrame {
private int codUsuario;
    public TelaInicial() {
        super("Tela Inicial");
        this.codUsuario = codUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(null, "Seu Id de Login é " + Usuario.getInstance().getCodUsuario());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        custoButton = new javax.swing.JButton();
        ingredienteButton = new javax.swing.JButton();
        recebimentoButton = new javax.swing.JButton();
        receitaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        custoButton.setText("Custos Fixos");
        custoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoButtonActionPerformed(evt);
            }
        });

        ingredienteButton.setText("Ingredientes");
        ingredienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredienteButtonActionPerformed(evt);
            }
        });

        recebimentoButton.setText("Recebimentos");
        recebimentoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recebimentoButtonActionPerformed(evt);
            }
        });

        receitaButton.setText("Receitas");
        receitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(custoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ingredienteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recebimentoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingredienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recebimentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingredienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredienteButtonActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
                new TelaIngredientes().setVisible(true);
        });
    }//GEN-LAST:event_ingredienteButtonActionPerformed

    private void receitaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaButtonActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaReceita_1().setVisible(true);
        });
    }//GEN-LAST:event_receitaButtonActionPerformed

    private void custoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoButtonActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TelaCusto().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }//GEN-LAST:event_custoButtonActionPerformed

    private void recebimentoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recebimentoButtonActionPerformed
      this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
          try {
              new TelaRecebimento().setVisible(true);
          } catch (SQLException ex) {
              Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
          }
        });  
    }//GEN-LAST:event_recebimentoButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton custoButton;
    private javax.swing.JButton ingredienteButton;
    private javax.swing.JButton recebimentoButton;
    private javax.swing.JButton receitaButton;
    // End of variables declaration//GEN-END:variables
}
