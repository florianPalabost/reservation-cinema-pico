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
public interface CinemaDAO {

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
    public boolean update(Cinema cinema);
    
    public boolean delete(Cinema cinema);
}
