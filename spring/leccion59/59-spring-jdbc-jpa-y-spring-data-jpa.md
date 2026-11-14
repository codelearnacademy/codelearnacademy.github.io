---
layout: lesson
route: spring
lesson_id: leccion59
lesson_file: 59-spring-jdbc-jpa-y-spring-data-jpa
lesson_number: "59"
title: Spring JDBC, JPA y Spring Data JPA
description: Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.
permalink: /spring/leccion59/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# Spring JDBC, JPA y Spring Data JPA

Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring JDBC, JPA y Spring Data JPA** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Persistencia con JPA y PostgreSQL.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Spring JDBC: SQL explícito. JPA: Mapeo de entidades. Spring Data JPA: Abstracción de repositorio sobre JPA.]({{ "/assets/images/spring/59-spring-jdbc-jpa-y-spring-data-jpa.webp" | relative_url }})

## Ejemplo guiado

```text
JDBC → API de bajo nivel
JPA/Hibernate → ORM
Spring Data JPA → abstracción de repositories sobre JPA
```



## Relación con el resto de la ruta

PostgreSQL es infraestructura. JPA abstrae persistencia, Spring Data reduce código repetitivo y Flyway controla evolución del esquema.



## Ejemplo adicional: aplicación práctica

```java
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("select t from TaskEntity t where t.completed = :estado")
    List<TaskEntity> buscarPorEstado(@Param("estado") boolean estado);
}
```

Spring Data JPA simplifica el acceso a datos y permite JPQL parametrizado.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa el concepto **Spring JDBC, JPA y Spring Data JPA** en una entidad `TaskEntity` y su repositorio.
2. Añade una prueba de repositorio que compruebe los cambios persistidos, no solo los objetos en memoria.
3. Comprueba un caso límite: registro inexistente, relación inválida o transacción fallida, según corresponda.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring JDBC, JPA y Spring Data JPA** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion58/">← 58 · Interfaces y desacoplamiento</a>
  <a href="/spring/leccion60/">60 · Añadir PostgreSQL mediante Maven →</a>
</div>
