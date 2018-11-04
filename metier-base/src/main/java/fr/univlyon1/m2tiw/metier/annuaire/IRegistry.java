package fr.univlyon1.m2tiw.metier.annuaire;

/**
 *
 * IRegistry .
 *
 * @author florian
 */
public interface IRegistry {
    public Object getReferencedObj(String refName);
     
    public void setReferencedObj(String pathRef, Object o);
}
