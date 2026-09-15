---
layout: lesson
route: ficheros
lesson_id: leccion38
lesson_file: 38-jsonnode-y-modelo-de-arbol
lesson_number: "38"
title: JsonNode y modelo de árbol
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion38/
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

# JsonNode y modelo de árbol

## Qué vas a conseguir

- Comprender **JsonNode y modelo de árbol**.
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

Con Jackson 2 y `jackson-databind` en el proyecto, `readTree` permite inspeccionar JSON sin crear un DTO. Importa `ObjectMapper` y `JsonNode` desde `com.fasterxml.jackson.databind`.

```java
ObjectMapper mapper = new ObjectMapper();
JsonNode root = mapper.readTree("{\"nombre\":\"Ana\",\"edad\":22,\"alias\":null}");
JsonNode edad = root.path("edad");
if (!edad.isIntegralNumber() || !edad.canConvertToInt()) {
    throw new IllegalArgumentException("edad debe ser un entero representable");
}
System.out.println(edad.intValue());
System.out.println(root.path("alias").isNull());
System.out.println(root.path("telefono").isMissingNode());
```

Ejecuta el fragmento dentro de un método que gestione las excepciones de lectura. La salida es `22`, `true`, `true`. Un campo ausente y un campo con `null` son estados diferentes. `path` permite encadenar consultas sin devolver Java null; valida tipos antes de convertir, porque algunas conversiones ofrecen valores por defecto que pueden ocultar datos erróneos.


## Relación con el resto de la ruta

Spring MVC utiliza Jackson habitualmente para convertir JSON HTTP en DTOs Java y viceversa.

## Ejercicios propuestos

1. Reproduce el ejemplo y guarda el resultado en un repositorio Git.
2. Introduce un fichero válido y otro mal formado; compara el comportamiento.
3. Cambia el nombre/ruta del fichero para recibirlo como argumento del programa.
4. Explica qué parte resuelve Java estándar y cuál depende de una biblioteca externa.
5. Escribe una prueba para el caso principal o describe cómo la automatizarías.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion37/">← 37 · Campos ignorados, opcionales y null</a>
  <a href="/ficheros/leccion39/">39 · Qué es XML →</a>
</div>
