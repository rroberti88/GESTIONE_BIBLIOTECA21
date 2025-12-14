/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

import java.time.LocalDate;

/**
 * @class Prestito
 * @brief Rappresenta un prestito di un libro effettuato da un utente.
 */
public class Prestito {
    private String libro; /**< ISBN del libro prestato */
    private String utente; /**< Matricola dell'utente */
    private LocalDate dataPrestito; /**< Data in cui il prestito è stato effettuato */
    private LocalDate dataScadenza; /**< Data di scadenza del prestito */
    private LocalDate dataRestituzione; /**< Data di restituzione del libro, null se non restituito */

    /**
     * @brief Costruttore della classe Prestito.
     * @param libro ISBN del libro
     * @param utente Matricola dell'utente
     * @param dataPrestito Data del prestito
     * @param dataScadenza Data di scadenza del prestito
     * @param dataRestituzione Data di restituzione (null se non ancora restituito)
     */
    public Prestito(String libro, String utente, LocalDate dataPrestito, LocalDate dataScadenza, LocalDate dataRestituzione){
        this.libro = libro;
        this.utente = utente;
        this.dataPrestito = dataPrestito;
        this.dataScadenza = dataScadenza;
        this.dataRestituzione = dataRestituzione;
    }

    /**
     * @return  *  @brief Restituisce l'ISBN del libro */
    public String getLibro() { return libro; }

    /**
     * @param libro *  @brief Imposta l'ISBN del libro */
    public void setLibro(String libro) { this.libro = libro; }

    /**
     * @return  *  @brief Restituisce la matricola dell'utente */
    public String getUtente() { return utente; }

    /**
     * @param utente *  @brief Imposta la matricola dell'utente */
    public void setUtente(String utente) { this.utente = utente; }

    /**
     * @return  *  @brief Restituisce la data del prestito */
    public LocalDate getDataPrestito() { return dataPrestito; }

    /**
     * @param dataPrestito *  @brief Imposta la data del prestito */
    public void setDataPrestito(LocalDate dataPrestito) { this.dataPrestito = dataPrestito; }

    /**
     * @return  *  @brief Restituisce la data di scadenza del prestito */
    public LocalDate getDataScadenza() { return dataScadenza; }

    /**
     * @param dataScadenza *  @brief Imposta la data di scadenza del prestito */
    public void setDataScadenza(LocalDate dataScadenza) { this.dataScadenza = dataScadenza; }

    /**
     * @return  *  @brief Restituisce la data di restituzione */
    public LocalDate getDataRestituzione() { return dataRestituzione; }

    /**
     * @param dataRestituzione *  @brief Imposta la data di restituzione */
    public void setDataRestituzione(LocalDate dataRestituzione) { this.dataRestituzione = dataRestituzione; }

    /**
     * @brief Controlla se il prestito è scaduto.
     * @return true se il libro non è stato restituito e la data attuale è successiva alla scadenza
     */
    public boolean isOverdue() {
        return dataRestituzione == null && LocalDate.now().isAfter(dataScadenza);
    }

    /**
     * @brief Controlla se il libro è attualmente in prestito.
     * @return true se il libro non è stato ancora restituito
     */
    public boolean isLent() {
        return dataRestituzione == null;
    }
}