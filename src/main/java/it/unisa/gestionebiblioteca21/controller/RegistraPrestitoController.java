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

import java.time.LocalDate;

public class RegistraPrestitoController {

    private ElencoPrestiti elencoPrestiti;
    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private ArchivioDati archivio;
    private Stage stage;

    @FXML private TextField txtLibro;
    @FXML private TextField txtUtente;
    @FXML private TextField txtDataPrestito;
    @FXML private TextField txtDataScadenza;

    public void setListaPrestiti(ElencoPrestiti e) { this.elencoPrestiti = e; }

    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }

    public void setElencoUtenti(ElencoUtenti u) { this.elencoUtenti = u; }

    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    public void setStage(Stage s) { this.stage = s; }

    @FXML
    private void handleSalva() {
        try {
            String libro = txtLibro.getText().trim();
            String utente = txtUtente.getText().trim();

            LocalDate dataPrestito = LocalDate.parse(txtDataPrestito.getText().trim());
            LocalDate dataScadenza = LocalDate.parse(txtDataScadenza.getText().trim());

            if (libro.isEmpty() || utente.isEmpty()) {
                mostraErrore("Tutti i campi devono essere compilati.");
                return;
            }

            Prestito p = new Prestito(libro, utente, dataPrestito, dataScadenza, null);

            elencoPrestiti.registraPrestito(p);

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());

            stage.close();

        } catch (Exception e) {
            mostraErrore("Errore nei dati inseriti.");
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


