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
public class CatalogoLibriTest {
    
    public CatalogoLibriTest() {
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
     * Test of getListaLibri method, of class CatalogoLibri.
     */
    @Test
    public void testGetListaLibri() {
        System.out.println("getListaLibri");
        CatalogoLibri instance = new CatalogoLibri();
        ArrayList<Libro> expResult = null;
        ArrayList<Libro> result = instance.getListaLibri();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserimentoLibro method, of class CatalogoLibri.
     */
    @Test
    public void testInserimentoLibro() {
        System.out.println("inserimentoLibro");
        Libro libro = null;
        CatalogoLibri instance = new CatalogoLibri();
        instance.inserimentoLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancellazioneLibro method, of class CatalogoLibri.
     */
    @Test
    public void testCancellazioneLibro() {
        System.out.println("cancellazioneLibro");
        Libro libro = null;
        CatalogoLibri instance = new CatalogoLibri();
        instance.cancellazioneLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaLibro method, of class CatalogoLibri.
     */
    @Test
    public void testModificaLibro() {
        System.out.println("modificaLibro");
        Libro libroOriginale = null;
        Libro libroModificato = null;
        CatalogoLibri instance = new CatalogoLibri();
        instance.modificaLibro(libroOriginale, libroModificato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ricercaLibro method, of class CatalogoLibri.
     */
    @Test
    public void testRicercaLibro() {
        System.out.println("ricercaLibro");
        String titolo = "";
        String autore = "";
        String ISBN = "";
        CatalogoLibri instance = new CatalogoLibri();
        ArrayList<Libro> expResult = null;
        ArrayList<Libro> result = instance.ricercaLibro(titolo, autore, ISBN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibroperilnome method, of class CatalogoLibri.
     */
    @Test
    public void testGetLibroperilnome() {
        System.out.println("getLibroperilnome");
        String nome = "";
        CatalogoLibri instance = new CatalogoLibri();
        Libro expResult = null;
        Libro result = instance.getLibroperilnome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaLibroPerISBN method, of class CatalogoLibri.
     */
    @Test
    public void testCercaLibroPerISBN() {
        System.out.println("cercaLibroPerISBN");
        String isbn = "";
        CatalogoLibri instance = new CatalogoLibri();
        Libro expResult = null;
        Libro result = instance.cercaLibroPerISBN(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibroperISBN method, of class CatalogoLibri.
     */
    @Test
    public void testGetLibroperISBN() {
        System.out.println("getLibroperISBN");
        String isbn = "";
        CatalogoLibri instance = new CatalogoLibri();
        Libro expResult = null;
        Libro result = instance.getLibroperISBN(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
