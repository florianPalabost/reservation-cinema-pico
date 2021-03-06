package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.impl.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;

import java.io.IOException;
import java.util.List;

public interface CinemaDAO {
    public Cinema load(String nom,List<Salle> salles,JSONProgrammationDAO progDAO,
                       JPAReservationDAO reservDAO) throws IOException;
}
