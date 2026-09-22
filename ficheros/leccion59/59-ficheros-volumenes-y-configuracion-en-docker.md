---
layout: lesson
route: ficheros
lesson_id: leccion59
lesson_file: 59-ficheros-volumenes-y-configuracion-en-docker
lesson_number: "59"
title: Ficheros, volúmenes y configuración en Docker
description: Ruta práctica para trabajar con ficheros y formatos de datos desde Java.
permalink: /ficheros/leccion59/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Ficheros, volúmenes y configuración en Docker

## Qué vas a conseguir

- Comprender **Ficheros, volúmenes y configuración en Docker**.
- Aplicarlo con Java 21.
- Distinguir lectura, parsing, validación y escritura.
- Relacionarlo con Maven, Spring o Docker cuando corresponda.

## Punto de partida

```text
Fichero → bytes/texto → parser → objetos Java → validación → lógica → writer → fichero
```

<div class="cla-note"><strong>Regla de la ruta</strong><p>Leer un fichero no es interpretarlo. Un parser entiende el formato; la lógica de negocio valida el significado.</p></div>

## Conceptos clave

- Acceso mediante `Path` y `Files`.
- UTF-8 explícito cuando trabajamos con texto.
- Manejo de errores mediante excepciones.
- Separación entre formato y modelo de dominio.

## Ejemplo guiado

Construye el JAR de la aplicación y monta fuera de la imagen los datos y la configuración:

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/aplicacion.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Ejemplo de ejecución con Docker Compose:

```yaml
services:
  aplicacion:
    build: .
    ports:
      - "8080:8080"
    volumes:
      - ./data:/app/data
      - ./config:/app/config:ro
```

La imagen contiene el código y las dependencias. `data` conserva los ficheros generados y `config` permite cambiar la configuración sin reconstruir la imagen. No montes secretos en una imagen ni los incluyas en `Dockerfile`.



## Relación con el resto de la ruta

Maven, Spring y Docker añaden empaquetado, endpoints, recursos, configuración externa y volúmenes alrededor de las mismas APIs.

## Ejercicios propuestos

1. Crea el `Dockerfile` y construye la imagen después de ejecutar `mvn package`.
2. Ejecuta el contenedor con los directorios `data` y `config` montados.
3. Modifica un fichero de configuración sin reconstruir la imagen y comprueba el cambio.
4. Verifica que los datos siguen disponibles tras eliminar y volver a crear el contenedor.
5. Explica qué pertenece a la imagen, al contenedor y al volumen.

## Qué debes recordar

- Maven **resuelve bibliotecas**; no parsea CSV, JSON o XML.
- `Properties`, Commons CSV y Jackson tienen responsabilidades diferentes.
- Los datos externos deben validarse.
- El modelo Java debería mantenerse independiente del formato.
- Los secretos no deben versionarse dentro de ficheros de configuración.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion58/">← 58 · Subida e importación de ficheros con Spring</a>
  <a href="/ficheros/leccion60/">60 · Exportaciones y persistencia de ficheros →</a>
</div>
