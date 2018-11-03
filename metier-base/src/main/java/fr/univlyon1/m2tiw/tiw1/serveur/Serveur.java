package fr.univlyon1.m2tiw.tiw1.serveur;

import java.util.Map;

/**
 * Serveur .
 * @author florian
 */
public interface Serveur {
    public Object processRequest(String methode, String commande, Map<String, Object> parametres);
}
