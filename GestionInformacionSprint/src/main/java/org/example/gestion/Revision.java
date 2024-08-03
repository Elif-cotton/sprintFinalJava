package org.example.gestion;

/*
 *
 * @author Judith Vergara
 * @version 1.0
 */

/**
 * Representa una revisión específica realizada durante una visita en terreno.
 */
public class Revision {

    // Principio de Responsabilidad Única (SRP): La clase Revision maneja detalles de una revisión específica.

    /**
     * Identificador único de la revisión.
     */
    private int identificador;
    /**
     * Identificador de la visita en terreno a la que pertenece esta revisión.
     */
    private int idVisitaTerreno;
    /**
     * Nombre o título de la revisión.
     */
    private String nombreRevision;
    /**
     * Detalle o descripción de la revisión.
     */
    private String detalleRevision;
    /**
     * Estado de la revisión. Los posibles valores son:
     * <ul>
     *     <li>1: Sin problemas</li>
     *     <li>2: Con observaciones</li>
     *     <li>3: No aprueba</li>
     * </ul>
     */
    private int estado; // 1 (sin problemas), 2 (con observaciones), 3 (no aprueba)


    /**
     * Constructor por defecto.
     */
    public Revision() {}

    /**
     * Constructor con todos los atributos.
     *
     * @param identificador El identificador único de la revisión.
     * @param estado El estado de la revisión. Debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).
     * @param detalleRevision El detalle de la revisión. No debe tener más de 100 caracteres.
     * @param nombreRevision El nombre de la revisión. Debe tener entre 10 y 50 caracteres.
     * @param idVisitaTerreno El identificador de la visita en terreno a la que pertenece la revisión.
     */
    public Revision(int identificador, int estado, String detalleRevision, String nombreRevision, int idVisitaTerreno) {
        setIdentificador(identificador);
        setEstado(estado);
        setDetalleRevision(detalleRevision);
        setNombreRevision(nombreRevision);
        setIdVisitaTerreno(idVisitaTerreno);
    }


    /**
     * Obtiene el identificador único de la revisión.
     *
     * @return El identificador de la revisión.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador único de la revisión.
     *
     * @param identificador El nuevo identificador de la revisión.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador; // Assuming no additional validation needed
    }

    /**
     * Obtiene el estado de la revisión.
     *
     * @return El estado de la revisión. Puede ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).
     */
    public int getEstado() {
        return estado;
    }
    /**
     * Establece el estado de la revisión.
     *
     * @param estado El nuevo estado de la revisión. Debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).
     * @throws IllegalArgumentException Si el estado no está en el rango permitido (1-3).
     */
    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException("El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
        }
        this.estado = estado;
    }
    /**
     * Obtiene el detalle de la revisión.
     *
     * @return El detalle de la revisión. No debe tener más de 100 caracteres.
     */
    public String getDetalleRevision() {
        return detalleRevision;
    }
    /**
     * Establece el detalle de la revisión.
     *
     * @param detalleRevision El nuevo detalle de la revisión. No debe tener más de 100 caracteres.
     * @throws IllegalArgumentException Si el detalle de la revisión tiene más de 100 caracteres.
     */
    public void setDetalleRevision(String detalleRevision) {
        if (detalleRevision != null && detalleRevision.length() > 100) {
            throw new IllegalArgumentException("El detalle de la revisión no puede tener más de 100 caracteres.");
        }
        this.detalleRevision = detalleRevision;
    }
    /**
     * Obtiene el nombre o título de la revisión.
     *
     * @return El nombre de la revisión. Debe tener entre 10 y 50 caracteres.
     */
    public String getNombreRevision() {
        return nombreRevision;
    }
    /**
     * Establece el nombre o título de la revisión.
     *
     * @param nombreRevision El nuevo nombre de la revisión. Debe tener entre 10 y 50 caracteres.
     * @throws IllegalArgumentException Si el nombre de la revisión es nulo, o tiene menos de 10 caracteres o más de 50 caracteres.
     */
    public void setNombreRevision(String nombreRevision) {
        if (nombreRevision == null || nombreRevision.length() < 10 || nombreRevision.length() > 50) {
            throw new IllegalArgumentException("El nombre de la revisión debe tener entre 10 y 50 caracteres.");
        }
        this.nombreRevision = nombreRevision;
    }
    /**
     * Obtiene el identificador de la visita en terreno a la que pertenece esta revisión.
     *
     * @return El identificador de la visita en terreno.
     */
    public int getIdVisitaTerreno() {
        return idVisitaTerreno;
    }
    /**
     * Establece el identificador de la visita en terreno a la que pertenece esta revisión.
     *
     * @param idVisitaTerreno El nuevo identificador de la visita en terreno.
     */
    public void setIdVisitaTerreno(int idVisitaTerreno) {
        this.idVisitaTerreno = idVisitaTerreno; // Assuming no additional validation needed
    }

    /**
     * Devuelve una representación en cadena de texto de la revisión.
     * <p>
     * La representación incluye el identificador, el nombre de la revisión, el detalle de la revisión y el estado.
     * </p>
     *
     * @return Una cadena que representa la revisión.
     */
    @Override
    public String toString() {
        String estadoString;
        switch (estado) {
            case 1:
                estadoString = "Sin problemas";
                break;
            case 2:
                estadoString = "Con observaciones";
                break;
            case 3:
                estadoString = "No aprueba";
                break;
            default:
                estadoString = "Estado desconocido";
        }
        return "Revisión #" + identificador +
                "\nNombre: " + nombreRevision +
                "\nDetalle: " + detalleRevision +
                "\nEstado: " + estadoString;
    }
}
