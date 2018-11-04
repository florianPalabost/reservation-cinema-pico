package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univlyon1.m2tiw.tiw1.config.Component;

public class ComponentDTO {
    @JsonProperty("class-name")
    public String className;
    
    @JsonProperty("path")
    public String path;
    
    public Component asComponent() {
        return new Component(className,path);
    }
}
