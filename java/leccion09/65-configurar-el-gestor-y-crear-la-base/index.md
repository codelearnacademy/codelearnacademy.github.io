---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
title: "Configurar el gestor y crear la base"
permalink: /java/leccion09/65-configurar-el-gestor-y-crear-la-base/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Configurar el gestor y crear la base

Añade la dependencia del proyecto ObjectDB y crea una base embebida nueva.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar proyecto ObjectDB</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/65.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/65.webp' | relative_url }}" alt="Configurar el gestor y crear la base. Añade la dependencia del proyecto ObjectDB y crea una base embebida nueva. Resultado: Se crea el préstamo P1 en prestamos.odb" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        aula.Prestamos.main(new String[]{"prestamos.odb", "crear"});
    }
}
```

**Resultado esperado**

```text
Se crea el préstamo P1 en prestamos.odb
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion09/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion09/66-guardar-objetos-relacionados/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Configura el POM.
2. Crea una base nueva.
3. Abre el gestor.
4. Cierra los recursos.
5. Persiste material.
6. Consulta por identidad.
7. Reabre el fichero.
8. Gestiona un fichero inexistente al iniciar.
9. Comprueba ruta y extensión de base.
10. Documenta un arranque reproducible con carga de datos.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L09-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L09-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Configurar el gestor y crear la base. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion09/L09-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Configurar el gestor y crear la base</a>
</div>
