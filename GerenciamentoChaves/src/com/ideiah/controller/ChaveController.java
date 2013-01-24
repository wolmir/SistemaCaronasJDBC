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
    
    public String salvar() {
        List<Chave> chaves = this.getTodas();
        for (Chave chavei: chaves) {
            if (chavei.getNumero() == chave.getNumero()) {
                return "Esta chave já existe.";
            }
        }
        new ChaveDAO().adiciona(getChave());
        return null;
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
        List<Chave> processed = new ArrayList<Chave>();
        List<Chave> all = this.getTodas();
        outer:
        for (Chave chavei: chaves) {
            for (Chave chavei2: all) {
                if (chavei.getNumero() == chavei2.getNumero()) {
                    continue outer;
                }
            }
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
            if (chave.getTipo().equals("menor")) {
                resultado.add(chave);
            }
        }
        return resultado;
    }
    
    public List<Chave> getPequenasDisponiveis() {
        List<Chave> pequenas = this.getPequenas();
        List<Chave> disponiveis = new ArrayList<Chave>();
        for (Chave chavei: pequenas) {
            if (chavei.getDisponivel()) {
                disponiveis.add(chavei);
            }
        }
        return disponiveis;
    }
    
    
    public List<Chave> getGrandesDisponiveis() {
        List<Chave> pequenas = this.getGrandes();
        List<Chave> disponiveis = new ArrayList<Chave>();
        for (Chave chavei: pequenas) {
            if (chavei.getDisponivel()) {
                disponiveis.add(chavei);
            }
        }
        return disponiveis;
    }
    
    public List<Chave> getGrandes() {
        List<Chave> resultado = new ArrayList<Chave>();
        List<Chave> chaves = new ChaveDAO().getChaves();
        for (Chave chave : chaves) {
            if (chave.getTipo().equals("maior")) {
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
    
    public Chave getByNumero(Integer numero) {
        List<Chave> chaves = this.getTodas();
        for (Chave chavei: chaves) {
            if (chavei.getNumero() == numero) {
                return chavei;
            }
        }
        return null;
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
