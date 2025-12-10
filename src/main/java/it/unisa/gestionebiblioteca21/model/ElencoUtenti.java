/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package it.unisa.gestionebiblioteca21.model;
import java.util.List;
import java.util.ArrayList;
/*
 * @author Roberto Roberti
*/
public class ElencoUtenti {

    private ArrayList<Utente> listaUtenti;

    public ElencoUtenti() {
        this.listaUtenti = new ArrayList<>();
    }

    public ElencoUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = (listaUtenti != null) ? listaUtenti : new ArrayList<>();
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void inserimentoUtente(Utente utente) {
        if (utente == null) return;
        if (!exists(utente.getMatricola())) {
            listaUtenti.add(utente);
        }
    }

    public void cancellazioneUtente(Utente utente) {
        if (utente == null) return;
        listaUtenti.removeIf(u -> u.getMatricola().equalsIgnoreCase(utente.getMatricola()));
    }
    public void modificaUtente(Utente utente) {
        if (utente == null) return;

        for (int i = 0; i < listaUtenti.size(); i++) {
            Utente u = listaUtenti.get(i);
            if (u.getMatricola().equalsIgnoreCase(utente.getMatricola())) {
                listaUtenti.set(i, utente);
                return;
            }
        }
    }

    public ArrayList<Utente> ricercaUtente(String cognome, String nome, String matricola) {
        ArrayList<Utente> risultati = new ArrayList<>();

        for (Utente u : listaUtenti) {
            boolean matchCognome = (cognome == null || cognome.isEmpty()) ||
                    u.getCognome().toLowerCase().contains(cognome.toLowerCase());

            boolean matchNome = (nome == null || nome.isEmpty()) ||
                    u.getNome().toLowerCase().contains(nome.toLowerCase());

            boolean matchMatricola = (matricola == null || matricola.isEmpty()) ||
                    u.getMatricola().equalsIgnoreCase(matricola);

            if (matchCognome || matchNome || matchMatricola) {
                risultati.add(u);
            }
        }

        return risultati;
    }

    public boolean exists(String matricola) {
        if (matricola == null) return false;
        for (Utente u : listaUtenti) {
            if (matricola.equalsIgnoreCase(u.getMatricola())) {
                return true;
            }
        }
        return false;
    }
}





