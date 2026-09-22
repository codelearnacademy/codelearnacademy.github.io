---
layout: lesson
route: ficheros
lesson_id: leccion15
lesson_file: 15-guardar-properties
lesson_number: "15"
title: Guardar properties
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion15/
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

# Guardar properties

## Qué vas a conseguir

- Comprender **Guardar properties**.
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

Este programa crea propiedades, las guarda y vuelve a leerlas. Guarda como `GuardarProperties.java` y ejecuta `java GuardarProperties.java` en una carpeta de práctica; escribe `config.properties` en esa carpeta.

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Properties;

public class GuardarProperties {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("config.properties");
        Properties original = new Properties();
        original.setProperty("app.name", "Gestión de tareas");
        original.setProperty("app.port", "8080");
        try (Writer out = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            original.store(out, "Configuración de ejemplo");
        }
        Properties copia = new Properties();
        try (Reader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            copia.load(in);
        }
        if (!original.equals(copia)) throw new IllegalStateException("Datos distintos");
        System.out.println(copia.getProperty("app.name"));
    }
}
```

El resultado es `Gestión de tareas`. `store` escribe y `load` lee. En este ejemplo ambos usan caracteres UTF-8 mediante Writer/Reader; las variantes con InputStream/OutputStream tienen otras reglas de codificación. El archivo puede incluir comentarios y una fecha: comprueba las propiedades, no igualdad literal de todos sus bytes.


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
  <a href="/ficheros/leccion14/">← 14 · Convertir valores a tipos Java</a>
  <a href="/ficheros/leccion16/">16 · Properties en src/main/resources →</a>
</div>
