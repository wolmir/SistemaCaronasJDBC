/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.controller;

import com.ideiah.model.dao.EmprestimoDAO;
import com.ideiah.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmprestimoController {
    private Emprestimo emprestimo;
    
    public String salvar() {
        List<Emprestimo> emprestimos = this.getAbertos();
        for (Emprestimo emprestimoi: emprestimos) {
            if (emprestimoi.getAluno().getId() == this.emprestimo.getAluno().getId()) {
                
                return "Este aluno já possui uma chave.";
            }
        }
        new EmprestimoDAO().adiciona(emprestimo);
        return null;
    }
    
    public void alterar() {
        new EmprestimoDAO().altera(emprestimo);
    }
    
    public void deletar() {
        new EmprestimoDAO().remove(emprestimo);
    }
    
    public List<Emprestimo> getEmprestimos() {
        return new EmprestimoDAO().getEmprestimos();
    }
    
    public List<Emprestimo> getAbertos() {
        List<Emprestimo> abertos = new ArrayList<Emprestimo>();
        List<Emprestimo> emprestimos = this.getEmprestimos();
        for (Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getData_devolucao() == null) {
                abertos.add(emprestimo);
            }
        }
        return abertos;
    }

    /**
     * @return the emprestimo
     */
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo the emprestimo to set
     */
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
}
