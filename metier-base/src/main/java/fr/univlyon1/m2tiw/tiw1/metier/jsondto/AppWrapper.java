package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppWrapper {
    @JsonProperty("application-config")
    public AppConfigDTO appConfigDTO;
}
