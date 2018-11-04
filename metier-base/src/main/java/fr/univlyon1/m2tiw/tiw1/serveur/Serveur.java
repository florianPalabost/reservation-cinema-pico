package fr.univlyon1.m2tiw.tiw1.serveur;

import fr.univlyon1.m2tiw.tiw1.config.AppConfig;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author florian
 */
public interface Serveur {
    public Object processRequest(String methode, String commande, Map<String, Object> parametres) throws IOException;
    public AppConfig getAppConf();
}
