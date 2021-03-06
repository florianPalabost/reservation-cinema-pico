package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.ACinemaRessource;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * CinemaRessourceFilms .
 *
 * @author florian
 */

// Gestion et consultation des films pour ressources 
public class CinemaRessourceFilms extends ACinemaRessource {
    // addFilm(), removeFilm() et getFilm()
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSalles.class.getName());
    private HashMap<String, Film> films = new HashMap<>();
    private final ProgrammationDAO progDAO;
    /*
        public CinemaRessourceFilms(ProgrammationDAO progDAO) throws IOException {
            this.progDAO = progDAO;
            setFilms(progDAO.getFilms());
        }*/
    
    public CinemaRessourceFilms(CinemaContext cineContext) throws IOException {
        this.progDAO = (ProgrammationDAO) cineContext.getDAO(ProgrammationDAO.CONTEXT);
        setFilms(progDAO.getFilms());
    }
    
    private void addFilm(Film film) throws IOException {
        this.films.put(film.getTitre() + " - " + film.getVersion(), film);
        progDAO.save(film);
    }

    private void removeFilm(Film film) {
        this.films.remove(film);
    }
    
    private void setFilms(Collection<Film> nFilms) throws IOException {
        this.films.clear();
        for (Film f : nFilms) {
            addFilm(f);
        }
    }
    
    private Film getFilm(String film) {
        return films.get(film);
    }
    
    public Collection<Film> getFilms() {
        return films.values();
    }
    
    public int getNbFilms() {
        return films.size();
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
            case "getFilms":
                return getFilms();
                
            case "getFilm":
                return getFilm((String) parametres.get("titre"));
                
            case "addFilm":
                addFilm((Film) parametres.get("film"));
                return null;

            case "removeFilm":
                removeFilm((Film) parametres.get("film"));
                return null;
                
            case "getNbFilms":
                return getNbFilms();
                
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
