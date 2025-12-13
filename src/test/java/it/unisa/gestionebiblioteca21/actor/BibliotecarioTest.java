/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.actor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecarioTest {

    private Bibliotecario instance;

    public BibliotecarioTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Bibliotecario("Fabrizio", "Frizzi", "admin", "admin123");
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        assertEquals("Fabrizio", instance.getNome());
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        instance.setNome("Luca");
        assertEquals("Luca", instance.getNome());
    }

    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        assertEquals("Frizzi", instance.getCognome());
    }

    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        instance.setCognome("Bianchi");
        assertEquals("Bianchi", instance.getCognome());
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        assertEquals("admin", instance.getUsername());
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        instance.setUsername("ff");
        assertEquals("ff", instance.getUsername());
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        assertEquals("admin123", instance.getPassword());
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        instance.setPassword("11");
        assertEquals("11", instance.getPassword());
    }
}

