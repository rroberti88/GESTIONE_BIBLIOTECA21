/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.actor;

/**
 *
 * @author Felice Iandoli
 */
public class Bibliotecario {
    private String nome;
    private String cognome;
    private String username;
    private String password;


    
public Bibliotecario (String nome, String cognome, String username,String password){
this.nome = nome;
this.cognome = cognome;
this.username = username;
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

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
 
}
