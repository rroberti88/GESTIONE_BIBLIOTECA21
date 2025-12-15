package it.unisa.gestionebiblioteca21.model;

import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CatalogoLibriTest {

    private CatalogoLibri instance;
    private Libro l1;
    private Libro l2;

    @BeforeEach
    public void setUp() {
        instance = new CatalogoLibri();

        l1 = new Libro(
                "9781234567890",
                "Programmazione Java",
                "Mario Rossi",
                2020,
                3
        );

        l2 = new Libro(
                "9780987654321",
                "Basi di Dati",
                "Luca Bianchi",
                2019,
                2
        );
    }

    @AfterEach
    public void tearDown() {
        instance = null;
        l1 = null;
        l2 = null;
    }

    @Test
    public void testGetListaLibri() {
        ArrayList<Libro> lista = instance.getListaLibri();
        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testInserimentoLibro_ok() {
        instance.inserimentoLibro(l1);
        assertEquals(1, instance.getListaLibri().size());
    }

    @Test
    public void testInserimentoLibro_campiVuoti() {
        Libro l = new Libro("", "", "", 2020, 1);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoLibro(l));
    }

    @Test
    public void testInserimentoLibro_isbnNonValido() {
        Libro l = new Libro("123", "Titolo", "Autore", 2020, 1);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoLibro(l));
    }

    @Test
    public void testInserimentoLibro_duplicato() {
        instance.inserimentoLibro(l1);
        assertThrows(IllegalArgumentException.class,
                () -> instance.inserimentoLibro(l1));
    }

    @Test
    public void testCancellazioneLibro() {
        instance.inserimentoLibro(l1);
        instance.cancellazioneLibro(l1);
        assertTrue(instance.getListaLibri().isEmpty());
    }

    @Test
    public void testModificaLibro_ok() {
        instance.inserimentoLibro(l1);

        Libro modificato = new Libro(
                l1.getISBN(),
                "Java Avanzato",
                "Mario Rossi",
                2021,
                4
        );

        instance.modificaLibro(l1, modificato);

        assertEquals("Java Avanzato", l1.getTitolo());
        assertEquals(4, l1.getCopieDisponibili());
    }

    @Test
    public void testModificaLibro_isbnNonValido() {
        instance.inserimentoLibro(l1);

        Libro modificato = new Libro(
                "123",
                "Java",
                "Autore",
                2020,
                1
        );

        assertThrows(IllegalArgumentException.class,
                () -> instance.modificaLibro(l1, modificato));
    }

    @Test
public void testRicercaLibroLiveSearch() {
    instance.inserimentoLibro(l1);
    instance.inserimentoLibro(l2);

    assertEquals(2, instance.ricercaLibro("", "", "").size());
    assertEquals(2, instance.ricercaLibro("Java", "", "").size());
    assertEquals(2, instance.ricercaLibro("", "Mario", "").size());
    assertEquals(2, instance.ricercaLibro("", "", "9780987654321").size());
}


    @Test
    public void testGetLibroperilnome() {
        instance.inserimentoLibro(l1);
        Libro trovato = instance.getLibroperilnome("Programmazione Java");
        assertNotNull(trovato);
        assertEquals(l1.getISBN(), trovato.getISBN());
    }

    @Test
    public void testGetLibroperilnome_nonTrovato() {
        assertThrows(IllegalArgumentException.class,
                () -> instance.getLibroperilnome("Libro Inesistente"));
    }

    @Test
    public void testCercaLibroPerISBN() {
        instance.inserimentoLibro(l1);
        Libro trovato = instance.cercaLibroPerISBN("9781234567890");
        assertNotNull(trovato);
    }

    @Test
    public void testGetLibroperISBN() {
        instance.inserimentoLibro(l2);
        Libro trovato = instance.getLibroperISBN("9780987654321");
        assertNotNull(trovato);
        assertEquals("Basi di Dati", trovato.getTitolo());
    }
}
