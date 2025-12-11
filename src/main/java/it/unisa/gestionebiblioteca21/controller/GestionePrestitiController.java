/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.*;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionePrestitiController {

    private ElencoPrestiti elencoPrestiti;
    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private Autenticazione autenticazione;
    private ArchivioDati archivio;
    private Stage stage;

    @FXML private TextField txtRicercaPrestito;

    @FXML private TableView<Prestito> tableview;
    @FXML private TableColumn<Prestito, String> colLibro;
    @FXML private TableColumn<Prestito, String> colUtente;
    @FXML private TableColumn<Prestito, LocalDate> colDataPrestito;
    @FXML private TableColumn<Prestito, LocalDate> colDataScadenza;

    public void setListaPrestiti(ElencoPrestiti e) {
        this.elencoPrestiti = e;
        aggiorna();
    }

    public void setCatalogo(CatalogoLibri c) {
        this.catalogo = c;
    }

    public void setElencoUtenti(ElencoUtenti u) {
        this.elencoUtenti = u;
    }

    public void setArchivio(ArchivioDati a) {
        this.archivio = a;
    }

    public void setModelAut(Autenticazione aut) {
        this.autenticazione = aut;
    }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    public void initialize() {

        colLibro.setCellValueFactory(new PropertyValueFactory<>("libro"));
        colUtente.setCellValueFactory(new PropertyValueFactory<>("utente"));
        colDataPrestito.setCellValueFactory(new PropertyValueFactory<>("dataPrestito"));
        colDataScadenza.setCellValueFactory(new PropertyValueFactory<>("dataScadenza"));

        txtRicercaPrestito.textProperty().addListener((obs, old, newVal) -> handleRicercaPrestito());
    }

    private void aggiorna() {
        if (elencoPrestiti != null)
            tableview.getItems().setAll(elencoPrestiti.getListaPrestiti());
    }

    @FXML
    public void handleRegistraPrestito() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/RegistraPrestitoView.fxml"));
            Parent root = loader.load();

            RegistraPrestitoController ctrl = loader.getController();
            ctrl.setListaPrestiti(elencoPrestiti);
            ctrl.setCatalogo(catalogo);
            ctrl.setElencoUtenti(elencoUtenti);
            ctrl.setArchivio(archivio);

            Stage popup = new Stage();
            ctrl.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Registrazione Prestito");
            popup.initOwner(stage);
            popup.showAndWait();

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
            aggiorna();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleRegistraRestituzione() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/RegistraRestituzioneView.fxml"));
            Parent root = loader.load();

            RegistraRestituzioneController ctrl = loader.getController();
            ctrl.setListaPrestiti(elencoPrestiti);
            ctrl.setArchivio(archivio);

            Stage popup = new Stage();
            ctrl.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Registrazione Restituzione");
            popup.initOwner(stage);
            popup.showAndWait();

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
            aggiorna();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleRicercaPrestito() {

        if (elencoPrestiti == null) return;

        String key = txtRicercaPrestito.getText();

        if (key == null || key.isEmpty()) {
            aggiorna();
            return;
        }

        ArrayList<Prestito> risultati =
                elencoPrestiti.ricercaPrestito(key, key);

        tableview.getItems().setAll(risultati);
    }

    @FXML
    public void handleBackDashboard() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
            Parent root = loader.load();

            HomeController home = loader.getController();

            home.setStage(stage);
            home.setArchivio(archivio);
            home.setModelAut(autenticazione);

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




