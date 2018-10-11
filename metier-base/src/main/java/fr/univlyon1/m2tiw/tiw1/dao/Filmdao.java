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
     * @return recherche par nom
     *
     */
    Film findByName(String name);

    /**
     *
     * @param film .
     *
     * @return update
     *
     */
    boolean update(Film film);

    /**
     *
     * @param film .
     *
     * @return delete
     *
     */
    boolean delete(Film film);
}
