---
layout: lesson
route: maven
lesson_id: principal17
lesson_number: "17"
title: "Crear y utilizar Maven Wrapper"
description: "Fija Maven para el proyecto y usa el mismo punto de entrada en local y CI."
permalink: /maven/17-maven-wrapper/
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
# Crear y utilizar Maven Wrapper

Fija Maven para el proyecto y usa el mismo punto de entrada en local y CI.
## Objetivo y punto de partida

Necesitas Maven global para generar el Wrapper una vez, o recibir un proyecto que ya lo tenga. El Wrapper descarga la distribución elegida en su primer uso; sigue necesitando un JDK y acceso de red para componentes no disponibles localmente.

## Práctica guiada

El plugin Wrapper ya está declarado desde la lección 12 con `${maven-wrapper-plugin.version}`. La opción `-Dmaven=3.9.11` selecciona la distribución de Maven, no la versión del plugin.

Desde la raíz del proyecto:

```bash
mvn wrapper:wrapper -Dmaven=3.9.11 -Dtype=only-script
```

Debe crear `mvnw`, `mvnw.cmd` y `.mvn/wrapper/maven-wrapper.properties`. En el tipo `only-script` no debes esperar obligatoriamente un `maven-wrapper.jar`.

En macOS/Linux:

```bash
chmod +x mvnw
./mvnw --version
./mvnw clean verify
```

En Windows PowerShell:

```powershell
.\mvnw.cmd --version
.\mvnw.cmd clean verify
```

Comprueba que aparece Maven 3.9.11 y Java 21. Versiona ambos scripts y la configuración `.mvn/`. Revisa `distributionUrl` para conocer qué distribución se descarga.

## Comprobación y errores habituales

`Permission denied` en macOS/Linux requiere permiso de ejecución. En Git puedes conservarlo con `git update-index --chmod=+x mvnw` después de añadir el archivo. En Windows utiliza el script `.cmd`, no dependas de una shell Unix.

Para actualizar Maven, cambia de forma revisable la versión del Wrapper y ejecuta las pruebas del proyecto. No presupongas que cambiar Maven global cambia el Wrapper.

## Ejercicio

Ejecuta el Wrapper en una terminal nueva y compara su versión con `mvn -version`. Explica qué parte controla y qué parte sigue dependiendo del entorno.

## Qué debes recordar

Desde ahora utiliza Wrapper en los comandos de la ruta. En macOS/Linux, `./mvnw`; en PowerShell, `.\mvnw.cmd`.

Referencia: [Maven Wrapper Plugin](https://maven.apache.org/tools/wrapper/maven-wrapper-plugin/usage.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/16-empaquetar-ejecutar/' | relative_url }}">← 16 · Empaquetar y ejecutar la aplicación</a>
<a href="{{ '/maven/18-maven-git/' | relative_url }}">18 · Maven dentro del flujo Git →</a>
</nav>
