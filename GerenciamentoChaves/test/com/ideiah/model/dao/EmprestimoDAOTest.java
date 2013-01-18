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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class EmprestimoDAOTest {
    
    private static AlunoDAO aluDao;
    private static ChaveDAO chaDao;
    private static EmprestimoDAO empDao;
    private static Connection connection;
    private static List<Aluno> alunosL1;
    private static List<Chave> chaveL1;
    private static List<Emprestimo> empL1;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        /*
        *   setUp de alunos na tabela Alunos
        * 
        */
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
            PreparedStatement stmtAluno = connection.prepareStatement(
                    "insert into aluno values ("+aluno.getId()+
                    ", '"+aluno.getNome()+
                    "','"+aluno.getEmail()+
                    "','"+aluno.getMatricula()+
                    "','"+aluno.getSenha()+
                    "','"+aluno.getCurso()+"');");
            stmtAluno.execute();
            stmtAluno.close();
        }
        
        /*
         * setUp de chaves na tabela chave
         * 
         */
        
        chaveL1 = (List<Chave>) new  ArrayList<Chave>();
        Chave c1 = new Chave();
        Chave c2 = new Chave();
        Chave c3 = new Chave();
        Chave c4 = new Chave();
        
        c1.setNumero(new Integer(21));
        c1.setId(new Long(1));
        c2.setNumero(new Integer(26));
        c2.setId(new Long(2));
        c3.setNumero(new Integer(31));
        c3.setId(new Long(3));
        c4.setNumero(new Integer(35));
        c4.setId(new Long (4));
        
        chaveL1.add(c1);
        chaveL1.add(c2);
        chaveL1.add(c3);
        chaveL1.add(c4);
        
        connection = new ConnectionFactory().getConnection();
        for(Chave chave : chaveL1) {
            PreparedStatement stmtChave = connection.prepareStatement(
                    "insert into chave values ("+chave.getId()+", "+chave.getNumero()+");");
            stmtChave.execute();
            stmtChave.close();
        }
        
        /*
         * setUp de emprestimos na tabela emprestimo
         * 
         */
        

        //empL1= (List<Emprestimo>) new ArrayList<Emprestimo>();
        Emprestimo e1 = new Emprestimo();
        /*e1.setId(new Long(0));
        e1.setAluno(a2);
        e1.setChave(c4);
        Calendar c = Calendar.getInstance();
        c.set(2013, 1, 17);
        e1.setData_retirada(c);
        e1.setData_devolucao(c);
        empDAO.adiciona(e1);
        */
        
        empDAO.getEmprestimos();
        PreparedStatement stmtEmp = connection.prepareStatement("insert into emprestimo"
                +"(id_alun0, id_chave, retirada, devolucao) values (?,?,?,?)");
            stmtEmp.setLong(1, 1);
            stmtEmp.setLong(2, 1);
            Calendar c = new GregorianCalendar();
            c.set(2013, 1, 17);
            stmtEmp.setDate(3, new Date(c.getTimeInMillis()));
            stmtEmp.setDate(4, new Date(c.getTimeInMillis()));
        
        stmtEmp.execute();
        stmtEmp.close();
        
        
        
        
        
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        connection = new ConnectionFactory().getConnection();
        /*
         * Emprestimo deve ser a primeira a ser excluida por conter chave estrangeira
         * 
         */
        
        
            PreparedStatement stmt = connection.prepareStatement(
                    "delete from emprestimo where id_alun0 = 1;");
            stmt.execute();
            stmt.close();
        
        
        for(Aluno aluno : alunosL1) {
            stmt = connection.prepareStatement(
                    "delete from aluno where id_aluno = "+aluno.getId()+";");
            stmt.execute();
        }
        
        for(Chave chave : chaveL1) {
            stmt = connection.prepareStatement(
                    "delete from chave where id_chave = "+chave.getId()+";");
            stmt.execute();
        }
        stmt.close();
    
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of adiciona method, of class EmprestimoDAO.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.adiciona(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altera method, of class EmprestimoDAO.
     */
    @Test
    public void testAltera() {
        System.out.println("altera");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.altera(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class EmprestimoDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.remove(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmprestimos method, of class EmprestimoDAO.
     */
    @Test
    public void testGetEmprestimos() {
        System.out.println("getEmprestimos");
        EmprestimoDAO instance = new EmprestimoDAO();
        List expResult = null;
        List result = instance.getEmprestimos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
