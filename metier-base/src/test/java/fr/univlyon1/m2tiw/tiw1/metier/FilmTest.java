package fr.univlyon1.m2tiw.tiw1.metier;

import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * Film Test .
 *
 * @author alper
 */
public class FilmTest {

    // Les trois films qu'on a trouve sur le site IMDB
    private Film film1 = new Film("Incendies", "VF", "https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1");
    private Film film2 = new Film("Limitless", "VO", "https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3");
    private Film film3 = new Film("Ant-Man and the Wasp", "VO", "https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3");

    // Film4 = Film1
    private Film film4 = new Film("Incendies", "VF", "https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1");
    private static final Logger LOGGER = Logger.getLogger(FilmTest.class.getName());

    @Test
    public void getTitre() {
        // LOGGER.info(film1.toString());
        // {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}
        // LOGGER.info("Titre du premier film est : " + film1.getTitre());

        // LOGGER.info(film2.toString());
        // {titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}
        // LOGGER.info("Titre du deuxieme film est : " + film2.getTitre());

        // LOGGER.info(film3.toString());
        //{titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}
        // LOGGER.info("Titre du toisieme film est : " + film3.getTitre());

        assertEquals("Incendies", film1.getTitre());
        assertEquals("Limitless", film2.getTitre());
        assertEquals("Ant-Man and the Wasp", film3.getTitre());
    }

    @Test
    public void getVersion() {

        // LOGGER.info(film1.toString());
        // {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}
        // LOGGER.info("Titre du premier film est : " + film1.getVersion());

        // LOGGER.info(film2.toString());
        // {titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}
        // LOGGER.info("Titre du deuxieme film est : " + film2.getVersion());

        // LOGGER.info(film3.toString());
        // {titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}
        // LOGGER.info("Titre du toisieme film est : " + film3.getVersion());

        assertEquals("VF", film1.getVersion());
        assertEquals("VO", film2.getVersion());
        assertEquals("VO", film3.getVersion());
    }

    @Test
    public void getFiche() {

        // LOGGER.info(film1.toString());
        // {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}
        // LOGGER.info("Titre du premier film est : " + film1.getFiche());

        // LOGGER.info(film2.toString());
        // {titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}
        // LOGGER.info("Titre du deuxieme film est : " + film2.getFiche());

        // LOGGER.info(film3.toString());
        // {titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}
        // LOGGER.info("Titre du toisieme film est : " + film3.getFiche());

        assertEquals("https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1", film1.getFiche());
        assertEquals("https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3", film2.getFiche());
        assertEquals("https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3", film3.getFiche());
    }

    @Test
    public void equalsTest() {

        // LOGGER.info(film1.toString());
        // Film 1 {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}

        // LOGGER.info(film2.toString());
        // Film 2 {titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}

        // LOGGER.info(film3.toString());
        // Film 3 {titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}

        // LOGGER.info(film4.toString());
        // Film 4 {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}

        assertEquals(true, film1.equals(film1));
        assertEquals(false, film1.equals(film2));
        assertEquals(false, film1.equals(film3));
        assertEquals(true, film1.equals(film4));

        assertEquals(false, film2.equals(film1));
        assertEquals(true, film2.equals(film2));
        assertEquals(false, film2.equals(film3));
        assertEquals(false, film2.equals(film4));

        assertEquals(false, film3.equals(film1));
        assertEquals(false, film3.equals(film2));
        assertEquals(true, film3.equals(film3));
        assertEquals(false, film3.equals(film4));

        assertEquals(true, film4.equals(film1));
        assertEquals(false, film4.equals(film2));
        assertEquals(false, film4.equals(film3));
        assertEquals(true, film4.equals(film4));
    }

}