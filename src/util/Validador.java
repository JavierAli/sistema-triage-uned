package util;

/**
 * Clase para validar datos de entrada
 */
public class Validador {

    /**
     * Valida que un texto no esté vacío
     */
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que la edad sea válida
     */
    public static boolean validarEdad(int edad) {
        return edad > 0 && edad <= 120;
    }

    /**
     * Valida que la temperatura esté en rango válido
     */
    public static boolean validarTemperatura(double temperatura) {
        return temperatura >= 30.0 && temperatura <= 45.0;
    }

    /**
     * Valida que la frecuencia cardíaca sea válida
     */
    public static boolean validarFrecuenciaCardiaca(int frecuencia) {
        return frecuencia > 0 && frecuencia <= 250;
    }

    /**
     * Valida que el nivel de dolor esté en escala 1-10
     */
    public static boolean validarNivelDolor(int dolor) {
        return dolor >= 1 && dolor <= 10;
    }

    /**
     * Valida todos los campos de un paciente
     */
    public static String validarPaciente(String nombre, String edadStr, String motivo,
                                         String tempStr, String frecStr, String dolorStr) {
        if (!validarTextoNoVacio(nombre)) {
            return "El nombre es obligatorio";
        }

        if (!validarTextoNoVacio(motivo)) {
            return "El motivo de consulta es obligatorio";
        }

        try {
            int edad = Integer.parseInt(edadStr);
            if (!validarEdad(edad)) {
                return "La edad debe estar entre 1 y 120 años";
            }
        } catch (NumberFormatException e) {
            return "La edad debe ser un número válido";
        }

        try {
            double temp = Double.parseDouble(tempStr);
            if (!validarTemperatura(temp)) {
                return "La temperatura debe estar entre 30 y 45 °C";
            }
        } catch (NumberFormatException e) {
            return "La temperatura debe ser un número válido";
        }

        try {
            int frec = Integer.parseInt(frecStr);
            if (!validarFrecuenciaCardiaca(frec)) {
                return "La frecuencia cardíaca debe ser mayor a 0 y menor a 250 lpm";
            }
        } catch (NumberFormatException e) {
            return "La frecuencia cardíaca debe ser un número válido";
        }

        try {
            int dolor = Integer.parseInt(dolorStr);
            if (!validarNivelDolor(dolor)) {
                return "El nivel de dolor debe estar entre 1 y 10";
            }
        } catch (NumberFormatException e) {
            return "El nivel de dolor debe ser un número válido";
        }

        return null; // Sin errores
    }
}
