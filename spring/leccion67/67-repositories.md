---
layout: lesson
route: spring
lesson_id: leccion67
lesson_file: 67-repositories
lesson_number: "67"
title: Repositories
description: Sigue las llamadas a los repositorios desde el servicio hasta SQLite.
permalink: /spring/leccion67/
lessons:
  - id: práctica-con-sqlite3
    title: Práctica con SQLite3
  - id: comprueba-lo-aprendido
    title: Comprueba lo aprendido
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>

# Repositories

Sigue las llamadas a los repositorios desde el servicio hasta SQLite.

## Práctica con SQLite3

Usa el [proyecto de tareas y categorías]({{ '/spring/ejemplos/api-tareas-sqlite.zip' | relative_url }}) para continuar la práctica de las lecciones 64–70.

El repositorio de tareas declara `JpaRepository<TareaEntity, Long>`. Spring Data implementa operaciones como `save` y `findById`. El servicio busca la categoría, guarda la tarea y convierte el resultado en el DTO de salida.

```java
public interface TareaRepository extends JpaRepository<TareaEntity, Long> {}
```

**Ejercicio breve.** Sigue el POST desde `TareaController.crear` hasta la llamada a `tareas.save`. Indica qué realiza `categorias.findById` y qué información añade `respuesta`. Para observar las consultas, arranca temporalmente con:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.jpa.show-sql=true
```

Crea una tarea y luego consulta la URL de `Location`. Reconoce la búsqueda de la categoría, la inserción y la consulta por ID.

## Comprueba lo aprendido

Repite el ejercicio cambiando un dato de entrada o usando un archivo nuevo para la migración. Registra el resultado esperado y lo observado en la API, en la consulta SQL o en la prueba.

<div class="cla-lesson-nav">
  <a href="/spring/leccion66/">← 66 · Identificadores</a>
  <a href="/spring/leccion68/">68 · Relaciones entre entidades →</a>
</div>
