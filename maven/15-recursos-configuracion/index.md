---
layout: lesson
route: maven
lesson_id: principal15
lesson_number: "15"
title: "Recursos y configuración de la aplicación"
description: "Carga recursos del classpath y separa configuración de datos persistidos."
permalink: /maven/15-recursos-configuracion/
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
# Recursos y configuración de la aplicación

Carga recursos del classpath y separa configuración de datos persistidos.
## Objetivo y punto de partida

Continúa con el proyecto probado. Maven copia por defecto `src/main/resources` al classpath principal.

## Práctica guiada

Crea `src/main/resources/aplicacion.properties`:

```properties
nombre=Gestor de tareas
```

Sustituye `Main.java` por este ejemplo, que conserva Gson:

```java
package com.codelearn.tareas;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        var config = new Properties();
        try (var entrada = Main.class.getResourceAsStream("/aplicacion.properties")) {
            if (entrada == null) {
                throw new IOException("Falta aplicacion.properties en el classpath");
            }
            config.load(entrada);
        }
        System.out.println(new Gson().toJson(Map.of("nombre", config.getProperty("nombre"))));
    }
}
```

```bash
mvn clean package
jar tf target/gestor-tareas-1.0.0-SNAPSHOT.jar
```

Busca `aplicacion.properties` en el listado y en `target/classes`. Si ya tienes el perfil `distribucion`, puedes ejecutar `mvn -Pdistribucion package` y después el JAR `-all` para observar el JSON.

## Comprobación y errores habituales

No leas el recurso mediante `new File("src/main/resources/...")`: esa ruta del código fuente no existe necesariamente en el equipo que ejecuta el JAR. La barra inicial en `getResourceAsStream` indica la raíz del classpath.

El fichero mutable `tareas.json` del proyecto final debe guardarse fuera del JAR, en una ruta de datos elegida por la aplicación. No intentes modificar un recurso empaquetado como almacén persistente.

## Ejercicio

Cambia el nombre, reconstruye y verifica que el recurso actualizado aparece en el artefacto. Retira temporalmente el archivo y comprueba el error al ejecutar; restáuralo.

## Qué debes recordar

Los recursos acompañan al artefacto. Los datos que cambian durante el uso necesitan una ubicación externa.

Referencia: [Recursos de Maven](https://maven.apache.org/plugins/maven-resources-plugin/).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/14-build-calidad/' | relative_url }}">← 14 · El build como comprobación de calidad</a>
<a href="{{ '/maven/16-empaquetar-ejecutar/' | relative_url }}">16 · Empaquetar y ejecutar la aplicación →</a>
</nav>
