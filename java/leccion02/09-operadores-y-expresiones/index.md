---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Operadores y expresiones"
permalink: /java/leccion02/09-operadores-y-expresiones/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Operadores y expresiones

Multiplica antes de sumar el gasto fijo. Cambia los paréntesis y predice el efecto.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/09.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/09.webp' | relative_url }}" alt="Operadores y expresiones. Multiplica antes de sumar el gasto fijo. Cambia los paréntesis y predice el efecto. Resultado: 1350" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(5 * 250 + 100);
    }
}
```

**Resultado esperado**

```text
1350
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/10-conversiones-de-tipos/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Suma entradas y resta salidas.
2. Calcula cajas completas.
3. Calcula unidades sobrantes.
4. Aplica un cargo fijo al importe.
5. Compara dos cantidades con un boolean.
6. Combina dos condiciones de disponibilidad.
7. Compara resultados con y sin paréntesis.
8. Explica y corrige una división por cero.
9. Corrige una concatenación que aparenta sumar.
10. Descompón un pedido en cajas y calcula su coste final.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Operadores y expresiones. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Operadores y expresiones</a>
</div>
