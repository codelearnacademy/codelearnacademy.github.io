---
layout: lesson
route: java
lesson_id: leccion01
lesson_number: "01"
title: "Configurar el JDK y el IDE"
permalink: /java/leccion01/01-configurar-el-jdk-y-el-ide/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Configurar el JDK y el IDE

Selecciona un JDK 21 como SDK del proyecto y ejecuta Main desde el IDE.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/01.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/01.webp' | relative_url }}" alt="Configurar el JDK y el IDE. Selecciona un JDK 21 como SDK del proyecto y ejecuta Main desde el IDE. Resultado: 21" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Runtime.version().feature());
    }
}
```

**Resultado esperado**

```text
21
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion01/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion01/02-anatomia-de-main-java/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Imprime la versión mayor.
2. Muestra el proveedor de Java.
3. Presenta nombre y versión en dos líneas.
4. Compón una ficha de entorno en un solo println.
5. Ordena tres mensajes de arranque.
6. Separa versión y proveedor con un guion.
7. Añade el nombre del proyecto a la salida.
8. Corrige un nombre de método mal escrito.
9. Reproduce y corrige un archivo mal nombrado.
10. Presenta un informe de entorno listo para comparar dos instalaciones.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L01-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L01-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Configurar el JDK y el IDE. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion01/L01-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Configurar el JDK y el IDE</a>
</div>
