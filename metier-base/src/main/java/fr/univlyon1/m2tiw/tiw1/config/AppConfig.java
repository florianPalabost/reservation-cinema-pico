package fr.univlyon1.m2tiw.tiw1.config;

import java.util.ArrayList;

public class AppConfig {
    private String name;
    private ArrayList<Component> businessComponents;
    private ArrayList<Component> serviceComponents;
    private ArrayList<Component> persistenceComponents;

    /**
     *
     * AppConfig .
     *
     * @param name .
     * @param businessComponents .
     * @param serviceComponents .
     * @param persistenceComponents .
     *
     */
    public AppConfig(String name, ArrayList<Component> businessComponents,
                     ArrayList<Component> serviceComponents,
                     ArrayList<Component> persistenceComponents) {
        this.name = name;
        this.businessComponents = businessComponents;
        this.serviceComponents = serviceComponents;
        this.persistenceComponents = persistenceComponents;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Component> getBusinessComponents() {
        return businessComponents;
    }

    public ArrayList<Component> getServiceComponents() {
        return serviceComponents;
    }

    public ArrayList<Component> getPersistenceComponents() {
        return persistenceComponents;
    }
    
    
}
