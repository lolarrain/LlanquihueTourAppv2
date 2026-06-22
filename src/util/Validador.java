package util;

public class Validador {

    public static boolean lineaPersonaValida(String[] datos) {
        return datos != null && datos.length == 9;
    }

    public static boolean textoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static String limpiarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.trim();
    }

    public static boolean rutValido(String rut) {
        return !textoVacio(rut);
    }

    public static boolean correoValido(String correo) {
        return !textoVacio(correo) && correo.contains("@") && correo.contains(".");
    }

    public static boolean telefonoValido(String telefono) {
        return !textoVacio(telefono);
    }
}