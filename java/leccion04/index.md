---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: Organización de clases
search_title: Lección 04 - Organización de clases
search_description: Organizarás el código en paquetes, clases y responsabilidades claras.
description: Organizarás clases Java con paquetes, visibilidad y composición.
lessons:
  - id: paquetes
    title: Paquetes y visibilidad
  - id: encapsulacion
    title: Encapsulación
  - id: composicion
    title: Composición y reutilización
  - id: ejercicios
    title: Ejercicios
permalink: /java/leccion04/
---

## Paquetes y visibilidad

Los paquetes agrupan clases relacionadas y evitan colisiones de nombres. La estructura de carpetas debe reflejar el `package`:

```java
package es.codelearn.pedidos;

public class Pedido {
  private final String identificador;

  public Pedido(String identificador) {
    this.identificador = identificador;
  }
}
```

`public` expone un tipo o miembro; `private` lo limita a su clase; `protected` permite acceso a subclases y al paquete; sin modificador se limita al paquete.

## Encapsulación

Una clase debe proteger sus invariantes y ofrecer operaciones significativas. Es preferible `pedido.cancelar()` a exponer un campo que cualquiera pueda cambiar.

```java
public void cancelar() {
  if (estado == Estado.ENVIADO) throw new IllegalStateException("Pedido enviado");
  estado = Estado.CANCELADO;
}
```

## Composición y reutilización

La composición modela relaciones “tiene un”. Permite cambiar una pieza sin crear jerarquías artificiales.

```java
public class Coche {
  private final Motor motor;

  public Coche(Motor motor) {
    this.motor = motor;
  }

  public void arrancar() { motor.encender(); }
}
```

Organiza cada clase alrededor de una responsabilidad y separa dominio, entrada/salida y presentación. Esta decisión facilita las pruebas y la evolución del proyecto.

## Ejercicios

1. Crea paquetes `domain`, `service` y `app` para una agenda.
2. Protege los datos de `Contacto` con visibilidad privada.
3. Implementa una clase `Motor` y úsala mediante composición en `Coche`.
4. Mueve una clase a otro paquete y corrige imports y visibilidad.
5. Revisa una clase grande y divídela por responsabilidades.
