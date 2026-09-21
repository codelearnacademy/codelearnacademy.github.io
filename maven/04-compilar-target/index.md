---
layout: lesson
route: maven
lesson_id: principal04
lesson_number: "04"
title: "Compilar y entender los archivos generados"
description: "Compila, localiza el bytecode y ejecuta la aplicación sin el IDE."
permalink: /maven/04-compilar-target/
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
# Compilar y entender los archivos generados

Compila, localiza el bytecode y ejecuta la aplicación sin el IDE.
## Objetivo y punto de partida

Continúa con el proyecto de la lección 03. No necesitas bibliotecas externas todavía.

## Práctica guiada

```bash
mvn compile
java -cp target/classes com.codelearn.tareas.Main
```

La ejecución debe imprimir `Gestor de tareas preparado`. Localiza `target/classes/com/codelearn/tareas/Main.class`. En macOS/Linux puedes ejecutar:

```bash
find target/classes -type f
```

En PowerShell:

```powershell
Get-ChildItem target/classes -Recurse -File
```

`target/classes` es la raíz del classpath; la JVM busca dentro de ella la ruta que corresponde al paquete. Maven mantiene los productos de construcción bajo `target/`.

## Comprobación y errores habituales

Modifica el mensaje, recompila y vuelve a ejecutar. Introduce después una falta de punto y coma: `mvn compile` debe fallar e indicar archivo y línea. Corrige el error antes de continuar.

`invalid target release: 21` indica que el compilador utilizado no soporta esa versión. Comprueba `mvn -version`. `ClassNotFoundException` puede indicar paquete incorrecto o classpath equivocado.

## Ejercicio

Ejecuta `mvn clean` y comprueba que desaparece `target/`. Reconstruye con `mvn compile` y ejecuta de nuevo.

## Qué debes recordar

Los `.class` son resultados reconstruibles. No reemplazan a los `.java` ni deben versionarse como código fuente.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/03-primer-proyecto/' | relative_url }}">← 03 · Crear el primer proyecto Maven</a>
<a href="{{ '/maven/05-ciclos-fases-goals/' | relative_url }}">05 · Ciclos de vida, fases y goals →</a>
</nav>
