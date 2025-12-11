/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import java.util.ArrayList;
/**
 *
 * @author Felice Iandoli
 */
public class ElencoPrestiti {

    private final ArrayList<Prestito> listaPrestiti;

     public ElencoPrestiti() {
        this.listaPrestiti = new ArrayList<>();
    }

    public ElencoPrestiti(ArrayList<Prestito> listaPrestiti) {
        this.listaPrestiti = listaPrestiti != null ? listaPrestiti : new ArrayList<>();
    }

    public void registraPrestito(Prestito prestito, Libro libro) {
    long prestitiUtente = listaPrestiti.stream().filter(p -> p.getUtente().equalsIgnoreCase(prestito.getUtente()) && p.isLent()).count();
        if (prestitiUtente >= 3) {
            throw new IllegalStateException("L'utente ha già 3 prestiti attivi.");
        }

        // Controllo disponibilità del libro
        if (libro.getCopieDisponibili() <= 0) {
            throw new IllegalStateException("Nessuna copia disponibile per questo libro.");
        }

        listaPrestiti.add(prestito);

        libro.setCopieDisponibili(libro.getCopieDisponibili() - 1);
    }

    public boolean registraRestituzione(String libro, String utente) {
    for (Prestito p : listaPrestiti) {
        if (p.getLibro().equalsIgnoreCase(libro) && p.getUtente().equalsIgnoreCase(utente) && p.isLent()) {
            listaPrestiti.remove(p);
            return true;
        }
    }
    return false;
    }

    
    public ArrayList<Prestito> getListaPrestiti() {
        return listaPrestiti;
    }
    
     public ArrayList<Prestito> ricercaPrestito(String libro, String utente) {
        ArrayList<Prestito> listaRisultatiPrestiti = new ArrayList<>();
        for (Prestito p : listaPrestiti)
    {
        boolean libroUguale = (libro == null || libro.isEmpty()) || p.getLibro().toLowerCase().contains(libro.toLowerCase());

        boolean utenteUguale = (utente == null || utente.isEmpty()) || p.getUtente().toLowerCase().contains(utente.toLowerCase());

       
        
        if (libroUguale || utenteUguale)
        {
            listaRisultatiPrestiti.add(p);
        }
    }
        return listaRisultatiPrestiti;
    }
}