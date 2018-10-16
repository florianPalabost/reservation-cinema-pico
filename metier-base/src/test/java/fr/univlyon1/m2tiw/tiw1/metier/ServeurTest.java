/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.serveur.Serveur;
import java.io.IOException;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author florian
 */
public class ServeurTest {
    private Serveur server;
     private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName() );
    
    @Test
    public void initServ() throws IOException{
        server = new Serveur();
        Cinema cinema;
        cinema = server.createCinema();
        LOGGER.info(cinema.toString());
    }
}
