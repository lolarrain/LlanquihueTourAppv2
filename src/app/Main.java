package app;

import data.LectorArchivo;
import model.Persona;
import service.GestorPersonas;
import ui.MenuConsola;

import java.util.List;

/**
 * Clase principal del sistema Llanquihue Tour.
 */
public class Main {

    public static void main(String[] args) {

        String rutaArchivo = "resources/personas.txt";

        LectorArchivo lectorArchivo = new LectorArchivo();
        List<Persona> personasLeidas = lectorArchivo.leerPersonas(rutaArchivo);

        GestorPersonas gestorPersonas = new GestorPersonas();
        gestorPersonas.cargarPersonas(personasLeidas);

        MenuConsola menuConsola = new MenuConsola(gestorPersonas);
        menuConsola.iniciar();
    }
}