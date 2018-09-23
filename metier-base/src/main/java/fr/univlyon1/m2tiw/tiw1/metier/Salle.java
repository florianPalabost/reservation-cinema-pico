package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "salle")
@JsonInclude(Include.NON_NULL)
public class Salle {

    @JsonProperty(value = "nom")
    private final String nom;

    @JsonProperty(value = "capacite")
    private final int capacite;

    public Salle(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public Salle() {
        this.nom = "";
        this.capacite = 0;
    }

    public Salle(String nom) {
        this.nom = nom;
        this.capacite = 0;
    }

    @JsonProperty(value = "nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty(value = "capacite")
    public int getCapacite() {
        return capacite;
    }

    @Override
    public String toString() {
        return "{" + "nom : " + nom + ", capacite : " + capacite + '}';
    }
    
}
