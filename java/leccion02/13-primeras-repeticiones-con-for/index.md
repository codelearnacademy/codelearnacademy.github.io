---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Primeras repeticiones con for"
permalink: /java/leccion02/13-primeras-repeticiones-con-for/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Primeras repeticiones con for

Usa un contador explícito cuando conoces el número de iteraciones.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/13.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/13.webp' | relative_url }}" alt="Primeras repeticiones con for. Usa un contador explícito cuando conoces el número de iteraciones. Resultado: 1, 2, 3" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 3; i++) System.out.println(i);
    }
}
```

**Resultado esperado**

```text
1
2
3
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/14-metodos-parametros-y-retorno/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Cuenta de uno a cinco.
2. Cuenta hacia atrás.
3. Muestra solo múltiplos de dos.
4. Suma los primeros n enteros.
5. Imprime una tabla de multiplicar.
6. Acumula precios iguales en céntimos.
7. Cuenta cantidades por debajo de un umbral.
8. Corrige un límite que omite el último número.
9. Comprueba cero iteraciones.
10. Genera una secuencia de movimientos con total y contador.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Primeras repeticiones con for. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Primeras repeticiones con for</a>
</div>
