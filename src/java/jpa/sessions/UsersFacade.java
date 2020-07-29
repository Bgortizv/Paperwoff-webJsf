/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import jpa.entidades.Users;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author Gus
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "PaperwoffPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    
    public Users consultaN(String nombre){
    Users retorno = new Users();
    
    String nombreconsulta = "select * FROM Users Where nombre=" + nombre;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PaperwoffPU");
     EntityManager em=emf.createEntityManager();
    
    Query consultanombre = em.createNamedQuery(nombreconsulta);
    retorno = (Users) consultanombre.getSingleResult();
    return retorno;
    }
    
    public Users ValidarUsuario(Users usuario){
        Users usuarios = null;
        
        String consulta = "Select * From Users where Documento=? ";
        Query query = em.createNativeQuery(consulta, Users.class);
        query.setParameter(1, usuario.getDocumento());
        List<Users> uslista= query.getResultList();
        if (!uslista.isEmpty()){ 
            usuarios = uslista.get(0);
        System.out.println("OBJETOINICIO" + uslista);
    }      
        return usuarios;
    }
    
    
    public Users ValidarContrasenia(String documento, String contrasena){
    Users contrasenia = null;
        System.out.println("documento " + documento);
        System.out.println("contrasenia " + contrasena);
   
    try{
        String consulta2 = "Select * From Users where Documento="+documento+" and Password='"+contrasena+"' ";
        Query query =em.createNativeQuery(consulta2, Users.class);
//        query.setParameter(1, documento);
//        query.setParameter(2, contrasena);
   System.out.println("OBJETO CONSULTA" + consulta2);
        List<Users> contralista = query.getResultList();
            System.out.println("OBJETO" + contralista);
             //System.out.println("numero de registros: "+uslista.size());
    if (!contralista.isEmpty()){ 
        contrasenia = contralista.get(0);
    
    }
    }catch(Exception e){    
    throw e;
    }
    return contrasenia;
    }
}