package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.Seance;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface ProgrammationDAO {
    public static final String CONTEXT = "programmation";

    void initData(Cinema cinema) throws Exception;

    Seance getSeanceById(String id);

    Film getFilmByTitreVersion(String titre, String version);

    Collection<Seance> getSeanceByFilm(Film film);

    void save(Seance seance) throws IOException;

    void save(Film film) throws IOException;

    void delete(Seance seance) throws IOException;
    
    Collection<Film> getFilms();
    
    Map<String, Seance> getSeances(); 
    
    public Map<String, Salle> getSalles();
}
