/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author florian
 */

// Gestion et consultation des films pour ressources 
public class CinemaRessourceFilms extends CinemaAbs {
    // addFilm(), removeFilm() et getFilm()
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSalles.class.getName());
    private HashMap<String, Film> films = new HashMap<>();
    private final ProgrammationDAO progDAO;

    public CinemaRessourceFilms(ProgrammationDAO progDAO) throws IOException {
        this.progDAO = progDAO;
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
    
    public Object process(String commande, Map<String,Object> parametres) throws IOException{
        return null;
    }
    
    @Override
    public void start() {
        LOGGER.info("Component "+ this.getClass() +" started");
    }
    
    @Override
    public void stop(){
        LOGGER.info("Component "+ this.getClass() +" stopped");
    }
}
