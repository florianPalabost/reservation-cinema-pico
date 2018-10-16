package fr.univlyon1.m2tiw.tiw1.metier.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.tiw1.metier.Cinema;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaDTO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.CinemaWrapper;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONCinemaDAO implements CinemaDAO {

    private static final URL RESOURCE = JSONCinemaDAO.class.getResource(
            "/sample-data/mon-cinema.json");

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Cinema load(List<Salle> salles, JSONProgrammationDAO progDAO, JPAReservationDAO reservDAO) throws IOException {
        CinemaDTO cinemaDTO = mapper.readValue(RESOURCE, CinemaWrapper.class).cinema;
        try {
            return cinemaDTO.asCinema(salles,progDAO,reservDAO);
        } catch (ParseException ex) {
            Logger.getLogger(JSONCinemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
