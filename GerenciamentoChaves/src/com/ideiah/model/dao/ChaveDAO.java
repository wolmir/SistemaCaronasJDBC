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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ChaveDAO {
    private static final Logger LOGGER = Logger.getLogger(ChaveDAO.class.getName());
    
    private Connection connection;
    
    public ChaveDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            LOGGER.severe("Erro na conexão do banco de dados.");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void adiciona(Chave chave) {
        LOGGER.setLevel(Level.SEVERE);
        String sql = "insert into chave " +
                "(numero, tipo, status) values (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, chave.getNumero());
            stmt.setString(2, chave.getTipo());
            stmt.setBoolean(3, chave.getDisponivel());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.severe("Erro ao inserir uma Chave no banco.");
            LOGGER.severe(e.getMessage());
        }
    }
    
    public List<Chave> getChaves() {
        LOGGER.setLevel(Level.SEVERE);
        try {
            List<Chave> chaves = new ArrayList<Chave>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from chave");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Chave chave = new Chave();
                chave.setId(rs.getLong("id_chave"));
                chave.setNumero(rs.getInt("numero"));
                chave.setTipo(rs.getString("tipo"));
                chave.setDisponivel(rs.getBoolean("status"));
                chaves.add(chave);
                
            }
            rs.close();
            stmt.close();
            return chaves;
            
        } catch (SQLException e) {
            LOGGER.severe("Erro ao listar as chaves.");
            LOGGER.severe(e.getMessage());
        }
        return null;
    }
    
    public void altera(Chave chave) {
        LOGGER.setLevel(Level.SEVERE);
        String sql = "update chave set numero=?, tipo=?, status=? where id_chave=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, chave.getNumero());
            stmt.setString(2, chave.getTipo());
            stmt.setLong(3, chave.getId());
            stmt.setBoolean(4, chave.getDisponivel());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.severe("Erro ao alterar uma Chave no banco.");
            LOGGER.severe(e.getMessage());
        } 
    }
    
    
    public void remove(Chave chave) {
        LOGGER.setLevel(Level.SEVERE);
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from chave where id_chave=?");
            stmt.setLong(1, chave.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.severe("Erro ao deletar uma Chave no banco.");
            LOGGER.severe(e.getMessage());
        }
    }
    
}
