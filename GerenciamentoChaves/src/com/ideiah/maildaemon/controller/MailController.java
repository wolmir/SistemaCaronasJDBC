/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.maildaemon.controller;

import com.ideiah.model.entity.Aluno;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MailController {
    
    private final static Logger LOGGER = Logger.getLogger(MailController.class.getName());
    
    private String from;
    private String host;
    private String username;
    private String password;
    
    
    public MailController() {
        try {
        FileHandler fh = new FileHandler(this.getClass().getName() + "log.txt");
        LOGGER.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Session getSession() {
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable","true" );
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true" );
        Authenticator auth = new SMTPAuthenticator(this.username, this.password);
        Session session = Session.getInstance(props, auth);
        return session;
    }
    
    
    private void sendMail(String to, Session session, String message) {
        LOGGER.setLevel(Level.SEVERE);
        try {
            Message msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(to);
            msg.setText(message);
              // -- Set some other header information --
            msg.setHeader("Biblioteca Unipampa", "Gerenciamento Chaves" );
            msg.setSentDate(new Date());
              // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to"+to+" OK." );
        } catch (javax.mail.AuthenticationFailedException e) {
            LOGGER.severe("Falha na autenticação ao enviar email.");
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
        catch (javax.mail.MessagingException m) {
            LOGGER.severe("Erro ao criar mensagem de email.");
            LOGGER.severe(m.getMessage());
            m.printStackTrace();
        }
        
    }
    
    
    public void sendMails(List<Aluno> alunos) {
        for (Aluno aluno: alunos) {
            String message = "Olá, " + aluno.getNome()
                    + ", esta mensagem está sendo enviada porque " +
                    "você pegou uma chave não devolveu.";
            this.sendMail(aluno.getEmail(), this.getSession(), message);
        }
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        private String user;
        private String psswd;
        
        public SMTPAuthenticator(String user, String psswd) {
            super();
            this.user = user;
            this.psswd = psswd;
        }
        @Override
        public PasswordAuthentication getPasswordAuthentication() {                             // specify your password here
            return new PasswordAuthentication(user, psswd);
        }
  }
    
}
