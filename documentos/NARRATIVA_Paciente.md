# Narrativa Exhaustiva: Paciente.java

## Propósito General
Esta clase representa un paciente en el sistema de triage. Es una clase modelo que encapsula todos los datos de un paciente y la lógica para calcular su clasificación de prioridad médica.

---

## Línea por Línea

### Declaración del Paquete
```java
package modelo;
```
**¿Qué es `package`?** Es una palabra reservada de Java que agrupa clases relacionadas en un mismo espacio de nombres.

**¿Qué es `modelo`?** Es el nombre del paquete donde está esta clase. Representa la capa de modelo en la arquitectura MVC (Modelo-Vista-Controlador).

**¿Por qué usar paquetes?** Para organizar el código, evitar conflictos de nombres y facilitar el mantenimiento.

---

### Comentario de Documentación
```java
/**
 * Clase que representa un paciente en el sistema de triage
 */
```
**¿Qué es `/**`?** Es el inicio de un comentario Javadoc, que sirve para documentar clases, métodos y atributos.

**¿Para qué sirve?** Para que otros programadores (o tú mismo en el futuro) entiendan qué hace esta clase sin leer todo el código.

---

### Declaración de la Clase
```java
public class Paciente {
```
**¿Qué es `public`?** Es un modificador de acceso que significa que esta clase puede ser usada desde cualquier otra clase del proyecto.

**¿Qué es `class`?** Palabra reservada que declara una clase en Java. Una clase es una plantilla para crear objetos.

**¿Qué es `Paciente`?** Es el nombre de la clase. Por convención, los nombres de clases en Java empiezan con mayúscula.

**¿Qué es `{`?** Llave de apertura que marca el inicio del cuerpo de la clase.

---

### Atributos Privados
```java
private int id;
```
**¿Qué es `private`?** Modificador de acceso que significa que este atributo solo puede ser accedido desde dentro de esta misma clase.

**¿Qué es `int`?** Tipo de dato primitivo en Java que representa números enteros (sin decimales). Ejemplo: 1, 2, 100, -5.

**¿Qué es `id`?** Nombre de la variable que almacenará el identificador único del paciente en la base de datos.

**¿Por qué `private`?** Para aplicar encapsulamiento, un principio de programación orientada a objetos que protege los datos.

---

```java
private String nombre;
```
**¿Qué es `String`?** Es una clase de Java que representa cadenas de texto (palabras, frases). Ejemplo: "Juan Pérez", "María".

**¿Por qué `String` con mayúscula?** Porque es una clase, no un tipo primitivo como `int`.

**¿Qué es `nombre`?** Variable que almacenará el nombre completo del paciente.

---

```java
private int edad;
```
**¿Qué almacena?** La edad del paciente en años (número entero).

---

```java
private String motivo;
```
**¿Qué almacena?** El motivo de consulta del paciente. Ejemplo: "Dolor de pecho", "Fiebre alta".

---

```java
private double temperatura;
```
**¿Qué es `double`?** Tipo de dato primitivo para números con decimales (punto flotante de doble precisión). Ejemplo: 36.5, 39.8, 38.0.

**¿Por qué `double` y no `int`?** Porque la temperatura puede tener decimales (36.8°C, no solo 36°C).

---

```java
private int frecuenciaCardiaca;
```
**¿Qué almacena?** La frecuencia cardíaca en latidos por minuto (lpm). Ejemplo: 80, 120, 95.

**¿Por qué `int`?** Porque normalmente se mide en números enteros.

---

```java
private int nivelDolor;
```
**¿Qué almacena?** El nivel de dolor del paciente en escala de 1 a 10.

---

```java
private String clasificacion;
```
**¿Qué almacena?** La clasificación de triage calculada. Ejemplo: "Emergencia (Rojo)", "Atención Normal (Verde)".

---

### Constructor Vacío
```java
public Paciente() {
}
```
**¿Qué es un constructor?** Un método especial que se ejecuta cuando se crea un objeto de esta clase.

**¿Por qué se llama igual que la clase?** Es una regla de Java para los constructores.

**¿Por qué está vacío?** Es un constructor sin parámetros que permite crear un objeto Paciente sin datos iniciales.

**¿Cuándo se usa?** Cuando se recuperan datos de la base de datos y se llenan después con setters.

---

### Constructor con Parámetros
```java
public Paciente(String nombre, int edad, String motivo, double temperatura, 
                int frecuenciaCardiaca, int nivelDolor) {
```
**¿Qué son los parámetros?** Variables que recibe el constructor para inicializar el objeto.

**¿Por qué está en dos líneas?** Por legibilidad, para que no sea una línea muy larga.

---

```java
this.nombre = nombre;
```
**¿Qué es `this`?** Palabra reservada que se refiere al objeto actual (la instancia de la clase).

**¿Por qué `this.nombre`?** Para diferenciar el atributo de la clase (`this.nombre`) del parámetro (`nombre`).

**¿Qué hace `=`?** Operador de asignación que copia el valor del parámetro al atributo.

---

```java
this.edad = edad;
this.motivo = motivo;
this.temperatura = temperatura;
this.frecuenciaCardiaca = frecuenciaCardiaca;
this.nivelDolor = nivelDolor;
```
**¿Qué hacen estas líneas?** Asignan cada parámetro recibido al atributo correspondiente del objeto.

---

```java
this.clasificacion = calcularClasificacion();
```
**¿Qué hace?** Llama al método `calcularClasificacion()` y guarda el resultado en el atributo `clasificacion`.

**¿Por qué aquí?** Para que automáticamente al crear un paciente, se calcule su clasificación de triage.

---

### Método de Cálculo de Clasificación
```java
/**
 * Calcula la clasificación de triage según los parámetros vitales
 */
private String calcularClasificacion() {
```
**¿Por qué `private`?** Porque es un método interno que solo se usa dentro de esta clase.

**¿Qué es `String`?** El tipo de dato que retorna (devuelve) este método.

**¿Qué es `calcularClasificacion()`?** El nombre del método. Los paréntesis vacíos indican que no recibe parámetros.

---

```java
if (nivelDolor >= 8 || frecuenciaCardiaca >= 120 || temperatura >= 39.0) {
```
**¿Qué es `if`?** Estructura condicional que ejecuta código solo si la condición es verdadera.

**¿Qué es `>=`?** Operador "mayor o igual que". Compara dos valores.

**¿Qué es `||`?** Operador lógico OR (O). La condición es verdadera si AL MENOS UNA de las condiciones es verdadera.

**¿Qué evalúa?** Si el dolor es 8 o más, O la frecuencia es 120 o más, O la temperatura es 39 o más.

**¿Por qué estas condiciones?** Son las reglas médicas de triage para clasificar como emergencia.

---

```java
return "Emergencia (Rojo)";
```
**¿Qué es `return`?** Palabra reservada que devuelve un valor y termina la ejecución del método.

**¿Qué devuelve?** La cadena de texto "Emergencia (Rojo)".

**¿Qué pasa después?** El método termina y no ejecuta el código siguiente.

---

```java
} else if ((nivelDolor >= 5 && nivelDolor <= 7) || 
           (frecuenciaCardiaca >= 100 && frecuenciaCardiaca <= 119) || 
           (temperatura >= 37.5 && temperatura <= 38.9)) {
```
**¿Qué es `else if`?** "Si no, si..." - evalúa otra condición si la anterior fue falsa.

**¿Qué es `&&`?** Operador lógico AND (Y). La condición es verdadera solo si AMBAS condiciones son verdaderas.

**¿Qué evalúa?** Si el dolor está entre 5-7, O la frecuencia entre 100-119, O la temperatura entre 37.5-38.9.

---

```java
return "Atención Prioritaria (Amarillo)";
```
**¿Qué devuelve?** La clasificación de prioridad media.

---

```java
} else {
    return "Atención Normal (Verde)";
}
```
**¿Qué es `else`?** "Si no..." - se ejecuta si ninguna condición anterior fue verdadera.

**¿Qué significa?** Si no es emergencia ni prioritaria, entonces es atención normal.

---

### Método para Recalcular
```java
public void recalcularClasificacion() {
```
**¿Qué es `void`?** Significa que este método no devuelve ningún valor.

**¿Para qué sirve?** Para recalcular la clasificación cuando se modifican los signos vitales.

---

```java
this.clasificacion = calcularClasificacion();
```
**¿Qué hace?** Vuelve a calcular la clasificación y actualiza el atributo.

---

### Getters y Setters

```java
public int getId() {
    return id;
}
```
**¿Qué es un getter?** Método que permite leer (obtener) el valor de un atributo privado.

**¿Por qué `public`?** Para que otras clases puedan obtener el ID del paciente.

**¿Qué retorna?** El valor del atributo `id`.

---

```java
public void setId(int id) {
    this.id = id;
}
```
**¿Qué es un setter?** Método que permite modificar (establecer) el valor de un atributo privado.

**¿Por qué recibe un parámetro?** Para saber qué valor asignar al atributo.

---

```java
public void setTemperatura(double temperatura) {
    this.temperatura = temperatura;
    recalcularClasificacion();
}
```
**¿Por qué llama a `recalcularClasificacion()`?** Porque al cambiar la temperatura, la clasificación de triage podría cambiar.

**Ejemplo:** Si un paciente tenía 36.5°C (Verde) y ahora tiene 39.5°C, debe reclasificarse como Rojo.

---

## Conceptos Clave Explicados

### ¿Qué es una Clase?
Una plantilla para crear objetos. Como un molde para hacer galletas.

### ¿Qué es un Objeto?
Una instancia de una clase. Como una galleta hecha con el molde.

### ¿Qué es Encapsulamiento?
Ocultar los datos (atributos privados) y solo permitir acceso mediante métodos públicos (getters/setters).

### ¿Por qué Getters y Setters?
- **Control:** Puedes validar datos antes de asignarlos
- **Flexibilidad:** Puedes cambiar la implementación interna sin afectar otras clases
- **Lógica adicional:** Como recalcular la clasificación al cambiar temperatura

### ¿Qué es `this`?
Referencia al objeto actual. Útil cuando el parámetro tiene el mismo nombre que el atributo.

---

## Flujo de Uso

1. **Crear paciente:**
   ```java
   Paciente p = new Paciente("Juan", 45, "Dolor pecho", 38.5, 125, 9);
   ```

2. **Se ejecuta el constructor:**
   - Asigna todos los valores
   - Llama a `calcularClasificacion()`
   - Evalúa: dolor=9 >= 8 → TRUE
   - Retorna: "Emergencia (Rojo)"

3. **Usar el objeto:**
   ```java
   String nombre = p.getNombre(); // "Juan"
   String clasificacion = p.getClasificacion(); // "Emergencia (Rojo)"
   ```

4. **Modificar datos:**
   ```java
   p.setTemperatura(36.5);
   // Automáticamente recalcula: ahora podría ser Verde
   ```

---

## Preguntas Frecuentes en Presentación

**P: ¿Por qué los atributos son privados?**
R: Para aplicar encapsulamiento y proteger los datos. Solo se accede mediante getters/setters.

**P: ¿Por qué hay dos constructores?**
R: Uno vacío para cuando recuperamos datos de BD, otro con parámetros para crear nuevos pacientes.

**P: ¿Cómo funciona la clasificación?**
R: Evalúa signos vitales con operadores lógicos (||, &&) según reglas médicas de triage.

**P: ¿Qué pasa si cambio la temperatura?**
R: El setter llama a `recalcularClasificacion()` para actualizar la clasificación automáticamente.

**P: ¿Por qué String con mayúscula?**
R: Porque es una clase, no un tipo primitivo como int o double.
