package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.metier.annuaire.Registry;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaWrapper;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CinemaTest {
 
    private Collection<Salle> salles;
    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(CinemaTest.class.getName());
    private Cinema cinema;
    private ServeurImpl serveur;
    private Registry annuaire;
    
    @Before
    public void initServeur() throws IOException, ClassNotFoundException {
        annuaire = new Registry();
        serveur = new ServeurImpl(annuaire);
    }
    
    @Test
    public void getNbSeances() throws IOException, SeanceCompleteException, ParseException {
        assertEquals(84,serveur.processRequest("SEANCE","getNbSeances",null));
    }

    @Test
    public void testChargementJackson() throws IOException,
            SeanceCompleteException, ParseException {
        CinemaWrapper wrapper = mapper.readValue(Cinema.class.getResource(
                "/sample-data/mon-cinema.json"), CinemaWrapper.class);
        assertEquals(84, wrapper.cinema.seances.size());
    }
/*
    @Test
    public void testReservation() throws IOException, SeanceCompleteException, ParseException {
        // List<Salle> sallles = new JSONSalleDAO().load();
        // JSONProgrammationDAO progDAO = new JSONProgrammationDAO(sallles);
        // Cinema c =  new JSONCinemaDAO().load(sallles,progDAO);
        serveur = new ServeurImpl();
        Cinema c = serveur.createCinema();
        Seance s = c.getSeances().get(1);
        Reservation r = s.createReservation("titi","machin", "titi.machin@nowhere.net");
        s.cancelReservation(r);
    }
*/

    @Test
    public void testProcess() throws IOException {
        //Cinema c = serveur.getCinema();
        HashMap params = new HashMap();
        params.put("titre", "Operation Finale - VF");
        LOGGER.info("--------process REQUEST TEST------------");
        LOGGER.info("map params(): "+params.toString());
        LOGGER.info("getFilms(): "+serveur.processRequest("FILM","getFilms", null).toString());
        LOGGER.info("getFilm(): "+serveur.processRequest("FILM","getFilm", params).toString());
    }

    // ----------- CinemaRessourceFilms -----------
    @Test
    public void getFilms() throws IOException {
        assertEquals("[{titre:Mission Impossible - Fallout, version:VO, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Toto, version:VF, fiche:https://toto.fr}, {titre:BlacKkKlansman, version:VO, fiche:https://www.imdb.com/title/tt7349662/?ref_=inth_ov_tt}, {titre:Burning, version:VO, fiche:https://www.imdb.com/title/tt7282468/?ref_=shtt_ov_tt}, {titre:Mission Impossible - Fallout, version:VF, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Operation Finale, version:VF, fiche:https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt}, {titre:Le poirier sauvage, version:VF, fiche:https://www.imdb.com/title/tt6628102/?ref_=shtt_ov_tt}]", serveur.processRequest("FILM","getFilms", null).toString());
    }

    @Test
    public void getFilm() throws IOException {
        HashMap params = new HashMap();
        params.put("titre", "Operation Finale - VF");
        assertEquals("{titre:Operation Finale, version:VF, fiche:https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt}", serveur.processRequest("FILM","getFilm", params).toString());
    }

    /*@Test
    public void addFilm() {
        Film ratarouille = new Film("Ratatouille", "VO", "https://www.imdb.com/title/tt0382932/?ref_=nv_sr_1");
        HashMap params = new HashMap();
        params.put("film", ratarouille);
        serveur.processRequest("FILM","addFilm", params);
        assertEquals("[{titre:Mission Impossible - Fallout, version:VO, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Toto, version:VF, fiche:https://toto.fr}, {titre:BlacKkKlansman, version:VO, fiche:https://www.imdb.com/title/tt7349662/?ref_=inth_ov_tt}, {titre:Burning, version:VO, fiche:https://www.imdb.com/title/tt7282468/?ref_=shtt_ov_tt}, {titre:Mission Impossible - Fallout, version:VF, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Operation Finale, version:VF, fiche:https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt}, {titre:Le poirier sauvage, version:VF, fiche:https://www.imdb.com/title/tt6628102/?ref_=shtt_ov_tt}, {titre:Ratatouille, version:VO, fiche:https://www.imdb.com/title/tt0382932/?ref_=nv_sr_1}]", serveur.processRequest("FILM","getFilms", null).toString());
    }*/

    /*@Test
    public void removeFilm()  { //removeFilm() A VERIFIER
        //Film missionImpossible = new Film("Mission Impossible - Fallout", "VO", "https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt");
        HashMap params = new HashMap();
        params.put("film", "Mission Impossible - Fallout, version:VO");
        serveur.processRequest("FILM","removeFilm", params);
        assertEquals("[{titre:BlacKkKlansman, version:VO, fiche:https://www.imdb.com/title/tt7349662/?ref_=inth_ov_tt}, {titre:Burning, version:VO, fiche:https://www.imdb.com/title/tt7282468/?ref_=shtt_ov_tt}, {titre:Mission Impossible - Fallout, version:VF, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Operation Finale, version:VF, fiche:https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt}, {titre:Le poirier sauvage, version:VF, fiche:https://www.imdb.com/title/tt6628102/?ref_=shtt_ov_tt}, {titre:Ratatouille, version:VO, fiche:https://www.imdb.com/title/tt0382932/?ref_=nv_sr_1}]", serveur.processRequest("FILM","getFilms", null).toString());

    }*/

    @Test
    public void getNbFilms() throws IOException {
        assertEquals(7, serveur.processRequest("FILM","getNbFilms", null));
    }

    // ----------- CinemaRessourceSalles -----------
    @Test
    public void getSalles() throws IOException {
        assertEquals("[{nom:Salle 3, capacite:50}, {nom:Salle 2, capacite:70}, {nom:Salle 1, capacite:100}]",serveur.processRequest("SALLE","getSalles",null).toString());
    }

    @Test
    public void getSalle() throws IOException {
        HashMap params = new HashMap();
        params.put("nomSalle", "Salle 2");
        assertEquals("{nom:Salle 2, capacite:70}",serveur.processRequest("SALLE","getSalle", params).toString());
    }

    @Test
    public void addSalle() throws IOException {
        Salle salle4 = new Salle("Salle 4", 100);
        HashMap params = new HashMap();
        params.put("salle", salle4);
        serveur.processRequest("SALLE", "addSalle", params);
        assertEquals("[{nom:Salle 4, capacite:100}, {nom:Salle 3, capacite:50}, {nom:Salle 2, capacite:70}, {nom:Salle 1, capacite:100}]",serveur.processRequest("SALLE","getSalles", null).toString());
    }

    @Test
    public void removeSalle() throws IOException  { // ok
        Salle salle4 = new Salle("Salle 4", 55);
        HashMap params = new HashMap();
        params.put("salle", salle4);
        serveur.processRequest("SALLE", "addSalle", params);
        assertEquals(4,serveur.processRequest("SALLE","getNbSalles", null));
         params.put("nomSalle", salle4.getNom());
        serveur.processRequest("SALLE", "removeSalle", params);
        assertEquals(3,serveur.processRequest("SALLE","getNbSalles", null));
    }

    @Test
    public void getNbSalles() throws IOException {
        assertEquals(3,serveur.processRequest("SALLE","getNbSalles",null));
    }


    // ----------- CinemaRessourceSeances -----------
    @Test
    public void createSeance() throws ParseException, IOException { // A VERIFIER

        //serveur = new ServeurImpl();

        // Film
        Film film = new Film("LaLaLand", "VO", "https://www.imdb.com/title/tt2975976/?ref_=nv_sr_1");

        // Salle
        Salle salle = new Salle("Salle LYON", 130);

        // Date
        String d = "2018-08-11 20:00:00 CET";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        Date dateSeance = format.parse(d);

        // Prix
        Float prix = 31.00f;

        // Au debut getNbSeances = 84
        assertEquals(84, serveur.processRequest("SEANCE", "getNbSeances", null));

        HashMap params = new HashMap();

        params.put("salle", (Object)salle);
        params.put("film", (Object)film);
        params.put("date", (Object)dateSeance);
        params.put("prix", (Object)prix);

        LOGGER.info("PARAMS : " + params);

        serveur.processRequest("SEANCE", "createSeance", params);

        // Apres la creation de la seance, getNbSeances = 84
        assertEquals(85, serveur.processRequest("SEANCE", "getNbSeances", null));
    }

    /*@Test
    public void removeSeance() throws ParseException { // OK (Il efface une seance, c'est pour cela il est en commentaire)

        //serveur = new ServeurImpl();

        //{ "film" : "Operation Finale - VF",
        //  "salle" : "Salle 2",
        //  "date" : "2018-09-25 20:00:00 CEST",
        //  "prix" : 10.0 }

        // Film
        Film opFin = new Film("Operation Finale", "VF", "https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt");

        // Salle
        Salle salle2 = new Salle("Salle 2", 70);

        // Date
        String d = "2018-09-25 20:00:00 CEST";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        Date dateSeance = format.parse(d);

        // Prix
        Float prix = 10.0f;

        // La seance a effacer
        Seance maSeanceEffacer = new Seance(opFin, salle2, dateSeance, prix);

        // Au debut getNbSeances = 84
        assertEquals(84, serveur.processRequest("SEANCE", "getNbSeances", null));

        HashMap params = new HashMap();

        params.put("seance", (Object)maSeanceEffacer);

        serveur.processRequest("SEANCE", "removeSeance", params);

        // Apres l'effacement de la seance getNbSeances = 83
        assertEquals(83, serveur.processRequest("SEANCE", "getNbSeances", null));
    }*/

    @Test
    public void getNBSeances() throws IOException { // OK

        assertEquals(84, serveur.processRequest("SEANCE", "getNbSeances", null));
    }

    @Test
    public void setSeances() throws ParseException, IOException { // OK

        // Films
        Film harryP = new Film("Harry Potter and the Prisoner of Azkaban", "VO", "https://www.imdb.com/title/tt0304141/?ref_=nv_sr_6");
        Film batmanB = new Film("Batman Begins", "VF", "https://www.imdb.com/title/tt0372784/?ref_=nv_sr_2");

        // Salles
        Salle salleX = new Salle("Salle X", 200);
        Salle salleY = new Salle("Salle Y", 170);

        // Dates
        String d1 = "2018-09-25 20:00:00 CEST";
        String d2 = "2018-10-12 19:00:00 CEST";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        Date dateSeance1 = format.parse(d1);
        Date dateSeance2 = format.parse(d2);

        // Prix
        Float prix1 = 10.0f;
        Float prix2 = 11.0f;

        // Les seances a creer
        Seance maSeanceCreer1 = new Seance(harryP, salleX, dateSeance1, prix1);
        Seance maSeanceCreer2 = new Seance(batmanB, salleY, dateSeance2, prix2);
        LOGGER.info("maSeanceCreer1 : " + maSeanceCreer1);
        LOGGER.info("maSeanceCreer2 : " + maSeanceCreer2);

        // Creation de la nouvelle collection
        Collection<Seance> colSeances = new ArrayList<Seance>() {{
            add(maSeanceCreer1);
            add(maSeanceCreer2);
        }};

        LOGGER.info("COLSEANCE : " + colSeances);

        // Aavant de la creation de la seance, getNbSeances = 84
        assertEquals(84, serveur.processRequest("SEANCE", "getNbSeances", null));

        HashMap params = new HashMap();

        params.put("seances", (Object)colSeances);

        serveur.processRequest("SEANCE", "setSeances", params);

        // Apres la creation de la seance, getNbSeances = 2
        assertEquals(2, serveur.processRequest("SEANCE", "getNbSeances", null));
    }

}
