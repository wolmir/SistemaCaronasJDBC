/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Chave;
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
public class ChaveDAO {
    
    private Connection connection;
    
    public ChaveDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Chave chave) {
        String sql = "insert into chaves " +
                "(numero) values (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, chave.getNumero());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Chave> getChaves() {
        try {
            List<Chave> chaves = new ArrayList<Chave>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from chaves");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Chave chave = new Chave();
                chave.setId(rs.getLong("id_chave"));
                chave.setNumero(rs.getInt("numero"));
                
                chaves.add(chave);
                
            }
            rs.close();
            stmt.close();
            return chaves;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Chave chave) {
        String sql = "update chaves set numero=? where id_chave=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, chave.getNumero());
            stmt.setLong(2, chave.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    
    public void remove(Chave chave) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from chaves where id_chave=?");
            stmt.setLong(1, chave.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
