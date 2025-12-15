/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.*;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

/**
 * Controller per la gestione degli utenti.
 * Permette di inserire, modificare, cancellare e ricercare utenti
 * all'interno del sistema.
 */
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
    @FXML private TableColumn<Utente, Integer> colNumeroPrestiti;


    /** Imposta l'elenco utenti da gestire
     * @param elenco */
    public void setElencoUtenti(ElencoUtenti elenco) {
        this.elencoUtenti = elenco;
        aggiorna();
    }

    /** Imposta il catalogo dei libri
     * @param c */
    public void setCatalogo(CatalogoLibri c) {
        this.catalogo = c;
    }

    /** Imposta la lista dei prestiti
     * @param p */
    public void setListaPrestiti(ElencoPrestiti p) {
        this.elencoPrestiti = p;
    }

    /** Imposta l'archivio dati
     * @param archivio */
    public void setArchivio(ArchivioDati archivio) {
        this.archivio = archivio;
    }

    /** Imposta il modello di autenticazione
     * @param modelAut */
    public void setModelAut(Autenticazione modelAut) {
        this.autenticazione = modelAut;
    }

    /** Imposta lo stage della finestra
     * @param stage */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /** Inizializza la tabella utenti e la ricerca dinamica */
    @FXML
    public void initialize() {
    colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
    colMatricola.setCellValueFactory(new PropertyValueFactory<>("matricola"));
    colContatti.setCellValueFactory(new PropertyValueFactory<>("email"));
    colNumeroPrestiti.setCellValueFactory(new PropertyValueFactory<>("numeroPrestiti"));

    txtRicercaUtente.textProperty()
            .addListener((obs, o, n) -> handleRicercaUtente());
    }


    /** Aggiorna la tabella con l'elenco completo degli utenti */
    private void aggiorna() {
        if (elencoUtenti != null) {
            tableview2.getItems().setAll(elencoUtenti.getListaUtenti());
        }
    }

    /** Gestisce l'inserimento di un nuovo utente */
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

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Inserimento Utente " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Impossibile aprire la finestra di inserimento utente.").showAndWait();
        }
    }

    /** Gestisce la modifica dell'utente selezionato */
    @FXML
    public void handleModificaUtente() {
        try {
            Utente sel = tableview2.getSelectionModel().getSelectedItem();
            if (sel == null) {
                new Alert(Alert.AlertType.WARNING, "Seleziona un utente da modificare.").show();
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

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Modifica Utente " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Impossibile aprire la finestra di modifica dell'utente.").showAndWait();
        }
    }

    /** Gestisce la cancellazione dell'utente selezionato */
    @FXML
    public void handleCancellazioneUtente() {
        try {
            Utente sel = tableview2.getSelectionModel().getSelectedItem();
            if (sel == null) {
                new Alert(Alert.AlertType.WARNING, "Seleziona un utente da eliminare.").show();
                return;
            }

            Alert conf = new Alert(Alert.AlertType.CONFIRMATION, "Confermi eliminazione utente?");
            conf.showAndWait().ifPresent(r -> {
                if (r == ButtonType.OK) {
                    elencoUtenti.cancellazioneUtente(sel);
                    if (archivio != null) {
                        archivio.salvaUtenti(elencoUtenti.getListaUtenti());
                    }
                    aggiorna();
                }
            });

        } catch (Exception e) {
            System.err.println("Errore nella Cancellazione Utente " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Impossibile cancellare l'utente.").showAndWait();
        }
    }

    /** Gestisce la ricerca dinamica degli utenti in tabella */
    @FXML
    public void handleRicercaUtente() {
        String ricerca = txtRicercaUtente.getText();
        if (ricerca == null || ricerca.isEmpty()) {
            aggiorna();
            return;
        }

        ArrayList<Utente> risultati = elencoUtenti.ricercaUtente(ricerca, ricerca, ricerca);
        tableview2.getItems().setAll(risultati);
    }

    /** Torna alla schermata principale della dashboard */
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

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Dashboard principale " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,
             "Impossibile aprire la finestra della dashboard.").showAndWait();
        }
    }
}







