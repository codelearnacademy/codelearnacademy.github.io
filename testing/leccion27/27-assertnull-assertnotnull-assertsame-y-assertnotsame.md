---
layout: lesson
route: testing
lesson_id: leccion27
lesson_file: 27-assertnull-assertnotnull-assertsame-y-assertnotsame
lesson_number: "27"
title: "assertNull, assertNotNull, assertSame y assertNotSame"
description: "Comprueba ausencia de valores e identidad de referencias con JUnit Jupiter."
permalink: /testing/leccion27/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
  - id: referencias
    title: Referencias
---

# assertNull, assertNotNull, assertSame y assertNotSame

## Qué vas a conseguir

- Comprobar referencias nulas y no nulas.
- Distinguir identidad de objetos e igualdad de valores.
- Elegir la aserción que representa el contrato probado.

## Conceptos clave

| Aserción | Comprobación |
|---|---|
| `assertNull(valor)` | La referencia es nula. |
| `assertNotNull(valor)` | La referencia no es nula. |
| `assertSame(esperado, actual)` | Ambas referencias apuntan al mismo objeto. |
| `assertNotSame(inesperado, actual)` | Las referencias no apuntan al mismo objeto. |

Dos objetos distintos pueden tener valores iguales. `assertEquals` comprueba igualdad; `assertSame` comprueba identidad. Utiliza identidad solo cuando compartir o copiar una instancia forme parte del contrato. Que una referencia no sea nula no demuestra que sus campos sean correctos.

## Ejemplo guiado

En un proyecto que ya tenga JUnit Jupiter configurado, guarda este archivo como `src/test/java/ReferenciasTest.java`:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReferenciasTest {
    record Pedido(String codigo) {}

    @Test
    void distingueAusenciaIdentidadEIgualdad() {
        Pedido ausente = null;
        Pedido original = new Pedido("P-01");
        Pedido alias = original;
        Pedido copia = new Pedido("P-01");

        assertNull(ausente);
        assertNotNull(original);
        assertSame(original, alias);
        assertNotSame(original, copia);
        assertEquals(original, copia);
    }
}
```

El `record` proporciona igualdad basada en sus componentes: original y copia tienen el mismo código, pero se crearon como dos instancias. El alias conserva la referencia original. Todas las aserciones del ejemplo deben pasar.

Ejecuta `./mvnw -Dtest=ReferenciasTest test` si el proyecto incluye Maven Wrapper, o `mvn -Dtest=ReferenciasTest test`. Revisa el resultado de Surefire en `target/surefire-reports`.

## Ejercicios propuestos

1. Sustituye `assertNotSame(original, copia)` por `assertSame(original, copia)` y explica el fallo antes de ejecutarlo.
2. Cambia el código de la copia y predice qué aserción dejará de pasar.
3. Añade un método que devuelva `null` cuando no encuentra un pedido y comprueba ese contrato.
4. Restaura las aserciones correctas y ejecuta las pruebas completas.

## Qué debes recordar

Ausencia, identidad e igualdad son comprobaciones distintas. Elige según el comportamiento esperado y evita depender accidentalmente de detalles como la reutilización de cadenas.

## Referencias

- [JUnit Jupiter: Assertions](https://docs.junit.org/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html).

<div class="cla-lesson-nav">
  <a href="{{ '/testing/leccion26/' | relative_url }}">← 26 · assertEquals, assertTrue y assertFalse</a>
  <a href="{{ '/testing/leccion28/' | relative_url }}">28 · Siguiente lección →</a>
</div>
