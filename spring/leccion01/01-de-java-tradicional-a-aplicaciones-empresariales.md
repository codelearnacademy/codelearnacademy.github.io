---
layout: lesson
route: spring
lesson_id: leccion01
lesson_file: 01-de-java-tradicional-a-aplicaciones-empresariales
lesson_number: "01"
title: De Java tradicional a aplicaciones empresariales
description: Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.
permalink: /spring/leccion01/
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
# De Java tradicional a aplicaciones empresariales

Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **De Java tradicional a aplicaciones empresariales** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Diseño de objetos, acoplamiento e inyección.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Java tradicional: Una clase crea y ejecuta. Aplicación empresarial: Capas y colaboradores.]({{ "/assets/images/spring/01-de-java-tradicional-a-aplicaciones-empresariales.webp" | relative_url }})

## Ejemplo guiado

Partimos de código Java que crea manualmente todos sus colaboradores:

```java
var repository = new PedidoRepositoryJdbc();
var email = new EmailService();
var service = new PedidoService(repository, email);
var controller = new PedidoController(service);
```

Añade una segunda implementación de `EmailService` y observa cuántos lugares debes modificar.



## Relación con el resto de la ruta

Relaciona estas ideas con SOLID y Clean Code: Spring puede facilitar el desacoplamiento, pero no sustituye un buen diseño.



## Ejemplo adicional: aplicación práctica

```java
public class Aplicacion {
    public static void main(String[] args) {
        PedidoService servicio = new PedidoService(new EmailNotificador());
        servicio.confirmar("PED-001");
    }
}
```

Observa que la aplicación ensambla las dependencias. Más adelante lo hará el contenedor Spring.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Identifica en el ejemplo de **De Java tradicional a aplicaciones empresariales** qué clase decide la creación o selección de dependencias.
2. Modifica el ejemplo para recibir una dependencia desde fuera; compara las dos implementaciones sin introducir Spring si no es necesario.
3. Escribe una prueba unitaria que utilice un colaborador falso y razona qué cambió en el acoplamiento.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **De Java tradicional a aplicaciones empresariales** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <span></span>
  <a href="/spring/leccion02/">02 · Acoplamiento entre clases →</a>
</div>
