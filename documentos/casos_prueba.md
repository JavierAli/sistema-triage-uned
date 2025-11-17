# Casos de Prueba – Sistema de Triage

**Documento:** Casos de Prueba – Sistema de Triage Básico  
**Estudiante:** [Tu Nombre Completo]  
**Fecha:** [Fecha actual]  
**Formato:** Tabla de casos de prueba ejecutados

---

## Tabla de Casos de Prueba

| ID | Requerimiento | Descripción del Caso | Datos de Entrada | Pasos para Ejecutar | Resultado Esperado | Resultado Obtenido | Estado | Observaciones |
|----|---------------|----------------------|------------------|---------------------|--------------------|--------------------|--------|---------------|
| CP-01 | RF-01 | Guardar paciente normal | Nombre: Pedro López<br>Edad: 30<br>Motivo: Consulta rutina<br>T=36.8°C<br>FC=80 lpm<br>Dolor=2 | 1. Llenar formulario<br>2. Click "Guardar"<br>3. Verificar tabla | Se guarda y clasifica "Atención Normal (Verde)" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-02 | RF-02 | Clasificación emergencia por dolor | Nombre: Laura Sánchez<br>Edad: 45<br>Motivo: Dolor pecho<br>T=37.0°C<br>FC=90 lpm<br>Dolor=9 | 1. Ingresar datos<br>2. Click "Guardar"<br>3. Verificar clasificación | Clasificación "Emergencia (Rojo)" y fila roja | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-03 | RF-02 | Clasificación emergencia por FC alta | Nombre: Roberto Díaz<br>Edad: 50<br>Motivo: Palpitaciones<br>T=36.5°C<br>FC=125 lpm<br>Dolor=4 | 1. Ingresar datos<br>2. Guardar<br>3. Verificar clasificación | Clasificación "Emergencia (Rojo)" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-04 | RF-02 | Clasificación emergencia por temperatura | Nombre: Carmen Ruiz<br>Edad: 35<br>Motivo: Fiebre alta<br>T=39.5°C<br>FC=85 lpm<br>Dolor=3 | 1. Ingresar datos<br>2. Guardar<br>3. Verificar clasificación | Clasificación "Emergencia (Rojo)" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-05 | RF-02 | Clasificación prioritaria (Amarillo) | Nombre: José Morales<br>Edad: 40<br>Motivo: Malestar general<br>T=38.0°C<br>FC=105 lpm<br>Dolor=6 | 1. Ingresar datos<br>2. Guardar<br>3. Verificar clasificación | Clasificación "Atención Prioritaria (Amarillo)" con fondo amarillo | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-06 | RF-07 | Validación campos vacíos | Nombre: [vacío]<br>Otros: datos válidos | 1. Dejar nombre vacío<br>2. Intentar guardar | Mensaje "El nombre es obligatorio" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-07 | RF-07 | Validación temperatura fuera rango | Temperatura: 50°C | 1. Ingresar temp inválida<br>2. Intentar guardar | Mensaje "La temperatura debe estar entre 30 y 45 °C" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-08 | RF-07 | Validación dolor fuera rango | Nivel Dolor: 15 | 1. Ingresar dolor inválido<br>2. Intentar guardar | Mensaje "El nivel de dolor debe estar entre 1 y 10" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-09 | RF-04 | Búsqueda por nombre exitosa | Texto búsqueda: "María" | 1. Ingresar "María"<br>2. Click "Buscar"<br>3. Verificar resultados | Muestra solo pacientes con "María" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-10 | RF-04 | Búsqueda sin resultados | Texto: "ZZZZZ" | 1. Buscar nombre inexistente<br>2. Verificar mensaje | Mensaje "No se encontraron pacientes" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-11 | RF-05 | Actualización de paciente | Seleccionar paciente<br>Cambiar edad 30→35 | 1. Seleccionar en tabla<br>2. Modificar edad<br>3. Click "Actualizar"<br>4. Verificar cambio | Edad actualizada y clasificación recalculada | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-12 | RF-06 | Eliminación de paciente | Seleccionar paciente | 1. Seleccionar paciente<br>2. Click "Eliminar"<br>3. Confirmar<br>4. Verificar tabla | Paciente eliminado con confirmación previa | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-13 | RF-09 | Colores en tabla | Registrar pacientes de cada tipo | 1. Registrar Rojo, Amarillo, Verde<br>2. Observar colores | Rojo: fondo rojo claro<br>Amarillo: fondo amarillo<br>Verde: fondo verde | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-14 | RF-08 | Conexión a BD | Iniciar aplicación | 1. Ejecutar aplicación<br>2. Verificar consola | Mensaje "Conexión exitosa a la base de datos" | [Completar] | [OK/Fallo] | [Observaciones] |
| CP-15 | RF-10 | Cierre controlado | Cerrar ventana (X) | 1. Click en X<br>2. Verificar confirmación | Diálogo "¿Está seguro que desea salir?" | [Completar] | [OK/Fallo] | [Observaciones] |

---

## Resumen de Ejecución

- **Total de casos:** 15
- **Casos aprobados:** [Completar después de ejecutar]
- **Casos fallidos:** [Completar después de ejecutar]
- **Porcentaje de éxito:** [Completar después de ejecutar]%

---

## Instrucciones para Completar

1. Ejecutar cada caso de prueba en el sistema
2. Anotar el resultado obtenido en la columna correspondiente
3. Marcar estado como OK si funciona correctamente, Fallo si no
4. Agregar observaciones relevantes si es necesario
5. Completar el resumen de ejecución al final

---

### CP-02: Clasificación de Emergencia por dolor alto (Rojo)
- **Requerimiento:** RF-02
- **Descripción:** Verificar clasificación cuando nivel de dolor ≥ 8
- **Datos de Entrada:**
  - Nombre: Laura Sánchez
  - Edad: 45
  - Motivo: Dolor de pecho intenso
  - Temperatura: 37.0°C
  - Frecuencia Cardíaca: 90 lpm
  - Nivel de Dolor: 9
- **Pasos:**
  1. Ingresar datos del paciente
  2. Guardar paciente
  3. Verificar clasificación en la tabla
- **Resultado Esperado:** Clasificación "Emergencia (Rojo)" y fila con fondo rojo claro
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-03: Clasificación de Emergencia por frecuencia cardíaca alta (Rojo)
- **Requerimiento:** RF-02
- **Descripción:** Verificar clasificación cuando FC ≥ 120
- **Datos de Entrada:**
  - Nombre: Roberto Díaz
  - Edad: 50
  - Motivo: Palpitaciones
  - Temperatura: 36.5°C
  - Frecuencia Cardíaca: 125 lpm
  - Nivel de Dolor: 4
- **Pasos:**
  1. Ingresar datos
  2. Guardar
  3. Verificar clasificación
- **Resultado Esperado:** "Emergencia (Rojo)"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-04: Clasificación de Emergencia por temperatura alta (Rojo)
- **Requerimiento:** RF-02
- **Descripción:** Verificar clasificación cuando Temp ≥ 39°C
- **Datos de Entrada:**
  - Nombre: Carmen Ruiz
  - Edad: 35
  - Motivo: Fiebre alta
  - Temperatura: 39.5°C
  - Frecuencia Cardíaca: 85 lpm
  - Nivel de Dolor: 3
- **Pasos:**
  1. Ingresar datos
  2. Guardar
  3. Verificar clasificación
- **Resultado Esperado:** "Emergencia (Rojo)"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-05: Clasificación Prioritaria (Amarillo)
- **Requerimiento:** RF-02
- **Descripción:** Verificar clasificación con valores en rango medio
- **Datos de Entrada:**
  - Nombre: José Morales
  - Edad: 40
  - Motivo: Malestar general
  - Temperatura: 38.0°C
  - Frecuencia Cardíaca: 105 lpm
  - Nivel de Dolor: 6
- **Pasos:**
  1. Ingresar datos
  2. Guardar
  3. Verificar clasificación
- **Resultado Esperado:** "Atención Prioritaria (Amarillo)" con fondo amarillo claro
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-06: Validación de campos vacíos
- **Requerimiento:** RF-07
- **Descripción:** Verificar que no se permita guardar con campos vacíos
- **Datos de Entrada:**
  - Nombre: [vacío]
  - Otros campos: con datos válidos
- **Pasos:**
  1. Dejar el campo nombre vacío
  2. Intentar guardar
- **Resultado Esperado:** Mensaje de error "El nombre es obligatorio"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-07: Validación de temperatura fuera de rango
- **Requerimiento:** RF-07
- **Descripción:** Verificar validación de temperatura
- **Datos de Entrada:**
  - Temperatura: 50°C (fuera de rango 30-45)
- **Pasos:**
  1. Ingresar temperatura inválida
  2. Intentar guardar
- **Resultado Esperado:** Mensaje "La temperatura debe estar entre 30 y 45 °C"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-08: Validación de nivel de dolor fuera de rango
- **Requerimiento:** RF-07
- **Descripción:** Verificar validación de dolor (1-10)
- **Datos de Entrada:**
  - Nivel de Dolor: 15 (fuera de rango)
- **Pasos:**
  1. Ingresar dolor inválido
  2. Intentar guardar
- **Resultado Esperado:** Mensaje "El nivel de dolor debe estar entre 1 y 10"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-09: Búsqueda de pacientes por nombre
- **Requerimiento:** RF-04
- **Descripción:** Buscar pacientes usando el campo de búsqueda
- **Datos de Entrada:**
  - Texto de búsqueda: "María"
- **Pasos:**
  1. Ingresar "María" en campo de búsqueda
  2. Hacer clic en "Buscar"
  3. Verificar resultados
- **Resultado Esperado:** Se muestran solo pacientes con "María" en el nombre
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-10: Búsqueda sin resultados
- **Requerimiento:** RF-04
- **Descripción:** Buscar un nombre que no existe
- **Datos de Entrada:**
  - Texto: "ZZZZZ"
- **Pasos:**
  1. Buscar nombre inexistente
  2. Verificar mensaje
- **Resultado Esperado:** Mensaje "No se encontraron pacientes con ese nombre"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-11: Actualización de paciente
- **Requerimiento:** RF-05
- **Descripción:** Modificar datos de un paciente existente
- **Datos de Entrada:**
  - Seleccionar paciente
  - Cambiar edad de 30 a 35
- **Pasos:**
  1. Seleccionar paciente en tabla
  2. Modificar edad
  3. Hacer clic en "Actualizar Paciente"
  4. Verificar cambio en tabla
- **Resultado Esperado:** Edad actualizada correctamente y clasificación recalculada si aplica
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-12: Eliminación de paciente
- **Requerimiento:** RF-06
- **Descripción:** Eliminar un paciente del sistema
- **Pasos:**
  1. Seleccionar paciente
  2. Hacer clic en "Eliminar Paciente"
  3. Confirmar eliminación
  4. Verificar que desaparece de la tabla
- **Resultado Esperado:** Paciente eliminado exitosamente con confirmación previa
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-13: Visualización con colores en tabla
- **Requerimiento:** RF-09
- **Descripción:** Verificar que las filas se colorean según clasificación
- **Pasos:**
  1. Registrar pacientes de cada clasificación
  2. Observar colores en tabla
- **Resultado Esperado:**
  - Rojo: fondo rojo claro
  - Amarillo: fondo amarillo claro
  - Verde: fondo verde claro
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-14: Conexión a base de datos
- **Requerimiento:** RF-08
- **Descripción:** Verificar conexión exitosa al iniciar
- **Pasos:**
  1. Iniciar aplicación
  2. Verificar consola
- **Resultado Esperado:** Mensaje "Conexión exitosa a la base de datos"
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

### CP-15: Botón Limpiar Campos
- **Requerimiento:** RF-10
- **Descripción:** Verificar que se limpian todos los campos
- **Pasos:**
  1. Llenar formulario
  2. Hacer clic en "Limpiar Campos"
- **Resultado Esperado:** Todos los campos vacíos y sin selección en tabla
- **Resultado Obtenido:** [Completar]
- **Estado:** [OK / Fallo]

---

## Resumen de Ejecución

- **Total de casos:** 15
- **Casos aprobados:** [Completar]
- **Casos fallidos:** [Completar]
- **Porcentaje de éxito:** [Completar]
