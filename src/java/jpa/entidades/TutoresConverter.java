/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.sessions.TutoresFacade;

/**
 *
 * @author Gus
 */
@FacesConverter(value = "TutoresConverter")
public class TutoresConverter implements Converter{

    @EJB 
    TutoresFacade tutoresFacade;
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
                List<Tutores> tutor = this.tutoresFacade.findAll();
        for (Tutores objeto : tutor) {
            if (objeto.getIdTutores() == Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
           if (objeto != null) {
            return ((Tutores) objeto).getIdTutores().toString();
        } else {
            return "";
        }
    }
    
}
