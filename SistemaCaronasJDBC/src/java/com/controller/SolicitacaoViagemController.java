/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.PassageiroDAO;
import com.model.dao.SolicitacaoViagemDAO;
import com.model.dao.UsuarioDAO;
import com.model.dao.VeiculoDAO;
import com.model.entity.Passageiro;
import com.model.entity.SolicitacaoViagem;
import com.model.entity.Usuario;
import com.model.entity.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class SolicitacaoViagemController {
    private SolicitacaoViagem solicitacaoviagem;
    private List<SolicitacaoViagem> viagens;
    private String veiculoSelect;
    private List<Veiculo> veiculos;
    private List<String> veiculoss;
    private String usuarioSolSelect;
    private String usuarioAutSelect;
    private List<Usuario> usuarios;
    private List<String> usuarioss;
    private Integer numero;
    
    public SolicitacaoViagemController() {
        this.solicitacaoviagem = new SolicitacaoViagem();
        this.viagens = new SolicitacaoViagemDAO().getSolicitacoes();
        this.veiculos = new VeiculoDAO().getVeiculos();
        this.usuarios = new UsuarioDAO().getUsuarios();
        this.veiculoss = new ArrayList<String>();
        this.usuarios = new UsuarioDAO().getUsuarios();
        this.usuarioss = new ArrayList<String>();
        for (Veiculo veiculoi: this.veiculos) {
            this.veiculoss.add(veiculoi.getPlaca());
        }
        for (Usuario usuarioi: usuarios) {
            usuarioss.add(usuarioi.getNome());
        }
    }

    
    public String salvar() {
        if (this.getSolicitacaoviagem().getId() == null) {
            Veiculo v = null;
            Usuario u = null;
            Usuario u2 = null;
            
            for (Veiculo veiculo: getVeiculos()) {
                if (veiculo.getPlaca().equals(this.getVeiculoSelect())) {
                    v = veiculo;
                }
            }
            
            for (Usuario usuario: getUsuarios()) {
                if (usuario.getNome().equals(this.getUsuarioSolSelect())) {
                    u = usuario;
                }
            }
            
            for (Usuario usuario: getUsuarios()) {
                if (usuario.getNome().equals(this.getUsuarioAutSelect())) {
                    u2 = usuario;
                }
            }
            
            this.getSolicitacaoviagem().setAutorizante(u2);
            this.getSolicitacaoviagem().setSolicitante(u);
            this.getSolicitacaoviagem().setVeiculo(v);
            this.getSolicitacaoviagem().setNumero(numero);
            new SolicitacaoViagemDAO().inserir(getSolicitacaoviagem());
        }
        
        else {
            Veiculo v = null;
            Usuario u = null;
            Usuario u2 = null;
            
            for (Veiculo veiculo: getVeiculos()) {
                if (veiculo.getPlaca().equals(this.getVeiculoSelect())) {
                    v = veiculo;
                }
            }
            
            for (Usuario usuario: getUsuarios()) {
                if (usuario.getNome().equals(this.getUsuarioSolSelect())) {
                    u = usuario;
                }
            }
            
            for (Usuario usuario: getUsuarios()) {
                if (usuario.getNome().equals(this.getUsuarioAutSelect())) {
                    u2 = usuario;
                }
            }
            
            this.getSolicitacaoviagem().setAutorizante(u2);
            this.getSolicitacaoviagem().setSolicitante(u);
            this.getSolicitacaoviagem().setVeiculo(v);
            this.getSolicitacaoviagem().setNumero(numero);
            new SolicitacaoViagemDAO().alterar(getSolicitacaoviagem());
        }
        
        return "listar";
    }
    
    @PostConstruct
    void initialiseSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
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
    public String getVeiculoSelect() {
        return veiculoSelect;
    }

    /**
     * @param veiculoSelect the veiculoSelect to set
     */
    public void setVeiculoSelect(String veiculoSelect) {
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
     * @return the usuarioSolSelect
     */
    public String getUsuarioSolSelect() {
        return usuarioSolSelect;
    }

    /**
     * @param usuarioSolSelect the usuarioSolSelect to set
     */
    public void setUsuarioSolSelect(String usuarioSolSelect) {
        this.usuarioSolSelect = usuarioSolSelect;
    }

    /**
     * @return the usuarioAutSelect
     */
    public String getUsuarioAutSelect() {
        return usuarioAutSelect;
    }

    /**
     * @param usuarioAutSelect the usuarioAutSelect to set
     */
    public void setUsuarioAutSelect(String usuarioAutSelect) {
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

    /**
     * @return the usuarioss
     */
    public List<String> getUsuarioss() {
        return usuarioss;
    }

    /**
     * @param usuarioss the usuarioss to set
     */
    public void setUsuarioss(List<String> usuarioss) {
        this.usuarioss = usuarioss;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) throws Exception {
        this.numero = numero;
        List<Passageiro> passageiros = new ArrayList<Passageiro>();
        for (int i = 0; i < numero; i++) {
            passageiros.add(new Passageiro(this));
        }
        this.solicitacaoviagem.setPassageiros(passageiros);
        //throw new Exception("Whoopi! " + passageiros.size() + numero);
    }
    
    public void adjust(Passageiro passageiro) {
        List<Passageiro> passageiros = new PassageiroDAO().getByNome(
                passageiro.getNome());
        if (passageiros.size() == 1) {
            Passageiro pass = passageiros.get(0);
            passageiro.setRg(pass.getRg());
            passageiro.setTelefone(pass.getTelefone());
            passageiro.setDisabled(true);
            passageiro.setIdPassageiro(pass.getIdPassageiro());
        }
    }
    
    
    
    
    
}
