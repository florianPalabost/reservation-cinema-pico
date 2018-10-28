/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

import java.io.IOException;
import java.util.Map;
import org.picocontainer.Startable;

/**
 *
 * @author florian
 */
public interface CinemaInt extends Startable {
  
    // Methode de service
    public Object process(String methode, String commande, Map<String,Object> parametres) throws IOException ;
    
}
