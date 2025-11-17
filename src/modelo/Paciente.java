package modelo;

/**
 * Clase que representa un paciente en el sistema de triage
 */
public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String motivo;
    private double temperatura;
    private int frecuenciaCardiaca;
    private int nivelDolor;
    private String clasificacion;

    public Paciente() {
    }

    public Paciente(String nombre, int edad, String motivo, double temperatura, 
                    int frecuenciaCardiaca, int nivelDolor) {
        this.nombre = nombre;
        this.edad = edad;
        this.motivo = motivo;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelDolor = nivelDolor;
        this.clasificacion = calcularClasificacion();
    }

    /**
     * Calcula la clasificación de triage según los parámetros vitales
     */
    private String calcularClasificacion() {
        if (nivelDolor >= 8 || frecuenciaCardiaca >= 120 || temperatura >= 39.0) {
            return "Emergencia (Rojo)";
        } else if ((nivelDolor >= 5 && nivelDolor <= 7) || 
                   (frecuenciaCardiaca >= 100 && frecuenciaCardiaca <= 119) || 
                   (temperatura >= 37.5 && temperatura <= 38.9)) {
            return "Atención Prioritaria (Amarillo)";
        } else {
            return "Atención Normal (Verde)";
        }
    }

    public void recalcularClasificacion() {
        this.clasificacion = calcularClasificacion();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        recalcularClasificacion();
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        recalcularClasificacion();
    }

    public int getNivelDolor() {
        return nivelDolor;
    }

    public void setNivelDolor(int nivelDolor) {
        this.nivelDolor = nivelDolor;
        recalcularClasificacion();
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
