/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import jpa.entidades.Users;
//import jpa.sessions.TutoriasFacade;
import jpa.sessions.UsersFacade;
import jpa.sessions.TutoriasFacade;

/**
 *
 * @author Gus
 */
@Named(value = "mainController")
@SessionScoped
public class MainController implements Serializable {
    private String fromMail;
    private String username;
    private String password;
    private List<Object> toMail = new ArrayList<>();
    private List<Object> toMailTuto = new ArrayList<>();

    
    private String subject;
    private String message;
    
     @EJB
    private UsersFacade connFacade;
    private TutoriasFacade tutoria;
     
    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Object> getToMail() {
        return toMail;
    }

    public void setToMail(List<Object> toMail) {
        this.toMail = toMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<Object> getToMailTuto() {
        return toMailTuto;
    }

    public void setToMailTuto(List<Object> toMailTuto) {
        this.toMailTuto = toMailTuto;
    }
        

   

    /**
     * Creates a new instance of MainController
     */
     public void send() {
        toMail = connFacade.obtenerCorreos();
        try {
            MailSender mailSender=new MailSender();
            mailSender.sendMail(fromMail, username, password, toMail, subject, message);
        } catch (Exception e) {
            System.out.println("correo no enviado");
        }
    }
     
          public void sendTutoria() {
        toMailTuto = tutoria.listaEstudiantesDeben();
        try {
            MailSender mailSender=new MailSender();
            mailSender.sendMail(fromMail, username, password, toMail, subject, message);
        } catch (Exception e) {
            System.out.println("correo no enviado");
        }
    }
    
}
