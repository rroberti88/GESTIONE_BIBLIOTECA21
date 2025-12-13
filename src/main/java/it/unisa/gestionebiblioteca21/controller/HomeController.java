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

/**
 * Controller della schermata principale (Home) della dashboard del bibliotecario.
 * Permette di accedere alle sezioni Gestione Libri, Gestione Utenti e Gestione Prestiti,
 * oltre a gestire il logout.
 */
public class HomeController {

    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private ElencoPrestiti elencoPrestiti;
    private Autenticazione autenticazione;
    private ArchivioDati archivio;
    private Stage stage;

    /** Imposta il catalogo dei libri */
    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }

    /** Imposta l'elenco degli utenti */
    public void setElencoUtenti(ElencoUtenti e) { this.elencoUtenti = e; }

    /** Imposta la lista dei prestiti */
    public void setListaPrestiti(ElencoPrestiti p) { this.elencoPrestiti = p; }

    /** Imposta il modello di autenticazione */
    public void setModelAut(Autenticazione a) { this.autenticazione = a; }

    /** Imposta l'archivio dati */
    public void setArchivio(ArchivioDati ar) { this.archivio = ar; }

    /** Imposta lo stage della finestra */
    public void setStage(Stage stage) { this.stage = stage; }

    /**
     * Gestisce la navigazione verso la schermata di gestione del catalogo libri.
     */
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

    /**
     * Gestisce la navigazione verso la schermata di gestione utenti.
     */
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

    /**
     * Gestisce la navigazione verso la schermata di gestione prestiti.
     */
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

    /**
     * Gestisce il logout e ritorna alla schermata di login.
     */
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





