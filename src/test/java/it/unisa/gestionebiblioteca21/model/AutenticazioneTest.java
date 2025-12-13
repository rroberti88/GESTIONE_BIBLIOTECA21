/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;

import it.unisa.gestionebiblioteca21.actor.Bibliotecario;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutenticazioneTest {

    private Autenticazione instance;
    private ArrayList<Bibliotecario> utenti;
    private Bibliotecario b1;

    public AutenticazioneTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        utenti = new ArrayList<>();

        b1 = new Bibliotecario(
                "Fabrizio",
                "Frizzi",
                "admin",
                "admin123"
        );

        utenti.add(b1);
        instance = new Autenticazione(utenti);
    }

    @AfterEach
    public void tearDown() {
        utenti.clear();
        instance = null;
    }

    @Test
    public void testLoginSuccesso() {
        assertTrue(instance.login("admin", "admin123"));
    }

    @Test
    public void testLoginPasswordErrata() {
        assertFalse(instance.login("admin", "Admin123"));
    }

    @Test
    public void testLoginUtenteNonEsistente() {
        assertFalse(instance.login("fabrizio", "admin123"));
    }

    @Test
    public void testLogout() {
        assertTrue(instance.logout("admin"));
      
    }
}
