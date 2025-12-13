/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.model.Autenticazione;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class HomeControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetModelAut() throws Exception {
        HomeController controller = new HomeController();
        Autenticazione aut = null;

        controller.setModelAut(aut);

        assertSame(aut, getPrivateField(controller, "autenticazione"));
    }

    @Test
    public void testSetStage() throws Exception {
        HomeController controller = new HomeController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }
}
