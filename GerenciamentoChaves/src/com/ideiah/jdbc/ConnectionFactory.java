/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    private final static Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    
    public Connection getConnection() {
        LOGGER.setLevel(Level.SEVERE);
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/gerenciamento_biblioteca", "root", "");
        } catch (SQLException e) {
            LOGGER.severe("Erro na conexão do banco de dados.");
            LOGGER.severe(e.getMessage());
        }
        return null;
    }
}
