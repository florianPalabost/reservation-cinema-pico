package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;

import java.io.IOException;
import java.util.List;

public interface CinemaDAO {
    public Cinema load(List<Salle> salles) throws IOException;
}
