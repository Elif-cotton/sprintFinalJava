package org.example;


import org.example.gestion.*;

import java.util.Scanner;
import java.util.InputMismatchException;

import static org.example.gestion.IngresarDatos.*;
/*
 *
 * @author Judith Vergara
 * @version 1.0
 *
 */

/**
 * Clase Principal del proyecto
 * La clase Main es el punto de entrada del programa de asesorías en prevención de riesgos.
 * Es responsable de la interacción con el usuario y delega el trabajo a otras clases.
 */
public class Main {
     /**
     * Este método se encarga de iniciar la ejecución del programar
     * Este es el método principal del proyecto
     * @param args es un arreglo con los parámetros que él reciba por consola
     *
     */

    // SRP: La clase Main es responsable de la interacción con el usuario y delega el trabajo a otras clases.
    public static void main(String[] args) {

        Contenedor contenedor = new Contenedor();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println();
            System.out.println("********************************************");
            System.out.println("**** ASESORÍAS EN PREVENCIÓN DE RIESGOS ****");
            System.out.println("********************************************");
            System.out.println("Menu Principal:");
            System.out.println("Ingrese el número de la opción que desea ejecutar:");
            System.out.println("1. Almacenar cliente");
            System.out.println("2. Almacenar profesional");
            System.out.println("3. Almacenar administrativo");
            System.out.println("4. Almacenar capacitación");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Listar usuarios por tipo");
            System.out.println("8. Listar capacitaciones");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        Cliente cliente = crearCliente(scanner);
                        if (contenedor.almacenarCliente(cliente)) {
                            System.out.println("El cliente ha sido almacenado exitosamente.");
                        } else {
                            System.out.println("No se pudo almacenar el cliente.");
                        }
                        break;
                    case 2:
                        Profesional profesional = crearProfesional(scanner);
                        if (contenedor.almacenarProfesional(profesional)) {
                            System.out.println("El profesional ha sido almacenado exitosamente.");
                        } else {
                            System.out.println("No se pudo almacenar el profesional.");
                        }
                        break;
                    case 3:
                        Administrativo administrativo = crearAdministrativo(scanner);
                        if (contenedor.almacenarAdministrativo(administrativo)) {
                            System.out.println("El administrativo ha sido almacenado exitosamente.");
                        } else {
                            System.out.println("No se pudo almacenar el administrativo.");
                        }
                        break;
                    case 4:
                        Capacitacion capacitacion = crearCapacitacion(scanner, contenedor);
                        if (capacitacion != null) {
                            if (contenedor.almacenarCapacitacion(capacitacion)) {
                                System.out.println("La capacitación ha sido almacenada exitosamente.");
                            } else {
                                System.out.println("No se pudo almacenar la capacitación.");
                            }
                        } else {
                            System.out.println("Error: Capacitación no creada.");
                        }
                        break;
                    case 5:
                        System.out.print("Ingrese el RUN del usuario a eliminar: ");
                        long runEliminar = scanner.nextLong();
                        contenedor.eliminarUsuario(runEliminar);
                        break;
                    case 6:
                        contenedor.listarUsuarios();
                        break;
                    case 7:
                        System.out.print("Ingrese el tipo de usuario (1. Cliente, 2. Profesional, 3. Administrativo): ");
                        int tipoUsuario = scanner.nextInt();
                        switch (tipoUsuario) {
                            case 1:
                                contenedor.listarUsuariosPorTipo(Cliente.class);
                                break;
                            case 2:
                                contenedor.listarUsuariosPorTipo(Profesional.class);
                                break;
                            case 3:
                                contenedor.listarUsuariosPorTipo(Administrativo.class);
                                break;
                            default:
                                System.out.println("Tipo de usuario incorrecto.");
                        }
                        break;
                    case 8:
                        contenedor.listarCapacitaciones();
                        break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción incorrecta, por favor intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor ingrese un número entre 1 y 9.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (opcion != 9);

        scanner.close();
    }
}
//Principios SOLID
//SRP:Cada clase tiene una sola responsabilidad.
//OCP: Las clases pueden ser extendidas sin modificar el código existente.
//LSP: Las clases hijas pueden ser tratadas como su clase base sin problemas.
//ISP: La interfaz Asesoria es específica y no fuerza a las clases a implementar métodos innecesarios.
// DIP: La clase Listado depende de la abstracción Asesoria en lugar de depender de implementaciones concretas.



