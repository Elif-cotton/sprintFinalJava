package org.example.gestion;

import java.time.LocalDate;
/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa un administrativo que extiende la clase {@link Usuario} e incluye información adicional específica para un administrativo.
 */
public class Administrativo extends Usuario{

    // Principio de Sustitución de Liskov (LSP) - Las clases hijas pueden ser tratadas como su clase padre Usuario
    // Principio de Responsabilidad Única (SRP): Cada clase tiene una sola responsabilidad.

    /**
     * Área de trabajo del administrativo.
     */
    private String area;
    /**
     * Experiencia previa del administrativo.
     */
    private String experienciaPrevia;

    /**
     * Constructor por defecto.
     */
    public Administrativo() {}

    /**
     * Constructor con parámetros para inicializar los atributos del administrativo.
     *
     * @param nombre Nombre del administrativo.
     * @param apellidos Apellidos del administrativo.
     * @param fechaNacimiento Fecha de nacimiento del administrativo.
     * @param rut RUT del administrativo.
     * @param area Área de trabajo del administrativo.
     * @param experienciaPrevia Experiencia previa del administrativo.
     */
    public Administrativo(String nombre, String apellidos, LocalDate fechaNacimiento, long rut, String area, String experienciaPrevia) {
        super(nombre, apellidos, fechaNacimiento, rut);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    /**
     * Obtiene el área de trabajo del administrativo.
     *
     * @return Área de trabajo del administrativo.
     */
    public String getArea() {
        return area;
    }
    /**
     * Establece el área de trabajo del administrativo.
     *
     * @param area Área de trabajo del administrativo.
     */
    public void setArea(String area) {
        this.area = area;
    }
    /**
     * Obtiene la experiencia previa del administrativo.
     *
     * @return Experiencia previa del administrativo.
     */
    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }
    /**
     * Establece la experiencia previa del administrativo.
     *
     * @param experienciaPrevia Experiencia previa del administrativo.
     */
    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    /**
     * Representa la información del administrativo en formato de cadena, incluyendo información adicional a la de la clase {@link Usuario}.
     *
     * @return Cadena con la información del administrativo.
     */
    @Override
    public String toString() {
        return "Administrativo: " +
                "\n" + super.toString()+
                "\n  Área: '" + area + '\'' +
                "\n  Experiencia Previa: '" + experienciaPrevia;
    }

    /**
     * Implementa el método de la interfaz {@link Asesoria} para analizar la información del administrativo.
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Área: " + area);
        System.out.println("Experiencia Previa: " + experienciaPrevia);
    }

}
