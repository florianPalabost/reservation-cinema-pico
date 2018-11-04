package fr.univlyon1.m2tiw.tiw1.metier;

import fr.univlyon1.m2tiw.metier.annuaire.Registry;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.serveur.Serveur;
import fr.univlyon1.m2tiw.tiw1.serveur.ServeurImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ServeurTest {
    private Serveur serveur;
    private Registry annuaire;
    private static final Logger LOGGER = Logger.getLogger(ServeurTest.class.getName());
    
    @Before
    public void initServeur() throws Exception {
        annuaire = new Registry();
        serveur = new ServeurImpl(annuaire);
    }
    /*@Test
    public void testCreateCineWithServ() throws IOException {
        LOGGER.info("--------testCreateCineWithServ------------");
        server = new ServeurImpl();
        Cinema cinema = null;
        try {
            cinema = server.createCinema();
        } catch (ParseException ex) {
            Logger.getLogger(ServeurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.info("classe : " + cinema.getClass());
        assertEquals(cinema.getClass(),Cinema.class);
        assertEquals("Mon Cinema",cinema.getNom());
    }*/
    
    @Test
    public void testInitPicoContainer() throws IOException {
        LOGGER.info("--------testInitPicoContainer------------");
        LOGGER.info("CLASS SERVEUR : " + serveur.getClass());
        LOGGER.info("PROCESS REQUEST GETFILMS : "
                + serveur.processRequest("FILM", "getFilms", null));
        
        Map<String,Object> params = new HashMap<>();
        params.put("class","Seance");
        // LOGGER.info(serveur.processRequest("SEANCE","getSeances", params).toString());
        // LOGGER.info("test server cinema:" + server.getCinema());
        //Cinema c = serveur.getCinema();
        assertEquals("mon-cinema",serveur.processRequest("CINEMA", "getNom", null));
    }
    
    @Test
    public void testProcessRequestNBXXX() throws IOException { // OK
        // verifie qu'on recupere les bonnes informations
        assertEquals("mon-cinema",serveur.processRequest("CINEMA", "getNom", new HashMap<>()));
        assertEquals(7,serveur.processRequest("FILM", "getNbFilms", new HashMap<>()));
        assertEquals(3,serveur.processRequest("SALLE", "getNbSalles", new HashMap<>()));
        assertEquals(84,serveur.processRequest("SEANCE", "getNbSeances", new HashMap<>()));
    }
    
    @Test
    public void testAddAndGetFilm() throws IOException { // OK
        Film f = new Film("Toto","VF","https://toto.fr");
        Map<String,Object> params = new HashMap<>();
        params.put("titre", "Toto - VF");
        params.put("film",f);
        serveur.processRequest("FILM", "addFilm", params);
        assertEquals(f,serveur.processRequest("FILM", "getFilm", params));
    }
    
    @Test
    public void testAddAndGetSalle() throws IOException { // OK
        Salle s = new Salle("Salle 42",42);
        Map<String,Object> params = new HashMap<>();
        params.put("nomSalle", s.getNom());
        params.put("salle",s);
        serveur.processRequest("SALLE", "addSalle", params);
        assertEquals(s,serveur.processRequest("SALLE", "getSalle", params));
    }

    // TESTS concernant l'annuaire
    @Test
    public void testGetRegistryNbSalles() throws Exception { //OK
        int nbSalles = ((List<Salle>) annuaire.getReferencedObj("/app/metier/salles")).size();
        assertEquals(3, nbSalles);
    }
    
    @Test
    public void testGetRegistryNbFilms() throws Exception { //OK
        JSONProgrammationDAO progDAO =
                (JSONProgrammationDAO) annuaire.getReferencedObj("/app/persistence/programmationDAO");
        int nbFilms = progDAO.getFilms().size();
        assertEquals(7, nbFilms);
    }
    
    @Test
    public void testGetRegistryNbSeances() throws Exception { //OK
        JSONProgrammationDAO progDAO =
                (JSONProgrammationDAO) annuaire.getReferencedObj("/app/persistence/programmationDAO");
        int nbSeances = progDAO.getSeances().size();
        assertEquals(84, nbSeances);
    }
    
    @Test
    public void testGetServerWithAnnuaire() throws Exception { //OK
        Serveur test = null;
        test = (Serveur) annuaire.getReferencedObj("/server");
        assertEquals(serveur,test);
        assertEquals(serveur.getAppConf().getName(),test.getAppConf().getName());
    }

    // TESTS concernant la partie app-config
    @Test
    public void testGetAppConfName() { // OK
        assertEquals("mon-cinema", serveur.getAppConf().getName());
    }
}

