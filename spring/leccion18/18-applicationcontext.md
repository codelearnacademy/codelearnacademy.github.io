---
layout: lesson
route: spring
lesson_id: leccion18
lesson_file: 18-applicationcontext
lesson_number: "18"
title: ApplicationContext
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion18/
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
# ApplicationContext

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **ApplicationContext** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);

PedidoService service = context.getBean(PedidoService.class);
```



## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
try (AnnotationConfigApplicationContext contexto =
         new AnnotationConfigApplicationContext(Configuracion.class)) {
    Clock reloj = contexto.getBean(Clock.class);
    System.out.println(reloj.instant());
}
```

ApplicationContext crea, configura y proporciona beans.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **ApplicationContext**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **ApplicationContext** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion17/">← 17 · Starters de Spring Boot</a>
  <a href="/spring/leccion19/">19 · Beans →</a>
</div>
