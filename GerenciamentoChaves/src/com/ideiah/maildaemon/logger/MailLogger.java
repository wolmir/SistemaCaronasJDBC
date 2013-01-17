/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.maildaemon.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Usuario
 */
public class MailLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    
    static public void setup() throws IOException {

        // Get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging.txt");

        // Create txt Formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

  }
}
