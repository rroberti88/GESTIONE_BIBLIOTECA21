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
            int annoPubblicazione = Integer.parseInt(txtAnnoPubblicazione.getText());
            String categoria = txtCategoria.getText();
            int copieDisponibili = Integer.parseInt(txtCopieDisponibili.getText());
            int copieTotali = Integer.parseInt(txtCopieTotali.getText());

            Libro libro = new Libro(titolo, autore, ISBN, annoPubblicazione,categoria, copieDisponibili, copieTotali);
            catalogo.inserimentoLibro(libro);

            stage.close(); 
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Dati non validi");
            alert.setContentText("Controlla i campi inseriti.");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    private void handleAnnulla(){
        stage.close();  
    }
}
