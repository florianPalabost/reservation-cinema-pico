package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "film")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public Film(String titre){
        this.titre = titre;
        this.version = null;
        this.fiche = null;
    }
    @JsonProperty(value="titre")
    public String getTitre() {
        return titre;
    }
    @JsonProperty(value="version")
    @JsonInclude(Include.NON_NULL)
    public String getVersion() {
        return version;
    }
    @JsonProperty(value="fiche")
    @JsonInclude(Include.NON_NULL)
    public String getFiche() {
        return fiche;
    }

    @Override
    public String toString() {
        return "{" + "titre : " + titre + ", version : " + version + ", fiche : " + fiche + '}';
    }
    
}
