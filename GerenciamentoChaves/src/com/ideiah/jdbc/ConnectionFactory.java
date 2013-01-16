/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/gerenciamento_biblioteca", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
