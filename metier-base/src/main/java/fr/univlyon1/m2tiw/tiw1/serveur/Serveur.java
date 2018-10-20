package fr.univlyon1.m2tiw.tiw1.serveur;

import java.util.HashMap;

/**
 *
 * @author flori
 */
public interface Serveur {
      public Object processRequest(String commande, HashMap<String, Object> parametres);
}
