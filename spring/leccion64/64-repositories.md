---
layout: lesson
route: spring
lesson_id: leccion64
lesson_file: 64-repositories
lesson_number: "64"
title: Repositories
description: Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.
permalink: /spring/leccion64/
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
# Repositories

Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Repositories** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Persistencia con JPA y PostgreSQL.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Interfaz: Declara el método. Spring Data: Implementa el repositorio. Base: Devuelve las tareas.]({{ "/assets/images/spring/64-repositories.webp" | relative_url }})

## Ejemplo guiado

```java
interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
}
```



### Operaciones del repositorio

```java
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTitleContainingIgnoreCase(String text);
}
```

`findAll()` devuelve una lista vacía cuando la tabla no tiene registros. Para búsquedas por ID, `findById()` devuelve `Optional<TaskEntity>`. Adapta esos resultados al contrato de tu servicio sin imprimir por consola.

## Relación con el resto de la ruta

PostgreSQL es infraestructura. JPA abstrae persistencia, Spring Data reduce código repetitivo y Flyway controla evolución del esquema.



## Ejemplo adicional: aplicación práctica

```java
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTitleContainingIgnoreCase(String texto);
    @Query("select t from TaskEntity t where t.completed = false")
    List<TaskEntity> pendientes();
}
```

Spring Data deriva consultas y permite JPQL cuando la búsqueda es específica.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa el concepto **Repositories** en una entidad `TaskEntity` y su repositorio.
2. Añade una prueba de repositorio que compruebe los cambios persistidos, no solo los objetos en memoria.
3. Comprueba un caso límite: registro inexistente, relación inválida o transacción fallida, según corresponda.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Repositories** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion63/">← 63 · Identificadores</a>
  <a href="/spring/leccion65/">65 · Relaciones entre entidades →</a>
</div>
