---
layout: lesson
route: java
lesson_id: leccion03
lesson_number: "03"
title: "Depurar con puntos de interrupción"
permalink: /java/leccion03/27-depurar-con-puntos-de-interrupcion/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: indice-y-acumulador
    title: "Índice y acumulador"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Depurar con puntos de interrupción

Coloca un breakpoint en la suma, observa i y total, y cambia el límite para incluir la tercera unidad.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/27.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/27.webp' | relative_url }}" alt="Depurar con puntos de interrupción. Coloca un breakpoint en la suma, observa i y total, y cambia el límite para incluir la tercera unidad. Resultado: 500" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int total = 0;
        for (int i = 1; i < 3; i++) {
            total += 250;
        }
        System.out.println(total);
    }
}
```

**Resultado esperado**

```text
500
```

## Índice y acumulador
{: #indice-y-acumulador }

Con el límite corregido se suma también la tercera unidad. Coloca el punto de interrupción después de la suma.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/74.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/74.webp' | relative_url }}" alt="Índice y acumulador. Con el límite corregido se suma también la tercera unidad. Coloca el punto de interrupción después de la suma. Resultado: 1: 250, 2: 500, 3: 750" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        int total = 0;
        for (int i = 1; i <= 3; i++) { total += 250; System.out.println(i + ": " + total); }
    }
}
```

**Resultado esperado**

```text
1: 250
2: 500
3: 750
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion03/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion03/28-verificar-invariantes-con-assert/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inspecciona el índice inicial.
2. Anota el acumulador en cada vuelta.
3. Predice el valor al salir del bucle.
4. Corrige el límite estricto.
5. Inspecciona una condición antes de entrar.
6. Compara la ejecución con cero y una unidad.
7. Depura una suma que reinicia el acumulador.
8. Localiza un índice fuera de rango.
9. Comprueba la corrección en tres entradas.
10. Entrega traza antes y después de reparar un total erróneo.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L03-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L03-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Depurar con puntos de interrupción. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion03/L03-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Depurar con puntos de interrupción</a>
</div>
