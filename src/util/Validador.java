package util;

public class Validador {

    public static boolean lineaPersonaValida(String[] datos) {
        return datos.length == 9;
    }

    public static boolean textoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}