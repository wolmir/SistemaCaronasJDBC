/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.jdbc.ConnectionFactory;
import com.model.entity.Passageiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Usuario
 */
public class PassageiroDAO {
    
    private class PassageiroFields {
        public static final String id = "id_passageiro";
        public static final String nome = "nome";
        public static final String rg = "rg";
        public static final String telefone = "telefone";
        
        public String getTuple() {
            return "(" + PassageiroFields.rg + ", " + PassageiroFields.nome + ", " + PassageiroFields.telefone + ")";
        }
    }
    
    private Connection connection;
    
    public PassageiroDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void inserir(Passageiro passageiro) {
        String sql = "insert into passageiro " +
                new PassageiroFields().getTuple() + " values (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, passageiro.getRg());
            stmt.setString(2, passageiro.getNome());
            stmt.setString(3, passageiro.getTelefone());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Passageiro> getPassageiros() {
        try {
            List<Passageiro> passageiros = new ArrayList<Passageiro>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from passageiro");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setIdPassageiro(rs.getInt(PassageiroFields.id));
                passageiro.setNome(rs.getString(PassageiroFields.nome));
                passageiro.setRg(rs.getString(PassageiroFields.rg));
                passageiro.setTelefone(rs.getString(PassageiroFields.telefone));
                passageiros.add(passageiro);
                
            }
            rs.close();
            stmt.close();
            return passageiros;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public void altera(Passageiro passageiro) {
        String sql = "update passageiro set nome=?," +
                "rg=?, telefone=? where id_passageiro=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, passageiro.getNome());
            stmt.setString(2, passageiro.getRg());
            stmt.setString(3, passageiro.getTelefone());
            stmt.setInt(4, passageiro.getIdPassageiro());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void remove(Passageiro passageiro) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from passageiro where id_passageiro=?");
            stmt.setInt(1, passageiro.getIdPassageiro());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Passageiro getById(Integer id) {
        try {
            List<Passageiro> passageiros = new ArrayList<Passageiro>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from passageiro where id_passageiro=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setIdPassageiro(rs.getInt(PassageiroFields.id));
                passageiro.setNome(rs.getString(PassageiroFields.nome));
                passageiro.setRg(rs.getString(PassageiroFields.rg));
                passageiro.setTelefone(rs.getString(PassageiroFields.telefone));
                passageiros.add(passageiro);
                
            }
            rs.close();
            stmt.close();
            return passageiros.get(0);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
