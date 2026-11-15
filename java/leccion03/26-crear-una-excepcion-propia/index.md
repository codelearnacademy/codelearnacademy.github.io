---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Crear una excepción propia"
permalink: /java/leccion03/26-crear-una-excepcion-propia/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Crear una excepción propia

Una clase de excepción puede expresar una regla del inventario y llevar un mensaje.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/26.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/26.webp' | relative_url }}" alt="Crear una excepción propia. Una clase de excepción puede expresar una regla del inventario y llevar un mensaje. Resultado: Cantidad negativa" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try { validar(-1); } catch (CantidadInvalida e) { System.out.println(e.getMessage()); }
    }

    static class CantidadInvalida extends IllegalArgumentException { CantidadInvalida() { super("Cantidad negativa"); } }
    static void validar(int n) { if (n < 0) throw new CantidadInvalida(); }
}
```

**Resultado esperado**

```text
Cantidad negativa
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/27-depurar-con-puntos-de-interrupcion/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea una excepción de cantidad.
2. Incluye el valor inválido en el mensaje.
3. Lanza la excepción para un negativo.
4. Captúrala desde el llamador.
5. Define una excepción de stock insuficiente.
6. Distingue ambas excepciones en un menú.
7. Conserva el estado ante una retirada rechazada.
8. Comprueba que un error válido no pasa por el catch.
9. Prueba el límite de retirar todo el stock.
10. Valida una secuencia y acumula motivos de rechazo.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Crear una excepción propia. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Crear una excepción propia</a>
</div>
