package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CinemaTest {
    //TODO importer le fichier mon-cinema.json
    /*
    ObjectMapper mapper = new ObjectMapper();
    */
    private Collection<Salle> salles;
   // private Cinema cinema = new Cinema("Mon Cinema",salles);
    /*
    private static final Logger LOGGER = Logger.getLogger( MonCinema.class.getName() );
    private MonCinema monCinema;
    
    public void testImportJson(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(Include.NON_NULL);
        try{
            monCinema = mapper.readValue(new File("src/main/resources/sample-data/mon-cinema.json"),MonCinema.class);
            LOGGER.info("MON CINEMA PARSE JSON");
            LOGGER.info(monCinema.toString());
            LOGGER.info("DONE PARSE JSON");
            // test copy to global var cinema
            //cinema = monCinema.cinema;
            cinema.setFilms(monCinema.cinema.getFilms());
            cinema.setSeances(monCinema.cinema.getSeances());
            cinema.setSalles(monCinema.cinema.getSalles());  
        }
        catch(JsonGenerationException e){
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
 
    }
       */
    @Test
    /**
     * Teste si on a bien 4 séances / jour x 7 jours x 3 salles = 84 séances
     */
    
    public void getNbSeances() throws Exception {
        //testImportJson();
     //   assertEquals(84, cinema.getNbSeances());
    }

}
