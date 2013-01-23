/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.PassageiroDAO;
import com.model.entity.Passageiro;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class PassageiroController {
    private Passageiro passageiro;
    private List<Passageiro> passageiros;
    private Integer id;
    
    public PassageiroController() {
        this.passageiro = new Passageiro();
    }
    
    public String salvar() {
        if (this.getPassageiro().getId_passageiro() == null) {
            new PassageiroDAO().inserir(this.getPassageiro());
        }
        else {
            new PassageiroDAO().altera(this.getPassageiro());
        }
        return "listar";
    }
    
    public String editar() {
        this.setPassageiro(new PassageiroDAO().getById(this.getId()));
        return "formulario";
    }
    
    public String deletar() {
        PassageiroDAO dao = new PassageiroDAO();
        this.passageiro = dao.getById(id);
        dao.remove(passageiro);
        this.passageiros = dao.getPassageiros();
        return "listar";
    }
    
    @PostConstruct
    public void listar() {
        this.passageiros = new PassageiroDAO().getPassageiros();
    }

    /**
     * @return the passageiro
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * @param passageiro the passageiro to set
     */
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
