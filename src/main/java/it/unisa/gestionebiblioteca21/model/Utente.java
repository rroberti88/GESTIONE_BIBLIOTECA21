/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

/**
 * @class Utente
 * @brief Rappresenta un utente registrato nella biblioteca.
 */
public class Utente {

    private String matricola; /**< Matricola dell'utente (10 cifre) */
    private String nome; /**< Nome dell'utente */
    private String cognome; /**< Cognome dell'utente */
    private String email; /**< Email dell'utente */
    private int numeroPrestiti; /**< Numero di prestiti attivi dell'utente */

    /** 
     * @brief Costruttore vuoto
     */
    public Utente() {
    }

    /**
     * @brief Costruttore completo
     * @param matricola Matricola dell'utente
     * @param nome Nome dell'utente
     * @param cognome Cognome dell'utente
     * @param email Email dell'utente
     * @param numeroPrestiti Numero di prestiti attivi
     */
    public Utente(String matricola, String nome, String cognome, String email, int numeroPrestiti) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroPrestiti = numeroPrestiti;
    }

    /** @brief Restituisce la matricola dell'utente */
    public String getMatricola() { return matricola; }

    /** @brief Imposta la matricola dell'utente */
    public void setMatricola(String matricola) { this.matricola = matricola; }

    /** @brief Restituisce il nome dell'utente */
    public String getNome() { return nome; }

    /** @brief Imposta il nome dell'utente */
    public void setNome(String nome) { this.nome = nome; }

    /** @brief Restituisce il cognome dell'utente */
    public String getCognome() { return cognome; }

    /** @brief Imposta il cognome dell'utente */
    public void setCognome(String cognome) { this.cognome = cognome; }

    /** @brief Restituisce l'email dell'utente */
    public String getEmail() { return email; }

    /** @brief Imposta l'email dell'utente */
    public void setEmail(String email) { this.email = email; }

    /** @brief Restituisce il numero di prestiti attivi dell'utente */
    public int getNumeroPrestiti() { return numeroPrestiti; }

    /** @brief Imposta il numero di prestiti attivi dell'utente */
    public void setNumeroPrestiti(int numeroPrestiti) { this.numeroPrestiti = numeroPrestiti; }

    /**
     * @brief Verifica se l'utente ha dati validi
     * @return true se la matricola Ã¨ valida (10 cifre) e tutti i campi principali non sono null
     */
    public boolean isValid() {
        return (nome != null && cognome != null && email != null && matricola != null) 
               && matricola.matches("\\d{10}");
    }
}