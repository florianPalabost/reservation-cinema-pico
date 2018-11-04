package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 *
 * SeanceTest .
 *
 * @author alper
 */
public class SeanceTest {

    // Les films
    private Film film1 = new Film("Incendies", "VF", "https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1");
    private Film film2 = new Film("Limitless", "VO", "https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3");
    private Film film3 = new Film("Ant-Man and the Wasp", "VO", "https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3");

    // Les salles
    private Salle salle1 = new Salle("Salle1", 30);
    private Salle salle2 = new Salle("Salle2", 50);
    private Salle salle3 = new Salle("Salle3", 90);

    // Les dates
    private String d1 = "2018-02-14 21:00:00 CET";
    private String d2 = "2018-05-19 19:30:00 CET";
    private String d3 = "2018-08-11 20:00:00 CET";

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");

    private Date date1 = format.parse(d1);
    private Date date2 = format.parse(d2);
    private Date date3 = format.parse(d3);

    // Les quatre seances qu'on va creer
    private Seance seance1 = new Seance(film1, salle1, date1, 20.00f);
    private Seance seance2 = new Seance(film2, salle2, date2, 15.50f);
    private Seance seance3 = new Seance(film3, salle3, date3, 10.00f);
    // seance4 = seance1
    private Seance seance4 = new Seance(film1, salle1, date1, 20.00f);

    private static final Logger LOGGER = Logger.getLogger(SeanceTest.class.getName());

    public SeanceTest() throws ParseException {
    }


    /**
     *
     * seances()
     *
     */
    @Before
    public void seances() {

        LOGGER.info("Seance 1 : " + seance1.toString());
        /* Seance 1 : {film:{titre:Incendies, version:VF,
        fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1},
        salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018,
        prix:20.0, reservations:[], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e} */

        LOGGER.info("Seance 2 : " + seance2.toString());
        /* Seance 2 : {film:{titre:Limitless, version:VO,
        fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3},
        salle:{nom:Salle2, capacite:50}, date:Sat May 19 20:30:00 CEST 2018,
        prix:15.5, reservations:[], id:87be2690-e594-374f-989b-9351e1dcc966} */

        LOGGER.info("Seance 3 : " + seance3.toString());
        /* Seance 3 : {film:{titre:Ant-Man and the Wasp, version:VO,
        fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3},
        salle:{nom:Salle3, capacite:90}, date:Sat Aug 11 21:00:00 CEST 2018,
        prix:10.0, reservations:[], id:688598f4-6586-3f4d-8bf7-321e02199a01} */

        LOGGER.info("Seance 4 : " + seance4.toString());
        /* Seance 4 : {film:{titre:Incendies, version:VF,
        fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1},
        salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018,
        prix:20.0, reservations:[], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e} */
    }

    @Test
    public void getFilm() {

        LOGGER.info("Premier Film : " + seance1.getFilm().toString());
        // {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}

        LOGGER.info("Deuxieme Film : " + seance2.getFilm().toString());
        // {titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}

        LOGGER.info("Troisieme Film : " + seance3.getFilm().toString());
        // {titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}

        LOGGER.info("Quatrieme Film : " + seance4.getFilm().toString());
        // {titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}

        assertEquals("{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}", seance1.getFilm().toString());
        assertEquals("{titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}", seance2.getFilm().toString());
        assertEquals("{titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}", seance3.getFilm().toString());
        assertEquals("{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}", seance4.getFilm().toString());
    }

    @Test
    public void getSalle() {

        LOGGER.info("Premiere Salle : " + seance1.getSalle().toString());
        // {nom:Salle1, capacite:30}

        LOGGER.info("Deuxieme Salle : " + seance2.getSalle().toString());
        // {nom:Salle2, capacite:50}

        LOGGER.info("Troisieme Salle : " + seance3.getSalle().toString());
        // {nom:Salle3, capacite:90}

        LOGGER.info("Quatrieme Salle : " + seance4.getSalle().toString());
        // {nom:Salle1, capacite:30}

        assertEquals("{nom:Salle1, capacite:30}", seance1.getSalle().toString());
        assertEquals("{nom:Salle2, capacite:50}", seance2.getSalle().toString());
        assertEquals("{nom:Salle3, capacite:90}", seance3.getSalle().toString());
        assertEquals("{nom:Salle1, capacite:30}", seance4.getSalle().toString());
    }

    @Test
    public void getDate() {

        LOGGER.info("Premiere Date : " + seance1.getDate().toString());
        // Wed Feb 14 21:00:00 CET 2018

        LOGGER.info("Deuxieme Date : " + seance2.getDate().toString());
        // May 19 20:30:00 CEST 2018

        LOGGER.info("Troisieme Date : " + seance3.getDate().toString());
        // Sat Aug 11 21:00:00 CEST 2018

        LOGGER.info("Quatrieme Date : " + seance4.getDate().toString());
        // Wed Feb 14 21:00:00 CET 2018

        assertEquals("Wed Feb 14 21:00:00 CET 2018", seance1.getDate().toString());
        assertEquals("Sat May 19 20:30:00 CEST 2018", seance2.getDate().toString());
        assertEquals("Sat Aug 11 21:00:00 CEST 2018", seance3.getDate().toString());
        assertEquals("Wed Feb 14 21:00:00 CET 2018", seance4.getDate().toString());
    }

    @Test
    public void getPrix() {

        LOGGER.info("Premier Prix : " + seance1.getPrix());
        // 20.0

        LOGGER.info("Deuxieme Prix : " + seance2.getPrix());
        // 15.5

        LOGGER.info("Troisieme Prix : " + seance3.getPrix());
        // 10.7

        LOGGER.info("Quatrieme Prix : " + seance4.getPrix());
        // 10.0

        assertEquals(20.0, seance1.getPrix(), 0);
        assertEquals(15.5, seance2.getPrix(), 0);
        assertEquals(10.0, seance3.getPrix(), 0);
        assertEquals(20.0, seance4.getPrix(), 0);
    }

    @Test
    public void getId() {

        LOGGER.info("Premier ID : " + seance1.getId());
        // 5d2d38e8-890c-3bba-be52-efd31f58eb7e

        LOGGER.info("Deuxieme ID : " + seance2.getId());
        // 87be2690-e594-374f-989b-9351e1dcc966

        LOGGER.info("Troisieme ID : " + seance3.getId());
        // 688598f4-6586-3f4d-8bf7-321e02199a01

        LOGGER.info("Quatrieme ID : " + seance4.getId());
        // 5d2d38e8-890c-3bba-be52-efd31f58eb7e

        assertEquals("5d2d38e8-890c-3bba-be52-efd31f58eb7e", seance1.getId());
        assertEquals("87be2690-e594-374f-989b-9351e1dcc966", seance2.getId());
        assertEquals("688598f4-6586-3f4d-8bf7-321e02199a01", seance3.getId());
        assertEquals("5d2d38e8-890c-3bba-be52-efd31f58eb7e", seance4.getId());
    }

    @Test
    public void createReservation() throws SeanceCompleteException {

        seance1.createReservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");
        seance2.createReservation("Florian", "PALABOST", "florian@palabost.fr");
        seance3.createReservation("Eric", "CLAPTON", "ericlapton@gmail.com");
        seance4.createReservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");

        LOGGER.info("Premiere Seance : " + seance1.toString());
        /* Premiere Seance : {film:{titre:Incendies, version:VF,
        fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1},
        salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0,
        reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr,
        paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}],
        id:5d2d38e8-890c-3bba-be52-efd31f58eb7e} */

        LOGGER.info("Deuxieme Seance : " + seance2.toString());
        /* Deuxieme Seance : {film:{titre:Limitless, version:VO,
        fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3},
        salle:{nom:Salle2, capacite:50}, date:Sat May 19 20:30:00 CEST 2018, prix:15.5,
        reservations:[{id:null, prenom:Florian, nom:PALABOST, email:florian@palabost.fr,
        paye:true, seanceId:87be2690-e594-374f-989b-9351e1dcc966}],
        id:87be2690-e594-374f-989b-9351e1dcc966} */

        LOGGER.info("Troisieme Seance : " + seance3.toString());
        /* Troisieme Seance : {film:{titre:Ant-Man and the Wasp, version:VO,
        fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3},
        salle:{nom:Salle3, capacite:90}, date:Sat Aug 11 21:00:00 CEST 2018, prix:10.0,
        reservations:[{id:null, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com,
        paye:true, seanceId:688598f4-6586-3f4d-8bf7-321e02199a01}],
        id:688598f4-6586-3f4d-8bf7-321e02199a01} */

        LOGGER.info("Quatrieme Seance : " + seance4.toString());
        /* Quatrieme Seance : {film:{titre:Incendies, version:VF,
        fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1},
        salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0,
        reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr,
        paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}],
        id:5d2d38e8-890c-3bba-be52-efd31f58eb7e} */

        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance1.toString());
        assertEquals("{film:{titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}, salle:{nom:Salle2, capacite:50}, date:Sat May 19 20:30:00 CEST 2018, prix:15.5, reservations:[{id:null, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, paye:true, seanceId:87be2690-e594-374f-989b-9351e1dcc966}], id:87be2690-e594-374f-989b-9351e1dcc966}", seance2.toString());
        assertEquals("{film:{titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}, salle:{nom:Salle3, capacite:90}, date:Sat Aug 11 21:00:00 CEST 2018, prix:10.0, reservations:[{id:null, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, paye:true, seanceId:688598f4-6586-3f4d-8bf7-321e02199a01}], id:688598f4-6586-3f4d-8bf7-321e02199a01}", seance3.toString());
        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance4.toString());
    }

    @Test
    public void cancelReservation() throws SeanceCompleteException {

        seance1.createReservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");
        seance2.createReservation("Florian", "PALABOST", "florian@palabost.fr");
        seance3.createReservation("Eric", "CLAPTON", "ericlapton@gmail.com");
        seance4.createReservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");

        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance1.toString());
        assertEquals("{film:{titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}, salle:{nom:Salle2, capacite:50}, date:Sat May 19 20:30:00 CEST 2018, prix:15.5, reservations:[{id:null, prenom:Florian, nom:PALABOST, email:florian@palabost.fr, paye:true, seanceId:87be2690-e594-374f-989b-9351e1dcc966}], id:87be2690-e594-374f-989b-9351e1dcc966}", seance2.toString());
        assertEquals("{film:{titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}, salle:{nom:Salle3, capacite:90}, date:Sat Aug 11 21:00:00 CEST 2018, prix:10.0, reservations:[{id:null, prenom:Eric, nom:CLAPTON, email:ericlapton@gmail.com, paye:true, seanceId:688598f4-6586-3f4d-8bf7-321e02199a01}], id:688598f4-6586-3f4d-8bf7-321e02199a01}", seance3.toString());
        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[{id:null, prenom:Alper, nom:EKMEKCI, email:alper@alperekmekci.fr, paye:true, seanceId:5d2d38e8-890c-3bba-be52-efd31f58eb7e}], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance4.toString());

        Reservation reservation1 = new Reservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");
        seance1.cancelReservation(reservation1);

        Reservation reservation2 = new Reservation("Florian", "PALABOST", "florian@palabost.fr");
        seance2.cancelReservation(reservation2);

        Reservation reservation3 = new Reservation("Eric", "CLAPTON", "ericlapton@gmail.com");
        seance3.cancelReservation(reservation3);

        Reservation reservation4 = new Reservation("Alper", "EKMEKCI", "alper@alperekmekci.fr");
        seance4.cancelReservation(reservation4);

        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance1.toString());
        assertEquals("{film:{titre:Limitless, version:VO, fiche:https://www.imdb.com/title/tt1219289/?ref_=nv_sr_3}, salle:{nom:Salle2, capacite:50}, date:Sat May 19 20:30:00 CEST 2018, prix:15.5, reservations:[], id:87be2690-e594-374f-989b-9351e1dcc966}", seance2.toString());
        assertEquals("{film:{titre:Ant-Man and the Wasp, version:VO, fiche:https://www.imdb.com/title/tt5095030/?ref_=nv_sr_3}, salle:{nom:Salle3, capacite:90}, date:Sat Aug 11 21:00:00 CEST 2018, prix:10.0, reservations:[], id:688598f4-6586-3f4d-8bf7-321e02199a01}", seance3.toString());
        assertEquals("{film:{titre:Incendies, version:VF, fiche:https://www.imdb.com/title/tt1255953/?ref_=nv_sr_1}, salle:{nom:Salle1, capacite:30}, date:Wed Feb 14 21:00:00 CET 2018, prix:20.0, reservations:[], id:5d2d38e8-890c-3bba-be52-efd31f58eb7e}", seance4.toString());
    }

    @Test
    public void equalsTest() {

        assertEquals(true, seance1.equals(seance1));
        assertEquals(false, seance1.equals(seance2));
        assertEquals(false, seance1.equals(seance3));
        assertEquals(true, seance1.equals(seance4));

        assertEquals(false, seance2.equals(seance1));
        assertEquals(true, seance2.equals(seance2));
        assertEquals(false, seance2.equals(seance3));
        assertEquals(false, seance2.equals(seance4));

        assertEquals(false, seance3.equals(seance1));
        assertEquals(false, seance3.equals(seance2));
        assertEquals(true, seance3.equals(seance3));
        assertEquals(false, seance3.equals(seance4));

        assertEquals(true, seance4.equals(seance1));
        assertEquals(false, seance4.equals(seance2));
        assertEquals(false, seance4.equals(seance3));
        assertEquals(true, seance4.equals(seance4));
    }

}
