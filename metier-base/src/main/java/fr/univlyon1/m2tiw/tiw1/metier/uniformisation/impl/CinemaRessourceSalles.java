package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.ACinemaRessource;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * CinemaRessourceSalles .
 *
 * @author florian
 */
// gestion des salles
public class CinemaRessourceSalles extends ACinemaRessource {
    //addSalle, removeSalle(on oubli ces deux normalement) et enfin getSalles(), getSalle()
    private Map<String, Salle> salles = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSalles.class.getName());

    
    /* public CinemaRessourceSalles(List<Salle> salles) {
        setSalles(salles);
    } */

    /**
     *
     * CinemaRessourceSalles .
     *
     * @param cineContext .
     *
     */
    public CinemaRessourceSalles(CinemaContext cineContext) {
        JSONProgrammationDAO progDAO =
                (JSONProgrammationDAO) cineContext.getDAO(ProgrammationDAO.CONTEXT);
        setSalles((Collection<Salle>) progDAO.getSalles().values());
    }
    
    private void addSalle(Salle salle) {
        this.salles.put(salle.getNom(), salle);
    }

    private void removeSalle(String nomSalle) {
        this.salles.remove(nomSalle);
    }
    
    private Salle getSalle(String salle) {
        return salles.get(salle);
    }
    
    private Collection<Salle> getSalles() {
        return salles.values();
    }

    /**
     *
     * setSalles .
     *
     * @param nSalles .
     *
     */
    public void setSalles(Collection<Salle> nSalles) {
        this.salles.clear();
        for (Salle s : nSalles) {
            addSalle(s);
        }
    }
    
    public int getNbSalles() {
        return this.salles.size();
    }

    /**
     *
     * process .
     *
     * @param commande .
     * @param parametres .
     *
     * @return Object .
     *
     * @throws IOException Exception IO
     */
    public Object process(String commande, Map<String,Object> parametres) throws IOException {
        switch (commande) {
            case "getSalles":
                return getSalles();
            
            case "getSalle":
                return getSalle((String) parametres.get("nomSalle"));

            case "addSalle":
                addSalle((Salle)parametres.get("salle"));
                return null;

            case "removeSalle":
                removeSalle((String)parametres.get("nomSalle"));
                return null;
                
            case "getNbSalles":
                return getNbSalles();

            default:
                return null;
        }
    }
    
    @Override
    public void start() {
        LOGGER.info("Component " + this.getClass() + " started");
    }
    
    @Override
    public void stop() {
        LOGGER.info("Component " + this.getClass() + " stopped");
    }
    
}
