package dao;

import modelo.Paciente;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para operaciones CRUD de Paciente
 */
public class PacienteDAO {

    /**
     * Crea la tabla de pacientes si no existe
     */
    public void crearTabla() {
        String sql = "CREATE TABLE pacientes (" +
                     "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                     "nombre VARCHAR(100) NOT NULL, " +
                     "edad INT NOT NULL, " +
                     "motivo VARCHAR(200) NOT NULL, " +
                     "temperatura DOUBLE NOT NULL, " +
                     "frecuencia_cardiaca INT NOT NULL, " +
                     "nivel_dolor INT NOT NULL, " +
                     "clasificacion VARCHAR(50) NOT NULL)";
        
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla pacientes creada");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("X0Y32")) {
                System.err.println("Error al crear tabla: " + e.getMessage());
            }
        }
    }

    /**
     * Inserta un nuevo paciente
     */
    public boolean insertar(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, edad, motivo, temperatura, " +
                     "frecuencia_cardiaca, nivel_dolor, clasificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, paciente.getNombre());
            pstmt.setInt(2, paciente.getEdad());
            pstmt.setString(3, paciente.getMotivo());
            pstmt.setDouble(4, paciente.getTemperatura());
            pstmt.setInt(5, paciente.getFrecuenciaCardiaca());
            pstmt.setInt(6, paciente.getNivelDolor());
            pstmt.setString(7, paciente.getClasificacion());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar paciente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Lista todos los pacientes
     */
    public List<Paciente> listarTodos() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes ORDER BY id";
        
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setMotivo(rs.getString("motivo"));
                p.setTemperatura(rs.getDouble("temperatura"));
                p.setFrecuenciaCardiaca(rs.getInt("frecuencia_cardiaca"));
                p.setNivelDolor(rs.getInt("nivel_dolor"));
                p.setClasificacion(rs.getString("clasificacion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pacientes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Busca pacientes por nombre
     */
    public List<Paciente> buscarPorNombre(String nombre) {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes WHERE UPPER(nombre) LIKE ? ORDER BY id";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + nombre.toUpperCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setMotivo(rs.getString("motivo"));
                p.setTemperatura(rs.getDouble("temperatura"));
                p.setFrecuenciaCardiaca(rs.getInt("frecuencia_cardiaca"));
                p.setNivelDolor(rs.getInt("nivel_dolor"));
                p.setClasificacion(rs.getString("clasificacion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pacientes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Actualiza un paciente existente
     */
    public boolean actualizar(Paciente paciente) {
        String sql = "UPDATE pacientes SET nombre=?, edad=?, motivo=?, temperatura=?, " +
                     "frecuencia_cardiaca=?, nivel_dolor=?, clasificacion=? WHERE id=?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, paciente.getNombre());
            pstmt.setInt(2, paciente.getEdad());
            pstmt.setString(3, paciente.getMotivo());
            pstmt.setDouble(4, paciente.getTemperatura());
            pstmt.setInt(5, paciente.getFrecuenciaCardiaca());
            pstmt.setInt(6, paciente.getNivelDolor());
            pstmt.setString(7, paciente.getClasificacion());
            pstmt.setInt(8, paciente.getId());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un paciente por ID
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM pacientes WHERE id=?";
        
        try (Connection conn = Conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }
}
