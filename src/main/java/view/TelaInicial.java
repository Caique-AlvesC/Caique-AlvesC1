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
//        JOptionPane.showMessageDialog(null, "Seu Id de Login é " + Usuario.getInstance().getCodUsuario());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        custoButton = new javax.swing.JButton();
        ingredienteButton = new javax.swing.JButton();
        recebimentoButton = new javax.swing.JButton();
        receitaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        custoButton.setBackground(new java.awt.Color(255, 153, 153));
        custoButton.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        custoButton.setForeground(new java.awt.Color(255, 255, 255));
        custoButton.setText("Custos Fixos");
        custoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(custoButton);
        custoButton.setBounds(200, 400, 350, 200);

        ingredienteButton.setBackground(new java.awt.Color(255, 153, 153));
        ingredienteButton.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        ingredienteButton.setForeground(new java.awt.Color(255, 255, 255));
        ingredienteButton.setText("Ingredientes");
        ingredienteButton.setMaximumSize(new java.awt.Dimension(290, 100));
        ingredienteButton.setMinimumSize(new java.awt.Dimension(290, 100));
        ingredienteButton.setPreferredSize(new java.awt.Dimension(290, 100));
        ingredienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredienteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ingredienteButton);
        ingredienteButton.setBounds(200, 100, 350, 200);

        recebimentoButton.setBackground(new java.awt.Color(255, 153, 153));
        recebimentoButton.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        recebimentoButton.setForeground(new java.awt.Color(255, 255, 255));
        recebimentoButton.setText("Recebimentos");
        recebimentoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recebimentoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recebimentoButton);
        recebimentoButton.setBounds(750, 400, 350, 200);

        receitaButton.setBackground(new java.awt.Color(255, 153, 153));
        receitaButton.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        receitaButton.setForeground(new java.awt.Color(255, 255, 255));
        receitaButton.setText("Receitas");
        receitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(receitaButton);
        receitaButton.setBounds(750, 100, 350, 200);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-05-31 140311.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-7, -5, 1300, 730);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton recebimentoButton;
    private javax.swing.JButton receitaButton;
    // End of variables declaration//GEN-END:variables
}
