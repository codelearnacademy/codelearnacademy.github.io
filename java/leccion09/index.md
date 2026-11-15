---
layout: lesson
route: java
lesson_id: leccion09
lesson_number: "09"
description: Consulta y gestiona préstamos relacionados con ObjectDB.
title: Persistencia y consultas avanzadas
permalink: /java/leccion09/
lessons:
  - id: objetivo
    title: "Objetivo"
  - id: sublecciones
    title: "Sublecciones"
  - id: practica-guiada
    title: "Práctica guiada · Préstamos en ObjectDB"
  - id: configuracion-de-objectdb
    title: "Configuración de ObjectDB"
---

# Persistencia y consultas avanzadas

<div class="cla-lesson-nav">
  <a href="{{ '/java/' | relative_url }}">Volver a Java</a>
</div>

## Objetivo
{: #objetivo }

Guardar y gestionar préstamos relacionados con ObjectDB, y construir consultas JPQL con parámetros, ordenación y agregación.

## Sublecciones
{: #sublecciones }

<div class="cla-content-map">
  <a href="{{ '/java/leccion09/64-que-almacena-una-base-orientada-a-objetos/' | relative_url }}"><span aria-hidden="true">01</span><strong>Qué almacena una base orientada a objetos</strong></a>
  <a href="{{ '/java/leccion09/65-configurar-el-gestor-y-crear-la-base/' | relative_url }}"><span aria-hidden="true">02</span><strong>Configurar el gestor y crear la base</strong></a>
  <a href="{{ '/java/leccion09/66-guardar-objetos-relacionados/' | relative_url }}"><span aria-hidden="true">03</span><strong>Guardar objetos relacionados</strong></a>
  <a href="{{ '/java/leccion09/67-buscar-por-identidad-y-consulta/' | relative_url }}"><span aria-hidden="true">04</span><strong>Buscar por identidad y consulta</strong></a>
  <a href="{{ '/java/leccion09/68-actualizar-revertir-y-borrar/' | relative_url }}"><span aria-hidden="true">05</span><strong>Actualizar, revertir y borrar</strong></a>
  <a href="{{ '/java/leccion09/69-cerrar-y-reabrir-para-verificar/' | relative_url }}"><span aria-hidden="true">06</span><strong>Cerrar y reabrir para verificar</strong></a>
  <a href="#practica-guiada"><span aria-hidden="true">→</span><strong>Práctica guiada</strong></a>
</div>

## Práctica guiada · Préstamos en ObjectDB
{: #practica-guiada }

**Práctica obligatoria.** Utiliza los demás ejercicios como refuerzo o ampliación.

<div class="cla-lesson-nav"><a href="{{ '/assets/proyectos/java/prestamos-objectdb.zip' | relative_url }}">Descargar Préstamos en ObjectDB</a></div>




<a href="{{ '/java/leccion09/#configuracion-de-objectdb' | relative_url }}">Guía y configuración de ObjectDB</a>


1. **Punto de partida.** Instala ObjectDB para Java 21 siguiendo la guía oficial, o importa sus dependencias Maven. Crea prestamos.odb en modo embebido.
2. **Pasos.** Define Prestamo y Material como clases persistentes. Modela LineaPrestamo como @Embeddable con una referencia al material, y guarda la colección con @ElementCollection. Compara búsqueda por identidad y consulta de objetos. Crea, recupera, actualiza y elimina un préstamo usando transacciones.
3. **Resultado esperado.** Al reabrir la base, el préstamo mantiene sus líneas y las referencias a los materiales.
4. **Caso de fallo.** Fuerza una modificación y revierte la transacción. Al eliminar un préstamo, verifica que el material compartido sigue disponible.

**Evidencia de entrega.** Configuración del gestor, clases, operaciones, salida tras reabrir y comparación razonada con SQLite.

### Rúbrica de la práctica

| Indicador | Puntos |
|---|---:|
| Documenta la instalación y la creación de la base .odb. | 1 |
| Recupera y actualiza un préstamo con referencias tras reabrir. | 1 |
| Demuestra reversión, borrado y conservación del material compartido. | 1 |

Cada indicador vale 1 si la evidencia es suficiente, 0,5 si es parcial y 0 si falta.


## Configuración de ObjectDB
{: #configuracion-de-objectdb }

Descarga el SDK y configura la variante Jakarta en un proyecto Java 21. Con Maven, añade el repositorio de ObjectDB y la dependencia `com.objectdb:objectdb-jk:2.9.6`. Consulta la [descarga y configuración oficial](https://www.objectdb.com/download) y la [guía de acceso en modo embebido](https://www.objectdb.com/tutorial/jpa/eclipse/store).

```java
var fabrica = jakarta.persistence.Persistence.createEntityManagerFactory("prestamos.odb");
try {
    var gestor = fabrica.createEntityManager();
    try {
        // Ejecuta las operaciones de la práctica.
    } finally {
        gestor.close();
    }
} finally {
    fabrica.close();
}
```

Puedes descargar el <a href="{{ '/java/proyectos/objectdb/pom.xml' | relative_url }}">pom.xml inicial</a>.

Usa `find(Prestamo.class, id)` para buscar por identidad y una consulta JPQL para filtrar por estado. Envuelve las escrituras en transacciones. Cierra y vuelve a abrir la base para comprobar la persistencia real. En ObjectDB el gestor persiste objetos. En la lección 08 JDBC modifica filas de SQLite.

<div class="cla-lesson-nav"><a href="{{ '/java/leccion08/' | relative_url }}">← 08 · Persistencia en Base de Datos</a></div>
