/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.emprestimo;

import com.ideiah.controller.AlunoController;
import com.ideiah.controller.EmprestimoController;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Emprestimo;
import com.ideiah.views.login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Bruna
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    PainelEmprestimoDevolucao painelEmprestimoDevolucao;
    
  
    public TelaPrincipal() {
        initComponents();
//        this.setResizable(true);
        //this.jButton_EmprestimoDevolucao.setVisible(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
          try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        
        //this.jButton_EmprestimoDevolucao.setVisible(false);
    }
    
    public void verificaBotoes(java.awt.event.ActionEvent evt){
        
        for(int i = 0; i < this.jPanel_menor1.getComponentCount();i++){

            if(this.jPanel_menor1.getComponent(i) instanceof JButton){
                if(((JButton) this.jPanel_menor1.getComponent(i)).getText().equals(evt.getActionCommand()))
                     this.jPanel_menor1.getComponent(i).setEnabled(false);
                else
                    this.jPanel_menor1.getComponent(i).setEnabled(true);  
            }
        }
        
        this.jPanel_conteudo.updateUI();
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
        jPanel_menor1 = new javax.swing.JPanel();
        jButton_CadastrarChave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_ListaAluno = new javax.swing.JButton();
        jLabel_dataAtual = new javax.swing.JLabel();
        jLabel_dataBuscada = new javax.swing.JLabel();
        jLabel_horaBuscada = new javax.swing.JLabel();
        jLabel_horaAtual = new javax.swing.JLabel();
        jLabel_NomeUser = new javax.swing.JLabel();
        jButton_EmprestimoDevolucao = new javax.swing.JButton();
        jButton_Logout = new javax.swing.JButton();
        jButton_CadastroChaveLote = new javax.swing.JButton();
        jButton_ListaChave = new javax.swing.JButton();
        jLabel_logoUnipampa = new javax.swing.JLabel();
        jPanel_conteudo = new javax.swing.JPanel();
        jLabel_subtitulo = new javax.swing.JLabel();
        jSeparator_topo = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(876, 710));
        setResizable(false);

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_titulo.setText("Sistema de empréstimo de chaves");

        jPanel_menor1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_menor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_CadastrarChave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_CadastrarChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/key.png"))); // NOI18N
        jButton_CadastrarChave.setText("Cadastrar Chave");
        jButton_CadastrarChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastrarChaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bem vindo (a) ");

        jButton_ListaAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_ListaAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ui-list-box-blue.png"))); // NOI18N
        jButton_ListaAluno.setText("Lista Aluno");
        jButton_ListaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListaAlunoActionPerformed(evt);
            }
        });

        jLabel_dataAtual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_dataAtual.setText("Data atual:");

        jLabel_dataBuscada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_dataBuscada.setText("10/01/2013");

        jLabel_horaBuscada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_horaBuscada.setText("15:37");

        jLabel_horaAtual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_horaAtual.setText("Hora atual:");

        jLabel_NomeUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_NomeUser.setText("Nome do Usuario");

        jButton_EmprestimoDevolucao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_EmprestimoDevolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/exchange.png"))); // NOI18N
        jButton_EmprestimoDevolucao.setText("Emprestimo e Devolução");
        jButton_EmprestimoDevolucao.setOpaque(false);
        jButton_EmprestimoDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EmprestimoDevolucaoActionPerformed(evt);
            }
        });

        jButton_Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/gnome-logout.png"))); // NOI18N
        jButton_Logout.setText("Sair");
        jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogoutActionPerformed(evt);
            }
        });

        jButton_CadastroChaveLote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_CadastroChaveLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/keys.png"))); // NOI18N
        jButton_CadastroChaveLote.setText("Cadastrar Chave em Lote");
        jButton_CadastroChaveLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastroChaveLoteActionPerformed(evt);
            }
        });

        jButton_ListaChave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_ListaChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ui-menu-blue.png"))); // NOI18N
        jButton_ListaChave.setText("Lista Chave");
        jButton_ListaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListaChaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_menor1Layout = new javax.swing.GroupLayout(jPanel_menor1);
        jPanel_menor1.setLayout(jPanel_menor1Layout);
        jPanel_menor1Layout.setHorizontalGroup(
            jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menor1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_menor1Layout.createSequentialGroup()
                        .addComponent(jLabel_dataAtual)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel_dataBuscada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_menor1Layout.createSequentialGroup()
                        .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_menor1Layout.createSequentialGroup()
                                .addComponent(jLabel_horaAtual)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_horaBuscada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_menor1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_NomeUser)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menor1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menor1Layout.createSequentialGroup()
                        .addComponent(jButton_Logout)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menor1Layout.createSequentialGroup()
                        .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton_ListaAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_CadastrarChave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_EmprestimoDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_CadastroChaveLote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_ListaChave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel_menor1Layout.setVerticalGroup(
            jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menor1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_NomeUser))
                .addGap(77, 77, 77)
                .addComponent(jButton_EmprestimoDevolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_CadastrarChave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_CadastroChaveLote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ListaAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ListaChave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_dataAtual)
                    .addComponent(jLabel_dataBuscada))
                .addGap(18, 18, 18)
                .addGroup(jPanel_menor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_horaAtual)
                    .addComponent(jLabel_horaBuscada))
                .addGap(27, 27, 27)
                .addComponent(jButton_Logout)
                .addGap(19, 19, 19))
        );

        jLabel_logoUnipampa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/logo unipampa menor.jpg"))); // NOI18N
        jLabel_logoUnipampa.setMaximumSize(new java.awt.Dimension(448, 265));
        jLabel_logoUnipampa.setMinimumSize(new java.awt.Dimension(448, 265));

        jPanel_conteudo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_conteudo.setPreferredSize(new java.awt.Dimension(609, 527));

        javax.swing.GroupLayout jPanel_conteudoLayout = new javax.swing.GroupLayout(jPanel_conteudo);
        jPanel_conteudo.setLayout(jPanel_conteudoLayout);
        jPanel_conteudoLayout.setHorizontalGroup(
            jPanel_conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel_conteudoLayout.setVerticalGroup(
            jPanel_conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        jLabel_subtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_subtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_subtitulo.setText("Armários da Biblioteca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_subtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel_logoUnipampa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_menor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_conteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator_topo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_conteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_menor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(575, 575, 575))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ListaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListaAlunoActionPerformed
        ListaAlunos listaAlunos = new ListaAlunos();
        
        criaPainel(listaAlunos, evt);
    }//GEN-LAST:event_jButton_ListaAlunoActionPerformed

    private void jButton_EmprestimoDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EmprestimoDevolucaoActionPerformed
        PainelEmprestimoDevolucao painelEmprestimoDevolucao = new PainelEmprestimoDevolucao();
        
        criaPainel(painelEmprestimoDevolucao, evt);
    }//GEN-LAST:event_jButton_EmprestimoDevolucaoActionPerformed

    private void jButton_CadastrarChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastrarChaveActionPerformed
        PainelCadastroChave painelCadastroChave = new PainelCadastroChave();
        
        criaPainel(painelCadastroChave, evt);
    }//GEN-LAST:event_jButton_CadastrarChaveActionPerformed

    private void jButton_CadastroChaveLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastroChaveLoteActionPerformed
        CadastroChaveLote painelCadastroChaveLote = new CadastroChaveLote();
        
        criaPainel(painelCadastroChaveLote, evt);
    }//GEN-LAST:event_jButton_CadastroChaveLoteActionPerformed

    private void jButton_ListaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListaChaveActionPerformed
        ListaChaves listaChave = new ListaChaves();
        
        criaPainel(listaChave, evt);
        
    }//GEN-LAST:event_jButton_ListaChaveActionPerformed

    private void criaPainel(Component painel, java.awt.event.ActionEvent evt){
        this.jPanel_conteudo.setLayout(new BorderLayout());
        this.jPanel_conteudo.removeAll();
        this.jPanel_conteudo.add(painel);
        
        verificaBotoes(evt);
    }
    
    private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogoutActionPerformed
        
        Login login = new Login();
        
        criaPainel(login, evt);
        
        this.jPanel_menor1.setVisible(false);
        this.jPanel_menor1.updateUI();
        
    }//GEN-LAST:event_jButton_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CadastrarChave;
    private javax.swing.JButton jButton_CadastroChaveLote;
    private javax.swing.JButton jButton_EmprestimoDevolucao;
    private javax.swing.JButton jButton_ListaAluno;
    private javax.swing.JButton jButton_ListaChave;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_NomeUser;
    private javax.swing.JLabel jLabel_dataAtual;
    private javax.swing.JLabel jLabel_dataBuscada;
    private javax.swing.JLabel jLabel_horaAtual;
    private javax.swing.JLabel jLabel_horaBuscada;
    private javax.swing.JLabel jLabel_logoUnipampa;
    private javax.swing.JLabel jLabel_subtitulo;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JPanel jPanel_conteudo;
    private javax.swing.JPanel jPanel_menor1;
    private javax.swing.JSeparator jSeparator_topo;
    // End of variables declaration//GEN-END:variables
}
