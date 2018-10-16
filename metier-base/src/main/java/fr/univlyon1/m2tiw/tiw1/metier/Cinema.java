package fr.univlyon1.m2tiw.tiw1.metier;


import fr.univlyon1.m2tiw.tiw1.metier.dao.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Collection;

public class Cinema {
    private final String nom;
    private Map<String, Salle> salles;
    private Map<String, Film> films;
    private List<Seance> seances;
    private ReservationDAO reservationDAO;
    private ProgrammationDAO programmationDAO;

    /**
     *
     * Constructeur de Cinema avec nom.
     *
     * @param nom .
     *
     * @param salles .
     * @param progDAO
     * @param reservDAO
     * @throws java.io.IOException
     * @throws java.text.ParseException
     *
     */
    public Cinema(String nom, List<Salle> salles,JSONProgrammationDAO progDAO, JPAReservationDAO reservDAO) throws IOException, ParseException {
        this.nom = nom;
        this.salles = new HashMap<String, Salle>();
        this.films = new HashMap<String, Film>();
        this.seances = new ArrayList<Seance>();
        //reservationDAO = new JPAReservationDAO();
        reservationDAO = reservDAO;
        setSalles(salles);
        programmationDAO = progDAO;
        //programmationDAO = new JSONProgrammationDAO(this.getSalles());
        // Attention, les salles doivent être cohérentes avec
        // l'information contenue dans le fichier JSON des seances
    }

    public String getNom() {
        return nom;
    }

    public void addSalle(Salle salle) {
        this.salles.put(salle.getNom(), salle);
    }

    public void removeSalle(Salle salle) {
        this.salles.remove(salle);
    }

    public void addFilm(Film film) throws IOException {
        this.films.put(film.getTitre() + " - " + film.getVersion(), film);
        programmationDAO.save(film);
    }

    public void removeFilm(Film film) {
        this.films.remove(film);
    }

    /**
     *
     * Ajouter une seance .
     *
     * @param salle .
     * @param film .
     * @param date .
     * @param prix .
     *
     */
    public void createSeance(Salle salle, Film film, Date date, float prix) throws IOException {
        Seance seance = new Seance(film, salle, date, prix);
        this.seances.add(seance);
        programmationDAO.save(seance);
        seance.setReservationDAO(reservationDAO);
    }

    public void removeSeance(Seance seance) throws IOException {
        seances.remove(seance);
        programmationDAO.delete(seance);
    }

    public int getNbSeances() {
        return seances.size();
    }

    public Collection<Salle> getSalles() {
        return salles.values();
    }

    /**
     *
     * Setter de salles .
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

    public Collection<Film> getFilms() {
        return films.values();
    }

    /**
     *
     * Setter de seances .
     *
     * @param nFilms .
     *
     */
    public void setFilms(Collection<Film> nFilms) throws IOException {
        this.films.clear();
        for (Film f : nFilms) {
            addFilm(f);
        }
    }

    public List<Seance> getSeances() {
        return seances;
    }

    /**
     *
     * Setter de seances .
     *
     * @param seances .
     *
     */
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
        for (Seance s : seances) {
            s.setReservationDAO(reservationDAO);
        }
    }

    public Salle getSalle(String salle) {
        return salles.get(salle);
    }

    public Film getFilm(String film) {
        return films.get(film);
    }

    @Override
    public String toString() {
        return "{" + "nom:" + nom + ", salles:" + salles + ", films:" + films + ", seances:" + seances + '}';
    }
    
}
