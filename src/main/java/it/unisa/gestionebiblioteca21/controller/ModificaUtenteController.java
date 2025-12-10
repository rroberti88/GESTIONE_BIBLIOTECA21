/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

/**
 *
 * @author cosim
 */
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;
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

    public void setModel(ElencoUtenti model) {
        this.model = model;
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

        String nome = txtNome.getText().trim();
        String cognome = txtCognome.getText().trim();
        String email = txtEmail.getText().trim();

        if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty()) {
            mostraErrore("Tutti i campi sono obbligatori.");
            return;
        }

        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);

        if (!utente.isValid()) {
            mostraErrore("Dati utente non validi.");
            return;
        }

        model.modificaUtente(utente);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successo");
        alert.setHeaderText("Utente modificato correttamente");
        alert.setContentText(nome + " " + cognome + " (matricola: " + utente.getMatricola() + ")");
        alert.showAndWait();

        if (onSalvato != null) {
            onSalvato.run();
        }

        stage.close();
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
