package app;

import data.LectorArchivo;
import model.Persona;
import service.GestorPersonas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del sistema Llanquihue Tour.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rutaArchivo = "resources/personas.txt";

        LectorArchivo lectorArchivo = new LectorArchivo();
        ArrayList<Persona> personasLeidas = lectorArchivo.leerPersonas(rutaArchivo);

        GestorPersonas gestorPersonas = new GestorPersonas();
        gestorPersonas.cargarPersonas(personasLeidas);

        int opcion = 0;

        do {
            System.out.println();
            System.out.println("=== SISTEMA LLANQUIHUE TOUR ===");
            System.out.println("1. Mostrar todas las personas");
            System.out.println("2. Buscar persona por RUT");
            System.out.println("3. Filtrar personas por tipo");
            System.out.println("4. Filtrar personas por comuna");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println();
                        System.out.println("=== PERSONAS REGISTRADAS ===");
                        gestorPersonas.mostrarTodasLasPersonas();
                        break;

                    case 2:
                        System.out.println();
                        System.out.print("Ingrese el RUT a buscar: ");
                        String rutBuscado = scanner.nextLine();

                        System.out.println();
                        System.out.println("=== RESULTADO DE BÚSQUEDA POR RUT ===");
                        gestorPersonas.buscarPorRut(rutBuscado);
                        break;

                    case 3:
                        System.out.println();
                        System.out.print("Ingrese el tipo de persona: ");
                        String tipoBuscado = scanner.nextLine();

                        System.out.println();
                        System.out.println("=== RESULTADO DE FILTRO POR TIPO ===");
                        gestorPersonas.filtrarPorTipo(tipoBuscado);
                        break;

                    case 4:
                        System.out.println();
                        System.out.print("Ingrese la comuna: ");
                        String comunaBuscada = scanner.nextLine();

                        System.out.println();
                        System.out.println("=== RESULTADO DE FILTRO POR COMUNA ===");
                        gestorPersonas.filtrarPorComuna(comunaBuscada);
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println();
                        System.out.println("Opción inválida. Debe ingresar un número entre 1 y 5.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Error: debe ingresar una opción numérica válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}