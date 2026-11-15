---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Recorrer un array"
permalink: /java/leccion03/23-recorrer-un-array/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: dossier-de-practica-10-ejercicios
    title: "Dossier de práctica · 10 ejercicios"
---

# Recorrer un array

Los índices válidos van de 0 a length menos uno. Usa for-each para sumar y un índice para localizar el agotado.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/23.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/23.webp' | relative_url }}" alt="Recorrer un array. Los índices válidos van de 0 a length menos uno. Usa for-each para sumar y un índice para localizar el agotado. Resultado: 8, 1" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int[] existencias = {5, 0, 3};
        int suma = 0;
        for (int valor : existencias) suma += valor;
        System.out.println(suma);
        for (int i = 0; i < existencias.length; i++) if (existencias[i] == 0) System.out.println(i);
    }
}
```

**Resultado esperado**

```text
8
1
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/24-sentencias-break-y-continue/' | relative_url }}">Siguiente concepto →</a>
</div>


## Dossier de práctica · 10 ejercicios
{: #dossier-de-practica-10-ejercicios }

Descarga el microproyecto, abre el `pom.xml` en el IDE y ejecuta `mvn test`.
Documenta con Javadoc la responsabilidad de la clase y el contrato de cada metodo implementado. Incluye parametros, retorno y excepciones cuando proceda. Ejecuta `mvn javadoc:javadoc` para generar la documentacion.

El README contiene los contratos de los diez ejercicios y las instrucciones de entrega.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Recorrer un array. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Recorrer un array</a>
</div>
