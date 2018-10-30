/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation;

/**
 *
 * @author florian
 */
public interface CinemaContext {
    // TODO obtenir une reference sur un obj DAO existant
    // public Object getDAO();
    public Object getDAO(String k);
    // TODO indiquer une ref a un DAO existant
    // public void setProgDAO(JSONProgrammationDAO progDAO);
    public void setDAO(String k, Object o);
}
