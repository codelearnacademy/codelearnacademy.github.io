---
layout: lesson
route: maven
lesson_id: ampliacion01
lesson_number: "A1"
title: "A1 · Publicar artefactos en un repositorio privado"
description: "Distingue install de deploy y publica releases y snapshots de forma controlada."
permalink: /maven/a1-publicar-artefactos/
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
# A1 · Publicar artefactos en un repositorio privado

Distingue install de deploy y publica releases y snapshots de forma controlada.
## Objetivo y punto de partida

Esta ampliación necesita un repositorio remoto real con permisos de escritura. Practica en un repositorio de formación: `deploy` realiza una publicación externa. Necesitas dos URLs proporcionadas por quien administra Nexus o Artifactory, una para releases y otra para snapshots.

## Práctica guiada

Añade bajo `<project>` y sustituye las URLs de ejemplo:

```xml
<distributionManagement>
  <repository>
    <id>empresa-releases</id>
    <url>https://repo.empresa.example/repository/maven-releases/</url>
  </repository>
  <snapshotRepository>
    <id>empresa-snapshots</id>
    <url>https://repo.empresa.example/repository/maven-snapshots/</url>
  </snapshotRepository>
</distributionManagement>
```

En settings añade `<server>` para **cada identificador**, con usuario y token de publicación mediante variables de entorno, siguiendo la lección 09. No utilices por defecto las credenciales de lectura de CI como credenciales de publicación.

Añade `<maven-deploy-plugin.version>3.1.3</maven-deploy-plugin.version>` al bloque `<properties>` existente. Para fijar el plugin mediante esa propiedad, añade a `<build><plugins>`:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-deploy-plugin</artifactId>
  <version>${maven-deploy-plugin.version}</version>
</plugin>
```

Antes de publicar:

```bash
./mvnw -s /ruta/real/settings-publicacion.xml clean verify
```

Cuando el destino y los permisos estén confirmados, ejecuta:

```bash
./mvnw -s /ruta/real/settings-publicacion.xml deploy
```

Con `1.0.0-SNAPSHOT`, Maven usa el destino snapshot; con `1.0.0`, el de releases. Muchos servicios impiden sobrescribir una release: utiliza una versión nueva para cambios posteriores.

## Comprobación y errores habituales

Consulta el servicio y verifica artefacto, POM y versión. Para comprobar consumo desde otro proyecto, configura un repositorio de descarga según las lecciones 08–09 y declara las coordenadas publicadas. `distributionManagement` no configura el repositorio desde el que los consumidores descargan.

`401/403` puede indicar credenciales o permisos de escritura. Un error de política puede indicar snapshot en repositorio de releases o una release ya existente.

## Ejercicio

Publica una versión snapshot de formación y consúmela desde un proyecto separado. Si no tienes permisos, prepara el POM y settings de ejemplo y verifica hasta `verify`, dejando la publicación pendiente.

## Qué debes recordar

`install` hace disponible el artefacto en tu equipo; `deploy` lo publica remotamente. Separar lectura y publicación simplifica permisos y diagnóstico.

Referencia: [Deploy Plugin](https://maven.apache.org/plugins/maven-deploy-plugin/).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/21-proyecto-final/' | relative_url }}">← 21 · Proyecto final: gestor de tareas</a>
<a href="{{ '/maven/a2-varios-modulos/' | relative_url }}">A2 · A2 · Proyectos con varios módulos →</a>
</nav>
