/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.metier.annuaire.IRegistry;
import fr.univlyon1.m2tiw.metier.annuaire.Registry;
import fr.univlyon1.m2tiw.tiw1.config.AppConfig;
import fr.univlyon1.m2tiw.tiw1.config.Component;
import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONCinemaDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONSalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.SalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONAppConfigDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.ACinemaRessource;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaContextImpl;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaRessourceFilms;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaRessourceSalles;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaRessourceSeances;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;


public class ServeurImpl implements Serveur {
    private Cinema cinema;
    private Registry registry;
    private List<Salle> salles;
    private AppConfig appConf;
    private static final Logger LOGGER = Logger.getLogger(ServeurImpl.class.getName());

    /**
     * Serveur : Instantie un PicoCotainer et recupere Cinema .
     * @param registryImpl .
     * @throws java.io.IOException IOException
     */
    public ServeurImpl(Registry registryImpl) throws IOException, ClassNotFoundException {
        // setup conf partie 5
        appConf = new JSONAppConfigDAO().load();
        salles = new JSONSalleDAO().load();
        // on recupere le nom du cine
        String nameCine = appConf.getName();
        
        
        // setup pico container
        DefaultPicoContainer pico = new DefaultPicoContainer(new Caching());
        pico.addComponent(nameCine);
        
        registry = registryImpl;
        // Bind server : /server
        registry.setReferencedObj(Registry.CTX_ROOT,this);
        
        // services-components
        for (Component component : appConf.getServiceComponents()) {
            if (component.getPath().equals("/app/metier/salles")) {
                pico.addComponent(salles);
            } else {
                pico.addComponent(Class.forName(component.getClassName()));       
            }
            registry.setReferencedObj(component.getPath(), pico.getComponent(Class.forName(component.getClassName())));
        }
        
        // persistences-components
        for (Component component : appConf.getPersistenceComponents()) {
            pico.addComponent(Class.forName(component.getClassName()));
            registry.setReferencedObj(component.getPath(), pico.getComponent(Class.forName(component.getClassName())));
        }
        
             
        // Contexte 3.X
        CinemaContext cineContext = new CinemaContextImpl();
        cineContext.setDAO(ProgrammationDAO.CONTEXT,pico.getComponent(JSONProgrammationDAO.class));
        cineContext.setDAO(SalleDAO.CONTEXT,pico.getComponent(salles));
        // cineContext.setDAO(ReservationDAO.CONTEXT,pico.getComponent(JPAReservationDAO.class));
        pico.addComponent(cineContext);
       
        
        // business-components
        for (Component component : appConf.getBusinessComponents()) {
            pico.addComponent(Class.forName(component.getClassName()));
            registry.setReferencedObj(component.getPath(), pico.getComponent(Class.forName(component.getClassName())));
        }


        
        // pico.addComponent(JSONSalleDAO.class);
        // pico.addComponent(JPAReservationDAO.class);
        // pico.addComponent(pico.getComponent(JSONSalleDAO.class).load());
        // pico.addComponent(JSONProgrammationDAO.class);
        //pico.addComponent(JSONCinemaDAO.class);
        // pico.addComponent("mon-cinema");
        // pico.addComponent(Cinema.class);
        
        
        // classes uniformisation 2.2
        // pico.addComponent(CinemaRessourceFilms.class);
        // pico.addComponent(CinemaRessourceSalles.class);
        // pico.addComponent(CinemaRessourceSeances.class);
   
        
        // Binding 4.X
        
        
        
        // Bind cineRessXXX : /app/cineRessXXX 
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+"/cinemaRessourceFilms",pico.getComponent(CinemaRessourceFilms.class));
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+"/cinemaRessourceSalles",pico.getComponent(CinemaRessourceSalles.class));
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+"/cinemaRessourceSeances",pico.getComponent(CinemaRessourceSeances.class));
        
        // Bind salles : /app/metier/salles
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+SalleDAO.CTX_METIER+"/salles",pico.getComponent(JSONSalleDAO.class).load());
        
        // Bind progdao et reservDAO : /app/persistence/progdao,ReservDao
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+"/persistence/programmationDAO",pico.getComponent(JSONProgrammationDAO.class));
        // registry.setReferencedObj(ACinemaRessource.CTX_CINE_RESS+"/persistence/reservationDAO",pico.getComponent(JPAReservationDAO.class));
        
       //  cinema = pico.getComponent(Cinema.class);
        
        // voir si utile de les laisser ?
        pico.addComponent(Integer.class);
        pico.addComponent(String.class);
        
        // lancement du cinema
        // cinema.start();
        
        // start tous les composants de pico qui implementent Startable en meme temps
        pico.start();
    }
    
    /**
     * 
     * @return une instance du cinema créé
     * @throws IOException IOException
     * @throws ParseException ParseException
     */
    /*
    public Cinema createCinema() throws IOException, ParseException {
        List<Salle> salles = new JSONSalleDAO().load();
        JSONProgrammationDAO progDAO = new JSONProgrammationDAO("mon-cinema",salles);
        JPAReservationDAO reservDAO = new JPAReservationDAO();
        cinema = new JSONCinemaDAO().load("Mon Cinema",salles,progDAO,reservDAO);
        
        LOGGER.info("SERVEUR CREATE CINEMA");
        LOGGER.info(cinema.toString());
        return cinema;
    }
    //TODO delete method add & delete salles
   */ 
    
    /**
     *
     * processRequest .
     *
     * @param methode methode .
     * @param commande methodes add,remove,get,...
     * @param parametres paires nom/valeur des parametres    des requetes
     * @return
     */
    @Override
    public Object processRequest(String methode, String commande, Map<String, Object> parametres) throws IOException {
        switch (methode) {         
            case "FILM":
                return ((CinemaRessourceFilms) registry.getReferencedObj("/app/cinemaRessourceFilms")).process(commande,parametres);
            case "SALLE":
                return ((CinemaRessourceSalles) registry.getReferencedObj("/app/cinemaRessourceSalle")).process(commande,parametres);
            case "SEANCE":
                return ((CinemaRessourceSeances) registry.getReferencedObj("/app/cinemaRessourceSeance")).process(commande,parametres);
            default:
                return null;
        }
    } 
    
    
    
    /*
    // methode service temporaire pour renvoyer une ref vers instance de Cinema
    public Cinema getCinema() {
        return cinema;
    }
    
    */

    public AppConfig getAppConf() {
        return appConf;
    }

   
    
}
