---
layout: lesson
route: docker
lesson_id: leccion28
lesson_file: 28-bind-mounts
lesson_number: "28"
title: Bind mounts
description: Monta rutas del host dentro de un contenedor y diferencia este mecanismo de los volúmenes.
permalink: /docker/leccion28/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-otras-tecnologías
    title: Relación con otras tecnologías
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Bind mounts

Monta rutas del host dentro de un contenedor y diferencia este mecanismo de los volúmenes.

## Qué vas a conseguir

- Comprender **bind mount**.
- Comprender **desarrollo**.
- Comprender **ruta host**.
- Comprender **permisos**.
- Aplicar el concepto en un ejemplo reproducible.
- Relacionarlo con el flujo Git → build → imagen → despliegue.

<div class="cla-note"><strong>Enfoque de la ruta</strong><p>No memorices comandos aislados. Antes de ejecutar Docker, identifica qué problema resuelve el comando, qué recurso modifica y cómo vas a comprobar el resultado.</p></div>

## Punto de partida

En las rutas anteriores, **Git** conserva la historia del código y **Maven** puede construir y verificar un proyecto Java. Docker añade otra responsabilidad: describir y ejecutar de forma reproducible el entorno donde el software funciona.

Modelo general:

```text
Git
 ↓
código + configuración
 ↓
Maven / npm
 ↓
artefactos
 ↓
Docker
 ↓
imagen
 ↓
contenedor
```

## Conceptos clave

- **bind mount**
- **desarrollo**
- **ruta host**
- **permisos**

## Ejemplo guiado

```bash
docker run --rm -v "$PWD/config:/app/config:ro" mi-app
```

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.



## Relación con otras tecnologías

Bind mounts son útiles en desarrollo porque reflejan archivos del host; para datos gestionados por Docker suelen preferirse volúmenes.

A lo largo de la ruta utilizaremos estas relaciones de forma recurrente:

```text
Java/Spring → Maven → WAR/JAR
Angular     → npm   → dist/
PostgreSQL  → datos persistentes
Docker      → imágenes + redes + volúmenes
Git         → fuentes y configuración
CI/CD       → automatización
```

## Ejercicios propuestos

1. Monta un archivo de configuración como solo lectura.
2. Compara un bind mount y un named volume en una tabla.

### Ejercicio de diagnóstico

Escribe qué comando o evidencia utilizarías para responder:

- ¿el contenedor existe?
- ¿está ejecutándose?
- ¿qué imagen utiliza?
- ¿qué puertos publica?
- ¿qué logs ha producido?
- ¿qué configuración debería quedar en Git y cuál no?



## Qué debes recordar

- Una **imagen** describe un artefacto ejecutable; un **contenedor** es una instancia.
- La configuración que deba reproducirse debe quedar declarada, no aplicada manualmente.
- Los datos persistentes necesitan volúmenes o almacenamiento externo.
- Git conserva recetas y código; un registry conserva imágenes.
- CI valida y construye; CD promociona o despliega versiones.

<div class="cla-lesson-nav">
  <a href="/docker/leccion27/">← 27 · Volúmenes</a>
  <a href="/docker/leccion29/">29 · Comunicación entre contenedores →</a>
</div>
