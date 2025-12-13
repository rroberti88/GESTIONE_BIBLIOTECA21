/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class UtenteTest {

    private Utente u;

    @BeforeEach
    public void setUp() {
        u = new Utente(
                "1234567890",
                "Mario",
                "Rossi",
                "test@mail.com",
                3
        );
    }

    @Test
    public void testGetMatricola() {
        System.out.println("getMatricola");
        assertEquals("1234567890", u.getMatricola());
    }

    @Test
    public void testSetMatricola() {
        System.out.println("setMatricola");
        u.setMatricola("0987654321");
        assertEquals("0987654321", u.getMatricola());
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        assertEquals("Mario", u.getNome());
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        u.setNome("Luca");
        assertEquals("Luca", u.getNome());
    }

    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        assertEquals("Rossi", u.getCognome());
    }

    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        u.setCognome("Bianchi");
        assertEquals("Bianchi", u.getCognome());
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertEquals("test@mail.com", u.getEmail());
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        u.setEmail("abc@mail.com");
        assertEquals("abc@mail.com", u.getEmail());
    }

    @Test
    public void testGetNumeroPrestiti() {
        System.out.println("getNumeroPrestiti");
        assertEquals(3, u.getNumeroPrestiti());
    }

    @Test
    public void testSetNumeroPrestiti() {
        System.out.println("setNumeroPrestiti");
        u.setNumeroPrestiti(5);
        assertEquals(5, u.getNumeroPrestiti());
    }

    @Test
    public void testIsValidTrue() {
        Utente x = new Utente();
        x.setMatricola("1234567890");
        x.setNome("Mario");
        x.setCognome("Rossi");
        x.setEmail("mario@mail.com");
        assertTrue(x.isValid());
    }

    @Test
    public void testIsValidFalseMatricola() {
        Utente x = new Utente();
        x.setMatricola("123");
        x.setNome("Mario");
        x.setCognome("Rossi");
        x.setEmail("mario@mail.com");
        assertFalse(x.isValid());
    }

    @Test
    public void testIsValidFalseEmail() {
        Utente x = new Utente();
        x.setMatricola("1234567890");
        x.setNome("Mario");
        x.setCognome("Rossi");
        x.setEmail("mariogmail.com");
        assertFalse(x.isValid());
    }
}
