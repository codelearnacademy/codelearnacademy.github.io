---
layout: lesson
route: maven
lesson_id: principal14
lesson_number: "14"
title: "El build como comprobación de calidad"
description: "Comprueba cómo un fallo detiene el proceso y qué garantiza verify."
permalink: /maven/14-build-calidad/
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
# El build como comprobación de calidad

Comprueba cómo un fallo detiene el proceso y qué garantiza verify.
## Objetivo y punto de partida

Parte de las dos pruebas correctas de la lección 13. La calidad que comprueba Maven depende de las pruebas y plugins configurados.

## Práctica guiada

```bash
mvn clean verify
```

Debe ejecutar las pruebas y generar el JAR. Introduce un error controlado en `GestorTareas.anadir`: elimina temporalmente `titulos.add(titulo)`. Ejecuta otra vez `mvn clean verify`.

La prueba debe fallar y Maven debe detenerse antes del empaquetado. Como has ejecutado `clean`, no debería quedar un JAR anterior que puedas confundir con uno recién construido. Restaura la línea y repite.

## Comprobación y errores habituales

En macOS/Linux comprueba el código de salida inmediatamente después del comando con `echo $?`; en PowerShell utiliza `$LASTEXITCODE`. El éxito devuelve 0; un fallo devuelve un valor distinto de 0. CI utiliza esta señal.

`-DskipTests` omite la ejecución de pruebas; `-Dmaven.test.skip=true` omite además su compilación en los plugins que reconocen esa propiedad. No utilices estas opciones como arreglo de una prueba fallida.

Llegar a `verify` no configura por sí mismo cobertura, análisis estático o pruebas de integración. Las unitarias ya se ejecutan durante `test`.

## Ejercicio

Provoca un fallo de compilación y un fallo de aserción por separado. Identifica la primera causa relevante en cada log y corrige ambos.

## Qué debes recordar

El build constituye una barrera solo para las comprobaciones que realmente ejecuta. Mantén el mismo comando de verificación en local y CI.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/13-junit-surefire/' | relative_url }}">← 13 · Añadir y ejecutar pruebas con JUnit</a>
<a href="{{ '/maven/15-recursos-configuracion/' | relative_url }}">15 · Recursos y configuración de la aplicación →</a>
</nav>
