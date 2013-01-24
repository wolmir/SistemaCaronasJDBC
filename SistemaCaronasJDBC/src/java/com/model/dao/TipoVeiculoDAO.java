/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.jdbc.ConnectionFactory;
import com.model.entity.TipoUsuario;
import com.model.entity.TipoVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipoVeiculoDAO {
private Connection connection;
    
    public TipoVeiculoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public TipoVeiculo getById(Integer id) {
        String sql = "select * from tipo_veiculo where id_tipo_veiculo=?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoVeiculo usuario = new TipoVeiculo();
                usuario.setId(rs.getInt("id_tipo_veiculo"));
                usuario.setTipoVeiculo(rs.getString("tipo_veiculo"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<TipoVeiculo> getTiposVeiculos() {
        String sql = "select * from tipo_veiculo";
        List<TipoVeiculo> tipos = new ArrayList<TipoVeiculo>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoVeiculo tipo = new TipoVeiculo();
                tipo.setId(rs.getInt("id_tipo_veiculo"));
                tipo.setTipoVeiculo(rs.getString("tipo_veiculo"));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }
    
}
