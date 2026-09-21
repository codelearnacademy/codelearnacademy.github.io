---
layout: lesson
route: maven
lesson_id: principal13
lesson_number: "13"
title: "Añadir y ejecutar pruebas con JUnit"
description: "Configura JUnit Jupiter y comprueba que Surefire ejecuta pruebas reales."
permalink: /maven/13-junit-surefire/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Añadir y ejecutar pruebas con JUnit

Configura JUnit Jupiter y comprueba que Surefire ejecuta pruebas reales.
## Objetivo y punto de partida

El POM debe conservar Surefire 3.5.2 y el BOM JUnit de la lección 12. No basta con obtener `BUILD SUCCESS`: debes comprobar que se ejecuta al menos una prueba.

## Práctica guiada

Añade dentro del bloque normal `<dependencies>`:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <scope>test</scope>
</dependency>
```

La versión procede del BOM. Crea `src/main/java/com/codelearn/tareas/GestorTareas.java`:

```java
package com.codelearn.tareas;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private final List<String> titulos = new ArrayList<>();

    public void anadir(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        titulos.add(titulo);
    }

    public List<String> listar() {
        return List.copyOf(titulos);
    }
}
```

Crea `src/test/java/com/codelearn/tareas/GestorTareasTest.java`:

```java
package com.codelearn.tareas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestorTareasTest {
    @Test
    void anadeUnaTarea() {
        var gestor = new GestorTareas();
        gestor.anadir("Aprender Maven");
        assertEquals(1, gestor.listar().size());
        assertEquals("Aprender Maven", gestor.listar().get(0));
    }

    @Test
    void rechazaTituloVacio() {
        var gestor = new GestorTareas();
        assertThrows(IllegalArgumentException.class, () -> gestor.anadir(" "));
    }
}
```

```bash
mvn test
mvn -Dtest=GestorTareasTest test
```

## Comprobación y errores habituales

La salida debe indicar **2 pruebas, 0 fallos y 0 errores**. Los informes se guardan en `target/surefire-reports/`. Cambia temporalmente el tamaño esperado a 2: debe fallar. Restáuralo.

Surefire reconoce por defecto patrones como `*Test.java`, `Test*.java`, `*Tests.java` y `*TestCase.java`. Revisa nombre, ruta, import de `@Test` y configuración si se ejecutan cero pruebas. Una dependencia con scope `test` no debe importarse desde `src/main/java`.

## Ejercicio

Añade una prueba para un título `null` y otra que compruebe que `listar()` no permite modificar el estado interno.

## Qué debes recordar

JUnit define las pruebas; Surefire las integra en Maven. Una construcción sin pruebas no demuestra que el comportamiento esté validado.

Referencia: [JUnit Platform y Surefire](https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit-platform.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/12-propiedades-versiones/' | relative_url }}">← 12 · Propiedades y gestión de versiones</a>
<a href="{{ '/maven/14-build-calidad/' | relative_url }}">14 · El build como comprobación de calidad →</a>
</nav>
