package vista;

import controlador.ControladorPaciente;
import modelo.Paciente;
import util.Conexion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.util.List;

/**
 * Ventana principal del sistema de triage
 */
public class VentanaPrincipal extends JFrame {
    private ControladorPaciente controlador;
    
    // Componentes de formulario
    private JTextField txtNombre, txtEdad, txtMotivo, txtTemperatura, txtFrecuencia, txtDolor, txtBuscar;
    private JButton btnGuardar, btnActualizar, btnEliminar, btnLimpiar, btnBuscar, btnMostrarTodos;
    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;
    private JLabel lblClasificacion;
    
    private int idSeleccionado = -1;

    public VentanaPrincipal() {
        controlador = new ControladorPaciente();
        inicializarComponentes();
        configurarCierreVentana();
        cargarDatos();
    }

    private void configurarCierreVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(
                    VentanaPrincipal.this,
                    "¿Está seguro que desea salir del sistema?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (confirmacion == JOptionPane.YES_OPTION) {
                    Conexion.cerrarConexion();
                    System.exit(0);
                }
            }
        });
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Triage Básico - Puesto de Salud");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior con logo y título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelTitulo.setBackground(new Color(41, 128, 185));
        
        // Intentar cargar logotipo
        try {
            ImageIcon logoIcon = new ImageIcon("resources/logotipo.png");
            if (logoIcon.getIconWidth() > 0) {
                Image img = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                JLabel lblLogo = new JLabel(new ImageIcon(img));
                panelTitulo.add(lblLogo);
            }
        } catch (Exception e) {
            System.out.println("Logotipo no encontrado en resources/logotipo.png");
        }
        
        JLabel lblTitulo = new JLabel("SISTEMA DE TRIAGE BÁSICO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel izquierdo - Formulario
        JPanel panelFormulario = crearPanelFormulario();
        add(panelFormulario, BorderLayout.WEST);

        // Panel central - Tabla
        JPanel panelTabla = crearPanelTabla();
        add(panelTabla, BorderLayout.CENTER);

        // Panel inferior - Búsqueda
        JPanel panelBusqueda = crearPanelBusqueda();
        add(panelBusqueda, BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(new Dimension(350, 0));

        JLabel lblFormulario = new JLabel("Registro de Paciente");
        lblFormulario.setFont(new Font("Arial", Font.BOLD, 16));
        lblFormulario.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblFormulario);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Campos del formulario
        panel.add(crearCampo("Nombre completo:", txtNombre = new JTextField(20)));
        panel.add(crearCampo("Edad:", txtEdad = new JTextField(20)));
        panel.add(crearCampo("Motivo de consulta:", txtMotivo = new JTextField(20)));
        panel.add(crearCampo("Temperatura (°C):", txtTemperatura = new JTextField(20)));
        panel.add(crearCampo("Frecuencia cardíaca (lpm):", txtFrecuencia = new JTextField(20)));
        panel.add(crearCampo("Nivel de dolor (1-10):", txtDolor = new JTextField(20)));

        // Clasificación
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        lblClasificacion = new JLabel("Clasificación: ---");
        lblClasificacion.setFont(new Font("Arial", Font.BOLD, 14));
        lblClasificacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblClasificacion);

        // Botones
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(crearPanelBotones());

        return panel;
    }

    private JPanel crearCampo(String etiqueta, JTextField campo) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setMaximumSize(new Dimension(330, 60));
        JLabel lbl = new JLabel(etiqueta);
        lbl.setPreferredSize(new Dimension(330, 20));
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(campo, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        
        btnGuardar = new JButton("Guardar Paciente");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(e -> guardarPaciente());

        btnActualizar = new JButton("Actualizar Paciente");
        btnActualizar.setBackground(new Color(52, 152, 219));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(e -> actualizarPaciente());

        btnEliminar = new JButton("Eliminar Paciente");
        btnEliminar.setBackground(new Color(231, 76, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(e -> eliminarPaciente());

        btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setBackground(new Color(149, 165, 166));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(e -> limpiarCampos());

        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);

        return panel;
    }

    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTabla = new JLabel("Lista de Pacientes Registrados");
        lblTabla.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblTabla, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Edad", "Motivo", "Temp(°C)", "FC(lpm)", "Dolor", "Clasificación"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPacientes = new JTable(modeloTabla);
        tablaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPacientes.setOpaque(false);
        tablaPacientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarPacienteSeleccionado();
            }
        });

        // Renderizador para colorear filas según clasificación
        tablaPacientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    String clasificacion = (String) table.getValueAt(row, 7);
                    if (clasificacion.contains("Rojo")) {
                        c.setBackground(new Color(255, 200, 200, 200));
                    } else if (clasificacion.contains("Amarillo")) {
                        c.setBackground(new Color(255, 255, 200, 200));
                    } else if (clasificacion.contains("Verde")) {
                        c.setBackground(new Color(200, 255, 200, 200));
                    }
                }
                return c;
            }
        });

        // ScrollPane con logotipo de fondo
        JScrollPane scrollPane = new JScrollPane(tablaPacientes) {
            private Image logoFondo;
            
            {
                try {
                    ImageIcon icon = new ImageIcon("resources/logotipo.png");
                    if (icon.getIconWidth() > 0) {
                        logoFondo = icon.getImage();
                    }
                } catch (Exception e) {
                    logoFondo = null;
                }
                setOpaque(false);
                getViewport().setOpaque(false);
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (logoFondo != null) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
                    
                    int anchoDisponible = getWidth() - 40;
                    int altoDisponible = getHeight() - 40;
                    int anchoLogo = logoFondo.getWidth(null);
                    int altoLogo = logoFondo.getHeight(null);
                    
                    double escala = Math.min((double)anchoDisponible / anchoLogo, (double)altoDisponible / altoLogo);
                    int nuevoAncho = (int)(anchoLogo * escala);
                    int nuevoAlto = (int)(altoLogo * escala);
                    
                    int x = (getWidth() - nuevoAncho) / 2;
                    int y = (getHeight() - nuevoAlto) / 2;
                    
                    g2d.drawImage(logoFondo, x, y, nuevoAncho, nuevoAlto, null);
                    g2d.dispose();
                }
            }
        };
        
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelBusqueda() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Búsqueda de Pacientes"));

        panel.add(new JLabel("Buscar por nombre:"));
        txtBuscar = new JTextField(20);
        panel.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(52, 152, 219));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.addActionListener(e -> buscarPacientes());
        panel.add(btnBuscar);

        btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBackground(new Color(52, 152, 219));
        btnMostrarTodos.setForeground(Color.WHITE);
        btnMostrarTodos.addActionListener(e -> cargarDatos());
        panel.add(btnMostrarTodos);

        return panel;
    }

    private void guardarPaciente() {
        String mensaje = controlador.guardarPaciente(
            txtNombre.getText(),
            txtEdad.getText(),
            txtMotivo.getText(),
            txtTemperatura.getText(),
            txtFrecuencia.getText(),
            txtDolor.getText()
        );

        if (mensaje.equals("Paciente guardado exitosamente")) {
            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            cargarDatos();
        } else {
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPaciente() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mensaje = controlador.actualizarPaciente(
            idSeleccionado,
            txtNombre.getText(),
            txtEdad.getText(),
            txtMotivo.getText(),
            txtTemperatura.getText(),
            txtFrecuencia.getText(),
            txtDolor.getText()
        );

        if (mensaje.equals("Paciente actualizado exitosamente")) {
            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            cargarDatos();
        } else {
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPaciente() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de eliminar este paciente?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (controlador.eliminarPaciente(idSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar paciente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarPacientes() {
        String nombre = txtBuscar.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Paciente> pacientes = controlador.buscarPacientes(nombre);
        actualizarTabla(pacientes);

        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con ese nombre", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarDatos() {
        List<Paciente> pacientes = controlador.listarPacientes();
        actualizarTabla(pacientes);
        txtBuscar.setText("");
    }

    private void actualizarTabla(List<Paciente> pacientes) {
        modeloTabla.setRowCount(0);
        for (Paciente p : pacientes) {
            modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getEdad(),
                p.getMotivo(),
                p.getTemperatura(),
                p.getFrecuenciaCardiaca(),
                p.getNivelDolor(),
                p.getClasificacion()
            });
        }
    }

    private void cargarPacienteSeleccionado() {
        int fila = tablaPacientes.getSelectedRow();
        if (fila >= 0) {
            idSeleccionado = (int) modeloTabla.getValueAt(fila, 0);
            txtNombre.setText((String) modeloTabla.getValueAt(fila, 1));
            txtEdad.setText(String.valueOf(modeloTabla.getValueAt(fila, 2)));
            txtMotivo.setText((String) modeloTabla.getValueAt(fila, 3));
            txtTemperatura.setText(String.valueOf(modeloTabla.getValueAt(fila, 4)));
            txtFrecuencia.setText(String.valueOf(modeloTabla.getValueAt(fila, 5)));
            txtDolor.setText(String.valueOf(modeloTabla.getValueAt(fila, 6)));
            lblClasificacion.setText("Clasificación: " + modeloTabla.getValueAt(fila, 7));
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtMotivo.setText("");
        txtTemperatura.setText("");
        txtFrecuencia.setText("");
        txtDolor.setText("");
        txtBuscar.setText("");
        lblClasificacion.setText("Clasificación: ---");
        idSeleccionado = -1;
        tablaPacientes.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
