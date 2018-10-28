/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.Seance;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaAbs;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author florian
 */

// gestion des seances 
public class CinemaRessourceSeances extends CinemaAbs {
    //createSeance(), removeSeance(), getNbSeance()
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSeances.class.getName());
    private Collection<Seance> seances;
    private ProgrammationDAO progDAO;
    private ReservationDAO reservationDAO;

    public CinemaRessourceSeances(ProgrammationDAO progDAO, ReservationDAO reservationDAO) {
        this.progDAO = progDAO;
        this.reservationDAO = reservationDAO;
        setSeances(this.progDAO.getSeances().values());
    }
    
    
     public void setSeances(Collection<Seance> seances) {
        this.seances = seances;
        for (Seance s : seances) {
            s.setReservationDAO(reservationDAO);
        }
    }

    private void createSeance(Salle salle, Film film, Date date, float prix) throws IOException {
        Seance seance = new Seance(film, salle, date, prix);
        this.seances.add(seance);
        progDAO.save(seance);
        seance.setReservationDAO(reservationDAO);
    }

    public void removeSeance(Seance seance) throws IOException {
        seances.remove(seance);
        progDAO.delete(seance);
    }

    private int getNbSeances() {
        return seances.size();
    }
    
    public Object process(String commande, Map<String,Object> parametres) throws IOException{
        return null;
    }
    
    @Override
    public void start() {
        LOGGER.info("Component "+ this.getClass() +" started");
    }
    
    @Override
    public void stop(){
        LOGGER.info("Component "+ this.getClass() +" stopped");
    }
}
