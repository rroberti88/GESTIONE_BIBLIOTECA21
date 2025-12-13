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

public class GestionePrestitiControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetListaPrestiti() {
        GestionePrestitiController controller = new GestionePrestitiController();
        ElencoPrestiti elenco = new ElencoPrestiti();

        assertThrows(NullPointerException.class, () -> {
            controller.setListaPrestiti(elenco);
    });
}


    @Test
    public void testSetCatalogo() throws Exception {
        GestionePrestitiController controller = new GestionePrestitiController();
        CatalogoLibri catalogo = new CatalogoLibri();

        controller.setCatalogo(catalogo);

        assertSame(catalogo, getPrivateField(controller, "catalogo"));
    }

    @Test
    public void testSetElencoUtenti() throws Exception {
        GestionePrestitiController controller = new GestionePrestitiController();
        ElencoUtenti elenco = new ElencoUtenti();

        controller.setElencoUtenti(elenco);

        assertSame(elenco, getPrivateField(controller, "elencoUtenti"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        GestionePrestitiController controller = new GestionePrestitiController();
        ArchivioDati archivio = new ArchivioDati();

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetModelAut() throws Exception {
        GestionePrestitiController controller = new GestionePrestitiController();
        Autenticazione aut = null;

        controller.setModelAut(aut);

        assertSame(aut, getPrivateField(controller, "autenticazione"));
    }

    @Test
    public void testSetStage() throws Exception {
        GestionePrestitiController controller = new GestionePrestitiController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }
}
