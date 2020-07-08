/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entidades.Asignaturaxtutor;

/**
 *
 * @author Gus
 */
@Stateless
public class AsignaturaxtutorFacade extends AbstractFacade<Asignaturaxtutor> {

    @PersistenceContext(unitName = "PaperwoffPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturaxtutorFacade() {
        super(Asignaturaxtutor.class);
    }
    
}
