/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.VeiculoDAO;
import com.model.entity.TipoVeiculo;
import com.model.entity.Veiculo;
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
    private Integer id;
    private TipoVeiculo tipoVeiculoSelect;
    
    public VeiculoController() {
        this.veiculo = new Veiculo();
        this.veiculos = new VeiculoDAO().getVeiculos();
    }
    
    public String salvar() {
        if (this.getVeiculo().getId() == null) {
            new VeiculoDAO().inserir(veiculo);
        }
        else {
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
    public TipoVeiculo getTipoVeiculoSelect() {
        return tipoVeiculoSelect;
    }

    /**
     * @param tipoVeiculoSelect the tipoVeiculoSelect to set
     */
    public void setTipoVeiculoSelect(TipoVeiculo tipoVeiculoSelect) {
        this.tipoVeiculoSelect = tipoVeiculoSelect;
    }
    
}
