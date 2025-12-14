/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.Libro;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller per l'inserimento di un nuovo libro nel catalogo.
 * Gestisce la validazione dei dati e l'aggiunta al catalogo libri.
 */
public class InserimentoLibroController {

    private CatalogoLibri catalogo;
    private ArchivioDati archivio;
    private Stage stage;

    @FXML private TextField txtTitolo;
    @FXML private TextField txtAutore;
    @FXML private TextField txtISBN;
    @FXML private TextField txtAnnoPubblicazione;
    @FXML private TextField txtCategoria;
    @FXML private TextField txtCopieDisponibili;
    @FXML private TextField txtCopieTotali;
    @FXML private Button btnSalva;
    @FXML private Button btnAnnulla;

    /**
     * Imposta il catalogo dei libri.
     * @param catalogo CatalogoLibri
     */
    public void setCatalogo(CatalogoLibri catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Imposta l'archivio dati per la persistenza.
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
     * Gestisce il salvataggio di un nuovo libro.
     * Valida i dati inseriti e aggiunge il libro al catalogo.
     */
    @FXML
    private void handleSalva() {
        try {
            String titolo = txtTitolo.getText();
            String autore = txtAutore.getText();
            String ISBN = txtISBN.getText();
            String categoria = txtCategoria.getText();

            int annoPubblicazione = Integer.parseInt(txtAnnoPubblicazione.getText());
            int copieDisponibili = Integer.parseInt(txtCopieDisponibili.getText());
            int copieTotali = Integer.parseInt(txtCopieTotali.getText());

            Libro libro = new Libro(ISBN, titolo, autore, annoPubblicazione, categoria, copieTotali, copieDisponibili);
            catalogo.inserimentoLibro(libro);

            if (archivio != null) {
                archivio.salvaLibri(catalogo.getListaLibri());
            }

            stage.close();

        } catch (NumberFormatException e) {
            mostraErrore("I campi numerici (anno, copie totali, copie disponibili) devono contenere solo numeri.");
        } catch (IllegalArgumentException e) {
            mostraErrore(e.getMessage());
        } catch (Exception e) {
            mostraErrore("Errore sconosciuto. Controlla i dati inseriti.");
        }
    }

    /**
     * Mostra un messaggio di errore all'utente.
     * @param msg Messaggio di errore
     */
    private void mostraErrore(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Dati non validi");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Gestisce l'annullamento dell'inserimento e chiude la finestra.
     */
    @FXML
    private void handleAnnulla() {
        stage.close();
    }
}

