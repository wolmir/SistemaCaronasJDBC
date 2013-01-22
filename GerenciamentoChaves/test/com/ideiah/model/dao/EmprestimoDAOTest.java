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
import java.sql.ResultSet;
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
    static Calendar c = new GregorianCalendar();
    Calendar c2 = new GregorianCalendar();
    
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
        a1.setMatricula("548697236");
        a1.setSenha("12345");
        a1.setCurso("CC");
        alunosL1.add(a1);
        
        a2.setId(new Long(2));
        a2.setNome("Maria");
        a2.setEmail("maria@unipampa.edu.br");
        a2.setMatricula("367254694");
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
        
        c1.setTipo(null);
        c2.setTipo(null);
        c3.setTipo(null);
        c4.setTipo(null);
        
        chaveL1.add(c1);
        chaveL1.add(c2);
        chaveL1.add(c3);
        chaveL1.add(c4);
        
        connection = new ConnectionFactory().getConnection();
        for(Chave chave : chaveL1) {
            PreparedStatement stmtChave = connection.prepareStatement(
                    "insert into chave values ("+chave.getId()+", "
                    + ""+chave.getNumero()+", "
                    + ""+chave.getTipo()+");");
            stmtChave.execute();
            stmtChave.close();
        }
        
        /*
         * setUp de emprestimos na tabela emprestimo
         * 
         */
        
        Emprestimo e1 = new Emprestimo();
        
        PreparedStatement stmtEmp = connection.prepareStatement("insert into emprestimo"
                +"(id_aluno, id_chave, retirada, devolucao) values (?,?,?,?)");
            stmtEmp.setLong(1, 1);
            stmtEmp.setLong(2, 1);
            c.set(2013, 1, 17);
            stmtEmp.setDate(3, new Date(c.getTimeInMillis()));
            stmtEmp.setDate(4, new Date(c.getTimeInMillis()));
        
        stmtEmp.execute();
        stmtEmp.close();
        /*
         * declarando um emprestimo para testar o método adicionar, remover.
         * 
         */
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        
        connection = new ConnectionFactory().getConnection();
        
        /*
         * Emprestimo deve ser a primeira a ser excluida por conter chave estrangeira
         * 
         */ 
        PreparedStatement stmt = connection.prepareStatement(
                    "delete from emprestimo where id_aluno = 1;");
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
    
    private boolean getCompEmprestimo(Emprestimo emprestimo){
        EmprestimoDAO instance = new EmprestimoDAO();
        List<Emprestimo> listEmprestimo = instance.getEmprestimos();
        boolean flag=false;
        
        for (Emprestimo emprestimoI : listEmprestimo){
            if (emprestimoI.getAluno().getId().equals(emprestimo.getAluno().getId())){
                flag = true;
                break;
            }
            else {
                flag = false;
            }
        }
        
        return flag;
    }

    /**
     * Test of adiciona method, of class EmprestimoDAO.
     */
    @Test
    public void testAdiciona() throws SQLException {
        System.out.println("adiciona");
        Emprestimo emprestimo = new Emprestimo();
        Aluno aluno = new Aluno();
        
        aluno.setId(new Long (6));
        aluno.setNome("Carlos");
        aluno.setEmail("carlos@unipampa.edu.br");
        aluno.setMatricula("111252349");
        aluno.setCurso("EM");
        
        PreparedStatement stmtAluno = connection.prepareStatement(
                    "insert into aluno values ("+aluno.getId()+
                    ", '"+aluno.getNome()+
                    "','"+aluno.getEmail()+
                    "','"+aluno.getMatricula()+
                    "','"+aluno.getSenha()+
                    "','"+aluno.getCurso()+"');");
            stmtAluno.execute();
            stmtAluno.close();
//        
//         adicionando uma nova chave para a tabela chave
//            
        
        Chave chave = new Chave();
        
        chave.setId(new Long(5));
        chave.setNumero(new Integer(69));
        chave.setTipo(null);
        
        PreparedStatement stmtChave = connection.prepareStatement(
                    "insert into chave values ("
            +chave.getId()+", "+chave.getNumero()+", "+chave.getTipo()+");");
            stmtChave.execute();
            stmtChave.close();
//
//            
//            adicionando um emprestimo a tabela emprestimo
        
        EmprestimoDAO instance = new EmprestimoDAO();
        
        emprestimo.setAluno(aluno);
        emprestimo.setChave(chave);
        c2.set(2013, 1, 21);
        emprestimo.setData_retirada(c2);
        emprestimo.setData_devolucao(c2);
        
        instance.adiciona(emprestimo);
//              
//        comparando o elemento adicionado com a tabela emprestimos após uma inserção
//        OBS: Integrando o método getEmprestimos (já testado e funcionando corretamente)
//        através do método private declarado nesta classe de teste getCompEmprestimo
//        
        boolean flag=false;
        flag=getCompEmprestimo(emprestimo);
        assertEquals(true, flag);
    }
    
    /**
     * Test of altera method, of class EmprestimoDAO.
     */
    @Test
    public void testAltera() {
        System.out.println("altera");
        boolean flag=false;
        Calendar c3=new GregorianCalendar();
        c3.set(2013,01,22);
        EmprestimoDAO instance = new EmprestimoDAO();
        List<Emprestimo> listEmprestimo=instance.getEmprestimos();
        for (Emprestimo empr : listEmprestimo){
            flag=getCompEmprestimo(empr);
        }
        if (flag == true){   
            for (Emprestimo empr : listEmprestimo){
            empr.setData_retirada(c3);
            empr.setData_devolucao(c3);
            instance.altera(empr);
            }
        }
        else{
            fail ("elementos na lista criada não conferem com a tabela");
        }
        Calendar c4=new GregorianCalendar();

        List<Emprestimo> listEmprestimoAfAlt=instance.getEmprestimos();
        
        for(Emprestimo empr : listEmprestimoAfAlt){
            c4=empr.getData_devolucao();
            if (c4.get(Calendar.DAY_OF_MONTH)==(c3.get(Calendar.DAY_OF_MONTH))){
            flag=true;
            }
            else{
                flag=false;
            }
        }
        
        assertEquals(true, flag);
    }

    /**
     * Test of remove method, of class EmprestimoDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        boolean flag = false;
        EmprestimoDAO instance = new EmprestimoDAO();
        List<Emprestimo> listEmprestimo=instance.getEmprestimos();
        for (Emprestimo empr : listEmprestimo){
            instance.remove(empr);
        }
        List<Emprestimo> listEmprestimoEmpty = instance.getEmprestimos();
        for (Emprestimo empr : listEmprestimo){
                if (listEmprestimoEmpty.contains(empr)){
                    flag=false;
                    System.out.println(empr);
                    break;
                }
                else{
                    flag=true;
                }
        }
        assertEquals(true, flag);
    }

    /**
     * Test of getEmprestimos method, of class EmprestimoDAO.
     */
    @Test
    public void testGetEmprestimos() {
        System.out.println("getEmprestimos");
        EmprestimoDAO instance = new EmprestimoDAO();
        List<Emprestimo> expResult = instance.getEmprestimos();
        List<Emprestimo> result = instance.getEmprestimos();
        
        for (Emprestimo emprestimo : result){
            System.out.println(emprestimo.getAluno().getNome());
        }
        assertEquals(expResult.size(), result.size());

    }
    
}
