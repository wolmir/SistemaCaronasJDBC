/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Chave;
import com.ideiah.model.entity.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class EmprestimoDAO {
    private static final Logger LOGGER = Logger.getLogger(EmprestimoDAO.class.getName());
    private Connection connection;
    
    public EmprestimoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            LOGGER.severe("Erro na conexão do banco de dados.");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean adiciona(Emprestimo emprestimo) {
        LOGGER.setLevel(Level.ALL);
        String sql = "insert into emprestimo (id_aluno, id_chave, retirada,"
                + "devolucao) values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, emprestimo.getAluno().getId());
            stmt.setLong(2, emprestimo.getChave().getId());
            stmt.setDate(3, new Date(
                    emprestimo.getData_retirada().getTimeInMillis()));
            if (emprestimo.getData_devolucao() != null) {
                stmt.setDate(4, new Date(
                        emprestimo.getData_devolucao().getTimeInMillis()));
            }
            else {
                stmt.setNull(4, java.sql.Types.NULL);
            }
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.severe("Erro ao adicionar um emprestimo no banco");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public void altera(Emprestimo emprestimo) {
        LOGGER.setLevel(Level.ALL);
        String sql = "update emprestimo set id_aluno=?, id_chave=?, retirada=?,"
                + "devolucao=? where id_emprestimo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, emprestimo.getAluno().getId());
            stmt.setLong(2, emprestimo.getChave().getId());
            stmt.setDate(3, new Date(
                    emprestimo.getData_retirada().getTimeInMillis()));
            stmt.setDate(4, new Date(
                    emprestimo.getData_devolucao().getTimeInMillis()));
            stmt.setLong(5, emprestimo.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.severe("Erro ao alterar um emprestimo no banco");
            LOGGER.severe(e.getMessage());
        }
    }
    
    public void remove(Emprestimo emprestimo) {
        LOGGER.setLevel(Level.ALL);
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where id_emprestimo=?");
            stmt.setLong(1, emprestimo.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            LOGGER.severe("Erro ao remover um emprestimo no banco");
            LOGGER.severe(e.getMessage());
        }
    }
    
    public List<Emprestimo> getEmprestimos() {
        LOGGER.setLevel(Level.ALL);
        try {
            List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
            String sql = "select * from emprestimo";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id_emprestimo"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("retirada"));
                emprestimo.setData_retirada(data);
                Date datard = rs.getDate("devolucao");
                if (datard != null) {
                    Calendar datad = Calendar.getInstance();
                    data.setTime(rs.getDate("devolucao"));
                    emprestimo.setData_devolucao(datad);
                }
                
                String sql_al = "select * from aluno where id_aluno=?";
                PreparedStatement st_aluno = connection.prepareStatement(sql_al);
                st_aluno.setLong(1, rs.getLong("id_aluno"));
                ResultSet rs_alunos = st_aluno.executeQuery();
                rs_alunos.next();
                Aluno aluno = new Aluno();
                aluno.setId(rs_alunos.getLong("id_aluno"));
                aluno.setNome(rs_alunos.getString("nome"));
                aluno.setEmail(rs_alunos.getString("email"));
                aluno.setCurso(rs_alunos.getString("curso"));
                aluno.setMatricula(rs_alunos.getString("matricula"));
                emprestimo.setAluno(aluno);
                
                String sql_chave = "select * from chave where id_chave=?";
                PreparedStatement st_chave = connection.prepareStatement(sql_chave);
                st_chave.setLong(1, rs.getLong("id_chave"));
                ResultSet rs_chaves = st_chave.executeQuery();
                rs_chaves.next();
                Chave chave = new Chave();
                chave.setId(rs_chaves.getLong("id_chave"));
                chave.setNumero(rs_chaves.getInt("numero"));
                chave.setTipo(rs_chaves.getString("tipo"));
                emprestimo.setChave(chave);
                
                emprestimos.add(emprestimo);
            }
            rs.close();
            stmt.close();
            return emprestimos;
            
        } catch (SQLException e) {
            LOGGER.severe("Erro ao listar empréstimos no banco");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Emprestimo> getByAluno(Aluno alunop) {
        LOGGER.setLevel(Level.ALL);
        try {
            List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
            String sql = "select * from emprestimo where id_aluno=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, alunop.getId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id_emprestimo"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("retirada"));
                emprestimo.setData_retirada(data);
                Date datard = rs.getDate("devolucao");
                if (datard != null) {
                    Calendar datad = Calendar.getInstance();
                    data.setTime(rs.getDate("devolucao"));
                    emprestimo.setData_devolucao(datad);
                }
                
                String sql_al = "select * from aluno where id_aluno=?";
                PreparedStatement st_aluno = connection.prepareStatement(sql_al);
                st_aluno.setLong(1, rs.getLong("id_aluno"));
                ResultSet rs_alunos = st_aluno.executeQuery();
                rs_alunos.next();
                Aluno aluno = new Aluno();
                aluno.setId(rs_alunos.getLong("id_aluno"));
                aluno.setNome(rs_alunos.getString("nome"));
                aluno.setEmail(rs_alunos.getString("email"));
                aluno.setCurso(rs_alunos.getString("curso"));
                aluno.setMatricula(rs_alunos.getString("matricula"));
                emprestimo.setAluno(aluno);
                
                String sql_chave = "select * from chave where id_chave=?";
                PreparedStatement st_chave = connection.prepareStatement(sql_chave);
                st_chave.setLong(1, rs.getLong("id_chave"));
                ResultSet rs_chaves = st_chave.executeQuery();
                rs_chaves.next();
                Chave chave = new Chave();
                chave.setId(rs_chaves.getLong("id_chave"));
                chave.setNumero(rs_chaves.getInt("numero"));
                chave.setTipo(rs_chaves.getString("tipo"));
                emprestimo.setChave(chave);
                
                emprestimos.add(emprestimo);
            }
            rs.close();
            stmt.close();
            return emprestimos;
            
        } catch (SQLException e) {
            LOGGER.severe("Erro ao listar empréstimos no banco");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
