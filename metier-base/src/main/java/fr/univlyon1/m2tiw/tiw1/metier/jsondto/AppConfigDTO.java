package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univlyon1.m2tiw.tiw1.config.Component;
import fr.univlyon1.m2tiw.tiw1.config.AppConfig;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class AppConfigDTO {
    @JsonProperty("name")
    public String name;
    
    @JsonProperty("business-components")
    private ArrayList<ComponentDTO> businessComponents;
    
    @JsonProperty("service-components")
    private ArrayList<ComponentDTO> serviceComponents;
    
    @JsonProperty("persistence-components")
    private ArrayList<ComponentDTO> persistenceComponents;

    /**
     *
     * asAppConfig .
     *
     * @return AppConfig object
     * @throws java.text.ParseException mauvais parsing des donnees
     * @throws java.io.IOException erreur lecture fichier
     */
    public AppConfig asAppConfig() throws ParseException, IOException {
        ArrayList<Component> businessComps = new ArrayList<>();
        ArrayList<Component> serviceComps = new ArrayList<>();
        ArrayList<Component> persistenceComps = new ArrayList<>();

        businessComponents.forEach((compDTO) -> {
            businessComps.add(compDTO.asComponent());
        });

        serviceComponents.forEach((compDTO) -> {
            serviceComps.add(compDTO.asComponent());
        });

        persistenceComponents.forEach((compDTO) -> {
            persistenceComps.add(compDTO.asComponent());
        });
        return new AppConfig(name,businessComps,serviceComps,persistenceComps);
    }

}
