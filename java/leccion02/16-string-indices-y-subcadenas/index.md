---
layout: lesson
route: java
lesson_id: leccion02
lesson_number: "02"
title: "String: índices y subcadenas"
permalink: /java/leccion02/16-string-indices-y-subcadenas/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: referencias-y-contenido
    title: "Referencias y contenido"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# String: índices y subcadenas

charAt devuelve un char. substring incluye el inicio y excluye el final.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/16.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/16.webp' | relative_url }}" alt="String: índices y subcadenas. charAt devuelve un char. substring incluye el inicio y excluye el final. Resultado: o, ol" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        String saludo = "Hola";
        System.out.println(saludo.charAt(1));
        System.out.println(saludo.substring(1, 3));
    }
}
```

**Resultado esperado**

```text
o
ol
```

## Referencias y contenido
{: #referencias-y-contenido }

Dos objetos pueden contener el mismo texto. equals compara el contenido.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/70.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/70.webp' | relative_url }}" alt="Referencias y contenido. Dos objetos pueden contener el mismo texto. equals compara el contenido. Resultado: false, true" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        String a = new String("Hola");
        String b = new String("Hola");
        System.out.println(a == b);
        System.out.println(a.equals(b));
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
  <a href="{{ '/java/leccion02/17-integer-del-texto-al-numero/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Obtén el carácter inicial.
2. Obtén los dos últimos caracteres.
3. Extrae el prefijo de MAT-05.
4. Busca la posición del guion.
5. Compara dos códigos normalizados.
6. Separa código y sufijo numérico.
7. Reemplaza espacios interiores por guiones.
8. Corrige un índice fuera de rango.
9. Corrige una comparación por referencia.
10. Normaliza y descompón un código de inventario.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L02-S10-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L02-S10-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea String: índices y subcadenas. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion02/L02-S10-tarea-01.zip' | relative_url }}">Descargar tarea 1 · String: índices y subcadenas</a>
</div>
