---
layout: lesson
route: spring
lesson_id: leccion28
lesson_file: 28-springbootapplication
lesson_number: "28"
title: "@SpringBootApplication"
description: Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.
permalink: /spring/leccion28/
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
# @SpringBootApplication

Comprende cómo Spring Boot reduce configuración mediante starters, auto-configuración y convenciones.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **@SpringBootApplication** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Primer proyecto Spring Boot y configuración.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```



## Relación con el resto de la ruta

Boot aplica convenciones y auto-configuración sobre Spring Framework; Maven o Gradle siguen siendo responsables del build.



## Ejemplo adicional: aplicación práctica

```java
@SpringBootApplication
public class TareasApplication {
    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }
}
```

La anotación agrupa configuración, auto-configuración y escaneo de componentes.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Aplica **@SpringBootApplication** en una aplicación Spring Boot mínima con Maven.
2. Ejecuta la aplicación con `./mvnw spring-boot:run` y observa qué configuración está activa.
3. Modifica un valor de configuración y registra cómo cambia el comportamiento sin editar las clases de negocio.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **@SpringBootApplication** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion27/">← 27 · Crear el primer proyecto Spring Boot</a>
  <a href="/spring/leccion29/">29 · Auto-configuración →</a>
</div>
