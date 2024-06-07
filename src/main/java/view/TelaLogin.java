
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        userTextField.setBackground(new java.awt.Color(255, 204, 204));
        userTextField.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        userTextField.setForeground(new java.awt.Color(255, 255, 255));
        userTextField.setText("rrr");
        userTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario:"));
        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(userTextField);
        userTextField.setBounds(250, 65, 780, 160);

        senhaTextField.setBackground(new java.awt.Color(255, 204, 204));
        senhaTextField.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        senhaTextField.setForeground(new java.awt.Color(255, 255, 255));
        senhaTextField.setText("jPasswordField1");
        senhaTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha:"));
        getContentPane().add(senhaTextField);
        senhaTextField.setBounds(250, 243, 780, 160);

        LoginButton.setBackground(new java.awt.Color(255, 204, 204));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        LoginButton.setText("Entrar");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton);
        LoginButton.setBounds(250, 504, 250, 103);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jButton2.setText("Cadastrar");
        jButton2.setMaximumSize(new java.awt.Dimension(250, 71));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(786, 504, 244, 103);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de tela 2024-06-04 210552.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField senhaTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
