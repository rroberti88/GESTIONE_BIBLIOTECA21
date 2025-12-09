/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
/**
 *
 * @author Felice Iandoli
 */

public class LoginController {

private Autenticazione modelAut;
private Stage stage;

@FXML
private TextField txtUsername;

@FXML
private PasswordField txtPassword;

public LoginController () {}

public void setModelAut (Autenticazione modelAut){
this.modelAut = modelAut;
}

public void setStage(Stage stage) {
this.stage = stage;
}

@FXML
private void handleLogin() {
String username = txtUsername.getText();
String password = txtPassword.getText();
if (modelAut.login(username, password)){
    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
                Parent root = loader.load();

                HomeController homeController = loader.getController();
                homeController.setModelAut(modelAut);
                homeController.setStage(stage);
                homeController.setUsername(username);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Dashboard Bibliotecario");
                stage.show();

            } catch (Exception e) {

}        
        }
    else {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Errore credenziali");
    alert.setHeaderText("Credenziali errate");
    alert.setContentText("Username o password non validi");
    alert.showAndWait();
}
}
}
