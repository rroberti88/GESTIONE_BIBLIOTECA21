/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.archivio;

import it.unisa.gestionebiblioteca21.model.Libro;
import it.unisa.gestionebiblioteca21.model.Prestito;
import it.unisa.gestionebiblioteca21.model.Utente;
import it.unisa.gestionebiblioteca21.actor.Bibliotecario;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivioDatiTest {

    private static ArchivioDati archivio;

    private static ArrayList<Utente> utenti;
    private static ArrayList<Libro> libri;
    private static ArrayList<Prestito> prestiti;
    private static ArrayList<Bibliotecario> bibliotecari;

    @BeforeAll
    public static void setUpClass() {

        archivio = new ArchivioDati();

        utenti = new ArrayList<>();
        libri = new ArrayList<>();
        prestiti = new ArrayList<>();
        bibliotecari = new ArrayList<>();

        utenti.add(new Utente("0612709470", "Mario", "Rossi", "mario@uni.it", 0));
        utenti.add(new Utente("0612709720", "Luca", "Bianchi", "luca@uni.it", 0));

        libri.add(new Libro("9781234567890", "Java", "Autore", 2020, 5));
        libri.add(new Libro("9780987654321", "DB", "Autore", 2019, 4));

        prestiti.add(new Prestito(
                "9781234567890",
                "U001",
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                null
        ));

        bibliotecari.add(new Bibliotecario("Admin", "Admin", "admin", "1234"));

        archivio.salvaUtenti(utenti);
        archivio.salvaLibri(libri);
        archivio.salvaPrestiti(prestiti);
        archivio.salvaBibliotecari(bibliotecari);
    }

    @Test
    public void testCaricaUtenti() {
        ArrayList<Utente> caricati = archivio.caricaUtenti();

        assertNotNull(caricati);
        assertEquals(2, caricati.size());
    }

    @Test
    public void testCaricaLibri() {
        ArrayList<Libro> caricati = archivio.caricaLibri();

        assertNotNull(caricati);
        assertEquals(2, caricati.size());
    }

    @Test
    public void testCaricaPrestiti() {
        ArrayList<Prestito> caricati = archivio.caricaPrestiti();

        assertNotNull(caricati);
        assertEquals(1, caricati.size());
    }

    @Test
    public void testCaricaBibliotecari() {
        ArrayList<Bibliotecario> caricati = archivio.caricaBibliotecari();

        assertNotNull(caricati);
        assertEquals(1, caricati.size());
        assertEquals("admin", caricati.get(0).getUsername());
    }
}
