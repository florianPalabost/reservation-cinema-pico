/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.SalleDTO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.SalleWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author flori
 */
public class JSONSalleDAO implements SalleDAO {

    private static final URL RESOURCE = JSONSalleDAO.class.getResource("/sample-data/salles.json");
    private final ObjectMapper mapper = new ObjectMapper();
     private static final Logger LOGGER = Logger.getLogger( JSONSalleDAO.class.getName() );
    @Override
    public Salle load() throws IOException {
        SalleDTO salleDTO = mapper.readValue(RESOURCE, SalleWrapper.class).salles;
        LOGGER.info("SALLES PARSE JSON");
        LOGGER.info(salleDTO.toString());
        return salleDTO.asSalle();
    }
    
}
