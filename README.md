# Sistema de Triage Básico para Puestos de Salud

## Descripción General

Este proyecto implementa un sistema básico de triage para puestos de salud utilizando Java, Swing y Derby como base de datos. La aplicación permite registrar pacientes, clasificarlos según su nivel de urgencia y administrar los datos almacenados mediante operaciones CRUD.

## Clasificación Utilizada

La prioridad clínica se determina a partir del nivel de dolor, la frecuencia cardíaca y la temperatura corporal.

- **Rojo (Emergencia)**: dolor ≥ 8, frecuencia ≥ 120 o temperatura ≥ 39°C
- **Amarillo (Prioritaria)**: dolor entre 5 y 7, frecuencia entre 100 y 119 o temperatura entre 37.5 y 38.9°C
- **Verde (Normal)**: valores fuera de los rangos anteriores

El sistema aplica esta clasificación automáticamente durante el registro o modificación de los datos del paciente.

## Tecnologías

- Java (JDK 17 o superior)
- NetBeans 12 o superior
- Apache Derby (Java DB)
- Swing
- JDBC usando el patrón DAO

## Organización del Proyecto

```
SistemaTriageBasico/
├── src/
│   ├── modelo/
│   ├── dao/
│   ├── controlador/
│   ├── vista/
│   └── util/
├── base_datos/
│   └── script_triagedb.sql
├── documentos/
└── README.md
```

La estructura separa claramente el modelo de datos, el acceso a la base de datos, la lógica del controlador y la interfaz gráfica.

## Funcionalidades Principales

- Registro de pacientes con validación de campos
- Visualización de registros en una tabla
- Actualización de datos
- Eliminación con confirmación
- Clasificación automática por triage
- Búsqueda por nombre
- Indicadores visuales de la clasificación
- Persistencia mediante Java DB

## Requisitos del Sistema

- JDK 17 o superior
- NetBeans 12 o superior
- Windows 10/11, Linux o macOS
- Al menos 4 GB de RAM

## Ejecución del Proyecto

### Desde NetBeans

1. Abrir NetBeans
2. Seleccionar File → Open Project
3. Elegir la carpeta del proyecto
4. Ejecutar con Run

### Desde línea de comandos

```bash
cd SistemaTriageBasico/src
javac -d ../bin modelo/*.java dao/*.java util/*.java controlador/*.java vista/*.java
cd ../bin
java vista.VentanaPrincipal
```

## Base de Datos

El sistema utiliza Apache Derby.
El script de creación se encuentra en:

```
/base_datos/script_triagedb.sql
```

Al ejecutarse por primera vez, la aplicación crea la base local denominada `triageDB`.

## Uso General

- **Registrar**: completar el formulario y guardar
- **Buscar**: ingresar un nombre o parte del nombre
- **Actualizar**: seleccionar un registro y modificarlo
- **Eliminar**: seleccionar un registro y confirmar la acción

## Validaciones Aplicadas

- Nombre obligatorio
- Edad entre 1 y 120 años
- Temperatura entre 30 y 45°C
- Frecuencia entre 1 y 250 lpm
- Nivel de dolor entre 1 y 10

## Documentación Incluida

En el directorio `documentos` se encuentran:

- Plan de pruebas
- Casos de prueba
- Registro de defectos
- Informe final de calidad

## Autoría

<<<<<<< HEAD
**Estudiante**: [Tu Nombre]  
=======
**Estudiante**: Luis Javier Ali
>>>>>>> e72a7e0bcd44e09bfa6abf92b9d5d4aa3ad93b41
**Carrera**: Sistemas de Información en Salud  
**Universidad Estatal a Distancia (UNED)**  
**Curso**: 03572 – Herramientas de Desarrollo y Calidad en SIS  
**Año**: 2025

## Nota

Este proyecto es de carácter académico y no debe emplearse en contextos clínicos reales.
