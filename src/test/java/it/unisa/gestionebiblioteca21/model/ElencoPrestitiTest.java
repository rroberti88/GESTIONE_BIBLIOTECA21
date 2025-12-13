/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.gestionebiblioteca21.model;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElencoPrestitiTest {

    private ElencoPrestiti instance;
    private Libro libroOk;

    public ElencoPrestitiTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new ElencoPrestiti();
        libroOk = new Libro("9781234567890", "Titolo", "Autore", 2020, "Cat", 10, 2);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
        libroOk = null;
    }

    private Prestito prestitoAttivo(String isbn, String utente, LocalDate scadenza) {
        return new Prestito(isbn, utente, LocalDate.now(), scadenza, null);
    }

    private Prestito prestitoRestituito(String isbn, String utente, LocalDate scadenza) {
        return new Prestito(isbn, utente, LocalDate.now().minusDays(10), scadenza, LocalDate.now().minusDays(1));
    }

    @Test
    public void testRegistraPrestito_ok() {
        Prestito p = prestitoAttivo("9781234567890", "U001", LocalDate.now().plusDays(7));
        instance.registraPrestito(p, libroOk);

        assertEquals(1, instance.getListaPrestiti().size());
        assertEquals(1, libroOk.getCopieDisponibili());
    }

    @Test
    public void testRegistraPrestito_prestitoONull_lanciaEccezione() {
        assertThrows(IllegalArgumentException.class, () -> instance.registraPrestito(null, libroOk));

        Prestito p = prestitoAttivo("9781234567890", "U001", LocalDate.now().plusDays(7));
        assertThrows(IllegalArgumentException.class, () -> instance.registraPrestito(p, null));
    }

    @Test
    public void testLimiteTrePrestitiAttivi() {
        Libro l = new Libro("X", "T", "A", 2020, "C", 10, 10);

        instance.registraPrestito(prestitoAttivo("1", "U", LocalDate.now().plusDays(1)), l);
        instance.registraPrestito(prestitoAttivo("2", "U", LocalDate.now().plusDays(2)), l);
        instance.registraPrestito(prestitoAttivo("3", "U", LocalDate.now().plusDays(3)), l);

        assertThrows(IllegalStateException.class,() -> instance.registraPrestito(prestitoAttivo("4", "U", LocalDate.now().plusDays(4)), l));
    }

    @Test
    public void testPrestitiRestituitiNonContanoNelLimite() {
        Libro l = new Libro("X", "T", "A", 2020, "C", 10, 10);

        instance.getListaPrestiti().add(prestitoRestituito("1", "U", LocalDate.now().minusDays(3)));
        instance.getListaPrestiti().add(prestitoRestituito("2", "U", LocalDate.now().minusDays(2)));

        Prestito p = prestitoAttivo("3", "U", LocalDate.now().plusDays(5));
        instance.registraPrestito(p, l);

        assertEquals(3, instance.getListaPrestiti().size());
    }

    @Test
    public void testRegistraRestituzione_ok() {
        LocalDate scadenza = LocalDate.now().plusDays(7);
        Prestito p = prestitoAttivo("978", "U", scadenza);
        instance.getListaPrestiti().add(p);

        boolean result = instance.registraRestituzione("978", "U", scadenza);

        assertTrue(result);
        assertTrue(instance.getListaPrestiti().isEmpty());
    }

    @Test
    public void testRegistraRestituzione_falseSeNonTrova() {
        LocalDate scadenza = LocalDate.now().plusDays(7);
        Prestito p = prestitoAttivo("978", "U", scadenza);
        instance.getListaPrestiti().add(p);

        assertFalse(instance.registraRestituzione("978", "U", scadenza.plusDays(1)));
        assertEquals(1, instance.getListaPrestiti().size());
    }

    @Test
    public void testGetListaPrestiti() {
        ArrayList<Prestito> lista = instance.getListaPrestiti();
        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testRicercaPrestito_liveSearch_OR() {
        Prestito p1 = prestitoAttivo("AAA111", "MAT001", LocalDate.now().plusDays(1));
        Prestito p2 = prestitoAttivo("BBB222", "MAT002", LocalDate.now().plusDays(2));
        Prestito p3 = prestitoAttivo("CCC333", "ALTRO", LocalDate.now().plusDays(3));

        instance.getListaPrestiti().add(p1);
        instance.getListaPrestiti().add(p2);
        instance.getListaPrestiti().add(p3);

        assertEquals(3, instance.ricercaPrestito("", "").size());
        assertEquals(3, instance.ricercaPrestito("AAA", "").size());
        assertEquals(3, instance.ricercaPrestito("", "MAT").size());
        assertEquals(1, instance.ricercaPrestito("AAA", "___").size());
        assertEquals(1, instance.ricercaPrestito("___", "ALT").size());
    }

    @Test
    public void testCercaPrestitoISBNMatricola() {
        Prestito attivo = prestitoAttivo("978", "U", LocalDate.now().plusDays(7));
        instance.getListaPrestiti().add(prestitoRestituito("978", "U", LocalDate.now().minusDays(1)));
        instance.getListaPrestiti().add(attivo);

        assertSame(attivo, instance.cercaPrestitoISBNMatricola("978", "U"));
    }

    @Test
    public void testCancellazionePrestito() {
        Prestito p = prestitoAttivo("978", "U", LocalDate.now().plusDays(7));
        instance.getListaPrestiti().add(p);

        assertTrue(instance.cancellazionePrestito(p));
        assertFalse(instance.cancellazionePrestito(null));
    }

    @Test
    public void testCercaPrestitoConDataScadenza() {
        LocalDate scadenza = LocalDate.of(2025, 1, 10);
        Prestito p = prestitoAttivo("978", "U", scadenza);
        instance.getListaPrestiti().add(p);

        assertSame(p, instance.cercaPrestito("978", "U", scadenza));
        assertNull(instance.cercaPrestito("978", "U", scadenza.plusDays(1)));
    }
}
