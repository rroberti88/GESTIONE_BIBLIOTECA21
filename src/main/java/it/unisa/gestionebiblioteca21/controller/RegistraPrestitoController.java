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

    @FXML private TextField txtISBN;
    @FXML private TextField txtMatricola;
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
            String isbn = txtISBN.getText().trim();
            String matricola = txtMatricola.getText().trim();

            if (isbn.isEmpty() || matricola.isEmpty()) {
                mostraErrore("Inserisci ISBN e Matricola.");
                return;
            }

            LocalDate dataPrestito = LocalDate.parse(txtDataPrestito.getText().trim());
            LocalDate dataScadenza = LocalDate.parse(txtDataScadenza.getText().trim());
            
            if (!dataScadenza.isAfter(dataPrestito)) {
            mostraErrore("La data di scadenza deve essere successiva alla data di prestito.");
            return;
            }

            Libro libroObj = catalogo.cercaLibroPerISBN(isbn);
            if (libroObj == null) {
                mostraErrore("Nessun libro trovato con ISBN: " + isbn);
                return;
            }

            Utente utenteObj = elencoUtenti.cercaPerMatricola(matricola);
            if (utenteObj == null) {
                mostraErrore("Nessun utente con matricola: " + matricola);
                return;
            }
            

            Prestito prestito = new Prestito(
                    isbn,
                    matricola,
                    dataPrestito,
                    dataScadenza,
                    null
            );

            elencoPrestiti.registraPrestito(prestito, libroObj);
            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());

            stage.close();

        } catch (Exception e) {
            mostraErrore("Errore nei dati inseriti. Controlla formati e valori.");
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
