---
layout: lesson
route: ficheros
lesson_id: leccion62
lesson_file: 62-proyecto-final-databridge
lesson_number: "62"
title: Proyecto final · DataBridge
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion62/
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

# Proyecto final · DataBridge

## Qué vas a conseguir

- Comprender **Proyecto final · DataBridge**.
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

```text
properties → configuración
CSV        → datos tabulares
JSON       → APIs y objetos
XML        → documentos e integraciones enterprise
```

Adapta el ejemplo al concepto de esta lección y comprueba el resultado con un fichero pequeño antes de aumentar el volumen de datos.

## Proyecto integrador · DataBridge

Construye una aplicación que lea productos desde CSV, JSON o XML y los exporte a cualquiera de esos formatos.

```java
public record Producto(long id, String nombre, BigDecimal precio, int stock) {}
```

Configuración:

```properties
input.format=csv
input.file=data/productos.csv
output.format=json
output.file=output/productos.json
validation.allowNegativeStock=false
```

Arquitectura:

```text
config.properties
      ↓
ReaderFactory
 ├─ CsvProductoReader
 ├─ JsonProductoReader
 └─ XmlProductoReader
      ↓
List<Producto>
      ↓
ProductoValidator
      ↓
WriterFactory
 ├─ CsvProductoWriter
 ├─ JsonProductoWriter
 └─ XmlProductoWriter
```

Debe soportar CSV→JSON, CSV→XML, JSON→CSV, JSON→XML, XML→CSV y XML→JSON, informar de registros válidos/erróneos y disponer de pruebas con `@TempDir`.

Como extensión, reutiliza los readers/writers desde Spring Boot para importar mediante `MultipartFile` y monta `/data` y `/config` como volúmenes Docker.


## Relación con el resto de la ruta

Todos los ecosistemas resuelven lectura, parsing, validación y escritura, aunque reparten las responsabilidades entre biblioteca estándar y paquetes externos.

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
  <a href="/ficheros/leccion61/">← 61 · Java frente a JavaScript, Python y Go</a>
  <a href="/spring/">Continuar con Spring →</a>
</div>
