/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    private final static Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    
    public ConnectionFactory() {
        try {
        FileHandler fh = new FileHandler(this.getClass().getName() + "log.txt");
        LOGGER.addHandler(fh);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        LOGGER.setLevel(Level.ALL);
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/gerenciamento_biblioteca", "root", "");
        } catch (SQLException e) {
            LOGGER.severe("Erro na conexão do banco de dados.");
            LOGGER.severe(e.getMessage());
        }
        return null;
    }
}
