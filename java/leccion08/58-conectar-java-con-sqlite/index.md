---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Conectar Java con SQLite"
permalink: /java/leccion08/58-conectar-java-con-sqlite/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Conectar Java con SQLite

El driver traduce la URL jdbc:sqlite en una conexión al fichero o a una base en memoria.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/58.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/58.webp' | relative_url }}" alt="Conectar Java con SQLite. El driver traduce la URL jdbc:sqlite en una conexión al fichero o a una base en memoria. Resultado: true" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            System.out.println(!db.isClosed());
        }
    }
}
```

**Resultado esperado**

```text
true
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/59-consultar-con-preparedstatement-y-resultset/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Abre una base en memoria.
2. Comprueba el estado de la conexión.
3. Cierra con try-with-resources.
4. Abre un fichero.
5. Crea dos conexiones sucesivas.
6. Ejecuta una consulta sencilla.
7. Activa claves foráneas.
8. Prueba una URL no admitida.
9. Comprueba cierre tras un error.
10. Construye una fábrica simple de conexiones verificables.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S02-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S02-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Conectar Java con SQLite. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S02-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Conectar Java con SQLite</a>
</div>
