/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.metier.annuaire;

import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaContextImpl;

/**
 *
 * @author florian
 */
public class Registry implements IRegistry {
    public static final String CTX_ROOT = "server";
    public CinemaContext instanceRoot;

    public Registry() {
        this.instanceRoot = new CinemaContextImpl();
    }
    
    /**
     *
     * @param refName
     * @return
     */
    @Override
    public Object getReferencedObj(String refName){
        Object currObj = instanceRoot;
        for (String currentPath : refName.split("/")){
            if(currObj != null){
                currObj = ((CinemaContext)currObj).getDAO(currentPath);   
            }
            else {
                return null ;
            }
        }
        return currObj;
    }
    
    /**
     *
     * @param pathRef
     * @param o
     * register a reference of an object in the registry
     */
    @Override
    public void setReferencedObj(String pathRef, Object o){
        int i = 1 ;
        String[] tmpPath = pathRef.split("/") ;
        Object currentObj = instanceRoot ;
        
        // Parcours tant qu'on trouve un /
        for (String currPath : tmpPath) {
            if (currentObj != null) {
                if (i == tmpPath.length) {
                    ((CinemaContext) currentObj).setDAO(currPath, o);
                } else {
                    if (((CinemaContext) currentObj).getDAO(currPath) == null) {
                        ((CinemaContext) currentObj).setDAO(currPath, new CinemaContextImpl());
                        currentObj = ((CinemaContext) currentObj).getDAO(currPath);
                    } else {
                        currentObj = ((CinemaContext) currentObj).getDAO(currPath);
                    }
                    i++;
                }
            }
        } 
    } 
}
