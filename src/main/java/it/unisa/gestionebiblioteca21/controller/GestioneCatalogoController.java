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
 * Controller per la gestione del catalogo dei libri.
 * Permette di inserire, modificare, cancellare e ricercare libri nel catalogo.
 */
public class GestioneCatalogoController {

    private CatalogoLibri catalogo;
    private ArchivioDati archivio;
    private Autenticazione autenticazione;
    private ElencoUtenti elencoUtenti;
    private ElencoPrestiti elencoPrestiti;
    private Stage stage;

    @FXML private TextField txtRicercaLibro;
    @FXML private TableView<Libro> tableview;
    @FXML private TableColumn<Libro, String> colTitolo;
    @FXML private TableColumn<Libro, String> colAutore;
    @FXML private TableColumn<Libro, Integer> colAnnoDiEdizione;
    @FXML private TableColumn<Libro, String> colIsbn;
    @FXML private TableColumn<Libro, Integer> colCopieDisponibili;

    /** Imposta il catalogo da gestire e aggiorna la tabella
     * @param catalogo */
    public void setCatalogo(CatalogoLibri catalogo) {
        this.catalogo = catalogo;
        aggiornaTabella();
    }

    public void setArchivio(ArchivioDati archivio) { this.archivio = archivio; }
    public void setModelAut(Autenticazione aut) { this.autenticazione = aut; }
    public void setElencoUtenti(ElencoUtenti elenco) { this.elencoUtenti = elenco; }
    public void setListaPrestiti(ElencoPrestiti elenco) { this.elencoPrestiti = elenco; }
    public void setStage(Stage stage) { this.stage = stage; }

    /** Inizializza la tabella e i listener di ricerca */
    @FXML
    public void initialize() {
        colTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        colAutore.setCellValueFactory(new PropertyValueFactory<>("autore"));
        colAnnoDiEdizione.setCellValueFactory(new PropertyValueFactory<>("annoPubblicazione"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colCopieDisponibili.setCellValueFactory(new PropertyValueFactory<>("copieDisponibili"));

        txtRicercaLibro.textProperty().addListener((obs, oldVal, newVal) -> handleRicercaLibro());
    }

    /** Aggiorna la tabella dei libri */
    private void aggiornaTabella() {
        if (catalogo != null)
            tableview.getItems().setAll(catalogo.getListaLibri());
    }

    /** Verifica se il catalogo è stato inizializzato */
    private boolean checkCatalogo() {
        if (catalogo == null) {
            mostraErrore("Catalogo non inizializzato.");
            return false;
        }
        return true;
    }

    /** Apre la finestra per l'inserimento di un nuovo libro */
    @FXML
    private void handleInserimentoLibro() {

        if (!checkCatalogo()) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/it/unisa/gestionebiblioteca21/view/InserimentoLibroView.fxml"));
            Parent root = loader.load();

            InserimentoLibroController ctrl = loader.getController();
            ctrl.setCatalogo(catalogo);
            ctrl.setArchivio(archivio);

            Stage popup = new Stage();
            ctrl.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Inserimento Libro");
            popup.initOwner(stage);
            popup.showAndWait();

            archivio.salvaLibri(catalogo.getListaLibri());
            aggiornaTabella();

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Inserimento Libro " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,
             "Impossibile aprire la finestra di inserimento libro.").showAndWait();
        }
    }

    /** Apre la finestra per modificare il libro selezionato */
    @FXML
    private void handleModificaLibro() {

        if (!checkCatalogo()) return;

        Libro sel = tableview.getSelectionModel().getSelectedItem();

        if (sel == null) {
            mostraWarning("Seleziona un libro da modificare.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/it/unisa/gestionebiblioteca21/view/ModificaLibroView.fxml"));
            Parent root = loader.load();

            ModificaLibroController ctrl = loader.getController();
            ctrl.setCatalogo(catalogo);
            ctrl.setArchivio(archivio);
            ctrl.setLibro(sel);

            Stage popup = new Stage();
            ctrl.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Modifica Libro");
            popup.initOwner(stage);
            popup.showAndWait();

            archivio.salvaLibri(catalogo.getListaLibri());
            aggiornaTabella();

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Modifica Libro " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,
             "Impossibile aprire la finestra di modifica del libro.").showAndWait();
        }
    }

    /** Cancella il libro selezionato dal catalogo */
    @FXML
    private void handleCancellazioneLibro() {
        
        if (!checkCatalogo()) return;
    try{
        Libro sel = tableview.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostraWarning("Seleziona un libro da cancellare.");
            return;
        }

        Alert conf = new Alert(Alert.AlertType.CONFIRMATION,
                "Vuoi davvero eliminare il libro selezionato?");
        conf.showAndWait().ifPresent(r -> {
            if (r == ButtonType.OK) {
                catalogo.cancellazioneLibro(sel);
                archivio.salvaLibri(catalogo.getListaLibri());
                aggiornaTabella();
            }
        });
    }catch (Exception e) {
            System.err.println("Errore nella Cancellazione Libro " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Impossibile cancellare il libro.").showAndWait();
        }
    }

    /** Ricerca libri filtrando per titolo, autore o ISBN */
    @FXML
    private void handleRicercaLibro() {

        if (!checkCatalogo()) return;

        String key = txtRicercaLibro.getText();

        if (key == null || key.isEmpty()) {
            aggiornaTabella();
            return;
        }

        ArrayList<Libro> risultati =
                catalogo.ricercaLibro(key, key, key);

        tableview.getItems().setAll(risultati);
    }

    /** Torna alla dashboard principale */
    @FXML
    private void handleBackDashboard() {
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

        } catch (IOException e) {
             System.err.println("Errore apertura finestra Dashboard principale " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,
             "Impossibile aprire la finestra della dashboard.").showAndWait();
}

    }

    /** Mostra un messaggio di errore */
    private void mostraErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg);
        a.showAndWait();
    }

    /** Mostra un messaggio di warning */
    private void mostraWarning(String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING, msg);
        a.showAndWait();
    }
}