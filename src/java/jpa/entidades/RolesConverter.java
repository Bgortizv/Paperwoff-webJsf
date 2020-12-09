/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.sessions.RolesFacade;



/**
 *
 * @author Gus
 */
@FacesConverter(value = "RolesConverter")
@SessionScoped
public class RolesConverter implements Converter{
    @EJB       
    private jpa.sessions.RolesFacade Roles;
        public  List<Roles> Rol ;  

    public List<Roles> getRol() {
        return Rol;
    }

    public void setRol(List<Roles> Rol) {
        this.Rol = Rol;
    }
    public RolesConverter(){
        
        
    }
    
  
  
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        valor = valor.trim();
             //System.out.println("ejb: "+Roles.findAll().size());
       setRol(Roles.findAll());          
        System.out.println("lo que llega de la vista es: "+valor);
                System.out.println("lista: "+Rol.size());
        for(Roles objeto :Rol){
        if(objeto.getIdRole()==Integer.parseInt(valor)){
        return objeto;
        }        
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if(objeto != null){
        return ((Roles) objeto).getIdRole().toString();
        }
        else {
        return "";
        }
    }

}