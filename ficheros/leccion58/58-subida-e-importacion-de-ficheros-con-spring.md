---
layout: lesson
route: ficheros
lesson_id: leccion58
lesson_file: 58-subida-e-importacion-de-ficheros-con-spring
lesson_number: "58"
title: Subida e importación de ficheros con Spring
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion58/
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

# Subida e importación de ficheros con Spring

## Qué vas a conseguir

- Comprender **Subida e importación de ficheros con Spring**.
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

Implementa un endpoint que reciba un CSV mediante `MultipartFile`. El controlador no debe contener el parser ni la lógica de validación; delega esas responsabilidades en un servicio:

```java
@RestController
class ImportacionController {
  private final ImportacionService service;

  ImportacionController(ImportacionService service) {
    this.service = service;
  }

  @PostMapping("/importaciones", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  Map<String, Integer> importar(@RequestParam("fichero") MultipartFile fichero)
      throws IOException {
    return Map.of("registros", service.importar(fichero.getInputStream()));
  }
}
```

El servicio debe leer el `InputStream`, validar cada fila y devolver un resumen. No guardes el nombre original del fichero como ruta sin validarlo ni cargues ficheros enormes completos en memoria.



## Relación con el resto de la ruta

Maven, Spring y Docker añaden empaquetado, endpoints, recursos, configuración externa y volúmenes alrededor de las mismas APIs.

## Ejercicios propuestos

1. Implementa el servicio que cuente filas válidas y rechace columnas incompletas.
2. Devuelve un error claro cuando falta la parte `fichero`.
3. Limita el tamaño del archivo y rechaza extensiones no permitidas.
4. Añade una prueba MockMvc con un CSV válido y otro inválido.
5. Explica por qué el controlador no debe encargarse del parsing.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion57/">← 57 · Properties y Jackson en Spring Boot</a>
  <a href="/ficheros/leccion59/">59 · Ficheros, volúmenes y configuración en Docker →</a>
</div>
