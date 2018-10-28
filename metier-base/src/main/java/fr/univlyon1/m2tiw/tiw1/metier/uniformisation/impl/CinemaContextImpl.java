/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;

/**
 *
 * @author florian
 */
public class CinemaContextImpl implements CinemaContext {
    ProgrammationDAO progDAO;
    
    @Override
    public Object getProgDAO() {
       return progDAO;
    }
// CES METHODES SONT A VERIFIER !!!!!!!!!!!!!!!
    @Override
    public void setProgDAO(JSONProgrammationDAO progDAO) {
        this.progDAO = progDAO;
    }
    
}
