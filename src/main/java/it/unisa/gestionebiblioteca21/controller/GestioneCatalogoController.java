/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Felice Iandoli
 */
public class GestioneCatalogoController {
private Libro modelLib;
private Stage stage; 

public GestioneCatalogoController () {}

public void setModelLib (Libro modelLib){
this.modelLib = modelLib;
}

public void setStage(Stage stage) {
this.stage = stage;
}

}
