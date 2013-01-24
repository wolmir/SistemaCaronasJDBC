/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.model.dao;

import com.ideiah.jdbc.ConnectionFactory;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Chave;
import com.ideiah.views.emprestimo.ListaChaves;
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
public class ChaveDAOTest {
    
    public ChaveDAOTest() {
    }
    
    public static Connection connection;
    public static List<Chave> listChave;
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        connection=new ConnectionFactory().getConnection();
        
        listChave = (List<Chave>) new ArrayList<Chave>();
        Chave chave1 = new Chave();
        Chave chave2 = new Chave();
        Chave chave3 = new Chave();
        String query = "insert into chave (numero,tipo,status) values (?,?,?);";
        
        chave1.setDisponivel(Boolean.TRUE);
        chave1.setNumero(new Integer(01));
        chave1.setTipo("pequena");
        listChave.add(chave1);
        
        chave2.setDisponivel(Boolean.TRUE);
        chave2.setNumero(new Integer(02));
        chave2.setTipo("grande");
        listChave.add(chave2);
        
        chave3.setDisponivel(Boolean.TRUE);
        chave3.setNumero(new Integer(03));
        chave3.setTipo("pequena");
        listChave.add(chave3);
        
        
        PreparedStatement stmt = connection.prepareStatement(query);
        for (Chave ch : listChave){
            stmt.setInt(1, ch.getNumero());
            stmt.setString(2, ch.getTipo());
            stmt.setBoolean(3, ch.getDisponivel());
            stmt.execute();
        }
        stmt.close();
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        
        String queryTD = "delete from chave;";
        PreparedStatement stmtTD = connection.prepareStatement(queryTD);
        stmtTD.execute();
        stmtTD.close();
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of adiciona method, of class ChaveDAO.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        Chave chave = new Chave();
        ChaveDAO instance = new ChaveDAO();
        
        chave.setDisponivel(Boolean.TRUE);
        chave.setNumero(new Integer (14));
        chave.setTipo("grande");
        listChave.add(chave);
        
        instance.adiciona(chave);
        
        List<Chave> listChaveA;
        listChaveA=instance.getChaves();
        
        boolean flag = false;
        
        for (Chave ch : listChaveA){
            if (ch.getNumero().equals(chave.getNumero())){
                flag = true;
                break;
            }
            else{
                flag = false;
            }
        }
        
        assertEquals("O numero da chave não está disponivel no banco",true,flag);
    }

    /**
     * Test of getChaves method, of class ChaveDAO.
     */
    @Test
    public void testGetChaves() {
        System.out.println("getChaves");
        ChaveDAO instance = new ChaveDAO();
        List<Chave> expResult = listChave;
        List<Chave> result = instance.getChaves();
        boolean flag=false;
        for (Chave ch0 : result){
            for (Chave ch1 : expResult){
                /*  if com operadores binarios && 
                *   ((condição 1)&&(condição2))&&(condição3))
                */
                if(((ch0.getNumero().equals(ch1.getNumero()))&&(ch0.getTipo().equals(ch1.getTipo())))&&(ch0.getDisponivel().equals(ch1.getDisponivel()))){
                    flag=true;
                    break;
                    
                }
                
                else {
                    flag=false;
                }
            }
        }
        assertEquals("Os dados no banco não conferem com os que foram inseridos",true, flag);
    }

    /**
     * Test of altera method, of class ChaveDAO.
     */
    @Test
    public void testAltera() {
        System.out.println("altera");
        Chave chave = new Chave();
        
        chave.setNumero(new Integer (142));
        chave.setTipo("pequena");
        chave.setDisponivel(Boolean.FALSE);
        
        ChaveDAO instance = new ChaveDAO();
        List<Chave> listChaveA2;
        listChaveA2 = instance.getChaves();
        boolean flag=false;
        
//        for (Chave ch : listChaveA2){
//            System.out.println(ch.getNumero());
//        }
        for (Chave ch : listChaveA2){
            if(ch.getNumero().equals(3)){
                chave.setId(ch.getId());
                instance.altera(chave);
                break;
            }
        }
        
        List<Chave> listChaveA21=instance.getChaves();
        
        for (Chave ch : listChaveA21){
            if (ch.getId().equals(chave.getId())){
                if ((ch.getNumero().equals(chave.getNumero())&&(ch.getTipo()).equals(chave.getTipo()))&&(ch.getDisponivel().equals(chave.getDisponivel()))){
                    flag=true;
                    break;
                }
            }
            else {
                flag = false;
            }
        }
        
        assertEquals("Erro na alteração da chave", true, flag);
    }

    /**
     * Test of remove method, of class ChaveDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        ChaveDAO instance = new ChaveDAO();
        boolean flag=false;
        
        List<Chave> listChaveR = instance.getChaves();
        for (Chave ch : listChaveR){
            if (ch.getNumero().equals(2)){
                System.out.println(ch.getNumero());
                instance.remove(ch);
                break;
            }
        }
        
        List<Chave> listChaveR2 = instance.getChaves();
        
        for (Chave ch : listChaveR2){
            if (ch.getNumero().equals(2)){
                flag = false;
                break;
            }
            else {
                flag=true;
            }
        }
        
        assertEquals("Erro durante a remoção",true, flag);
        }
        
    }
