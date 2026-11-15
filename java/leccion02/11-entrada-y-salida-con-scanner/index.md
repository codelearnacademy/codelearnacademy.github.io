---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Entrada y salida con Scanner"
permalink: /java/leccion02/11-entrada-y-salida-con-scanner/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: el-salto-pendiente-en-scanner
    title: "El salto pendiente en Scanner"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Entrada y salida con Scanner

Introduce 5 y separa la lectura del formato de salida.

Escribe `5` y pulsa Intro.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/11.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/11.webp' | relative_url }}" alt="Entrada y salida con Scanner. Introduce 5 y separa la lectura del formato de salida. Resultado: 5 unidades" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var entrada = new java.util.Scanner(System.in);
        int unidades = entrada.nextInt();
        System.out.printf("%d unidades%n", unidades);
    }
}
```

**Resultado esperado**

```text
5 unidades
```

## El salto pendiente en Scanner
{: #el-salto-pendiente-en-scanner }

nextInt consume el número. El primer nextLine consume el resto vacío de esa línea.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/71.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/71.webp' | relative_url }}" alt="El salto pendiente en Scanner. nextInt consume el número. El primer nextLine consume el resto vacío de esa línea. Resultado: 5, [], Ada" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var s = new java.util.Scanner("5\nAda\n");
        System.out.println(s.nextInt());
        System.out.println("[" + s.nextLine() + "]");
        System.out.println(s.nextLine());
    }
}
```

**Resultado esperado**

```text
5
[]
Ada
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/12-primeras-decisiones-con-if/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Lee un entero.
2. Lee un nombre completo.
3. Imprime una ficha con printf.
4. Lee nombre y cantidad en líneas distintas.
5. Lee cantidad seguida de nombre.
6. Rechaza texto no numérico.
7. Lee tres cantidades y calcula su suma.
8. Corrige el salto pendiente de nextInt.
9. Gestiona fin de entrada antes de leer.
10. Construye un registro de material con salida alineada.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Entrada y salida con Scanner. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Entrada y salida con Scanner</a>
</div>
