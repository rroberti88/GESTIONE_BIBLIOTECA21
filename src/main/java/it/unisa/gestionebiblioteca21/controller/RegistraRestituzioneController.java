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
 * @class RegistraRestituzioneController
 * @brief Controller per la view di restituzione dei prestiti.
 * 
 * Permette di registrare la restituzione di un prestito esistente,
 * gestisce errori, segnala restituzioni in ritardo e aggiorna i dati
 * relativi a prestiti e copie disponibili dei libri.
 */
public class RegistraRestituzioneController {

    private ElencoPrestiti elencoPrestiti; 
    private ArchivioDati archivio;
    private Stage stage;
    private CatalogoLibri catalogo; 
    private ElencoUtenti elencoUtenti;

    @FXML private TextField txtLibro; 
    @FXML private TextField txtUtente; 
    @FXML private TextField txtDatadiScadenza; 

    /**
     * @brief Imposta la lista dei prestiti.
     * @param e ElencoPrestiti da utilizzare
     */
    public void setListaPrestiti(ElencoPrestiti e) { this.elencoPrestiti = e; }

    /**
     * @brief Imposta l'archivio dati.
     * @param a ArchivioDati da utilizzare
     */
    public void setArchivio(ArchivioDati a) { this.archivio = a; }

    /**
     * @brief Imposta il catalogo dei libri.
     * @param c CatalogoLibri da utilizzare
     */
    public void setCatalogo(CatalogoLibri c) { this.catalogo = c; }
    
    /**
     * @brief Imposta l'elenco utenti.
     * @param e CatalogoLibri da utilizzare
     */
    public void setElencoUtenti(ElencoUtenti e) {this.elencoUtenti = e;}

    /**
     * @brief Imposta lo stage della finestra popup.
     * @param s Stage da utilizzare
     */
    public void setStage(Stage s) { this.stage = s; }

    /**
     * @brief Salva la restituzione di un prestito.
     * 
     * Controlla che tutti i campi siano compilati, che il prestito esista,
     * segnala eventuali ritardi, aggiorna le copie disponibili del libro,
     * salva su archivio e chiude la finestra.
     * @return void
     */
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
                avviso.setContentText("La data di scadenza era: " + prestito.getDataScadenza() +
                        "\nData odierna: " + oggi );
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
            Utente utente = elencoUtenti.cercaPerMatricola(matricola);
            if (utente != null && utente.getNumeroPrestiti() > 0) {
                utente.setNumeroPrestiti(utente.getNumeroPrestiti() - 1);
            }

            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
            archivio.salvaLibri(catalogo.getListaLibri());
            archivio.salvaUtenti(elencoUtenti.getListaUtenti());


            stage.close();

        } catch (Exception e) {
            mostraErrore("Errore durante la restituzione.");
        }
    }

    /**
     * @brief Chiude la finestra senza salvare modifiche.
     * @return void
     */
    @FXML
    private void handleAnnulla() {
        stage.close();
    }

    /**
     * @brief Mostra un messaggio di errore all'utente.
     * @param msg Messaggio da visualizzare
     * @return void
     */
    private void mostraErrore(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg);
        a.showAndWait();
    }
}
