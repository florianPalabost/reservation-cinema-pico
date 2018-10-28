package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.serveur.Serveur;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author florian
 */
public class ServeurTest {
    private Serveur serveur;
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName());
    
    @Before
    public void initServeur() throws IOException {
        serveur = new ServeurImpl();
    }
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
        LOGGER.info("CLASS SERVEUR : "+serveur.getClass());
        LOGGER.info("PROCESS REQUEST GETFILMS : "+serveur.processRequest("getFilms", null));
        
        Map<String,Object> params = new HashMap<>();
        params.put("class","Seance");
        LOGGER.info(serveur.processRequest("getSeances", params).toString());
        // LOGGER.info("test server cinema:" + server.getCinema());
        // Cinema c = server.getCinema();
        // assertEquals("Mon Cinema",c.getNom());
    }
    
    @Test
    public void testProcessRequest(){
        String nomCinema;
        nomCinema = (String) serveur.processRequest("getNom", null);
        assertEquals("mon-cinema",nomCinema);
    }
}
