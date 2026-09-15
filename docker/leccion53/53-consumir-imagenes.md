---
layout: lesson
route: docker
lesson_id: leccion53
lesson_file: 53-consumir-imagenes
lesson_number: "53"
title: Consumir imágenes publicadas
description: Despliega una versión sin necesitar el código fuente ni el toolchain de compilación.
permalink: /docker/leccion53/
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
# Consumir imágenes publicadas

Despliega una versión sin necesitar el código fuente ni el toolchain de compilación.

## Qué vas a conseguir

- Comprender **docker pull**.
- Comprender **immutable artifact**.
- Comprender **runtime host**.
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

- **docker pull**
- **immutable artifact**
- **runtime host**

## Ejemplo guiado

```bash
docker pull ghcr.io/organizacion/tasks-backend:1.0.0
docker run ...
```

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.



## Relación con otras tecnologías

Esta separación es clave en CD: el servidor de destino consume artefactos ya construidos y probados.

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

1. Ejecuta una imagen desde un equipo que no tenga Maven.
2. Explica qué software mínimo necesita ese host.

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
  <a href="/docker/leccion52/">← 52 · Publicar imágenes</a>
  <a href="/docker/leccion54/">54 · Docker en integración continua →</a>
</div>
