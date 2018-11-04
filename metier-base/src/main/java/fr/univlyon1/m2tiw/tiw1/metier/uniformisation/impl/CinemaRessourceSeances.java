package fr.univlyon1.m2tiw.tiw1.metier.uniformisation.impl;

import fr.univlyon1.m2tiw.tiw1.metier.Film;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.Seance;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.ReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.ACinemaRessource;
import fr.univlyon1.m2tiw.tiw1.metier.uniformisation.CinemaContext;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * CinemaRessourceSeances .
 *
 * @author alper
 */
// gestion des seances 
public class CinemaRessourceSeances extends ACinemaRessource {
    //createSeance(), removeSeance(), getNbSeance()
    private static final Logger LOGGER = Logger.getLogger(CinemaRessourceSeances.class.getName());
    private Collection<Seance> seances;
    private ProgrammationDAO progDAO;
    private ReservationDAO reservationDAO;

    /*
    public CinemaRessourceSeances(ProgrammationDAO progDAO, ReservationDAO reservationDAO) {
        this.progDAO = progDAO;
        this.reservationDAO = reservationDAO;
        setSeances(this.progDAO.getSeances().values());
    }*/

    /**
     *
     * CinemaRessourceSeances .
     *
     * @param cineContext
     *
     */
    public CinemaRessourceSeances(CinemaContext cineContext) {
        this.progDAO = (ProgrammationDAO) cineContext.getDAO(ProgrammationDAO.CONTEXT);
        this.reservationDAO = (ReservationDAO) cineContext.getDAO(ReservationDAO.CONTEXT);
        setSeances(this.progDAO.getSeances().values());
    }

    /**
     *
     * setSeances .
     *
     * @param seances
     *
     */
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

    /**
     *
     * process .
     *
     * @param commande .
     * @param parametres .
     *
     * @return Object .
     *
     * @throws IOException Exception IO
     */
    public Object process(String commande, Map<String,Object> parametres) throws IOException {
        switch (commande) {
            case "createSeance":
                // A TESTER 
                createSeance((Salle)parametres.get("salle"),(Film) parametres.get("film"),
                        (Date)parametres.get("date"),(Float) parametres.get("prix"));
                return null;
                
            case "removeSeance":
                removeSeance((Seance) parametres.get("seance"));
                return null;
                
            case "getNbSeances":
                return getNbSeances();

            case "setSeances":
                setSeances((Collection<Seance>) parametres.get("seances"));
                return null;
                
            default:
                return null;
        }
    }
    
    @Override
    public void start() {
        LOGGER.info("Component " + this.getClass() + " started");
    }
    
    @Override
    public void stop() {
        LOGGER.info("Component " + this.getClass() + " stopped");
    }
}
