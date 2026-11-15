---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Métodos, parámetros y retorno"
permalink: /java/leccion02/14-metodos-parametros-y-retorno/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Métodos, parámetros y retorno

Extrae el cálculo a un método, llama con 5 unidades y muestra el valor devuelto.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/14.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/14.webp' | relative_url }}" alt="Métodos, parámetros y retorno. Extrae el cálculo a un método, llama con 5 unidades y muestra el valor devuelto. Resultado: 1250" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(total(5));
    }

    static int total(int cantidad) { return cantidad * 250; }
}
```

**Resultado esperado**

```text
1250
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/15-clases-envolventes/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Extrae un método de suma.
2. Devuelve el total en céntimos.
3. Crea un método de aviso sin retorno.
4. Pasa cantidad y precio como argumentos.
5. Reutiliza el cálculo con dos materiales.
6. Llama a un método desde otro.
7. Devuelve la diferencia entre coste y presupuesto.
8. Corrige un retorno ausente.
9. Evita intercambiar los argumentos.
10. Compón un cálculo modular de pedido y envío.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S08-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S08-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Métodos, parámetros y retorno. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S08-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Métodos, parámetros y retorno</a>
</div>
