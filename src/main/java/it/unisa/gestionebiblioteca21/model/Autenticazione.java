/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Roberto Roberti
 */
public class Autenticazione {
    private ArrayList<Bibliotecario> utentiAutorizzati; 

    public Autenticazione(ArrayList<Bibliotecario> utentiAutorizzati) {
        this.utentiAutorizzati = utentiAutorizzati;
    }
    public boolean login (String username, String password){
    return true;
    }
    public boolean logout (){
    return true;
    }
    public boolean modificaPassword (String nuovaPassword){
    return false;
    }
    public boolean reimpostaPassword (String username, String nuovaPassword){
    return false;
    }
}
