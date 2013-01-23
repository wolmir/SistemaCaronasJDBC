/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entity;

/**
 *
 * @author Usuario
 */
public class Passageiro {
    private Integer id_passageiro;
    private String rg;
    private String nome;
    private String telefone;

    /**
     * @return the id_passageiro
     */
    public Integer getId_passageiro() {
        return id_passageiro;
    }

    /**
     * @param id_passageiro the id_passageiro to set
     */
    public void setId_passageiro(Integer id_passageiro) {
        this.id_passageiro = id_passageiro;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
