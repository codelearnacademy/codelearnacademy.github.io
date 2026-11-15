---
layout: lesson
route: java
lesson_id: leccion06
lesson_number: "06"
title: "Validar códigos con Pattern"
permalink: /java/leccion06/47-validar-codigos-con-pattern/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Validar códigos con Pattern

Compila el patrón una vez y comprueba cada código con un Matcher.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/47.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/47.webp' | relative_url }}" alt="Validar códigos con Pattern. Compila el patrón una vez y comprueba cada código con un Matcher. Resultado: true, false" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var patron = java.util.regex.Pattern.compile("MAT-[0-9]{2}");
        for (String codigo : java.util.List.of("MAT-02", "M-02")) System.out.println(patron.matcher(codigo).matches());
    }
}
```

**Resultado esperado**

```text
true
false
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion06/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion06/48-leer-y-modificar-json-y-xml/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Compila un patrón.
2. Valida dos códigos.
3. Extrae una coincidencia.
4. Cuenta varias coincidencias.
5. Usa un grupo para el número.
6. Reutiliza Pattern en un bucle.
7. Normaliza antes de validar.
8. Distingue matches y find.
9. Prueba un código con espacios.
10. Valida un lote y separa códigos correctos de rechazados.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L06-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L06-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Validar códigos con Pattern. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion06/L06-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Validar códigos con Pattern</a>
</div>
