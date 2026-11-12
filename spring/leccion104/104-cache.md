---
layout: lesson
route: spring
lesson_id: leccion104
lesson_file: 104-cache
lesson_number: "104"
title: Cache
description: Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.
permalink: /spring/leccion104/
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
# Cache

Introduce mecanismos transversales de Spring y alternativas arquitectónicas sin perder el modelo mental.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Cache** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Capacidades avanzadas de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
@Cacheable("tasks")
public TaskDto findById(Long id) { ... }
```



## Relación con el resto de la ruta

AOP, proxies, eventos y cache explican parte del comportamiento transversal de Spring; MVC/WebFlux son modelos web distintos.



## Ejemplo adicional: aplicación práctica

```java
@Cacheable("tareas")
public TareaResponse buscar(Long id) {
    return cargarDesdeRepositorio(id);
}
@CacheEvict(value = "tareas", key = "#id")
public void eliminar(Long id) { /* eliminar en BD */ }
```

La caché necesita una estrategia de invalidación cuando cambian los datos.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Construye un ejemplo pequeño y aislado de **Cache**.
2. Compara su comportamiento con y sin la característica y explica en qué momento interviene Spring.
3. Crea una prueba que verifique el resultado observable y no solo la presencia de una anotación.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Cache** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion103/">← 103 · Scheduling</a>
  <a href="/spring/leccion105/">105 · Clientes HTTP →</a>
</div>
