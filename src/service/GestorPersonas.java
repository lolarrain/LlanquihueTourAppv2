package service;

import model.Persona;

import java.util.ArrayList;

/**
 * Clase encargada de gestionar la colección de personas.
 */
public class GestorPersonas {

    private ArrayList<Persona> personas;

    public GestorPersonas() {
        this.personas = new ArrayList<>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void cargarPersonas(ArrayList<Persona> personasLeidas) {
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
        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rut)) {
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
        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rutBuscado)) {
                System.out.println("------------------------------");
                System.out.println(persona);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró una persona con el RUT: " + rutBuscado);
        }
    }

    public void filtrarPorTipo(String tipoBuscado) {
        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getTipoPersona().equalsIgnoreCase(tipoBuscado)) {
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
        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getDireccion().getComuna().equalsIgnoreCase(comunaBuscada)) {
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
