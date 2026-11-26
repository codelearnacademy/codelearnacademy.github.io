---
layout: lesson
route: spring
lesson_id: leccion112
lesson_number: "112"
lesson_file: 112-swagger-openapi
title: Swagger UI y contrato OpenAPI
description: Documenta las cinco operaciones del controlador CSV, comprueba el contrato con peticiones reales y aplícalo a los cinco almacenamientos de la API de tareas.
permalink: /spring/leccion112/
lessons:
  - { id: preparar, title: Preparar el servicio }
  - { id: contrato, title: Escribir el contrato HTTP }
  - { id: controlador, title: Documentar el controlador CSV }
  - { id: verificar, title: Comparar Swagger con la respuesta real }
  - { id: entrega, title: Documentar los cinco almacenamientos }
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Swagger UI y contrato OpenAPI

Un cliente acaba de crear una tarea. ¿Cómo sabe qué URL consultar para recuperarla? En esta lección vas a documentar la cabecera `Location`, comprobar que el servidor la envía y seguirla hasta la tarea creada. Después aplicarás el mismo método a las cinco operaciones del CRUD.

![Swagger UI permite enviar un POST y contrastar las respuestas 201 y 400 con el contrato OpenAPI.]({{ "/assets/images/spring/109-swagger-openapi.webp" | relative_url }})

## Preparar el servicio {#preparar}

Para una primera lectura, el [ejemplo de tareas en memoria]({{ "/spring/ejemplos/api-tareas.zip" | relative_url }}) ya tiene Swagger UI y responde en `/api/tareas`. Para realizar la práctica completa, usa **tu proyecto de tareas multi-almacenamiento** con el recorrido CSV implementado. Deben funcionar el servicio cualificado como `tareaServiceCsv`, el repositorio y `TareaMapperApi.toResponse`. Parte del CRUD de la [lección 111]({{ "/spring/leccion111/" | relative_url }}).

Comprueba en el POM la dependencia que incorporan los ejemplos. Basta una declaración:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>3.2.0</version>
</dependency>
```

Desde la carpeta que contiene `pom.xml` y `data/`, ejecuta `mvn spring-boot:run`. Abre [Swagger UI](http://localhost:8080/swagger-ui/index.html) para enviar peticiones y [OpenAPI en JSON](http://localhost:8080/v3/api-docs) para leer lo que se ha publicado sobre ellas. La sección **Responses** de Swagger UI describe el contrato. Tras pulsar **Execute**, **Server response** muestra lo ocurrido en esa petición.

## Escribir el contrato HTTP {#contrato}

La ruta base del ejemplo es `/api/csv/tareas`. El cliente envía y recibe JSON aunque el repositorio guarde CSV.

| Método y ruta relativa | Entrada | Éxito | Errores que se trabajan |
|---|---|---|---|
| GET a la colección | Sin cuerpo | 200 con un array de tareas, incluido `[]` | — |
| GET `/{id}` | ID en la URL | 200 con una tarea | 404 si el recurso está ausente |
| POST a la colección | JSON con título obligatorio | 201 con la tarea guardada y la cabecera `Location` | 400 por título inválido o JSON ilegible |
| PUT `/{id}` | ID en la URL y JSON con el título | 200 con la tarea actualizada | 400 por entrada inválida; 404 si el ID está ausente y el cuerpo es válido |
| DELETE `/{id}` | ID en la URL | 204 sin cuerpo | 404 si el recurso está ausente |

**Ejemplo de alta.** Envía `{"titulo":"Preparar entrega"}`. Si la respuesta contiene `{"id":7,"titulo":"Preparar entrega"}`, la cabecera `Location` debe apuntar a `/api/csv/tareas/7`. Usa siempre el ID que haya devuelto el servidor. El alta asigna el identificador en persistencia y el PUT selecciona la tarea mediante el ID de la URL.

## Documentar el controlador CSV {#controlador}

En `aula/tareas/controller/TareaControllerCsv.java`, usa `@Tag` para agrupar las operaciones y `@Operation` para explicar qué hace cada una. Con `@ApiResponse` describe el estado, el tipo de cuerpo y las cabeceras. El ejemplo devuelve un problema HTTP en los errores de validación y de lectura de JSON, y un 404 vacío al buscar una tarea ausente. Si tu proyecto ya centraliza los errores con un advice, conserva ese mecanismo y documenta el cuerpo y el tipo de contenido que devuelve.

```java
package aula.tareas.controller;

import aula.tareas.api.TareaRequest;
import aula.tareas.api.TareaResponse;
import aula.tareas.mapper.TareaMapperApi;
import aula.tareas.service.ITareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/csv/tareas")
@Tag(name = "Tareas CSV", description = "Tareas guardadas en el fichero CSV")
public class TareaControllerCsv {
    private final ITareaService servicio;

    public TareaControllerCsv(@Qualifier("tareaServiceCsv") ITareaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    @Operation(summary = "Listar las tareas CSV")
    @ApiResponse(responseCode = "200", description = "Lista, posiblemente vacía",
        content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = TareaResponse.class))))
    public List<TareaResponse> listar() {
        return servicio.listar().stream().map(TareaMapperApi::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar una tarea CSV por ID")
    @ApiResponse(responseCode = "200", description = "Tarea encontrada",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TareaResponse.class)))
    @ApiResponse(responseCode = "404", description = "ID inexistente", content = @Content)
    public ResponseEntity<TareaResponse> buscar(
            @Parameter(description = "ID asignado en el alta")
            @PathVariable("id") long id) {
        return ResponseEntity.of(servicio.buscar(id).map(TareaMapperApi::toResponse));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Crear una tarea CSV",
        description = "El almacenamiento asigna el ID. Location identifica el recurso creado.")
    @ApiResponse(responseCode = "201", description = "Tarea guardada",
        headers = @Header(name = "Location", description = "URI de la nueva tarea",
            schema = @Schema(type = "string", format = "uri-reference")),
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TareaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Título inválido o JSON ilegible",
        content = @Content(mediaType = "application/problem+json",
            schema = @Schema(implementation = ProblemDetail.class)))
    public ResponseEntity<TareaResponse> crear(@Valid @RequestBody TareaRequest request) {
        TareaResponse creada = TareaMapperApi.toResponse(servicio.crear(request));
        URI ruta = URI.create("/api/csv/tareas/" + creada.id());
        return ResponseEntity.created(ruta).body(creada);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Actualizar el título de una tarea CSV",
        description = "El ID de la ruta determina qué tarea se modifica.")
    @ApiResponse(responseCode = "200", description = "Tarea actualizada",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TareaResponse.class)))
    @ApiResponse(responseCode = "400", description = "Título inválido o JSON ilegible",
        content = @Content(mediaType = "application/problem+json",
            schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "404", description = "ID inexistente", content = @Content)
    public ResponseEntity<TareaResponse> actualizar(
            @PathVariable("id") long id, @Valid @RequestBody TareaRequest request) {
        return ResponseEntity.of(servicio.actualizar(id, request).map(TareaMapperApi::toResponse));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea CSV")
    @ApiResponse(responseCode = "204", description = "Tarea eliminada", content = @Content)
    @ApiResponse(responseCode = "404", description = "ID inexistente", content = @Content)
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        if (servicio.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ProblemDetail> entradaInvalida(Exception error) {
        String detalle = error instanceof MethodArgumentNotValidException
            ? "El título es obligatorio y debe contener texto."
            : "Envía un objeto JSON válido.";
        ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detalle);
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_PROBLEM_JSON).body(problema);
    }
}
```

**Documenta los campos.** En el DTO de entrada conserva la validación `@NotBlank`. Añade descripciones y ejemplos en el propio tipo para que aparezcan en el esquema que comparten POST y PUT:

```java
package aula.tareas.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record TareaRequest(
    @Schema(description = "Opcional. El alta genera el ID y la actualización usa el de la URL.")
    Long id,
    @NotBlank
    @Schema(description = "Título con al menos un carácter distinto de un espacio",
            example = "Preparar entrega", requiredMode = Schema.RequiredMode.REQUIRED)
    String titulo
) {}
```

En Swagger UI, despliega **Schemas** y compara `TareaRequest` con `TareaResponse`. El primero explica qué debe enviar el cliente. El segundo muestra el ID y el título que ha guardado el servidor. Los nombres internos `identificador`, `nombre`, `idTarea` y `nombreTarea` pertenecen al dominio o a la persistencia.

## Comparar Swagger con la respuesta real {#verificar}

Reinicia la aplicación y abre la etiqueta **Tareas CSV**. En cada operación, pulsa **Try it out**, introduce los datos y selecciona **Execute**.

1. **Crear.** Envía un POST con `{"titulo":"Preparar entrega"}`. Comprueba el `201`, el ID del cuerpo y la cabecera real `Location`. Abre esa URI mediante GET y confirma el `200` y el título.
2. **Actualizar.** Haz PUT sobre el ID creado con `{"titulo":"Revisar entrega"}`. Espera `200`. Repite con `{"titulo":" "}`. Comprueba `400`, el `Content-Type` y el cuerpo de error. Un GET posterior debe conservar «Revisar entrega». Prueba también el POST en blanco.
3. **Eliminar.** Borra la tarea. Comprueba `204` y cuerpo vacío. Con el mismo ID, repite GET, PUT con título válido y DELETE. Los tres deben devolver `404`.
4. **Contrastar la especificación.** En el JSON de OpenAPI, localiza `paths → /api/csv/tareas → post → responses → 201 → headers → Location`. En la operación DELETE, abre la respuesta `204` y comprueba que carece de un esquema de cuerpo. Compara el contenido documentado en el `400` con el observado en el paso 2.

**Ejercicio de diagnóstico.** Conserva `ResponseEntity.created(ruta)` y quita temporalmente el argumento `headers` de la anotación del POST. Tras reiniciar, compara la respuesta real con el JSON de OpenAPI. Explica qué información pierde un cliente que solo dispone de la especificación. Restaura la declaración de `Location`.

## Documentar los cinco almacenamientos {#entrega}

Aplica el contrato al resto de los controladores. Actualiza la etiqueta, la ruta de clase, el calificador del servicio y la URI generada por POST para cada tecnología. Comprueba especialmente que el `Location` de una tarea JSON conduce al controlador JSON.

| Etiqueta | Ruta base | Operaciones |
|---|---|---|
| Tareas CSV | `/api/csv/tareas` | GET de colección, GET por ID, POST, PUT y DELETE |
| Tareas JSON | `/api/json/tareas` | Las mismas cinco |
| Tareas XML | `/api/xml/tareas` | Las mismas cinco |
| Tareas JDBC | `/api/jdbc/tareas` | Las mismas cinco |
| Tareas ORM | `/api/orm/tareas` | Las mismas cinco |

**Documenta también el servicio Java.** El contrato HTTP utiliza `404` para un ID ausente. En el Javadoc de `ITareaService.buscar(long id)`, describe cómo se comunica esa ausencia al controlador:

```java
/**
 * Recupera una tarea del almacenamiento asociado al servicio.
 * @param id identificador asignado a la tarea
 * @return la tarea encontrada o un Optional vacío si el ID no existe
 */
Optional<Tarea> buscar(long id);
```

Aplica el mismo criterio a los demás métodos de `ITareaService` e `ITareaRepository`. En `ITareaRepositoryJpa`, explica en el Javadoc de la interfaz la entidad gestionada, el tipo de ID y el comportamiento heredado que usa el adaptador ORM.

**Entrega.** Exporta el contrato mientras la API esté en marcha:

```sh
curl -fsS http://localhost:8080/v3/api-docs -o openapi.json
```

Entrega el archivo y una tabla con una fila por almacenamiento. En cada fila registra el ID real, el `Location`, el resultado del PUT inválido y el del segundo DELETE. Revisa que en los diez paths de la práctica (colección y recurso para cada tecnología) estén documentadas las **25 operaciones**. Cada alta debe conducir a la tarea correcta y cada respuesta documentada debe coincidir con el comportamiento observado.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion111/' | relative_url }}">← 111 · Diseño de servicios REST</a>
</div>
