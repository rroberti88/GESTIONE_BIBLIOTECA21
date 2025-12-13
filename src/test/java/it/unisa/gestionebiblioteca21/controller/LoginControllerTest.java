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

public class LoginControllerTest {

   
    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetModelAut() throws Exception {
        LoginController controller = new LoginController();
        Autenticazione aut = null;

        controller.setModelAut(aut);

        assertSame(aut, getPrivateField(controller, "autenticazione"));
    }

    @Test
    public void testSetStage() throws Exception {
        LoginController controller = new LoginController();
        Stage stage = null; 

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        LoginController controller = new LoginController();
        ArchivioDati archivio = new ArchivioDati();

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetCatalogo() throws Exception {
        LoginController controller = new LoginController();
        CatalogoLibri catalogo = new CatalogoLibri();

        controller.setCatalogo(catalogo);

        assertSame(catalogo, getPrivateField(controller, "catalogo"));
    }

    @Test
    public void testSetElencoUtenti() throws Exception {
        LoginController controller = new LoginController();
        ElencoUtenti elenco = new ElencoUtenti();

        controller.setElencoUtenti(elenco);

        assertSame(elenco, getPrivateField(controller, "elencoUtenti"));
    }

    @Test
    public void testSetElencoPrestiti() throws Exception {
        LoginController controller = new LoginController();
        ElencoPrestiti elenco = new ElencoPrestiti();

        controller.setElencoPrestiti(elenco);

        assertSame(elenco, getPrivateField(controller, "elencoPrestiti"));
    }
}
