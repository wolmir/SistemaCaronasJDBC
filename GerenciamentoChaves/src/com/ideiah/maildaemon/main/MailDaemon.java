/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.maildaemon.main;

import com.ideiah.maildaemon.controller.MailController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class MailDaemon {
    public static void main() throws FileNotFoundException, IOException {
        
        String conf = new MailDaemon().getConf();
        String[] elmts = conf.split("\\n");
        MailController controller = new MailController();
        controller.setFrom(elmts[0]);
        controller.setHost(elmts[1]);
        controller.setUsername(elmts[2]);
        controller.setPassword(elmts[3]);
        
        
    }
    
    private String getConf() throws FileNotFoundException, IOException {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String everything = "";
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
                }
                everything = sb.toString();
            } finally {
                br.close();
            }
            return everything;
    }
    
}
