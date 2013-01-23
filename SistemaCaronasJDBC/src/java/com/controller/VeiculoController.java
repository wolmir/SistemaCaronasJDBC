/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.TipoVeiculoDAO;
import com.model.dao.VeiculoDAO;
import com.model.entity.TipoVeiculo;
import com.model.entity.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name="veiculoController")
@RequestScoped
public class VeiculoController {
    private Veiculo veiculo;
    private List<Veiculo> veiculos;
    private List<String> veiculoss;
    private Integer id;
    private String tipoVeiculoSelect;
    private List<TipoVeiculo> tipos;
    
    public VeiculoController() {
        this.veiculo = new Veiculo();
        this.veiculos = new VeiculoDAO().getVeiculos();
        this.tipos = new TipoVeiculoDAO().getTiposVeiculos();
        this.veiculoss = new ArrayList<String>();
        for (TipoVeiculo veiculoi: this.tipos) {
            this.veiculoss.add(veiculoi.getTipoVeiculo());
        }
    }
    
    public String salvar() {
        if (this.getVeiculo().getId() == null) {
            TipoVeiculo tv = null;
            for (TipoVeiculo t: this.getTipos()) {
                if (t.getTipoVeiculo().equals(this.tipoVeiculoSelect)) {
                    tv = t;
                }
            }
            veiculo.setTipoVeiculo(tv);
            new VeiculoDAO().inserir(veiculo);
        }
        else {
            TipoVeiculo tv = null;
            for (TipoVeiculo t: this.getTipos()) {
                if (t.getTipoVeiculo().equals(this.tipoVeiculoSelect)) {
                    tv = t;
                }
            }
            veiculo.setTipoVeiculo(tv);
            new VeiculoDAO().altera(this.getVeiculo());
        }
        return "listar";
    }
    
    
    public String deletar(Integer id) {
        veiculo.setId(id);
        new VeiculoDAO().deletar(veiculo);
        return "listar";
    }
    
    public String editar(Integer id) throws Exception {
        veiculo = new VeiculoDAO().getById(id);
        //throw new Exception("" + veiculo.getPlaca());
        return "formulario";
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the veiculos
     */
    public List<Veiculo> getVeiculos() {
        //return new VeiculoDAO().getVeiculos();
        return veiculos;
    }

    /**
     * @param veiculos the veiculos to set
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
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
     * @return the tipoVeiculoSelect
     */
    public String getTipoVeiculoSelect() {
        return tipoVeiculoSelect;
    }

    /**
     * @param tipoVeiculoSelect the tipoVeiculoSelect to set
     */
    public void setTipoVeiculoSelect(String tipoVeiculoSelect) {
        this.tipoVeiculoSelect = tipoVeiculoSelect;
    }

    /**
     * @return the veiculoss
     */
    public List<String> getVeiculoss() {
        return veiculoss;
    }

    /**
     * @param veiculoss the veiculoss to set
     */
    public void setVeiculoss(List<String> veiculoss) {
        this.veiculoss = veiculoss;
    }

    /**
     * @return the tipos
     */
    public List<TipoVeiculo> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(List<TipoVeiculo> tipos) {
        this.tipos = tipos;
    }
    
}
