/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    private Libro instance;

    public LibroTest() {
    }


    @BeforeEach
    public void setUp() {
        
        instance = new Libro(
                "1234567890123",   
                "Il Nome della Rosa",
                "Umberto Eco",
                1980,
                "Narrativa",
                10,
                5
        );
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        assertEquals("1234567890123", instance.getISBN());
    }

  
    @Test
    public void testSetISBN() {
        System.out.println("setISBN");
        instance.setISBN("1234567890124");
        assertEquals("1234567890124", instance.getISBN());
    }

    
    @Test
    public void testGetTitolo() {
        System.out.println("getTitolo");
        assertEquals("Il Nome della Rosa", instance.getTitolo());
    }

    
    @Test
    public void testSetTitolo() {
        System.out.println("setTitolo");
        instance.setTitolo("Titolo nuovo");
        assertEquals("Titolo nuovo", instance.getTitolo());
    }

    
    @Test
    public void testGetAutore() {
        System.out.println("getAutore");
        assertEquals("Umberto Eco", instance.getAutore());
    }

   
    @Test
    public void testSetAutore() {
        System.out.println("setAutore");
        instance.setAutore("Autore nuovo");
        assertEquals("Autore nuovo", instance.getAutore());
    }

    
    @Test
    public void testGetAnnoPubblicazione() {
        System.out.println("getAnnoPubblicazione");
        assertEquals(1980, instance.getAnnoPubblicazione());
    }

    
    @Test
    public void testSetAnnoPubblicazione() {
        System.out.println("setAnnoPubblicazione");
        instance.setAnnoPubblicazione(2020);
        assertEquals(2020, instance.getAnnoPubblicazione());
    }

   
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        assertEquals("Narrativa", instance.getCategoria());
    }

    
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        instance.setCategoria("Saggio");
        assertEquals("Saggio", instance.getCategoria());
    }

    
    @Test
    public void testGetCopieTotali() {
        System.out.println("getCopieTotali");
        assertEquals(10, instance.getCopieTotali());
    }

    
    @Test
    public void testSetCopieTotali() {
        System.out.println("setCopieTotali");
        instance.setCopieTotali(20);
        assertEquals(20, instance.getCopieTotali());
    }

    
    @Test
    public void testGetCopieDisponibili() {
        System.out.println("getCopieDisponibili");
        assertEquals(5, instance.getCopieDisponibili());
    }

    
    @Test
    public void testSetCopieDisponibili() {
        System.out.println("setCopieDisponibili");
        instance.setCopieDisponibili(7);
        assertEquals(7, instance.getCopieDisponibili());
    }

   
    @Test
    public void testIsValid() {
        System.out.println("isValid");

        assertTrue(instance.isValid());

        instance.setISBN("123");
        assertFalse(instance.isValid());

        setUp();
        instance.setTitolo(null);
        assertFalse(instance.isValid());

        setUp();
        instance.setAutore(null);
        assertFalse(instance.isValid());

        setUp();
        instance.setAnnoPubblicazione(0);
        assertFalse(instance.isValid());

        
        setUp();
        instance.setCopieTotali(0);
        assertFalse(instance.isValid());

        setUp();
        instance.setCopieDisponibili(0); 
        assertFalse(instance.isValid());
    }
}
