package controlador;

import dao.PacienteDAO;
import modelo.Paciente;
import util.Validador;
import java.util.List;

/**
 * Controlador para gestionar la lógica de negocio de pacientes
 */
public class ControladorPaciente {
    private PacienteDAO pacienteDAO;

    public ControladorPaciente() {
        pacienteDAO = new PacienteDAO();
        pacienteDAO.crearTabla();
    }

    /**
     * Guarda un nuevo paciente
     */
    public String guardarPaciente(String nombre, String edad, String motivo,
                                  String temperatura, String frecuencia, String dolor) {
        // Validar datos
        String error = Validador.validarPaciente(nombre, edad, motivo, temperatura, frecuencia, dolor);
        if (error != null) {
            return error;
        }

        // Crear paciente
        Paciente paciente = new Paciente(
            nombre.trim(),
            Integer.parseInt(edad),
            motivo.trim(),
            Double.parseDouble(temperatura),
            Integer.parseInt(frecuencia),
            Integer.parseInt(dolor)
        );

        // Guardar en BD
        if (pacienteDAO.insertar(paciente)) {
            return "Paciente guardado exitosamente";
        } else {
            return "Error al guardar el paciente en la base de datos";
        }
    }

    /**
     * Actualiza un paciente existente
     */
    public String actualizarPaciente(int id, String nombre, String edad, String motivo,
                                     String temperatura, String frecuencia, String dolor) {
        // Validar datos
        String error = Validador.validarPaciente(nombre, edad, motivo, temperatura, frecuencia, dolor);
        if (error != null) {
            return error;
        }

        // Crear paciente con datos actualizados
        Paciente paciente = new Paciente(
            nombre.trim(),
            Integer.parseInt(edad),
            motivo.trim(),
            Double.parseDouble(temperatura),
            Integer.parseInt(frecuencia),
            Integer.parseInt(dolor)
        );
        paciente.setId(id);

        // Actualizar en BD
        if (pacienteDAO.actualizar(paciente)) {
            return "Paciente actualizado exitosamente";
        } else {
            return "Error al actualizar el paciente en la base de datos";
        }
    }

    /**
     * Elimina un paciente
     */
    public boolean eliminarPaciente(int id) {
        return pacienteDAO.eliminar(id);
    }

    /**
     * Lista todos los pacientes
     */
    public List<Paciente> listarPacientes() {
        return pacienteDAO.listarTodos();
    }

    /**
     * Busca pacientes por nombre
     */
    public List<Paciente> buscarPacientes(String nombre) {
        return pacienteDAO.buscarPorNombre(nombre);
    }
}
