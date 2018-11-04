package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JPAReservationDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 *
 * JPAReservationDAOTest .
 *
 * @author alper
 */
// NAME_ASCENDING : Pour faire les test, il suivit un ordre alphabetique
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAReservationDAOTest {

    private static final Logger LOGGER = Logger.getLogger(JPAReservationDAOTest.class.getName());
    private EntityManager em = null;
    private ReservationDAO rdao;

    private Reservation reservation1 = new Reservation("Alper",
            "EKMEKCI", "alper@alperekmekci.fr");
    private Reservation reservation2 = new Reservation("Florian",
            "PALABOST", "florian@palabost.fr");
    private Reservation reservation3 = new Reservation("Eric",
            "CLAPTON", "ericlapton@gmail.com");

    @Before
    public void setup() {
        em = Persistence.createEntityManagerFactory("pu").createEntityManager();
        rdao = new JPAReservationDAO(em);
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void aaSave() {

        // -------------- Save reservation1 --------------
        reservation1.setSeanceId("Seance1");
        rdao.save(reservation1);

        LOGGER.info(rdao.getBySeance("Seance1").toString());
        LOGGER.info(rdao.getBySeance("Seance2").toString());

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, seanceId:Seance1}]", rdao.getBySeance("Seance1").toString());
        assertEquals("[]", rdao.getBySeance("Seance2").toString());

        // -------------- Save reservation2 --------------
        reservation2.setSeanceId("Seance2");
        rdao.save(reservation2);

        LOGGER.info(rdao.getBySeance("Seance1").toString());
        LOGGER.info(rdao.getBySeance("Seance2").toString());

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, seanceId:Seance1}]", rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}]", rdao.getBySeance("Seance2").toString());

        // -------------- Save reservation3 --------------
        reservation3.setSeanceId("Seance1");
        rdao.save(reservation3);

        LOGGER.info(rdao.getBySeance("Seance1").toString());
        LOGGER.info(rdao.getBySeance("Seance2").toString());

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, seanceId:Seance1}, "
                + "{id:3, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, "
                + "paye:false, seanceId:Seance1}]", rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}]", rdao.getBySeance("Seance2").toString());
    }

    @Test
    public void bbDelete() {

        reservation1.setSeanceId("Seance1");
        reservation2.setSeanceId("Seance2");
        reservation3.setSeanceId("Seance1");

        rdao.save(reservation1);
        rdao.save(reservation2);
        rdao.save(reservation3);

        // Avant de commencer delete
        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false," + " seanceId:Seance1}, {id:3, prenom:Eric, nom:CLAPTON, "
                + "email:ericlapton@gmail.com, paye:false, seanceId:Seance1}, "
                + "{id:4, prenom:Alper, nom:EKMEKCI, "
                + "email:alper@alperekmekci.fr, paye:false, seanceId:Seance1}, "
                + "{id:6, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, paye:false, "
                + "seanceId:Seance1}]", rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}, {id:5, prenom:Florian, nom:PALABOST, "
                + "email:florian@palabost.fr, paye:false, seanceId:Seance2}]",
                rdao.getBySeance("Seance2").toString());

        // -------------- delete reservation1 --------------
        rdao.delete(reservation1);

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, "
                + "seanceId:Seance1}, {id:3, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, "
                + "paye:false, seanceId:Seance1}, {id:6, prenom:Eric, nom:CLAPTON, "
                + "email:ericlapton@gmail.com, paye:false, seanceId:Seance1}]",
                rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}, {id:5, prenom:Florian, nom:PALABOST, "
                + "email:florian@palabost.fr, paye:false, seanceId:Seance2}]",
                rdao.getBySeance("Seance2").toString());

        // -------------- delete reservation2 --------------
        rdao.delete(reservation2);

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, seanceId:Seance1}, {id:3, prenom:Eric, nom:CLAPTON, "
                + "email:ericlapton@gmail.com, paye:false, seanceId:Seance1}, "
                + "{id:6, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, paye:false, "
                + "seanceId:Seance1}]", rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}]",
                rdao.getBySeance("Seance2").toString());

        // -------------- delete reservation3 --------------
        rdao.delete(reservation3);

        assertEquals("[{id:1, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, "
                + "paye:false, seanceId:Seance1}, {id:3, prenom:Eric, nom:CLAPTON, "
                + "email:ericlapton@gmail.com, paye:false, seanceId:Seance1}]",
                rdao.getBySeance("Seance1").toString());
        assertEquals("[{id:2, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, "
                + "paye:false, seanceId:Seance2}]", rdao.getBySeance("Seance2").toString());
    }

    @Test
    public void ccGetBySeance() {

        reservation1.setSeanceId("Seance1");
        rdao.save(reservation1);

        reservation2.setSeanceId("Seance2");
        rdao.save(reservation2);

        reservation3.setSeanceId("Seance1");
        rdao.save(reservation3);

        Collection<Reservation> reservations1 = rdao.getBySeance("Seance1");
        Collection<Reservation> reservations2 = rdao.getBySeance("Seance2");

        assertTrue(reservations1.contains(reservation1));
        assertFalse(reservations2.contains(reservation1));

        assertTrue(reservations2.contains(reservation2));
        assertFalse(reservations1.contains(reservation2));

        assertTrue(reservations1.contains(reservation3));
        assertFalse(reservations2.contains(reservation3));

        assertEquals(4, reservations1.size());
        assertEquals(2, reservations2.size());
    }

    @Test
    public void ddGetById()  {

        reservation1.setSeanceId("Seance1");
        rdao.save(reservation1);

        reservation2.setSeanceId("Seance2");
        rdao.save(reservation2);

        reservation3.setSeanceId("Seance1");
        rdao.save(reservation3);

        Reservation reservationsId1 = rdao.getById(10);
        Reservation reservationsId2 = rdao.getById(11);
        Reservation reservationsId3 = rdao.getById(12);

        assertEquals(reservation1, reservationsId1);
        assertEquals(reservation2, reservationsId2);
        assertEquals(reservation3, reservationsId3);
    }

}
