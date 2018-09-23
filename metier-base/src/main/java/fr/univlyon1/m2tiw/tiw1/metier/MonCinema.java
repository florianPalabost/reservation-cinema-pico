/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 *
 * @author florian.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class MonCinema extends Cinema {

    @JsonProperty(value = "cinema")
    public Cinema cinema;

    public MonCinema(Cinema cinema, String nom) {
        super(nom);
        this.cinema = cinema;
    }

    public MonCinema(String nom) {
        super(nom);
    }

    public MonCinema() {
    }
   

    @Override
    public String toString() {
        return  "{" + cinema + '}';
    }

    @JsonProperty(value = "cinema")
    public Cinema getCinema() {
        return cinema;
    }

    @JsonProperty(value = "cinema")
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
}
