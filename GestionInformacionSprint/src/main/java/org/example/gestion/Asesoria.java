package org.example.gestion;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Interfaz que define el método para analizar la información de un usuario.
 *
 */
public interface Asesoria {
    /**
     * Analiza la información de un usuario.
     */
    void analizarUsuario();

    // Principio de Segregación de Interfaces (ISP): La interfaz Asesoria es específica y no fuerza a las clases a implementar métodos innecesarios.
}
