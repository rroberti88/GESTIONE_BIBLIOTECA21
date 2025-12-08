/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import it.unisa.gestionebiblioteca21.view.HomeView;

/**
 *
 * @author Felice Iandoli
 */
public class HomeController {

    private Autenticazione model;
    private HomeView view;

    public HomeController (Autenticazione model, HomeView view){
    this.model = model;
    this.view = view;
}

    public void Login (String username, String password){
    if (model.login(username, password) == true )
{
    view.mostraDashboard(username);
}
    else {
    view.mostraErrore("Credenziali non valide");
}
}
    public void Logout(){
    view.mostraLogin();
}
}
