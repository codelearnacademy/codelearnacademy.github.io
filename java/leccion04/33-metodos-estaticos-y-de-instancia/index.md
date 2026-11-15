---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Métodos estáticos y de instancia"
permalink: /java/leccion04/33-metodos-estaticos-y-de-instancia/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Métodos estáticos y de instancia

Invoca el método estático en la clase y el de instancia sobre un objeto concreto.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/33.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/33.webp' | relative_url }}" alt="Métodos estáticos y de instancia. Invoca el método estático en la clase y el de instancia sobre un objeto concreto. Resultado: 1" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var texto = String.valueOf(5);
        System.out.println(texto.length());
    }
}
```

**Resultado esperado**

```text
1
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/34-composicion-entre-objetos/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Usa un método estático.
2. Llama a un método de instancia.
3. Añade un contador de instancias.
4. Extrae una validación común.
5. Calcula totales de dos objetos.
6. Reutiliza una utilidad desde otro archivo.
7. Distingue estado compartido e individual.
8. Corrige una llamada estática inválida.
9. Prueba dos instancias distintas.
10. Construye un cliente con ambos tipos de métodos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Métodos estáticos y de instancia. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Métodos estáticos y de instancia</a>
</div>
