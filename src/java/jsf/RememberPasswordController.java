/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.entidades.Users;
import jsf.util.PaginationHelper;

/**
 *
 * @author Gus
 */
@Named("RememberPasswordController")
@SessionScoped
public class RememberPasswordController implements Serializable{
    
    private Users UsuarioRecordar;
    @EJB
    private jpa.sessions.UsersFacade ejbFacade;
       
    
    public void rememberPassword(){
        
        
        
       
    }
    
}
