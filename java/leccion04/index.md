---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: Organización de clases
search_title: Lección 04 - Organización de clases
search_description: Organizarás el código en paquetes, clases y responsabilidades claras.
description: Organizarás clases Java con paquetes, visibilidad y composición.
lessons:
  - id: paquetes
    title: Paquetes y visibilidad
  - id: encapsulacion
    title: Encapsulación
  - id: composicion
    title: Composición y reutilización
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion04/
---

## Paquetes y visibilidad

Los paquetes agrupan clases relacionadas y evitan colisiones de nombres. La estructura de carpetas debe reflejar el `package`:

```java
package es.codelearn.pedidos;

public class Pedido {
  private final String identificador;

  public Pedido(String identificador) {
    this.identificador = identificador;
  }
}
```

`public` expone un tipo o miembro; `private` lo limita a su clase; `protected` permite acceso a subclases y al paquete; sin modificador se limita al paquete.

### Ejercicios de práctica · Paquetes y visibilidad

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a organizar código y controlar acceso. Debes utilizar explícitamente paquetes, imports, `public`, `protected`, package-private y `private`. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Paquetes y visibilidad**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por imports ambiguos y miembros demasiado expuestos. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Paquetes y visibilidad**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en organizar una aplicación por capas. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Encapsulación


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/04-encapsulacion.png" alt="Encapsulación del estado de una clase" loading="lazy">
</figure>

Una clase debe proteger sus invariantes y ofrecer operaciones significativas. Es preferible `pedido.cancelar()` a exponer un campo que cualquiera pueda cambiar.

```java
public void cancelar() {
  if (estado == Estado.ENVIADO) throw new IllegalStateException("Pedido enviado");
  estado = Estado.CANCELADO;
}
```

### Ejercicios de práctica · Encapsulación

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a proteger invariantes del objeto. Debes utilizar explícitamente campos privados, constructores y métodos de intención. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Encapsulación**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por setters que permiten estados inválidos. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Encapsulación**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en una cuenta, reserva o producto consistente. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Composición y reutilización


<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/04-composicion.png" alt="Composición entre objetos" loading="lazy">
</figure>

La composición modela relaciones “tiene un”. Permite cambiar una pieza sin crear jerarquías artificiales.

```java
public class Coche {
  private final Motor motor;

  public Coche(Motor motor) {
    this.motor = motor;
  }

  public void arrancar() { motor.encender(); }
}
```

Organiza cada clase alrededor de una responsabilidad y separa dominio, entrada/salida y presentación. Esta decisión facilita las pruebas y la evolución del proyecto.

### Ejercicios de práctica · Composición y reutilización

Realiza estos ejercicios antes de pasar al siguiente concepto. En todos los casos conserva el código y anota brevemente qué has comprobado.

**1. Aplicación directa.** Crea un ejemplo mínimo que te obligue a combinar objetos sin herencia innecesaria. Debes utilizar explícitamente delegación, colaboradores y composición. Al final, muestra o documenta el resultado esperado y compáralo con el obtenido. **Entrega:** código fuente, salida obtenida y una tabla con al menos tres casos de prueba.

**2. Variación controlada.** Parte del ejemplo anterior y cambia al menos dos datos, reglas o entradas. Explica qué partes del código necesitan modificarse y cuáles permanecen iguales gracias al concepto **Composición y reutilización**. **Entrega:** versión inicial y versión modificada, más una lista de los cambios realizados y su efecto.

**3. Diagnóstico de errores.** Construye o recibe un ejemplo que falle por acoplamiento y jerarquías artificiales. Localiza el problema, copia el mensaje o comportamiento observado, corrígelo y escribe una explicación breve de la causa. **Entrega:** código que falla, mensaje o comportamiento observado, código corregido y explicación de la causa.

**4. Comparación de alternativas.** Resuelve el mismo problema de dos formas posibles dentro de **Composición y reutilización**. Compara legibilidad, seguridad y facilidad de mantenimiento, e indica cuál elegirías para un proyecto de clase. **Entrega:** las dos soluciones funcionando y una comparación escrita de al menos tres criterios.

**5. Mini integración.** Desarrolla un ejercicio pequeño basado en pedido-líneas o servicio-estrategia. Debe incluir entrada o datos de prueba, procesamiento, salida verificable y al menos tres casos que demuestren que la solución funciona. **Entrega:** solución completa, datos usados, salida esperada/real y una breve conclusión.

## Ejercicios

1. Crea paquetes `domain`, `service` y `app` para una agenda.
2. Protege los datos de `Contacto` con visibilidad privada.
3. Implementa una clase `Motor` y úsala mediante composición en `Coche`.
4. Mueve una clase a otro paquete y corrige imports y visibilidad.
5. Revisa una clase grande y divídela por responsabilidades.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/04-clase-objeto.png" alt="Comparación entre una clase Java como plantilla y varios objetos creados a partir de ella" loading="lazy">
</figure>

### Ejemplo guiado

Construye `Producto` empezando con atributos, añade constructor, encapsula el estado y crea dos instancias.

### Ejercicio propuesto

Diseña `Libro`, `Autor` y `Biblioteca` utilizando encapsulación y composición.

## Tarea para casa

Diseña una biblioteca con `Libro`, `Autor` y `Biblioteca`. Encapsula el estado, utiliza composición y añade una pequeña clase `Main` de demostración.

### Entrega mínima

- Código fuente compilable.
- Un `README.md` breve con instrucciones de ejecución.
- Tres casos de prueba manuales y el resultado esperado.

## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué es encapsulación?

- A) Ocultar estado interno y exponer una API controlada
- B) Poner todos los campos public
- C) Evitar clases
- D) Usar solo métodos static

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La encapsulación protege invariantes y reduce acoplamiento.</p>

</details>

### 2. ¿Qué relación expresa normalmente composición?

- A) Tiene-un
- B) Es-un
- C) Compila-a
- D) Ejecuta-en

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La composición modela que un objeto contiene/usa otros como partes.</p>

</details>

### 3. ¿Para qué sirven los paquetes?

- A) Organizar tipos y controlar nombres/visibilidad
- B) Guardar imágenes únicamente
- C) Sustituir métodos
- D) Crear SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los paquetes estructuran el código y sus espacios de nombres.</p>

</details>

### 4. ¿Qué ventaja aporta un constructor?

- A) Inicializar un objeto en un estado válido
- B) Ejecutar SQL siempre
- C) Sustituir la JVM
- D) Crear variables globales

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El constructor prepara el estado inicial.</p>

</details>

### 5. ¿Qué elemento debería proteger una clase?

- A) Sus invariantes
- B) Solo sus comentarios
- C) El nombre del fichero
- D) La versión del IDE

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Una buena clase evita estados inválidos mediante su API.</p>

</details>

## Ejercicios propuestos

1. Diseña `CuentaBancaria` manteniendo el saldo privado e impidiendo operaciones inválidas.
2. Modela `Biblioteca`, `Libro` y `Autor` usando composición donde corresponda.
3. Organiza las clases en paquetes `model`, `service` y `app` y justifica las dependencias.

## Ejercicios de repaso de la lección

Realiza estos retos después de completar los ejercicios de práctica. Cada concepto de la lección dispone de cinco ejercicios de repaso más autónomos.

### Paquetes y visibilidad

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible organizar código y controlar acceso. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Paquetes y visibilidad** a un contexto distinto del explicado en clase, por ejemplo organizar una aplicación por capas. Usa paquetes, imports, `public`, `protected`, package-private y `private` y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Paquetes y visibilidad** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con imports ambiguos y miembros demasiado expuestos. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Paquetes y visibilidad**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Encapsulación

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible proteger invariantes del objeto. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Encapsulación** a un contexto distinto del explicado en clase, por ejemplo una cuenta, reserva o producto consistente. Usa campos privados, constructores y métodos de intención y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Encapsulación** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con setters que permiten estados inválidos. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Encapsulación**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

### Composición y reutilización

**1. Desde cero.** Sin copiar el ejemplo de los apuntes, crea una solución nueva donde sea imprescindible combinar objetos sin herencia innecesaria. Antes de programar, escribe en 3–5 líneas el plan y después verificalo con al menos cuatro casos. **Entrega:** planteamiento previo, solución completa y cuatro pruebas con resultado esperado y real.

**2. Cambio de dominio.** Aplica **Composición y reutilización** a un contexto distinto del explicado en clase, por ejemplo pedido-líneas o servicio-estrategia. Usa delegación, colaboradores y composición y documenta qué decisiones has tenido que adaptar. **Entrega:** código, descripción del nuevo dominio y explicación de cómo adaptaste el concepto.

**3. Integración con contenidos anteriores.** Combina **Composición y reutilización** con al menos dos conceptos estudiados previamente. La solución debe tener varias operaciones o pasos, no un único `println`, y debe mostrar claramente dónde interviene cada concepto. **Entrega:** solución integrada y un esquema o comentario que identifique claramente los conceptos combinados.

**4. Casos límite y robustez.** Diseña cinco casos de prueba que incluyan situaciones normales y problemas relacionados con acoplamiento y jerarquías artificiales. Ejecuta todos, anota resultado esperado/real y corrige la implementación si alguno falla. **Entrega:** tabla de cinco casos límite con resultado esperado/real y las correcciones realizadas.

**5. Refactorización y explicación.** Parte de una solución funcional pero poco clara para **Composición y reutilización**, reorganízala para mejorar nombres, responsabilidades y legibilidad. Entrega versión antes/después y justifica al menos tres cambios. **Entrega:** versión antes/después y justificación de al menos tres decisiones de refactorización.

## Actividades principales de la lección

### Actividad 1 · Refactorizar `Producto`

**Modalidad:** clase · **Tiempo orientativo:** 40–50 minutos

**Objetivo:** transformar código monolítico en una clase con responsabilidades claras.

Parte de un programa que guarda `id`, `nombre` y `precio` en variables de `main`. Extrae esos datos a una clase `Producto`, encapsula su estado y crea un constructor que garantice un objeto válido.

**Comprobación:** desde `main`, crea al menos dos productos y muestra sus datos sin acceder directamente a campos privados.

### Actividad 2 · Cliente y Dirección

**Modalidad:** clase · **Tiempo orientativo:** 40–50 minutos

**Objetivo:** practicar composición entre objetos.

Crea `Direccion` con calle, ciudad y código postal. Después crea `Cliente`, que debe contener una `Direccion`. Añade un método que genere una descripción completa del cliente.

**Comprobación:** modifica la dirección de un cliente sin duplicar los datos de dirección dentro de `Cliente`.

### Actividad 3 · Biblioteca

**Modalidad:** casa · **Tiempo orientativo:** 75–90 minutos

**Objetivo:** diseñar varias clases relacionadas mediante encapsulación y composición.

Modela `Autor`, `Libro` y `Biblioteca`. La biblioteca debe permitir añadir libros, mostrarlos y buscar por título. Organiza las clases en paquetes coherentes.

**Entrega:** código, diagrama textual sencillo de las relaciones y `README.md` con ejemplos de uso.

<div class="cla-lesson-nav"><a href="/java/leccion03/">← 03 · Estructuras de control</a><a href="/java/leccion05/">05 · Entrada y salida →</a></div>
