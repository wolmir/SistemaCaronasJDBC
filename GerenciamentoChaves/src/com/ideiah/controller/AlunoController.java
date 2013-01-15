/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.controller;

import com.ideiah.model.dao.AlunoDAO;
import com.ideiah.model.dao.EmprestimoDAO;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AlunoController {
    
    private Aluno aluno;
    
    public AlunoController() {
        this.aluno = new Aluno();
    }
    
    public List<Aluno> getTodos() {
        return new AlunoDAO().getAlunos();
    }
    
    public List<Aluno> pesquisarPorNome(String nome) {
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        List<Aluno> resultado = new ArrayList<Aluno>();
        for (Aluno aluno: alunos) {
            if (aluno.getNome().equals(nome)) {
                resultado.add(aluno);
            }
        }
        
        return resultado;
    }
    
    public List<Aluno> pesquisarPorEmail(String email) {
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        List<Aluno> resultado = new ArrayList<Aluno>();
        for (Aluno aluno: alunos) {
            if (aluno.getEmail().equals(email)) {
                resultado.add(aluno);
            }
        }
        
        return resultado;
    }
    
    public List<Aluno> pesquisarPorCurso(String curso) {
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        List<Aluno> resultado = new ArrayList<Aluno>();
        for (Aluno aluno: alunos) {
            if (aluno.getCurso().equals(curso)) {
                resultado.add(aluno);
            }
        }
        
        return resultado;
    }
    
    public List<Emprestimo> getEmprestimos() {
        List<Emprestimo> resultado = new ArrayList<Emprestimo>();
        List<Emprestimo> emprestimos = new EmprestimoDAO().getEmprestimos();
        for (Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getAluno().getId() == this.aluno.getId()) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }
    
    /*public List<Aluno> getAtrasados() {
        List<Aluno> resultado = new ArrayList<Aluno>();
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        for (Aluno aluno: alunos) {
            AlunoController controller = new AlunoController();
            controller.setAluno(aluno);
            List<Emprestimo> emprestimos = controller.getEmprestimos();
            for (Emprestimo emprestimo: emprestimos) {
                if (emprestimo.getData_retirada().before(Calendar.getInstance().))
            }
        }
        return resultado;
    }*/
   

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
