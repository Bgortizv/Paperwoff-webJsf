/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

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
    
}
