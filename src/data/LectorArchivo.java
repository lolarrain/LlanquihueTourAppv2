package data;

import model.Direccion;
import model.Persona;
import util.Validador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada exclusivamente de leer personas desde un archivo externo.
 */
public class LectorArchivo {

    public ArrayList<Persona> leerPersonas(String rutaArchivo) {
        ArrayList<Persona> personas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

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
        String rut = datos[0].trim();
        String nombre = datos[1].trim();
        String tipoPersona = datos[2].trim();
        String telefono = datos[3].trim();
        String correo = datos[4].trim();
        String calle = datos[5].trim();
        String numero = datos[6].trim();
        String comuna = datos[7].trim();
        String region = datos[8].trim();

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
