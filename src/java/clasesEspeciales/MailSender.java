/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jpa.entidades.Users;

/**
 *
 * @author Gus
 */
public class MailSender implements Serializable {
     public  void sendMail(String fromMail,String username,String password,
            List<Object> toMail,String subject,String message) throws AddressException, MessagingException{
       
        Properties props=System.getProperties();
 
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");

                System.out.println("conectó a gmail");
                Session mailSession=Session.getDefaultInstance(props, null);
                mailSession.setDebug(true);
                 
                Message mailMessage=new MimeMessage(mailSession);
               
               
                for(int i = 0; i < toMail.size(); i++){
                    
                       System.out.println("wntro "+toMail); 
                   System.out.println("mailer corre0 "+toMail.get(i));
                        System.out.println("mailer corre1 "+toMail.get(1).toString());
                         System.out.println("mailer corre2 "+toMail.get(2));
                mailMessage.setFrom(new InternetAddress(fromMail));

                 InternetAddress destinatarios ;                 
                 destinatarios = new InternetAddress(toMail.get(i).toString());
                       System.out.println("mailer 1 "+destinatarios);                  
                     
                mailMessage.setRecipient(Message.RecipientType.TO, destinatarios);
                
                System.out.println("mailer 2 "+mailMessage); 
                mailMessage.setContent(message,"text/html");
                System.out.println("mailer 3 "+mailMessage); 
                mailMessage.setSubject(subject);
                    System.out.println("objeto mensaje: "+mailMessage);
                Transport transport=mailSession.getTransport("smtp");
                transport.connect("smtp.gmail.com", username, password);
                transport.sendMessage(mailMessage, mailMessage.getAllRecipients());   
                }
     } 
    }
               



     