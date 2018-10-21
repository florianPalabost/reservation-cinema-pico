package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaWrapper;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CinemaTest {
 
    private Collection<Salle> salles;
    // private Cinema cinema = new Cinema("Mon Cinema",salles);
    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName());
    private Cinema cinema;
    private ServeurImpl serveur;

    @Test
    public void getNbSeances() throws IOException, SeanceCompleteException, ParseException {
        /*List<Salle> sallles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO(sallles);*/
        serveur = new ServeurImpl();
        Cinema c = serveur.createCinema();
        assertEquals(84, c.getNbSeances());
    }

    @Test
    public void testChargementJackson() throws IOException,
            SeanceCompleteException, ParseException {
        CinemaWrapper wrapper = mapper.readValue(Cinema.class.getResource(
                "/sample-data/mon-cinema.json"), CinemaWrapper.class);
        assertEquals(84, wrapper.cinema.seances.size());
    }

    @Test
    public void testReservation() throws IOException, SeanceCompleteException, ParseException {
        /*List<Salle> sallles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO(sallles);
        Cinema c =  new JSONCinemaDAO().load(sallles,progDAO);*/
        serveur = new ServeurImpl();
        Cinema c = serveur.createCinema();
        Seance s = c.getSeances().get(1);
        Reservation r = s.createReservation("titi","machin", "titi.machin@nowhere.net");
        s.cancelReservation(r);
    }
// TESTS GENERES AUTOMATIQUEMENT LES ENLEVER SI INUTILES
    /**
     * Test of toString method, of class Cinema.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cinema instance = null;
        String expResult = "";
        //String result = instance.toString();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Cinema.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Cinema instance = null;
        //instance.start();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class Cinema.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Cinema instance = null;
        //instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testProcessRequest() throws IOException {
        serveur = new ServeurImpl();
        Cinema c = serveur.getCinema();
        HashMap params = new HashMap();
        params.put("film", "Operation Finale");
        LOGGER.info("--------process REQUEST TEST------------");
        LOGGER.info("map params(): "+params.toString());
        LOGGER.info("getFilms(): "+serveur.processRequest("getFilms", null).toString());
        LOGGER.info("getFilm(): "+serveur.processRequest("getFilm", params).toString());
    }   
    
    

}
