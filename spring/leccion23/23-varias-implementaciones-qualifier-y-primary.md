---
layout: lesson
route: spring
lesson_id: leccion23
lesson_file: 23-varias-implementaciones-qualifier-y-primary
lesson_number: "23"
title: "Varias implementaciones: @Qualifier y @Primary"
description: Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.
permalink: /spring/leccion23/
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
# Varias implementaciones: @Qualifier y @Primary

Trabaja directamente con el contenedor IoC de Spring para entender beans, configuración e inyección.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Varias implementaciones: @Qualifier y @Primary** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Contenedor IoC y beans.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Dos beans: Implementan el mismo contrato. @Qualifier: Selecciona explícitamente. @Primary: Marca el candidato preferido.]({{ "/assets/images/spring/23-varias-implementaciones-qualifier-y-primary.webp" | relative_url }})

## Ejemplo guiado

```java
interface NotificacionService {}

@Service("email")
class EmailService implements NotificacionService {}

@Service("sms")
class SmsService implements NotificacionService {}
```

Resuelve la ambigüedad con `@Qualifier` o `@Primary`.



## Relación con el resto de la ruta

Estos conceptos existen aunque no uses Spring Boot. Entenderlos evita tratar las anotaciones de Boot como magia.



## Ejemplo adicional: aplicación práctica

```java
@Service("email") class EmailNotificador implements Notificador { /* ... */ }
@Service("sms") class SmsNotificador implements Notificador { /* ... */ }
@Service
class AvisosService {
    AvisosService(@Qualifier("email") Notificador notificador) { /* ... */ }
}
```

Cuando hay más de una implementación debes definir cuál inyectar.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Prepara un bean que permita observar el comportamiento de **Varias implementaciones: @Qualifier y @Primary**.
2. Inyecta el bean mediante constructor en una segunda clase y comprueba que el contexto resuelve sus dependencias.
3. Escribe una prueba que obtenga el bean del contexto y verifique la configuración sin arrancar un servidor HTTP.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Varias implementaciones: @Qualifier y @Primary** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion22/">← 22 · Constructor injection</a>
  <a href="/spring/leccion24/">24 · Scopes de los beans →</a>
</div>
