---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Encapsular el acceso en un DAO"
permalink: /java/leccion08/61-encapsular-el-acceso-en-un-dao/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Encapsular el acceso en un DAO

Coloca el SQL en una clase de acceso y deja que el cliente llame al método de dominio.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/61.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/61.webp' | relative_url }}" alt="Encapsular el acceso en un DAO. Coloca el SQL en una clase de acceso y deja que el cliente llame al método de dominio. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            preparar(sql);
            System.out.println(new MaterialDao(db).cantidad());
        }
    }

    record MaterialDao(java.sql.Connection db) { int cantidad() throws java.sql.SQLException { try (var q = db.prepareStatement("SELECT cantidad FROM material WHERE id=1"); var r = q.executeQuery()) { if (!r.next()) throw new java.sql.SQLException("Material ausente"); return r.getInt(1); } } }
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
  <a href="{{ '/java/leccion08/62-confirmar-y-revertir-transacciones/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Define el contrato del DAO.
2. Implementa buscar.
3. Devuelve ausencia.
4. Implementa listar.
5. Añade crear.
6. Añade modificar y borrar.
7. Separa cliente y SQL.
8. Trata un resultado inexistente.
9. Comprueba el cierre de recursos.
10. Usa el DAO desde un cliente que registra y consulta materiales.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S05-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S05-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Encapsular el acceso en un DAO. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S05-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Encapsular el acceso en un DAO</a>
</div>
