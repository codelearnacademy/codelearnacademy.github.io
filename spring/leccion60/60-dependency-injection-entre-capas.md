---
layout: lesson
route: spring
lesson_id: leccion60
lesson_file: 60-dependency-injection-entre-capas
lesson_number: "60"
title: Dependency Injection entre capas
description: Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.
permalink: /spring/leccion60/
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
# Dependency Injection entre capas

Organiza una aplicación separando HTTP, negocio y persistencia con dependencias explícitas.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Dependency Injection entre capas** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Arquitectura por capas.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Controller: Recibe el servicio. Service: Recibe el repositorio. Repository: Bean de acceso a datos.]({{ "/assets/images/spring/57-dependency-injection-entre-capas.webp" | relative_url }})

## Ejemplo guiado

```java
TaskController(TaskService service) { ... }
TaskService(TaskRepository repository) { ... }
```



## Relación con el resto de la ruta

Relaciona capas con Clean Code, testing y Dependency Inversion. Cada capa debe tener una responsabilidad verificable.



## Ejemplo adicional: aplicación práctica

```java
@Service
class TaskService {
    private final TaskRepository repository;
    TaskService(TaskRepository repository) { this.repository = repository; }
}
```

La inyección por constructor conecta capas sin instanciarlas manualmente.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Sitúa **Dependency Injection entre capas** en la estructura `controller` → `service` → `repository`.
2. Crea un método de servicio con una regla simple y delega la persistencia en el repositorio.
3. Escribe un test aislado del servicio usando una dependencia simulada; no accedas a la base desde el controlador.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Dependency Injection entre capas** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion59/">← 59 · Responsabilidad del Repository</a>
  <a href="/spring/leccion61/">61 · Interfaces y desacoplamiento →</a>
</div>
