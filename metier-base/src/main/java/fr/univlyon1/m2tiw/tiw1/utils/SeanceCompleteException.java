package fr.univlyon1.m2tiw.tiw1.utils;

/**
 *
 * La classe Film.
 *
 */
public class SeanceCompleteException extends Exception {

    /**
     *
     * Exception lors d'un seance complet .
     *
     */
    public SeanceCompleteException() {
        super("Cette seance est complete.");
    }
}
