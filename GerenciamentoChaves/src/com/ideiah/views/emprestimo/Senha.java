/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.emprestimo;

/**
 *
 * @author Kooler
 */
public class Senha extends javax.swing.JFrame {

    /**
     * Creates new form Senha
     */
    public Senha() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel_senha = new javax.swing.JLabel();
        jPasswordField_senha = new javax.swing.JPasswordField();
        jLabel_confirma = new javax.swing.JLabel();
        jLabel_alertaSenha = new javax.swing.JLabel();
        jButton_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel_senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_senha.setText("Digite a senha:");

        jPasswordField_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_senhaActionPerformed(evt);
            }
        });
        jPasswordField_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_senhaKeyPressed(evt);
            }
        });

        jLabel_confirma.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_confirma.setText("Confirmação");

        jLabel_alertaSenha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_alertaSenha.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_alertaSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_alertaSenha.setText("Senha Inválida");

        jButton_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ok.png"))); // NOI18N
        jButton_ok.setText("OK");
        jButton_ok.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton_ok.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton_ok))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_alertaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_senha)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_confirma)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_senha)
                    .addComponent(jPasswordField_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_ok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_alertaSenha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_senhaActionPerformed

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_okActionPerformed

    private void jPasswordField_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_senhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            //Adicionar método que confirma o empréstimo do objeto jButton_ok
        } 
    }//GEN-LAST:event_jPasswordField_senhaKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Senha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Senha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Senha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Senha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Senha().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ok;
    private javax.swing.JLabel jLabel_alertaSenha;
    private javax.swing.JLabel jLabel_confirma;
    private javax.swing.JLabel jLabel_senha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_senha;
    // End of variables declaration//GEN-END:variables
}