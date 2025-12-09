/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.Libro;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
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
public class GestioneCatalogoController {
private CatalogoLibri catalogo;
private Autenticazione modelAut;
private Stage stage; 

@FXML private TextField txtRicercaLibro;
@FXML private TableView<Libro> tableview;
@FXML private TableColumn<Libro, String> colTitolo;
@FXML private TableColumn<Libro, String> colAutore;
@FXML private TableColumn<Libro, Integer> colAnnoDiEdizione;
@FXML private TableColumn<Libro, String> colIsbn;
@FXML private TableColumn<Libro, Integer> colCopieDisponibili;
@FXML private Button btnDashboard;
@FXML private Button btnModificaLibro;
@FXML private Button btnInserimentoLibro;
@FXML private Button btnCancellazioneLibro;


public GestioneCatalogoController () {}

public void setCatalogo (CatalogoLibri catalogo){
this.catalogo = catalogo;
aggiornaTableView();
}
public void setModelAut(Autenticazione modelAut){
    this.modelAut = modelAut;
}

public void setStage(Stage stage) {
this.stage = stage;
}

@FXML
public void initialize() {
    colTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
    colAutore.setCellValueFactory(new PropertyValueFactory<>("autore"));
    colAnnoDiEdizione.setCellValueFactory(new PropertyValueFactory<>("annoPubblicazione"));
    colIsbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
    colCopieDisponibili.setCellValueFactory(new PropertyValueFactory<>("copieDisponibili"));
    
    
}
private void aggiornaTableView(){
    if (catalogo != null) {
        tableview.getItems().setAll(catalogo.getListaLibri());
    }
}

@FXML
public void handleInserimentoLibro(){
     try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/InserimentoLibroView.fxml"));
        Parent root = loader.load();

        InserimentoLibroController inserimentoLibroController = loader.getController();
        inserimentoLibroController.setCatalogo(catalogo);

        Stage popupStage = new Stage();
        inserimentoLibroController.setStage(popupStage);
        popupStage.setScene(new Scene(root));
        popupStage.setTitle("Inserimento Nuovo Libro");
        popupStage.initOwner(stage); 
        popupStage.showAndWait();   

        
        aggiornaTableView();

            } catch (Exception e) {

}  
}

@FXML
public void handleModificaLibro(){
    
}

@FXML
public void handleCancellazioneLibro(){
   
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

}      
}

}
