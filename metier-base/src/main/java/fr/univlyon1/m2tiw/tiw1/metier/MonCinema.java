/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier;

/**
 *
 * @author flori
 */
public class MonCinema extends Cinema {
    public Cinema monCinema;

    public MonCinema(Cinema monCinema, String nom) {
        super(nom);
        this.monCinema = monCinema;
    }

    public MonCinema(String nom) {
        super(nom);
    }

    public MonCinema() {
    }
   

    @Override
    public String toString() {
        return "MonCinema{" + "monCinema=" + monCinema + '}';
    }

    public Cinema getMonCinema() {
        return monCinema;
    }

    public void setMonCinema(Cinema monCinema) {
        this.monCinema = monCinema;
    }
    
}
