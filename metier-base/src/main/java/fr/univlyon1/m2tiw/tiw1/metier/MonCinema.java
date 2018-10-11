/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author florian.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class MonCinema extends Cinema {

    /**
     *
     * Le cinema.
     *
     */
    @JsonProperty(value = "cinema")
    private Cinema cinema;

    /**
     *
     * Constructeur de MonCinema.
     *
     * @param monCinema .
     *
     * @param nom .
     *
     */
    public MonCinema(final Cinema monCinema, final String nom) {
        super(nom);
        this.cinema = monCinema;
    }

    /**
     *
     * Constructeur de MonCinema.
     *
     * @param nom .
     *
     */
    public MonCinema(final String nom) {
        super(nom);
    }


    /**
     *
     * Constructeur de MonCinema.
     *
     *
     */
    public MonCinema() {
    }

    /**
     *
     * @return l'affichage.
     *
     */
    @Override
    public String toString() {
        return  "{" + cinema + '}';
    }

    /**
     *
     * @return le cinema .
     *
     */
    @JsonProperty(value = "cinema")
    public Cinema getCinema() {
        return cinema;
    }

    /**
     *
     * Setter de films .
     *
     * @param monCinema .
     *
     */
    @JsonProperty(value = "cinema")
    public void setCinema(final Cinema monCinema) {
        this.cinema = monCinema;
    }

}
