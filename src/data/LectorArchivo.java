package data;

import model.Direccion;
import model.Persona;
import util.Validador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada exclusivamente de leer personas desde un archivo externo.
 */
public class LectorArchivo {

    public List<Persona> leerPersonas(String rutaArchivo) {
        List<Persona> personas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (Validador.textoVacio(linea)) {
                    continue;
                }

                String[] datos = linea.split(";", -1);

                if (Validador.lineaPersonaValida(datos)) {
                    Persona persona = crearPersonaDesdeDatos(datos);
                    personas.add(persona);
                } else {
                    System.out.println("Línea inválida omitida: " + linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return personas;
    }

    private Persona crearPersonaDesdeDatos(String[] datos) {
        String rut = Validador.limpiarTexto(datos[0]);
        String nombre = Validador.limpiarTexto(datos[1]);
        String tipoPersona = Validador.limpiarTexto(datos[2]);
        String telefono = Validador.limpiarTexto(datos[3]);
        String correo = Validador.limpiarTexto(datos[4]);
        String calle = Validador.limpiarTexto(datos[5]);
        String numero = Validador.limpiarTexto(datos[6]);
        String comuna = Validador.limpiarTexto(datos[7]);
        String region = Validador.limpiarTexto(datos[8]);

        Direccion direccion = new Direccion(calle, numero, comuna, region);

        return new Persona(
                rut,
                nombre,
                tipoPersona,
                telefono,
                correo,
                direccion
        );
    }
}