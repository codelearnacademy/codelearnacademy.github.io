---
layout: lesson
route: java
lesson_id: leccion08
lesson_number: "08"
title: "Confirmar y revertir transacciones"
permalink: /java/leccion08/62-confirmar-y-revertir-transacciones/
lessons:
  - id: ejemplo-en-java
    title: "Ejemplo en Java"
  - id: confirmar-o-revertir-una-salida
    title: "Confirmar o revertir una salida"
  - id: compruebalo
    title: "Compruébalo"
  - id: microproyecto-de-algoritmia
    title: "Microproyecto de algoritmia"
---

# Confirmar y revertir transacciones

Una actualización revertida deja el estado original. En el proyecto añade el movimiento en la misma transacción.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/08-sqlite.zip' | relative_url }}">Descargar proyecto SQLite JDBC</a>
</div>

Ejecuta el ejemplo con las dependencias del proyecto descargable y sigue las indicaciones de su README.

## Ejemplo en Java
{: #ejemplo-en-java }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/62.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/62.webp' | relative_url }}" alt="Confirmar y revertir transacciones. Una actualización revertida deja el estado original. En el proyecto añade el movimiento en la misma transacción. Resultado: 5" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        try (var db = java.sql.DriverManager.getConnection("jdbc:sqlite::memory:");
             var sql = db.createStatement()) {
            preparar(sql);
            db.setAutoCommit(false);
            sql.executeUpdate("UPDATE material SET cantidad=4 WHERE id=1");
            db.rollback();
            try (var r = sql.executeQuery("SELECT cantidad FROM material")) { if (r.next()) System.out.println(r.getInt(1)); }
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

## Confirmar o revertir una salida
{: #confirmar-o-revertir-una-salida }

El movimiento y la actualización se escriben en una transacción. Comprueba ambos resultados en bases de prueba nuevas.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/conceptos/75.webp' | relative_url }}" aria-label="Ampliar infografía"><img src="{{ '/assets/images/java/conceptos/75.webp' | relative_url }}" alt="Confirmar o revertir una salida. El movimiento y la actualización se escriben en una transacción. Comprueba ambos resultados en bases de prueba nuevas. Resultado: Reversión esperada, ID 1 | unidades 5 | salidas 0, ID 1 | unidades 4 | salidas 1" loading="lazy" decoding="async" style="max-width:100%;height:auto"></a>
</figure>

```java
public class Main {
    public static void main(String[] args) throws Exception {
        aula.Inventario.main(new String[]{"aula.db", "crear", "1", "5"});
        try { aula.Inventario.main(new String[]{"aula.db", "fallo", "1"}); } catch (java.sql.SQLException error) { System.out.println("Reversión esperada"); }
        aula.Inventario.main(new String[]{"aula.db", "listar"});
        aula.Inventario.main(new String[]{"aula.db", "salida", "1"});
        aula.Inventario.main(new String[]{"aula.db", "listar"});
    }
}
```

**Resultado esperado**

```text
Reversión esperada
ID 1 | unidades 5 | salidas 0
ID 1 | unidades 4 | salidas 1
```

## Compruébalo
{: #compruebalo }

Ejecuta el ejemplo, compara su resultado con el esperado y explica el paso que determina la salida.

<div class="cla-lesson-nav">
  <a href="{{ '/java/leccion08/' | relative_url }}">← Volver a la lección</a>
  <a href="{{ '/java/leccion08/63-comprobar-integridad-al-reabrir/' | relative_url }}">Siguiente concepto →</a>
</div>


## Microproyecto de algoritmia
{: #microproyecto-de-algoritmia }

Resuelve los diez ejercicios en Java 21. Implementa las operaciones pendientes del README. Ejecuta las pruebas incluidas y añade casos de prueba para tus ampliaciones. Documenta las clases y métodos con Javadoc.

1. Inicia una transacción.
2. Confirma una actualización.
3. Revierte una actualización.
4. Registra una salida.
5. Descuenta unidades en la misma transacción.
6. Comprueba el total con dos operaciones.
7. Distingue error y confirmación.
8. Fuerza fallo en la segunda operación.
9. Comprueba stock insuficiente.
10. Demuestra en dos bases el resultado de commit y rollback.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/java/microproyectos/L08-S06-tarea-01.webp' | relative_url }}" aria-label="Ampliar la infografía del microproyecto">
    <img src="{{ '/assets/images/java/microproyectos/L08-S06-tarea-01.webp' | relative_url }}" alt="Resumen de la tarea Confirmar y revertir transacciones. El encargo y cómo comprobarlo se explican en este apartado y en el README." loading="lazy" decoding="async" style="max-width:100%;height:auto">
  </a>
</figure>

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/java/leccion08/L08-S06-tarea-01.zip' | relative_url }}">Descargar tarea 1 · Confirmar y revertir transacciones</a>
</div>
