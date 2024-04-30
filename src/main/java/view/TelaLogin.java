
package view;

import arquivs.java.Usuario;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.UsuarioDao;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        super("Tela de Login");
        initComponents();
        this.setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userTextField = new javax.swing.JTextField();
        senhaTextField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario:"));
        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        senhaTextField.setText("jPasswordField1");
        senhaTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha:"));

        LoginButton.setText("Entrar");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(senhaTextField)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
    UsuarioDao dao = new UsuarioDao();
    String username = userTextField.getText();
    char[] passwordArray = senhaTextField.getPassword();
    String password = new String(passwordArray);
    try {
        int userId = dao.checkLogin(username, password);
        if (userId > 0) {
           
            Usuario.getInstance().setCodUsuario(userId);
            JOptionPane.showMessageDialog(null, "Bem Vindo!!");
            this.dispose();
            java.awt.EventQueue.invokeLater(() -> {
                new TelaInicial().setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Senha ou usuário Incorretos");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados: " + ex.getMessage());
        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + ex.getMessage());
        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Apaga o array de senha para segurança
        Arrays.fill(passwordArray, '0');
    }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin_Cadastro().setVisible(true);
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JPasswordField senhaTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
