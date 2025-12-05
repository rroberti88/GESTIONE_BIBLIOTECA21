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
    private List<Libro> listaLibri;

    public CatalogoLibri(List<Libro> listaLibri) {
        this.listaLibri = listaLibri;
    }

    public List<Libro> getListaLibri() {
        return listaLibri;
    }
    public void inserimentoLibro (Libro libro) {

    }
    public void cancellazioneLibro (Libro libro) {

    }
    public void modificaLibro (Libro libro) {

    }
    public List<Libro> ricercaLibro(String chiaveRicerca) {
        return new ArrayList<Libro>();
    }
}
