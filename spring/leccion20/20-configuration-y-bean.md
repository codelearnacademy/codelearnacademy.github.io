---
layout: lesson
route: spring
lesson_id: leccion20
lesson_file: 20-configuration-y-bean
lesson_number: "20"
title: "@Configuration y @Bean"
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion20/
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
# @Configuration y @Bean

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **@Configuration y @Bean** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![@Configuration: Clase de configuración. @Bean: Método que construye el objeto. Contexto: Registra el resultado.]({{ "/assets/images/spring/20-configuration-y-bean.webp" | relative_url }})

## Ejemplo guiado

```java
@Configuration
class AppConfig {
    @Bean
    NotificacionService notificacionService() {
        return new EmailService();
    }
}
```



## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
@Configuration
class RelojConfig {
    @Bean
    Clock reloj() { return Clock.systemUTC(); }
}
```

@Bean permite registrar objetos de clases que no puedes anotar.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **@Configuration y @Bean**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **@Configuration y @Bean** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion19/">← 19 · Beans</a>
  <a href="/spring/leccion21/">21 · Component scanning →</a>
</div>
