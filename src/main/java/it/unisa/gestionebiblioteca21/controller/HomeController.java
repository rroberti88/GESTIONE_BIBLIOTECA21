package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.Autenticazione;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Roberto Roberti
 */
public class HomeController {

    private Autenticazione model;
    private Stage stage;
    private String username; 

    @FXML
    private Button btnGestioneLibri;
    @FXML
    private Button btnGestioneUtenti;
    @FXML
    private Button btnGestionePrestiti;
    @FXML
    private Button btnLogout;

    public HomeController() {}

    public void setModel(Autenticazione model) {
        this.model = model;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void mostraDashboard(String username) {
        this.username = username;
        stage.show(); 
        System.out.println("Benvenuto, " + username + "! Dashboard caricata.");
    }

    @FXML
    private void handleGestioneLibri() {
        System.out.println("Aperta gestione libri");
    }

    @FXML
    private void handleGestioneUtenti() {
        System.out.println("Aperta gestione utenti ");
    }

    @FXML
    private void handleGestionePrestiti() {
        System.out.println("Aperta gestione prestiti ");
    }

    @FXML
    private void handleLogout() {
    if (model.logout(username))
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
                Parent root = loader.load();

                LoginController loginController = loader.getController();
                loginController.setModel(model);
                loginController.setStage(stage);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
    } catch (Exception f){
    }

    }
}
