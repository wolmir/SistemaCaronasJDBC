/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.TipoUsuarioDAO;
import com.model.dao.UsuarioDAO;
import com.model.entity.TipoUsuario;
import com.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class UsuarioController {
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String tipoUsuarioSelect;
    private List<TipoUsuario> tipoUsuarios;
    private List<String> tiposUsuarios;
    
    public UsuarioController() throws Exception {
        this.usuario = new Usuario();
        this.usuarios = new UsuarioDAO().getUsuarios();
        this.tipoUsuarios = new TipoUsuarioDAO().getTiposUsuarios();
        this.tiposUsuarios = new ArrayList<String>();
        for (TipoUsuario tipo: this.tipoUsuarios) {
            this.tiposUsuarios.add(tipo.getTipoUsuario());
        }
    }

    
    public String salvar() throws Exception {
        UsuarioDAO ud = new UsuarioDAO();
        if (this.usuario.getId() == null) {
            TipoUsuario tipo = null;
            for (TipoUsuario t: this.tipoUsuarios) {
                if (t.getTipoUsuario().equals(this.tipoUsuarioSelect)) {
                    tipo = t;
                }
            }
            this.usuario.setTipo(tipo);
            ud.inserir(this.usuario);
        }
        
        else {
            TipoUsuario tipo = null;
            for (TipoUsuario t: this.tipoUsuarios) {
                if (t.getTipoUsuario().equals(this.tipoUsuarioSelect)) {
                    tipo = t;
                }
            }
            this.usuario.setTipo(tipo);
            ud.alterar(this.usuario);
        }
        return "listar";
    }
    
    public String editar(Integer id) {
        this.usuario = new UsuarioDAO().getById(id);
        return "formulario";
    }
    
    public String deletar(Integer id) {
        UsuarioDAO ud = new UsuarioDAO();
        this.usuario = ud.getById(id);
        ud.deletar(this.usuario);
        return "listar";
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the tipoUsuarioSelect
     */
    public String getTipoUsuarioSelect() {
        return tipoUsuarioSelect;
    }

    /**
     * @param tipoUsuarioSelect the tipoUsuarioSelect to set
     */
    public void setTipoUsuarioSelect(String tipoUsuarioSelect) {
        this.tipoUsuarioSelect = tipoUsuarioSelect;
    }

    /**
     * @return the tipoUsuarios
     */
    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    /**
     * @param tipoUsuarios the tipoUsuarios to set
     */
    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    /**
     * @return the tiposUsuarios
     */
    public List<String> getTiposUsuarios() {
        return tiposUsuarios;
    }

    /**
     * @param tiposUsuarios the tiposUsuarios to set
     */
    public void setTiposUsuarios(List<String> tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }
    
}
