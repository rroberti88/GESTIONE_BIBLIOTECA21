/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller per l'inserimento di un nuovo utente.
 * Gestisce la validazione dei dati e l'aggiunta all'elenco utenti.
 */
public class InserimentoUtenteController {

    @FXML private TextField txtMatricola;
    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private TextField txtEmail;

    private ElencoUtenti modelUt;
    private ArchivioDati archivio;
    private Stage stage;

    /**
     * Imposta il modello degli utenti.
     * @param modelUt ElencoUtenti
     */
    public void setModel(ElencoUtenti modelUt) {
        this.modelUt = modelUt;
    }

    /**
     * Imposta l'archivio per la gestione dei dati persistenti.
     * @param archivio ArchivioDati
     */
    public void setArchivio(ArchivioDati archivio) {
        this.archivio = archivio;
    }

    /**
     * Imposta lo stage della finestra corrente.
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Gestisce il salvataggio di un nuovo utente.
     * Valida i dati inseriti e aggiunge l'utente al modello.
     */
    @FXML
    private void handleSalva() {

        String matricola = txtMatricola.getText().trim();
        String nome = txtNome.getText().trim();
        String cognome = txtCognome.getText().trim();
        String email = txtEmail.getText().trim();

        Utente nuovo = new Utente();
        nuovo.setMatricola(matricola);
        nuovo.setNome(nome);
        nuovo.setCognome(cognome);
        nuovo.setEmail(email);
        nuovo.setNumeroPrestiti(0);

        try {
            modelUt.inserimentoUtente(nuovo);

            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setTitle("Successo");
            ok.setHeaderText(null);
            ok.setContentText("Utente inserito correttamente.");
            ok.showAndWait();

            stage.close();

        } catch (IllegalArgumentException e) {
            mostraErrore(e.getMessage());
        } catch (Exception e) {
            mostraErrore("Errore sconosciuto. Controlla i dati inseriti.");
        }
    }

    /**
     * Gestisce l'annullamento dell'inserimento e chiude la finestra.
     */
    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    /**
     * Mostra un messaggio di errore all'utente.
     * @param msg Messaggio di errore
     */
    private void mostraErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Errore");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}