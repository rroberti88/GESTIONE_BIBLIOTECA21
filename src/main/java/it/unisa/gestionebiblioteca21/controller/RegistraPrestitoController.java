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

/**
 * Controller per la registrazione dei prestiti dei libri.
 * Permette di creare un nuovo prestito, aggiorna le copie disponibili
 * del libro e salva le informazioni nell'archivio.
 */
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

    /**
     * Imposta l'elenco prestiti da utilizzare.
     * @param e ElencoPrestiti
     */
    public void setListaPrestiti(ElencoPrestiti e) { this.elencoPrestiti = e; }

    /**
     * Imposta il catalogo dei libri.
     * @param c CatalogoLibri
     */
    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }

    /**
     * Imposta l'elenco utenti.
     * @param u ElencoUtenti
     */
    public void setElencoUtenti(ElencoUtenti u) { this.elencoUtenti = u; }

    /**
     * Imposta l'archivio dati.
     * @param a ArchivioDati
     */
    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    /**
     * Imposta lo stage della finestra corrente.
     * @param s Stage
     */
    public void setStage(Stage s) { this.stage = s; }

    /**
     * Gestisce la pressione del pulsante Salva per registrare un nuovo prestito.
     * Controlla validità degli input, verifica disponibilità del libro
     * e dei dati dell'utente, aggiorna copie disponibili e salva i dati.
     */
    @FXML
    private void handleSalva() {
        try {
            String isbn = txtISBN.getText().trim();
            String matricola = txtMatricola.getText().trim();

            if (isbn.isEmpty() || matricola.isEmpty() ||
                txtDataPrestito.getText().trim().isEmpty() || txtDataScadenza.getText().trim().isEmpty()) {
                mostraErrore("Inserisci tutti i campi: ISBN, Matricola, Data Prestito e Data Scadenza.");
                return;
            }

            LocalDate dataPrestito;
            LocalDate dataScadenza;
            try {
                dataPrestito = LocalDate.parse(txtDataPrestito.getText().trim());
                dataScadenza = LocalDate.parse(txtDataScadenza.getText().trim());
            } catch (Exception e) {
                mostraErrore("Formato data non valido. Usa: YYYY-MM-DD");
                return;
            }

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
                mostraErrore("Nessun utente trovato con matricola: " + matricola);
                return;
            }

            Prestito prestito = new Prestito(isbn, matricola, dataPrestito, dataScadenza, null);

            elencoPrestiti.registraPrestito(prestito, libroObj);

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());

            stage.close();

        } catch (IllegalStateException | IllegalArgumentException e) {
            mostraErrore(e.getMessage());
        } catch (Exception e) {
            mostraErrore("Errore nei dati inseriti. Controlla formati e valori.");
        }
    }

    /**
     * Gestisce la pressione del pulsante Annulla chiudendo la finestra.
     */
    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    /**
     * Mostra un messaggio di errore all'utente.
     * @param msg Messaggio da visualizzare
     */
    private void mostraErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg);
        a.showAndWait();
    }
}
