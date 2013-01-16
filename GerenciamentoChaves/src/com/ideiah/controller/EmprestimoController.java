/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.controller;

import com.ideiah.model.dao.EmprestimoDAO;
import com.ideiah.model.entity.Emprestimo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmprestimoController {
    private Emprestimo emprestimo;
    
    public void salvar() {
        new EmprestimoDAO().adiciona(emprestimo);
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
