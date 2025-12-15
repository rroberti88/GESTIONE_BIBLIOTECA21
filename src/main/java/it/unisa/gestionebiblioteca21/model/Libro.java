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
    private int copieDisponibili; /**< Numero di copie disponibili per il prestito */

    /**
     * @brief Costruttore della classe Libro.
     * @param ISBN Codice ISBN del libro
     * @param titolo Titolo del libro
     * @param autore Autore del libro
     * @param annoPubblicazione Anno di pubblicazione
     * @param copieDisponibili Numero di copie disponibili
     */
    public Libro(String ISBN, String titolo, String autore, int annoPubblicazione, int copieDisponibili) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.copieDisponibili = copieDisponibili;
    }

    /**
     * @return  *  @brief Restituisce l'ISBN del libro */
    public String getISBN() { return ISBN; }

    /**
     * @param ISBN *  @brief Imposta l'ISBN del libro */
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    /**
     * @return  *  @brief Restituisce il titolo del libro */
    public String getTitolo() { return titolo; }

    /**
     * @param titolo *  @brief Imposta il titolo del libro */
    public void setTitolo(String titolo) { this.titolo = titolo; }

    /**
     * @return  *  @brief Restituisce l'autore del libro */
    public String getAutore() { return autore; }

    /**
     * @param autore *  @brief Imposta l'autore del libro */
    public void setAutore(String autore) { this.autore = autore; }

    /**
     * @return  *  @brief Restituisce l'anno di pubblicazione */
    public int getAnnoPubblicazione() { return annoPubblicazione; }

    /**
     * @param annoPubblicazione *  @brief Imposta l'anno di pubblicazione */
    public void setAnnoPubblicazione(int annoPubblicazione) { this.annoPubblicazione = annoPubblicazione; }


    /**
     * @return  *  @brief Restituisce il numero di copie disponibili */
    public int getCopieDisponibili() { return copieDisponibili; }

    /**
     * @param copieDisponibili *  @brief Imposta il numero di copie disponibili */
    public void setCopieDisponibili(int copieDisponibili) { this.copieDisponibili = copieDisponibili; }

    /**
     * @brief Controlla se il libro Ã¨ valido
     * @return true se tutti i campi obbligatori sono valorizzati correttamente e ISBN valido, false altrimenti
     */
    public boolean isValid() {
        if (titolo != null && autore != null && annoPubblicazione > 0
            && ISBN != null && copieDisponibili > 0) {
            return ISBN.matches("\\d{13}");
        }
        return false;
    }
}
