---
layout: lesson
route: maven
lesson_id: principal01
lesson_number: "01"
title: "Qué problema resuelve Maven"
description: "Comprueba qué tareas automatiza Maven a partir de una aplicación Java mínima."
permalink: /maven/01-problema-que-resuelve-maven/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Qué problema resuelve Maven

Comprueba qué tareas automatiza Maven a partir de una aplicación Java mínima.
## Objetivo y punto de partida

Necesitas conocimientos básicos de clases, métodos y terminal. Antes de instalar Maven, observa qué hace el JDK. Trabaja en una carpeta de práctica fuera del proyecto final.

## Práctica guiada

Guarda `Main.java`:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Una tarea: aprender Maven");
    }
}
```

```bash
javac Main.java
java Main
```

`javac` transforma el código en `Main.class`; `java` ejecuta la clase. Debe aparecer `Una tarea: aprender Maven`. Java no necesita Maven para funcionar.

Cuando incorporas bibliotecas debes conseguir sus JAR, configurar el classpath y repetir ese trabajo en cada equipo. Si además añades pruebas y empaquetado, necesitas un proceso común. Maven describe ese proceso en `pom.xml`, resuelve dependencias y ejecuta plugins para compilar, probar y empaquetar. Git conserva los archivos fuente; CI ejecuta el proceso automáticamente.

## Comprobación y errores habituales

`java Main.class` es incorrecto: utiliza el nombre de la clase sin extensión. Si no existe `javac`, falta un JDK o su directorio `bin` no está en `PATH`. La siguiente lección prepara el entorno.

## Ejercicio

Cambia el mensaje y ejecuta `java Main` antes de recompilar. Explica por qué todavía aparece el mensaje anterior. Recompila y comprueba el cambio.

## Qué debes recordar

El JDK compila y ejecuta Java. Maven coordina la construcción del proyecto y utiliza herramientas del JDK mediante plugins.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/' | relative_url }}">← Índice de Maven</a>
<a href="{{ '/maven/02-instalar-jdk-maven/' | relative_url }}">02 · Instalar JDK 21 y Maven →</a>
</nav>
