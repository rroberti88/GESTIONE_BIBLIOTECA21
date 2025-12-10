/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import it.unisa.gestionebiblioteca21.database.Archivio;
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

    public void registraPrestito(Prestito prestito) {
        listaPrestiti.add(prestito);
    Archivio.salvaPrestiti(this);
    }

    public void registraRestituzione(Prestito prestito) {
        listaPrestiti.remove(prestito);
    Archivio.salvaPrestiti(this);
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