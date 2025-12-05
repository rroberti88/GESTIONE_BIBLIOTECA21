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
 * @author Felice Iandoli
 */
public class ElencoPrestiti {

    private List<Prestito> listaPrestiti;

    
    public ElencoPrestiti(List<Prestito> listaPrestiti) {
        this.listaPrestiti = new ArrayList<>();
    }

    //  Registra un prestito
    public void registraPrestito(Prestito prestito) {
        listaPrestiti.add(prestito);
    }

    //  Registra una restituzione
    public void registraRestituzione(Prestito prestito) {
        listaPrestiti.remove(prestito);
    }

    
    public List<Prestito> getPrestiti() {
        return listaPrestiti;
    }
}