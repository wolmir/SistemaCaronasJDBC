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

/**
 *
 * @author Usuario
 */
public class EmprestimoDAO {
    private Connection connection;
    
    public EmprestimoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Emprestimo emprestimo) {
        String sql = "insert into emprestimo (id_aluno, id_chave, retirada,"
                + "devolucao) values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, emprestimo.getAluno().getId());
            stmt.setLong(2, emprestimo.getChave().getId());
            stmt.setDate(3, new Date(
                    emprestimo.getData_retirada().getTimeInMillis()));
            stmt.setDate(4, new Date(
                    emprestimo.getData_devolucao().getTimeInMillis()));
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void altera(Emprestimo emprestimo) {
        String sql = "update emprestimo set id_aluno=?, id_chave=?, retirada=?,"
                + "devolucao=? where id=?";
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
            throw new RuntimeException(e);
        }
    }
    
    public void remove(Emprestimo emprestimo) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where id_emprestimo=?");
            stmt.setLong(1, emprestimo.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Emprestimo> getEmprestimos() {
        try {
            List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
            String sql = "select * from emprestimo";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("retirada"));
                emprestimo.setData_retirada(data);
                Calendar datad = Calendar.getInstance();
                data.setTime(rs.getDate("devolucao"));
                emprestimo.setData_devolucao(datad);
                
                String sql_al = "select * from aluno where id=?";
                PreparedStatement st_aluno = connection.prepareStatement(sql_al);
                st_aluno.setLong(1, rs.getLong("id_usuario"));
                ResultSet rs_alunos = st_aluno.executeQuery();
                rs_alunos.next();
                Aluno aluno = new Aluno();
                aluno.setId(rs_alunos.getLong("id_aluno"));
                aluno.setNome(rs_alunos.getString("nome"));
                aluno.setEmail(rs_alunos.getString("email"));
                aluno.setCurso(rs_alunos.getString("curso"));
                aluno.setMatricula(rs_alunos.getInt("matricula"));
                emprestimo.setAluno(aluno);
                
                String sql_chave = "select * from chave where id=?";
                PreparedStatement st_chave = connection.prepareStatement(sql_chave);
                st_aluno.setLong(1, rs.getLong("id_chave"));
                ResultSet rs_chaves = st_chave.executeQuery();
                rs_chaves.next();
                Chave chave = new Chave();
                chave.setId(rs.getLong("id_chave"));
                chave.setNumero(rs.getInt("numero"));
                emprestimo.setChave(chave);
                
                emprestimos.add(emprestimo);
            }
            rs.close();
            stmt.close();
            return emprestimos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
