package org.example.gestion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa un usuario con información básica como nombre, apellidos, fecha de nacimiento y RUN.
 * Implementa la interfaz {@link Asesoria} para permitir la implementación del método {@code analizarUsuario()}.
 *
 */
public class Usuario implements Asesoria{

    // Principio de Responsabilidad Única (SRP): Cada clase tiene una sola responsabilidad.
    // Principio Abierto/Cerrado (OCP): Esta clase está abierta para extensión mediante herencia, pero cerrada para modificación.
    //Ya que están diseñadas de manera que se pueden extender (por ejemplo, creando nuevas subclases de Usuario).

    /**
     * Nombre del usuario.
     */
    protected String nombre;
    /**
     * Apellidos del usuario.
     */
    protected String apellidos;
    /**
     * Fecha de nacimiento del usuario.
     */
    protected LocalDate fechaNacimiento;
    /**
     * RUN del usuario.
     */
    protected long run;

    /**
     * Constructor por defecto.
     */

    public Usuario() {}

    /**
     * Constructor con parámetros para inicializar los atributos del usuario.
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @param run RUN del usuario.
     */

    public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, long run) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return Apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Establece el apellido del usuario.
     *
     * @param apellidos Apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return Fecha de nacimiento del usuario.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el RUN del usuario.
     *
     * @return RUN del usuario.
     */
    public long getRun() {
        return run;
    }

    /**
     * Establece el RUN del usuario.
     *
     * @param run RUN del usuario.
     */
    public void setRun(long run) {
        this.run = run;
    }

    /**
     * Obtiene el nombre completo del usuario (nombre + apellidos).
     *
     * @return Nombre completo del usuario.
     */
    public String obtenerNombre() {
        return nombre + " " + apellidos;
    }


    /**
     * Representa la información del usuario en formato de cadena.
     *
     * @return Cadena con la información del usuario.
     */
    @Override
    public String toString() {
        return " Nombre: '" + nombre + '\'' +
                "\n  Apellidos: '" + apellidos + '\'' +
                "\n  Fecha de Nacimiento: " + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\n  RUT: " + run;
    }

    /**
     * Muestra la edad del usuario calculada a partir de la fecha de nacimiento.
     */
    public void mostrarEdad() {
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        System.out.println("El usuario tiene " + edad + " años");
    }

    /**
     * Implementa el método de la interfaz {@link Asesoria} para analizar la información del usuario.
     */
    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("RUN: " + run);
    }
}
