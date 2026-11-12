---
layout: lesson
route: spring
lesson_id: leccion62
lesson_file: 62-entidades-jpa
lesson_number: "62"
title: Entidades JPA
description: Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.
permalink: /spring/leccion62/
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
# Entidades JPA

Integra PostgreSQL mediante JPA, Spring Data, transacciones y migraciones controladas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Entidades JPA** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Persistencia con JPA y PostgreSQL.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
@Entity
@Table(name = "tasks")
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
```



### Separación entre entidad y modelo

```java
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    protected TaskEntity() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
```

El modelo `Task` es una clase Java normal con constructor, getters y setters. Los servicios no deben utilizar entidades como respuesta HTTP. La conversión se concentra en `TaskMapper`.

## Relación con el resto de la ruta

PostgreSQL es infraestructura. JPA abstrae persistencia, Spring Data reduce código repetitivo y Flyway controla evolución del esquema.



## Ejemplo adicional: aplicación práctica

```java
@Entity
@Table(name = "tareas")
public class TaskEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String title;
    protected TaskEntity() {}
    public Long getId() { return id; }
    public String getTitle() { return title; }
}
```

La entidad representa la tabla; el DTO define el contrato externo.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Implementa el concepto **Entidades JPA** en una entidad `TaskEntity` y su repositorio.
2. Añade una prueba de repositorio que compruebe los cambios persistidos, no solo los objetos en memoria.
3. Comprueba un caso límite: registro inexistente, relación inválida o transacción fallida, según corresponda.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Entidades JPA** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion61/">← 61 · Configurar DataSource</a>
  <a href="/spring/leccion63/">63 · Identificadores →</a>
</div>
