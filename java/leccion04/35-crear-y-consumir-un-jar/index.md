---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Crear y consumir un JAR"
permalink: /java/leccion04/35-crear-y-consumir-un-jar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Crear y consumir un JAR

Compila la biblioteca del proyecto descargable, empaqueta inventario.jar y añade el archivo al classpath del cliente.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/04-biblioteca.zip' | relative_url }}">Descargar biblioteca y cliente</a>
</div>

Añade el JAR al classpath antes de ejecutar.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/35.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/35.webp' | relative_url }}" alt="Crear y consumir un JAR. Compila la biblioteca del proyecto descargable, empaqueta inventario.jar y añade el archivo al classpath del cliente. Resultado: 4" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new aula.inventario.Material(5).retirar(1).unidades());
    }
}
```

**Resultado esperado**

```text
4
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Compila la biblioteca.
2. Empaqueta sus clases.
3. Importa Material en un cliente.
4. Ejecuta una retirada.
5. Añade Movimiento.
6. Valida con un cliente nuevo.
7. Reutiliza el JAR en dos casos.
8. Corrige un classpath incorrecto.
9. Prueba una retirada inválida.
10. Distribuye un cliente reproducible con su biblioteca.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Crear y consumir un JAR. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Crear y consumir un JAR</a>
</div>
