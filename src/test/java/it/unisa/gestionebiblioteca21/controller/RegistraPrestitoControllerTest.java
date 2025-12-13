/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
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
public class RegistraPrestitoControllerTest {
    
    public RegistraPrestitoControllerTest() {
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
     * Test of setListaPrestiti method, of class RegistraPrestitoController.
     */
    @Test
    public void testSetListaPrestiti() {
        System.out.println("setListaPrestiti");
        ElencoPrestiti e = null;
        RegistraPrestitoController instance = new RegistraPrestitoController();
        instance.setListaPrestiti(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCatalogo method, of class RegistraPrestitoController.
     */
    @Test
    public void testSetCatalogo() {
        System.out.println("setCatalogo");
        CatalogoLibri c = null;
        RegistraPrestitoController instance = new RegistraPrestitoController();
        instance.setCatalogo(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElencoUtenti method, of class RegistraPrestitoController.
     */
    @Test
    public void testSetElencoUtenti() {
        System.out.println("setElencoUtenti");
        ElencoUtenti u = null;
        RegistraPrestitoController instance = new RegistraPrestitoController();
        instance.setElencoUtenti(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArchivio method, of class RegistraPrestitoController.
     */
    @Test
    public void testSetArchivio() {
        System.out.println("setArchivio");
        ArchivioDati a = null;
        RegistraPrestitoController instance = new RegistraPrestitoController();
        instance.setArchivio(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class RegistraPrestitoController.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage s = null;
        RegistraPrestitoController instance = new RegistraPrestitoController();
        instance.setStage(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
