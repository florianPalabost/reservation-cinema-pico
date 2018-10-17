/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.Seance;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;


public class ServeurImpl implements Serveur {
    private Cinema cinema;
    private static final Logger LOGGER = Logger.getLogger(ServeurImpl.class.getName());

    /**
     * Serveur : Instantie un PicoCotainer et recupere Cinema .
     * @throws java.io.IOException IOException
     */
    public ServeurImpl() throws IOException {
        List<Salle> salles = new JSONSalleDAO().load();
        //JSONProgrammationDAO progDAO = new JSONProgrammationDAO(salles);
        DefaultPicoContainer pico = new DefaultPicoContainer();
        pico.addConfig("nom", "Mon Cinema");
        //pico.addConfig("salles", salles);
        /*
        try {
            pico.addConfig("films", new JSONProgrammationDAO(salles).getFilms());
            pico.addConfig("seances", new JSONProgrammationDAO(salles).getSeances());
        } catch (ParseException ex) {
            Logger.getLogger(ServeurImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        //pico.addConfig("reservations", new JPAReservationDAO());
        pico.addComponent(JSONSalleDAO.class);
        pico.addComponent(JSONProgrammationDAO.class);
        pico.addComponent(JPAReservationDAO.class);
        pico.addComponent(Film.class);
        pico.addComponent(Salle.class);
        pico.addComponent(Seance.class);
        pico.addComponent(Integer.class);
        pico.addComponent(ArrayList.class);
        //pico.addComponent(salles);
        pico.addComponent(String.class);
        // faire des dependances/ liens avec cinema et film et seances
        pico.addComponent(Cinema.class);
        // recuperer le component de type cinema ?
        cinema = pico.getComponent(Cinema.class);
        pico.start();
        LOGGER.info("SERVEUR PICO CINEMA : " + cinema.toString());
    }
    
    /**
     * 
     * @return une instance du cinema créé
     * @throws IOException IOException
     * @throws ParseException ParseException
     */
    public Cinema createCinema() throws IOException, ParseException {
        List<Salle> salles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO(salles);
        JPAReservationDAO reservDAO = new JPAReservationDAO();
        cinema = new JSONCinemaDAO().load(salles,progDAO,reservDAO);
        
        LOGGER.info("SERVEUR CREATE CINEMA");
        LOGGER.info(cinema.toString());
        return cinema;
    }
    //delete method add & delete salles
    
    // cense renvoyer une ref vers instance de Cinema
    public Cinema getCinema() {
        return cinema;
    }
    
    

   
    
}
