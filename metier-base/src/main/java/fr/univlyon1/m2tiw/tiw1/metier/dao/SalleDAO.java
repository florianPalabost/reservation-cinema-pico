/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.tiw1.metier.dao;

import fr.univlyon1.m2tiw.tiw1.metier.Salle;
import java.io.IOException;

/**
 *
 * @author flori
 */
public interface SalleDAO {
    public Salle load() throws IOException;
}
