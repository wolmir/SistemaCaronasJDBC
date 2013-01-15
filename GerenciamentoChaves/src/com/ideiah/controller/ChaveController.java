/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.controller;

import com.ideiah.model.dao.ChaveDAO;
import com.ideiah.model.dao.EmprestimoDAO;
import com.ideiah.model.entity.Chave;
import com.ideiah.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ChaveController {
    
    private Chave chave;
    
    public ChaveController() {
        this.chave = new Chave();
    }
    
    public void salvar() {
        new ChaveDAO().adiciona(chave);
    }
    
    public void alterar() {
        new ChaveDAO().altera(chave);
    }
    
    public void deletar() {
        new ChaveDAO().remove(chave);
    }
    
    public List<Chave> getTodas() {
        return new ChaveDAO().getChaves();
    }
    
    public List<Emprestimo> getEmprestimos() {
        List<Emprestimo> resultado = new ArrayList<Emprestimo>();
        List<Emprestimo> emprestimos = new EmprestimoDAO().getEmprestimos();
        for (Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getChave().getId() == chave.getId()) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }
    
}
