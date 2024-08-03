package org.example.gestion;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */


/**
 * Clase encargada de la validación de datos ingresados por el usuario para la creación de instancias de {@link Cliente},
 * {@link Profesional}, {@link Administrativo} y {@link Capacitacion}.
 */
public class Validar {

    // Validar sigue el principio SRP, ya que cada método tiene una responsabilidad específica en la validación de datos.


    /**
     * Valida una entrada de texto asegurándose de que no esté vacía y que tenga una longitud dentro del rango especificado.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el texto.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param min El número mínimo de caracteres permitidos.
     * @param max El número máximo de caracteres permitidos.
     * @return El texto validado ingresado por el usuario.
     */
    public static String validarString(String mensaje, Scanner scanner, int min, int max) {
        String input;
        while (true) {
            System.out.print(mensaje);
            input = scanner.nextLine().trim().toUpperCase();
            if (!input.isEmpty() && input.length() >= min && input.length() <= max) {
                break;
            }
            System.out.println("Error: El texto debe tener entre " + min + " y " + max + " caracteres y no puede estar vacío.");
        }
        return input;
    }

    /**
     * Normaliza una cadena de texto eliminando acentos y convirtiéndola a mayúsculas.
     *
     * @param input El texto a normalizar.
     * @return El texto normalizado.
     */
    public static String normalizarString(String input) {
        // Normaliza el texto eliminando acentos y convirtiéndolo a mayúsculas
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toUpperCase();
    }

    /**
     * Valida un día de la semana asegurándose de que sea uno de los días permitidos.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el día.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @return El día de la semana validado ingresado por el usuario.
     */
    public static String validarDia(String mensaje, Scanner scanner) {
        List<String> diasPermitidos = Arrays.asList("LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO");
        // Normaliza los días permitidos
        List<String> diasPermitidosNormalizados = diasPermitidos.stream()
                .map(Validar::normalizarString)
                .toList();

        String dia;
        while (true) {
            System.out.print(mensaje);
            dia = scanner.nextLine().trim().toUpperCase();
            String diaNormalizado = normalizarString(dia);
            if (diasPermitidosNormalizados.contains(diaNormalizado)) {
                break;
            }
            System.out.println("Error: El día debe ser uno de los siguientes: Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo.");
        }
        return dia;
    }

    /**
     * Valida una fecha ingresada por el usuario asegurándose de que esté en el formato especificado.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar la fecha.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param formato El formato esperado de la fecha.
     * @return La fecha validada ingresada por el usuario.
     */
    public static LocalDate validarFecha(String mensaje, Scanner scanner, String formato) {
        LocalDate fecha;
        while (true) {
            System.out.print(mensaje);
            String inputFecha = scanner.nextLine();
            if (inputFecha.isEmpty()) {
                System.out.println("Error: La fecha no puede estar vacía.");
                continue;
            }
            try {
                fecha = LocalDate.parse(inputFecha, DateTimeFormatter.ofPattern(formato));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Fecha no válida. Use el formato " + formato + ".");
            }
        }
        return fecha;
    }


    /**
     * Conjunto para almacenar los RUNs únicos.
     */
    private static Set<Long> runSet = new HashSet<>();
    /**
     * Valida que el valor ingresado sea un número entero de tipo long y que no se repita.
     *
     * @param mensaje El mensaje a mostrar al usuario para solicitar el RUN.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param max El valor máximo permitido para el RUN.
     * @return El RUN validado como un número long.
     */
    public static long validarLong(String mensaje, Scanner scanner, long max) {
        long numero;
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().replaceAll("[.\\-]", "");
            if (input.isEmpty()) {
                System.out.println("Error: El valor no puede estar vacío.");
                continue;
            }
            try {
                numero = Long.parseLong(input);
                if (numero < max) {
                    if (runSet.contains(numero)) {
                        System.out.println("Error: RUN repetido. Ingrese uno válido.");
                    } else {
                        runSet.add(numero);
                        break;
                    }
                } else {
                    System.out.println("Error: El valor debe ser un número menor a " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número válido.");
            }
        }
        return numero;
    }
    /**
     * Valida un número largo (long) ingresado por el usuario, asegurándose de que sea menor que el valor máximo permitido.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el número.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param max El valor máximo permitido para el número.
     * @return El número largo validado ingresado por el usuario.
     */
    public static long validarLongCap(String mensaje, Scanner scanner, long max) {
        long numero;
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().replaceAll("[.\\-]", "");
            if (input.isEmpty()) {
                System.out.println("Error: El valor no puede estar vacío.");
                continue;
            }
            try {
                numero = Long.parseLong(input);
                if (numero < max) {
                    break;
                } else {
                    System.out.println("Error: El valor debe ser un número menor a " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número válido.");
            }
        }
        return numero;
    }
    /**
     * Valida un número de teléfono asegurándose de que tenga exactamente 9 dígitos.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el teléfono.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @return El número de teléfono validado ingresado por el usuario.
     */
    public static String validarTelefono(String mensaje, Scanner scanner) {
        String telefono;
        while (true) {
            System.out.print(mensaje);
            telefono = scanner.nextLine().trim();
            if (telefono.matches("\\d{9}")) {
                break;
            }
            System.out.println("Error: El teléfono debe ser un número de 9 dígitos.");
        }
        return telefono;
    }

    /**
     * Valida un número entero asegurándose de que esté dentro del rango especificado.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el número.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param min El valor mínimo permitido para el número.
     * @param max El valor máximo permitido para el número.
     * @return El número entero validado ingresado por el usuario.
     */
    public static int validarEntero(String mensaje, Scanner scanner, int min, int max) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                numero = Integer.parseInt(input);
                if (numero >= min && numero <= max) {
                    break;
                }
                System.out.println("Error: El valor debe ser un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida. Debe ingresar un número.");
            }
        }
        return numero;
    }

    /**
     * Método que valida una cadena de caracteres.
     *
     * @param mensaje El mensaje a mostrar al usuario.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param minLen  La longitud mínima permitida de la cadena.
     * @param maxLen  La longitud máxima permitida de la cadena.
     * @return La cadena de caracteres validada.
     */
    public static String validarSinNumeros(String mensaje, Scanner scanner, int minLen, int maxLen) {
        String input;
        boolean valido;

        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim().toUpperCase();

            valido = input.length() >= minLen && input.length() <= maxLen && !input.matches(".*\\d.*");

            if (!valido) {
                System.out.println("Error: No debe contener números y debe tener una longitud entre " + minLen + " y " + maxLen + " caracteres.");
            }
        } while (!valido);

        return input;
    }

    /**
     * Valida una cadena de texto asegurándose de que contenga solo letras y tenga una longitud dentro del rango especificado.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar el texto.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param minLength La longitud mínima permitida para el texto.
     * @param maxLength La longitud máxima permitida para el texto.
     * @return El texto validado ingresado por el usuario.
     */
    public static String validarSoloLetras(String mensaje, Scanner scanner, int minLength, int maxLength) {
        String input;
        boolean isValid;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim().toUpperCase();
            isValid = input.length() >= minLength && input.length() <= maxLength && input.matches("[a-zA-Z\\s]+");
            if (!isValid) {
                System.out.println("Entrada inválida. Por favor, ingrese un título que contenga solo letras y tenga entre " + minLength + " y " + maxLength + " caracteres.");
            }
        } while (!isValid);
        return input;
    }

    /**
     * Valida una hora ingresada por el usuario asegurándose de que esté en el formato HH:MM y que sea una hora válida.
     *
     * @param mensaje El mensaje que se muestra al usuario para ingresar la hora.
     * @param scanner El objeto {@link Scanner} usado para leer la entrada del usuario.
     * @param minLength La longitud exacta requerida para la hora (debe ser 5 para formato HH:MM).
     * @return La hora validada ingresada por el usuario.
     */
    public static String validarHora(String mensaje, Scanner scanner, int minLength) {
        String input;
        boolean isValid;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim();
            isValid = input.length() == minLength && input.matches("\\d{2}:\\d{2}") && esHoraValida(input);
            if (!isValid) {
                System.out.println("Entrada inválida. Por favor, ingrese una hora válida en formato HH:MM.");
            }
        } while (!isValid);
        return input;
    }

    /**
     * Verifica si una hora en formato HH:MM es válida.
     *
     * @param hora La hora en formato HH:MM a validar.
     * @return true si la hora es válida; false en caso contrario.
     */
    public static boolean esHoraValida(String hora) {
        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59;
    }

}
