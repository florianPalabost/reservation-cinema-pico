/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author florian
 */
// gestion des salles
public class CinemaRessourceSalles extends CinemaAbs {
    //addSalle, removeSalle(on oubli ces deux normalement) et enfin getSalles(), getSalle()
    private Map<String, Salle> salles= new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSalles.class.getName());

    public CinemaRessourceSalles(List<Salle> salles) {
        setSalles(salles);
    }
    
    private void addSalle(Salle salle) {
        this.salles.put(salle.getNom(), salle);
    }

    private void removeSalle(Salle salle) {
        this.salles.remove(salle);
    }
    
    private Salle getSalle(String salle) {
        return salles.get(salle);
    }
    
    private Collection<Salle> getSalles() {
        return salles.values();
    }

    public void setSalles(Collection<Salle> nSalles) {
        this.salles.clear();
        for (Salle s : nSalles) {
            addSalle(s);
        }
    }
    
    public int getNbSalles(){
        return this.salles.size();
    }
    
    public Object process(String commande, Map<String,Object> parametres) throws IOException{
         switch (commande) {
            case "getSalles":
                return getSalles();
            
            case "getSalle":
                return getSalle((String) parametres.get("nomSalle"));

            case "addSalle":
                addSalle((Salle)parametres.get("salle"));
                return null;

            case "removeSalle":
                removeSalle((Salle)parametres.get("salle"));
                return null;
                
            case "getNbSalles":
                return getNbSalles();

            default:
                return null;
        }
    }
    
    @Override
    public void start() {
        LOGGER.info("Component "+ this.getClass() +" started");
    }
    
    @Override
    public void stop(){
        LOGGER.info("Component "+ this.getClass() +" stopped");
    }
    
}
