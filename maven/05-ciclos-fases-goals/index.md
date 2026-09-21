---
layout: lesson
route: maven
lesson_id: principal05
lesson_number: "05"
title: "Ciclos de vida, fases y goals"
description: "Entiende qué ejecutan clean, package y verify y cómo intervienen los plugins."
permalink: /maven/05-ciclos-fases-goals/
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
# Ciclos de vida, fases y goals

Entiende qué ejecutan clean, package y verify y cómo intervienen los plugins.
## Objetivo y punto de partida

Utiliza el proyecto compilable de la lección 04. Una fase representa un paso del proceso; un goal es una tarea concreta de un plugin.

## Práctica guiada

```bash
mvn clean package
```

`clean` pertenece a su propio ciclo y elimina resultados anteriores. `package` pertenece al ciclo `default` y alcanza todas las fases anteriores de ese ciclo. Para un proyecto JAR, los enlaces habituales incluyen `compiler:compile`, `surefire:test` y `jar:jar`.

| Fase del ciclo default | Propósito |
|---|---|
| `validate` | Validar el proyecto |
| `compile` | Compilar código principal |
| `test` | Ejecutar pruebas unitarias configuradas |
| `package` | Crear el artefacto |
| `verify` | Ejecutar comprobaciones vinculadas a esta fase |
| `install` | Instalar artefacto y POM en el repositorio local |
| `deploy` | Publicar en el repositorio remoto configurado |

La tabla resume fases relevantes; existen fases intermedias. Maven también define el ciclo `site` para documentación. `mvn package` no ejecuta `clean` implícitamente.

## Comprobación y errores habituales

```bash
mvn clean verify
```

Busca los nombres de plugins en la salida. `verify` incluye el recorrido hasta empaquetar; no añade automáticamente análisis estático ni pruebas de integración si no están configurados. Ejecutar `mvn compile test package` repite recorridos que normalmente puedes expresar con `mvn package`.

## Ejercicio

Compara la salida de `mvn compile` y `mvn package`. Identifica al menos un goal que solo aparece en el segundo comando.

## Qué debes recordar

Las fases ordenan el proceso y los plugins realizan el trabajo. Alcanzar una fase ejecuta las anteriores de su ciclo, con las tareas que tenga configuradas.

Referencia: [Ciclo de vida de Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/04-compilar-target/' | relative_url }}">← 04 · Compilar y entender los archivos generados</a>
<a href="{{ '/maven/06-anadir-dependencia/' | relative_url }}">06 · Añadir y utilizar una dependencia →</a>
</nav>
