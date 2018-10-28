/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;

/**
 *
 * @author florian
 */
public interface CinemaContext {
    // TODO obtenir une reference sur un obj ProgDAO existant
    public Object getProgDAO();
    // TODO indiquer une ref a un progDAO existant
    public void setProgDAO(JSONProgrammationDAO progDAO);
}
