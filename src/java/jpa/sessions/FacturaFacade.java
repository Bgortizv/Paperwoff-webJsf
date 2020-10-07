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
import jpa.entidades.Factura;

/**
 *
 * @author Gus
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "PaperwoffPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
    public List<Factura[]> ListaFacturasFiltro(long idUser) {
         List<Factura[]> Tutorf ;
        Query query;
        String consulta;
        try {
            consulta = "select Usuarios.Documento, Usuarios.Nombre, Usuarios.Apellidos, Factura.Total_horas, Factura.id_Factura, Factura.Fecha_Creacion, Factura.Total From tyt.factura As Factura Inner Join tyt.tutores As Tutores On Factura.Tutores_id_Tutores = Tutores.id_Tutores Inner Join tyt.users As Usuarios On Tutores.Users_id_User = Usuarios.id_User Where Usuarios.id_User=?;";
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
    
//    public List<Factura> ListaFacturasFiltroPrueba(long idUser) {
//         List<Factura> Tutorf ;
//        Query query;
//        String consulta;
//        try {
//            consulta = "select * From tyt.tutorias As tuto Inner Join tyt.users As Usuarios On tuto.Users_id_User = Usuarios.id_User Where Usuarios.id_User=?;";
//            query = em.createNativeQuery(consulta);
//            query.setParameter(1, idUser);
//                
//          // Tutorf = query.getResultList();
//            System.out.println("Consulta: " +query.getResultList());
//           // if (Tutorf!=null){
//                return query.getResultList();
//           //  return Tutorf;
//         //   }
//        }           
//        catch (Exception e) {
//            throw e;
//        }
//      
//     }
    
    
    
}
