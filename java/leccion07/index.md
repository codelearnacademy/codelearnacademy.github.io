---
layout: lesson
route: java
lesson_id: leccion07
lesson_number: "07"
title: Herencia e interfaces
search_title: Lección 07 - Herencia e interfaces
search_description: Aplicarás herencia, interfaces y polimorfismo para diseñar soluciones extensibles.
description: Aplicarás herencia, interfaces, polimorfismo y composición.
lessons:
  - id: sublecciones
    title: Sublecciones
  - id: practica-guiada
    title: Práctica guiada
  - id: herencia
    title: Herencia y sobrescritura
  - id: interfaces
    title: Interfaces y polimorfismo
  - id: composicion
    title: Composición y diseño
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion07/
---

## Objetivo

Aplicarás herencia, interfaces, polimorfismo y composición.

## Sublecciones
{: #sublecciones }

<div class="cla-content-map">
  <a href="{{ '/java/leccion07/50-superclase-y-subclases/' | relative_url }}"><span aria-hidden="true">01</span><strong>Superclase y subclases</strong></a>
  <a href="{{ '/java/leccion07/51-constructores-y-super/' | relative_url }}"><span aria-hidden="true">02</span><strong>Constructores y super</strong></a>
  <a href="{{ '/java/leccion07/52-sobrescritura-y-polimorfismo/' | relative_url }}"><span aria-hidden="true">03</span><strong>Sobrescritura y polimorfismo</strong></a>
  <a href="{{ '/java/leccion07/53-abstract-y-final/' | relative_url }}"><span aria-hidden="true">04</span><strong>Abstract y final</strong></a>
  <a href="{{ '/java/leccion07/54-interfaces-como-contratos/' | relative_url }}"><span aria-hidden="true">05</span><strong>Interfaces como contratos</strong></a>
  <a href="{{ '/java/leccion07/55-composicion-y-delegacion/' | relative_url }}"><span aria-hidden="true">06</span><strong>Composición y delegación</strong></a>
  <a href="{{ '/java/leccion07/56-probar-y-documentar-una-jerarquia/' | relative_url }}"><span aria-hidden="true">07</span><strong>Probar y documentar una jerarquía</strong></a>
  <a href="#practica-guiada"><span aria-hidden="true">→</span><strong>Práctica guiada</strong></a>
</div>

## Práctica guiada · Políticas de préstamo
{: #practica-guiada }

**Práctica obligatoria.** Utiliza los demás ejercicios como refuerzo o ampliación.




1. **Punto de partida.** Parte de Material y prepara dos tipos de material con plazos distintos.
2. **Pasos.** Define una clase base abstracta, usa super y sobrescribe plazoDias() en dos subclases. Usa final para bloquear una extensión indebida. Invoca ambos objetos a través del tipo base y compara con una interfaz PoliticaPrestamo delegada por composición.
3. **Resultado esperado.** Una lista de materiales produce los plazos 3 y 7 con el mismo método.
4. **Caso de fallo.** Inyecta temporalmente un plazo incorrecto y localízalo con el depurador.

**Evidencia de entrega.** Pruebas, traza breve, Javadoc del contrato y decisión razonada sobre herencia, interfaz y composición.

### Rúbrica de la práctica

| Indicador | Puntos |
|---|---:|
| Usa una jerarquía con sobrescritura y llamadas polimórficas. | 1 |
| Prueba ambos tipos y documenta un fallo depurado. | 1 |
| Justifica herencia o composición y documenta el contrato público. | 1 |

Cada indicador vale 1 si la evidencia es suficiente, 0,5 si es parcial y 0 si falta.


## Herencia y sobrescritura


La herencia expresa una especialización. La subclase recibe miembros accesibles de la superclase y puede sobrescribir comportamiento con `@Override`.

```java
public class Empleado {
  protected final String nombre;
  public Empleado(String nombre) { this.nombre = nombre; }
  public double coste() { return 0; }
}

public class Desarrollador extends Empleado {
  private final double salario;
  public Desarrollador(String nombre, double salario) {
    super(nombre);
    this.salario = salario;
  }
  @Override public double coste() { return salario; }
}
```

Usa `final` para impedir extensiones o sobrescrituras cuando el diseño lo requiera. Una jerarquía debe tener una relación “es un” clara.

### Ejercicios de práctica · Herencia y sobrescritura

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a modelar especialización. Debes utilizar explícitamente `extends`, `super`, `@Override`, abstract y final. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Herencia y sobrescritura**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por jerarquías que no cumplen relación es-un. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Herencia y sobrescritura**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en vehículos, empleados o figuras. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Interfaces y polimorfismo

Una interfaz define un contrato que distintas clases pueden implementar:

```java
public interface Exportable { String exportar(); }

public class Informe implements Exportable {
  @Override public String exportar() { return "informe"; }
}

Exportable documento = new Informe();
System.out.println(documento.exportar());
```

El código cliente depende del contrato y no de la implementación concreta. Una clase puede implementar varias interfaces, lo que evita la limitación de herencia única.

### Ejercicios de práctica · Interfaces y polimorfismo

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a programar contra contratos. Debes utilizar explícitamente `interface`, `implements`, múltiples implementaciones y sustitución. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Interfaces y polimorfismo**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por acoplamiento a clases concretas e `instanceof` innecesario. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Interfaces y polimorfismo**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en pagos, notificaciones o exportadores. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Composición y diseño


Prefiere composición cuando un objeto utiliza a otro sin ser una especialización. `Pedido` puede tener un `CalculadorDePrecios`; no necesita heredar de él. Esta decisión reduce acoplamiento y facilita sustituir colaboraciones en pruebas.

### Ejercicios de práctica · Composición y diseño

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a preferir colaboración cuando corresponde. Debes utilizar explícitamente inyección por constructor, delegación y estrategias. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Composición y diseño**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por herencia usada solo para reutilizar código. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Composición y diseño**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en checkout, descuentos o servicios configurables. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Ejercicios

1. Crea una jerarquía `Vehiculo`, `Coche` y `Moto`.
2. Implementa `Notificable` para correo y consola.
3. Compara una solución con herencia y otra con composición.
4. Diseña un sistema de formas que calcule áreas mediante polimorfismo.
5. Documenta por qué una clase debe ser `abstract`, `final` o una interfaz.

## Refuerzo práctico

### Ejemplo guiado

Define `IPago`, implementa tarjeta y transferencia y haz que el cliente dependa solo de la interfaz.

### Ejercicio propuesto

Añade una tercera forma de pago sin modificar el código cliente y explica por qué funciona.

## Tarea para casa

Implementa un sistema de pagos con `IPago` y al menos tres implementaciones. El código cliente solo debe depender de la interfaz.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. Si una variable de tipo Material contiene una subclase que sobrescribe plazoDias(), ¿qué implementación se invoca?

- A) La de Material por el tipo declarado
- B) La del constructor de la subclase
- C) La de la subclase concreta
- D) La de Material salvo que se use un cast

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> La JVM selecciona la implementación del método de instancia según el tipo real del objeto.</p>

</details>

### 2. ¿Qué palabra se usa para heredar de una clase?

- A) implements siempre
- B) superclass
- C) extends
- D) inherits

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> extends declara la superclase.</p>

</details>

### 3. ¿Qué palabra se usa para implementar una interfaz?

- A) implements
- B) interfaceOf
- C) with
- D) extends siempre

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Una clase implementa contratos con implements.</p>

</details>

### 4. ¿Qué permite el polimorfismo?

- A) Evitar métodos
- B) Eliminar todos los tipos
- C) Compilar sin JVM
- D) Usar una referencia de un tipo común con implementaciones distintas

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> El código cliente puede trabajar contra una abstracción común.</p>

</details>

### 5. ¿Cuándo suele ser preferible composición a herencia?

- A) Nunca
- B) Cuando queremos combinar comportamiento sin una relación es-un natural
- C) Solo con Strings
- D) Solo con bases de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La composición suele reducir acoplamiento cuando la jerarquía no es una relación de sustitución clara.</p>

</details>

## Ejercicios propuestos

1. Implementa `IPago` con `PagoTarjeta` y `PagoTransferencia` y usa solo `IPago` en el cliente.
2. Crea una jerarquía `Vehiculo`, `Coche`, `Moto` y demuestra polimorfismo en una lista.
3. Reformula un ejemplo de herencia como composición y compara ambas soluciones.

## Ejercicios de repaso de la lección

Realiza estos retos después de completar los ejercicios de práctica. Cada concepto de la lección dispone de cinco ejercicios de repaso más autónomos.

### Herencia y sobrescritura

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible modelar especialización. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Herencia y sobrescritura** a un contexto distinto del explicado en clase, por ejemplo vehículos, empleados o figuras. Usa `extends`, `super`, `@Override`, abstract y final y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Herencia y sobrescritura** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con jerarquías que no cumplen relación es-un. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Herencia y sobrescritura**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Interfaces y polimorfismo

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible programar contra contratos. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Interfaces y polimorfismo** a un contexto distinto del explicado en clase, por ejemplo pagos, notificaciones o exportadores. Usa `interface`, `implements`, múltiples implementaciones y sustitución y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Interfaces y polimorfismo** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con acoplamiento a clases concretas e `instanceof` innecesario. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Interfaces y polimorfismo**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Composición y diseño

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible preferir colaboración cuando corresponde. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Composición y diseño** a un contexto distinto del explicado en clase, por ejemplo checkout, descuentos o servicios configurables. Usa inyección por constructor, delegación y estrategias y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Composición y diseño** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con herencia usada solo para reutilizar código. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Composición y diseño**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Actividades principales de la lección

### Actividad 1 · Vehículos polimórficos

**Modalidad:** clase · **Tiempo orientativo:** 40–50 minutos

**Objetivo:** observar herencia, sobrescritura y polimorfismo.

Crea `Vehiculo`, `Coche` y `Moto`. Define `mover()` en el tipo base y sobrescríbelo. Guarda distintos objetos en una `List<Vehiculo>` y recórrela invocando `mover()`.

**Comprobación:** explica por qué una referencia de tipo `Vehiculo` puede ejecutar implementaciones diferentes.

### Actividad 2 · Formas de pago

**Modalidad:** clase · **Tiempo orientativo:** 45–55 minutos

**Objetivo:** diseñar contra una interfaz.

Define `IPago` e implementa `PagoTarjeta` y `PagoTransferencia`. Crea un servicio que dependa únicamente de `IPago`, no de las clases concretas.

**Comprobación:** añade `PagoEfectivo` sin modificar la lógica principal del servicio.

### Actividad 3 · Sistema de notificaciones

**Modalidad:** casa · **Tiempo orientativo:** 60–75 minutos

**Objetivo:** consolidar interfaces, polimorfismo y bajo acoplamiento.

Diseña `INotificacion` con implementaciones para correo electrónico, SMS y un tercer canal elegido por ti. El cliente debe trabajar solo con la interfaz.

**Entrega:** código, pequeño diagrama de tipos y explicación de cómo añadirías una cuarta implementación.

<div class="cla-lesson-nav"><a href="/java/leccion06/">← 06 · Colecciones y tipos avanzados</a><a href="/java/leccion08/">08 · Persistencia en Base de Datos →</a></div>
