/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.entity.TipoVeiculo;
import com.model.dao.TipoVeiculoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class TipoVeiculoController {
    private TipoVeiculo tipoVeiculo;
    private List<TipoVeiculo> tiposVeiculos;
    
    public TipoVeiculoController() {
        this.tipoVeiculo = new TipoVeiculo();
        this.tiposVeiculos = new TipoVeiculoDAO().getTiposVeiculos();
    }

    
    
    /**
     * @return the tipoVeiculo
     */
    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    /**
     * @param tipoVeiculo the tipoVeiculo to set
     */
    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    /**
     * @return the tiposVeiculos
     */
    public List<TipoVeiculo> getTiposVeiculos() {
        return tiposVeiculos;
    }

    /**
     * @param tiposVeiculos the tiposVeiculos to set
     */
    public void setTiposVeiculos(List<TipoVeiculo> tiposVeiculos) {
        this.tiposVeiculos = tiposVeiculos;
    }
    
    
}
