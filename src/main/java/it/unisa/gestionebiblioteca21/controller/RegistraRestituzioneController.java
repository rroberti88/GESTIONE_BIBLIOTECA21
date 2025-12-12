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

public class RegistraRestituzioneController {

    private ElencoPrestiti elencoPrestiti;
    private ArchivioDati archivio;
    private Stage stage;
    private CatalogoLibri catalogo;     

    @FXML private TextField txtLibro;     
    @FXML private TextField txtUtente;    
    @FXML private TextField txtDatadiScadenza; 

    public void setListaPrestiti(ElencoPrestiti e) { this.elencoPrestiti = e; }

    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }  

    public void setStage(Stage s) { this.stage = s; }

    @FXML
    private void handleSalva() {
        try {
            String isbn = txtLibro.getText().trim();
            String matricola = txtUtente.getText().trim();
            String dataScadInput = txtDatadiScadenza.getText().trim();

            if (isbn.isEmpty() || matricola.isEmpty() || dataScadInput.isEmpty()) {
                mostraErrore("Inserisci ISBN, Matricola e Data di Scadenza.");
                return;
            }

            LocalDate dataScadenzaInserita;
            try {
                dataScadenzaInserita = LocalDate.parse(dataScadInput);
            } catch (Exception e) {
                mostraErrore("Formato data non valido. Usa: YYYY-MM-DD");
                return;
            }

            Prestito prestito = elencoPrestiti.cercaPrestito(isbn, matricola, dataScadenzaInserita);

            if (prestito == null) {
                mostraErrore("Prestito non trovato per questi dati.");
                return;
            }

        

            LocalDate oggi = LocalDate.now();
            if (oggi.isAfter(prestito.getDataScadenza())) {
            Alert avviso = new Alert(Alert.AlertType.WARNING);
            avviso.setTitle("Avviso");
            avviso.setHeaderText("Restituzione in ritardo");
            avviso.setContentText("La data di scadenza era: " + prestito.getDataScadenza() + "\nData odierna: " + oggi );
            avviso.showAndWait();
            }
            boolean completato = elencoPrestiti.registraRestituzione(isbn, matricola, dataScadenzaInserita);

            if (!completato) {
                mostraErrore("Errore nella restituzione.");
                return;
            }

            Libro libro = catalogo.cercaLibroPerISBN(isbn);
            if (libro != null) {
                libro.setCopieDisponibili((libro.getCopieDisponibili() + 1));
            }
            

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
            archivio.salvaLibri(catalogo.getListaLibri());

            stage.close();

        } catch (Exception e) {
            mostraErrore("Errore durante la restituzione.");
            e.printStackTrace();
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
