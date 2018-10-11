package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 *  La classe Salle .
 *
 */
@JsonRootName(value = "salle")
@JsonInclude(Include.NON_NULL)
public class Salle {

    /**
     *
     * Le nom .
     *
     */
    @JsonProperty(value = "nom")
    private final String nom;

    /**
     *
     * La capacite .
     *
     */
    @JsonProperty(value = "capacite")
    private final int capacite;

    /**
     *
     * Constructeur de Film.
     *
     * @param nomSalle .
     *
     * @param capaciteSalle .
     *
     */
    public Salle(final String nomSalle, final int capaciteSalle) {
        this.nom = nomSalle;
        this.capacite = capaciteSalle;
    }

    /**
     *
     * Constructeur de Film.
     *
     */
    public Salle() {
        this.nom = "";
        this.capacite = 0;
    }

    /**
     *
     * Constructeur de Film.
     *
     * @param nomSalle .
     *
     */
    public Salle(final String nomSalle) {
        this.nom = nomSalle;
        this.capacite = 0;
    }

    /**
     *
     * @return le nom .
     *
     */
    @JsonProperty(value = "nom")
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return la capacite .
     *
     */
    @JsonProperty(value = "capacite")
    public int getCapacite() {
        return capacite;
    }

    /**
     *
     * @return l'affichage.
     *
     */
    @Override
    public String toString() {
        return "{" + "nom : " + nom + ", capacite : " + capacite + '}';
    }

}
