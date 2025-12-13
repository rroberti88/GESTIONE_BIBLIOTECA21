/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;

import java.util.ArrayList;
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
public class ElencoUtentiTest {
    
    public ElencoUtentiTest() {
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
     * Test of getListaUtenti method, of class ElencoUtenti.
     */
    @Test
    public void testGetListaUtenti() {
        System.out.println("getListaUtenti");
        ElencoUtenti instance = new ElencoUtenti();
        ArrayList<Utente> expResult = null;
        ArrayList<Utente> result = instance.getListaUtenti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserimentoUtente method, of class ElencoUtenti.
     */
    @Test
    public void testInserimentoUtente() {
        System.out.println("inserimentoUtente");
        Utente utente = null;
        ElencoUtenti instance = new ElencoUtenti();
        instance.inserimentoUtente(utente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellazioneUtente method, of class ElencoUtenti.
     */
    @Test
    public void testCancellazioneUtente() {
        System.out.println("cancellazioneUtente");
        Utente utente = null;
        ElencoUtenti instance = new ElencoUtenti();
        instance.cancellazioneUtente(utente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaUtente method, of class ElencoUtenti.
     */
    @Test
    public void testModificaUtente() {
        System.out.println("modificaUtente");
        Utente utenteOriginale = null;
        Utente utenteModificato = null;
        ElencoUtenti instance = new ElencoUtenti();
        instance.modificaUtente(utenteOriginale, utenteModificato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaUtente method, of class ElencoUtenti.
     */
    @Test
    public void testRicercaUtente() {
        System.out.println("ricercaUtente");
        String cognome = "";
        String nome = "";
        String matricola = "";
        ElencoUtenti instance = new ElencoUtenti();
        ArrayList<Utente> expResult = null;
        ArrayList<Utente> result = instance.ricercaUtente(cognome, nome, matricola);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exists method, of class ElencoUtenti.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        String matricola = "";
        ElencoUtenti instance = new ElencoUtenti();
        boolean expResult = false;
        boolean result = instance.exists(matricola);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaPerMatricola method, of class ElencoUtenti.
     */
    @Test
    public void testCercaPerMatricola() {
        System.out.println("cercaPerMatricola");
        String matricola = "";
        ElencoUtenti instance = new ElencoUtenti();
        Utente expResult = null;
        Utente result = instance.cercaPerMatricola(matricola);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
