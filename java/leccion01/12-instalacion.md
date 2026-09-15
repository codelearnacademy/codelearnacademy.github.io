---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 12-instalacion
lesson_number: "12"
title: Instalación
description: Instala un JDK 21 y verifica el entorno antes de escribir código.
---

# Instalación

Instala un JDK 21 de una distribución compatible con tu sistema operativo. Después abre un terminal nuevo para que el sistema cargue las variables de entorno actualizadas.

## Verificación mínima

```bash
java -version
javac -version
```

Ambos comandos deben responder con la versión 21 o con la versión de JDK que hayas elegido explícitamente. Si `java` funciona pero `javac` no existe, probablemente tienes un runtime incompleto o el `PATH` apunta a otra instalación.

## Diagnóstico

```bash
which java
which javac
```

En Windows, utiliza `where java` y `where javac`. Cuando haya varias instalaciones, corrige el `PATH` o configura el JDK desde tu IDE y tu herramienta de build de forma explícita.

<div class="cla-note"><strong>Resultado esperado</strong><p>El terminal debe poder encontrar el compilador y el lanzador de Java sin depender de una ruta absoluta en cada comando.</p></div>

## Entorno reproducible

Anota el sistema operativo, la arquitectura y el proveedor del JDK. En equipos profesionales conviene automatizar la selección de versión con la herramienta de build o un gestor de versiones, y comprobarla también en CI.

La idea es común a Node.js con `node --version`, Python con `python --version` y Go con `go version`: el comando de verificación debe formar parte del diagnóstico.

## Lista de comprobación

1. Instala una distribución JDK 21 de 64 bits adecuada para tu sistema.
2. Abre un terminal nuevo y comprueba `java -version`.
3. Comprueba `javac -version` y confirma que el compilador pertenece a la misma instalación.
4. Ejecuta `which java` y `which javac` en macOS o Linux para detectar rutas mezcladas.
5. Guarda la información en el README del ejercicio.

Si trabajas con Windows, sustituye `which` por `where`. En un equipo, una captura aislada ayuda menos que comandos reproducibles y una salida que otra persona pueda contrastar.