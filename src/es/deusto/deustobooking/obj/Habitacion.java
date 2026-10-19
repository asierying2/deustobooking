package obj;

public class Habitacion {

    private final int numero;
    private String tipo;
    private int capacidad;
    private double precioNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, int capacidad, double precioNoche,
            boolean disponible) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número de habitación tien que ser positivo.");
        }
        this.numero = numero;
        setTipo(tipo);
        setCapacidad(capacidad);
        setPrecioNoche(precioNoche);
        this.disponible = disponible;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public int getCapacidad() { return capacidad; }
    public double getPrecioNoche() { return precioNoche; }


    public boolean isDisponible() { return disponible; }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Indica el tipo de habitación.");
        }
        this.tipo = tipo.trim();
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad tiene que ser positiva.");
        }
        this.capacidad = capacidad;
    }

    public void setPrecioNoche(double precioNoche) {
        if (!Double.isFinite(precioNoche) || precioNoche <= 0) {
            throw new IllegalArgumentException("El precio por noche tiene que  ser positivo.");
        }
        this.precioNoche = precioNoche;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double calcularImporte(int noches) {
        if (noches <= 0) {
            throw new IllegalArgumentException("La estancia tiene que ser de  al menos una noche.");
        }

        return Math.round(precioNoche * noches * 100) / 100.0;
    }

    @Override
    public String toString() {
        return numero + " - " + tipo;
    }
}
