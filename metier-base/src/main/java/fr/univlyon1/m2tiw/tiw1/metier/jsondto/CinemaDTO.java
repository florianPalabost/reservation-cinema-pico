package fr.univlyon1.m2tiw.tiw1.metier.jsondto;

import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
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
     private static final Logger LOGGER = Logger.getLogger(CinemaDTO.class.getName() );
    /**
     *
     * As Cinema .
     *
     * @return Cinema
     */
    public Cinema asCinema(List<Salle> sallesCinema) throws ParseException, IOException {
        //List<Salle> sallesCinema =  new JSONSalleDAO().load();
        LOGGER.info("CINEMA DTO->sallles");
        LOGGER.info(sallesCinema.toString());
        //sallesCinema.addAll(salles.stream().map(SalleDTO::asSalle).collect(Collectors.toList()));
        Cinema cinema = new Cinema(nom, sallesCinema);
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
