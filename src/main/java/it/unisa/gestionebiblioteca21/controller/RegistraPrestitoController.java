/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
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
public class RegistraPrestitoController {

    private ElencoPrestiti listaPrestiti;
    private CatalogoLibri catalogoLibri; // riferimento al catalogo libri
    private Stage stage;

    @FXML private TextField txtLibro;
    @FXML private TextField txtUtente;
    @FXML private TextField txtDataPrestito;
    @FXML private TextField txtDataScadenza;
    @FXML private Button btnSalva;
    @FXML private Button btnAnnulla;

    public void setListaPrestiti(ElencoPrestiti listaPrestiti) {
        this.listaPrestiti = listaPrestiti;
    }

    public void setCatalogoLibri(CatalogoLibri catalogoLibri) {
        this.catalogoLibri = catalogoLibri;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleSalva() {
        try {
            String nomeLibro = txtLibro.getText().trim();
            String utente = txtUtente.getText().trim();
            LocalDate dataPrestito = LocalDate.parse(txtDataPrestito.getText().trim());
            LocalDate dataScadenza = LocalDate.parse(txtDataScadenza.getText().trim());

            if (nomeLibro.isEmpty() || utente.isEmpty()) {
                throw new IllegalArgumentException("Tutti i campi devono essere compilati.");
            }

            Libro libroObj = catalogoLibri.getLibroperilnome(nomeLibro);
            if (libroObj == null) {
                throw new IllegalArgumentException("Libro non trovato nel catalogo.");
            }

            Prestito prestito = new Prestito(nomeLibro, utente, dataPrestito, dataScadenza, null);

            listaPrestiti.registraPrestito(prestito, libroObj);
            stage.close();

        } catch (IllegalStateException | IllegalArgumentException e) {
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