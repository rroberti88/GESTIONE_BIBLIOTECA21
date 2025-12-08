/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import java.util.ArrayList;
/**
 *
 * @author Roberto Roberti
 */
public class Autenticazione {
    private final ArrayList<Bibliotecario> utentiAutorizzati; 

    public Autenticazione(ArrayList<Bibliotecario> utentiAutorizzati) {
        this.utentiAutorizzati = utentiAutorizzati;
    }
    public boolean login (String username, String password){
    for (Bibliotecario b : utentiAutorizzati) {
    if (b.getUsername().equals(username) && b.getPassword().equals(password))
    {
    return true;
    }
    }
    return false;
    }
    public boolean logout (String username){
    return true;
    }
    public boolean modificaPassword (String username, String nuovaPassword){
    for (Bibliotecario b : utentiAutorizzati) {
    if (b.getUsername().equals(username))
    {
    b.setPassword(nuovaPassword);
    }
    }
    return false;
    }
    public boolean reimpostaPassword (String username, String nuovaPassword){
    return modificaPassword (username,nuovaPassword);
    }
}
