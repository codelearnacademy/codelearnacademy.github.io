---
layout: lesson
route: spring
lesson_id: leccion04
lesson_file: 04-inyeccion-de-dependencias
lesson_number: "04"
title: Inyección de dependencias
description: Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.
permalink: /spring/leccion04/
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
# Inyección de dependencias

Comprende el problema de acoplamiento, creación de objetos e inversión de control antes de utilizar Spring.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Inyección de dependencias** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Diseño de objetos, acoplamiento e inyección.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Ejemplo guiado

```java
@Service
class PedidoService {
    private final NotificacionService notificacion;

    PedidoService(NotificacionService notificacion) {
        this.notificacion = notificacion;
    }
}
```

La clase declara lo que necesita, pero no crea la implementación.



## Relación con el resto de la ruta

Relaciona estas ideas con SOLID y Clean Code: Spring puede facilitar el desacoplamiento, pero no sustituye un buen diseño.



## Ejemplo adicional: aplicación práctica

```java
@Component
class EmailNotificador implements Notificador {
    public void enviar(String mensaje) { /* enviar correo */ }
}
@Service
class PedidoService {
    private final Notificador notificador;
    PedidoService(Notificador notificador) { this.notificador = notificador; }
}
```

La inyección por constructor hace explícitas las dependencias necesarias.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Identifica en el ejemplo de **Inyección de dependencias** qué clase decide la creación o selección de dependencias.
2. Modifica el ejemplo para recibir una dependencia desde fuera; compara las dos implementaciones sin introducir Spring si no es necesario.
3. Escribe una prueba unitaria que utilice un colaborador falso y razona qué cambió en el acoplamiento.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Inyección de dependencias** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion03/">← 03 · Inversión de Control</a>
  <a href="/spring/leccion05/">05 · IoC, DI y DIP no son lo mismo →</a>
</div>
