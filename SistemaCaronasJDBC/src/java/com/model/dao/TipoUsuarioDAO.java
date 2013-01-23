/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.jdbc.ConnectionFactory;
import com.model.entity.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class TipoUsuarioDAO {
    
    private Connection connection;
    
    public TipoUsuarioDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public TipoUsuario getById(Integer id) {
        String sql = "select * from tipo_usuario where id_tipo_usuario=?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoUsuario usuario = new TipoUsuario();
                usuario.setId(rs.getInt("id_tipo_usuario"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
