/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import java.util.List;
import jpa.entidades.Users;

/**
 *
 * @author Gus
 */
public interface CorreosMasivos {
    
     
    public void sendMail(String fromMail,String username,String password,
            List<Object> toMail,String subject,String message);
    
}
