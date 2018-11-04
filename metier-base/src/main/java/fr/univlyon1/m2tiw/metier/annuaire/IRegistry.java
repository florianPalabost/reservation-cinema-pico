package fr.univlyon1.m2tiw.metier.annuaire;

/**
 *
 * IRegistry .
 *
 * @author florian
 */
public interface IRegistry {
    // retourne l'objet demandé en fonction de son chemin dans l'annuaire
    public Object getReferencedObj(String refName);
    
    // ajoute ou met a jour un objet en fonciton de son chemin dans l'annuaire
    public void setReferencedObj(String pathRef, Object o);
}
