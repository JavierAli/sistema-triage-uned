-- =====================================================
-- Script de Creación de Base de Datos
-- Sistema de Triage Básico para Puestos de Salud
-- Base de Datos: Derby Java DB
-- =====================================================

-- Crear tabla de pacientes
CREATE TABLE pacientes (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    temperatura DOUBLE NOT NULL,
    frecuencia_cardiaca INT NOT NULL,
    nivel_dolor INT NOT NULL,
    clasificacion VARCHAR(50) NOT NULL
);

-- Insertar datos de ejemplo para pruebas
INSERT INTO pacientes (nombre, edad, motivo, temperatura, frecuencia_cardiaca, nivel_dolor, clasificacion)
VALUES ('Juan Pérez', 45, 'Dolor de pecho intenso', 38.5, 125, 9, 'Emergencia (Rojo)');

INSERT INTO pacientes (nombre, edad, motivo, temperatura, frecuencia_cardiaca, nivel_dolor, clasificacion)
VALUES ('María González', 32, 'Fiebre y malestar general', 38.2, 105, 6, 'Atención Prioritaria (Amarillo)');

INSERT INTO pacientes (nombre, edad, motivo, temperatura, frecuencia_cardiaca, nivel_dolor, clasificacion)
VALUES ('Carlos Rodríguez', 28, 'Consulta de rutina', 36.5, 75, 2, 'Atención Normal (Verde)');

INSERT INTO pacientes (nombre, edad, motivo, temperatura, frecuencia_cardiaca, nivel_dolor, clasificacion)
VALUES ('Ana Martínez', 55, 'Dificultad para respirar', 39.5, 130, 8, 'Emergencia (Rojo)');

INSERT INTO pacientes (nombre, edad, motivo, temperatura, frecuencia_cardiaca, nivel_dolor, clasificacion)
VALUES ('Luis Hernández', 40, 'Dolor abdominal moderado', 37.8, 95, 5, 'Atención Prioritaria (Amarillo)');

-- Consultas útiles para verificación

-- Ver todos los pacientes
SELECT * FROM pacientes;

-- Ver pacientes por clasificación
SELECT * FROM pacientes WHERE clasificacion LIKE '%Rojo%';
SELECT * FROM pacientes WHERE clasificacion LIKE '%Amarillo%';
SELECT * FROM pacientes WHERE clasificacion LIKE '%Verde%';

-- Contar pacientes por clasificación
SELECT clasificacion, COUNT(*) as total 
FROM pacientes 
GROUP BY clasificacion;

-- Buscar paciente por nombre
SELECT * FROM pacientes WHERE UPPER(nombre) LIKE '%MARIA%';

-- =====================================================
-- Notas importantes:
-- 1. Este script se ejecuta automáticamente al iniciar
--    la aplicación si la tabla no existe
-- 2. Derby crea la base de datos en el directorio del proyecto
-- 3. El campo ID se genera automáticamente (IDENTITY)
-- 4. La clasificación se calcula según las reglas de triage
-- =====================================================
