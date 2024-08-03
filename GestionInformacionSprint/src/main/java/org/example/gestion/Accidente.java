package org.example.gestion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */


/**
 * Representa un accidente con detalles como identificador, RUT del cliente, fecha, hora, lugar, origen y consecuencias.
 *
 */
public class Accidente {


    // Principio de Responsabilidad Única (SRP) al enfocarse únicamente en la representación y validación
    // de los detalles del accidente. Puede ser extendida sin modificación, siguiendo el Principio de Abierto/Cerrado (OCP).


    /**
     * El identificador del accidente.
     */
    private int identificador;
    /**
     * El RUT del cliente asociado con el accidente.
     */
    private long rutCliente;
    /**
     * La fecha del accidente.
     */
    private LocalDate dia;
    /**
     * La hora del accidente en formato HH:MM (24 horas).
     */
    private String hora;
    /**
     * El lugar donde ocurrió el accidente.
     */
    private String lugar;
    /**
     * El origen del accidente (opcional, hasta 100 caracteres).
     */
    private String origen;
    /**
     * Las consecuencias del accidente (opcional, hasta 100 caracteres).
     */
    private String consecuencias;


    /**
     * Constructor por defecto para la clase Accidente.
     */
    public Accidente() {
    }

    /**
     * Construye un objeto Accidente con los detalles especificados.
     *
     * @param identificador  el identificador del accidente
     * @param rutCliente     el RUT del cliente asociado con el accidente
     * @param dia            la fecha del accidente
     * @param hora           la hora del accidente en formato HH:MM (24 horas)
     * @param lugar          el lugar donde ocurrió el accidente (10-50 caracteres)
     * @param origen         el origen del accidente (opcional, hasta 100 caracteres)
     * @param consecuencias  las consecuencias del accidente (opcional, hasta 100 caracteres)
     */
    public Accidente(int identificador, long rutCliente, LocalDate dia, String hora, String lugar, String origen, String consecuencias) {
        this.identificador = identificador;
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }
    /**
     * Obtiene el identificador del accidente.
     *
     * @return el identificador del accidente
     */
    public int getIdentificador() {
        return identificador;
    }
    /**
     * Establece el identificador del accidente.
     *
     * @param identificador el identificador del accidente
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    /**
     * Obtiene el RUT del cliente asociado con el accidente.
     *
     * @return el RUT del cliente
     */
    public long getRutCliente() {
        return rutCliente;
    }
    /**
     * Establece el RUT del cliente asociado con el accidente.
     *
     * @param rutCliente el RUT del cliente
     * @throws IllegalArgumentException si el RUT no es un número válido (debe estar entre 1 y 99.999.999)
     */
    public void setRutCliente(long rutCliente) {
        if (rutCliente <= 0 || rutCliente >= 99999999) {
            throw new IllegalArgumentException("El RUT del cliente debe ser un número menor a 99.999.999.");
        }
        this.rutCliente = rutCliente;
    }

    /**
     * Obtiene la fecha del accidente.
     *
     * @return la fecha del accidente
     */
    public LocalDate getDia() {
        return dia;
    }
    /**
     * Establece la fecha del accidente.
     *
     * @param dia la fecha del accidente
     * @throws IllegalArgumentException si la fecha es nula
     */
    public void setDia(LocalDate dia) {
        if (dia == null) {
            throw new IllegalArgumentException("La fecha del accidente no puede ser nula.");
        }
        this.dia = dia;
    }
    /**
     * Obtiene la hora del accidente.
     *
     * @return la hora del accidente en formato HH:MM
     */
    public String getHora() {
        return hora;
    }
    /**
     * Establece la hora del accidente.
     *
     * @param hora la hora del accidente en formato HH:MM (24 horas)
     * @throws IllegalArgumentException si la hora es nula o no coincide con el formato HH:MM (24 horas)
     */
    public void setHora(String hora) {
        if (hora == null || !hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            throw new IllegalArgumentException("La hora debe estar en formato HH:MM (24 horas).");
        }
        this.hora = hora;
    }
    /**
     * Obtiene el lugar donde ocurrió el accidente.
     *
     * @return el lugar donde ocurrió el accidente
     */
    public String getLugar() {
        return lugar;
    }
    /**
     * Establece el lugar donde ocurrió el accidente.
     *
     * @param lugar el lugar donde ocurrió el accidente (10-50 caracteres)
     * @throws IllegalArgumentException si el lugar es nulo o no tiene entre 10 y 50 caracteres
     */
    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }
    /**
     * Obtiene el origen del accidente.
     *
     * @return el origen del accidente
     */
    public String getOrigen() {
        return origen;
    }
    /**
     * Establece el origen del accidente.
     *
     * @param origen el origen del accidente (opcional, hasta 100 caracteres)
     * @throws IllegalArgumentException si el origen tiene más de 100 caracteres
     */
    public void setOrigen(String origen) {
        if (origen != null && origen.length() > 100) {
            throw new IllegalArgumentException("El origen no puede tener más de 100 caracteres.");
        }
        this.origen = origen;
    }
    /**
     * Obtiene las consecuencias del accidente.
     *
     * @return las consecuencias del accidente
     */
    public String getConsecuencias() {
        return consecuencias;
    }
    /**
     * Establece las consecuencias del accidente.
     *
     * @param consecuencias las consecuencias del accidente (opcional, hasta 100 caracteres)
     * @throws IllegalArgumentException si las consecuencias tienen más de 100 caracteres
     */
    public void setConsecuencias(String consecuencias) {
        if (consecuencias != null && consecuencias.length() > 100) {
            throw new IllegalArgumentException("Las consecuencias no pueden tener más de 100 caracteres.");
        }
        this.consecuencias = consecuencias;
    }

    /**
     * Devuelve una representación en forma de cadena del accidente.
     *
     * @return una representación en forma de cadena del accidente
     */
    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Accidente #" + identificador +
                "\nFecha: " + dateFormat.format(dia) +
                "\nHora: " + hora +
                "\nLugar: " + lugar +
                "\nOrigen: " + origen +
                "\nConsecuencias: " + consecuencias;
    }

}
