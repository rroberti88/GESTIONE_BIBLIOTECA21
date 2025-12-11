/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;

public class GestioneUtentiController {

    private ElencoUtenti elencoUtenti;
    private CatalogoLibri catalogo;
    private ElencoPrestiti elencoPrestiti;
    private Autenticazione autenticazione;
    private ArchivioDati archivio;
    private Stage stage;

    @FXML private TextField txtRicercaUtente;
    @FXML private TableView<Utente> tableview2;
    @FXML private TableColumn<Utente, String> colNome;
    @FXML private TableColumn<Utente, String> colCognome;
    @FXML private TableColumn<Utente, String> colMatricola;
    @FXML private TableColumn<Utente, String> colContatti;  

    public void setElencoUtenti(ElencoUtenti elenco) {
        this.elencoUtenti = elenco;
        aggiorna();
    }

    public void setCatalogo(CatalogoLibri c) {
        this.catalogo = c;
    }

    public void setListaPrestiti(ElencoPrestiti p) {
        this.elencoPrestiti = p;
    }

    public void setArchivio(ArchivioDati archivio) {
        this.archivio = archivio;
    }

    public void setModelAut(Autenticazione modelAut) {
        this.autenticazione = modelAut;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
        colContatti.setCellValueFactory(new PropertyValueFactory<>("email")); 

        txtRicercaUtente.textProperty().addListener((obs, o, n) -> handleRicercaUtente());
    }

    private void aggiorna() {
        if (elencoUtenti != null) {
            tableview2.getItems().setAll(elencoUtenti.getListaUtenti());
        }
    }

    @FXML
    public void handleInserimentoUtente() {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/it/unisa/gestionebiblioteca21/view/InserimentoUtenteView.fxml"));
            Parent root = loader.load();

            InserimentoUtenteController controller = loader.getController();
            controller.setModel(elencoUtenti);
            controller.setArchivio(archivio);

            Stage popup = new Stage();
            controller.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Inserimento Utente");
            popup.initOwner(stage);
            popup.showAndWait();

            if (archivio != null) {
                archivio.salvaUtenti(elencoUtenti.getListaUtenti());
            }
            aggiorna();

        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void handleModificaUtente() {
        try {
            Utente sel = tableview2.getSelectionModel().getSelectedItem();

            if (sel == null) {
                new Alert(Alert.AlertType.WARNING,
                    "Seleziona un utente da modificare.").show();
                return;
            }

            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/it/unisa/gestionebiblioteca21/view/ModificaUtenteView.fxml"));
            Parent root = loader.load();

            ModificaUtenteController controller = loader.getController();
            controller.setModel(elencoUtenti);
            controller.setArchivio(archivio);
            controller.setUtente(sel);

            Stage popup = new Stage();
            controller.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Modifica Utente");
            popup.initOwner(stage);
            popup.showAndWait();

            if (archivio != null) {
                archivio.salvaUtenti(elencoUtenti.getListaUtenti());
            }
            aggiorna();

        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void handleCancellazioneUtente() {
        try {
            Utente sel = tableview2.getSelectionModel().getSelectedItem();

            if (sel == null) {
                new Alert(Alert.AlertType.WARNING,
                    "Seleziona un utente da eliminare.").show();
                return;
            }

            Alert conf = new Alert(Alert.AlertType.CONFIRMATION,
                "Confermi eliminazione utente?");
            conf.showAndWait().ifPresent(r -> {
                if (r == ButtonType.OK) {
                    elencoUtenti.cancellazioneUtente(sel);
                    if (archivio != null) {
                        archivio.salvaUtenti(elencoUtenti.getListaUtenti());
                    }
                    aggiorna();
                }
            });

        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void handleRicercaUtente() {
        String ricerca = txtRicercaUtente.getText();

        if (ricerca == null || ricerca.isEmpty()) {
            aggiorna();
            return;
        }

        ArrayList<Utente> risultati =
            elencoUtenti.ricercaUtente(ricerca, ricerca, ricerca);

        tableview2.getItems().setAll(risultati);
    }

    @FXML
    public void handleBackDashboard() {
        try {

            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
            Parent root = loader.load();

            HomeController home = loader.getController();
            home.setModelAut(autenticazione);
            home.setArchivio(archivio);
            home.setCatalogo(catalogo);
            home.setElencoUtenti(elencoUtenti);
            home.setListaPrestiti(elencoPrestiti);
            home.setStage(stage);

            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard Bibliotecario");
            stage.show();

        } catch (Exception e) { e.printStackTrace(); }
    }
}







