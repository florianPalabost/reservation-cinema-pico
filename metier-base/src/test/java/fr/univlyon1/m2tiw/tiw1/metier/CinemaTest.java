package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.metier.annuaire.Registry;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaWrapper;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
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
    public void initServeur() throws IOException {
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
    public void getFilms() {
        assertEquals("[{titre:Mission Impossible - Fallout, version:VO, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Toto, version:VF, fiche:https://toto.fr}, {titre:BlacKkKlansman, version:VO, fiche:https://www.imdb.com/title/tt7349662/?ref_=inth_ov_tt}, {titre:Burning, version:VO, fiche:https://www.imdb.com/title/tt7282468/?ref_=shtt_ov_tt}, {titre:Mission Impossible - Fallout, version:VF, fiche:https://www.imdb.com/title/tt4912910/?ref_=inth_ov_tt}, {titre:Operation Finale, version:VF, fiche:https://www.imdb.com/title/tt5208252/?ref_=inth_ov_tt}, {titre:Le poirier sauvage, version:VF, fiche:https://www.imdb.com/title/tt6628102/?ref_=shtt_ov_tt}]", serveur.processRequest("FILM","getFilms", null).toString());
    }

    @Test
    public void getFilm() {
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
    public void getNbFilms() {
        assertEquals(7, serveur.processRequest("FILM","getNbFilms", null));
    }

    // ----------- CinemaRessourceSalles -----------
    @Test
    public void getSalles() {
        assertEquals("[{nom:Salle 3, capacite:50}, {nom:Salle 2, capacite:70}, {nom:Salle 1, capacite:100}]",serveur.processRequest("SALLE","getSalles",null).toString());
    }

    @Test
    public void getSalle() {
        HashMap params = new HashMap();
        params.put("nomSalle", "Salle 2");
        assertEquals("{nom:Salle 2, capacite:70}",serveur.processRequest("SALLE","getSalle", params).toString());
    }

    @Test
    public void addSalle() {
        Salle salle4 = new Salle("Salle 4", 100);
        HashMap params = new HashMap();
        params.put("salle", salle4);
        serveur.processRequest("SALLE", "addSalle", params);
        assertEquals("[{nom:Salle 4, capacite:100}, {nom:Salle 3, capacite:50}, {nom:Salle 2, capacite:70}, {nom:Salle 1, capacite:100}]",serveur.processRequest("SALLE","getSalles", null).toString());
    }

    @Test
    public void removeSalle()  { // ok
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
    public void getNbSalles() {
        assertEquals(3,serveur.processRequest("SALLE","getNbSalles",null));
    }

}
