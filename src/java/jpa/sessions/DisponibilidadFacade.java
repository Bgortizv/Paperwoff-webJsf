/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entidades.Disponibilidad;

/**
 *
 * @author Gus
 */
@Stateless
public class DisponibilidadFacade extends AbstractFacade<Disponibilidad> {

    @PersistenceContext(unitName = "PaperwoffPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisponibilidadFacade() {
        super(Disponibilidad.class);
    }
    
    public List<Disponibilidad[]> ListaDisponiblesFiltro(long idUser) {
         List<Disponibilidad[]> Tutorf ;
        Query query;
        String consulta;
        try {
            consulta = "select Dispo.Fecha, Dispo.Hora_inicio, Dispo.Hora_fin, Usuarios.Nombre, Usuarios.Apellidos From tyt.disponibilidad As Dispo Inner Join tyt.tutores As Tutores On Dispo.Tutores_id_Tutores = Tutores.id_Tutores Inner Join tyt.users As Usuarios On Tutores.Users_id_User = Usuarios.id_User Where Usuarios.id_User=?;";
            query = em.createNativeQuery(consulta);
            query.setParameter(1, idUser);
                
          // Tutorf = query.getResultList();
            System.out.println("Consulta: " +query.getResultList());
           // if (Tutorf!=null){
                return query.getResultList();
           //  return Tutorf;
         //   }
        }           
        catch (Exception e) {
            throw e;
        }
      
     }
    
}
