package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONSalleDAO;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author florian
 */
public class SalleTest {
    private List<Salle> salles;
    private static final Logger LOGGER = Logger.getLogger(SalleTest.class.getName());

    @Test
    public void getSalles() {
        try {
            salles = new JSONSalleDAO().load();
            LOGGER.info(salles.toString());
            assertEquals("[{nom:Salle 1, capacite:100}, {nom:Salle 2, capacite:70}, "
                    + "{nom:Salle 3, capacite:50}]",salles.toString());
        } catch (IOException ex) {
            Logger.getLogger(SalleTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
