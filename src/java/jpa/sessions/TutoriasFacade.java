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
import jpa.entidades.Tutorias;

/**
 *
 * @author Gus
 */
@Stateless
public class TutoriasFacade extends AbstractFacade<Tutorias> {

    @PersistenceContext(unitName = "PaperwoffPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutoriasFacade() {
        super(Tutorias.class);
    }
    
    
    //Carga masiva de informacion
     public   void  cargarArchivo(String patch){
         System.out.println("ruta: " +patch);
     Tutorias  us = null;
     String consulta;
         try{
        consulta = "LOAD DATA INFILE '"+patch+"' INTO TABLE tyt.tutorias FIELDS TERMINATED BY ';' LINES TERMINATED BY '\\n';";
         System.out.println("consulta completa: " +consulta);
        Query query =   em.createNativeQuery(consulta);
         System.out.println("query: " +query);
    //query.setParameter(1,patch);
  int num = query.executeUpdate();
             System.out.println(" "+num);
   // List<Talonario> uslista = query.getResultList();
             //System.out.println("numero de registros: "+uslista.size());
//    if (!uslista.isEmpty()){ 
//        us = uslista.get(0);
//
//    }
    }catch(Exception e){    
    throw e;
    }
     }
     
     public List<Tutorias[]> ListaTutoriasFiltro(long idUser) {
         List<Tutorias[]> Tutorf ;
        Query query;
        String consulta;
        try {
            consulta = "select * From tyt.tutorias As tuto Inner Join tyt.users As Usuarios On tuto.Users_id_User = Usuarios.id_User Where Usuarios.id_User=?;";
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
     
   public List<Object> listaEstudiantesDeben() {

        String consulta;
        try {
            consulta = "select Usuarios.e_mail FROM tyt.tutorias AS Tutoria INNER JOIN tyt.estudiantes AS Estudiante ON Estudiante.id_Estudiantes = Tutoria.Estudiantes_id_Estudiantes INNER JOIN tyt.Users AS Usuarios ON Estudiante.Users_id_User = Usuarios.id_User where Tutoria.paga = 0;";
            System.out.println("Esta es la consulta nativa = "+consulta);
            Query query = em.createNativeQuery(consulta);
            List<Object> correos=(List<Object> )query.getResultList();
            System.out.println("Este es el getResultlist= "+query.getResultList());
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }

    }
    
}
