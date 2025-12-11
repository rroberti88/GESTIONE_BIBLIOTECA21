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

public class RegistraRestituzioneController {

    private ElencoPrestiti elencoPrestiti;
    private ArchivioDati archivio;
    private Stage stage;

    @FXML private TextField txtLibro;
    @FXML private TextField txtUtente;


    public void setListaPrestiti(ElencoPrestiti e) { this.elencoPrestiti = e; }

    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    public void setStage(Stage s) { this.stage = s; }


    @FXML
    private void handleSalva() {

        try {
            String libro = txtLibro.getText().trim();
            String utente = txtUtente.getText().trim();

            if (libro.isEmpty() || utente.isEmpty()) {
                mostraErrore("Inserisci sia libro che utente.");
                return;
            }

            boolean ok = elencoPrestiti.registraRestituzione(libro, utente);

            if (!ok) {
                mostraErrore("Prestito non trovato.");
                return;
            }

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());

            stage.close();

        } catch (Exception e) {
            mostraErrore("Errore durante la restituzione.");
        }
    }


    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    private void mostraErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg);
        a.showAndWait();
    }
}


