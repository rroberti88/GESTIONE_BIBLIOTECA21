package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.Autenticazione;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.Utente;
import it.unisa.gestionebiblioteca21.model.Prestito;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/**
 * Roberto Roberti
 */
public class HomeController {

    private CatalogoLibri catalogo = new CatalogoLibri();
    private Utente modelUt;
    private ElencoPrestiti listaPrestiti;
    private Autenticazione modelAut;
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

    public void setCatalogo(CatalogoLibri catalogo) {
        this.catalogo = catalogo;
    }

    public void setModelUt(Utente modelUt) {
        this.modelUt = modelUt;
    }

    public void setListaPrestiti(Prestito modelPres) {
        this.listaPrestiti = listaPrestiti;
    }

    public void setModelAut(Autenticazione modelAut) {
        this.modelAut = modelAut;
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/GestioneCatalogoView.fxml"));
            Parent root = loader.load();

            GestioneCatalogoController gestioneCatalogoController = loader.getController();
            gestioneCatalogoController.setModelAut(modelAut);
            gestioneCatalogoController.setCatalogo(catalogo);
            gestioneCatalogoController.setStage(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gestione Libri");
            stage.show();

        } catch (Exception f){
        }
    }


    @FXML
    private void handleGestioneUtenti() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/GestioneUtentiView.fxml"));
            Parent root = loader.load();

            GestioneUtentiController gestioneUtentiController = loader.getController();
            gestioneUtentiController.setModelAut(modelAut);

            ElencoUtenti elenco = new ElencoUtenti(new ArrayList<>());
            if (modelUt != null) {
                elenco.inserimentoUtente(modelUt);
            }

            gestioneUtentiController.setElencoUtenti(elenco);
            gestioneUtentiController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gestione Utenti");
            stage.show();

        } catch (Exception f){
        }
    }

    @FXML
    private void handleGestionePrestiti() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/GestionePrestitiView.fxml"));
            Parent root = loader.load();

            GestionePrestitiController gestionePrestitiController = loader.getController();
            gestionePrestitiController.setModelAut(modelAut);
            gestionePrestitiController.setListaPrestiti(listaPrestiti);
            gestionePrestitiController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gestione Prestiti");
            stage.show();

        } catch (Exception f){
        }
    }

    @FXML
    private void handleLogout() {
        if (modelAut.logout(username)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
                Parent root = loader.load();

                LoginController loginController = loader.getController();
                loginController.setModelAut(modelAut);
                loginController.setStage(stage);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();

            } catch (Exception f){
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore ");
            alert.setHeaderText("Impossibile caricare la schermata di Login");
            alert.setContentText("Logout non riuscito");
            alert.showAndWait();
        }
    }
}

