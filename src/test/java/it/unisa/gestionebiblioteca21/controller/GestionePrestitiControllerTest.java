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
public class GestionePrestitiControllerTest {
    
    public GestionePrestitiControllerTest() {
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
     * Test of setListaPrestiti method, of class GestionePrestitiController.
     */
    @Test
    public void testSetListaPrestiti() {
        System.out.println("setListaPrestiti");
        ElencoPrestiti e = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setListaPrestiti(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCatalogo method, of class GestionePrestitiController.
     */
    @Test
    public void testSetCatalogo() {
        System.out.println("setCatalogo");
        CatalogoLibri c = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setCatalogo(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElencoUtenti method, of class GestionePrestitiController.
     */
    @Test
    public void testSetElencoUtenti() {
        System.out.println("setElencoUtenti");
        ElencoUtenti u = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setElencoUtenti(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class GestionePrestitiController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati a = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setArchivio(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModelAut method, of class GestionePrestitiController.
     */
    @Test
    public void testSetModelAut() {
        System.out.println("setModelAut");
        Autenticazione a = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setModelAut(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class GestionePrestitiController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage s = null;
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.setStage(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class GestionePrestitiController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRegistraPrestito method, of class GestionePrestitiController.
     */
    @Test
    public void testHandleRegistraPrestito() {
        System.out.println("handleRegistraPrestito");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.handleRegistraPrestito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRegistraRestituzione method, of class GestionePrestitiController.
     */
    @Test
    public void testHandleRegistraRestituzione() {
        System.out.println("handleRegistraRestituzione");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.handleRegistraRestituzione();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleCancellazionePrestito method, of class GestionePrestitiController.
     */
    @Test
    public void testHandleCancellazionePrestito() {
        System.out.println("handleCancellazionePrestito");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.handleCancellazionePrestito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRicercaPrestito method, of class GestionePrestitiController.
     */
    @Test
    public void testHandleRicercaPrestito() {
        System.out.println("handleRicercaPrestito");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.handleRicercaPrestito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleBackDashboard method, of class GestionePrestitiController.
     */
    @Test
    public void testHandleBackDashboard() {
        System.out.println("handleBackDashboard");
        GestionePrestitiController instance = new GestionePrestitiController();
        instance.handleBackDashboard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
