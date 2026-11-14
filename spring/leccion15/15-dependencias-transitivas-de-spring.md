---
layout: lesson
route: spring
lesson_id: leccion15
lesson_file: 15-dependencias-transitivas-de-spring
lesson_number: "15"
title: Dependencias transitivas de Spring
description: Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.
permalink: /spring/leccion15/
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
# Dependencias transitivas de Spring

Relaciona Maven con Spring distinguiendo gestión de bibliotecas de inyección de objetos.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Dependencias transitivas de Spring** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Maven y gestión de dependencias.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Dependencia directa: Declarada en el POM. Transitivas: Llegan con ella. Verificar: mvn dependency:tree.]({{ "/assets/images/spring/15-dependencias-transitivas-de-spring.webp" | relative_url }})

## Ejemplo guiado

```bash
mvn dependency:tree
```

Localiza `spring-context` y sigue las dependencias de otros módulos Spring que aparecen debajo.



## Relación con el resto de la ruta

Maven resuelve bibliotecas. Spring gestiona objetos. El árbol Maven explica qué código existe en classpath; ApplicationContext explica qué objetos existen en ejecución.



## Ejemplo adicional: aplicación práctica

```bash
./mvnw dependency:tree -Dincludes=org.springframework
./mvnw dependency:analyze
```

Distingue dependencias directas, transitivas y aquellas no utilizadas.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Dependencias transitivas de Spring** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Dependencias transitivas de Spring** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion14/">← 14 · Maven no hace Dependency Injection</a>
  <a href="/spring/leccion16/">16 · Spring Boot Starter Parent y BOM →</a>
</div>
