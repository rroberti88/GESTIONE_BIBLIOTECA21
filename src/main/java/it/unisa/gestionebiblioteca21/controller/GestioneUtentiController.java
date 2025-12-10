/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;
import it.unisa.gestionebiblioteca21.model.Autenticazione;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Felice Iandoli
*/
public class GestioneUtentiController {

    private ElencoUtenti elencoUtenti;
    private Autenticazione modelAut;
    private Stage stage;

    @FXML private TextField txtRicercaUtente;
    @FXML private TableView<Utente> tableview2;
    @FXML private TableColumn<Utente, String> colNome;
    @FXML private TableColumn<Utente, String> colCognome;
    @FXML private TableColumn<Utente, String> colMatricola;
    @FXML private TableColumn<Utente, String> colContatti;

    @FXML private Button btnInserimentoNuovoUtente;
    @FXML private Button btnModificaUtente;
    @FXML private Button btnCancellazioneUtente;
    @FXML private Button btnDashboard;

    public GestioneUtentiController() {}

    public void setElencoUtenti(ElencoUtenti elenco) {
        this.elencoUtenti = elenco;
        aggiornaTableView();
    }

    public void setModelAut(Autenticazione modelAut) {
        this.modelAut = modelAut;
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

        txtRicercaUtente.textProperty().addListener((obs, oldVal, newVal) -> {
            handleRicercaUtente();
        });
    }

    private void aggiornaTableView() {
        if (elencoUtenti != null) {
            tableview2.getItems().setAll(elencoUtenti.getListaUtenti());
        }
    }

    @FXML
    public void handleInserimentoUtente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/InserimentoUtenteView.fxml"));
            Parent root = loader.load();

            InserimentoUtenteController controller = loader.getController();
            controller.setModel(elencoUtenti);

            Stage popup = new Stage();
            controller.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Inserimento Nuovo Utente");
            popup.initOwner(stage);
            popup.showAndWait();

            aggiornaTableView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleModificaUtente() {
        try {
            Utente selezionato = tableview2.getSelectionModel().getSelectedItem();

            if (selezionato == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attenzione");
                alert.setHeaderText("Nessun utente selezionato");
                alert.setContentText("Seleziona un utente dalla lista per modificarlo.");
                alert.showAndWait();
                return;
            }

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/ModificaUtenteView.fxml")
            );
            Parent root = loader.load();

            ModificaUtenteController controller = loader.getController();

            Stage popup = new Stage();
            controller.setStage(popup);
            controller.setModel(elencoUtenti);
            controller.setUtente(selezionato);

            popup.setScene(new Scene(root));
            popup.setTitle("Modifica Utente");
            popup.initOwner(stage);
            popup.showAndWait();

            aggiornaTableView();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Impossibile modificare l'utente");
            alert.setContentText("Si è verificato un errore inatteso.");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleCancellazioneUtente() {
        try {
            Utente selezionato = tableview2.getSelectionModel().getSelectedItem();

            if (selezionato == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attenzione");
                alert.setHeaderText("Nessun utente selezionato");
                alert.setContentText("Seleziona un utente dalla tabella per eliminarlo.");
                alert.showAndWait();
                return;
            }

            Alert conferma = new Alert(Alert.AlertType.CONFIRMATION);
            conferma.setTitle("Conferma eliminazione");
            conferma.setHeaderText("Eliminare l'utente selezionato?");
            conferma.setContentText("Questa operazione non può essere annullata.");
            conferma.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    elencoUtenti.cancellazioneUtente(selezionato);
                    aggiornaTableView();

                    Alert ok = new Alert(Alert.AlertType.INFORMATION);
                    ok.setTitle("Eliminazione completata");
                    ok.setHeaderText(null);
                    ok.setContentText("Utente eliminato correttamente.");
                    ok.showAndWait();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Alert errore = new Alert(Alert.AlertType.ERROR);
            errore.setTitle("Errore");
            errore.setHeaderText("Errore durante l'eliminazione");
            errore.setContentText("Si è verificato un errore imprevisto.");
            errore.showAndWait();
        }
    }

    @FXML
    public void handleRicercaUtente() {
        String ricerca = txtRicercaUtente.getText();

        if (ricerca == null || ricerca.isEmpty()) {
            aggiornaTableView();
            return;
        }

        ArrayList<Utente> risultati = elencoUtenti.ricercaUtente(ricerca, ricerca, ricerca);
        tableview2.getItems().setAll(risultati);
    }

    @FXML
    public void handleBackDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
            Parent root = loader.load();

            HomeController homeController = loader.getController();
            homeController.setModelAut(modelAut);
            homeController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Dashboard Bibliotecario");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




