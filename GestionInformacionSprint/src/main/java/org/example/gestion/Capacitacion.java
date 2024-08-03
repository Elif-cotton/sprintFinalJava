package org.example.gestion;
/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa una capacitación con detalles específicos.
 */
public class Capacitacion {

    // Principio de Responsabilidad Única (SRP): La clase Capacitación maneja detalles de capacitación.


    // Contador estático para generar identificadores únicos.
    private static int contadorIdentificadores = 0;
    /**
     * Identificador único de la capacitación.
     */
    private int identificador;
    /**
     * RUT del cliente que solicita la capacitación.
     */
    private long rutCliente;
    /**
     * Día en el que se realizará la capacitación.
     */
    private String dia;
    /**
     * Hora de inicio de la capacitación.
     */
    private String hora;
    /**
     * Lugar donde se llevará a cabo la capacitación.
     */
    private String lugar;
    /**
     * Duración de la capacitación en minutos.
     */
    private int duracion;
    /**
     * Cantidad de asistentes esperados para la capacitación.
     */
    private int cantidadAsistentes;

    /**
     * Constructor por defecto.
     */
    public Capacitacion() {
        // Asignar un identificador único al crear la capacitación.
        this.identificador = ++contadorIdentificadores;
    }

    /**
     * Constructor que inicializa una nueva instancia de la clase Capacitacion con todos los atributos.
     *
     * @param rutCliente El RUT del cliente que solicita la capacitación, equivalente a RUN.
     * @param dia El día de la capacitación.
     * @param hora La hora de inicio de la capacitación.
     * @param lugar El lugar donde se llevará a cabo la capacitación.
     * @param duracion La duración de la capacitación en minutos.
     * @param cantidadAsistentes La cantidad de asistentes esperados.
     */
    public Capacitacion(long rutCliente, String dia, String hora,
                        String lugar, int duracion, int cantidadAsistentes) {
        this.identificador = ++contadorIdentificadores;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }
    /**
     * Obtiene el RUT del cliente.
     *
     * @return El RUT del cliente.
     */
    public long getRutCliente() {
        return rutCliente;
    }
    /**
     * Establece el RUT del cliente.
     *
     * @param rutCliente El nuevo RUT del cliente.
     */
    public void setRutCliente(long rutCliente) {
        this.rutCliente = rutCliente;
    }
    /**
     * Obtiene el identificador de la capacitación.
     *
     * @return El identificador de la capacitación.
     */
    public int getIdentificador() {
        return identificador;
    }
    /**
     * Establece el identificador de la capacitación.
     *
     * @param identificador El nuevo identificador de la capacitación.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene el día de la capacitación.
     *
     * @return El día de la capacitación.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la capacitación.
     *
     * @param dia El nuevo día de la capacitación.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    /**
     * Obtiene la hora de inicio de la capacitación.
     *
     * @return La hora de inicio de la capacitación.
     */
    public String getHora() {
        return hora;
    }
    /**
     * Establece la hora de inicio de la capacitación.
     *
     * @param hora La nueva hora de inicio de la capacitación.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    /**
     * Obtiene el lugar de la capacitación.
     *
     * @return El lugar de la capacitación.
     */
    public String getLugar() {
        return lugar;
    }
    /**
     * Establece el lugar de la capacitación.
     *
     * @param lugar El nuevo lugar de la capacitación.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    /**
     * Obtiene la duración de la capacitación en minutos.
     *
     * @return La duración de la capacitación en minutos.
     */
    public int getDuracion() {
        return duracion;
    }
    /**
     * Establece la duración de la capacitación en minutos.
     *
     * @param duracion La nueva duración de la capacitación en minutos.
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    /**
     * Obtiene la cantidad de asistentes esperados para la capacitación.
     *
     * @return La cantidad de asistentes esperados.
     */
    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }
    /**
     * Establece la cantidad de asistentes esperados para la capacitación.
     *
     * @param cantidadAsistentes La nueva cantidad de asistentes esperados.
     */
    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    /**
     * Devuelve una representación en cadena de texto de la capacitación.
     * La representación incluye el identificador, el RUT del cliente, el día, la hora, el lugar, la duración y la cantidad de asistentes.
     *
     * @return Una cadena que representa la capacitación.
     */
    @Override
    public String toString() {
        return "Capacitacion:" +
                "\n  Identificador: " + identificador +
                "\n  RUT del Cliente: " + rutCliente +
                "\n  Día: '" + dia + '\'' +
                "\n  Hora: '" + hora + '\'' +
                "\n  Lugar: '" + lugar + '\'' +
                "\n  Duración: " + duracion + " minutos" +
                "\n  Cantidad de Asistentes: " + cantidadAsistentes;
    }

    /**
     * Muestra un detalle de la capacitación.
     * El detalle incluye el lugar, la hora, el día y la duración de la capacitación.
     *
     * @return Una cadena que describe la capacitación.
     */
    public String mostrarDetalle() {
        return "La capacitación será en " + lugar + " a las " + hora + " del día " + dia + ", y durará " + duracion + " minutos";
    }

}
