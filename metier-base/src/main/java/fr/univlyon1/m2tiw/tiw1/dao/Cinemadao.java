/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;

/**
 *
 * @author florian.
 */
public interface Cinemadao {

    /**
     *
     * @param name .
     *
     * @return le resultat de la recherche par le nom
     *
     */
    Cinema findByName(String name);

    /**
     *
     * @param cinema .
     *
     * @return update
     *
     */
    boolean update(Cinema cinema);

    /**
     *
     * @param cinema .
     *
     * @return delete
     *
     */
    boolean delete(Cinema cinema);
}
