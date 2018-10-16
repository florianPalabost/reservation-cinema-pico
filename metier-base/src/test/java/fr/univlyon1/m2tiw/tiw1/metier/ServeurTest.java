/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.serveur.Serveur;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.picocontainer.PicoContainer;

/**
 *
 * @author florian
 */
public class ServeurTest {
    private Serveur server;
     private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName() );
    
    @Test
    public void testCreateCineWithServ() throws IOException, ParseException{
         LOGGER.info("--------testCreateCineWithServ------------");
        server = new Serveur();
        Cinema cinema = null;
        cinema = server.createCinema();
        LOGGER.info("classe : "+cinema.getClass());
        assertEquals(cinema.getClass(),Cinema.class);
        assertEquals("Mon Cinema",cinema.getNom());
    }
    
    @Test
    public void testInitPicoContainer() throws IOException{
        LOGGER.info("--------testInitPicoContainer------------");
        server = new Serveur();
       
        LOGGER.info("server cinema:"+server.getCinema());
        //assertEquals("Mon Cinema",c.getNom());
    }
}
