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

    public void setModel(ElencoUtenti model) {
        this.model = model;
    }

    public void setArchivio(ArchivioDati archivio) {
        this.archivio = archivio;
    }

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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setOnSalvato(Runnable onSalvato) {
        this.onSalvato = onSalvato;
    }

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

        stage.close();

    } catch (IllegalArgumentException e) {
        mostraErrore(e.getMessage());
    } catch (Exception e) {
        mostraErrore("Errore sconosciuto. Controlla i dati inseriti.");
        e.printStackTrace();
    }

    }

    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    private void mostraErrore(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Dati non validi");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

