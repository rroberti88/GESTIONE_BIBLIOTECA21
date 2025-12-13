/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package it.unisa.gestionebiblioteca21.model;

import java.util.ArrayList;

/**
 * @class CatalogoLibri
 * @brief Gestisce l'insieme dei libri del catalogo e le operazioni su di essi.
 */
public class CatalogoLibri {

    private ArrayList<Libro> listaLibri; /**< Lista dei libri del catalogo */

    /**
     * @brief Costruttore vuoto, inizializza la lista dei libri.
     */
    public CatalogoLibri() {
        this.listaLibri = new ArrayList<>();
    }

    /**
     * @brief Costruttore con lista predefinita.
     * @param listaLibri Lista iniziale di libri
     */
    public CatalogoLibri(ArrayList<Libro> listaLibri) {
        this.listaLibri = listaLibri != null ? listaLibri : new ArrayList<>();
    }

    /**
     * @brief Restituisce la lista dei libri.
     * @return Lista dei libri
     */
    public ArrayList<Libro> getListaLibri() {
        return listaLibri;
    }

    /**
     * @brief Inserisce un nuovo libro nel catalogo.
     * @param libro Libro da inserire
     * @throws IllegalArgumentException Se i campi sono incompleti o ISBN duplicato
     */
    public void inserimentoLibro(Libro libro) {
        if (libro.getTitolo().isEmpty() || libro.getAutore().isEmpty()
                || libro.getCategoria().isEmpty() || libro.getISBN().isEmpty()) {
            throw new IllegalArgumentException("Tutti i campi devono essere compilati.");
        }

        if (libro.getCopieDisponibili() > libro.getCopieTotali()) {
            throw new IllegalArgumentException("Le copie disponibili non possono superare le copie totali.");
        }

        if (!libro.getISBN().matches("\\d{13}")) {
            throw new IllegalArgumentException("L'ISBN deve contenere esattamente 13 cifre numeriche.");
        }

        for (Libro l : listaLibri) {
            if (l.getISBN().equals(libro.getISBN())) {
                throw new IllegalArgumentException("Libro giÃ  presente");
            }
        }
        listaLibri.add(libro);
    }

    /**
     * @brief Rimuove un libro dal catalogo.
     * @param libro Libro da rimuovere
     */
    public void cancellazioneLibro(Libro libro) {
        listaLibri.remove(libro);
    }

    /**
     * @brief Modifica i dati di un libro esistente.
     * @param libroOriginale Libro da modificare
     * @param libroModificato Nuovi dati del libro
     * @throws IllegalArgumentException Se i campi non sono validi
     */
    public void modificaLibro(Libro libroOriginale, Libro libroModificato) {
        if (libroModificato.getTitolo().isEmpty() || libroModificato.getAutore().isEmpty()
                || libroModificato.getCategoria().isEmpty() || libroModificato.getISBN().isEmpty()) {
            throw new IllegalArgumentException("Tutti i campi devono essere compilati.");
        }

        if (libroModificato.getCopieDisponibili() > libroModificato.getCopieTotali()) {
            throw new IllegalArgumentException("Le copie disponibili non possono superare le copie totali.");
        }

        if (!libroModificato.getISBN().matches("\\d{13}")) {
            throw new IllegalArgumentException("L'ISBN deve contenere esattamente 13 cifre numeriche.");
        }

        libroOriginale.setTitolo(libroModificato.getTitolo());
        libroOriginale.setAutore(libroModificato.getAutore());
        libroOriginale.setAnnoPubblicazione(libroModificato.getAnnoPubblicazione());
        libroOriginale.setCategoria(libroModificato.getCategoria());
        libroOriginale.setCopieTotali(libroModificato.getCopieTotali());
        libroOriginale.setCopieDisponibili(libroModificato.getCopieDisponibili());
    }

    /**
     * @brief Ricerca libri nel catalogo per titolo, autore o ISBN.
     * @param titolo Titolo del libro
     * @param autore Autore del libro
     * @param ISBN ISBN del libro
     * @return Lista dei libri corrispondenti ai criteri
     */
    public ArrayList<Libro> ricercaLibro(String titolo, String autore, String ISBN) {
        ArrayList<Libro> listarisultati = new ArrayList<>();
        for (Libro l : listaLibri) {
            boolean titoloUguale = (titolo == null || titolo.isEmpty()) || l.getTitolo().toLowerCase().contains(titolo.toLowerCase());
            boolean autoreUguale = (autore == null || autore.isEmpty()) || l.getAutore().toLowerCase().contains(autore.toLowerCase());
            boolean isbnUguale = (ISBN == null || ISBN.isEmpty()) || l.getISBN().equalsIgnoreCase(ISBN);

            if (titoloUguale || autoreUguale || isbnUguale) {
                listarisultati.add(l);
            }
        }
        return listarisultati;
    }

    /**
     * @brief Recupera un libro tramite il titolo.
     * @param nome Titolo del libro
     * @return Libro trovato
     * @throws IllegalArgumentException Se il libro non esiste
     */
    public Libro getLibroperilnome(String nome) {
        for (Libro l : listaLibri) {
            if (l.getTitolo().equalsIgnoreCase(nome)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Libro non trovato nel catalogo.");
    }

    /**
     * @brief Cerca un libro tramite ISBN.
     * @param isbn ISBN del libro
     * @return Libro trovato o null se non esiste
     */
    public Libro cercaLibroPerISBN(String isbn) {
        for (Libro libro : listaLibri) {
            if (libro.getISBN().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * @brief Alias per cercare un libro tramite ISBN.
     * @param isbn ISBN del libro
     * @return Libro trovato o null
     */
    public Libro getLibroperISBN(String isbn) {
        return cercaLibroPerISBN(isbn);
    }
}
