package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONCinemaDAO;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;
import org.junit.Test;

public class CinemaTest {
 
    private Collection<Salle> salles;
   // private Cinema cinema = new Cinema("Mon Cinema",salles);
    
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName() );
    private Cinema cinema;
    
    @Test
    public void testImportJson(){
        try{
            cinema = new JSONCinemaDAO().load();
            LOGGER.info("cinema.toString()");
            LOGGER.info(cinema.toString());
            // assert cinema bien rempli TODO
            
        } catch(JsonGenerationException e){
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
      /* 
    @Test
    /**
     * Teste si on a bien 4 séances / jour x 7 jours x 3 salles = 84 séances
     */
    /*
    public void getNbSeances() throws Exception {
        //testImportJson();
     //   assertEquals(84, cinema.getNbSeances());
    }
*/
}
