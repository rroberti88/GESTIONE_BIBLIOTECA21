/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.*;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * Controller per la gestione del login del bibliotecario.
 * Controlla le credenziali e, se valide, apre la dashboard principale.
 */
public class LoginController {

    private Autenticazione autenticazione;
    private Stage stage;

    private ArchivioDati archivio;
    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private ElencoPrestiti elencoPrestiti;

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnAccedi;

    /**
     * Imposta il modello di autenticazione.
     * @param aut Autenticazione
     */
    public void setModelAut(Autenticazione aut) { this.autenticazione = aut; }

    /**
     * Imposta lo stage principale.
     * @param stage Stage
     */
    public void setStage(Stage stage) { this.stage = stage; }

    /**
     * Imposta l'archivio dati per la gestione dei dati persistenti.
     * @param archivio ArchivioDati
     */
    public void setArchivio(ArchivioDati archivio) { this.archivio = archivio; }

    /**
     * Imposta il catalogo dei libri.
     * @param catalogo CatalogoLibri
     */
    public void setCatalogo(CatalogoLibri catalogo) { this.catalogo = catalogo; }

    /**
     * Imposta l'elenco degli utenti.
     * @param elenco ElencoUtenti
     */
    public void setElencoUtenti(ElencoUtenti elenco) { this.elencoUtenti = elenco; }

    /**
     * Imposta l'elenco dei prestiti.
     * @param elenco ElencoPrestiti
     */
    public void setElencoPrestiti(ElencoPrestiti elenco) { this.elencoPrestiti = elenco; }

    /**
     * Gestisce il login del bibliotecario.
     * Controlla le credenziali e, se corrette, apre la schermata principale.
     */
    @FXML
    private void handleLogin() {

        String user = txtUsername.getText();
        String pass = txtPassword.getText();

        if (!autenticazione.login(user, pass)) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Credenziali errate.");
            a.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
            Parent root = loader.load();

            HomeController home = loader.getController();
            home.setStage(stage);
            home.setModelAut(autenticazione);
            home.setArchivio(archivio);
            home.setCatalogo(catalogo);
            home.setElencoUtenti(elencoUtenti);
            home.setListaPrestiti(elencoPrestiti);

            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard Bibliotecario");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



