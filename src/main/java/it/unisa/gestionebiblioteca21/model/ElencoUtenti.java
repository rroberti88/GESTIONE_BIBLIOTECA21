/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Roberto Roberti
 */
public class ElencoUtenti {
    private ArrayList<Utente> listaUtenti;

    public ElencoUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }
    
    public void inserimentoUtente (Utente utente) {

    }
    public void cancellazioneUtente (Utente utente) {

    }
    public void modificaUtente (Utente utente) {

    }
    public ArrayList<Utente> ricercaUtente(String cognome, String nome, String matricola) {
        return new ArrayList<Utente>();
    }
    public boolean exists (String matricola) {
    return false;
}
}

