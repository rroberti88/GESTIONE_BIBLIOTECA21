/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cosim
 */
public class ModificaUtenteControllerTest {
    
    public ModificaUtenteControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setModel method, of class ModificaUtenteController.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        ElencoUtenti model = null;
        ModificaUtenteController instance = new ModificaUtenteController();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class ModificaUtenteController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati archivio = null;
        ModificaUtenteController instance = new ModificaUtenteController();
        instance.setArchivio(archivio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtente method, of class ModificaUtenteController.
     */
    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        Utente utente = null;
        ModificaUtenteController instance = new ModificaUtenteController();
        instance.setUtente(utente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class ModificaUtenteController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage stage = null;
        ModificaUtenteController instance = new ModificaUtenteController();
        instance.setStage(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnSalvato method, of class ModificaUtenteController.
     */
    @Test
    public void testSetOnSalvato() {
        System.out.println("setOnSalvato");
        Runnable onSalvato = null;
        ModificaUtenteController instance = new ModificaUtenteController();
        instance.setOnSalvato(onSalvato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
