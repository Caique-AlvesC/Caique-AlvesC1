/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.precification;

import arquivs.java.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.UsuarioDao;

/**
 *
 * @author Kaique Alves
 */
public class TelaLogin_Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin_Cadastro
     */
    public TelaLogin_Cadastro() {
        super("Cadastro");
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginCadTextField = new javax.swing.JTextField();
        SenhaCadTextField = new javax.swing.JTextField();
        SenhaCadTextField2 = new javax.swing.JTextField();
        CadLoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginCadTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Login a ser Cadastrado:"));

        SenhaCadTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite a senha para o cadastro:"));

        SenhaCadTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite novamente a senha:"));

        CadLoginButton.setText("Cadastrar");
        CadLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadLoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CadLoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(SenhaCadTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addComponent(loginCadTextField))
                    .addComponent(SenhaCadTextField2))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(loginCadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SenhaCadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SenhaCadTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CadLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadLoginButtonActionPerformed
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        usuario.setLogin(loginCadTextField.getText());
        if (SenhaCadTextField.getText().equals(SenhaCadTextField2.getText())) {
            usuario.setSenha(SenhaCadTextField.getText());
            try {
                dao.cadastrar(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(TelaLogin_Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaLogin_Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
        }
        else{
            JOptionPane.showMessageDialog(null, "Senhas não compativeis");
        }
        
    }//GEN-LAST:event_CadLoginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadLoginButton;
    private javax.swing.JTextField SenhaCadTextField;
    private javax.swing.JTextField SenhaCadTextField2;
    private javax.swing.JTextField loginCadTextField;
    // End of variables declaration//GEN-END:variables
}
