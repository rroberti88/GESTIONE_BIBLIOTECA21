/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
public class HomeController {

    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private ElencoPrestiti elencoPrestiti;
    private Autenticazione autenticazione;
    private ArchivioDati archivio;

    private Stage stage;

    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }

    public void setElencoUtenti(ElencoUtenti e) { this.elencoUtenti = e; }

    public void setListaPrestiti(ElencoPrestiti p) { this.elencoPrestiti = p; }

    public void setModelAut(Autenticazione a) { this.autenticazione = a; }

    public void setArchivio(ArchivioDati ar) { this.archivio = ar; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleGestioneLibri() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/it/unisa/gestionebiblioteca21/view/GestioneCatalogoView.fxml"));
            Parent root = loader.load();

            GestioneCatalogoController ctrl = loader.getController();
            ctrl.setStage(stage);
            ctrl.setArchivio(archivio);
            ctrl.setCatalogo(catalogo);
            ctrl.setModelAut(autenticazione);
            ctrl.setElencoUtenti(elencoUtenti);
            ctrl.setListaPrestiti(elencoPrestiti);

            stage.setScene(new Scene(root));
            stage.setTitle("Gestione Catalogo Libri");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGestioneUtenti() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/it/unisa/gestionebiblioteca21/view/GestioneUtentiView.fxml"));
            Parent root = loader.load();

            GestioneUtentiController ctrl = loader.getController();

            ctrl.setStage(stage);
            ctrl.setArchivio(archivio);
            ctrl.setModelAut(autenticazione);
            ctrl.setElencoUtenti(elencoUtenti);
            ctrl.setCatalogo(catalogo);
            ctrl.setListaPrestiti(elencoPrestiti);

            stage.setScene(new Scene(root));
            stage.setTitle("Gestione Utenti");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGestionePrestiti() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/it/unisa/gestionebiblioteca21/view/GestionePrestitiView.fxml"));
            Parent root = loader.load();

            GestionePrestitiController ctrl = loader.getController();

            ctrl.setStage(stage);
            ctrl.setArchivio(archivio);
            ctrl.setModelAut(autenticazione);
            ctrl.setCatalogo(catalogo);
            ctrl.setListaPrestiti(elencoPrestiti);
            ctrl.setElencoUtenti(elencoUtenti);

            stage.setScene(new Scene(root));
            stage.setTitle("Gestione Prestiti");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleLogout() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
            Parent root = loader.load();

            LoginController login = loader.getController();

            login.setStage(stage);
            login.setModelAut(autenticazione);
            login.setArchivio(archivio);
            login.setCatalogo(catalogo);
            login.setElencoUtenti(elencoUtenti);
            login.setElencoPrestiti(elencoPrestiti);

            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





