/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.maildaemon.main;

import com.ideiah.controller.AlunoController;
import com.ideiah.controller.ChaveController;
import com.ideiah.controller.EmprestimoController;
import com.ideiah.maildaemon.controller.MailController;
import com.ideiah.maildaemon.logger.MailLogger;
import com.ideiah.model.entity.Aluno;
import com.ideiah.model.entity.Chave;
import com.ideiah.model.entity.Emprestimo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class MailDaemon {
    
    private static final Logger LOGGER = Logger.getLogger(MailDaemon.class.getName());
    public static void main(String[] args) {
        MailDaemon.run();
        
    }

    public static void run() {
        LOGGER.setLevel(Level.ALL);
        try {
            //MailLogger.setup();
            FileHandler fh = new FileHandler("MailDaemon.txt");
            LOGGER.addHandler(fh);
            String conf = new MailDaemon().getConf();
            String[] elmts = conf.split("\\n");
            MailController controller = new MailController();
            controller.setFrom(elmts[0]);
            controller.setHost(elmts[1]);
            controller.setUsername(elmts[2]);
            controller.setPassword(elmts[3]);
        
            ChaveController cc = new ChaveController();
            Chave chave = new Chave();
            chave.setNumero(01);
            chave.setTipo("pequena");
            cc.setChave(chave);
            cc.salvar();
            chave = cc.getTodas().get(0);
            Emprestimo emp = new Emprestimo();
            AlunoController ac = new AlunoController();
            emp.setAluno(ac.getTodos().get(0));
            emp.setChave(chave);
            Calendar datar = new GregorianCalendar();
            datar.set(2013, 01, 17);
            emp.setData_retirada(datar);
            EmprestimoController ec = new EmprestimoController();
            ec.setEmprestimo(emp);
            ec.salvar();
            List<Aluno> alunos = new AlunoController().getAtrasados();
            LOGGER.fine("Tamanho: " + alunos.size());
            controller.sendMails(alunos);
        } catch (FileNotFoundException e) {
            LOGGER.severe("Arquivo não encontrado");
            LOGGER.severe(e.getMessage());
        }
        catch (IOException e) {
            LOGGER.severe("Pau no IO");
            LOGGER.severe(e.getMessage());
        }
        
    }
    
    private String getConf() throws FileNotFoundException, IOException {
            BufferedReader br = new BufferedReader(new FileReader("email_config.txt"));
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
