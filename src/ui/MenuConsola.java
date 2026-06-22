package ui;

import service.GestorPersonas;

import java.util.Scanner;

/**
 * Clase encargada de mostrar el menú y gestionar la interacción por consola.
 */
public class MenuConsola {

    private GestorPersonas gestorPersonas;
    private Scanner scanner;

    public MenuConsola(GestorPersonas gestorPersonas) {
        this.gestorPersonas = gestorPersonas;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = 0;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Error: debe ingresar una opción numérica válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("=== SISTEMA LLANQUIHUE TOUR ===");
        System.out.println("1. Mostrar todas las personas");
        System.out.println("2. Buscar persona por RUT");
        System.out.println("3. Filtrar personas por tipo");
        System.out.println("4. Filtrar personas por comuna");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarPersonas();
                break;

            case 2:
                buscarPorRut();
                break;

            case 3:
                filtrarPorTipo();
                break;

            case 4:
                filtrarPorComuna();
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
    }

    private void mostrarPersonas() {
        System.out.println();
        System.out.println("=== PERSONAS REGISTRADAS ===");
        gestorPersonas.mostrarTodasLasPersonas();
    }

    private void buscarPorRut() {
        System.out.println();
        System.out.print("Ingrese el RUT a buscar: ");
        String rutBuscado = scanner.nextLine();

        System.out.println();
        System.out.println("=== RESULTADO DE BÚSQUEDA POR RUT ===");
        gestorPersonas.buscarPorRut(rutBuscado);
    }

    private void filtrarPorTipo() {
        System.out.println();
        System.out.print("Ingrese el tipo de persona: ");
        String tipoBuscado = scanner.nextLine();

        System.out.println();
        System.out.println("=== RESULTADO DE FILTRO POR TIPO ===");
        gestorPersonas.filtrarPorTipo(tipoBuscado);
    }

    private void filtrarPorComuna() {
        System.out.println();
        System.out.print("Ingrese la comuna: ");
        String comunaBuscada = scanner.nextLine();

        System.out.println();
        System.out.println("=== RESULTADO DE FILTRO POR COMUNA ===");
        gestorPersonas.filtrarPorComuna(comunaBuscada);
    }
}
