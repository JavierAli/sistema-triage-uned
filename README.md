# Sistema de Triage Básico para Puestos de Salud

## Descripción del Proyecto

Sistema de clasificación de pacientes según prioridad médica (triage) desarrollado en Java con interfaz gráfica Swing y base de datos Derby. Permite registrar, clasificar y gestionar pacientes en puestos de salud.

## Clasificación de Triage

- 🔴 **Rojo (Emergencia):** Dolor ≥8 O Frecuencia ≥120 O Temperatura ≥39°C
- 🟡 **Amarillo (Prioritaria):** Dolor 5-7 O Frecuencia 100-119 O Temperatura 37.5-38.9°C
- 🟢 **Verde (Normal):** Todos los demás casos

## Tecnologías Utilizadas

- **Lenguaje:** Java 17+
- **IDE:** NetBeans 12+
- **Base de Datos:** Apache Derby (Java DB)
- **Interfaz:** Swing (javax.swing)
- **Persistencia:** JDBC con patrón DAO

## Estructura del Proyecto

```
SistemaTriageBasico/
├── src/
│   ├── modelo/
│   │   └── Paciente.java
│   ├── dao/
│   │   └── PacienteDAO.java
│   ├── controlador/
│   │   └── ControladorPaciente.java
│   ├── vista/
│   │   └── VentanaPrincipal.java
│   └── util/
│       ├── Conexion.java
│       └── Validador.java
├── base_datos/
│   └── script_triagedb.sql
├── documentos/
│   ├── plan_pruebas.md
│   ├── casos_prueba.md
│   ├── registro_defectos.md
│   └── informe_calidad.md
└── README.md
```

## Funcionalidades Implementadas

### Operaciones CRUD
- ✅ Crear: Registrar nuevos pacientes
- ✅ Leer: Visualizar lista de pacientes en tabla
- ✅ Actualizar: Modificar datos de pacientes existentes
- ✅ Eliminar: Borrar registros con confirmación

### Características Adicionales
- ✅ Clasificación automática de triage
- ✅ Búsqueda de pacientes por nombre
- ✅ Validación de datos de entrada
- ✅ Colores visuales según clasificación
- ✅ Conexión persistente a base de datos
- ✅ Interfaz gráfica intuitiva

## Requisitos del Sistema

- **JDK:** 17 o superior
- **NetBeans:** 12 o superior
- **Sistema Operativo:** Windows 10/11 (compatible con Linux/Mac)
- **Memoria RAM:** Mínimo 4GB

## Instalación y Ejecución

### Opción 1: Desde NetBeans

1. Abrir NetBeans
2. File → Open Project
3. Seleccionar la carpeta `SistemaTriageBasico`
4. Click derecho en el proyecto → Run

### Opción 2: Desde línea de comandos

```bash
cd SistemaTriageBasico/src
javac -d ../bin modelo/*.java dao/*.java util/*.java controlador/*.java vista/*.java
cd ../bin
java vista.VentanaPrincipal
```

## Configuración de la Base de Datos

La base de datos Derby se crea automáticamente al ejecutar la aplicación por primera vez. El script SQL de referencia está en `base_datos/script_triagedb.sql`.

**Ubicación de la BD:** Se crea en el directorio raíz del proyecto como `triageDB/`

## Uso del Sistema

1. **Registrar Paciente:**
   - Llenar todos los campos del formulario
   - Click en "Guardar Paciente"
   - El sistema clasifica automáticamente

2. **Buscar Paciente:**
   - Ingresar nombre en campo de búsqueda
   - Click en "Buscar"
   - Click en "Mostrar Todos" para ver lista completa

3. **Actualizar Paciente:**
   - Seleccionar paciente en la tabla
   - Modificar campos necesarios
   - Click en "Actualizar Paciente"

4. **Eliminar Paciente:**
   - Seleccionar paciente en la tabla
   - Click en "Eliminar Paciente"
   - Confirmar eliminación

## Validaciones Implementadas

- Nombre: No vacío
- Edad: 1-120 años
- Temperatura: 30-45°C
- Frecuencia Cardíaca: 1-250 lpm
- Nivel de Dolor: 1-10

## Documentación de Calidad

El proyecto incluye documentación completa de aseguramiento de calidad:

- **Plan de Pruebas:** Estrategia y alcance de las pruebas
- **Casos de Prueba:** 15 casos documentados
- **Registro de Defectos:** Seguimiento de errores encontrados
- **Informe de Calidad:** Análisis final y reflexión ética

## Autor

**Estudiante:** [Tu Nombre Completo]  
**Carrera:** Sistemas de Información en Salud  
**Universidad:** UNED  
**Curso:** 03572 - Herramientas de Desarrollo y Calidad en SIS  
**Año:** 2025

## Licencia

Proyecto académico desarrollado para fines educativos.

## Contacto

Para consultas sobre el proyecto: [Tu correo institucional UNED]

---

**Nota:** Este sistema es un prototipo educativo y no debe utilizarse en entornos médicos reales sin las certificaciones y validaciones correspondientes.
