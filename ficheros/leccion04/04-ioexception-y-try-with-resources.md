---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion04"
lesson_file: "04-ioexception-y-try-with-resources"
lesson_number: "4"
title: "IOException y try-with-resources"
description: "IOException y try-with-resources: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion04/"
lessons:
  - id: "qué-vas-a-conseguir"
    title: "Qué vas a conseguir"
  - id: "punto-de-partida"
    title: "Punto de partida"
  - id: "conceptos-clave"
    title: "Conceptos clave"
  - id: "ejemplo-guiado"
    title: "Ejemplo guiado"
  - id: "relación-con-el-resto-de-la-ruta"
    title: "Relación con el resto de la ruta"
  - id: "ejercicios-propuestos"
    title: "Ejercicios propuestos"
  - id: "qué-debes-recordar"
    title: "Qué debes recordar"
---

# IOException y try-with-resources

## Qué vas a conseguir

- Tratar errores de E/S de forma explícita.
- Cerrar recursos automáticamente con `try-with-resources`.

## Punto de partida

Abrir un fichero puede fallar por permisos, ausencia, rutas inválidas o errores del dispositivo.

<div class="cla-note"><strong>Errores de E/S</strong><p>Distingue los fallos esperables de acceso a fichero y usa <code>try-with-resources</code> cuando abras recursos que deban cerrarse.</p></div>

## Conceptos clave

- `IOException` representa fallos de entrada/salida comprobados.
- `try-with-resources` cierra streams, readers, writers y parsers que implementan `AutoCloseable`.
- Capturar una excepción solo tiene sentido si puedes recuperarte o añadir contexto útil.

## Ejemplo guiado

```java
Path file = Path.of("data", "entrada.txt");
try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
    System.out.println(reader.readLine());
}
```

## Relación con el resto de la ruta

Commons CSV y algunos usos de Jackson aceptan streams/readers; aquí aprendes a controlar correctamente su ciclo de vida.

## Ejercicios propuestos

1. Intenta leer un fichero inexistente y muestra un mensaje que incluya su ruta.
2. Usa `try-with-resources` con `BufferedWriter` para crear un fichero.

## Qué debes recordar

- No ocultes un `IOException` con un `catch` vacío.
- Si abres un recurso, asegúrate de que se cierra incluso si ocurre un error.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion03/">← 3 · Lectura y escritura de texto</a>
  <a href="/ficheros/leccion05/">5 · Maven y dependencias →</a>
</div>
