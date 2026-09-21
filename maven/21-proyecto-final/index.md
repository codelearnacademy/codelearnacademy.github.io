---
layout: lesson
route: maven
lesson_id: principal21
lesson_number: "21"
title: "Proyecto final: gestor de tareas"
description: "Integra persistencia, pruebas y distribución en una aplicación construible desde un clon limpio."
permalink: /maven/21-proyecto-final/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: requisitos-funcionales
    title: "Requisitos funcionales"
  - id: diseño-y-ejemplo-de-uso
    title: "Diseño y ejemplo de uso"
  - id: hitos-verificables
    title: "Hitos verificables"
  - id: comprobación-de-entrega
    title: "Comprobación de entrega"
  - id: ejercicio-de-revisión
    title: "Ejercicio de revisión"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Proyecto final: gestor de tareas

Integra persistencia, pruebas y distribución en una aplicación construible desde un clon limpio.
## Objetivo y punto de partida

Amplía el proyecto construido durante la ruta. Ya dispones de Maven, Gson, JUnit, recursos, Wrapper y CI. El objetivo es demostrar que otra persona puede construir y ejecutar una entrega documentada.

## Requisitos funcionales

La consola debe permitir añadir, listar, completar y eliminar tareas. Cada tarea tiene identificador, título y estado. Rechaza títulos vacíos y trata identificadores inexistentes con un resultado claro. Guarda las tareas en un JSON externo y recupéralas al iniciar; si el archivo no existe, empieza con una lista vacía. Si el JSON está dañado, informa del problema sin sobrescribirlo silenciosamente.

## Diseño y ejemplo de uso

```text
src/main/java/com/codelearn/tareas/
├── Main.java                # interacción de consola
├── Tarea.java               # identificador, título y estado
├── GestorTareas.java        # operaciones del dominio
└── RepositorioTareas.java   # lectura/escritura JSON
src/test/java/com/codelearn/tareas/
├── GestorTareasTest.java
└── RepositorioTareasTest.java
```

Evoluciona la lista de títulos de la lección 13 a tareas con identificador. Conserva las pruebas que sigan siendo válidas y actualiza las que dependan de esa representación.

```text
> añadir Aprender Maven
Tarea 1 creada
> completar 1
Tarea 1 completada
> listar
1 [completada] Aprender Maven
> salir
```

Puedes implementar menú numérico o comandos; documenta la opción elegida. La ruta del archivo de datos puede recibirse como argumento; usa una ubicación externa al artefacto y no dependas del árbol `src/`.

## Hitos verificables

1. Modelo y operaciones en memoria, con pruebas de añadir, completar, eliminar y buscar un identificador inexistente.
2. Persistencia JSON, con pruebas de ida y vuelta, archivo inexistente y datos inválidos. Usa directorios temporales en las pruebas.
3. Consola que delega en el dominio; ejecución fuera del IDE.
4. Build `./mvnw -Pdistribucion clean verify`, con pruebas realmente ejecutadas y JAR `-all` generado.
5. Git y CI con el mismo comando; settings privado solo si tu entorno lo necesita.
6. README y entrega estable. Cambia la versión de `1.0.0-SNAPSHOT` a `1.0.0`, verifica y crea la etiqueta `v1.0.0`.

## Comprobación de entrega

Desde un clon limpio, en macOS/Linux:

```bash
./mvnw -Pdistribucion clean verify
java -jar target/gestor-tareas-1.0.0-all.jar
```

En Windows utiliza `.\mvnw.cmd -Pdistribucion clean verify`; el comando `java -jar` es el mismo. Añade una tarea, termina la aplicación y arráncala otra vez: la tarea debe recuperarse.

El README debe explicar requisitos, construcción, pruebas, ejecución, ubicación de datos y configuración externa necesaria. No incluyas credenciales ni datos personales. Entrega el artefacto o instrucciones exactas para obtenerlo.

## Ejercicio de revisión

Pide a otra persona que siga únicamente el README. Anota el primer punto ambiguo y corrígelo. Comprueba también que Git no contiene `target/`, secretos ni el fichero mutable de tareas.

## Qué debes recordar

La entrega está terminada cuando se puede construir, probar, ejecutar y comprender desde un clon limpio. El acceso a repositorios privados, si existe, debe explicarse como requisito externo.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/20-diagnosticar-build/' | relative_url }}">← 20 · Diagnosticar y reparar problemas de Maven</a>
<a href="{{ '/maven/a1-publicar-artefactos/' | relative_url }}">A1 · A1 · Publicar artefactos en un repositorio privado →</a>
</nav>
