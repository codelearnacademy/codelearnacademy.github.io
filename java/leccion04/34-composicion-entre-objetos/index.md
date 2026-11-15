---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Composición entre objetos"
permalink: /java/leccion04/34-composicion-entre-objetos/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Composición entre objetos

Una línea de inventario contiene un material como colaborador.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/34.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/34.webp' | relative_url }}" alt="Composición entre objetos. Una línea de inventario contiene un material como colaborador. Resultado: MAT-01" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var linea = new Linea(new Material("MAT-01"), 5);
        System.out.println(linea.material().codigo());
    }

    record Material(String codigo) {}
    record Linea(Material material, int unidades) {}
}
```

**Resultado esperado**

```text
MAT-01
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/35-crear-y-consumir-un-jar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea un material y una línea.
2. Consulta el código desde la línea.
3. Añade cantidad.
4. Calcula el importe de una línea.
5. Compón varias líneas en un pedido.
6. Suma el total.
7. Cuenta líneas agotadas.
8. Rechaza una línea inválida.
9. Prueba un pedido vacío.
10. Construye el resumen de un pedido compuesto.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Composición entre objetos. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Composición entre objetos</a>
</div>
