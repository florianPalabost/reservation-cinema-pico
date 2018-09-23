/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Film;

/**
 *
 * @author florian.
 */
public interface Filmdao {

    /**
     *
     * @param name .
     *
     */
    public abstract Film findByName(String name);

    /**
     *
     * @param film .
     *
     */
    public abstract boolean update(Film film);
    
    /**
     *
     * @param film .
     *
     */
    public abstract boolean delete(Film film);
}
