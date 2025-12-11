/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.gestionebiblioteca21.archivio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unisa.gestionebiblioteca21.model.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivioDati {

    private static final String FILE_UTENTI = "data/utenti.json";
    private static final String FILE_LIBRI = "data/libri.json";
    private static final String FILE_PRESTITI = "data/prestiti.json";

    private final Gson gson;

    public ArchivioDati() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        creaCartellaData();
    }

    private void creaCartellaData() {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdir();
    }


    public void salvaUtenti(ArrayList<Utente> utenti) {
        salva(FILE_UTENTI, utenti);
    }

    public void salvaLibri(ArrayList<Libro> libri) {
        salva(FILE_LIBRI, libri);
    }

    public void salvaPrestiti(ArrayList<Prestito> prestiti) {
        salva(FILE_PRESTITI, prestiti);
    }

    private <T> void salva(String path, T lista) {
        try (Writer w = new FileWriter(path)) {
            gson.toJson(lista, w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Utente> caricaUtenti() {
        Type type = new TypeToken<ArrayList<Utente>>() {}.getType();
        return carica(FILE_UTENTI, type);
    }

    public ArrayList<Libro> caricaLibri() {
        Type type = new TypeToken<ArrayList<Libro>>() {}.getType();
        return carica(FILE_LIBRI, type);
    }

    public ArrayList<Prestito> caricaPrestiti() {
        Type type = new TypeToken<ArrayList<Prestito>>() {}.getType();
        return carica(FILE_PRESTITI, type);
    }

    private <T> T carica(String path, Type type) {
        try (Reader r = new FileReader(path)) {
            return gson.fromJson(r, type);
        } catch (FileNotFoundException e) {
            return gson.fromJson("[]", type);
        } catch (Exception e) {
            e.printStackTrace();
            return gson.fromJson("[]", type);
        }
    }
}
