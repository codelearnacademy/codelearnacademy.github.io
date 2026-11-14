---
layout: lesson
route: spring
lesson_id: leccion06
lesson_file: 06-que-es-spring-framework
lesson_number: "06"
title: Qué es Spring Framework
description: Sitúa Spring Framework y Spring Boot dentro del ecosistema y distingue sus responsabilidades.
permalink: /spring/leccion06/
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
# Qué es Spring Framework

Sitúa Spring Framework y Spring Boot dentro del ecosistema y distingue sus responsabilidades.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Qué es Spring Framework** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Fundamentos y versiones de Spring.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Objetos Java: Clases de la aplicación. Spring Framework: Gestiona componentes e infraestructura.]({{ "/assets/images/spring/06-que-es-spring-framework.webp" | relative_url }})

## Ejemplo guiado

Crea un mapa del Framework:

```text
Spring Core / Beans / Context
Spring MVC
Transactions
Data access
Validation
Testing
AOP
```

Después indica cuáles usarías en una API REST sencilla.



## Relación con el resto de la ruta

Spring Boot se apoya en Spring Framework. Spring Data, Security y otros proyectos amplían responsabilidades concretas del ecosistema.



## Ejemplo adicional: aplicación práctica

```java
@Configuration
class Configuracion {
    @Bean
    Clock reloj() { return Clock.systemUTC(); }
}
```

Spring gestiona objetos y sus dependencias mediante su contenedor.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Localiza en el `pom.xml` la dependencia o configuración relacionada con **Qué es Spring Framework** y explica para qué sirve.
2. Ejecuta `mvn dependency:tree` y señala qué artefactos llegan de forma transitiva.
3. Describe el comportamiento esperado al eliminar la dependencia o cambiar la versión gestionada; compruébalo en un proyecto de laboratorio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Qué es Spring Framework** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion05/">← 05 · IoC, DI y DIP no son lo mismo</a>
  <a href="/spring/leccion07/">07 · El ecosistema Spring →</a>
</div>
