---
layout: lesson
route: maven
lesson_id: principal08
lesson_number: "08"
title: "Repositorios externos y settings.xml"
description: "Separa la configuración del proyecto de la configuración del equipo."
permalink: /maven/08-repositorios-settings/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada
    title: "Práctica guiada"
  - id: configuración-permanente
    title: "Configuración permanente"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Repositorios externos y settings.xml

Separa la configuración del proyecto de la configuración del equipo.
## Objetivo y punto de partida

Necesitas conocer Central y `.m2`. El POM expresa las necesidades del proyecto. `settings.xml` contiene configuración del entorno, como servidores, proxy, mirrors y perfiles. No se crea automáticamente en todas las instalaciones.

## Práctica guiada

Crea una carpeta `config` en el proyecto y guarda **sin credenciales** `config/settings-publico.xml`:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
  <profiles>
    <profile>
      <id>repositorio-publico</id>
      <repositories>
        <repository>
          <id>central-explicito</id>
          <url>https://repo.maven.apache.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>false</enabled></snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>
</settings>
```

Este ejemplo utiliza Central para practicar con una URL real sin necesitar una cuenta. No hace falta añadirlo en un proyecto normal. Para otro proveedor sustituye identificador y URL por los que te indique.

```bash
mvn -s config/settings-publico.xml -Prepositorio-publico help:active-profiles
mvn -s config/settings-publico.xml -Prepositorio-publico compile
```

Debe aparecer `repositorio-publico` entre los perfiles activos. `-s` selecciona el archivo de configuración del usuario; no reemplaza el POM ni elimina necesariamente los settings globales.

## Configuración permanente

La ubicación de usuario es `~/.m2/settings.xml` en macOS/Linux y `%USERPROFILE%\.m2\settings.xml` en Windows. También puede existir `${maven.home}/conf/settings.xml`; Maven combina configuración global y de usuario, dando prioridad a la de usuario.

Si un repositorio es un requisito compartido del proyecto puedes declarar `<repositories>` directamente bajo `<project>` en el POM. Los repositorios para resolver plugins se declaran con `<pluginRepositories>`; no son lo mismo que los de bibliotecas.

## Comprobación y errores habituales

Un `<repositories>` directamente bajo `<settings>` es inválido: en settings debe ir dentro de un perfil. Para inspeccionar la configuración, ejecuta `mvn -s config/settings-publico.xml help:effective-settings`. No publiques la salida de configuraciones que incluyan datos privados.

## Ejercicio

Ejecuta la comprobación con y sin `-Prepositorio-publico`. Explica qué cambia y por qué el proyecto puede seguir descargando desde Central por defecto.

## Qué debes recordar

Configura lo compartido en el proyecto y lo propio del entorno en settings. Un repositorio de descarga no configura la publicación de artefactos.

Referencia: [Settings de Maven](https://maven.apache.org/settings.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/07-central-repositorio-local/' | relative_url }}">← 07 · Maven Central y el repositorio local</a>
<a href="{{ '/maven/09-privados-mirrors-proxy/' | relative_url }}">09 · Repositorios privados, mirrors y proxy →</a>
</nav>
