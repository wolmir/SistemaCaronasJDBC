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
import java.util.Date;
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
    
    public List<Aluno> pesquisarPorMatricula(Integer matricula) {
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        List<Aluno> resultado = new ArrayList<Aluno>();
        for (Aluno aluno: alunos) {
            if (aluno.getMatricula() == matricula) {
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
    
    public List<Aluno> getAtrasados() {
        List<Aluno> resultado = new ArrayList<Aluno>();
        List<Aluno> alunos = new AlunoDAO().getAlunos();
        for (Aluno aluno: alunos) {
            AlunoController controller = new AlunoController();
            controller.setAluno(aluno);
            List<Emprestimo> emprestimos = controller.getEmprestimos();
            for (Emprestimo emprestimo: emprestimos) {
                if (this.testaDataRetirada(emprestimo.getData_retirada()) && emprestimo.getData_devolucao() == null) {
                    resultado.add(aluno);
                }
            }
        }
        return resultado;
    }
    
    
    public Emprestimo getEmprestimoAberto() {
        List<Emprestimo> emprestimos = this.getEmprestimos();
        for (Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getData_devolucao() == null) {
                return emprestimo;
            }
        }
        return null;
    }
    
    private boolean testaDataRetirada(Calendar data) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        
        if ((data.get(Calendar.DAY_OF_MONTH) < day) || (data.get(Calendar.MONTH) < month)) {
            return true;
        }
        return false;
    }
   

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
