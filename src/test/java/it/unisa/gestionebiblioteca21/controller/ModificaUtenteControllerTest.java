/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.controller;

import it.unisa.gestionebiblioteca21.archivio.ArchivioDati;
import it.unisa.gestionebiblioteca21.model.ElencoUtenti;
import it.unisa.gestionebiblioteca21.model.Utente;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class ModificaUtenteControllerTest {

    private Object getPrivateField(Object target, String fieldName) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    public void testSetModel() throws Exception {
        ModificaUtenteController controller = new ModificaUtenteController();
        ElencoUtenti model = new ElencoUtenti();

        controller.setModel(model);

        assertSame(model, getPrivateField(controller, "model"));
    }

    @Test
    public void testSetArchivio() throws Exception {
        ModificaUtenteController controller = new ModificaUtenteController();
        ArchivioDati archivio = new ArchivioDati();

        controller.setArchivio(archivio);

        assertSame(archivio, getPrivateField(controller, "archivio"));
    }

    @Test
    public void testSetStage() throws Exception {
        ModificaUtenteController controller = new ModificaUtenteController();
        Stage stage = null;

        controller.setStage(stage);

        assertSame(stage, getPrivateField(controller, "stage"));
    }

    @Test
    public void testSetOnSalvato() throws Exception {
        ModificaUtenteController controller = new ModificaUtenteController();
        Runnable r = () -> {};

        controller.setOnSalvato(r);

        assertSame(r, getPrivateField(controller, "onSalvato"));
    }

    @Test
    public void testSetUtente() {
        ModificaUtenteController controller = new ModificaUtenteController();
        Utente utente = new Utente();

        assertThrows(NullPointerException.class, () -> {
            controller.setUtente(utente);
        });
    }
}
