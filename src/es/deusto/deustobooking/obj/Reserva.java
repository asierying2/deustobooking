package es.deusto.deustobooking.obj;

public class Reserva {

    private String codigo;
    private String cliente;
    private int numeroHabitacion;
    private String fechaEntrada;
    private String fechaSalida;
    private boolean cancelada;

    public Reserva(String codigo, String cliente, int numeroHabitacion,
            String fechaEntrada, String fechaSalida, boolean cancelada) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cancelada = cancelada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
}
