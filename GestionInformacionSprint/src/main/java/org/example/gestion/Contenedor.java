package org.example.gestion;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa un contenedor para almacenar y gestionar usuarios y capacitaciones.
 *
 */
public class Contenedor {

    // Principio de Inversión de Dependencias (DIP) La clase Listado depende de la abstracción Asesoria en lugar de depender de implementaciones concretas.

    /**
     * Lista de usuarios, que puede contener instancias de {@link Cliente}, {@link Profesional}, {@link Administrativo}.
     */
    private List<Usuario> usuarios;

    /**
     * Lista de capacitaciones registradas.
     */
    private List<Capacitacion> capacitaciones;

    /**
     * Constructor por defecto que inicializa las listas de usuarios y capacitaciones.
     */
    public Contenedor() {
        this.usuarios = new ArrayList<>();
        this.capacitaciones = new ArrayList<>();
    }

    /**
     * Almacena un cliente en la lista de usuarios.
     *
     * @param cliente El cliente a almacenar.
     * @return true si el cliente fue almacenado exitosamente, false en caso contrario.
     */
    public boolean almacenarCliente(Cliente cliente) {
        return usuarios.add(cliente);
    }

    /**
     * Almacena un profesional en la lista de usuarios.
     *
     * @param profesional El profesional a almacenar.
     * @return true si el profesional fue almacenado exitosamente, false en caso contrario.
     */
    public boolean almacenarProfesional(Profesional profesional) {
        return usuarios.add(profesional);
    }


    /**
     * Almacena un administrativo en la lista de usuarios.
     *
     * @param administrativo El administrativo a almacenar.
     * @return true si el administrativo fue almacenado exitosamente, false en caso contrario.
     */
    public boolean almacenarAdministrativo(Administrativo administrativo) {
        return usuarios.add(administrativo);
    }

    /**
     * Almacena una capacitación en la lista de capacitaciones.
     *
     * @param capacitacion La capacitación a almacenar.
     * @return true si la capacitación fue almacenada exitosamente, false en caso contrario.
     */
    public boolean almacenarCapacitacion(Capacitacion capacitacion) {
        return capacitaciones.add(capacitacion);
    }


    /**
     * Elimina un usuario de la lista de usuarios y las capacitaciones asociadas.
     *
     * <p>Este método busca un usuario en la lista de usuarios utilizando el RUN proporcionado. Si el usuario se encuentra y se elimina con éxito, el método procede a eliminar todas las capacitaciones asociadas a dicho usuario utilizando el RUN proporcionado.</p>
     *
     * <p>Si el usuario no se encuentra en la lista, el método imprime un mensaje de error indicando que el usuario no fue encontrado. Si el usuario se elimina con éxito, el método también imprime un mensaje indicando que las capacitaciones asociadas han sido eliminadas.</p>
     *
     * @param run El RUN del usuario que se desea eliminar. Este valor se utiliza para identificar al usuario en la lista y también para encontrar y eliminar las capacitaciones asociadas a dicho usuario.
     */
    public void eliminarUsuario(long run) {
        // Elimina al usuario si existe
        boolean eliminado = usuarios.removeIf(usuario -> usuario.getRun() == run);

        if (eliminado) {
            // Elimina las capacitaciones asociadas
            capacitaciones.removeIf(capacitacion -> capacitacion.getRutCliente() == run);

            System.out.println("Usuario con RUN " + run + " eliminado con éxito.");
            System.out.println("Si tenía Capacitaciones asociadas también han sido eliminadas.");
        } else {
            System.out.println("Error: Usuario con RUN " + run + " no encontrado.");
        }
    }

    /**
     * Lista todos los usuarios registrados.
     * Muestra información de cada usuario si está registrado. Si no hay usuarios, muestra un mensaje indicando que no hay usuarios registrados.
     */
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    /**
     * Lista todos los usuarios registrados de un tipo específico.
     *
     * @param tipo El tipo de usuario a listar.
     */
    public void listarUsuariosPorTipo(Class<?> tipo) {
        List<Usuario> usuariosFiltrados = usuarios.stream()
                .filter(tipo::isInstance)
                .toList();

        if (usuariosFiltrados.isEmpty()) {
            System.out.println("No hay usuarios del tipo " + tipo.getSimpleName() + " registrados.");
        } else {
            usuariosFiltrados.forEach(System.out::println);
        }
    }

    /**
     * Lista todas las capacitaciones registradas.
     * <p>
     * Este método verifica si hay capacitaciones registradas en la lista {@code capacitaciones}.
     * Si no hay capacitaciones, imprime un mensaje indicando que no hay registros.
     * Si hay capacitaciones, imprime detalles de cada una, incluyendo:
     * <ul>
     *     <li>Un resumen de la capacitación utilizando el método {@code mostrarDetalle()}.</li>
     *     <li>Información completa de la capacitación utilizando el método {@code toString()}.</li>
     *     <li>Información del cliente asociado a la capacitación.</li>
     * </ul>
     * Al final de los detalles de cada capacitación, se imprime un separador para mayor claridad.
     */
    public void listarCapacitaciones() {
        if (capacitaciones.isEmpty()) {
            System.out.println("No hay capacitaciones registradas.");
        } else {
            for (Capacitacion capacitacion : capacitaciones) {
                // Mostrar detalles usando mostrarDetalle()
                System.out.println("Resumen Capacitación:");
                System.out.println(capacitacion.mostrarDetalle());
                System.out.println();
                // Mostrar detalles usando toString()
                System.out.println("Información Completa Capacitación:");
                System.out.println(capacitacion.toString());

                // Mostrar los clientes asociados a la capacitación
                System.out.println("Información Cliente:");
                usuarios.stream()
                        .filter(usuario -> usuario instanceof Cliente &&
                                ((Cliente) usuario).getRun() == capacitacion.getRutCliente())
                        .forEach(System.out::println);

                // Separador entre capacitaciones para mayor claridad
                System.out.println("--------------------------------------------------");
            }
        }
    }

    /**
     * Busca un cliente por su RUN en la lista de usuarios.
     *
     * @param run El RUN del cliente a buscar.
     * @return El cliente correspondiente al RUN especificado, o {@code null} si no se encuentra.
     */
    public Cliente buscarClientePorRut(long run) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente && ((Cliente) usuario).getRun() == run) {
                return (Cliente) usuario;
            }
        }
        return null;
    }
}
