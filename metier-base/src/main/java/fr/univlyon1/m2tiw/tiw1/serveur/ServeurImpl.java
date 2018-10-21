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
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceFilms;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceSalles;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaRessourceSeances;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        DefaultPicoContainer pico = new DefaultPicoContainer();
        pico.addComponent(JSONSalleDAO.class);
        pico.addComponent(JPAReservationDAO.class);
        pico.addComponent(pico.getComponent(JSONSalleDAO.class).load());
        pico.addComponent(JSONProgrammationDAO.class);
        pico.addComponent(JSONCinemaDAO.class);
        pico.addComponent("mon-cinema");
        
        
        // classes uniformisation 2.2
        // pico.addComponent(CinemaRessourceFilms.class);
        // pico.addComponent(CinemaRessourceSalles.class);
        // pico.addComponent(CinemaRessourceSeances.class);
        
        // cineRessFilm = pico.getComponent(CinemaRessourceFilms.class);
        // cineRessSalles = pico.getComponent(CinemaRessourceSalles.class);
        // cineRessSeances = pico.getComponent(CinemaRessourceSeances.class);
        
        // nom : "Mon Cinema", même string pour déduire le nom du ficher 
        // et nommer le cinéma
        // On appelle JSONCinemDAO a partir de pico pour recuperer le cinema
        // on utilise load(nom, salles, progDAO,reservDAO) de cette classe
        cinema = pico.getComponent(JSONCinemaDAO.class).load("mon-cinema",
            pico.getComponent(JSONSalleDAO.class).load(),
            pico.getComponent(JSONProgrammationDAO.class),
            pico.getComponent(JPAReservationDAO.class));
        
        // voir si utile de les laisser ?
        pico.addComponent(Integer.class);
        pico.addComponent(String.class);
        pico.addComponent(Cinema.class);
        
        // lancement du cinema
        //cinema.start();
        LOGGER.info("SERVEUR PICO : CINEMA = " + cinema.toString());
    }
    
    /**
     * 
     * @return une instance du cinema créé
     * @throws IOException IOException
     * @throws ParseException ParseException
     */
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
    
    
    /**
     *
     * @param commande methodes add,remove,get,...
     * @param parametres paires nom/valeur des parametres des requetes
     * @return
     */
    @Override
    public Object processRequest(String commande, Map<String, Object> parametres){
        Object o = null;
        cinema.process(commande,parametres);
/*        switch(commande) {
            default:
            case "getSalles":
                o = cinema.process(commande,parametres);
                LOGGER.info("getSalles toString()");
                LOGGER.info(o.toString());
                break;
            case "getFilms":
                o = cinema.getFilms();
                LOGGER.info("getFilms toString()");
                LOGGER.info(o.toString());
                break;
            case "getFilm":
                o= cinema.getFilm((String) parametres.get("film"));
                LOGGER.info("getFilm: "+o.toString());
                break;
        }
  */      
        return o;  
    } 
    
    
    
    
    // methode service cense renvoyer une ref vers instance de Cinema
    public Cinema getCinema() {
        return cinema;
    }
    
    

   
    
}
