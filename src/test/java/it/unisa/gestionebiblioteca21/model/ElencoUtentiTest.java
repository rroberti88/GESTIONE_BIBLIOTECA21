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


public class ElencoUtentiTest {

    private ElencoUtenti instance;
    private Utente u1;
    private Utente u2;

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
        instance = new ElencoUtenti();

        u1 = new Utente("1234567890", "Mario", "Rossi", "mario@mail.com", 0);
        u2 = new Utente("0987654321", "Luca", "Bianchi", "luca@mail.com", 0);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
        u1 = null;
        u2 = null;
    }

    @Test
    public void testGetListaUtenti() {
        ArrayList<Utente> lista = instance.getListaUtenti();
        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testInserimentoUtente_ok() {
        instance.inserimentoUtente(u1);
        assertEquals(1, instance.getListaUtenti().size());
    }

    @Test
    public void testInserimentoUtente_campiVuoti() {
        Utente u = new Utente("", "", "", "", 0);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoUtente(u));
    }

    @Test
    public void testInserimentoUtente_emailNonValida() {
        Utente u = new Utente("1111111111", "Anna", "Verdi", "annamail.com", 0);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoUtente(u));
    }

    @Test
    public void testInserimentoUtente_duplicato() {
        instance.inserimentoUtente(u1);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoUtente(u1));
    }

    @Test
    public void testCancellazioneUtente() {
        instance.inserimentoUtente(u1);
        instance.cancellazioneUtente(u1);
        assertTrue(instance.getListaUtenti().isEmpty());
    }

    @Test
    public void testCancellazioneUtente_null() {
        instance.inserimentoUtente(u1);
        instance.cancellazioneUtente(null);
        assertEquals(1, instance.getListaUtenti().size());
    }

    @Test
    public void testModificaUtente_ok() {
        instance.inserimentoUtente(u1);

        Utente modificato = new Utente(
                u1.getMatricola(),
                "Marco",
                "Neri",
                "marco@mail.com",
                0
        );

        instance.modificaUtente(u1, modificato);

        assertEquals("Marco", u1.getNome());
        assertEquals("Neri", u1.getCognome());
        assertEquals("marco@mail.com", u1.getEmail());
    }

    @Test
    public void testModificaUtente_emailNonValida() {
        instance.inserimentoUtente(u1);

        Utente modificato = new Utente(
                u1.getMatricola(),
                "Marco",
                "Neri",
                "marcomail.com",
                0
        );

        assertThrows(IllegalArgumentException.class,
                () -> instance.modificaUtente(u1, modificato));
    }

 @Test
public void testRicercaUtenteLiveSearch() {
    instance.inserimentoUtente(u1);
    instance.inserimentoUtente(u2);

    assertEquals(2, instance.ricercaUtente("", "", "").size());
    assertEquals(2, instance.ricercaUtente("Rossi", "", "").size());
    assertEquals(2, instance.ricercaUtente("", "Luca", "").size());

    assertEquals(1, instance.ricercaUtente("Rossi", "___", "___").size());
    assertEquals(1, instance.ricercaUtente("___", "Luca", "___").size());
    assertEquals(1, instance.ricercaUtente("___", "___", "1234567890").size());
}

    @Test
    public void testExists() {
        instance.inserimentoUtente(u1);
        assertTrue(instance.exists("1234567890"));
        assertFalse(instance.exists("0000000000"));
    }

    @Test
    public void testCercaPerMatricola() {
        instance.inserimentoUtente(u1);
        Utente trovato = instance.cercaPerMatricola("1234567890");
        assertNotNull(trovato);
        assertEquals("Mario", trovato.getNome());
    }

    @Test
    public void testCercaPerMatricola_null() {
        assertNull(instance.cercaPerMatricola(null));
        assertNull(instance.cercaPerMatricola(""));
    }
}
