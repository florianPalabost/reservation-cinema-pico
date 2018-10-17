package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JPAReservationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONProgrammationDAO;
import fr.univlyon1.m2tiw.tiw1.metier.dao.JSONSalleDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CinemaDTO {
    public static final SimpleDateFormat DATE_PARSER =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");

    public String nom;
    public Collection<SalleDTO> salles;
    public Collection<FilmDTO> films;
    public Collection<SeanceDTO> seances;
    private static final Logger LOGGER = Logger.getLogger(CinemaDTO.class.getName());

    /**
     *
     * As Cinema .
     *
     * @param sallesCinema .
     * @param progDAO .
     * @param reservDAO .
     *
     * @return Cinema
     *
     * @throws java.text.ParseException ParseException
     * @throws java.io.IOException IOException
     */
    public Cinema asCinema(List<Salle> sallesCinema,JSONProgrammationDAO progDAO,
                           JPAReservationDAO reservDAO) throws ParseException, IOException {
        //List<Salle> sallesCinema =  new JSONSalleDAO().load();
        LOGGER.info("CINEMA DTO->sallles");
        LOGGER.info(sallesCinema.toString());
        //sallesCinema.addAll(salles.stream().map(SalleDTO::asSalle).collect(Collectors.toList()));
        LOGGER.info("progDAO.toString()");
        LOGGER.info(progDAO.toString());
        Cinema cinema = new Cinema(nom, sallesCinema,progDAO,reservDAO);
        // progDAO.initData(cinema);
        
        // voir si il faut pas deplacer/ supp ces deux loop
        for (FilmDTO f : films) {
            cinema.addFilm(f.asFilm());
        }
        for (SeanceDTO s : seances) {
            Date d = DATE_PARSER.parse(s.date);
            cinema.createSeance(cinema.getSalle(s.salle), cinema.getFilm(s.film), d, s.prix);
        }
        return cinema;
    }
}
