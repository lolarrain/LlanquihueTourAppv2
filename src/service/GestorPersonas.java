package service;

import model.Persona;
import util.Validador;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar la colección de personas.
 */
public class GestorPersonas {

    private List<Persona> personas;

    public GestorPersonas() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void cargarPersonas(List<Persona> personasLeidas) {
        for (Persona persona : personasLeidas) {
            agregarPersona(persona);
        }
    }

    public void agregarPersona(Persona persona) {
        if (persona == null) {
            System.out.println("No se puede agregar una persona nula.");
            return;
        }

        if (!existeRut(persona.getRut())) {
            personas.add(persona);
        } else {
            System.out.println("Registro duplicado omitido. RUT: " + persona.getRut());
        }
    }

    public boolean existeRut(String rut) {
        if (Validador.textoVacio(rut)) {
            return false;
        }

        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rut.trim())) {
                return true;
            }
        }

        return false;
    }

    public void mostrarTodasLasPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        for (Persona persona : personas) {
            System.out.println("------------------------------");
            System.out.println(persona);
        }
    }

    public void buscarPorRut(String rutBuscado) {
        if (Validador.textoVacio(rutBuscado)) {
            System.out.println("Debe ingresar un RUT válido.");
            return;
        }

        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rutBuscado.trim())) {
                System.out.println("------------------------------");
                System.out.println(persona);
                return;
            }
        }

        System.out.println("No se encontró una persona con el RUT: " + rutBuscado);
    }

    public void filtrarPorTipo(String tipoBuscado) {
        if (Validador.textoVacio(tipoBuscado)) {
            System.out.println("Debe ingresar un tipo de persona válido.");
            return;
        }

        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getTipoPersona().equalsIgnoreCase(tipoBuscado.trim())) {
                System.out.println("------------------------------");
                System.out.println(persona);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron personas del tipo: " + tipoBuscado);
        }
    }

    public void filtrarPorComuna(String comunaBuscada) {
        if (Validador.textoVacio(comunaBuscada)) {
            System.out.println("Debe ingresar una comuna válida.");
            return;
        }

        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getDireccion().getComuna().equalsIgnoreCase(comunaBuscada.trim())) {
                System.out.println("------------------------------");
                System.out.println(persona);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron personas en la comuna: " + comunaBuscada);
        }
    }
}
