---
layout: lesson
route: maven
lesson_id: principal09
lesson_number: "09"
title: "Repositorios privados, mirrors y proxy"
description: "Conecta Maven con Nexus o Artifactory y diagnostica el acceso."
permalink: /maven/09-privados-mirrors-proxy/
lessons:
  - id: objetivo-y-punto-de-partida
    title: "Objetivo y punto de partida"
  - id: práctica-guiada-mirror-y-autenticación
    title: "Práctica guiada: mirror y autenticación"
  - id: proxy-opcional
    title: "Proxy opcional"
  - id: comprobación-y-errores-habituales
    title: "Comprobación y errores habituales"
  - id: ejercicio
    title: "Ejercicio"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---
# Repositorios privados, mirrors y proxy

Conecta Maven con Nexus o Artifactory y diagnostica el acceso.
## Objetivo y punto de partida

Para ejecutar esta práctica necesitas un Nexus o Artifactory existente y una cuenta autorizada. Solicita la URL HTTPS de un repositorio agrupado que incluya las bibliotecas y plugins necesarios. Los dominios `.example` siguientes son marcadores que debes sustituir; no son servicios disponibles.

## Práctica guiada: mirror y autenticación

Guarda fuera de Git un archivo `settings-empresa.xml`:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0">
  <servers>
    <server>
      <id>empresa</id>
      <username>${env.MAVEN_REPO_USER}</username>
      <password>${env.MAVEN_REPO_TOKEN}</password>
    </server>
  </servers>
  <mirrors>
    <mirror>
      <id>empresa</id>
      <mirrorOf>*</mirrorOf>
      <url>https://repo.empresa.example/repository/maven-public/</url>
    </mirror>
  </mirrors>
</settings>
```

Para Artifactory, la URL puede tener una forma como `https://repo.empresa.example/artifactory/maven-virtual/`. Utiliza siempre la URL real proporcionada por quien administra el servicio.

Define `MAVEN_REPO_USER` y `MAVEN_REPO_TOKEN` en el entorno mediante tu gestor de secretos o el mecanismo de CI. En una terminal, puedes asignarlas para la sesión con `export` (macOS/Linux) o `$env:MAVEN_REPO_USER` y `$env:MAVEN_REPO_TOKEN` (PowerShell). Evita escribir valores reales en archivos versionados o comandos que se compartan.

```bash
mvn -s settings-empresa.xml clean verify
```

El `<server><id>` debe coincidir con el identificador del mirror, porque Maven termina conectándose a él. `mirrorOf=*` dirige todos los repositorios al servicio; el mirror debe proporcionar los artefactos solicitados. Un mirror no une por sí mismo varios repositorios: esa agrupación la realiza Nexus o Artifactory.

## Proxy opcional

Si tu red requiere un proxy, añade a `<settings>` este bloque y ajusta los datos:

```xml
<proxies>
  <proxy>
    <id>red-empresa</id>
    <active>true</active>
    <protocol>http</protocol>
    <host>proxy.empresa.example</host>
    <port>8080</port>
    <nonProxyHosts>localhost|127.0.0.1|*.empresa.example</nonProxyHosts>
  </proxy>
</proxies>
```

El protocolo corresponde al proxy. Si requiere autenticación, utiliza `<username>` y `<password>` con variables de entorno, igual que en el servidor.

## Comprobación y errores habituales

Observa la URL de las descargas en el log. Si la caché ya contiene todos los artefactos, una construcción correcta no demuestra acceso remoto: para una comprobación aislada puedes usar `-Dmaven.repo.local=target/repositorio-prueba`, lo que descargará de nuevo los componentes necesarios.

- `401`: revisa credenciales e identificadores.
- `403`: revisa permisos de lectura.
- `404`: revisa URL, repositorio y coordenadas.
- Error de certificado: revisa la cadena de confianza con quien administra la red; no desactives HTTPS para ocultarlo.

## Ejercicio

Documenta el identificador del mirror y la URL utilizada sin incluir secretos. Si no dispones de servicio privado, analiza el XML y deja esta práctica de conexión pendiente hasta tener acceso.

## Qué debes recordar

Las credenciales pertenecen al entorno. Los identificadores conectan la configuración de autenticación con el repositorio efectivo.

Referencias: [Mirrors](https://maven.apache.org/guides/mini/guide-mirror-settings), [Proxy](https://maven.apache.org/guides/mini/guide-proxies.html).

<nav class="cla-lesson-nav" aria-label="Navegación de la ruta Maven">
<a href="{{ '/maven/08-repositorios-settings/' | relative_url }}">← 08 · Repositorios externos y settings.xml</a>
<a href="{{ '/maven/10-profiles/' | relative_url }}">10 · Profiles: activar configuraciones de Maven →</a>
</nav>
