package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.serveur.Serveur;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author florian
 */
public class ServeurTest {
    private Serveur server;
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName());
    
    /*@Test
    public void testCreateCineWithServ() throws IOException {
        LOGGER.info("--------testCreateCineWithServ------------");
        server = new ServeurImpl();
        Cinema cinema = null;
        try {
            cinema = server.createCinema();
        } catch (ParseException ex) {
            Logger.getLogger(ServeurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.info("classe : " + cinema.getClass());
        assertEquals(cinema.getClass(),Cinema.class);
        assertEquals("Mon Cinema",cinema.getNom());
    }*/
    
    @Test
    public void testInitPicoContainer() throws IOException {
        LOGGER.info("--------testInitPicoContainer------------");
        server = (Serveur)new ServeurImpl();
        //server = new ServeurImpl();
        LOGGER.info("PROCESS REQUEST GETFILMS : "+server.processRequest("getFilms", null));
        // LOGGER.info("test server cinema:" + server.getCinema());
        // Cinema c = server.getCinema();
        // assertEquals("Mon Cinema",c.getNom());
    }
}
