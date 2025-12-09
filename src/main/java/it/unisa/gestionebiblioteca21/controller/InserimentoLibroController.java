/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
/**
 *
 * @author Felice Iandoli
 */
public class InserimentoLibroController {
    private CatalogoLibri catalogo;
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

    public void setCatalogo(CatalogoLibri catalogo) {
        this.catalogo = catalogo;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
private void handleSalva() {
    try {

        String titolo = txtTitolo.getText();
        String autore = txtAutore.getText();
        String ISBN = txtISBN.getText();
        String categoria = txtCategoria.getText();

        if (titolo.isEmpty() || autore.isEmpty() || categoria.isEmpty() || ISBN.isEmpty()) {
            throw new IllegalArgumentException("Tutti i campi devono essere compilati.");
        }

        int annoPubblicazione = Integer.parseInt(txtAnnoPubblicazione.getText());
        int copieDisponibili = Integer.parseInt(txtCopieDisponibili.getText());
        int copieTotali = Integer.parseInt(txtCopieTotali.getText());

        if (copieDisponibili > copieTotali) {
            throw new IllegalArgumentException("Le copie disponibili non possono superare le copie totali.");
        }

        if (!ISBN.matches("\\d{13}")) {
            throw new IllegalArgumentException("L'ISBN deve contenere esattamente 13 cifre numeriche.");
        }

        Libro libro = new Libro(ISBN, titolo, autore, annoPubblicazione, categoria, copieTotali, copieDisponibili);

        catalogo.inserimentoLibro(libro);

        stage.close();

    } catch (NumberFormatException e) {

        mostraErrore("I campi numerici (anno, copie totali, copie disponibili) devono contenere solo numeri.");

    } catch (IllegalArgumentException e) {

        mostraErrore(e.getMessage());

    } catch (Exception e) {

        mostraErrore("Errore sconosciuto. Controlla i dati inseriti.");
        e.printStackTrace();
    }
}

private void mostraErrore(String msg) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Errore");
    alert.setHeaderText("Dati non validi");
    alert.setContentText(msg);
    alert.showAndWait();
}
    @FXML
    private void handleAnnulla(){
        stage.close();  
    }
}
