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
public class Libro {
    private String ISBN;
    private String titolo;
    private String autore;
    private int annoPublicazione;
    private String Categoria;
    private int copieTotali;
    private int copieDisponibili;

    public Libro(String ISBN, String titolo, String autore, int annoPublicazione, String Categoria, int copieTotali, int copieDisponibili) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPublicazione = annoPublicazione;
        this.Categoria = Categoria;
        this.copieTotali = copieTotali;
        this.copieDisponibili = copieDisponibili;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getCopieTotali() {
        return copieTotali;
    }

    public void setCopieTotali(int copieTotali) {
        this.copieTotali = copieTotali;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public void setCopieDisponibili(int copieDisponibili) {
        this.copieDisponibili = copieDisponibili;
    }

   
    
    public boolean isValid(){
        return true;
    }
    
}
