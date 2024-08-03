package org.example.gestion;

import java.time.LocalDate;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa un cliente que extiende la clase {@link Usuario} e incluye información adicional específica para un cliente.
 */
public class Cliente extends Usuario{

    // Principio de Sustitución de Liskov (LSP) - Las clases hijas pueden ser tratadas como su clase padre Usuario
    // Principio de Responsabilidad Única (SRP): Cada clase tiene una sola responsabilidad.

    /**
     * Teléfono del cliente.
     */
    private String telefono;
    /**
     * AFP del cliente.
     */
    private String afp;
    /**
     * Sistema de salud del cliente (1 para Fonasa, 2 para Isapre).
     */
    private int sistemaSalud;

    /**
     * Dirección del cliente.
     */
    private String direccion;
    /**
     * Comuna del cliente.
     */
    private String comuna;

    /**
     * Edad del cliente.
     */
    private int edad;


    /**
     * Constructor por defecto.
     */
    public Cliente() {}

    /**
     * Constructor con parámetros para inicializar los atributos del cliente.
     *
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param run RUN del cliente.
     * @param telefono Teléfono del cliente.
     * @param afp AFP del cliente.
     * @param sistemaSalud Sistema de salud del cliente (1 para Fonasa, 2 para Isapre).
     * @param direccion Dirección del cliente.
     * @param comuna Comuna del cliente.
     * @param edad Edad del cliente.
     */
    public Cliente(String nombre, String apellidos, LocalDate fechaNacimiento, long run, String telefono,
                   String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, apellidos, fechaNacimiento, run);
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Establece el teléfono del cliente.
     *
     * @param telefono Teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Obtiene el AFP del cliente.
     *
     * @return AFP del cliente.
     */
    public String getAfp() {
        return afp;
    }
    /**
     * Establece el AFP del cliente.
     *
     * @param afp AFP del cliente.
     */
    public void setAfp(String afp) {
        this.afp = afp;
    }
    /**
     * Obtiene el sistema de salud del cliente.
     *
     * @return Sistema de salud del cliente (1 para Fonasa, 2 para Isapre).
     */
    public int getSistemaSalud() {
        return sistemaSalud;
    }
    /**
     * Establece el sistema de salud del cliente.
     *
     * @param sistemaSalud Sistema de salud del cliente (1 para Fonasa, 2 para Isapre).
     */
    public void setSistemaSalud(int sistemaSalud) {
        this.sistemaSalud = sistemaSalud;
    }
    /**
     * Obtiene la dirección del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Establece la dirección del cliente.
     *
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Obtiene la comuna del cliente.
     *
     * @return Comuna del cliente.
     */
    public String getComuna() {
        return comuna;
    }
    /**
     * Establece la comuna del cliente.
     *
     * @param comuna Comuna del cliente.
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    /**
     * Obtiene la edad del cliente.
     *
     * @return Edad del cliente.
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Establece la edad del cliente.
     *
     * @param edad Edad del cliente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Representa la información del cliente en formato de cadena, incluyendo información adicional a la de la clase {@link Usuario}.
     *
     * @return Cadena con la información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " +
                "\n " + super.toString()+
                "\n  Teléfono: '" + telefono + '\'' +
                "\n  AFP: '" + afp + '\'' +
                "\n  Sistema de Salud: " + sistemaSalud +
                "\n  Dirección: '" + direccion + '\'' +
                "\n  Comuna: '" + comuna + '\'' +
                "\n  Edad: " + edad;
    }
    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre Completo del cliente.
     */
    public String obtenerNombre() {
        return nombre + " " + apellidos;
    }

    /**
     * Obtiene el nombre del sistema de salud del cliente.
     *
     * @return Nombre del sistema de salud (Fonasa o Isapre).
     */
    public String obtenerSistemaSalud() {
        return sistemaSalud == 1 ? "Fonasa" : "Isapre";
    }

    /**
     * Implementa el método de la interfaz {@link Asesoria} para analizar la información del cliente.
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Dirección: " + direccion);
        System.out.println("Comuna: " + comuna);
    }

}
