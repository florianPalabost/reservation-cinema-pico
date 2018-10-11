package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
//import java.util.*; // Il faut eviter les import *

/**
 *
 *  La classe Cinema .
 */
@JsonRootName(value = "cinema")
//@JsonIgnoreProperties(ignoreUnknown=false)
public class Cinema {

    /**
     *
     * Le nom.
     *
     */
    @JsonProperty(value = "nom")
    private String nom;

    /**
     *
     * Les salles .
     *
     */
    @JsonProperty(value = "salles")
    //private Map<String, Salle> salles;
    private List<Salle> salles;

    /**
     *
     * Les films .
     *
     */
    @JsonProperty(value = "films")
    private List<Film> films;

    /**
     *
     * Les seances .
     *
     */
    @JsonProperty(value = "seances")
    private List<Seance> seances;

    /**
     *
     * Constructeur de Cinema avec nom.
     *
     * @param nomC .
     *
     */
    public Cinema(final String nomC) {
        this.nom = nomC;
        //this.salles = new HashMap<String, Salle>();
        this.salles = new ArrayList<Salle>();
        // this.films = new HashMap<String, Film>();
        this.films = new ArrayList<Film>();
        this.seances = new ArrayList<Seance>();
    }

    /**
     *
     * Constructeur de Cinema avec nom.
     *
     */
    public Cinema() {
    //this.nom = "";
    }

    /**
     *
     * @return les salles .
     *
     */
    @JsonProperty(value = "salles")
    public List<Salle> getSalles() {
        return salles;
    }

    /**
     *
     * Setter des salles .
     *
     * @param lesSalles .
     *
     */
    @JsonProperty(value = "salles")
    public void setSalles(final List<Salle> lesSalles) {
        this.salles = lesSalles;
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

    /**
     *
     * @return les films .
     *
     */
    @JsonProperty(value = "films")
    public List<Film> getFilms() {
        return films;
    }

    /**
     *
     * Setter de films .
     *
     * @param lesFilms .
     *
     */
    @JsonProperty(value = "films")
    public void setFilms(final List<Film> lesFilms) {
        this.films = lesFilms;
    }

    /**
     *
     * @return les seances .
     *
     */
    @JsonProperty(value = "seances")
    public List<Seance> getSeances() {
        return seances;
    }

    /**
     *
     * Setter de seances .
     *
     * @param lesSeances .
     *
     */
    @JsonProperty(value = "seances")
    public void setSeances(final List<Seance> lesSeances) {
        this.seances = lesSeances;
    }

    /**
     *
     * @return le nom .
     *
     */
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
    public void createSeance(final Salle salle,
                             final Film film,
                             final Date date,
                             final float prix) {
        this.seances.add(new Seance(film, salle, date, prix));
    }

    /**
     *
     * enlever une seance .
     *
     * @param seance .
     *
     *
     */
    public void removeSeance(final Seance seance) {
        seances.remove(seance);
    }

    /**
     *
     * @return le nombre de seance .
     *
     */
    @JsonGetter
    public int getNbSeances() {
        return seances.size();
    }

    /**
     *
     * Hashcode.
     *
     */
    @Override
    public int hashCode() {
        final int cinq = 5;
        int hash = cinq;
        return hash;
    }

    /**
     *
     * Verifier egalite.
     *
     */
    @Override
    public boolean equals(final Object obj) {
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

    /**
     *
     * @return l'affichage.
     *
     */
    @Override
    public String toString() {
        return "cinema : {" + "nom : " + nom
                            + ", salles : " + salles
                            + ", films : " + films
                            + ", seances : " + seances + "}";
    }


}
