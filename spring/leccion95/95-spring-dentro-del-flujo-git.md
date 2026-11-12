---
layout: lesson
route: spring
lesson_id: leccion95
lesson_file: 95-spring-dentro-del-flujo-git
lesson_number: "95"
title: Spring dentro del flujo Git
description: Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.
permalink: /spring/leccion95/
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
# Spring dentro del flujo Git

Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Spring dentro del flujo Git** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Git, integración y despliegue continuos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```text
feature branch
 ↓
cambio
 ↓
./mvnw clean verify
 ↓
commit
 ↓
push / PR
```



## Relación con el resto de la ruta

Git conserva el cambio; CI lo verifica; un registry conserva la imagen; CD despliega una versión inmutable.



## Ejemplo adicional: aplicación práctica

```bash
git checkout -b feature/listado-tareas
git add src pom.xml
git commit -m "Añade listado de tareas"
```

Un cambio de funcionalidad debe tener su prueba y revisión.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Incorpora **Spring dentro del flujo Git** a un flujo de construcción automatizado.
2. Ejecuta las pruebas y comprueba que un fallo provoca un estado de pipeline fallido.
3. Documenta cómo identificar la versión desplegada y cómo volver a una versión anterior.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Spring dentro del flujo Git** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion94/">← 94 · Spring Boot y Cloud Native Buildpacks</a>
  <a href="/spring/leccion96/">96 · CI para Spring Boot →</a>
</div>
