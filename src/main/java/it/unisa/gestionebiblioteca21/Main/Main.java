package it.unisa.gestionebiblioteca21.Main;

import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import it.unisa.gestionebiblioteca21.controller.LoginController;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;

import java.util.ArrayList;
import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Bibliotecario> utenti = new ArrayList<>();
        utenti.add(new Bibliotecario("fabrizio", "frizzi", "admin", "admin123"));

        Autenticazione modelAut = new Autenticazione(utenti);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();
        loginController.setModelAut(modelAut);   
        loginController.setStage(primaryStage);

        primaryStage.setTitle("Login Bibliotecario");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}