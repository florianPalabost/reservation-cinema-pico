/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceFilms;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceSalles;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceSeances;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;


public class ServeurImpl implements Serveur {
    private Cinema cinema;
    private static final Logger LOGGER = Logger.getLogger(ServeurImpl.class.getName());

    /**
     * Serveur : Instantie un PicoCotainer et recupere Cinema .
     * @throws java.io.IOException IOException
     */
    public ServeurImpl() throws IOException {
        // setup pico container
        DefaultPicoContainer pico = new DefaultPicoContainer(new Caching());
        pico.addComponent(JSONSalleDAO.class);
        pico.addComponent(JPAReservationDAO.class);
        pico.addComponent(pico.getComponent(JSONSalleDAO.class).load());
        pico.addComponent(JSONProgrammationDAO.class);
        pico.addComponent(JSONCinemaDAO.class);
        pico.addComponent("mon-cinema");
        pico.addComponent(Cinema.class);
        
        
        // classes uniformisation 2.2
        pico.addComponent(CinemaRessourceFilms.class);
        pico.addComponent(CinemaRessourceSalles.class);
        pico.addComponent(CinemaRessourceSeances.class);
        
        // cineRessFilm = pico.getComponent(CinemaRessourceFilms.class);
        // cineRessSalles = pico.getComponent(CinemaRessourceSalles.class);
        // cineRessSeances = pico.getComponent(CinemaRessourceSeances.class);
        
        // nom : "Mon Cinema", même string pour déduire le nom du ficher 
        // et nommer le cinéma
        // On appelle JSONCinemDAO a partir de pico pour recuperer le cinema
        // on utilise load(nom, salles, progDAO,reservDAO) de cette classe
        /* cinema = pico.getComponent(JSONCinemaDAO.class).load("mon-cinema",
            pico.getComponent(JSONSalleDAO.class).load(),
            pico.getComponent(JSONProgrammationDAO.class),
            pico.getComponent(JPAReservationDAO.class));
        */
        cinema = pico.getComponent(Cinema.class);
        
        // voir si utile de les laisser ?
        pico.addComponent(Integer.class);
        pico.addComponent(String.class);
        
        // lancement du cinema
        cinema.start();
        LOGGER.info("SERVEUR PICO : CINEMA = " + cinema.toString());
    }
    
    /**
     * 
     * @return une instance du cinema créé
     * @throws IOException IOException
     * @throws ParseException ParseException
     */
    /*
    public Cinema createCinema() throws IOException, ParseException {
        List<Salle> salles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO("mon-cinema",salles);
        JPAReservationDAO reservDAO = new JPAReservationDAO();
        cinema = new JSONCinemaDAO().load("Mon Cinema",salles,progDAO,reservDAO);
        
        LOGGER.info("SERVEUR CREATE CINEMA");
        LOGGER.info(cinema.toString());
        return cinema;
    }
    //TODO delete method add & delete salles
   */ 
    
    /**
     *
     * @param methode
     * @param commande methodes add,remove,get,...
     * @param parametres paires nom/valeur des parametres    des requetes
     * @return
     */
    @Override
    public Object processRequest(String methode, String commande, Map<String, Object> parametres){
        try {
            return cinema.process(methode,commande, parametres);
        } catch (IOException ex) {
            Logger.getLogger(ServeurImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServeurImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    
    
    
    // methode service temporaire pour renvoyer une ref vers instance de Cinema
    public Cinema getCinema() {
        return cinema;
    }
    
    

   
    
}
