/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.Seance;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author florian
 */
public abstract class CinemaAbs implements CinemaInt{
    private static final Logger LOGGER = Logger.getLogger(ServeurImpl.class.getName());
    // private final String nom;
    private Map<String, Salle> salles;
    private Map<String, Film> films;
    private List<Seance> seances;
    private ReservationDAO reservationDAO;
    private ProgrammationDAO programmationDAO;
    private final String methode="";
    private CinemaRessourceFilms cineRessFilms;
    private CinemaRessourceSalles cineRessSalles;
    private CinemaRessourceSeances cineRessSeances;

    @Override
    public void start() {
        LOGGER.info("Component CinemaABSs STARTED. Objet d'acces aux données : "+this.programmationDAO.toString());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        LOGGER.info("SERVER STOPPED");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param methode
     * @param commande
     * @param parametres
     * @return
     * @throws IOException
     */
    @Override
    public Object process(String methode, String commande, Map<String, Object> parametres) throws IOException  {
        // suivant la commande XXXXX appellez le bon CinemaRessourceXXXX
        // SI ON A LE TEMPS : Factoriser ce code ...
        switch (methode) {
            case "FILM":
                return cineRessFilms.process(commande, parametres);      
            case "SALLE":
                return cineRessSalles.process(commande, parametres);   
            case "SEANCE":
                return cineRessSeances.process(commande, parametres);   
            default:
                return null;
        }
    }
    
}
