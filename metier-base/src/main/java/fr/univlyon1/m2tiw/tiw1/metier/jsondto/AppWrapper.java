package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import com.fasterxml.jackson.annotation.JsonProperty;

// meme modele que pour cinema et salle, on utilise un wrapper 
public class AppWrapper {
    @JsonProperty("application-config")
    public AppConfigDTO appConfigDTO;
}
