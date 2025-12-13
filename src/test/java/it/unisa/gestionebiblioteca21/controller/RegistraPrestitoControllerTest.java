/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.CatalogoLibri;
import it.unisa.gestionebiblioteca21.model.ElencoPrestiti;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class RegistraPrestitoControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetListaPrestiti() throws Exception {
        RegistraPrestitoController controller = new RegistraPrestitoController();
        ElencoPrestiti elenco = new ElencoPrestiti();

        controller.setListaPrestiti(elenco);

        assertSame(elenco, getPrivateField(controller, "elencoPrestiti"));
    }

    @Test
    public void testSetCatalogo() throws Exception {
        RegistraPrestitoController controller = new RegistraPrestitoController();
        CatalogoLibri catalogo = new CatalogoLibri();

        controller.setCatalogo(catalogo);

        assertSame(catalogo, getPrivateField(controller, "catalogo"));
    }

    @Test
    public void testSetElencoUtenti() throws Exception {
        RegistraPrestitoController controller = new RegistraPrestitoController();
        ElencoUtenti utenti = new ElencoUtenti();

        controller.setElencoUtenti(utenti);

        assertSame(utenti, getPrivateField(controller, "elencoUtenti"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        RegistraPrestitoController controller = new RegistraPrestitoController();
        ArchivioDati archivio = new ArchivioDati();

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetStage() throws Exception {
        RegistraPrestitoController controller = new RegistraPrestitoController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }
}
