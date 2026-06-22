package model;

/**
 * Representa la dirección de una persona vinculada a Llanquihue Tour.
 * Esta clase se usa por composición dentro de la clase Persona.
 */
public class Direccion {

    private String calle;
    private String numero;
    private String comuna;
    private String region;

    public Direccion(String calle, String numero, String comuna, String region) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
        setRegion(region);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        try {
            if (calle == null || calle.trim().isEmpty()) {
                throw new IllegalArgumentException("La calle no puede estar vacía.");
            }
            this.calle = calle;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en calle: " + e.getMessage());
            this.calle = "Sin calle";
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        try {
            if (numero == null || numero.trim().isEmpty()) {
                throw new IllegalArgumentException("El número no puede estar vacío.");
            }
            this.numero = numero;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en número: " + e.getMessage());
            this.numero = "S/N";
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        try {
            if (comuna == null || comuna.trim().isEmpty()) {
                throw new IllegalArgumentException("La comuna no puede estar vacía.");
            }
            this.comuna = comuna;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en comuna: " + e.getMessage());
            this.comuna = "Sin comuna";
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        try {
            if (region == null || region.trim().isEmpty()) {
                throw new IllegalArgumentException("La región no puede estar vacía.");
            }
            this.region = region;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en región: " + e.getMessage());
            this.region = "Sin región";
        }
    }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna + ", " + region;
    }
}
