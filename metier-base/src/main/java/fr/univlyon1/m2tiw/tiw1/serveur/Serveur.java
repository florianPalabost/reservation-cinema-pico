/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import java.util.ArrayList;
import java.util.List;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

/**
 *
 * @author florian
 */
public class Serveur {
    public List<Salle> salles = new ArrayList();
    // public Cinema cinema = new Cinema("monCinema",salles);
    // for pico container TODO Impl
    // public ProgrammationDao progDAO = new ProgrammationDao();
    // public ReservationDao reservationDAO = new ReservationDao();
   
    
    // read salles.json and put it in salles , Do it with the dao
    //public Salledao salleDAO = new Salledao();
    
    //delete method add & delete salles
    
    
    // Create pico container
   

    public Serveur() {
        /* MutablePicoContainer pico = new DefaultPicoContainer()
            .addComponent(cinema)
            .addComponent(salles)
            .addComponent(ProgrammationDao.class).addComponent(ReservationDao.class);
         // recupere le component de type cinema
         cinema = pico.getComponent(Cinema.class);
         pico.start();*/
    }
   
    
}
