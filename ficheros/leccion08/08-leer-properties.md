---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion08"
lesson_file: "08-leer-properties"
lesson_number: "8"
title: "Leer .properties"
description: "Leer .properties: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion08/"
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

# Leer .properties

## Qué vas a conseguir

- Cargar un `.properties` con Java 21.
- Leer valores obligatorios, opcionales y tipados.

## Punto de partida

`Properties.getProperty` devuelve `String`; la aplicación decide cómo validar y convertir cada valor.

<div class="cla-note"><strong>Lectura de configuración</strong><p>Centraliza la conversión de cadenas a tipos Java y define qué ocurre cuando una clave no existe.</p></div>

## Conceptos clave

- `Properties.load(Reader)` carga pares clave-valor.
- `getProperty(clave, defecto)` evita algunos `null`.
- La conversión a número o booleano pertenece a la lógica de configuración.

## Ejemplo guiado

```java
Properties props = new Properties();
try (Reader reader = Files.newBufferedReader(Path.of("config.properties"), StandardCharsets.UTF_8)) {
    props.load(reader);
}
String name = props.getProperty("app.name", "FileLab");
int port = Integer.parseInt(props.getProperty("server.port", "8080"));
```

## Relación con el resto de la ruta

Después de aprender a cargar configuración, la siguiente lección modifica y persiste esas claves.

## Ejercicios propuestos

1. Lee `app.name`, `server.port` y `debug`.
2. Usa valores por defecto para dos claves y provoca un error de conversión controlado en otra.

## Qué debes recordar

- `getProperty` no convierte tipos.
- Valida valores antes de utilizarlos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion07/">← 7 · El formato .properties</a>
  <a href="/ficheros/leccion09/">9 · Crear y modificar .properties →</a>
</div>
