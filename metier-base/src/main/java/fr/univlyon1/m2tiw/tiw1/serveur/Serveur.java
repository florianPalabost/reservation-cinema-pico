/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;


public class Serveur {
    public Cinema createCinema() throws IOException{
        List<Salle> salles = new JSONSalleDAO().load();
        Cinema cinema = new JSONCinemaDAO().load(salles);
        System.out.println(cinema.toString());
        return cinema;
    }
  
    // for pico container TODO Impl
    // public ProgrammationDao progDAO = new ProgrammationDao();
    // public ReservationDao reservationDAO = new ReservationDao();
   
    
    // read salles.json and put it in salles , Do it with the dao
    //public Salledao salleDAO = new Salledao();
    
    //delete method add & delete salles
    
    
    // Create pico container


    /**
     * Serveur .
     */
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
