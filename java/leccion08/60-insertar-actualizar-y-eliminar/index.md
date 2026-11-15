---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Insertar, actualizar y eliminar"
permalink: /java/leccion08/60-insertar-actualizar-y-eliminar/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Insertar, actualizar y eliminar

Comprueba la cantidad de filas afectadas en cada escritura.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/60.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/60.webp' | relative_url }}" alt="Insertar, actualizar y eliminar. Comprueba la cantidad de filas afectadas en cada escritura. Resultado: 1, 1, 1" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            preparar(sql);
            System.out.println(sql.executeUpdate("INSERT INTO material VALUES (2,3)"));
            System.out.println(sql.executeUpdate("UPDATE material SET cantidad=4 WHERE id=2"));
            System.out.println(sql.executeUpdate("DELETE FROM material WHERE id=2"));
        }
    }

    static void preparar(java.sql.Statement sql) throws java.sql.SQLException {
        sql.execute("CREATE TABLE material(id INTEGER PRIMARY KEY, cantidad INTEGER NOT NULL)");
        sql.executeUpdate("INSERT INTO material VALUES(1,5)");
    }
}
```

**Resultado esperado**

```text
1
1
1
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/61-encapsular-el-acceso-en-un-dao/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inserta una fila.
2. Actualiza una cantidad.
3. Borra una fila.
4. Comprueba filas afectadas.
5. Añade parámetros a cada escritura.
6. Lista tras modificar.
7. Reutiliza un método de escritura.
8. Prueba actualizar ID ausente.
9. Comprueba una restricción al borrar.
10. Implementa CRUD con resultados verificables.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S04-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S04-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Insertar, actualizar y eliminar. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S04-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Insertar, actualizar y eliminar</a>
</div>
