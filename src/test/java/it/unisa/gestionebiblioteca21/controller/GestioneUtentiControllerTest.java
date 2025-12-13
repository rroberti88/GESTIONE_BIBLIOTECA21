/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.Autenticazione;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Felice Iandoli
 */
public class GestioneUtentiControllerTest {
    
    public GestioneUtentiControllerTest() {
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
     * Test of setElencoUtenti method, of class GestioneUtentiController.
     */
    @Test
    public void testSetElencoUtenti() {
        System.out.println("setElencoUtenti");
        ElencoUtenti elenco = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setElencoUtenti(elenco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCatalogo method, of class GestioneUtentiController.
     */
    @Test
    public void testSetCatalogo() {
        System.out.println("setCatalogo");
        CatalogoLibri c = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setCatalogo(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPrestiti method, of class GestioneUtentiController.
     */
    @Test
    public void testSetListaPrestiti() {
        System.out.println("setListaPrestiti");
        ElencoPrestiti p = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setListaPrestiti(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class GestioneUtentiController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati archivio = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setArchivio(archivio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModelAut method, of class GestioneUtentiController.
     */
    @Test
    public void testSetModelAut() {
        System.out.println("setModelAut");
        Autenticazione modelAut = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setModelAut(modelAut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class GestioneUtentiController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage stage = null;
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.setStage(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class GestioneUtentiController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleInserimentoUtente method, of class GestioneUtentiController.
     */
    @Test
    public void testHandleInserimentoUtente() {
        System.out.println("handleInserimentoUtente");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.handleInserimentoUtente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleModificaUtente method, of class GestioneUtentiController.
     */
    @Test
    public void testHandleModificaUtente() {
        System.out.println("handleModificaUtente");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.handleModificaUtente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleCancellazioneUtente method, of class GestioneUtentiController.
     */
    @Test
    public void testHandleCancellazioneUtente() {
        System.out.println("handleCancellazioneUtente");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.handleCancellazioneUtente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRicercaUtente method, of class GestioneUtentiController.
     */
    @Test
    public void testHandleRicercaUtente() {
        System.out.println("handleRicercaUtente");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.handleRicercaUtente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleBackDashboard method, of class GestioneUtentiController.
     */
    @Test
    public void testHandleBackDashboard() {
        System.out.println("handleBackDashboard");
        GestioneUtentiController instance = new GestioneUtentiController();
        instance.handleBackDashboard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
