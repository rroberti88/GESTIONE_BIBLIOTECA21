/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.archivio;

import it.unisa.gestionebiblioteca21.model.Libro;
import it.unisa.gestionebiblioteca21.model.Prestito;
import it.unisa.gestionebiblioteca21.model.Utente;
import java.util.ArrayList;
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
public class ArchivioDatiTest {
    
    public ArchivioDatiTest() {
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
     * Test of salvaUtenti method, of class ArchivioDati.
     */
    @Test
    public void testSalvaUtenti() {
        System.out.println("salvaUtenti");
        ArrayList<Utente> utenti = null;
        ArchivioDati instance = new ArchivioDati();
        instance.salvaUtenti(utenti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaLibri method, of class ArchivioDati.
     */
    @Test
    public void testSalvaLibri() {
        System.out.println("salvaLibri");
        ArrayList<Libro> libri = null;
        ArchivioDati instance = new ArchivioDati();
        instance.salvaLibri(libri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaPrestiti method, of class ArchivioDati.
     */
    @Test
    public void testSalvaPrestiti() {
        System.out.println("salvaPrestiti");
        ArrayList<Prestito> prestiti = null;
        ArchivioDati instance = new ArchivioDati();
        instance.salvaPrestiti(prestiti);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caricaUtenti method, of class ArchivioDati.
     */
    @Test
    public void testCaricaUtenti() {
        System.out.println("caricaUtenti");
        ArchivioDati instance = new ArchivioDati();
        ArrayList<Utente> expResult = null;
        ArrayList<Utente> result = instance.caricaUtenti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caricaLibri method, of class ArchivioDati.
     */
    @Test
    public void testCaricaLibri() {
        System.out.println("caricaLibri");
        ArchivioDati instance = new ArchivioDati();
        ArrayList<Libro> expResult = null;
        ArrayList<Libro> result = instance.caricaLibri();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caricaPrestiti method, of class ArchivioDati.
     */
    @Test
    public void testCaricaPrestiti() {
        System.out.println("caricaPrestiti");
        ArchivioDati instance = new ArchivioDati();
        ArrayList<Prestito> expResult = null;
        ArrayList<Prestito> result = instance.caricaPrestiti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
