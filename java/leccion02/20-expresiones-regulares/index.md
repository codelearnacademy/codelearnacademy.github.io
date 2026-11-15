---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "Expresiones regulares"
permalink: /java/leccion02/20-expresiones-regulares/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: matches-frente-a-find
    title: "matches frente a find"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Expresiones regulares

Comprueba si el código completo cumple el patrón MAT seguido de dos cifras.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/20.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/20.webp' | relative_url }}" alt="Expresiones regulares. Comprueba si el código completo cumple el patrón MAT seguido de dos cifras. Resultado: true, false" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("MAT-05".matches("MAT-[0-9]{2}"));
        System.out.println("MAT-5".matches("MAT-[0-9]{2}"));
    }
}
```

**Resultado esperado**

```text
true
false
```

## matches frente a find
{: #matches-frente-a-find }

matches exige que todo el texto encaje. find busca una coincidencia dentro.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/72.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/72.webp' | relative_url }}" alt="matches frente a find. matches exige que todo el texto encaje. find busca una coincidencia dentro. Resultado: false, true" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var p = java.util.regex.Pattern.compile("MAT-[0-9]{2}");
        var texto = "Código MAT-05";
        System.out.println(p.matcher(texto).matches());
        System.out.println(p.matcher(texto).find());
    }
}
```

**Resultado esperado**

```text
false
true
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion02/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion02/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Valida MAT y dos cifras.
2. Rechaza un código corto.
3. Acepta dos prefijos autorizados.
4. Extrae un código dentro de texto.
5. Cuenta las coincidencias en una descripción.
6. Separa prefijo y número en grupos.
7. Normaliza entrada antes de validar.
8. Corrige un escape de barra en una cadena Java.
9. Distingue matches de find en el mismo texto.
10. Valida y resume los códigos presentes en un inventario.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S14-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S14-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Expresiones regulares. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S14-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Expresiones regulares</a>
</div>
