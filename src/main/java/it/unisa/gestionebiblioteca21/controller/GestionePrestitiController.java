/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import it.unisa.gestionebiblioteca21.model.Prestito;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Felice Iandoli
 */
public class GestionePrestitiController {
private ElencoPrestiti listaPrestiti;
private Autenticazione modelAut;
private Stage stage;  

@FXML private TextField txtRicercaPrestito;
@FXML private TableView<Prestito> tableview;
@FXML private TableColumn<Prestito, String> colLibro;
@FXML private TableColumn<Prestito, String> colUtente;
@FXML private TableColumn<Prestito, LocalDate> colDataPrestito;
@FXML private TableColumn<Prestito, LocalDate> colDataScadenza;
@FXML private Button btnDashboard;
@FXML private Button btnRegistraPrestito;
@FXML private Button btnRegistraRestituzione;
@FXML private Button btnVisualizzaPrestitiScaduti;

public GestionePrestitiController () {}

public void setListaPrestiti (ElencoPrestiti listaPrestiti){
this.listaPrestiti = listaPrestiti;
}

public void setModelAut(Autenticazione modelAut) {
    this.modelAut = modelAut;
}
public void setStage(Stage stage) {
this.stage = stage;
}

@FXML
public void initialize() {
    colLibro.setCellValueFactory(new PropertyValueFactory<>("libro"));
    colUtente.setCellValueFactory(new PropertyValueFactory<>("utente"));
    colDataPrestito.setCellValueFactory(new PropertyValueFactory<>("dataPrestito"));
    colDataScadenza.setCellValueFactory(new PropertyValueFactory<>("dataScadenza"));

    
    txtRicercaPrestito.textProperty().addListener((obs, oldValue, newValue) -> {
        handleRicercaPrestito();
    });
    
}
private void aggiornaTableView(){
    if (listaPrestiti != null) {
        tableview.getItems().setAll(listaPrestiti.getListaPrestiti());
    }
}

@FXML
public void handleRegistraPrestito(){
     try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/RegistraPrestitoView.fxml"));
        Parent root = loader.load();

        RegistraPrestitoController registraPrestitoController = loader.getController();
        registraPrestitoController.setListaPrestiti(listaPrestiti);

        Stage popupStage = new Stage();
        registraPrestitoController.setStage(popupStage);
        popupStage.setScene(new Scene(root));
        popupStage.setTitle("Registrazione Nuovo Prestito");
        popupStage.initOwner(stage); 
        popupStage.showAndWait();   

        
        aggiornaTableView();

            } catch (Exception e) {

}  
}


@FXML
public void handleRicercaPrestito() {
    if (listaPrestiti == null) return;

    String ricerca = txtRicercaPrestito.getText();

    if (ricerca == null || ricerca.isEmpty()) {
        aggiornaTableView();
        return;
    }

    ArrayList<Prestito> risultati = listaPrestiti.ricercaPrestito(ricerca, ricerca);
    tableview.getItems().setAll(risultati);
}


@FXML
public void handleBackDashboard(){
    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/HomeView.fxml"));
                Parent root = loader.load();

                HomeController homeController = loader.getController();
                homeController.setModelAut(modelAut);
                homeController.setStage(stage);
               

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Dashboard Bibliotecario");
                stage.show();

            } catch (Exception e) {

                 e.printStackTrace();
}      
}


}
