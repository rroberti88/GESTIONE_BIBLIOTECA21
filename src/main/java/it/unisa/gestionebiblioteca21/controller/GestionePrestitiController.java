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
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

/**
 * @class GestionePrestitiController
 * @brief Controller per la gestione dei prestiti.
 * 
 * Si occupa della visualizzazione dei prestiti nella TableView,
 * della gestione della registrazione, restituzione, cancellazione e ricerca
 * dei prestiti.
 */
public class GestionePrestitiController {

    private ElencoPrestiti elencoPrestiti; ///< Lista dei prestiti
    private CatalogoLibri catalogo; ///< Catalogo dei libri
    private ElencoUtenti elencoUtenti; ///< Elenco degli utenti
    private Autenticazione autenticazione; ///< Modello di autenticazione
    private ArchivioDati archivio; ///< Archivio dati per salvataggio e caricamento
    private Stage stage; ///< Stage principale

    @FXML private TextField txtRicercaPrestito; ///< Campo per ricerca prestiti
    @FXML private TableView<Prestito> tableview; ///< TableView dei prestiti
    @FXML private TableColumn<Prestito, String> colLibro; ///< Colonna titolo libro
    @FXML private TableColumn<Prestito, String> colUtente; ///< Colonna nome utente
    @FXML private TableColumn<Prestito, String> colDataPrestito; ///< Colonna data prestito
    @FXML private TableColumn<Prestito, String> colDataScadenza; ///< Colonna data scadenza

    /**
     * @brief Imposta la lista dei prestiti e aggiorna la TableView.
     * @param e Lista dei prestiti da visualizzare
     */
    public void setListaPrestiti(ElencoPrestiti e) {
        this.elencoPrestiti = e;
        aggiorna();
    }

    /**
     * @brief Imposta il catalogo dei libri.
     * @param c Catalogo dei libri
     */
    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }

    /**
     * @brief Imposta l'elenco degli utenti.
     * @param u Elenco utenti
     */
    public void setElencoUtenti(ElencoUtenti u) { this.elencoUtenti = u; }

    /**
     * @brief Imposta l'archivio dati.
     * @param a Archivio dati
     */
    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    /**
     * @brief Imposta il modello di autenticazione.
     * @param a Modello autenticazione
     */
    public void setModelAut(Autenticazione a) { this.autenticazione = a; }

    /**
     * @brief Imposta lo stage principale dell'applicazione.
     * @param s Stage principale
     */
    public void setStage(Stage s) { this.stage = s; }

    /**
     * @brief Inizializza le colonne della TableView, i colori delle righe
     * e il listener per la ricerca dei prestiti.
     */
    @FXML
    public void initialize() {

        colLibro.setCellValueFactory(p -> {
            Libro l = catalogo.cercaLibroPerISBN(p.getValue().getLibro());
            return new SimpleStringProperty(l != null ? l.getTitolo() : "Libro non trovato");
        });

        colUtente.setCellValueFactory(p -> {
            Utente u = elencoUtenti.cercaPerMatricola(p.getValue().getUtente());
            return new SimpleStringProperty(u != null ? u.getNome() : "Utente non trovato");
        });

        colDataPrestito.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().getDataPrestito().toString()));

        colDataScadenza.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().getDataScadenza().toString()));

        tableview.setRowFactory(tv -> new TableRow<Prestito>() {
            @Override
            protected void updateItem(Prestito p, boolean empty) {
                super.updateItem(p, empty);

                if (empty || p == null) {
                    setStyle("");
                    return;
                }

                if (p.isOverdue()) {
                    setStyle("-fx-background-color: #ff9999;");
                } else {
                    setStyle("-fx-background-color: #99ff99;");
                }
            }
        });

        txtRicercaPrestito.textProperty().addListener((o, oldV, newV) -> handleRicercaPrestito());
    }

    /**
     * @brief Aggiorna la TableView con la lista dei prestiti corrente.
     * @return void
     */
    private void aggiorna() {
        if (elencoPrestiti != null)
            tableview.getItems().setAll(elencoPrestiti.getListaPrestiti());
    }

    /**
     * @brief Apre la finestra per registrare un nuovo prestito.
     * Salva i dati su archivio dopo la chiusura del popup.
     */
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

        } catch (IOException e) {
            System.err.println("Errore apertura finestra Registrazione Prestito: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,
            "Impossibile aprire la finestra di registrazione del prestito.").showAndWait();
        }
    }

    /**
     * @brief Apre la finestra per registrare la restituzione di un prestito.
     * Salva i dati su archivio dopo la chiusura del popup.
     */
    @FXML
    public void handleRegistraRestituzione() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/it/unisa/gestionebiblioteca21/view/RegistraRestituzioneView.fxml"));
            Parent root = loader.load();

            RegistraRestituzioneController ctrl = loader.getController();
            ctrl.setListaPrestiti(elencoPrestiti);
            ctrl.setArchivio(archivio);
            ctrl.setCatalogo(catalogo);
            ctrl.setElencoUtenti(elencoUtenti);

            Stage popup = new Stage();
            ctrl.setStage(popup);

            popup.setScene(new Scene(root));
            popup.setTitle("Registrazione Restituzione");
            popup.initOwner(stage);
            popup.showAndWait();

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
            archivio.salvaLibri(catalogo.getListaLibri());
            aggiorna();

        }  catch (IOException e) {
        System.err.println("Errore apertura finestra Registrazione Restituzione: " + e.getMessage());
        new Alert(Alert.AlertType.ERROR,
             "Impossibile aprire la finestra di registrazione della restituzione.").showAndWait();
}

    }

    /**
     * @brief Elimina il prestito selezionato nella TableView.
     * Aggiorna il numero di copie disponibili del libro associato.
     * Salva i dati modificati su archivio.
     */
    @FXML
    public void handleCancellazionePrestito() {
        try {
            Prestito sel = tableview.getSelectionModel().getSelectedItem();

            if (sel == null) {
                new Alert(Alert.AlertType.WARNING,
                        "Seleziona un prestito da eliminare.").show();
                return;
            }

            Alert conf = new Alert(Alert.AlertType.CONFIRMATION,
                    "Confermi l'eliminazione del prestito selezionato?");
            conf.showAndWait().ifPresent(r -> {

                if (r == ButtonType.OK) {

                    Libro libro = catalogo.cercaLibroPerISBN(sel.getLibro());
                    if (libro != null) {
                        libro.setCopieDisponibili((libro.getCopieDisponibili() + 1));
                    }
                    elencoPrestiti.cancellazionePrestito(sel);

                    if (archivio != null) {
                        archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
                    }

                    aggiorna();
                }
            });

        } catch (Exception e) {
            System.err.println("Errore nella Cancellazione Prestito " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Impossibile cancellare il prestito.").showAndWait();
        }
    }

    /**
     * @brief Esegue la ricerca dei prestiti in base alla chiave inserita.
     * Aggiorna la TableView con i risultati trovati.
     */
    @FXML
    public void handleRicercaPrestito() {
        if (elencoPrestiti == null) return;

    String key = txtRicercaPrestito.getText();
    if (key == null || key.trim().isEmpty()) {
        aggiorna();
        return;
    }

   String ricerca = key.toLowerCase();

    ArrayList<Prestito> risultati = new ArrayList<>();

    for (Prestito p : elencoPrestiti.getListaPrestiti()) {

        String isbn = "";
        String titolo = "";
        String nomeUtente = "";


        if (p.getLibro() != null) {
            isbn = p.getLibro().toLowerCase();
        }


        Libro l = catalogo.cercaLibroPerISBN(p.getLibro());
        if (l != null && l.getTitolo() != null) {
            titolo = l.getTitolo().toLowerCase();
        }


        Utente u = elencoUtenti.cercaPerMatricola(p.getUtente());
        if (u != null && u.getNome() != null) {
            nomeUtente = u.getNome().toLowerCase();
        }

        if (isbn.contains(ricerca)|| 
            titolo.contains(ricerca) ||
            nomeUtente.contains(ricerca)) {

            risultati.add(p);
        }
    }

    tableview.getItems().setAll(risultati);
    }
    

    /**
     * @brief Torna alla Dashboard principale del bibliotecario.
     * Carica la view HomeView e imposta i modelli e dati necessari.
     */
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

        } catch (IOException e) {
            System.err.println("Errore durante la cancellazione del prestito: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Errore durante la cancellazione del prestito.")
            .showAndWait();
}

    }
}
