/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.emprestimo;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Kooler
 */
public class ListaAlunos extends javax.swing.JFrame {

    /**
     * Creates new form ListaAlunos
     */
    public ListaAlunos() {
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

        jSeparator_topo = new javax.swing.JSeparator();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_logoUnipampa = new javax.swing.JLabel();
        jLabel_titulo2 = new javax.swing.JLabel();
        jPanel_meio = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_listaAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_titulo.setText("Lista de Alunos");

        jLabel_logoUnipampa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/logo unipampa menor.jpg"))); // NOI18N
        jLabel_logoUnipampa.setMaximumSize(new java.awt.Dimension(448, 265));
        jLabel_logoUnipampa.setMinimumSize(new java.awt.Dimension(448, 265));

        jLabel_titulo2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_titulo2.setText("com chaves esprestadas");

        jPanel_meio.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_meio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 300));

        jTable_listaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número da chave", "Nome", "Matrícula", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_listaAlunos);
        jTable_listaAlunos.getColumnModel().getColumn(0).setResizable(false);
        jTable_listaAlunos.getColumnModel().getColumn(1).setResizable(false);
        jTable_listaAlunos.getColumnModel().getColumn(2).setResizable(false);
        jTable_listaAlunos.getColumnModel().getColumn(3).setResizable(false);

        javax.swing.GroupLayout jPanel_meioLayout = new javax.swing.GroupLayout(jPanel_meio);
        jPanel_meio.setLayout(jPanel_meioLayout);
        jPanel_meioLayout.setHorizontalGroup(
            jPanel_meioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_meioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel_meioLayout.setVerticalGroup(
            jPanel_meioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_meioLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator_topo)
                            .addComponent(jPanel_meio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_titulo)
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_titulo2)
                                .addGap(71, 71, 71)))
                        .addComponent(jLabel_logoUnipampa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel_logoUnipampa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_titulo2)
                        .addGap(26, 26, 26)))
                .addComponent(jSeparator_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_meio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAlunos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_logoUnipampa;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_titulo2;
    private javax.swing.JPanel jPanel_meio;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator_topo;
    private javax.swing.JTable jTable_listaAlunos;
    // End of variables declaration//GEN-END:variables
}
