/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univlyon1.m2tiw.tiw1.metier.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import fr.univlyon1.m2tiw.tiw1.metier.dao.SalleDAO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.SalleDTO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.SalleWrapper;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JSONSalleDAO implements SalleDAO {

    private static final URL RESOURCE = JSONSalleDAO.class.getResource("/sample-data/salles.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(JSONSalleDAO.class.getName());
    // private List<Salle> salles;
    
    @Override
    public List<Salle> load() throws IOException {
        ArrayList<Salle> salles = new ArrayList<>();
        Collection<SalleDTO> sallesDTO = mapper.readValue(RESOURCE, SalleWrapper.class).salles;
        // salles.addAll(sallesDTO.stream().map(SalleDTO::asSalle).collect(Collectors.toList()));
        for (SalleDTO sDto: sallesDTO) {
            salles.add(sDto.asSalle());
        }
        return salles;
    }
    /*
        @Override
        public String toString() {
            return "{" + salles + '}';
        }
    */

    
}
