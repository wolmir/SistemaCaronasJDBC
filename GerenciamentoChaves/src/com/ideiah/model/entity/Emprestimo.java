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
    private Calendar data;

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
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }
}
