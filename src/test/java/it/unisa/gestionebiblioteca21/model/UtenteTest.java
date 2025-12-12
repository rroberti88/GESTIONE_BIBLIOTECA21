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

public class UtenteTest {

    @Test
    public void testGetMatricola() {
        Utente u = new Utente();
        u.setMatricola("1234567890");
        assertEquals("1234567890", u.getMatricola());
    }

    @Test
    public void testSetMatricola() {
        Utente u = new Utente();
        u.setMatricola("0987654321");
        assertEquals("0987654321", u.getMatricola());
    }

    @Test
    public void testGetNome() {
        Utente u = new Utente();
        u.setNome("Mario");
        assertEquals("Mario", u.getNome());
    }

    @Test
    public void testSetNome() {
        Utente u = new Utente();
        u.setNome("Luca");
        assertEquals("Luca", u.getNome());
    }

    @Test
    public void testGetCognome() {
        Utente u = new Utente();
        u.setCognome("Rossi");
        assertEquals("Rossi", u.getCognome());
    }

    @Test
    public void testSetCognome() {
        Utente u = new Utente();
        u.setCognome("Bianchi");
        assertEquals("Bianchi", u.getCognome());
    }

    @Test
    public void testGetEmail() {
        Utente u = new Utente();
        u.setEmail("test@mail.com");
        assertEquals("test@mail.com", u.getEmail());
    }

    @Test
    public void testSetEmail() {
        Utente u = new Utente();
        u.setEmail("abc@mail.com");
        assertEquals("abc@mail.com", u.getEmail());
    }

    @Test
    public void testGetNumeroPrestiti() {
        Utente u = new Utente();
        u.setNumeroPrestiti(3);
        assertEquals(3, u.getNumeroPrestiti());
    }

    @Test
    public void testSetNumeroPrestiti() {
        Utente u = new Utente();
        u.setNumeroPrestiti(5);
        assertEquals(5, u.getNumeroPrestiti());
    }

    @Test
    public void testIsValidTrue() {
        Utente u = new Utente();
        u.setMatricola("1234567890");
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEmail("mario@mail.com");
        assertTrue(u.isValid());
    }

    @Test
    public void testIsValidFalse() {
        Utente u = new Utente();
        u.setMatricola("123"); 
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEmail("mario@mail.com");
        assertFalse(u.isValid());
    }
}