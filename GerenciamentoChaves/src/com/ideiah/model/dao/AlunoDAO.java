/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Aluno;
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
public class AlunoDAO {
    
    private Connection connection;
    
    public AlunoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Aluno> getAlunos() {
        try {
            List<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from aluno");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSenha(rs.getString("senha"));
                alunos.add(aluno);
                
            }
            rs.close();
            stmt.close();
            return alunos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    /*public void adiciona(Aluno aluno) {
        String sql = "insert into alunos (nome, matricula, curso, email, senha, status)"
                + "values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    
}
