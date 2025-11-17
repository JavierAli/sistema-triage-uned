# Plan de Pruebas del Proyecto – Sistema de Triage Básico

**Estudiante:** [Tu Nombre Completo]  
**Carrera:** Sistemas de Información en Salud  
**Universidad Estatal a Distancia (UNED)**  
**Fecha:** [Fecha actual]  
**Versión del Documento:** 1.0

---

## 1. Objetivo

Establecer el marco de trabajo para la ejecución de pruebas del Sistema de Triage Básico, definiendo los procedimientos, criterios y recursos necesarios para validar que el sistema cumpla con los requerimientos funcionales especificados, asegurando la calidad, confiabilidad y correcto funcionamiento del software antes de su entrega final.

---

## 2. Alcance

Este plan abarca las pruebas funcionales del sistema, enfocadas en las operaciones CRUD, clasificación de triage, validación de datos, y conexión con la base de datos.

**No incluye:** pruebas de rendimiento, seguridad avanzada o carga concurrente.

---

## 3. Estrategia de Pruebas

| Tipo de Prueba | Descripción | Herramienta |
|----------------|-------------|-------------|
| Pruebas funcionales | Validación de requerimientos CRUD y clasificación | Manual / GUI |
| Pruebas de validación | Verificación de límites y datos inválidos | Manual |
| Pruebas de interfaz | Revisión de colores, mensajes y usabilidad | Manual visual |
| Pruebas de conexión | Prueba de conexión y manejo de error de BD | JDBC / Derby |

---

## 4. Criterios de Aceptación

- Todos los casos de prueba críticos deben ejecutarse con éxito
- No deben existir defectos abiertos con severidad Alta
- La clasificación del paciente debe coincidir con las reglas definidas
- Los mensajes de validación deben mostrarse correctamente
- La tabla debe actualizarse automáticamente después de cada operación CRUD

---

## 5. Cronograma

| Actividad | Fecha Inicio | Fecha Fin | Responsable | Estado |
|-----------|--------------|-----------|-------------|--------|
| Diseño de casos de prueba | [Ej: 10/11/2025] | [Ej: 12/11/2025] | [Tu nombre] | Completado |
| Implementación del sistema | [Ej: 13/11/2025] | [Ej: 18/11/2025] | [Tu nombre] | Completado |
| Ejecución de pruebas funcionales | [Ej: 19/11/2025] | [Ej: 20/11/2025] | [Tu nombre] | Completado |
| Registro y corrección de defectos | [Ej: 20/11/2025] | [Ej: 21/11/2025] | [Tu nombre] | Completado |
| Elaboración del informe final | [Ej: 21/11/2025] | [Ej: 22/11/2025] | [Tu nombre] | Completado |
| Revisión y entrega | [Ej: 22/11/2025] | [Ej: 23/11/2025] | [Tu nombre] | En proceso |

---

## 6. Recursos

### Recursos de Hardware
| Recurso | Descripción |
|---------|-------------|
| Computadora | PC con procesador Intel/AMD, 8GB RAM mínimo |
| Almacenamiento | 500MB de espacio disponible para proyecto y BD |

### Recursos de Software
| Recurso | Descripción | Versión |
|---------|-------------|----------|
| IDE | Apache NetBeans IDE | 17 o superior |
| JDK | Java Development Kit | 17 o superior |
| BD | Apache Derby (Java DB) | 10.15.2.0 |
| Librerías | Swing (javax.swing), JDBC | Incluidas en JDK |
| SO | Sistema Operativo | Windows 10/11 |
| Lenguaje | Java | 17+ |
| Control de Versiones | Git + GitHub | Última versión |

### Recursos Humanos
| Rol | Nombre | Responsabilidad |
|-----|--------|------------------|
| Desarrollador/QA | [Tu nombre] | Desarrollo, pruebas y documentación |
| Tutor | Ing. Iván Rojas | Revisión y evaluación del proyecto |

---

## 7. Aprobación

| Rol | Nombre | Firma | Fecha |
|-----|--------|-------|-------|
| Estudiante | [Tu nombre] | | [Fecha] |
| Docente | | | |
