/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.gestionebiblioteca21.Main;

import it.unisa.gestionebiblioteca21.model.Autenticazione;
import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creiamo utenti di test
        ArrayList<Bibliotecario> utenti = new ArrayList<>();
        utenti.add(new Bibliotecario("fabrizio","frizzi","admin", "admin123"));

        // Model
        Autenticazione model = new Autenticazione(utenti);

        // Carichiamo FXML login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
        Parent root = loader.load();

        // Controller
        it.unisa.gestionebiblioteca21.controller.LoginController controller = loader.getController();
        controller.setModel(model);
        controller.setStage(primaryStage);

        // Scene
        primaryStage.setTitle("Login Bibliotecario");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}