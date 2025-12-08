/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import it.unisa.gestionebiblioteca21.view.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
/**
 *
 * @author Felice Iandoli
 */

public class LoginController {

private Autenticazione model;
private Stage stage;

@FXML
private TextField txtUsername;

@FXML
private PasswordField txtPassword;

public LoginController () {}

public void setModel (Autenticazione model){
this.model = model;
}

public void setStage(Stage stage) {
this.stage = stage;
}

@FXML
private void handleLogin() {
    String username = txtUsername.getText();
    String password = txtPassword.getText();
     if (model.login(username, password) == true )
{
    HomeView homeView = new HomeView (stage, username);
    homeView.mostraDashboard();
}
    else {
    System.out.println("Credenziali non valide");
}
}
}
