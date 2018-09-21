package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "film")
public class Film {
    @JsonProperty(value="titre")
    private final String titre;
    //Langue du film (VO, VF...)
    @JsonProperty(value="version")
    private final String version;
    //La fiche du film sur Linked Movie Database
    @JsonProperty(value="fiche")
    private final String fiche;

    public Film(String titre, String version, String fiche) {
        this.titre = titre;
        this.version = version;
        this.fiche = fiche;
    }
    
    public Film(){
        this.titre = "";
        this.version = "";
        this.fiche = "";
    }
    @JsonGetter
    public String getTitre() {
        return titre;
    }
    @JsonGetter
    public String getVersion() {
        return version;
    }
    @JsonGetter
    public String getFiche() {
        return fiche;
    }
}
