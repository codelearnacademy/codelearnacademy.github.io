---
layout: lesson
route: maven
lesson_id: principal20
lesson_number: "20"
title: "Diagnosticar y reparar problemas de Maven"
description: "Relaciona cada fallo con su causa y utiliza el modelo efectivo para investigar."
permalink: /maven/20-diagnosticar-build/
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
# Diagnosticar y reparar problemas de Maven

Relaciona cada fallo con su causa y utiliza el modelo efectivo para investigar.
## Objetivo y punto de partida

Trabaja en una rama de práctica y empieza con `./mvnw clean verify` correcto. En PowerShell utiliza `.\mvnw.cmd`.

## Práctica guiada

Provoca un solo problema cada vez y restáuralo antes del siguiente:

| Cambio controlado | Señal | Investigación |
|---|---|---|
| Etiqueta del POM sin cerrar | POM no legible | Archivo y línea del XML |
| Versión de Gson inexistente | No se resuelve el artefacto | Coordenadas, repositorio y acceso |
| Aserción incorrecta | Fallo de Surefire | Test e informe en `target/surefire-reports` |
| Test con nombre no reconocido | Cero pruebas | Nombre, ruta y configuración de Surefire |
| Ejecutar JAR convencional sin Gson | `NoClassDefFoundError` | Classpath o artefacto de distribución |

Para investigar:

```bash
./mvnw --version
./mvnw help:active-profiles
./mvnw help:effective-pom -Doutput=target/pom-efectivo.xml
./mvnw dependency:tree -Dverbose
./mvnw -e test
```

Si necesitas investigar settings utiliza `help:effective-settings` con el mismo `-s` que usó el build. El POM efectivo combina herencia, perfiles y defaults; el árbol muestra las dependencias seleccionadas.

## Comprobación y errores habituales

Empieza por el primer error relevante, no solo por la última línea `BUILD FAILURE`. `-e` añade detalle de excepciones y `-X` añade depuración extensa; revisa el log antes de compartirlo porque puede contener información del entorno.

No borres toda `.m2` como primer paso: fuerza descargas y puede ocultar la causa. Una versión incorrecta no se arregla vaciando la caché. Si necesitas aislar resolución, usa un repositorio local temporal con `-Dmaven.repo.local=target/repositorio-prueba`.

## Ejercicio

Redacta un pequeño informe de uno de los fallos con comando, señal observada, causa y corrección. Demuestra que la corrección termina ejecutando pruebas.

## Qué debes recordar

Un fallo de descarga, uno de compilación y uno de ejecución requieren investigaciones distintas. Cambia una variable cada vez y verifica la causa.

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/19-maven-ci/' | relative_url }}">← 19 · Automatizar el build en CI</a>
<a href="{{ '/maven/21-proyecto-final/' | relative_url }}">21 · Proyecto final: gestor de tareas →</a>
</nav>
