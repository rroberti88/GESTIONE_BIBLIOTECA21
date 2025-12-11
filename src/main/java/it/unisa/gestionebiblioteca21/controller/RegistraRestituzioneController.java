/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import it.unisa.gestionebiblioteca21.model.Libro;
import it.unisa.gestionebiblioteca21.model.Prestito;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * @author Felice Iandoli
 */
public class RegistraRestituzioneController {
    private ElencoPrestiti listaPrestiti;
    private Stage stage;

    @FXML private TextField txtLibro;
    @FXML private TextField txtUtente;
    @FXML private TextField txtDatadiScadenza;
    @FXML private TextField txtDatadiPrestito;

    public void setListaPrestiti(ElencoPrestiti listaPrestiti) {
        this.listaPrestiti = listaPrestiti;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleSalva() {

        String libro = txtLibro.getText();
        String utente = txtUtente.getText();

        if (libro.isEmpty() || utente.isEmpty()) {
            mostraErrore("Inserire libro e utente.");
            return;
        }

        boolean rimosso = listaPrestiti.registraRestituzione(libro, utente);

        if (rimosso) {
            stage.close();
        } else {
            mostraErrore("Prestito non trovato.");
        }
    }

    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    private void mostraErrore(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Restituzione non riuscita");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
