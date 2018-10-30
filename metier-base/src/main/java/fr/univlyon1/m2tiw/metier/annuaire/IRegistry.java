/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.m2tiw.metier.annuaire;

/**
 *
 * @author florian
 */
public interface IRegistry {
     public Object getReference(String refName);
     
     public void setReference(String k, Object o);
}
