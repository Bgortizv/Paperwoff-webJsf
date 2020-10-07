/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesEspeciales;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import jpa.entidades.Users;
import jpa.sessions.UsersFacade;

/**
 *
 * @author Gus
 */
@Named(value = "login")
@SessionScoped


public class Login implements Serializable{
private String Documento;
private String password;
private String nombreUsuario;

@EJB
private UsersFacade usuario;
private Users User;

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
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
    
   
    public Login() {
    }

    public String validar(){
        User = usuario.encontrarUsuarioxLogin(Documento);
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
