package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonRootName(value = "reservation")
public class Reservation {

    @JsonProperty(value = "prenom")
    private final String prenom;

    @JsonProperty(value = "nom")
    private final String nom;

    @JsonProperty(value = "email")
    private final String email;

    @JsonProperty(value = "paye")
    private boolean paye;

    /**
     *
     * Constructeur de Reservation avec prenom, nom et email.
     *
     */
    public Reservation(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.paye = false;
    }

    @JsonGetter
    public String getPrenom() {
        return prenom;
    }

    @JsonGetter
    public String getNom() {
        return nom;
    }

    @JsonGetter
    public String getEmail() {
        return email;
    }

    @JsonGetter
    public boolean isPaye() {
        return paye;
    }

    @JsonSetter
    public void setPaye(boolean paye) {
        this.paye = paye;
    }
}
