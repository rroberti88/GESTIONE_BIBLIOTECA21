/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;

/**
 *
 * @author Felice Iandoli
 */
public class Utente {
    
    private String matricola;
    private String nome;
    private String cognome;
    private String email;
    private int numeroPrestiti;
    
    public Utente() {
    }


    public Utente(String matricola, String nome, String cognome, String email, int numeroPrestiti) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroPrestiti=numeroPrestiti;
    }

    
    
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    public void setNumeroPrestiti(int numeroPrestiti) {
        this.numeroPrestiti = numeroPrestiti;
    }
    
    public boolean isValid(){
        if ((nome != null ) && (cognome != null ) && (email != null ) && (matricola != null )){
        return matricola.matches("\\d{10}");
    }   
    return false;
    }
    
}