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

        utenti.add(new Utente("0612709470", "Roberto", "Roberti", "r.roberti@studenti.unisa.it", 1));
        utenti.add(new Utente("0612709720", "Felice", "Iandoli", "f.iandoli@stuendi.unisa.it", 1));
        utenti.add(new Utente("0612708916", "Cosimo", "Rivellini", "c.rivellini@stuendi.unisa.it", 1));
        utenti.add(new Utente("0612709557", "Jacopo Pio", "RIcciardelli", "j.ricciardelli@stuendi.unisa.it", 1));
        utenti.add(new Utente("0612709468", "Mario", "Mele", "m.mele@stuendi.unisa.it", 0));

        libri.add(new Libro("1234567890123", "Pinocchio", "Carlo Collodi", 1988, 5));
        libri.add(new Libro("1234567890124", "IT", "Stephen King", 2019, 4));
        libri.add(new Libro("1234567890125", "La Sacra Bibbia", "Gutenberg", 2015, 12));
        libri.add(new Libro("1234567890126", "Ingegneria del Software", "I. Sommerville", 2023, 3));
        libri.add(new Libro("1234567890127", "Fahreneit 451", "Ray Bradbury", 2019, 7));
        
        prestiti.add(new Prestito(
                "1234567890124",
                "0612709470",
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                null
        ));
        prestiti.add(new Prestito(
                "1234567890125",
                "0612709720",
                LocalDate.now(),
                LocalDate.now().plusDays(25),
                null
        ));
        prestiti.add(new Prestito(
                "1234567890127",
                "0612708916",
                LocalDate.now(),
                LocalDate.now().plusDays(123),
                null
        ));
        prestiti.add(new Prestito(
                "1234567890126",
                "0612709557",
                LocalDate.now(),
                LocalDate.now().plusDays(12),
                null
        ));
        prestiti.add(new Prestito(
                "1234567890123",
                "0612709468",
                LocalDate.now(),
                LocalDate.now().plusDays(0),
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
        assertEquals(5, caricati.size());
    }

    @Test
    public void testCaricaLibri() {
        ArrayList<Libro> caricati = archivio.caricaLibri();

        assertNotNull(caricati);
        assertEquals(5, caricati.size());
    }

    @Test
    public void testCaricaPrestiti() {
        ArrayList<Prestito> caricati = archivio.caricaPrestiti();

        assertNotNull(caricati);
        assertEquals(5, caricati.size());
    }

    @Test
    public void testCaricaBibliotecari() {
        ArrayList<Bibliotecario> caricati = archivio.caricaBibliotecari();

        assertNotNull(caricati);
        assertEquals(1, caricati.size());
        assertEquals("admin", caricati.get(0).getUsername());
    }
}
