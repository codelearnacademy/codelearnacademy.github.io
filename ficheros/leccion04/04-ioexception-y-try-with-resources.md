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
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: relacion-con-el-resto-de-la-ruta
    title: "Relación con el resto de la ruta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-leer-con-recursos
    title: "Microproyecto · Leer con recursos"
---

# IOException y try-with-resources

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Tratar errores de E/S de forma explícita.
- Cerrar recursos automáticamente con `try-with-resources`.

## Punto de partida
{: #punto-de-partida }

Abrir un fichero puede fallar por permisos, ausencia, rutas inválidas o errores del dispositivo.

<div class="cla-note"><strong>Errores de E/S</strong><p>Distingue los fallos esperables de acceso a fichero y usa <code>try-with-resources</code> cuando abras recursos que deban cerrarse.</p></div>

## Conceptos clave
{: #conceptos-clave }

- `IOException` representa fallos de entrada/salida comprobados.
- `try-with-resources` cierra streams, readers, writers y parsers que implementan `AutoCloseable`.
- Capturar una excepción solo tiene sentido si puedes recuperarte o añadir contexto útil.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/04.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/04.webp' | relative_url }}" alt="Abrir → leer → cerrar. El lector se declara en try-with-resources. Un error de lectura llega al llamador como IOException." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo guiado
{: #ejemplo-guiado }

```java
Path file = Path.of("data", "entrada.txt");
try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
    System.out.println(reader.readLine());
}
```

## Relación con el resto de la ruta
{: #relacion-con-el-resto-de-la-ruta }

Commons CSV y algunos usos de Jackson aceptan streams/readers; aquí aprendes a controlar correctamente su ciclo de vida.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Intenta leer un fichero inexistente y muestra un mensaje que incluya su ruta.
2. Usa `try-with-resources` con `BufferedWriter` para crear un fichero.

## Qué debes recordar
{: #que-debes-recordar }

- No ocultes un `IOException` con un `catch` vacío.
- Si abres un recurso, asegúrate de que se cierra incluso si ocurre un error.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Leer con recursos
{: #microproyecto-leer-con-recursos }

Devuelve la primera línea o el texto vacío si el fichero está vacío. Usa un lector que se cierre incluso si falla y propaga IOException.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F04-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F04-tarea-01.webp' | relative_url }}" alt="Leer con recursos. Resultado esperado: Primera línea o error de lectura" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Primera línea o error de lectura.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion04/F04-tarea-01.zip' | relative_url }}">Descargar F04-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion03/' | relative_url }}">← 3 · Lectura y escritura de texto</a>
  <a href="{{ '/ficheros/leccion05/' | relative_url }}">5 · Maven y dependencias →</a>
</div>
