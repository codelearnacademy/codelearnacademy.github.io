---
layout: lesson
route: spring
lesson_id: leccion53
lesson_file: 53-controller-service-y-repository
lesson_number: "53"
title: Controller, Service y Repository
description: Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.
permalink: /spring/leccion53/
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
# Controller, Service y Repository

Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Controller, Service y Repository** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Arquitectura por capas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```text
TaskController
      ↓
TaskService
      ↓
TaskRepository
```



### Organización del proyecto

```text
src/main/java/com/ejemplo/tareas/
├── api/TaskController.java
├── dto/TaskRequest.java
├── dto/TaskResponse.java
├── model/Task.java
├── mapper/TaskMapper.java
├── entity/TaskEntity.java
├── repository/TaskRepository.java
├── service/TaskService.java
└── config/
```

El `Controller` gestiona HTTP; el `Service` aplica las reglas; el `Repository` consulta y persiste `TaskEntity`; el `Mapper` adapta los datos entre las capas. El modelo `Task` no contiene anotaciones JPA.

## Relación con el resto de la ruta

Relaciona capas con Clean Code, testing y Dependency Inversion. Cada capa debe tener una responsabilidad verificable.



## Ejemplo adicional: aplicación práctica

```java
@RestController class TaskController {
    private final TaskService service;
    TaskController(TaskService service) { this.service = service; }
}
@Service class TaskService {
    private final TaskRepository repository;
    TaskService(TaskRepository repository) { this.repository = repository; }
}
```

Controller trata HTTP; Service aplica reglas; Repository accede a datos.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Sitúa **Controller, Service y Repository** en la estructura `controller` → `service` → `repository`.
2. Crea un método de servicio con una regla simple y delega la persistencia en el repositorio.
3. Escribe un test aislado del servicio usando una dependencia simulada; no accedas a la base desde el controlador.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Controller, Service y Repository** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion52/">← 52 · Tomcat 10 frente a Tomcat 11</a>
  <a href="/spring/leccion54/">54 · Responsabilidad del Controller →</a>
</div>
