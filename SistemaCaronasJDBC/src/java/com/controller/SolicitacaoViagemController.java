/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.SolicitacaoViagemDAO;
import com.model.dao.UsuarioDAO;
import com.model.dao.VeiculoDAO;
import com.model.entity.SolicitacaoViagem;
import com.model.entity.Usuario;
import com.model.entity.Veiculo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class SolicitacaoViagemController {
    private SolicitacaoViagem solicitacaoviagem;
    private List<SolicitacaoViagem> viagens;
    private Veiculo veiculoSelect;
    private List<Veiculo> veiculos;
    private Usuario usuarioSolSelect;
    private Usuario usuarioAutSelect;
    private List<Usuario> usuarios;
    
    public SolicitacaoViagemController() {
        this.solicitacaoviagem = new SolicitacaoViagem();
        this.viagens = new SolicitacaoViagemDAO().getSolicitacoes();
        this.veiculos = new VeiculoDAO().getVeiculos();
        this.usuarios = new UsuarioDAO().getUsuarios();
    }

    /**
     * @return the solicitacaoviagem
     */
    public SolicitacaoViagem getSolicitacaoviagem() {
        return solicitacaoviagem;
    }

    /**
     * @param solicitacaoviagem the solicitacaoviagem to set
     */
    public void setSolicitacaoviagem(SolicitacaoViagem solicitacaoviagem) {
        this.solicitacaoviagem = solicitacaoviagem;
    }

    /**
     * @return the viagens
     */
    public List<SolicitacaoViagem> getViagens() {
        return viagens;
    }

    /**
     * @param viagens the viagens to set
     */
    public void setViagens(List<SolicitacaoViagem> viagens) {
        this.viagens = viagens;
    }

    /**
     * @return the veiculoSelect
     */
    public Veiculo getVeiculoSelect() {
        return veiculoSelect;
    }

    /**
     * @param veiculoSelect the veiculoSelect to set
     */
    public void setVeiculoSelect(Veiculo veiculoSelect) {
        this.veiculoSelect = veiculoSelect;
    }

    /**
     * @return the veiculos
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * @param veiculos the veiculos to set
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    /**
     * @return the usuarioSolSelect
     */
    public Usuario getUsuarioSolSelect() {
        return usuarioSolSelect;
    }

    /**
     * @param usuarioSolSelect the usuarioSolSelect to set
     */
    public void setUsuarioSolSelect(Usuario usuarioSolSelect) {
        this.usuarioSolSelect = usuarioSolSelect;
    }

    /**
     * @return the usuarioAutSelect
     */
    public Usuario getUsuarioAutSelect() {
        return usuarioAutSelect;
    }

    /**
     * @param usuarioAutSelect the usuarioAutSelect to set
     */
    public void setUsuarioAutSelect(Usuario usuarioAutSelect) {
        this.usuarioAutSelect = usuarioAutSelect;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
