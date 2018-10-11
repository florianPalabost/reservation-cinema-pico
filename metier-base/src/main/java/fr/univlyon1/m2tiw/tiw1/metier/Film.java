package fr.univlyon1.m2tiw.tiw1.metier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * La classe Film.
 *
 */
@JsonRootName(value = "film")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Film {

    /**
     *
     * Le titre .
     *
     */
    @JsonProperty(value = "titre")
    private final String titre;

    /**
     *
     * Langue du film (VO, VF...) .
     *
     */
    //Langue du film (VO, VF...)
    @JsonProperty(value = "version")
    private final String version;

    /**
     *
     * La fiche du film sur Linked Movie Database .
     *
     */
    //La fiche du film sur Linked Movie Database
    @JsonProperty(value = "fiche")
    private final String fiche;

    /**
     *
     * Constructeur de Film avec titre, version et fiche.
     *
     * @param monTitre .
     * @param maVersion .
     * @param maFiche .
     *
     */
    public Film(final String monTitre,
                final String maVersion,
                final String maFiche) {
        this.titre = monTitre;
        this.version = maVersion;
        this.fiche = maFiche;
    }

    /**
     *
     * Constructeur de Film.
     *
     */
    public Film() {
        this.titre = "";
        this.version = "";
        this.fiche = "";
    }

    /**
     *
     * Constructeur de Film avec titre.
     *
     * @param monTitre .
     *
     */
    public Film(final String monTitre) {
        this.titre = monTitre;
        this.version = null;
        this.fiche = null;
    }

    /**
     *
     * @return le film .
     *
     */
    @JsonProperty(value = "titre")
    public String getTitre() {
        return titre;
    }

    /**
     *
     * @return la version .
     *
     */
    @JsonProperty(value = "version")
    @JsonInclude(Include.NON_NULL)
    public String getVersion() {
        return version;
    }

    /**
     *
     * @return la fiche .
     *
     */
    @JsonProperty(value = "fiche")
    @JsonInclude(Include.NON_NULL)
    public String getFiche() {
        return fiche;
    }

    /**
     *
     * @return l'affichage.
     *
     */
    @Override
    public String toString() {
        return "{" + "titre : "
                   + titre
                   + ", version : "
                   + version
                   + ", fiche : "
                   + fiche
                   + '}';
    }

}
