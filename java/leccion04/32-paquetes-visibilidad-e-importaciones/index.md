---
layout: lesson
route: java
lesson_id: leccion04
lesson_number: "04"
title: "Paquetes, visibilidad e importaciones"
permalink: /java/leccion04/32-paquetes-visibilidad-e-importaciones/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Paquetes, visibilidad e importaciones

Importa tipos por su nombre de paquete. Los miembros privados se usan desde su propia clase.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/32.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/32.webp' | relative_url }}" alt="Paquetes, visibilidad e importaciones. Importa tipos por su nombre de paquete. Los miembros privados se usan desde su propia clase. Resultado: MAT-01" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(List.of("MAT-01").getFirst());
    }
}
```

**Resultado esperado**

```text
MAT-01
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion04/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion04/33-metodos-estaticos-y-de-instancia/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Declara un paquete.
2. Importa un tipo.
3. Usa una clase pública.
4. Crea un auxiliar de paquete.
5. Separa modelo y cliente.
6. Encapsula la validación.
7. Reutiliza el modelo desde otro paquete.
8. Explica un acceso privado inválido.
9. Corrige un import ambiguo.
10. Organiza un pequeño inventario en dos paquetes.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L04-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L04-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Paquetes, visibilidad e importaciones. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion04/L04-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Paquetes, visibilidad e importaciones</a>
</div>
