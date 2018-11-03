package fr.univlyon1.m2tiw.tiw1.metier;

import org.junit.Test;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author alper
 */
public class ReservationTest {

    // Les trois reservations qu'on va creer
    private Reservation reservation1 = new Reservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");
    private Reservation reservation2 = new Reservation("Florian", "PALABOST", "florian@palabost.fr");
    private Reservation reservation3 = new Reservation("Eric", "CLAPTON", "ericlapton@gmail.com");

    // reservation4 = reservation1
    private Reservation reservation4 = new Reservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");

    // reservation5 reservation6 et reservation7 n'ont pas de prenom, nom, email, id et paye
    private Reservation reservation5 = new Reservation();
    private Reservation reservation6 = new Reservation();
    private Reservation reservation7 = new Reservation();

    private static final Logger LOGGER = Logger.getLogger(ReservationTest.class.getName());

    @Test
    public void setGetId() {

        reservation1.setId(1L);
        reservation2.setId(2L);
        reservation3.setId(3L);
        reservation4.setId(1L);
        reservation5.setId(5L);
        reservation6.setId(6L);
        reservation7.setId(7L);

        assertEquals(1L, reservation1.getId().longValue());
        assertEquals(2L, reservation2.getId().longValue());
        assertEquals(3L, reservation3.getId().longValue());
        assertEquals(1L, reservation4.getId().longValue());
        assertEquals(5L, reservation5.getId().longValue());
        assertEquals(6L, reservation6.getId().longValue());
        assertEquals(7L, reservation7.getId().longValue());
    }

    @Test
    public void setGetPrenom() {

        // reservation5, reservation6 et reservation7 n'ont pas de prenom
        reservation5.setPrenom("Lara");
        reservation6.setPrenom("Hugo");
        reservation7.setPrenom("Kylian");

        assertEquals("Alper", reservation1.getPrenom());
        assertEquals("Florian", reservation2.getPrenom());
        assertEquals("Eric", reservation3.getPrenom());
        assertEquals("Alper", reservation4.getPrenom());
        assertEquals("Lara", reservation5.getPrenom());
        assertEquals("Hugo", reservation6.getPrenom());
        assertEquals("Kylian", reservation7.getPrenom());
    }

    @Test
    public void setGetNom() {

        // reservation5, reservation6 et reservation7 n'ont pas de nom
        reservation5.setNom("CROFT");
        reservation6.setNom("LLORIS");
        reservation7.setNom("MBAPPE");

        assertEquals("EKMEKCI", reservation1.getNom());
        assertEquals("PALABOST", reservation2.getNom());
        assertEquals("CLAPTON", reservation3.getNom());
        assertEquals("EKMEKCI", reservation4.getNom());
        assertEquals("CROFT", reservation5.getNom());
        assertEquals("LLORIS", reservation6.getNom());
        assertEquals("MBAPPE", reservation7.getNom());
    }

    @Test
    public void setGetEmail() {

        // reservation5, reservation6 et reservation7 n'ont pas email
        reservation5.setEmail("laracroft@croftgames.com");
        reservation6.setEmail("hugo@lloris.fr");
        reservation7.setEmail("kmbappe10@equipedefrance.fr");

        assertEquals("alper@alperekmekci.fr", reservation1.getEmail());
        assertEquals("florian@palabost.fr", reservation2.getEmail());
        assertEquals("ericlapton@gmail.com", reservation3.getEmail());
        assertEquals("alper@alperekmekci.fr", reservation4.getEmail());
        assertEquals("laracroft@croftgames.com", reservation5.getEmail());
        assertEquals("hugo@lloris.fr", reservation6.getEmail());
        assertEquals("kmbappe10@equipedefrance.fr", reservation7.getEmail());
    }

    @Test
    public void setIsPaye() {

        reservation1.setPaye(true);
        reservation2.setPaye(false);
        reservation3.setPaye(false);
        reservation4.setPaye(true);
        reservation5.setPaye(false);
        reservation6.setPaye(true);
        reservation7.setPaye(true);

        assertEquals(true, reservation1.isPaye());
        assertEquals(false, reservation2.isPaye());
        assertEquals(false, reservation3.isPaye());
        assertEquals(true, reservation4.isPaye());
        assertEquals(false, reservation5.isPaye());
        assertEquals(true, reservation6.isPaye());
        assertEquals(true, reservation7.isPaye());
    }

    @Test
    public void setGetSeandId() {

        reservation1.setSeanceId("SeanceID1");
        reservation2.setSeanceId("SeanceID2");
        reservation3.setSeanceId("SeanceID3");
        reservation4.setSeanceId("SeanceID4");
        reservation5.setSeanceId("SeanceID5");
        reservation6.setSeanceId("SeanceID6");
        reservation7.setSeanceId("SeanceID7");

        assertEquals("SeanceID1", reservation1.getSeanceId());
        assertEquals("SeanceID2", reservation2.getSeanceId());
        assertEquals("SeanceID3", reservation3.getSeanceId());
        assertEquals("SeanceID4", reservation4.getSeanceId());
        assertEquals("SeanceID5", reservation5.getSeanceId());
        assertEquals("SeanceID6", reservation6.getSeanceId());
        assertEquals("SeanceID7", reservation7.getSeanceId());
    }

    @Test
    public void equalsTest() {//not ok

        LOGGER.info(reservation1.toString());
        reservation1.setId(1L);
        reservation1.setPaye(true);

        LOGGER.info(reservation2.toString());
        reservation2.setId(2L);
        reservation2.setPaye(false);

        LOGGER.info(reservation3.toString());
        reservation3.setId(3L);
        reservation3.setPaye(false);

        LOGGER.info(reservation4.toString());
        reservation4.setId(1L);
        reservation4.setPaye(true);

        assertEquals(true, reservation1.equals(reservation1));
        assertEquals(false, reservation1.equals(reservation2));
        assertEquals(false, reservation1.equals(reservation3));
        assertEquals(true, reservation1.equals(reservation4));

        assertEquals(false, reservation2.equals(reservation1));
        assertEquals(true, reservation2.equals(reservation2));
        assertEquals(false, reservation2.equals(reservation3));
        assertEquals(false, reservation2.equals(reservation4));

        assertEquals(false, reservation3.equals(reservation1));
        assertEquals(false, reservation3.equals(reservation2));
        assertEquals(true, reservation3.equals(reservation3));
        assertEquals(false, reservation3.equals(reservation4));

        assertEquals(true, reservation4.equals(reservation1));
        assertEquals(false, reservation4.equals(reservation2));
        assertEquals(false, reservation4.equals(reservation3));
        assertEquals(true, reservation4.equals(reservation4));
    }

}