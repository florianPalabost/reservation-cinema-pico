package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

/**
 *
 * CinemaContext .
 *
 * @author florian
 */
public interface CinemaContext {
    // TODO obtenir une reference sur un obj DAO existant
    // public Object getDAO();
    public Object getDAO(String k);
    // TODO indiquer une ref a un DAO existant
    // public void setProgDAO(JSONProgrammationDAO progDAO);

    public void setDAO(String k, Object o);
}
