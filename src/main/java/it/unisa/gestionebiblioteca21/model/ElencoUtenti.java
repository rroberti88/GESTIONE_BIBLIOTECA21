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
    
    private boolean emailValida(String email) {
    return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    public void inserimentoUtente(Utente utente) {

    if (utente.getMatricola().isEmpty() || utente.getNome().isEmpty() || utente.getCognome().isEmpty() || utente.getEmail().isEmpty()) {
        throw new IllegalArgumentException("Tutti i campi sono obbligatori.");
    }
    
    if (!emailValida(utente.getEmail())){
            throw new IllegalArgumentException("email non valida. Esempio di formato valido: giacomo21@gmail.com");
        }
        
    for (Utente u : listaUtenti){
    if (u.getMatricola().equals(utente.getMatricola())){
        throw new IllegalArgumentException("Utente già presente");
    }
    }
    listaUtenti.add(utente);
    }

    public void cancellazioneUtente(Utente utente) {
    if (utente == null) return;
        listaUtenti.removeIf(u -> u.getMatricola().equalsIgnoreCase(utente.getMatricola()));
    }

    public void modificaUtente(Utente utenteOriginale, Utente utenteModificato) {
        if (utenteOriginale == null || utenteModificato == null) return;

    if (utenteModificato.getNome().isEmpty() || utenteModificato.getCognome().isEmpty() || utenteModificato.getEmail().isEmpty()) {
        throw new IllegalArgumentException("Tutti i campi sono obbligatori.");
    }
    
    if (!emailValida(utenteModificato.getEmail())){
        throw new IllegalArgumentException("Email non valida. Esempio: giacomo21@gmail.com");
    }

    utenteOriginale.setNome(utenteModificato.getNome());
    utenteOriginale.setCognome(utenteModificato.getCognome());
    utenteOriginale.setEmail(utenteModificato.getEmail());
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





