package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.sun.media.jfxmedia.logging.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.picocontainer.Startable;
import java.lang.Class;
import java.util.logging.Level;
//import java.util.*; // Il faut eviter les import *

@JsonRootName(value = "cinema")
//@JsonIgnoreProperties(ignoreUnknown=false)
public class Cinema implements Startable {
    Logger logger;
    @JsonProperty(value = "nom")
    private String nom;

    @JsonProperty(value = "salles")
    //private Map<String, Salle> salles;
    private List<Salle> salles;

    @JsonProperty(value = "films")
    private List<Film> films;

    @JsonProperty(value = "seances")
    private List<Seance> seances;

    /**
     *
     * Constructeur de Cinema avec nom.
     *
     * @param nom
     * @param salles
     */
    public Cinema(String nom, List<Salle> salles){
        this.nom = nom;
        //this.salles = new HashMap<String, Salle>();
        
       // this.salles = new ArrayList<Salle>();
       this.salles = salles;
        // this.films = new HashMap<String, Film>();
        this.films = new ArrayList<Film>();
        this.seances = new ArrayList<Seance>();
    }

    public Cinema(){
    //this.nom = "";
    }

    @JsonProperty(value = "salles")
    public List<Salle> getSalles() {
        return salles;
    }

    @JsonProperty(value = "salles")
    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    /*
    @JsonSetter
    public void setSalles(Map<String, Salle> salles) {
        this.salles = salles;
    }
    */
    /*
    @JsonSetter
    public void setFilms(Map<String, Film> films) {
        this.films = films;
    }
    */

    @JsonProperty(value = "films")
    public List<Film> getFilms() {
        return films;
    }

    @JsonProperty(value = "films")
    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @JsonProperty(value = "seances")
    public List<Seance> getSeances() {
        return seances;
    }

    @JsonProperty(value = "seances")
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    
    @JsonProperty(value = "nom")
    @JsonGetter
    public String getNom() {
        return nom;
    }

    /*
        public void addSalle(Salle salle) {
            this.salles.put(salle.getNom(), salle);
        }

        public void removeSalle(Salle salle) {
            this.salles.remove(salle);
        }

        public void addFilm(Film film) {
            this.films.put(film.getTitre(), film);
        }

        public void removeFilm(Film film) {
            this.films.remove(film);
        }
    */

    public void createSeance(Salle salle, Film film, Date date, float prix) {
        this.seances.add(new Seance(film, salle, date, prix));
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    @JsonGetter
    public int getNbSeances() {
        return seances.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cinema other = (Cinema) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.salles, other.salles)) {
            return false;
        }
        if (!Objects.equals(this.films, other.films)) {
            return false;
        }
        if (!Objects.equals(this.seances, other.seances)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cinema : {" + "nom : " + nom
                            + ", salles : " + salles
                            + ", films : " + films
                            + ", seances : " + seances + "}";
    }
// Methodes de Startable de Pico Container
    @Override
    public void start() {
        Logger.logMsg(Logger.INFO,"Server started");
        /*try {
            Class c = Class.forName(Cinema);
            //c = c.getClass();
             Logger logMsg = Logger.logMsg(Logger.INFO,c.getName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cinema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.*/
    }

    @Override
    public void stop() {
        Logger.logMsg(Logger.INFO,"Server stopped");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
