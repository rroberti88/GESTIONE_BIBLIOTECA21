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
                "9781234567890",   
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
        String expResult = "9781234567890";
        String result = instance.getISBN();
        assertEquals(expResult, result);
    }

  
    @Test
    public void testSetISBN() {
        System.out.println("setISBN");
        String ISBN = "1234567890123";
        instance.setISBN(ISBN);
        assertEquals(ISBN, instance.getISBN());
    }

    
    @Test
    public void testGetTitolo() {
        System.out.println("getTitolo");
        String expResult = "Il Nome della Rosa";
        String result = instance.getTitolo();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetTitolo() {
        System.out.println("setTitolo");
        String titolo = "Titolo nuovo";
        instance.setTitolo(titolo);
        assertEquals(titolo, instance.getTitolo());
    }

    
    @Test
    public void testGetAutore() {
        System.out.println("getAutore");
        String expResult = "Umberto Eco";
        String result = instance.getAutore();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testSetAutore() {
        System.out.println("setAutore");
        String autore = "Autore nuovo";
        instance.setAutore(autore);
        assertEquals(autore, instance.getAutore());
    }

    
    @Test
    public void testGetAnnoPubblicazione() {
        System.out.println("getAnnoPubblicazione");
        int expResult = 1980;
        int result = instance.getAnnoPubblicazione();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetAnnoPubblicazione() {
        System.out.println("setAnnoPubblicazione");
        int annoPubblicazione = 2020;
        instance.setAnnoPubblicazione(annoPubblicazione);
        assertEquals(annoPubblicazione, instance.getAnnoPubblicazione());
    }

   
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        String expResult = "Narrativa";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        String categoria = "Saggio";
        instance.setCategoria(categoria);
        assertEquals(categoria, instance.getCategoria());
    }

    
    @Test
    public void testGetCopieTotali() {
        System.out.println("getCopieTotali");
        int expResult = 10;
        int result = instance.getCopieTotali();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetCopieTotali() {
        System.out.println("setCopieTotali");
        int copieTotali = 20;
        instance.setCopieTotali(copieTotali);
        assertEquals(copieTotali, instance.getCopieTotali());
    }

    
    @Test
    public void testGetCopieDisponibili() {
        System.out.println("getCopieDisponibili");
        int expResult = 5;
        int result = instance.getCopieDisponibili();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetCopieDisponibili() {
        System.out.println("setCopieDisponibili");
        int copieDisponibili = 7;
        instance.setCopieDisponibili(copieDisponibili);
        assertEquals(copieDisponibili, instance.getCopieDisponibili());
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
