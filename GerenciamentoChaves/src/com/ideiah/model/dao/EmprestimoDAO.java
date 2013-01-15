/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public List<Emprestimo> getEmprestimos() {
        try {
            List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getLong("id"));
                emprestimo.setNumero(rs.getInt("numero"));
                
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
