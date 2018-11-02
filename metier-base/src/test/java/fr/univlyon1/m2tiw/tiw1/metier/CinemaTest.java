package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.metier.annuaire.Registry;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaWrapper;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
 
    private Collection<Salle> salles;
    // private Cinema cinema = new Cinema("Mon Cinema",salles);
    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName());
    private Cinema cinema;
    private ServeurImpl serveur;
    private Registry annuaire;
    
    @Before
    public void initServeur() throws IOException {
        annuaire = new Registry();
        serveur = new ServeurImpl(annuaire);
    }
    
    @Test
    public void getNbSeances() throws IOException, SeanceCompleteException, ParseException {
        assertEquals(84,serveur.processRequest("SEANCE","getNbSeances",null));
    }

    @Test
    public void testChargementJackson() throws IOException,
            SeanceCompleteException, ParseException {
        CinemaWrapper wrapper = mapper.readValue(Cinema.class.getResource(
                "/sample-data/mon-cinema.json"), CinemaWrapper.class);
        assertEquals(84, wrapper.cinema.seances.size());
    }
/*
    @Test
    public void testReservation() throws IOException, SeanceCompleteException, ParseException {
        // List<Salle> sallles = new JSONSalleDAO().load();
        // JSONProgrammationDAO progDAO = new JSONProgrammationDAO(sallles);
        // Cinema c =  new JSONCinemaDAO().load(sallles,progDAO);
        serveur = new ServeurImpl();
        Cinema c = serveur.createCinema();
        Seance s = c.getSeances().get(1);
        Reservation r = s.createReservation("titi","machin", "titi.machin@nowhere.net");
        s.cancelReservation(r);
    }
*/

    @Test
    public void testProcess() throws IOException {
        //Cinema c = serveur.getCinema();
        HashMap params = new HashMap();
        params.put("nomFilm", (Object)"Operation Finale - VF");
        LOGGER.info("--------process REQUEST TEST------------");
        LOGGER.info("map params(): "+params.toString());
        LOGGER.info("getFilms(): "+serveur.processRequest("FILM","getFilms", null).toString());
        LOGGER.info("getFilm(): "+serveur.processRequest("FILM","getFilm", params).toString());
        
        // TODO faire des methodes pour avoir la taille de films,salles... comme getNbSeances
    }   
    
    

}
