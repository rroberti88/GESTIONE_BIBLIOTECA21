/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Roberto Roberti
 */
public class CatalogoLibri {
    private ArrayList<Libro> listaLibri;

    public CatalogoLibri(ArrayList<Libro> listaLibri) {
        this.listaLibri = listaLibri;
    }

    public ArrayList<Libro> getListaLibri() {
        return listaLibri;
    }
    public void inserimentoLibro (Libro libro) {

    }
    public void cancellazioneLibro (Libro libro) {

    }
    public void modificaLibro (Libro libro) {

    }
    public ArrayList<Libro> ricercaLibro(String titolo, String autore, String ISBN) {
        return new ArrayList<Libro>();
    }
}
