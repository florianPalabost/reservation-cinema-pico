/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian
 */
public class CinemaContextImpl implements CinemaContext {
    private Map<String,Object> cineContext;

    public CinemaContextImpl() {
        this.cineContext = new HashMap<>();
    }

    @Override
    public Object getDAO(String k) {
        if(cineContext.containsKey(k)) {
            return cineContext.get(k);
        }
        return null;
    }

    @Override
    public void setDAO(String k, Object o) {
        cineContext.put(k, o);
    }
    

    
}
