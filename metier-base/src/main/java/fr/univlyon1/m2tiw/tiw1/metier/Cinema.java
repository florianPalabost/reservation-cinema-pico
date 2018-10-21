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
import java.util.logging.Logger;
import org.picocontainer.Startable;

public class Cinema implements Startable {
    private final String nom;
    private Map<String, Salle> salles;
    private Map<String, Film> films;
    private List<Seance> seances;
    private ReservationDAO reservationDAO;
    private ProgrammationDAO programmationDAO;
    private static final Logger LOGGER = Logger.getLogger(Cinema.class.getName());

    /**
     *
     * Constructeur de Cinema avec nom.
     *
     * @param nom .
     *
     * @param salles .
     * @param progDAO .
     * @param reservDAO .
     *
     * @throws java.io.IOException IOException
     * @throws java.text.ParseException ParseException
     *
     */
    public Cinema(String nom, List<Salle> salles,JSONProgrammationDAO progDAO,
                  JPAReservationDAO reservDAO) throws IOException, ParseException {
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

    private String getNom() {
        return nom;
    }
    
    private void addSalle(Salle salle) {
        this.salles.put(salle.getNom(), salle);
    }

    private void removeSalle(Salle salle) {
        this.salles.remove(salle);
    }
    
    private void addFilm(Film film) throws IOException {
        this.films.put(film.getTitre() + " - " + film.getVersion(), film);
        programmationDAO.save(film);
    }

    private void removeFilm(Film film) {
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
    private void createSeance(Salle salle, Film film, Date date, float prix) throws IOException {
        Seance seance = new Seance(film, salle, date, prix);
        this.seances.add(seance);
        programmationDAO.save(seance);
        seance.setReservationDAO(reservationDAO);
    }

    private void removeSeance(Seance seance) throws IOException {
        seances.remove(seance);
        programmationDAO.delete(seance);
    }

    private int getNbSeances() {
        return seances.size();
    }

    private Collection<Salle> getSalles() {
        return salles.values();
    }

    /**
     *
     * Setter de salles .
     *
     * @param nSalles .
     *
     */
    private void setSalles(Collection<Salle> nSalles) {
        this.salles.clear();
        for (Salle s : nSalles) {
            addSalle(s);
        }
    }

    private Collection<Film> getFilms() {
        return films.values();
    }

    /**
     *
     * Setter de seances .
     *
     * @param nFilms .
     *
     */
    private void setFilms(Collection<Film> nFilms) throws IOException {
        this.films.clear();
        for (Film f : nFilms) {
            addFilm(f);
        }
    }

    private List<Seance> getSeances() {
        return seances;
    }

    /**
     *
     * Setter de seances .
     *
     * @param seances .
     *
     */
    private void setSeances(List<Seance> seances) {
        this.seances = seances;
        for (Seance s : seances) {
            s.setReservationDAO(reservationDAO);
        }
    }

    private Salle getSalle(String salle) {
        return salles.get(salle);
    }

    private Film getFilm(String film) {
        return films.get(film);
    }
    
    public Object process(String commande, Map<String,Object> parametres) throws IOException{
        Object o = null;
        switch(commande) {
            default:
            case "getSalles":
                o = this.getSalles();
                LOGGER.info("getSalles toString()");
                LOGGER.info(o.toString());
                break;
            case "getFilms":
                o = this.getFilms();
                LOGGER.info("getFilms toString()");
                LOGGER.info(o.toString());
                break;
            case "createSeance":
                // o = this.createSeance(salle, film, date, 0);
            case "removeSeance":
                // void
                // o = this.removeSeance(seance);
            case " addFilm":
                // void
                this.addFilm((Film) parametres.get("film"));
        }
        
        return o;  
    }
   
    
    @Override
    public String toString() {
        return "{"  + "nom:" + nom
                    + ", salles:" + salles
                    + ", films:" + films
                    + ", seances:" + seances + '}';
    }

    /**
     * start the cinema
     */
    @Override
    public void start() {
        LOGGER.info("Component Cinema STARTED. Objet d'acces aux données : "+this.getClass());
        LOGGER.info(this.toString());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * stop the cinema instance
     */
    @Override
    public void stop() {
        LOGGER.info("SERVER STOPPED");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
