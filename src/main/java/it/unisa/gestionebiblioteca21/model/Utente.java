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

    /**
     * @return  *  @brief Restituisce la matricola dell'utente */
    public String getMatricola() { return matricola; }

    /**
     * @param matricola *  @brief Imposta la matricola dell'utente */
    public void setMatricola(String matricola) { this.matricola = matricola; }

    /**
     * @return  *  @brief Restituisce il nome dell'utente */
    public String getNome() { return nome; }

    /**
     * @param nome *  @brief Imposta il nome dell'utente */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * @return  *  @brief Restituisce il cognome dell'utente */
    public String getCognome() { return cognome; }

    /**
     * @param cognome *  @brief Imposta il cognome dell'utente */
    public void setCognome(String cognome) { this.cognome = cognome; }

    /**
     * @return  *  @brief Restituisce l'email dell'utente */
    public String getEmail() { return email; }

    /**
     * @param email *  @brief Imposta l'email dell'utente */
    public void setEmail(String email) { this.email = email; }

    /**
     * @return  *  @brief Restituisce il numero di prestiti attivi dell'utente */
    public int getNumeroPrestiti() { return numeroPrestiti; }

    /**
     * @param numeroPrestiti *  @brief Imposta il numero di prestiti attivi dell'utente */
    public void setNumeroPrestiti(int numeroPrestiti) { this.numeroPrestiti = numeroPrestiti; }

    /**
     * @brief Verifica se l'utente ha dati validi
     * @return true se la matricola Ã¨ valida (10 cifre), la mail ha il giusto formato e tutti i campi principali non sono null
     */
    public boolean isValid() {
        return nome != null
        && cognome != null
        && email != null
        && matricola != null
        && matricola.matches("\\d{10}")
        && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}