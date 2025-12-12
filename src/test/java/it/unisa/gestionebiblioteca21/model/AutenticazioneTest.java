/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;

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
public class AutenticazioneTest {
    
    public AutenticazioneTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
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
     * Test of login method, of class Autenticazione.
     */
    @org.junit.jupiter.api.Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        Autenticazione instance = null;
        boolean expResult = false;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Autenticazione.
     */
    @org.junit.jupiter.api.Test
    public void testLogout() {
        System.out.println("logout");
        String username = "";
        Autenticazione instance = null;
        boolean expResult = false;
        boolean result = instance.logout(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaPassword method, of class Autenticazione.
     */
    @org.junit.jupiter.api.Test
    public void testModificaPassword() {
        System.out.println("modificaPassword");
        String username = "";
        String nuovaPassword = "";
        Autenticazione instance = null;
        boolean expResult = false;
        boolean result = instance.modificaPassword(username, nuovaPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reimpostaPassword method, of class Autenticazione.
     */
    @org.junit.jupiter.api.Test
    public void testReimpostaPassword() {
        System.out.println("reimpostaPassword");
        String username = "";
        String nuovaPassword = "";
        Autenticazione instance = null;
        boolean expResult = false;
        boolean result = instance.reimpostaPassword(username, nuovaPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
