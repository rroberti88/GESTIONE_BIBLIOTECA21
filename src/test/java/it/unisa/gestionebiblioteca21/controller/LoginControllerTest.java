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
 * @author cosim
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of setModelAut method, of class LoginController.
     */
    @Test
    public void testSetModelAut() {
        System.out.println("setModelAut");
        Autenticazione aut = null;
        LoginController instance = new LoginController();
        instance.setModelAut(aut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class LoginController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage stage = null;
        LoginController instance = new LoginController();
        instance.setStage(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class LoginController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati archivio = null;
        LoginController instance = new LoginController();
        instance.setArchivio(archivio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCatalogo method, of class LoginController.
     */
    @Test
    public void testSetCatalogo() {
        System.out.println("setCatalogo");
        CatalogoLibri catalogo = null;
        LoginController instance = new LoginController();
        instance.setCatalogo(catalogo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElencoUtenti method, of class LoginController.
     */
    @Test
    public void testSetElencoUtenti() {
        System.out.println("setElencoUtenti");
        ElencoUtenti elenco = null;
        LoginController instance = new LoginController();
        instance.setElencoUtenti(elenco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElencoPrestiti method, of class LoginController.
     */
    @Test
    public void testSetElencoPrestiti() {
        System.out.println("setElencoPrestiti");
        ElencoPrestiti elenco = null;
        LoginController instance = new LoginController();
        instance.setElencoPrestiti(elenco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
