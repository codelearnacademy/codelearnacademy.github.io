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
