/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.metier.annuaire;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian
 */
public class Registry implements IRegistry {
    public static final String CTX_ROOT = "/";
    private static Map<String,Object> annuaire = new HashMap<>();
    
    /**
     *
     * @param refName
     * @return
     */
    @Override
    public Object getReference(String refName){
        if(isRegistered(refName)){
            return annuaire.get(refName);
        }
        return null;
    }
    
    /**
     *
     * @param k
     * @param o
     */
    @Override
    public void setReference(String k, Object o){
        if(!isRegistered(k)){
            annuaire.put(k, o);
        }
    }
    
    /**
     *
     * @param refName
     * @return
     */
    public boolean isRegistered(String refName){
        return annuaire.containsKey(refName);
    }

    public static Map<String, Object> getAnnuaire() {
        return annuaire;
    }
    
}
