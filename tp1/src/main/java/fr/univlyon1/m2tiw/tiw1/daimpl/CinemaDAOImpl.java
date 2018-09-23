/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.daimpl;

import fr.univlyon1.m2tiw.tiw1.dao.CinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import javax.persistence.Query;

/**
 *
 * @author florian
 */
public class CinemaDAOImpl extends GenericDAOImpl<Integer,Cinema> implements CinemaDAO {

    @Override
    public Cinema findByName(String name) {
        Query q = em.createQuery(
            "SELECT e FROM " + entityClass.getName() + " e WHERE nom = :name");
        q.setParameter("name", name);
        return (Cinema) q.getResultList();
    }
   
}
