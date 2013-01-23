/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.emprestimo;

import com.ideiah.controller.AlunoController;
import com.ideiah.controller.ChaveController;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Chave;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Kooler
 */
public class PainelEmprestimoDevolucao extends javax.swing.JPanel {

    /**
     * Creates new form PainelEmprestimoDevoolucao
     */
    private String matricula;
    private AlunoController alunoController;
    private Aluno aluno;
     
    public PainelEmprestimoDevolucao() {
        System.out.println("Bunda");
        initComponents();
        carregarAsCoisasQuePrecisamSerCarregadas();
        this.jTF_matriculaBuscarE.grabFocus();
    }

 

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void teste(){
    
    }
    private Aluno buscarAluno(){
       alunoController = new AlunoController();
       aluno  = alunoController.pesquisarPorMatricula(this.getMatricula());
       return aluno;
    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_matriculaBuscarE = new javax.swing.JLabel();
        jTF_matriculaBuscarE = new javax.swing.JTextField();
        jButton_buscarE = new javax.swing.JButton();
        jLabel_nomeE = new javax.swing.JLabel();
        jLabel_cursoE = new javax.swing.JLabel();
        jLabel_nomeBuscadoE = new javax.swing.JLabel();
        jLabel_cursoBuscadoE = new javax.swing.JLabel();
        jLabel_numChaveE = new javax.swing.JLabel();
        jComboBox_listaNumChavesMenores = new javax.swing.JComboBox();
        jButton_realizarEmprestimo = new javax.swing.JButton();
        jComboBox_listaNumChavesMaiores = new javax.swing.JComboBox();
        jRadioButton_armarioMaior = new javax.swing.JRadioButton();
        jRadioButton_armarioMenor = new javax.swing.JRadioButton();
        jLabel_tituloEmprestimo = new javax.swing.JLabel();
        jSeparator_meio = new javax.swing.JSeparator();
        jLabel_alertaEmprestimo = new javax.swing.JLabel();
        jLabel4_tituloDevolucao = new javax.swing.JLabel();
        jLabel_matriculaBuscarD = new javax.swing.JLabel();
        jTF_matriculaBuscarD = new javax.swing.JTextField();
        jButton_buscarD = new javax.swing.JButton();
        jLabel_alertaDevolucao = new javax.swing.JLabel();
        jLabel_cursoBuscadoD = new javax.swing.JLabel();
        jLabel_nomeBuscadoD = new javax.swing.JLabel();
        jLabel_nomeD = new javax.swing.JLabel();
        jLabel_cursoD = new javax.swing.JLabel();
        jLabel_numChaveD = new javax.swing.JLabel();
        jLabel_ChaveBuscadaD = new javax.swing.JLabel();
        jButton_realizarDevolucao = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(609, 527));

        jLabel_matriculaBuscarE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_matriculaBuscarE.setText("Matrícula:");

        jTF_matriculaBuscarE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_matriculaBuscarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_matriculaBuscarEActionPerformed(evt);
            }
        });
        jTF_matriculaBuscarE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_matriculaBuscarEKeyPressed(evt);
            }
        });

        jButton_buscarE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_buscarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/Search.png"))); // NOI18N
        jButton_buscarE.setText("Buscar");
        jButton_buscarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarEActionPerformed(evt);
            }
        });

        jLabel_nomeE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_nomeE.setText("Nome:");

        jLabel_cursoE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cursoE.setText("Curso:");

        jLabel_nomeBuscadoE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_nomeBuscadoE.setText("Fulano de tal");

        jLabel_cursoBuscadoE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cursoBuscadoE.setText("Engenharia de Telecomunicações");

        jLabel_numChaveE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_numChaveE.setText("Número da chave:");

        jComboBox_listaNumChavesMenores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_listaNumChavesMenores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        jComboBox_listaNumChavesMenores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_listaNumChavesMenoresActionPerformed(evt);
            }
        });

        jButton_realizarEmprestimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_realizarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ok.png"))); // NOI18N
        jButton_realizarEmprestimo.setText("Realizar Empréstimo");
        jButton_realizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_realizarEmprestimoActionPerformed(evt);
            }
        });

        jComboBox_listaNumChavesMaiores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_listaNumChavesMaiores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61" }));
        jComboBox_listaNumChavesMaiores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_listaNumChavesMaioresActionPerformed(evt);
            }
        });

        jRadioButton_armarioMaior.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton_armarioMaior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton_armarioMaior.setText("Armario maior:");
        jRadioButton_armarioMaior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_armarioMaiorActionPerformed(evt);
            }
        });

        jRadioButton_armarioMenor.setBackground(new java.awt.Color(204, 255, 204));
        jRadioButton_armarioMenor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton_armarioMenor.setText("Armário menor:");
        jRadioButton_armarioMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_armarioMenorActionPerformed(evt);
            }
        });

        jLabel_tituloEmprestimo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_tituloEmprestimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_tituloEmprestimo.setText("Empréstimo");

        jLabel_alertaEmprestimo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_alertaEmprestimo.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_alertaEmprestimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_alertaEmprestimo.setText("Aluno não encontrado");

        jLabel4_tituloDevolucao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4_tituloDevolucao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_tituloDevolucao.setText("Devolução");

        jLabel_matriculaBuscarD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_matriculaBuscarD.setText("Matrícula:");

        jTF_matriculaBuscarD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_matriculaBuscarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_matriculaBuscarDActionPerformed(evt);
            }
        });

        jButton_buscarD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_buscarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/Search.png"))); // NOI18N
        jButton_buscarD.setText("Buscar");
        jButton_buscarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarDActionPerformed(evt);
            }
        });

        jLabel_alertaDevolucao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_alertaDevolucao.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_alertaDevolucao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_alertaDevolucao.setText("Aluno não encontrado");

        jLabel_cursoBuscadoD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cursoBuscadoD.setText("Engenharia de Telecomunicações");

        jLabel_nomeBuscadoD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_nomeBuscadoD.setText("Fulano de tal");

        jLabel_nomeD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_nomeD.setText("Nome:");

        jLabel_cursoD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_cursoD.setText("Curso:");

        jLabel_numChaveD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_numChaveD.setText("Número da chave:");

        jLabel_ChaveBuscadaD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_ChaveBuscadaD.setText("23");

        jButton_realizarDevolucao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_realizarDevolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ideiah/views/imagens/ok.png"))); // NOI18N
        jButton_realizarDevolucao.setText("Realizar Devolução");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jButton_realizarDevolucao)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel_cursoBuscadoD, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_matriculaBuscarD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTF_matriculaBuscarD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_buscarD)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_alertaDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_nomeD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_nomeBuscadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel_cursoD))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_numChaveD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_ChaveBuscadaD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton_armarioMenor)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton_armarioMaior)
                                        .addGap(24, 24, 24)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_listaNumChavesMenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox_listaNumChavesMaiores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_realizarEmprestimo))))
                            .addComponent(jLabel_numChaveE))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_nomeE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_nomeBuscadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel_cursoBuscadoE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_cursoE)
                                .addContainerGap(47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_matriculaBuscarE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTF_matriculaBuscarE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_buscarE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_alertaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator_meio)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_tituloEmprestimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4_tituloDevolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel_tituloEmprestimo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_buscarE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTF_matriculaBuscarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_matriculaBuscarE)
                        .addComponent(jLabel_alertaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nomeE)
                    .addComponent(jLabel_nomeBuscadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cursoE)
                    .addComponent(jLabel_cursoBuscadoE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_numChaveE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton_armarioMenor)
                            .addComponent(jComboBox_listaNumChavesMenores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_listaNumChavesMaiores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton_armarioMaior)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton_realizarEmprestimo)))
                .addGap(43, 43, 43)
                .addComponent(jSeparator_meio, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4_tituloDevolucao)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_buscarD)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTF_matriculaBuscarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_matriculaBuscarD)
                        .addComponent(jLabel_alertaDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nomeD)
                    .addComponent(jLabel_nomeBuscadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cursoD)
                    .addComponent(jLabel_cursoBuscadoD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_numChaveD)
                    .addComponent(jLabel_ChaveBuscadaD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton_realizarDevolucao)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_matriculaBuscarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_matriculaBuscarEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_matriculaBuscarEActionPerformed

    private void jTF_matriculaBuscarEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_matriculaBuscarEKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
           this.setMatricula(this.jTF_matriculaBuscarE.getText());
           aluno = this.buscarAluno();
           this.jLabel_nomeBuscadoE.setText(aluno.getNome());
           this.jLabel_cursoBuscadoE.setText(aluno.getCurso());
        }

    }//GEN-LAST:event_jTF_matriculaBuscarEKeyPressed

    private void jButton_buscarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarEActionPerformed
        // TODO add your handling code here:
        //this.jButton_buscar.setBack
        this.setMatricula(this.jTF_matriculaBuscarE.getText());
        aluno = this.buscarAluno();
        this.jLabel_nomeBuscadoE.setText(aluno.getNome());
        this.jLabel_cursoBuscadoE.setText(aluno.getCurso());
    }//GEN-LAST:event_jButton_buscarEActionPerformed

    private void jComboBox_listaNumChavesMenoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_listaNumChavesMenoresActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox_listaNumChavesMenoresActionPerformed

    private void jButton_realizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_realizarEmprestimoActionPerformed
        Aluno aluno;
        AlunoController alunoController = new AlunoController();
        aluno = alunoController.pesquisarPorMatricula(matricula);
        Chave chave;
        if (this.jRadioButton_armarioMaior.getSelectedObjects() != null) {
            chave = new ChaveController().getByNumero((Integer)
                    this.jComboBox_listaNumChavesMaiores.getItemAt(
                    this.jComboBox_listaNumChavesMaiores.getSelectedIndex()));
        }
        else {
            chave = new ChaveController().getByNumero((Integer)
                    this.jComboBox_listaNumChavesMenores.getItemAt(
                    this.jComboBox_listaNumChavesMenores.getSelectedIndex()));
        }
        Senha senha =new Senha(this.jTF_matriculaBuscarE.getText(),aluno, chave);
        senha.setVisible(true);
        
    }//GEN-LAST:event_jButton_realizarEmprestimoActionPerformed

    private void jComboBox_listaNumChavesMaioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_listaNumChavesMaioresActionPerformed

        
    }//GEN-LAST:event_jComboBox_listaNumChavesMaioresActionPerformed

    private void jRadioButton_armarioMaiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_armarioMaiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_armarioMaiorActionPerformed

    private void jRadioButton_armarioMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_armarioMenorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_armarioMenorActionPerformed

    private void jTF_matriculaBuscarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_matriculaBuscarDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_matriculaBuscarDActionPerformed

    private void jButton_buscarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_buscarDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscarD;
    private javax.swing.JButton jButton_buscarE;
    private javax.swing.JButton jButton_realizarDevolucao;
    private javax.swing.JButton jButton_realizarEmprestimo;
    private javax.swing.JComboBox jComboBox_listaNumChavesMaiores;
    private javax.swing.JComboBox jComboBox_listaNumChavesMenores;
    private javax.swing.JLabel jLabel4_tituloDevolucao;
    private javax.swing.JLabel jLabel_ChaveBuscadaD;
    private javax.swing.JLabel jLabel_alertaDevolucao;
    private javax.swing.JLabel jLabel_alertaEmprestimo;
    private javax.swing.JLabel jLabel_cursoBuscadoD;
    private javax.swing.JLabel jLabel_cursoBuscadoE;
    private javax.swing.JLabel jLabel_cursoD;
    private javax.swing.JLabel jLabel_cursoE;
    private javax.swing.JLabel jLabel_matriculaBuscarD;
    private javax.swing.JLabel jLabel_matriculaBuscarE;
    private javax.swing.JLabel jLabel_nomeBuscadoD;
    private javax.swing.JLabel jLabel_nomeBuscadoE;
    private javax.swing.JLabel jLabel_nomeD;
    private javax.swing.JLabel jLabel_nomeE;
    private javax.swing.JLabel jLabel_numChaveD;
    private javax.swing.JLabel jLabel_numChaveE;
    private javax.swing.JLabel jLabel_tituloEmprestimo;
    private javax.swing.JRadioButton jRadioButton_armarioMaior;
    private javax.swing.JRadioButton jRadioButton_armarioMenor;
    private javax.swing.JSeparator jSeparator_meio;
    private javax.swing.JTextField jTF_matriculaBuscarD;
    private javax.swing.JTextField jTF_matriculaBuscarE;
    // End of variables declaration//GEN-END:variables

    private void carregarAsCoisasQuePrecisamSerCarregadas() {
        List<Chave> chaves = new ChaveController().getPequenas();
        Vector<Integer> chaves2 = new Vector<Integer>();
        for (Chave chave: chaves) {
            chaves2.add(chave.getNumero());
        }
        DefaultComboBoxModel dcm = new DefaultComboBoxModel(chaves2);
        this.jComboBox_listaNumChavesMenores.setModel(dcm);
        
        List<Chave> chaves3 = new ChaveController().getGrandes();
        Vector<Integer> chaves4 = new Vector<Integer>();
        for (Chave chave: chaves) {
            chaves2.add(chave.getNumero());
        }
        DefaultComboBoxModel dcm2 = new DefaultComboBoxModel(chaves4);
        this.jComboBox_listaNumChavesMaiores.setModel(dcm2);
    }
}
