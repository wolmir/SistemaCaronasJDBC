/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Aluno;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AlunoDAO {
    private static final Logger LOGGER = Logger.getLogger(AlunoDAO.class.getName());
    private Connection connection;
    
    public AlunoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
            FileHandler fh = new FileHandler(this.getClass().getName() + "log.txt");
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException m) {
            LOGGER.severe("Erro na conexão do banco de dados.");
            LOGGER.severe(m.getMessage());
            m.printStackTrace();
        }
    }
    
    public List<Aluno> getAlunos() {
        LOGGER.setLevel(Level.ALL);
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
            LOGGER.severe("Erro ao listar alunos no banco.");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
        return null;
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
