package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 *
 * La classe Reservation.
 *
 */
@JsonRootName(value = "reservation")
public class Reservation {

    /**
     *
     * Le prenom.
     *
     */
    @JsonProperty(value = "prenom")
    private final String prenom;

    /**
     *
     * Le nom.
     *
     */
    @JsonProperty(value = "nom")
    private final String nom;

    /**
     *
     * Le e-mail.
     *
     */
    @JsonProperty(value = "email")
    private final String email;

    /**
     *
     * Pour savoir si paye .
     *
     */
    @JsonProperty(value = "paye")
    private boolean paye;

    /**
     *
     * Constructeur de Reservation avec prenom, nom et email.
     *
     * @param prenomRes .
     *
     * @param nomRes .
     *
     * @param emailRes .
     *
     */
    public Reservation(final String prenomRes,
                       final String nomRes,
                       final String emailRes) {
        this.prenom = prenomRes;
        this.nom = nomRes;
        this.email = emailRes;
        this.paye = false;
    }

    /**
     *
     * @return le prenom .
     *
     */
    @JsonGetter
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return le nom .
     *
     */
    @JsonGetter
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return le mail .
     *
     */
    @JsonGetter
    public String getEmail() {
        return email;
    }

    /**
     *
     * Verifier si paye ou pas .
     *
     * @return paye .
     *
     */
    @JsonGetter
    public boolean isPaye() {
        return paye;
    }

    /**
     *
     * Setter de paye .
     *
     * @param payeRes .
     *
     */
    @JsonSetter
    public void setPaye(final boolean payeRes) {
        this.paye = payeRes;
    }
}
