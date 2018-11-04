package fr.univlyon1.m2tiw.metier.annuaire;

import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl.CinemaContextImpl;

/**
 *
 * Registry .
 *
 * @author florian
 */
public class Registry implements IRegistry {
    public static final String CTX_ROOT = "/server";
    public CinemaContext root;

    public Registry() {
        this.root = new CinemaContextImpl();
    }
    
    /**
     *
     * getReferencedObj .
     *
     * @param refName .
     * @return object qui en fonction du path
     */
    @Override
    public Object getReferencedObj(String refName) {
        Object currObj = root;
        for (String currentPath : refName.split("/")) {
            if (currObj != null) {
                currObj = ((CinemaContext)currObj).getDAO(currentPath);   
            } else {
                return null;
            }
        }
        return currObj;
    }
    
    /**
     *
     * setReferencedObj .
     * register a reference of an object in the registry .
     *
     * @param pathRef .
     * @param o .
     *
     */
    @Override
    public void setReferencedObj(String pathRef, Object o) {
        int i = 1;
        String[] tmpPath = pathRef.split("/");
        Object currentObj = root;
        
        // Parcours tant qu'on trouve un / , on a cependant quand meme 
        // des appels sur des "" ... 
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
