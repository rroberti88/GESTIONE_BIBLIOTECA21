/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.Utente;
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
public class GestioneUtentiController {
private Utente modelUt;
private Stage stage; 

public GestioneUtentiController () {
}
public void setModelUt (Utente modelUt){
this.modelUt = modelUt;
}

public void setStage(Stage stage) {
this.stage = stage;
}


}