---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Consultar con PreparedStatement y ResultSet"
permalink: /java/leccion08/59-consultar-con-preparedstatement-y-resultset/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Consultar con PreparedStatement y ResultSet

Los parámetros comienzan en 1. next sitúa el cursor en una fila si la consulta encuentra el ID.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/59.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/59.webp' | relative_url }}" alt="Consultar con PreparedStatement y ResultSet. Los parámetros comienzan en 1. next sitúa el cursor en una fila si la consulta encuentra el ID. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            preparar(sql);
            try (var q = db.prepareStatement("SELECT cantidad FROM material WHERE id=?")) { q.setInt(1, 1); try (var filas = q.executeQuery()) { if (filas.next()) System.out.println(filas.getInt(1)); } }
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
5
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/60-insertar-actualizar-y-eliminar/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Prepara SELECT por ID.
2. Vincula el parámetro.
3. Comprueba next.
4. Lee dos columnas.
5. Recorre múltiples filas.
6. Ordena resultados.
7. Convierte filas en objetos.
8. Gestiona consulta sin filas.
9. Comprueba parámetro inválido.
10. Entrega una búsqueda parametrizada con listado y caso ausente.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S03-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S03-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Consultar con PreparedStatement y ResultSet. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S03-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Consultar con PreparedStatement y ResultSet</a>
</div>
