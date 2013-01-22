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
        new ChaveDAO().adiciona(getChave());
    }
    
    public void alterar() {
        new ChaveDAO().altera(getChave());
    }
    
    public void deletar() {
        new ChaveDAO().remove(getChave());
    }
    
    public List<Chave> getTodas() {
        return new ChaveDAO().getChaves();
    }
    
    public void salvarLote(List<Chave> chaves) {
        ChaveDAO cd = new ChaveDAO();
        for (Chave chavei: chaves) {
            cd.adiciona(chavei);
        }
    }
    
    public List<Emprestimo> getEmprestimos() {
        List<Emprestimo> resultado = new ArrayList<Emprestimo>();
        List<Emprestimo> emprestimos = new EmprestimoDAO().getEmprestimos();
        for (Emprestimo emprestimo: emprestimos) {
            if (emprestimo.getChave().getId() == getChave().getId()) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }
    
    public List<Chave> getSemEmprestimo() {
        List<Chave> resultado = new ArrayList<Chave>();
        List<Chave> chaves = new ChaveDAO().getChaves();
        for (Chave chave : chaves) {
            ChaveController cc = new ChaveController();
            cc.setChave(chave);
            boolean semEmprestimo = true;
            List<Emprestimo> emprestimos = cc.getEmprestimos();
            for (Emprestimo emprestimo: emprestimos) {
                if (emprestimo.getData_devolucao() == null) {
                    semEmprestimo = false;
                    break;
                }
            }
            
            if (semEmprestimo) {
                resultado.add(chave);
            }
        }
        return resultado;
    }
    
    public List<Chave> getPequenas() {
        List<Chave> resultado = new ArrayList<Chave>();
        List<Chave> chaves = new ChaveDAO().getChaves();
        for (Chave chave : chaves) {
            if (chave.getTipo().equals("pequena")) {
                resultado.add(chave);
            }
        }
        return resultado;
    }
    
    public List<Chave> getGrandes() {
        List<Chave> resultado = new ArrayList<Chave>();
        List<Chave> chaves = new ChaveDAO().getChaves();
        for (Chave chave : chaves) {
            if (chave.getTipo().equals("grande")) {
                resultado.add(chave);
            }
        }
        return resultado;
    }
    
    public List<Chave> getDisponiveis() {
        List<Chave> disponiveis = new ArrayList<Chave>();
        List<Chave> chaves = new ChaveDAO().getChaves();
        for (Chave chave: chaves) {
            if (chave.getDisponivel()) {
                disponiveis.add(chave);
            }
        }
        return disponiveis;
    }

    /**
     * @return the chave
     */
    public Chave getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(Chave chave) {
        this.chave = chave;
    }
    
}
