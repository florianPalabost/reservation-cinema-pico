package fr.univlyon1.m2tiw.tiw1.serveur;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian
 */
public interface Serveur {
      public Object processRequest(String commande, Map<String, Object> parametres);
}
