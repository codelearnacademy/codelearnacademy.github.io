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
  - id: sublecciones
    title: Sublecciones
  - id: practica-guiada
    title: Práctica guiada
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

## Objetivo

Organizarás clases Java con paquetes, visibilidad y composición.

## Sublecciones
{: #sublecciones }

<div class="cla-content-map">
  <a href="{{ '/java/leccion04/29-clases-objetos-y-estado/' | relative_url }}"><span aria-hidden="true">01</span><strong>Clases, objetos y estado</strong></a>
  <a href="{{ '/java/leccion04/30-constructores-y-metodos/' | relative_url }}"><span aria-hidden="true">02</span><strong>Constructores y métodos</strong></a>
  <a href="{{ '/java/leccion04/31-encapsulacion-y-validacion/' | relative_url }}"><span aria-hidden="true">03</span><strong>Encapsulación y validación</strong></a>
  <a href="{{ '/java/leccion04/32-paquetes-visibilidad-e-importaciones/' | relative_url }}"><span aria-hidden="true">04</span><strong>Paquetes, visibilidad e importaciones</strong></a>
  <a href="{{ '/java/leccion04/33-metodos-estaticos-y-de-instancia/' | relative_url }}"><span aria-hidden="true">05</span><strong>Métodos estáticos y de instancia</strong></a>
  <a href="{{ '/java/leccion04/34-composicion-entre-objetos/' | relative_url }}"><span aria-hidden="true">06</span><strong>Composición entre objetos</strong></a>
  <a href="{{ '/java/leccion04/35-crear-y-consumir-un-jar/' | relative_url }}"><span aria-hidden="true">07</span><strong>Crear y consumir un JAR</strong></a>
  <a href="#practica-guiada"><span aria-hidden="true">→</span><strong>Práctica guiada</strong></a>
</div>

## Práctica guiada · Biblioteca de inventario
{: #practica-guiada }

**Práctica obligatoria.** Utiliza los demás ejercicios como refuerzo o ampliación.

<div class="cla-lesson-nav"><a href="{{ '/assets/proyectos/java/04-biblioteca.zip' | relative_url }}">Descargar Biblioteca y cliente</a></div>




1. **Punto de partida.** Crea un proyecto biblioteca y otro cliente, con paquetes distintos.
2. **Pasos.** Define Material y Movimiento con campos privados y constructores. Añade un método estático de validación. Empaqueta las clases en inventario.jar con jar --create --file inventario.jar -C out . Añade el JAR al cliente en el IDE e importa sus clases.
3. **Resultado esperado.** El cliente crea un material de 5 unidades y registra una salida de 1, obteniendo 4.
4. **Caso de fallo.** Intenta crear un material con cantidad negativa y verifica el rechazo.

**Evidencia de entrega.** JAR, fuentes en ambos proyectos y prueba del contrato público.

### Rúbrica de la práctica

| Indicador | Puntos |
|---|---:|
| Mantiene campos privados y valida estados. | 1 |
| Genera un JAR y lo utiliza desde el cliente. | 1 |
| Comprueba una operación correcta y una retirada inválida. | 1 |

Cada indicador vale 1 si la evidencia es suficiente, 0,5 si es parcial y 0 si falta.


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

### 1. ¿Qué diseño permite impedir existencias negativas después de construir Material?

- A) Campo público y validación solo en el constructor
- B) Campo privado y operaciones que validan cada cambio
- C) Campo protegido y un getter público
- D) Campo privado y un setter sin validación

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La invariante debe protegerse también después de construir el objeto.</p>

</details>

### 2. ¿Qué relación expresa normalmente composición?

- A) Es-un
- B) Ejecuta-en
- C) Compila-a
- D) Tiene-un

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La composición modela que un objeto contiene/usa otros como partes.</p>

</details>

### 3. ¿Para qué sirven los paquetes?

- A) Organizar tipos y controlar nombres/visibilidad
- B) Crear SQL
- C) Guardar imágenes únicamente
- D) Sustituir métodos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los paquetes estructuran el código y sus espacios de nombres.</p>

</details>

### 4. ¿Qué ventaja aporta un constructor?

- A) Ejecutar SQL siempre
- B) Crear variables globales
- C) Inicializar un objeto en un estado válido
- D) Sustituir la JVM

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El constructor prepara el estado inicial.</p>

</details>

### 5. ¿Qué elemento debería proteger una clase?

- A) Sus invariantes
- B) El nombre del fichero
- C) Solo sus comentarios
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
