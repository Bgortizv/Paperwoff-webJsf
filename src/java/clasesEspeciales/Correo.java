    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Gus
 */
public class Correo {
    
    public static void send(List<Object> para, String sujeto, String mensaje) throws UnsupportedEncodingException {
        System.out.println("Entro correo");
        final String user = "bgortizv@gmail.com";
        final String pass = "QcGr80vdfJ";

        //1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.starttls.required", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        //2nd paso)compose message
        try {
            /*BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\Microsoft Windows 10\\Desktop\\File\\Archivo.txt")));
            adjunto.setFileName("Archivo.txt");
             */
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
            //multiparte.addBodyPart(adjunto);
            MimeMessage message = new MimeMessage(session);
           
            message.setFrom(new InternetAddress(user, "Global Bill"));
            //retornarDestinatarios(para);

            InternetAddress[] destinatarios = new InternetAddress[para.size()];

            for (int i = 0; i < para.size(); i++) {

            destinatarios[i] = new InternetAddress(para.get(i).toString());
            }

           
            message.addRecipients(Message.RecipientType.TO, destinatarios);
            message.setSubject(sujeto);
            message.setContent(multiparte, "text/html; charset=utf-8");
            
            //3rd paso)send message
            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
