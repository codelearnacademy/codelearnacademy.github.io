---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Tablas, claves y restricciones"
permalink: /java/leccion08/57-tablas-claves-y-restricciones/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Tablas, claves y restricciones

La clave identifica cada material y CHECK impide guardar existencias negativas.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/57.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/57.webp' | relative_url }}" alt="Tablas, claves y restricciones. La clave identifica cada material y CHECK impide guardar existencias negativas. Resultado: Tabla creada" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            sql.execute("CREATE TABLE material(id INTEGER PRIMARY KEY, cantidad INTEGER NOT NULL CHECK(cantidad >= 0))");
            System.out.println("Tabla creada");
        }
    }
}
```

**Resultado esperado**

```text
Tabla creada
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/58-conectar-java-con-sqlite/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea la tabla.
2. Añade clave primaria.
3. Añade restricción CHECK.
4. Inserta un registro válido.
5. Crea tabla de movimientos.
6. Declara la referencia al material.
7. Comprueba existencia de la tabla.
8. Rechaza clave repetida.
9. Rechaza cantidad negativa.
10. Prepara un esquema que detecte datos inconsistentes.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S01-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S01-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Tablas, claves y restricciones. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S01-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Tablas, claves y restricciones</a>
</div>
