/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class InserimentoUtenteControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetModel() throws Exception {
        InserimentoUtenteController controller = new InserimentoUtenteController();
        ElencoUtenti model = new ElencoUtenti();

        controller.setModel(model);

        assertSame(model, getPrivateField(controller, "modelUt"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        InserimentoUtenteController controller = new InserimentoUtenteController();
        ArchivioDati archivio = null;

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetStage() throws Exception {
        InserimentoUtenteController controller = new InserimentoUtenteController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }
}
