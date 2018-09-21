package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CinemaTest {
    //TODO importer le fichier mon-cinema.json
    ObjectMapper mapper = new ObjectMapper();
    private final Cinema cinema = new Cinema("Mon Cinema");
    //private final MonCinema monCinema = new MonCinema(cinema,cinema.getNom());
    private static final Logger LOGGER = Logger.getLogger( MonCinema.class.getName() );
    
    @Test
    public void testImportJson() throws Exception {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Cinema monCinema = mapper.readValue(new File("F:/Florian/Documents/M2TIW/TIW1 - IS/tiw1-is-2018/metier-base/src/main/resources/sample-data/mon-cinema.json"), Cinema.class);
        mapper.generateJsonSchema(Cinema.class);
        LOGGER.info("MON CINEMA");
        LOGGER.info(mapper.toString());
        LOGGER.info(monCinema.toString());
      //  LOGGER.log( Level.FINE, "Start test json", monCinema);
    
    }
    
    @Test
    /**
     * Teste si on a bien 4 séances / jour x 7 jours x 3 salles = 84 séances
     */
    public void getNbSeances() throws Exception {
        assertEquals(84, cinema.getNbSeances());
    }
}
