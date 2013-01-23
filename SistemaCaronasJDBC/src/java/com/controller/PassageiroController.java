/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.PassageiroDAO;
import com.model.entity.Passageiro;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
        this.passageiros = new PassageiroDAO().getPassageiros();
    }
    
    public String salvar() {
        if (this.getPassageiro().getIdPassageiro() == null) {
            new PassageiroDAO().inserir(this.getPassageiro());
        }
        else {
            new PassageiroDAO().altera(this.getPassageiro());
        }
        return "listar";
    }
    
    public String editar(Integer id) {
        this.setPassageiro(new PassageiroDAO().getById(id));
        return "formulario";
    }
    
    public String deletar(Integer id) {
        PassageiroDAO dao = new PassageiroDAO();
        this.passageiro = dao.getById(id);
        dao.remove(passageiro);
        this.setPassageiros(dao.getPassageiros());
        return "listar";
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

    /**
     * @return the passageiros
     */
    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    /**
     * @param passageiros the passageiros to set
     */
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
}
