/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Equips;

/**
 *
 * @author ingjo
 */
@Stateless
public class EquipsFacade extends AbstractFacade<Equips> {

    @PersistenceContext(unitName = "eSportsTournamentsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipsFacade() {
        super(Equips.class);
    }
    
}
