---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Verificar invariantes con assert"
permalink: /java/leccion03/28-verificar-invariantes-con-assert/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Verificar invariantes con assert

Activa las aserciones con java -ea Main.java. Cambia total a 500 y observa AssertionError.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/28.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/28.webp' | relative_url }}" alt="Verificar invariantes con assert. Activa las aserciones con java -ea Main.java. Cambia total a 500 y observa AssertionError. Resultado: 750" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int total = 750;
        assert total == 3 * 250 : "Total incoherente";
        System.out.println(total);
    }
}
```

**Resultado esperado**

```text
750
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Activa las aserciones.
2. Comprueba una suma coherente.
3. Provoca AssertionError con un total incorrecto.
4. Comprueba conservación de stock tras retirar.
5. Verifica que el contador no supera la longitud.
6. Combina validación de entrada y aserción interna.
7. Añade un mensaje que muestre el valor observado.
8. Detecta una aserción que modifica el estado.
9. Compara ejecución con y sin -ea.
10. Verifica dos invariantes de una jornada de inventario.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S08-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S08-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Verificar invariantes con assert. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S08-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Verificar invariantes con assert</a>
</div>
