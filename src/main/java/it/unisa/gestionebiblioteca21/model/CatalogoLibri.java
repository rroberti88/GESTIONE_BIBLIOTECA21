/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package it.unisa.gestionebiblioteca21.model;

import java.util.ArrayList;

public class CatalogoLibri {
    private ArrayList<Libro> listaLibri;

    public CatalogoLibri() {
        this.listaLibri = new ArrayList<>();
    }

    public CatalogoLibri(ArrayList<Libro> listaLibri) {
        this.listaLibri = listaLibri != null ? listaLibri : new ArrayList<>();
    }

    public ArrayList<Libro> getListaLibri() {
        return listaLibri;
    }

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
                throw new IllegalArgumentException("Libro già presente");
            }
        }
        listaLibri.add(libro);
    }

    public void cancellazioneLibro(Libro libro) {
        listaLibri.remove(libro);
    }

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

    public Libro getLibroperilnome(String nome) {
        for (Libro l : listaLibri) {
            if (l.getTitolo().equalsIgnoreCase(nome)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Libro non trovato nel catalogo.");
    }

    public Libro cercaLibroPerISBN(String isbn) {
        for (Libro libro : listaLibri) {
            if (libro.getISBN().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro getLibroperISBN(String isbn) {
        return cercaLibroPerISBN(isbn);
    }
}
