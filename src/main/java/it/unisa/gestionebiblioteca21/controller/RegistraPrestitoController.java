/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
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
    private Stage stage;

    @FXML private TextField txtLibro;
    @FXML private TextField txtUtente;
    @FXML private TextField txtDataPrestito;
    @FXML private TextField txtDataScadenza;
    @FXML private Button btnSalva;
    @FXML private Button btnAnnulla;
    
    public void setListaPrestiti (ElencoPrestiti listaPrestiti){
    this.listaPrestiti = listaPrestiti;
    }
  public void setStage(Stage stage) {
  this.stage = stage;
    }
    
     @FXML
private void handleSalva() {
    try {

        String libro = txtLibro.getText();
        String utente = txtUtente.getText();
        LocalDate dataPrestito = LocalDate.parse(txtDataPrestito.getText());
        LocalDate dataScadenza = LocalDate.parse(txtDataScadenza.getText());
        LocalDate dataRestituzione = null;

        if (libro.isEmpty() || utente.isEmpty() || dataPrestito==null || dataScadenza==null ) {
            throw new IllegalArgumentException("Tutti i campi devono essere compilati.");
        }


        Prestito prestito = new Prestito(libro, utente, dataPrestito, dataScadenza, dataRestituzione);

        listaPrestiti.registraPrestito(prestito);

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
