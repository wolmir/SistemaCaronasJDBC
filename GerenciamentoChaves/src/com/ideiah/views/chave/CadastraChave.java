/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.chave;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author Bruna
 */
public class CadastraChave extends javax.swing.JFrame {

    /**
     * Creates new form CadastraChave
     */
    public CadastraChave() {
        initComponents();
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jSeparator_topo = new javax.swing.JSeparator();
        jPanel_menor = new javax.swing.JPanel();
        jLabel_cadNumero = new javax.swing.JLabel();
        jTF_cadNumChave = new javax.swing.JTextField();
        jButton_cadastrar = new javax.swing.JButton();
        jLabel_cadTamanhoChave = new javax.swing.JLabel();
        jComboBox_listaTamChaves = new javax.swing.JComboBox();
        jLabel_logoUnipampa = new javax.swing.JLabel();
        jLabel_alerta = new javax.swing.JLabel();
        jLabel_subtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel_titulo.setText("Sistema de empréstimo de chaves");

        jPanel_menor.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_menor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_cadNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cadNumero.setText("Número da chave:");

        jTF_cadNumChave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton_cadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ok.png"))); // NOI18N
        jButton_cadastrar.setText("Cadastrar");
        jButton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cadastrarActionPerformed(evt);
            }
        });

        jLabel_cadTamanhoChave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cadTamanhoChave.setText("Número da chave:");

        jComboBox_listaTamChaves.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_listaTamChaves.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Menor", "Maior" }));
        jComboBox_listaTamChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_listaTamChavesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_menorLayout = new javax.swing.GroupLayout(jPanel_menor);
        jPanel_menor.setLayout(jPanel_menorLayout);
        jPanel_menorLayout.setHorizontalGroup(
            jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_cadNumero)
                    .addComponent(jLabel_cadTamanhoChave))
                .addGap(75, 75, 75)
                .addGroup(jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTF_cadNumChave, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jComboBox_listaTamChaves, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel_menorLayout.setVerticalGroup(
            jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menorLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_cadNumChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cadNumero))
                .addGap(18, 18, 18)
                .addGroup(jPanel_menorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_cadTamanhoChave)
                    .addComponent(jComboBox_listaTamChaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButton_cadastrar)
                .addGap(54, 54, 54))
        );

        jLabel_logoUnipampa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/logo unipampa menor.jpg"))); // NOI18N
        jLabel_logoUnipampa.setMaximumSize(new java.awt.Dimension(448, 265));
        jLabel_logoUnipampa.setMinimumSize(new java.awt.Dimension(448, 265));

        jLabel_alerta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_alerta.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_alerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_alerta.setText("Número de chave incorreto");

        jLabel_subtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_subtitulo.setText("Armários da Biblioteca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addComponent(jLabel_logoUnipampa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel_alerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_menor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_logoUnipampa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel_titulo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_alerta)
                .addGap(18, 18, 18)
                .addComponent(jPanel_menor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_listaTamChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_listaTamChavesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_listaTamChavesActionPerformed

    private void jButton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cadastrarActionPerformed
        // TODO add your handling code here:
        //this.jButton_buscar.setBack
    }//GEN-LAST:event_jButton_cadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastraChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastraChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastraChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastraChave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraChave().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cadastrar;
    private javax.swing.JComboBox jComboBox_listaTamChaves;
    private javax.swing.JLabel jLabel_alerta;
    private javax.swing.JLabel jLabel_cadNumero;
    private javax.swing.JLabel jLabel_cadTamanhoChave;
    private javax.swing.JLabel jLabel_logoUnipampa;
    private javax.swing.JLabel jLabel_subtitulo;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPanel jPanel_menor;
    private javax.swing.JSeparator jSeparator_topo;
    private javax.swing.JTextField jTF_cadNumChave;
    // End of variables declaration//GEN-END:variables
}
