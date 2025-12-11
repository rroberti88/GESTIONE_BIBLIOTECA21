/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

/**
 *
 * @author cosim
*/
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class InserimentoUtenteController {

    @FXML private TextField txtMatricola;
    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private TextField txtEmail;

    private ElencoUtenti modelUt;   
    private Stage stage;            

    public void setModel(ElencoUtenti modelUt) {
        this.modelUt = modelUt;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    

    @FXML
    private void handleSalva() {

        String matricola = txtMatricola.getText().trim();
        String nome = txtNome.getText().trim();
        String cognome = txtCognome.getText().trim();
        String email = txtEmail.getText().trim();
       
        

        Utente nuovo = new Utente();
        nuovo.setMatricola(matricola);
        nuovo.setNome(nome);
        nuovo.setCognome(cognome);
        nuovo.setEmail(email);
        nuovo.setNumeroPrestiti(0);

        try {
        modelUt.inserimentoUtente(nuovo); 

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setTitle("Successo");
        ok.setHeaderText(null);
        ok.setContentText("Utente inserito correttamente.");
        ok.showAndWait();

        stage.close();

    } catch (IllegalArgumentException e) {
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
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Errore");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}



