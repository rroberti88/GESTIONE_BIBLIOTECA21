/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

/**
 * @class Libro
 * @brief Rappresenta un libro presente nel catalogo della biblioteca.
 */
public class Libro {
    private String ISBN; /**< Codice ISBN del libro */
    private String titolo; /**< Titolo del libro */
    private String autore; /**< Autore del libro */
    private int annoPubblicazione; /**< Anno di pubblicazione */
    private String Categoria; /**< Categoria o genere del libro */
    private int copieTotali; /**< Numero totale di copie */
    private int copieDisponibili; /**< Numero di copie disponibili per il prestito */

    /**
     * @brief Costruttore della classe Libro.
     * @param ISBN Codice ISBN del libro
     * @param titolo Titolo del libro
     * @param autore Autore del libro
     * @param annoPubblicazione Anno di pubblicazione
     * @param Categoria Categoria del libro
     * @param copieTotali Numero totale di copie
     * @param copieDisponibili Numero di copie disponibili
     */
    public Libro(String ISBN, String titolo, String autore, int annoPubblicazione, String Categoria, int copieTotali, int copieDisponibili) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.Categoria = Categoria;
        this.copieTotali = copieTotali;
        this.copieDisponibili = copieDisponibili;
    }

    /** @brief Restituisce l'ISBN del libro */
    public String getISBN() { return ISBN; }

    /** @brief Imposta l'ISBN del libro */
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    /** @brief Restituisce il titolo del libro */
    public String getTitolo() { return titolo; }

    /** @brief Imposta il titolo del libro */
    public void setTitolo(String titolo) { this.titolo = titolo; }

    /** @brief Restituisce l'autore del libro */
    public String getAutore() { return autore; }

    /** @brief Imposta l'autore del libro */
    public void setAutore(String autore) { this.autore = autore; }

    /** @brief Restituisce l'anno di pubblicazione */
    public int getAnnoPubblicazione() { return annoPubblicazione; }

    /** @brief Imposta l'anno di pubblicazione */
    public void setAnnoPubblicazione(int annoPubblicazione) { this.annoPubblicazione = annoPubblicazione; }

    /** @brief Restituisce la categoria del libro */
    public String getCategoria() { return Categoria; }

    /** @brief Imposta la categoria del libro */
    public void setCategoria(String Categoria) { this.Categoria = Categoria; }

    /** @brief Restituisce il numero totale di copie */
    public int getCopieTotali() { return copieTotali; }

    /** @brief Imposta il numero totale di copie */
    public void setCopieTotali(int copieTotali) { this.copieTotali = copieTotali; }

    /** @brief Restituisce il numero di copie disponibili */
    public int getCopieDisponibili() { return copieDisponibili; }

    /** @brief Imposta il numero di copie disponibili */
    public void setCopieDisponibili(int copieDisponibili) { this.copieDisponibili = copieDisponibili; }

    /**
     * @brief Controlla se il libro Ã¨ valido
     * @return true se tutti i campi obbligatori sono valorizzati correttamente e ISBN valido, false altrimenti
     */
    public boolean isValid() {
        if (titolo != null && autore != null && annoPubblicazione > 0
            && ISBN != null && copieDisponibili > 0 && copieTotali > 0) {
            return ISBN.matches("\\d{13}");
        }
        return false;
    }
}
