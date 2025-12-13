/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package it.unisa.gestionebiblioteca21.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @class ElencoPrestiti
 * @brief Rappresenta l'elenco dei prestiti della biblioteca.
 */
public class ElencoPrestiti {

    private final ArrayList<Prestito> listaPrestiti; ///< Lista interna dei prestiti

    /**
     * @brief Costruttore di default, inizializza la lista dei prestiti vuota.
     */
    public ElencoPrestiti() {
        this.listaPrestiti = new ArrayList<>();
    }

    /**
     * @brief Costruttore con lista iniziale di prestiti.
     * @param listaPrestiti Lista di prestiti da impostare (se null crea una lista vuota)
     */
    public ElencoPrestiti(ArrayList<Prestito> listaPrestiti) {
        this.listaPrestiti = listaPrestiti != null ? listaPrestiti : new ArrayList<>();
    }

    /**
     * @brief Registra un nuovo prestito e aggiorna le copie disponibili del libro.
     * 
     * Controlla che il prestito e il libro non siano nulli, che tutti i campi
     * del prestito siano compilati, che l'utente non abbia più di 3 prestiti attivi
     * e che ci siano copie disponibili del libro.
     * @param prestito Prestito da registrare
     * @param libro Libro associato al prestito
     * @throws IllegalArgumentException se prestito o libro sono null o campi mancanti
     * @throws IllegalStateException se l'utente ha già 3 prestiti o il libro non ha copie disponibili
     * @return void
     */
    public void registraPrestito(Prestito prestito, Libro libro) {

        if (prestito == null || libro == null) {
            throw new IllegalArgumentException("Prestito o libro non possono essere null.");
        }

        if (prestito.getLibro().isEmpty() || prestito.getUtente().isEmpty()
                || prestito.getDataPrestito() == null || prestito.getDataScadenza() == null) {
            throw new IllegalArgumentException("Tutti i campi del prestito devono essere compilati.");
        }

        long prestitiUtente = listaPrestiti.stream()
                .filter(p -> p.getUtente().equalsIgnoreCase(prestito.getUtente()) && p.isLent())
                .count();

        if (prestitiUtente >= 3) {
            throw new IllegalStateException("L'utente ha già 3 prestiti attivi.");
        }

        if (libro.getCopieDisponibili() <= 0) {
            throw new IllegalStateException("Nessuna copia disponibile per questo libro.");
        }

        listaPrestiti.add(prestito);
        libro.setCopieDisponibili(libro.getCopieDisponibili() - 1);
    }

    /**
     * @brief Registra la restituzione di un prestito specifico.
     * 
     * Rimuove il prestito dalla lista se corrisponde a ISBN, matricola utente
     * e data di restituzione.
     * @param isbn ISBN del libro restituito
     * @param matricola Matricola dell'utente
     * @param dataRestituzione Data di restituzione
     * @return true se il prestito è stato trovato e rimosso, false altrimenti
     */
    public boolean registraRestituzione(String isbn, String matricola, LocalDate dataRestituzione) {
        for (Prestito p : listaPrestiti) {
            if (p.getLibro().equalsIgnoreCase(isbn)
                    && p.getUtente().equalsIgnoreCase(matricola)
                    && p.isLent() && p.getDataScadenza().equals(dataRestituzione)) {

                listaPrestiti.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * @brief Restituisce l'intera lista dei prestiti.
     * @return ArrayList<Prestito> Lista dei prestiti
     */
    public ArrayList<Prestito> getListaPrestiti() {
        return listaPrestiti;
    }

    /**
     * @brief Esegue una ricerca dei prestiti per libro o utente.
     * 
     * Filtra la lista dei prestiti in base alla presenza del testo nel
     * titolo del libro o nella matricola/nome utente.
     * @param libro Stringa di ricerca per il libro (può essere null o vuota)
     * @param utente Stringa di ricerca per l'utente (può essere null o vuota)
     * @return ArrayList<Prestito> Lista dei prestiti che soddisfano il criterio
     */
    public ArrayList<Prestito> ricercaPrestito(String libro, String utente) {
        ArrayList<Prestito> listaRisultatiPrestiti = new ArrayList<>();

        for (Prestito p : listaPrestiti) {

            boolean libroUguale  = (libro == null || libro.isEmpty()) ||
                                  p.getLibro().toLowerCase().contains(libro.toLowerCase());

            boolean utenteUguale = (utente == null || utente.isEmpty()) ||
                                  p.getUtente().toLowerCase().contains(utente.toLowerCase());

            if (libroUguale || utenteUguale) {
                listaRisultatiPrestiti.add(p);
            }
        }
        return listaRisultatiPrestiti;
    }

    /**
     * @brief Cerca un prestito attivo dato ISBN e matricola utente.
     * @param isbn ISBN del libro
     * @param matricola Matricola dell'utente
     * @return Prestito trovato oppure null se non esiste
     */
    public Prestito cercaPrestitoISBNMatricola(String isbn, String matricola) {
        for (Prestito p : listaPrestiti) {
            if (p.getLibro().equalsIgnoreCase(isbn)
                    && p.getUtente().equalsIgnoreCase(matricola)
                    && p.isLent()) {
                return p;
            }
        }
        return null;
    }

    /**
     * @brief Cancella un prestito dalla lista.
     * @param p Prestito da cancellare
     * @return true se il prestito è stato rimosso, false se p era null
     */
    public boolean cancellazionePrestito(Prestito p) {
        if (p == null) return false;
        return listaPrestiti.remove(p);
    }

    /**
     * @brief Cerca un prestito dato ISBN, matricola e data di scadenza.
     * @param isbn ISBN del libro
     * @param matricola Matricola dell'utente
     * @param dataScadenza Data di scadenza del prestito
     * @return Prestito trovato o null se non esiste
     */
    public Prestito cercaPrestito(String isbn, String matricola, LocalDate dataScadenza) {
        for (Prestito p : listaPrestiti) {
            if (p.getLibro().equals(isbn)
                    && p.getUtente().equalsIgnoreCase(matricola)
                    && p.getDataScadenza().isEqual(dataScadenza)) {
                return p;
            }
        }
        return null;
    }
}
