/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import java.util.ArrayList;
/**
 *
 * @author Roberto Roberti
 */
public class CatalogoLibri {
    private ArrayList<Libro> listaLibri;

    public CatalogoLibri() {
        this.listaLibri = new ArrayList<>();
    }
     public CatalogoLibri(ArrayList<Libro> listaLibri) {
        this.listaLibri = listaLibri != null ? listaLibri : new ArrayList<>();
    }

    public ArrayList<Libro> getListaLibri() {
        return listaLibri;
    }

    public void inserimentoLibro (Libro libro) {
    listaLibri.add(libro);
    }

    public void cancellazioneLibro (Libro libro) {
    listaLibri.remove(libro);
    }

    public void modificaLibro (Libro libro) {
    for (int i=0; i< listaLibri.size(); i++)
    {
      Libro L = listaLibri.get(i);
      if (L.getISBN().equals(libro.getISBN()))
    {
       L.setTitolo(libro.getTitolo());
       L.setAutore(libro.getAutore());
       L.setAnnoPubblicazione(libro.getAnnoPubblicazione());
       L.setCategoria(libro.getCategoria());
       return;
    }
    }
    }

    public ArrayList<Libro> ricercaLibro(String titolo, String autore, String ISBN) {
        ArrayList<Libro> listarisultati = new ArrayList<>();
        for (Libro l : listaLibri)
    {
        boolean Titolouguale = (titolo == null || titolo.isEmpty()) || l.getTitolo().toLowerCase().contains(titolo.toLowerCase());

        boolean Autoreuguale = (autore == null || autore.isEmpty()) || l.getAutore().toLowerCase().contains(autore.toLowerCase());

        boolean ISBNuguale = (ISBN == null || ISBN.isEmpty()) || l.getISBN().equalsIgnoreCase(ISBN);
        
        if (Titolouguale || Autoreuguale || ISBNuguale)
        {
            listarisultati.add(l);
        }
    }
        return listarisultati;
    }
}
