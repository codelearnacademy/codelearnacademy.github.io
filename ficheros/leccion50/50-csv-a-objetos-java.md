---
layout: lesson
route: ficheros
lesson_id: leccion50
lesson_file: 50-csv-a-objetos-java
lesson_number: "50"
title: CSV a objetos Java
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion50/
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

# CSV a objetos Java

## Qué vas a conseguir

- Comprender **CSV a objetos Java**.
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
interface DataReader<T> {
    List<T> read(Path path) throws IOException;
}
interface DataWriter<T> {
    void write(Path path, List<T> data) throws IOException;
}
```



## Relación con el resto de la ruta

El modelo de dominio debe ser independiente del formato para permitir cambiar CSV, JSON o XML sin reescribir la lógica.

## Ejercicios propuestos

1. Implementa una conversión entre dos formatos utilizando un único modelo de dominio.
2. Comprueba que los datos conservan sus tipos y valores después de la conversión.
3. Rechaza registros inválidos sin detener una importación completa cuando proceda.
4. Compara las ventajas y pérdidas de cada formato elegido.
5. Añade pruebas de ida y vuelta y de datos corruptos.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion49/">← 49 · Elegir entre properties, CSV, JSON y XML</a>
  <a href="/ficheros/leccion51/">51 · Objetos Java a JSON y XML →</a>
</div>
