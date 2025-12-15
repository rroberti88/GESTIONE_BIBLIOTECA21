/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import java.util.ArrayList;

/**
 * @class Autenticazione
 * @brief Gestisce l'autenticazione dei bibliotecari del sistema.
 *
 * Questa classe fornisce i metodi per:
 * - effettuare il login dei bibliotecari
 * - reimpostare la password in caso di smarrimento
 * - recuperare la lista dei bibliotecari autorizzati
 *
 * La classe opera su una lista di oggetti {@link Bibliotecario}
 * caricata all'avvio dell'applicazione.
 */
public class Autenticazione {

    /**
     * Lista dei bibliotecari autorizzati ad accedere al sistema.
     */
    private final ArrayList<Bibliotecario> utentiAutorizzati;

    /**
     * Costruttore della classe Autenticazione.
     *
     * @param utentiAutorizzati lista dei bibliotecari autorizzati
     */
    public Autenticazione(ArrayList<Bibliotecario> utentiAutorizzati) {
        this.utentiAutorizzati = utentiAutorizzati;
    }

    /**
     * Effettua il login di un bibliotecario.
     *
     * @param username username del bibliotecario
     * @param password password del bibliotecario
     * @return true se le credenziali sono corrette, false altrimenti
     */
    public boolean login(String username, String password) {
        for (Bibliotecario b : utentiAutorizzati) {
            if (b.getUsername().equals(username)
                    && b.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reimposta la password di un bibliotecario dato il suo username.
     *
     * @param username username del bibliotecario
     * @param nuovaPassword nuova password da impostare
     * @return true se la password è stata modificata con successo,
     *         false se lo username non esiste
     */
    public boolean resetPassword(String username, String nuovaPassword) {
        for (Bibliotecario b : utentiAutorizzati) {
            if (b.getUsername().equals(username)) {
                b.setPassword(nuovaPassword);
                return true;
            }
        }
        return false;
    }

    /**
     * Restituisce la lista dei bibliotecari autorizzati.
     *
     * @return lista dei bibliotecari
     */
    public ArrayList<Bibliotecario> getBibliotecari() {
        return utentiAutorizzati;
    }

    /**
     * Effettua il logout del bibliotecario.
     *
     * Attualmente il metodo non contiene logica specifica,
     * ma è previsto per eventuali estensioni future
     * (gestione sessioni, logging, ecc.).
     *
     * @param username username del bibliotecario
     * @return true (logout completato)
     */
    public boolean logout(String username) {
        return true;
    }
}

