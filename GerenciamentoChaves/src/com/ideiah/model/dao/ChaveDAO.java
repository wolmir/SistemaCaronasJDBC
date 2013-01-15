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
    
    public List<Chave> getChaves() {
        try {
            List<Chave> chaves = new ArrayList<Chave>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from chaves");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Chave chave = new Chave();
                chave.setId(rs.getLong("id"));
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
    
}
