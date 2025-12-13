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

public class PrestitoTest {

    private Prestito instance;

    public PrestitoTest() {
    }

   

    @BeforeEach
    public void setUp() {
        instance = new Prestito(
                "1234567890123",
                "MAT001",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 10),
                null
        );
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetLibro() {
        System.out.println("getLibro");
        assertEquals("1234567890123", instance.getLibro());
    }

    @Test
    public void testSetLibro() {
        System.out.println("setLibro");
        instance.setLibro("1111111111111");
        assertEquals("1111111111111", instance.getLibro());
    }

    @Test
    public void testGetUtente() {
        System.out.println("getUtente");
        assertEquals("MAT001", instance.getUtente());
    }

    @Test
    public void testSetUtente() {
        System.out.println("setUtente");
        instance.setUtente("MAT999");
        assertEquals("MAT999", instance.getUtente());
    }

    @Test
    public void testGetDataPrestito() {
        System.out.println("getDataPrestito");
        assertEquals(LocalDate.of(2025, 1, 1), instance.getDataPrestito());
    }

    @Test
    public void testSetDataPrestito() {
        System.out.println("setDataPrestito");
        LocalDate nuova = LocalDate.of(2025, 2, 2);
        instance.setDataPrestito(nuova);
        assertEquals(nuova, instance.getDataPrestito());
    }

    @Test
    public void testGetDataScadenza() {
        System.out.println("getDataScadenza");
        assertEquals(LocalDate.of(2025, 1, 10), instance.getDataScadenza());
    }

    @Test
    public void testSetDataScadenza() {
        System.out.println("setDataScadenza");
        LocalDate nuova = LocalDate.of(2025, 3, 3);
        instance.setDataScadenza(nuova);
        assertEquals(nuova, instance.getDataScadenza());
    }

    @Test
    public void testGetDataRestituzione() {
        System.out.println("getDataRestituzione");
        assertNull(instance.getDataRestituzione());
    }

    @Test
    public void testSetDataRestituzione() {
        System.out.println("setDataRestituzione");
        LocalDate restituzione = LocalDate.of(2025, 1, 5);
        instance.setDataRestituzione(restituzione);
        assertEquals(restituzione, instance.getDataRestituzione());
    }

    @Test
    public void testIsLent_trueSeDataRestituzioneNull() {
        System.out.println("isLent");
        instance.setDataRestituzione(null);
        assertTrue(instance.isLent());
    }

    @Test
    public void testIsLent_falseDataRestituzioneNonNull() {
        System.out.println("isLent");
        instance.setDataRestituzione(LocalDate.of(2025, 1, 5));
        assertFalse(instance.isLent());
    }

    @Test
    public void testIsOverdue_falseRestituito() {
        System.out.println("isOverdue");
        instance.setDataRestituzione(LocalDate.now());
        assertFalse(instance.isOverdue());
    }

    @Test
    public void testIsOverdue_falseNonScaduto() {
        System.out.println("isOverdue");
        instance.setDataRestituzione(null);
        instance.setDataScadenza(LocalDate.now().plusDays(5));
        assertFalse(instance.isOverdue());
    }

    @Test
    public void testIsOverdue_trueNonRestituitoDopoScadenza() {
        System.out.println("isOverdue");
        instance.setDataRestituzione(null);
        instance.setDataScadenza(LocalDate.now().minusDays(1));
        assertTrue(instance.isOverdue());
    }
}
