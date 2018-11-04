package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.config.AppConfig;
import java.io.IOException;

public interface AppConfigDAO {
    public AppConfig load() throws IOException;
}
