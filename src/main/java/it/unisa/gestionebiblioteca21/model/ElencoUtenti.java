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
    private List<Utente> listaUtenti;

    public ElencoUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }
    
    public void inserimentoUtente (Utente utente) {

    }
    public void cancellazioneUtente (Utente utente) {

    }
    public void modificaUtente (Utente utente) {

    }
    public List<Utente> ricercaUtente(String chiaveRicerca) {
        return new ArrayList<Utente>();
    }
    public boolean exists (String matricola) {
    return false;
}
}

