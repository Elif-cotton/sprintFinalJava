package org.example.gestion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa un profesional que extiende la clase {@link Usuario} e incluye información adicional específica para un profesional.
 */
public class Profesional extends Usuario{

    // Principio de Sustitución de Liskov (LSP) - Las clases hijas pueden ser tratadas como su clase padre Usuario
    // Principio de Responsabilidad Única (SRP): Cada clase tiene una sola responsabilidad.

    /**
     * Título profesional del usuario.
     */
    private String titulo;
    /**
     * Fecha de ingreso del profesional en la organización.
     */
    private LocalDate fechaIngreso;

    /**
     * Constructor por defecto.
     */
    public Profesional() {}
    /**
     * Constructor con parámetros para inicializar los atributos del profesional.
     *
     * @param nombre Nombre del profesional.
     * @param apellidos Apellidos del profesional.
     * @param fechaNacimiento Fecha de nacimiento del profesional.
     * @param rut RUT del profesional.
     * @param titulo Título profesional del usuario.
     * @param fechaIngreso Fecha de ingreso del profesional en la organización.
     */
    public Profesional(String nombre, String apellidos,  LocalDate fechaNacimiento, long rut, String titulo, LocalDate fechaIngreso) {
        super(nombre, apellidos,fechaNacimiento, rut);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene el título profesional del usuario.
     *
     * @return Título profesional del usuario.
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el título profesional del usuario.
     *
     * @param titulo Título profesional del usuario.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtiene la fecha de ingreso del profesional en la organización.
     *
     * @return Fecha de ingreso del profesional.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    /**
     * Establece la fecha de ingreso del profesional en la organización.
     *
     * @param fechaIngreso Fecha de ingreso del profesional.
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Representa la información del profesional en formato de cadena, incluyendo información adicional a la de la clase {@link Usuario}.
     *
     * @return Cadena con la información del profesional.
     */
    @Override
    public String toString() {
        return "Profesional: " +
                "\n" + super.toString()+
                "\n  Título: '" + titulo + '\'' +
                "\n  Fecha de Ingreso: " + fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Implementa el método de la interfaz {@link Asesoria} para analizar la información del profesional.
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Titulo: " + titulo);
        System.out.println("Fecha de Ingreso: " + fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
