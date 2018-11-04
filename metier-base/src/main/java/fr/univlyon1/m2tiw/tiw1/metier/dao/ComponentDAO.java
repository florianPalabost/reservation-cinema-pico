package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import java.io.IOException;
import java.util.ArrayList;

public interface ComponentDAO {
    public ArrayList<Salle> load() throws IOException;
}
