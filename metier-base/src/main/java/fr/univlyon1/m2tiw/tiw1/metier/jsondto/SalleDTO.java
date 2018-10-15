package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import java.util.Collection;
import java.util.List;

public class SalleDTO {
    public String nom;
    public int capacite;
    //public Collection<Salle> salles;
    
    public Salle asSalle() {
       /* List<Salle> salles = null;
        for(Salle salle: salles){
           salle =  new Salle(salle.getNom(), salle.getCapacite());
           salles.add(salle);
        }*/
        return new Salle(nom,capacite);
    }
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }
    @JsonProperty("capacite")
    public int getCapacite() {
        return capacite;
    }
    @JsonProperty("capacite")
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "{" + "nom: " + nom + ", capacite: " + capacite + '}';
    }
    
    
}
