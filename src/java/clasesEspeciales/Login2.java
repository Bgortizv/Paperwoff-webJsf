/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import jpa.entidades.Users;
import jpa.sessions.UsersFacade;

/**
 *
 * @author Gus
 */
@Named(value = "login2")
@SessionScoped
public class Login2 implements Serializable {
private String ingresous;
private String password;
private String nombreUsuario;

@EJB
private UsersFacade usuario;
private Users User;

    public String getIngresous() {
        return ingresous;
    }

    public void setIngresous(String ingresous) {
        this.ingresous = ingresous;
    }

 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Users getUser() {
        return User;
    }

    public void setUser(Users User) {
        this.User = User;
    }

    
    public Login2() {
    }
    
     public String validar(){
        User = usuario.encontrarUsuarioxLogin(ingresous);
        nombreUsuario = User.getNombre();
        
        if(User!=null){
            if(User.getPassword().equals(password)){
            System.out.println("Redirecciona");  
        }
        System.out.println("Usuario no encontrado");
   
    }
        return null;
    }
    
}
