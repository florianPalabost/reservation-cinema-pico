/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;


public class Serveur {
    private Cinema cinema;
    /**
     * Serveur : Instantie un PicoCotainer et recupere Cinema .
     * @throws java.io.IOException
     */
    public Serveur() throws IOException {
        List<Salle> salles = new JSONSalleDAO().load();
        MutablePicoContainer pico = new DefaultPicoContainer()
            .addComponent(Cinema.class)
            .addComponent(String.class)
            .addComponent(salles)
            .addComponent(JSONSalleDAO.class)
            .addComponent(JSONProgrammationDAO.class)
            .addComponent(JPAReservationDAO.class);
         // recuperer le component de type cinema ?
        cinema = pico.getComponent(Cinema.class);
        pico.start();  
    }
    
    /**
     * 
     * @return une instance du cinema créé
     * @throws IOException
     * @throws ParseException 
     */
    public Cinema createCinema() throws IOException, ParseException{
        List<Salle> salles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO(salles);
        JPAReservationDAO reservDAO = new JPAReservationDAO();
        Cinema cinema = new JSONCinemaDAO().load(salles,progDAO,reservDAO);
        
        System.out.println(cinema.toString());
        return cinema;
    }
    //delete method add & delete salles
    
    // cense renvoyer une ref vers instance de Cinema
    public Cinema getCinema() {
        return cinema;
    }
    
    

   
    
}
