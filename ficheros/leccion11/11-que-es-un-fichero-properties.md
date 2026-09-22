---
layout: lesson
route: ficheros
lesson_id: leccion11
lesson_file: 11-que-es-un-fichero-properties
lesson_number: "11"
title: Qué es un fichero properties
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion11/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Qué es un fichero properties

## Qué vas a conseguir

- Comprender **Qué es un fichero properties**.
- Aplicarlo con Java 21.
- Distinguir lectura, parsing, validación y escritura.
- Relacionarlo con Maven, Spring o Docker cuando corresponda.

## Punto de partida

```text
Fichero → bytes/texto → parser → objetos Java → validación → lógica → writer → fichero
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Leer un fichero no es interpretarlo. Un parser entiende el formato; la lógica de negocio valida el significado.</p></div>

## Conceptos clave

- Acceso mediante `Path` y `Files`.
- UTF-8 explícito cuando trabajamos con texto.
- Manejo de errores mediante excepciones.
- Separación entre formato y modelo de dominio.

## Ejemplo guiado

```java
Properties props = new Properties();
try (Reader r = Files.newBufferedReader(Path.of("config.properties"))) {
    props.load(r);
}
String name = props.getProperty("app.name", "CodeLearn");
```



## Relación con el resto de la ruta

Spring Boot amplía properties mediante application.properties, YAML, profiles y variables de entorno.

## Ejercicios propuestos

1. Crea un fichero de configuración específico para este concepto.
2. Define y comprueba un valor por defecto o un valor obligatorio.
3. Convierte el valor leído al tipo adecuado y gestiona un dato inválido.
4. Guarda la configuración sin perder caracteres especiales ni la codificación.
5. Añade una prueba que compruebe precedencia, ausencia o formato incorrecto.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion10/">← 10 · Serialización, deserialización y modelo de dominio</a>
  <a href="/ficheros/leccion12/">12 · Leer properties con java.util.Properties →</a>
</div>
