/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc;

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
    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/sistema_caronas", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }
}
