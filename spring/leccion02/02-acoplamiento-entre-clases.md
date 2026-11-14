---
layout: lesson
route: spring
lesson_id: leccion02
lesson_file: 02-acoplamiento-entre-clases
lesson_number: "02"
title: Acoplamiento entre clases
description: Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.
permalink: /spring/leccion02/
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
# Acoplamiento entre clases

Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Acoplamiento entre clases** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Diseño de objetos, acoplamiento e inyección.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![PedidoService crea EmailService directamente. Cambiar de correo a SMS obliga a editar la clase concreta que instancia PedidoService.]({{ "/assets/images/spring/02-acoplamiento-entre-clases.webp" | relative_url }})

## Ejemplo guiado

```java
class PedidoService {
    private final EmailService email = new EmailService();
}
```

`PedidoService` decide qué implementación usar. Cambiar a `SmsService` obliga a modificar la propia clase.



## Relación con el resto de la ruta

Relaciona estas ideas con SOLID y Clean Code: Spring puede facilitar el desacoplamiento, pero no sustituye un buen diseño.



## Ejemplo adicional: aplicación práctica

```java
class PedidoService {
    private final EmailNotificador notificador = new EmailNotificador();

    void confirmar(String codigo) {
        notificador.enviar("Confirmado: " + codigo);
    }
}
```

Cambiar el mecanismo de notificación obliga a modificar esta clase: hay acoplamiento concreto.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Identifica en el ejemplo de **Acoplamiento entre clases** qué clase decide la creación o selección de dependencias.
2. Modifica el ejemplo para recibir una dependencia desde fuera; compara las dos implementaciones sin introducir Spring si no es necesario.
3. Escribe una prueba unitaria que utilice un colaborador falso y razona qué cambió en el acoplamiento.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Acoplamiento entre clases** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion01/">← 01 · De Java tradicional a aplicaciones empresariales</a>
  <a href="/spring/leccion03/">03 · Inversión de Control →</a>
</div>
