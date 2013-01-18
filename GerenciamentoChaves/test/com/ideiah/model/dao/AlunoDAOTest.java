/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao Paulo
 */
public class AlunoDAOTest {
    
    private static AlunoDAO dao;
    private static Connection connection;
    private static List<Aluno> alunosL1;
    
    public AlunoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        dao = new AlunoDAO();
        alunosL1 = (List<Aluno>) new  ArrayList<Aluno>();
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setId(new Long(1));
        a1.setNome("Joao");
        a1.setEmail("joao@unipampa.edu.br");
        a1.setMatricula(new Integer(548697236));
        a1.setSenha("12345");
        a1.setCurso("CC");
        alunosL1.add(a1);
        
        a2.setId(new Long(2));
        a2.setNome("Maria");
        a2.setEmail("maria@unipampa.edu.br");
        a2.setMatricula(new Integer(367254694));
        a2.setSenha("12345");
        a2.setCurso("ES");
        alunosL1.add(a2);
        
        connection = new ConnectionFactory().getConnection();
        for(Aluno aluno : alunosL1) {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into aluno values ("+aluno.getId()+
                    ", '"+aluno.getNome()+
                    "','"+aluno.getEmail()+
                    "','"+aluno.getMatricula()+
                    "','"+aluno.getSenha()+
                    "','"+aluno.getCurso()+"');");
            stmt.execute();
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        connection = new ConnectionFactory().getConnection();
        
        for(Aluno aluno : alunosL1) {
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from aluno where id_aluno = "+aluno.getId()+";");
            stmt.execute();
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAlunos method, of class AlunoDAO.
     */
    @Test
    public void testGetAlunos() {
        System.out.println("testgetAlunos");
        List<Aluno> alunos = dao.getAlunos();
        for (Aluno a : alunosL1) {
            boolean flag = false;
            for (Aluno aluno : alunos){
                if (a.getId().equals(aluno.getId())){
                    System.out.println(a.getId()+"\t"+aluno.getId());
                    flag = true;
                }
            }
            assertEquals(true, flag);
        }
    }
}
