package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import fr.univlyon1.m2tiw.tiw1.utils.SeanceCompleteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *  La classe Seance .
 */
@JsonRootName(value = "seance")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seance {

    /**
     *
     * Le film .
     *
     */
    // @JsonProperty(value="film")
    private final Film film;

    /**
     *
     * La salle .
     *
     */
    //@JsonProperty(value="salle")
    private final Salle salle;

    /**
     *
     * La date .
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd HH:mm:ssX",
                timezone = "UTC")
    @JsonProperty(value = "date")
    private final java.util.Date date;

    /**
     *
     * Le prix .
     *
     */
    @JsonProperty(value = "prix")
    private final float prix;

    /**
     *
     * Les reservations .
     *
     */
    @JsonProperty(value = "reservations")
    private List<Reservation> reservations;

    /**
     *
     * Constructeur de Seance avec film, salle, date et prix.
     *
     * @param filmSeance .
     *
     * @param salleSeance .
     *
     * @param dateSeance .
     *
     * @param prixSeance .
     *
     */
    public Seance(final Film filmSeance,
                  final Salle salleSeance,
                  final Date dateSeance,
                  final float prixSeance) {
        this.film = filmSeance;
        this.salle = salleSeance;
        this.date = dateSeance;
        this.prix = prixSeance;
        this.reservations = new ArrayList<Reservation>();
    }

    /**
     *
     * Constructeur de Seance.
     *
     */
    public Seance() {
        this.film = null;
        this.salle = null;
        this.date = null;
        this.prix = 0;
        this.reservations = null;
    }

    /**
     *
     * @return le fiilm .
     *
     */
    @JsonProperty(value = "film")
    public Film getFilm() {
        return film;
    }

    /**
     *
     * @return la salle .
     *
     */
    @JsonProperty(value = "salle")
    public Salle getSalle() {
        return salle;
    }

    /**
     *
     * @return la date .
     *
     */
    @JsonProperty(value = "date")
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return le prix .
     *
     */
    @JsonProperty(value = "prix")
    public float getPrix() {
        return prix;
    }

    /**
     *
     * Pour creer la reservation.
     *
     * @param prenom .
     *
     * @param nom .
     *
     * @param email .
     *
     * @throws SeanceCompleteException Exception de la seance complete.
     *
     */
    public void createReservation(final String prenom,
                                  final String nom,
                                  final String email)
            throws SeanceCompleteException {
        if (this.salle.getCapacite() >= this.reservations.size()) {
            throw new SeanceCompleteException();
        }
        Reservation resa = new Reservation(prenom, nom, email);
        this.reservations.add(resa);
        resa.setPaye(true);
    }

    /**
     *
     * Annuler une reservation .
     *
     * @param reservation .
     *
     */
    public void cancelReservation(final Reservation reservation) {
        this.reservations.remove(reservation);
    }

    /**
     *
     * Setter de reservation .
     *
     * @param reservationsSeance .
     *
     */
    public void setReservations(final List<Reservation> reservationsSeance) {
        this.reservations = reservationsSeance;
    }

    /**
     *
     * @return l'affichage.
     *
     */
    @Override
    public String toString() {
        return "{" + "film:" + film
                   + ", salle:" + salle
                   + ", date:" + date
                   + ", prix:" + prix
                   + ", reservations:" + reservations + '}';
    }

}
