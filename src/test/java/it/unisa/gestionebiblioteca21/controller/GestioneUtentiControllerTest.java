/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.*;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class GestioneUtentiControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetElencoUtenti() {
        GestioneUtentiController controller = new GestioneUtentiController();
        ElencoUtenti elenco = new ElencoUtenti();

        assertThrows(NullPointerException.class, () -> {
            controller.setElencoUtenti(elenco);
        });
    }

    @Test
    public void testSetCatalogo() throws Exception {
        GestioneUtentiController controller = new GestioneUtentiController();
        CatalogoLibri catalogo = new CatalogoLibri();

        controller.setCatalogo(catalogo);

        assertSame(catalogo, getPrivateField(controller, "catalogo"));
    }

    @Test
    public void testSetListaPrestiti() throws Exception {
        GestioneUtentiController controller = new GestioneUtentiController();
        ElencoPrestiti prestiti = new ElencoPrestiti();

        controller.setListaPrestiti(prestiti);

        assertSame(prestiti, getPrivateField(controller, "elencoPrestiti"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        GestioneUtentiController controller = new GestioneUtentiController();
        ArchivioDati archivio = new ArchivioDati();

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetModelAut() throws Exception {
        GestioneUtentiController controller = new GestioneUtentiController();
        Autenticazione aut = null;

        controller.setModelAut(aut);

        assertSame(aut, getPrivateField(controller, "autenticazione"));
    }

    @Test
    public void testSetStage() throws Exception {
        GestioneUtentiController controller = new GestioneUtentiController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }
}
