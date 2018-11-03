package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONSalleDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author florian
 */
public class SalleTest {
    private List<Salle> salles;
    private static final Logger LOGGER = Logger.getLogger(SalleTest.class.getName());

    @Before
    public void loadSalles() throws IOException {
        salles = new JSONSalleDAO().load();
    }

    @Test
    public void getSalles() throws IOException {
        LOGGER.info(salles.toString());
        assertEquals("[{nom:Salle 1, capacite:100}, {nom:Salle 2, capacite:70}, "
                + "{nom:Salle 3, capacite:50}]", salles.toString());
    }

    @Test
    public void getNbSalles() throws IOException {
        LOGGER.info(salles.toString());

        //Il y a 3 salles
        // - {nom:Salle 1, capacite:100},
        // - {nom:Salle 2, capacite:70},
        // - {nom:Salle 3, capacite:50}
        assertEquals(3, salles.size());
    }

    @Test
    public void getNom() throws IOException {
        LOGGER.info(salles.get(0).getNom());
        LOGGER.info(salles.get(1).getNom());
        LOGGER.info(salles.get(2).getNom());

        //Il y a 3 salles
        // - {nom:Salle 1, capacite:100},
        // - {nom:Salle 2, capacite:70},
        // - {nom:Salle 3, capacite:50}
        int i = 1;
        while(i <= salles.size()) {
            assertEquals("Salle " +i , salles.get(i - 1).getNom());
            i++;
        }
    }

    @Test
    public void getCapacite() throws IOException {
        //Il y a 3 salles
        // - {nom:Salle 1, capacite:100},
        // - {nom:Salle 2, capacite:70},
        // - {nom:Salle 3, capacite:50}
        assertEquals(100, salles.get(0).getCapacite());
        assertEquals(70 , salles.get(1).getCapacite());
        assertEquals(50, salles.get(2).getCapacite());
    }
}
