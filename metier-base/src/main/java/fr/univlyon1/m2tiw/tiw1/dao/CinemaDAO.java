/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;

/**
 *
 * @author florian
 */
public interface CinemaDAO extends GenericDAO<Integer,Cinema>{

    /**
     *
     * @param name
     * @return
     */
    public Cinema findByName(String name);  
    /**
     *
     * @param cinema
     * @return 
     */
    @Override
    public boolean update(Cinema cinema);
    
    @Override
    public boolean delete(Cinema cinema);
}
