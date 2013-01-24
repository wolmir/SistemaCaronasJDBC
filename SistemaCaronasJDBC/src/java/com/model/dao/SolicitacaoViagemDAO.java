/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.jdbc.ConnectionFactory;
import com.model.entity.Passageiro;
import com.model.entity.SolicitacaoViagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SolicitacaoViagemDAO {
    
    private Connection connection;
    
    public SolicitacaoViagemDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void inserir(SolicitacaoViagem solicitacao) {
        String sql = "insert into solicitacao_viagem "
                + "(numero_transportados, servidores, data_saida, hora_saida, "
                + "local_saida, data_retorno, hora_retorno, local_retorno, "
                + "percurso, objetivo_viagem, id_veiculo, id_responsavel_solicitacao, "
                + "id_responsavel_autorizante) values (?,?,?,?,?,?,?,?,?,?,?," 
                + "?, ?)";
        
        String sql2 = "insert into passageiro_solicitacao_viagem "
                + "(id_passageiro, id_solicitacao_viagem) values (?, ?)";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, solicitacao.getNumero());
            stmt.setBoolean(2, solicitacao.getServidores());
            stmt.setDate(3, new Date(solicitacao.getDataSaida().getTime()));
            stmt.setDate(4, new Date(solicitacao.getHoraSaida().getTime()));
            stmt.setString(5, solicitacao.getLocalSaida());
            stmt.setDate(6, new Date(solicitacao.getDataRetorno().getTime()));
            stmt.setDate(7, new Date(solicitacao.getHoraRetorno().getTime()));
            stmt.setString(8, solicitacao.getLocalRetorno());
            stmt.setString(9, solicitacao.getPercurso());
            stmt.setString(10, solicitacao.getObjetivo());
            stmt.setInt(11, solicitacao.getVeiculo().getId());
            stmt.setInt(12, solicitacao.getSolicitante().getId());
            stmt.setInt(13, solicitacao.getAutorizante().getId());
            
            stmt.execute();
            ResultSet rsid = stmt.getGeneratedKeys();
            rsid.next();
            Integer gid = rsid.getInt("id_solicitacao_viagem");
            stmt.close();
            
            List<Passageiro> passageiros = solicitacao.getPassageiros();
            for (Passageiro passageiro: passageiros) {
                if (passageiro.getIdPassageiro() == null) {
                    Passageiro teste = new PassageiroDAO().getByRG(passageiro.getRg());
                    if (teste == null) {
                        new PassageiroDAO().inserir(passageiro);
                    }
                    stmt = this.connection.prepareStatement(sql2);
                    String rgp = passageiro.getRg();
                    Passageiro pass2 = new PassageiroDAO().getByRG(rgp);
                    Integer id2 = pass2.getIdPassageiro();
                    stmt.setInt(1, id2);
                    Integer id3 = gid;
                    stmt.setInt(2, id3);
                    stmt.execute();
                    stmt.close();
                    
                }
                
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public void alterar(SolicitacaoViagem solicitacao) {
        String sql = "update solicitacao_viagem set"
                + "numero_transportados=?, servidores=?, data_saida=?, hora_saida=?, "
                + "local_saida=?, data_retorno=?, hora_retorno=?, local_retorno=?, "
                + "percurso=?, objetivo_viagem=?, id_veiculo=?, id_responsavel_solicitacao=?, "
                + "id_responsavel_autorizante=? where id_solcitacao_viagem=? ";
        
        String sql2 = "insert into passageiro_solicitacao_viagem "
                + "(id_passageiro, id_solicitacao_viagem) values (?, ?)";
        String sql3 = "select * from passageiro_solicitacao_viagem";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, solicitacao.getNumero());
            stmt.setBoolean(2, solicitacao.getServidores());
            stmt.setDate(3, new Date(solicitacao.getDataSaida().getTime()));
            stmt.setDate(4, new Date(solicitacao.getHoraSaida().getTime()));
            stmt.setString(5, solicitacao.getLocalSaida());
            stmt.setDate(6, new Date(solicitacao.getDataRetorno().getTime()));
            stmt.setDate(7, new Date(solicitacao.getHoraRetorno().getTime()));
            stmt.setString(8, solicitacao.getLocalRetorno());
            stmt.setString(9, solicitacao.getPercurso());
            stmt.setString(10, solicitacao.getObjetivo());
            stmt.setInt(11, solicitacao.getVeiculo().getId());
            stmt.setInt(12, solicitacao.getSolicitante().getId());
            stmt.setInt(13, solicitacao.getAutorizante().getId());
            stmt.setInt(14, solicitacao.getId());
            stmt.execute();
            stmt.close();
            
            List<Passageiro> passageiros = solicitacao.getPassageiros();
            for (Passageiro passageiro: passageiros) {
                stmt = this.connection.prepareStatement(sql2);
                stmt.setInt(1, passageiro.getIdPassageiro());
                stmt.setInt(2, solicitacao.getId());
                stmt.execute();
                stmt.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public List<SolicitacaoViagem> getSolicitacoes() {
        String sql = "select * from solicitacao_viagem";
        String sql2 = "select * from passageiro_solicitacao_viagem where "
                + "id_solicitacao_viagem = ?";
        String sql4 = "select * from usuario where id_usuario=?";
        List<SolicitacaoViagem> solicitacoes = new ArrayList<SolicitacaoViagem>();
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ((rs.next())) {
                SolicitacaoViagem sv = new SolicitacaoViagem();
                sv.setId(rs.getInt("id_solicitacao_viagem"));
                Calendar c = Calendar.getInstance();
                c.setTime(rs.getDate("data_saida"));
                sv.setDataSaida(c.getTime());
                c = Calendar.getInstance();
                c.setTime(rs.getDate("hora_saida"));
                sv.setHoraSaida(c.getTime());
                c = Calendar.getInstance();
                c.setTime(rs.getDate("data_retorno"));
                sv.setDataRetorno(c.getTime());
                c = Calendar.getInstance();
                c.setTime(rs.getDate("hora_retorno"));
                sv.setHoraRetorno(c.getTime());
                sv.setLocalSaida(rs.getString("local_saida"));
                sv.setLocalRetorno(rs.getString("local_retorno"));
                sv.setNumero(rs.getInt("numero_transportados"));
                sv.setObjetivo(rs.getString("objetivo_viagem"));
                sv.setPercurso(rs.getString("percurso"));
                sv.setServidores(rs.getBoolean("servidores"));
                PreparedStatement stmt2 = this.connection.prepareStatement(sql2);
                stmt2.setInt(1, sv.getId());
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    Integer ids = rs.getInt("id_passageiro");
                    sv.getPassageiros().add(new PassageiroDAO().getById(ids));
                }
                Integer uid = rs.getInt("id_responsavel_solicitacao");
                sv.setSolicitante(new UsuarioDAO().getById(uid));
                Integer uaid = rs.getInt("id_responsavel_autorizante");
                sv.setAutorizante(new UsuarioDAO().getById(uaid));
                Integer vid = rs.getInt("id_veiculo");
                sv.setVeiculo(new VeiculoDAO().getById(vid));
                solicitacoes.add(sv);
            }
            return solicitacoes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
