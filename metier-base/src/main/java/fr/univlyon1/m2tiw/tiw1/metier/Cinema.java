package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.*;

@JsonRootName(value = "cinema")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Cinema {
    @JsonProperty(value="nom")
    private final String nom;
    @JsonProperty(value="salles")
    private Map<String, Salle> salles;
    @JsonProperty(value="films")
    private Map<String, Film> films;
    @JsonProperty(value="seances")
    private List<Seance> seances;   

    public Cinema(String nom) {
        this.nom = nom;
        this.salles = new HashMap<String, Salle>();
        this.films = new HashMap<String, Film>();
        this.seances = new ArrayList<Seance>();
    }
    public Cinema(){
    this.nom="";
    }
    
    @JsonSetter
    public void setSalles(Map<String, Salle> salles) {
        this.salles = salles;
    }
    @JsonSetter
    public void setFilms(Map<String, Film> films) {
        this.films = films;
    }
    @JsonSetter
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    
    
    @JsonGetter
    public String getNom() {
        return nom;
    }

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
    public String toString() {
        return "cinema : {" + "nom : " + nom + ", salles : " + salles + ", films : " + films + ", seances : " + seances + '}';
    }
    
    
}
