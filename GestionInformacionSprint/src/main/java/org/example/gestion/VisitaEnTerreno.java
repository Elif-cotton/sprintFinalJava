package org.example.gestion;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa una visita en terreno realizada a un cliente.
 */
public class VisitaEnTerreno {

    // Principio de Responsabilidad Única (SRP): La clase VisitaEnTerreno maneja detalles de una visita en terreno.

    /**
     * Identificador único de la visita en terreno.
     */
    private int identificador;
    /**
     * RUT del cliente asociado a la visita en terreno.
     */
    private long rutCliente;
    /**
     * Fecha de la visita en terreno.
     */
    private LocalDate dia;
    /**
     * Hora de la visita en terreno en formato HH:MM (24 horas).
     */
    private String hora;
    /**
     * Lugar donde se realizó la visita en terreno.
     */
    private String lugar;
    /**
     * Comentarios adicionales sobre la visita en terreno.
     */
    private String comentarios;
    /**
     * Lista de revisiones asociadas a la visita en terreno.
     */
    private List<Revision> revisiones;


    /**
     * Constructor por defecto.
     * <p>
     * Inicializa la lista de revisiones como una lista vacía.
     * </p>
     */
    public VisitaEnTerreno() {
        this.revisiones = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param identificador El identificador único de la visita en terreno.
     * @param rutCliente El RUT del cliente asociado a la visita en terreno. Debe ser un número menor a 99.999.999.
     * @param dia La fecha de la visita en terreno. No puede ser nula.
     * @param hora La hora de la visita en terreno en formato HH:MM (24 horas). No puede ser nula y debe cumplir con el formato.
     * @param lugar El lugar de la visita en terreno. Debe tener entre 10 y 50 caracteres.
     * @param comentarios Los comentarios adicionales sobre la visita en terreno. No deben exceder los 100 caracteres.
     */
    public VisitaEnTerreno(int identificador, long rutCliente, LocalDate dia, String hora, String lugar, String comentarios) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
    }

    /**
     * Obtiene el identificador único de la visita en terreno.
     *
     * @return El identificador de la visita en terreno.
     */
    public int getIdentificador() {
        return identificador;
    }
    /**
     * Establece el identificador único de la visita en terreno.
     *
     * @param identificador El nuevo identificador de la visita en terreno.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    /**
     * Obtiene el RUT del cliente asociado a la visita en terreno.
     *
     * @return El RUT del cliente. Debe ser un número menor a 99.999.999.
     */
    public long getRutCliente() {
        return rutCliente;
    }
    /**
     * Establece el RUT del cliente asociado a la visita en terreno.
     *
     * @param rutCliente El nuevo RUT del cliente. Debe ser un número menor a 99.999.999.
     * @throws IllegalArgumentException Si el RUT no es un número válido o está fuera del rango permitido.
     */
    public void setRutCliente(long rutCliente) {
        if (rutCliente <= 0 || rutCliente >= 99999999) {
            throw new IllegalArgumentException("El RUT del cliente debe ser un número menor a 99.999.999.");
        }
        this.rutCliente = rutCliente;
    }
    /**
     * Obtiene la fecha de la visita en terreno.
     *
     * @return La fecha de la visita en terreno.
     */
    public LocalDate getDia() {
        return dia;
    }
    /**
     * Establece la fecha de la visita en terreno.
     *
     * @param dia La nueva fecha de la visita en terreno. No puede ser nula.
     * @throws IllegalArgumentException Si la fecha es nula.
     */
    public void setDia(LocalDate dia) {
        if (dia == null) {
            throw new IllegalArgumentException("La fecha del accidente no puede ser nula.");
        }
        this.dia = dia;
    }
    /**
     * Obtiene la hora de la visita en terreno.
     *
     * @return La hora de la visita en terreno en formato HH:MM (24 horas).
     */
    public String getHora() {
        return hora;
    }
    /**
     * Establece la hora de la visita en terreno.
     *
     * @param hora La nueva hora de la visita en terreno en formato HH:MM (24 horas). No puede ser nula y debe cumplir con el formato.
     * @throws IllegalArgumentException Si la hora no está en el formato correcto.
     */
    public void setHora(String hora) {
        if (hora == null || !hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            throw new IllegalArgumentException("La hora debe estar en formato HH:MM (24 horas).");
        }
        this.hora = hora;
    }
    /**
     * Obtiene el lugar de la visita en terreno.
     *
     * @return El lugar de la visita en terreno.
     */
    public String getLugar() {
        return lugar;
    }
    /**
     * Establece el lugar de la visita en terreno.
     *
     * @param lugar El nuevo lugar de la visita en terreno. Debe tener entre 10 y 50 caracteres.
     * @throws IllegalArgumentException Si el lugar es nulo o no tiene la longitud requerida.
     */
    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }
    /**
     * Obtiene los comentarios adicionales sobre la visita en terreno.
     *
     * @return Los comentarios adicionales sobre la visita en terreno.
     */
    public String getComentarios() {
        return comentarios;
    }
    /**
     * Establece los comentarios adicionales sobre la visita en terreno.
     *
     * @param comentarios Los nuevos comentarios adicionales sobre la visita en terreno. No deben exceder los 100 caracteres.
     * @throws IllegalArgumentException Si los comentarios tienen más de 100 caracteres.
     */
    public void setComentarios(String comentarios) {
        if (comentarios != null && comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no pueden tener más de 100 caracteres.");
        }
        this.comentarios = comentarios;
    }
    /**
     * Obtiene la lista de revisiones asociadas a la visita en terreno.
     *
     * @return La lista de revisiones asociadas a la visita en terreno.
     */
    public List<Revision> getRevisiones() {
        return revisiones;
    }
    /**
     * Establece la lista de revisiones asociadas a la visita en terreno.
     *
     * @param revisiones La nueva lista de revisiones asociadas a la visita en terreno.
     */
    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }
    /**
     * Agrega una revisión a la lista de revisiones asociadas a la visita en terreno.
     *
     * @param revision La revisión a agregar.
     */
    public void agregarRevision(Revision revision) {
        if (revisiones == null) {
            revisiones = new ArrayList<>();
        }
        revisiones.add(revision);
    }
    /**
     * Devuelve una representación en cadena de texto de la visita en terreno.
     * <p>
     * La representación incluye el identificador, la fecha, la hora, el lugar, los comentarios y una lista de las revisiones asociadas.
     * </p>
     *
     * @return Una cadena que representa la visita en terreno.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder revisionString = new StringBuilder();
        if (revisiones != null) {
            for (Revision revision : revisiones) {
                revisionString.append("\n  - ").append(revision.getNombreRevision());
            }
        }
        return "Visita en Terreno #" + identificador +
                "\nFecha: " + dateFormat.format(dia) +
                "\nHora: " + hora +
                "\nLugar: " + lugar +
                "\nComentarios: " + comentarios +
                "\nRevisiones:" + (revisiones != null && !revisiones.isEmpty() ? revisionString.toString() : "");
    }

}
