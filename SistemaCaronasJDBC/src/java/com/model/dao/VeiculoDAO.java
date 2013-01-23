/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.jdbc.ConnectionFactory;
import com.model.entity.Veiculo;
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
public class VeiculoDAO {
    private Connection connection;
    
    public VeiculoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void inserir(Veiculo veiculo) {
        String sql = "insert into veiculo (id_tipo_veiculo, "
                + "placa, quilometragem, capacidade_veiculo, "
                + "cor) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, veiculo.getTipoVeiculo().getId());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setFloat(3, veiculo.getQuilometragem());
            stmt.setInt(4, veiculo.getCapacidadePassageiro());
            stmt.setString(5, veiculo.getCor());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Veiculo getById(Integer id) {
        String sql = "select * from veiculo where id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo usuario = new Veiculo();
                usuario.setCapacidadePassageiro(rs.getInt("capacidade_passageiro"));
                usuario.setCor(rs.getString("cor"));
                usuario.setId(rs.getInt("id"));
                usuario.setPlaca(rs.getString("placa"));
                usuario.setQuilometragem(rs.getFloat("quilometragem"));
                Integer tid = rs.getInt("id_tipo_veiculo");
                usuario.setTipoVeiculo(new TipoVeiculoDAO().getById(tid));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public void altera(Veiculo veiculo) {
        String sql = "update veiculo set placa=?," +
                "quilometragem=?, capacidade_veiculo=?, cor=? where id_veiculo=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getPlaca());
            stmt.setFloat(2, veiculo.getQuilometragem());
            stmt.setInt(3, veiculo.getCapacidadePassageiro());
            stmt.setString(4, veiculo.getCor());
            stmt.setInt(5, veiculo.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    
    public List<Veiculo> getVeiculos() {
        String sql = "select * from veiculo";
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCapacidadePassageiro(rs.getInt("capacidade_passageiro"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setId(rs.getInt("id"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setQuilometragem(rs.getFloat("quilometragem"));
                veiculo.setTipoVeiculo(new TipoVeiculoDAO().getById(rs.getInt("id_tipo_veiculo")));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
    public void deletar(Veiculo veiculo) {
        String sql = "delete from veiculo where id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, veiculo.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
