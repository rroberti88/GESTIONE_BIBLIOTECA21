package it.unisa.gestionebiblioteca21.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unisa.gestionebiblioteca21.model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Archivio {


    private static final String CARTELLA_DATI = System.getProperty("utente.home") + "/GestioneBiblioteca";
    private static final String FILE_LIBRI = "libri.json";
    private static final String FILE_UTENTI = "utenti.json";
    private static final String FILE_PRESTITI = "prestiti.json";

    private static final Gson gson = new Gson();

    public static void salvaLibri(CatalogoLibri catalogo) {
        try (FileWriter writer = new FileWriter(FILE_LIBRI)) {
            gson.toJson(catalogo.getListaLibri(), writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvaUtenti(ElencoUtenti elencoUtenti) {
        try (FileWriter writer = new FileWriter(FILE_UTENTI)) {
            gson.toJson(elencoUtenti.getListaUtenti(), writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvaPrestiti(ElencoPrestiti elencoPrestiti) {
        try (FileWriter writer = new FileWriter(FILE_PRESTITI)) {
            gson.toJson(elencoPrestiti.getListaPrestiti(), writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Libro> caricaLibri() {
        try (FileReader reader = new FileReader(FILE_LIBRI)) {
            Type type = new TypeToken<ArrayList<Libro>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Utente> caricaUtenti() {
        try (FileReader reader = new FileReader(FILE_UTENTI)) {
            Type type = new TypeToken<ArrayList<Utente>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Prestito> caricaPrestiti() {
        try (FileReader reader = new FileReader(FILE_PRESTITI)) {
            Type type = new TypeToken<ArrayList<Prestito>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
