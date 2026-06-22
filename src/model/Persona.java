package model;

import util.Validador;

/**
 * Clase base que representa a una persona vinculada a Llanquihue Tour.
 * Puede corresponder a un guía turístico, operador local o proveedor de transporte.
 */
public class Persona {

    private String rut;
    private String nombre;
    private String tipoPersona;
    private String telefono;
    private String correo;
    private Direccion direccion;

    public Persona(String rut, String nombre, String tipoPersona, String telefono, String correo, Direccion direccion) {
        setRut(rut);
        setNombre(nombre);
        setTipoPersona(tipoPersona);
        setTelefono(telefono);
        setCorreo(correo);
        setDireccion(direccion);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        try {
            if (!Validador.rutValido(rut)) {
                throw new IllegalArgumentException("El RUT no puede estar vacío.");
            }
            this.rut = Validador.limpiarTexto(rut);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en RUT: " + e.getMessage());
            this.rut = "Sin RUT";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try {
            if (Validador.textoVacio(nombre)) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            this.nombre = Validador.limpiarTexto(nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en nombre: " + e.getMessage());
            this.nombre = "Sin nombre";
        }
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        try {
            if (Validador.textoVacio(tipoPersona)) {
                throw new IllegalArgumentException("El tipo de persona no puede estar vacío.");
            }
            this.tipoPersona = Validador.limpiarTexto(tipoPersona);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en tipo de persona: " + e.getMessage());
            this.tipoPersona = "Sin tipo";
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        try {
            if (!Validador.telefonoValido(telefono)) {
                throw new IllegalArgumentException("El teléfono no puede estar vacío.");
            }
            this.telefono = Validador.limpiarTexto(telefono);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en teléfono: " + e.getMessage());
            this.telefono = "Sin teléfono";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        try {
            if (!Validador.correoValido(correo)) {
                throw new IllegalArgumentException("El correo debe contener @ y punto.");
            }
            this.correo = Validador.limpiarTexto(correo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en correo: " + e.getMessage());
            this.correo = "Sin correo";
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        try {
            if (direccion == null) {
                throw new IllegalArgumentException("La dirección no puede ser nula.");
            }
            this.direccion = direccion;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en dirección: " + e.getMessage());
            this.direccion = new Direccion("Sin calle", "S/N", "Sin comuna", "Sin región");
        }
    }

    @Override
    public String toString() {
        return "RUT: " + rut +
                "\nNombre: " + nombre +
                "\nTipo de persona: " + tipoPersona +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correo +
                "\nDirección: " + direccion;
    }
}
