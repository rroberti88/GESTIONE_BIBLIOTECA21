/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.Main;

import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import it.unisa.gestionebiblioteca21.controller.LoginController;
import it.unisa.gestionebiblioteca21.model.*;
import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private ArchivioDati archivio;
    private Autenticazione autenticazione;

    private CatalogoLibri catalogo;
    private ElencoUtenti elencoUtenti;
    private ElencoPrestiti elencoPrestiti;

    @Override
    public void start(Stage primaryStage) throws Exception {

        archivio = new ArchivioDati();

        ArrayList<Bibliotecario> bibliotecari = archivio.caricaBibliotecari();
        if (bibliotecari.isEmpty()) {
            bibliotecari.add(new Bibliotecario("admin", "admin", "admin", "1234"));
        }
        autenticazione = new Autenticazione(bibliotecari);

        catalogo = new CatalogoLibri(archivio.caricaLibri());
        elencoUtenti = new ElencoUtenti(archivio.caricaUtenti());
        elencoPrestiti = new ElencoPrestiti(archivio.caricaPrestiti());

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/it/unisa/gestionebiblioteca21/view/LoginView.fxml"));
        Parent root = loader.load();

        LoginController login = loader.getController();
        login.setStage(primaryStage);
        login.setModelAut(autenticazione);
        login.setArchivio(archivio);

        login.setCatalogo(catalogo);
        login.setElencoUtenti(elencoUtenti);
        login.setElencoPrestiti(elencoPrestiti);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Login Bibliotecario");
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            archivio.salvaBibliotecari(autenticazione.getBibliotecari());
            archivio.salvaLibri(catalogo.getListaLibri());
            archivio.salvaUtenti(elencoUtenti.getListaUtenti());
            archivio.salvaPrestiti(elencoPrestiti.getListaPrestiti());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
