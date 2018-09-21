package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonRootName(value = "seance")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Seance {
   // @JsonProperty(value="film")
    private final Film film;
    //@JsonProperty(value="salle")
    private final Salle salle;
   @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ssX", timezone="UTC") 
      @JsonProperty(value="date")
    private final java.util.Date date;
    @JsonProperty(value="prix")
    private final float prix;
    @JsonProperty(value="reservations")
    private List<Reservation> reservations;

    public Seance(Film film, Salle salle, Date date, float prix) {
        this.film = film;
        this.salle = salle;
        this.date = date;
        this.prix = prix;
        this.reservations = new ArrayList<Reservation>();
    }

    public Seance(){
         this.film = null;
        this.salle = null;
        this.date = null;
        this.prix = 0;
        this.reservations = null;
    }
    @JsonProperty(value="film")
    public Film getFilm() {
        return film;
    }
    @JsonProperty(value="salle")
    public Salle getSalle() {
        return salle;
    }
    @JsonProperty(value="date")
    public Date getDate() {
        return date;
    }
    @JsonProperty(value="prix")
    public float getPrix() {
        return prix;
    }

    public void createReservation(String prenom, String nom, String email) throws SeanceCompleteException{
        if(this.salle.getCapacite() >= this.reservations.size())
            throw new SeanceCompleteException();
        Reservation resa = new Reservation(prenom, nom, email);
        this.reservations.add(resa);
        resa.setPaye(true);
    }

    public void cancelReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "{" + "film:" + film + ", salle:" + salle + ", date:" + date + ", prix:" + prix + ", reservations:" + reservations + '}';
    }
    
}
