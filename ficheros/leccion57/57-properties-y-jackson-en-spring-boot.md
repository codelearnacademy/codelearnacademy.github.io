---
layout: lesson
route: ficheros
lesson_id: leccion57
lesson_file: 57-properties-y-jackson-en-spring-boot
lesson_number: "57"
title: Properties y Jackson en Spring Boot
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion57/
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

# Properties y Jackson en Spring Boot

## Qué vas a conseguir

- Comprender **Properties y Jackson en Spring Boot**.
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

Parte de una aplicación Spring Boot con las dependencias `spring-boot-starter-web` y `jackson-databind`. Guarda la configuración en `src/main/resources/application.properties`:

```properties
app.catalogo=ruta/catalogo.json
spring.jackson.default-property-inclusion=non_null
```

Expón una clase de configuración y un endpoint que devuelva un objeto Java. Spring utilizará Jackson para convertirlo en JSON:

```java
@RestController
class CatalogoController {
  @Value("${app.catalogo}")
  private String rutaCatalogo;

  @GetMapping("/catalogo/configuracion")
  Map<String, String> configuracion() {
    return Map.of("catalogo", rutaCatalogo);
  }
}
```

Prueba `GET /catalogo/configuracion` y comprueba que la respuesta es JSON. La propiedad configura la aplicación; Jackson transforma el `Map` en la respuesta HTTP.



## Relación con el resto de la ruta

Maven, Spring y Docker añaden empaquetado, endpoints, recursos, configuración externa y volúmenes alrededor de las mismas APIs.

## Ejercicios propuestos

1. Añade la propiedad y crea el endpoint de configuración.
2. Cambia la ruta mediante un perfil `application-dev.properties` sin modificar el código.
3. Añade un campo nullable al DTO y comprueba el efecto de `non_null`.
4. Escribe una prueba MVC que compruebe el código HTTP y el JSON devuelto.
5. Explica qué parte corresponde a Spring, qué parte a Jackson y qué parte a `application.properties`.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion56/">← 56 · Recursos internos frente a ficheros externos</a>
  <a href="/ficheros/leccion58/">58 · Subida e importación de ficheros con Spring →</a>
</div>
