package org.example.gestion;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.gestion.Validar.*;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Clase encargada de gestionar la entrada de datos para la creación de instancias de {@link Cliente}, {@link Profesional},
 * {@link Administrativo} y {@link Capacitacion}.
 */
public class IngresarDatos {

    //principio SRP, ya que la clase tiene una responsabilidad específica de ingresar datos.


    /**
     * Crea una nueva instancia de {@link Cliente} a partir de los datos ingresados por el usuario.
     *
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @return Una nueva instancia de {@link Cliente} con los datos proporcionados por el usuario.
     */
    public static Cliente crearCliente(Scanner scanner) {
        String nombre = validarSinNumeros("Ingrese el nombre del cliente: ", scanner, 5, 50);
        String apellidos = validarSinNumeros("Ingrese los apellidos del cliente: ", scanner, 5, 50);
        LocalDate fechaNacimiento = validarFecha("Ingrese la fecha de nacimiento (dd/MM/yyyy): ", scanner, "dd/MM/yyyy");
        long run = validarLong("Ingrese el RUT del cliente sin puntos ni guión: ", scanner, 99999999);
        String telefono = validarTelefono("Ingrese el teléfono del cliente (9 dígitos): ", scanner);
        String afp = validarSinNumeros("Ingrese la AFP del cliente: ", scanner, 4, 30);
        int sistemaSalud = validarEntero("Ingrese el sistema de salud (1. Fonasa, 2. Isapre): ", scanner, 1, 2);
        String direccion = validarString("Ingrese la dirección del cliente: ", scanner, 0, 70);
        String comuna = validarSinNumeros("Ingrese la comuna del cliente: ", scanner, 0, 50);
        int edad = validarEntero("Ingrese la edad del cliente: ", scanner, 0, 150);

        return new Cliente(nombre, apellidos, fechaNacimiento, run, telefono, afp, sistemaSalud, direccion, comuna, edad);
    }

    /**
     * Crea una nueva instancia de {@link Profesional} a partir de los datos ingresados por el usuario.
     *
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @return Una nueva instancia de {@link Profesional} con los datos proporcionados por el usuario.
     */
    public static Profesional crearProfesional(Scanner scanner) {
        String nombre = validarSinNumeros("Ingrese el nombre del profesional: ", scanner, 5, 50);
        String apellidos = validarSinNumeros("Ingrese los apellidos del profesional: ", scanner, 5, 50);
        LocalDate fechaNacimiento = validarFecha("Ingrese la fecha de nacimiento (dd/MM/yyyy): ", scanner, "dd/MM/yyyy");
        long run = validarLong("Ingrese el RUT del profesional sin puntos ni guión: ", scanner, 99999999);
        String titulo = validarSoloLetras("Ingrese el título del profesional: ", scanner, 10, 50);
        LocalDate fechaIngreso = validarFecha("Ingrese la fecha de ingreso (dd/MM/yyyy): ", scanner, "dd/MM/yyyy");

        return new Profesional(nombre, apellidos, fechaNacimiento, run, titulo, fechaIngreso);
    }

    /**
     * Crea una nueva instancia de {@link Administrativo} a partir de los datos ingresados por el usuario.
     *
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @return Una nueva instancia de {@link Administrativo} con los datos proporcionados por el usuario.
     */
    public static Administrativo crearAdministrativo(Scanner scanner) {
        String nombre = validarSinNumeros("Ingrese el nombre del administrativo: ", scanner, 5, 50);
        String apellidos = validarSinNumeros("Ingrese los apellidos del administrativo: ", scanner, 5, 50);
        LocalDate fechaNacimiento = validarFecha("Ingrese la fecha de nacimiento (dd/MM/yyyy): ", scanner, "dd/MM/yyyy");
        long run = validarLong("Ingrese el RUN del administrativo: ", scanner, 99999999);
        String area = validarString("Ingrese el área del administrativo: ", scanner, 5, 20);
        String experienciaPrevia = validarString("Ingrese la experiencia previa del administrativo: ", scanner, 0, 100);
        return new Administrativo(nombre, apellidos, fechaNacimiento, run, area, experienciaPrevia);
    }

    /**
     * Crea una nueva instancia de {@link Capacitacion} a partir de los datos ingresados por el usuario.
     * Verifica que el cliente asociado exista en el contenedor proporcionado.
     *
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param contenedor El objeto {@link Contenedor} que contiene la lista de clientes.
     * @return Una nueva instancia de {@link Capacitacion} con los datos proporcionados por el usuario, o {@code null} si el cliente no se encuentra.
     */
    public static Capacitacion crearCapacitacion(Scanner scanner, Contenedor contenedor) {
        long runCliente = validarLongCap("Ingrese el RUN del cliente: ", scanner, 99999999);
        Cliente cliente = contenedor.buscarClientePorRut(runCliente);
        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return null;
        }

        String dia = validarDia("Ingrese el día de la semana en que se realizará la capacitación (ej:Lunes, etc): ", scanner);
        String hora = validarHora("Ingrese la hora de la capacitación en formato (HH:MM): ", scanner, 5);
        String lugar = validarString("Ingrese el lugar de la capacitación: ", scanner, 10, 50);
        int duracion = validarEntero("Ingrese la duración de la capacitación en minutos: ", scanner, 5, 240);
        int cantidadAsistentes = validarEntero("Ingrese la cantidad de asistentes: ", scanner, 1, 1000);

        return new Capacitacion(runCliente,  dia, hora, lugar, duracion, cantidadAsistentes);
    }
}
