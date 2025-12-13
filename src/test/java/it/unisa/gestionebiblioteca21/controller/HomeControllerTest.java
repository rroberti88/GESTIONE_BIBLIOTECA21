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
public class HomeControllerTest {
    
    public HomeControllerTest() {
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
     * Test of setCatalogo method, of class HomeController.
     */
    @Test
    public void testSetCatalogo() {
        System.out.println("setCatalogo");
        CatalogoLibri c = null;
        HomeController instance = new HomeController();
        instance.setCatalogo(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElencoUtenti method, of class HomeController.
     */
    @Test
    public void testSetElencoUtenti() {
        System.out.println("setElencoUtenti");
        ElencoUtenti e = null;
        HomeController instance = new HomeController();
        instance.setElencoUtenti(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPrestiti method, of class HomeController.
     */
    @Test
    public void testSetListaPrestiti() {
        System.out.println("setListaPrestiti");
        ElencoPrestiti p = null;
        HomeController instance = new HomeController();
        instance.setListaPrestiti(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModelAut method, of class HomeController.
     */
    @Test
    public void testSetModelAut() {
        System.out.println("setModelAut");
        Autenticazione a = null;
        HomeController instance = new HomeController();
        instance.setModelAut(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class HomeController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati ar = null;
        HomeController instance = new HomeController();
        instance.setArchivio(ar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class HomeController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage stage = null;
        HomeController instance = new HomeController();
        instance.setStage(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
