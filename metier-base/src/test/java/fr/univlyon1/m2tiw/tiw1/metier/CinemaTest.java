package fr.univlyon1.m2tiw.tiw1.metier;

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
            
        } catch (IOException e) {
            e.printStackTrace();
        }
               /*mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(Include.NON_NULL);
        
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
 */
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
