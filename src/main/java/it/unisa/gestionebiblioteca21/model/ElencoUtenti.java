/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package it.unisa.gestionebiblioteca21.model;

import java.util.ArrayList;

/**
 * @class ElencoUtenti
 * @brief Gestisce l'elenco degli utenti della biblioteca.
 */
public class ElencoUtenti {

    private ArrayList<Utente> listaUtenti; /**< Lista di utenti */

    /**
     * @brief Costruttore vuoto, inizializza la lista degli utenti.
     */
    public ElencoUtenti() {
        this.listaUtenti = new ArrayList<>();
    }

    /**
     * @brief Costruttore con lista iniziale di utenti.
     * @param listaUtenti Lista di utenti iniziale
     */
    public ElencoUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = (listaUtenti != null) ? listaUtenti : new ArrayList<>();
    }

    /**
     * @brief Restituisce la lista degli utenti.
     * @return Lista degli utenti
     */
    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    /**
     * @brief Controlla se un'email ha un formato valido.
     * @param email Email da validare
     * @return true se valida, false altrimenti
     */
    private boolean emailValida(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    /**
     * @brief Inserisce un nuovo utente nell'elenco.
     * @param utente Utente da inserire
     * @throws IllegalArgumentException Se campi vuoti o email non valida o utente già presente
     */
    public void inserimentoUtente(Utente utente) {
        if (utente.getMatricola().isEmpty() || utente.getNome().isEmpty()
                || utente.getCognome().isEmpty() || utente.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Tutti i campi sono obbligatori.");
        }

        if (!emailValida(utente.getEmail())) {
            throw new IllegalArgumentException("Email non valida. Esempio: giacomo21@gmail.com");
        }

        for (Utente u : listaUtenti) {
            if (u.getMatricola().equals(utente.getMatricola())) {
                throw new IllegalArgumentException("Utente già presente");
            }
        }

        listaUtenti.add(utente);
    }

    /**
     * @brief Cancella un utente dall'elenco.
     * @param utente Utente da rimuovere
     */
    public void cancellazioneUtente(Utente utente) {
        if (utente == null) return;
        listaUtenti.removeIf(u -> u.getMatricola().equalsIgnoreCase(utente.getMatricola()));
    }

    /**
     * @brief Modifica i dati di un utente esistente.
     * @param utenteOriginale Utente da modificare
     * @param utenteModificato Nuovi dati dell'utente
     * @throws IllegalArgumentException Se campi vuoti o email non valida
     */
    public void modificaUtente(Utente utenteOriginale, Utente utenteModificato) {
        if (utenteOriginale == null || utenteModificato == null) return;

        if (utenteModificato.getNome().isEmpty() || utenteModificato.getCognome().isEmpty()
                || utenteModificato.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Tutti i campi sono obbligatori.");
        }

        if (!emailValida(utenteModificato.getEmail())) {
            throw new IllegalArgumentException("Email non valida. Esempio: giacomo21@gmail.com");
        }

        utenteOriginale.setNome(utenteModificato.getNome());
        utenteOriginale.setCognome(utenteModificato.getCognome());
        utenteOriginale.setEmail(utenteModificato.getEmail());
    }

    /**
     * @brief Cerca utenti in base a cognome, nome o matricola.
     * @param cognome Cognome da cercare (opzionale)
     * @param nome Nome da cercare (opzionale)
     * @param matricola Matricola da cercare (opzionale)
     * @return Lista degli utenti corrispondenti ai criteri
     */
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

    /**
     * @brief Controlla se esiste un utente con una determinata matricola.
     * @param matricola Matricola da controllare
     * @return true se esiste, false altrimenti
     */
    public boolean exists(String matricola) {
        if (matricola == null) return false;
        for (Utente u : listaUtenti) {
            if (matricola.equalsIgnoreCase(u.getMatricola())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @brief Cerca un utente tramite la matricola.
     * @param matricola Matricola dell'utente
     * @return Utente trovato o null se non esiste
     */
    public Utente cercaPerMatricola(String matricola) {
        if (matricola == null || matricola.isEmpty()) return null;

        for (Utente u : listaUtenti) {
            if (u.getMatricola().equalsIgnoreCase(matricola)) {
                return u;
            }
        }

        return null;
    }
}






