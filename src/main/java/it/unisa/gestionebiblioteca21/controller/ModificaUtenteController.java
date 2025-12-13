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
 * Controller per la modifica dei dati di un utente.
 * Permette di aggiornare nome, cognome ed email di un utente
 * giÃ  presente nell'elenco utenti e salvare le modifiche sull'archivio.
 */
public class ModificaUtenteController {

    @FXML private TextField txtMatricola;
    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private TextField txtEmail;

    private ElencoUtenti model;
    private Utente utente;
    private Stage stage;
    private Runnable onSalvato;
    private ArchivioDati archivio;

    /**
     * Imposta il modello dell'elenco utenti.
     * @param model ElencoUtenti
     */
    public void setModel(ElencoUtenti model) {
        this.model = model;
    }

    /**
     * Imposta l'archivio dati per il salvataggio.
     * @param archivio ArchivioDati
     */
    public void setArchivio(ArchivioDati archivio) {
        this.archivio = archivio;
    }

    /**
     * Imposta l'utente da modificare e popola i campi della UI.
     * @param utente Utente
     */
    public void setUtente(Utente utente) {
        this.utente = utente;

        if (utente != null) {
            txtMatricola.setText(utente.getMatricola());
            txtMatricola.setDisable(true);
            txtNome.setText(utente.getNome());
            txtCognome.setText(utente.getCognome());
            txtEmail.setText(utente.getEmail());
        }
    }

    /**
     * Imposta lo stage della finestra corrente.
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Imposta una callback da eseguire dopo il salvataggio.
     * @param onSalvato Runnable
     */
    public void setOnSalvato(Runnable onSalvato) {
        this.onSalvato = onSalvato;
    }

    /**
     * Gestisce la pressione del pulsante Salva per modificare un utente.
     * Valida i dati inseriti, aggiorna il modello e salva le modifiche sull'archivio.
     */
    @FXML
    private void handleSalva() {

        if (utente == null) {
            mostraErrore("Nessun utente da modificare.");
            return;
        }

        Utente utenteModificato = new Utente();
        utenteModificato.setMatricola(utente.getMatricola());
        utenteModificato.setNome(txtNome.getText().trim());
        utenteModificato.setCognome(txtCognome.getText().trim());
        utenteModificato.setEmail(txtEmail.getText().trim());

        try {
            model.modificaUtente(utente, utenteModificato);
            if (archivio != null) {
                archivio.salvaUtenti(model.getListaUtenti());
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successo");
            alert.setHeaderText("Utente modificato correttamente");
            alert.setContentText(utenteModificato.getNome() + " " + utenteModificato.getCognome() +
                    " (matricola: " + utenteModificato.getMatricola() + ")");
            alert.showAndWait();

            if (onSalvato != null) onSalvato.run();
            stage.close();

        } catch (IllegalArgumentException e) {
            mostraErrore(e.getMessage());
        } catch (Exception e) {
            mostraErrore("Errore sconosciuto. Controlla i dati inseriti.");
            e.printStackTrace();
        }
    }

    /**
     * Gestisce la pressione del pulsante Annulla chiudendo la finestra.
     */
    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    /**
     * Mostra un messaggio di errore all'utente.
     * @param msg Messaggio da visualizzare
     */
    private void mostraErrore(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Dati non validi");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

