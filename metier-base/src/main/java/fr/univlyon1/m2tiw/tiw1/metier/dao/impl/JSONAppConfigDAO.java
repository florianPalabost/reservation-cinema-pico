package fr.univlyon1.m2tiw.tiw1.metier.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univlyon1.m2tiw.tiw1.config.AppConfig;
import fr.univlyon1.m2tiw.tiw1.metier.dao.AppConfigDAO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.AppConfigDTO;
import fr.univlyon1.m2tiw.tiw1.metier.jsondto.AppWrapper;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONAppConfigDAO implements AppConfigDAO{

    private static final URL RESOURCE = 
            JSONAppConfigDAO.class.getResource("/conf/config.json");
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public AppConfig load() throws IOException {
        try {
            AppConfigDTO appConfDTO = mapper.readValue(RESOURCE, AppWrapper.class).appConfigDTO;
            return appConfDTO.asAppConfig();
        } catch (ParseException ex) {
            Logger.getLogger(JSONAppConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
