---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Comprobar integridad al reabrir"
permalink: /java/leccion08/63-comprobar-integridad-al-reabrir/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Comprobar integridad al reabrir

Una base en fichero conserva los cambios confirmados después de cerrar la conexión.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/63.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/63.webp' | relative_url }}" alt="Comprobar integridad al reabrir. Una base en fichero conserva los cambios confirmados después de cerrar la conexión. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        var f = java.nio.file.Files.createTempFile("aula", ".db");
        String url = "jdbc:sqlite:" + f;
        try { try (var c = java.sql.DriverManager.getConnection(url); var s = c.createStatement()) { preparar(s); } try (var c = java.sql.DriverManager.getConnection(url); var s = c.createStatement(); var r = s.executeQuery("SELECT cantidad FROM material")) { if (r.next()) System.out.println(r.getInt(1)); } } finally { java.nio.file.Files.deleteIfExists(f); }
    }

    static void preparar(java.sql.Statement sql) throws java.sql.SQLException {
        sql.execute("CREATE TABLE material(id INTEGER PRIMARY KEY, cantidad INTEGER NOT NULL)");
        sql.executeUpdate("INSERT INTO material VALUES(1,5)");
    }
}
```

**Resultado esperado**

```text
5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/#practica-guiada' | relative_url }}">Ir a la práctica</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Crea un fichero de base.
2. Guarda un material.
3. Cierra y reabre.
4. Consulta el estado persistido.
5. Registra y recupera un movimiento.
6. Verifica una modificación persistente.
7. Reabre después de rollback.
8. Prueba una base nueva.
9. Comprueba la restricción al reabrir.
10. Valida persistencia e integridad en un escenario reproducible.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S07-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S07-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Comprobar integridad al reabrir. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S07-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Comprobar integridad al reabrir</a>
</div>
