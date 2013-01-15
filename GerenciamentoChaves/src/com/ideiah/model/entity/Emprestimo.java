/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.entity;

import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Emprestimo {
    private Long id;
    private Aluno aluno;
    private Chave chave;
    private Calendar data_retirada;
    private Calendar data_devolucao;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * @return the data_retirada
     */
    public Calendar getData_retirada() {
        return data_retirada;
    }

    /**
     * @param data_retirada the data_retirada to set
     */
    public void setData_retirada(Calendar data_retirada) {
        this.data_retirada = data_retirada;
    }

    /**
     * @return the data_devolucao
     */
    public Calendar getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(Calendar data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    
}
