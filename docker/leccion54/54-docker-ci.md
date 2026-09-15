---
layout: lesson
route: docker
lesson_id: leccion54
lesson_file: 54-docker-ci
lesson_number: "54"
title: Docker en integración continua
description: Añade construcción de imágenes al pipeline después de las pruebas.
permalink: /docker/leccion54/
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
# Docker en integración continua

Añade construcción de imágenes al pipeline después de las pruebas.

## Qué vas a conseguir

- Comprender **CI**.
- Comprender **docker build**.
- Comprender **quality gate**.
- Comprender **pipeline**.
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

- **CI**
- **docker build**
- **quality gate**
- **pipeline**

## Ejemplo guiado

```text
checkout
  ↓
tests
  ↓
docker build backend
  ↓
docker build frontend
```

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.

## CI y CD no son lo mismo

**CI (Continuous Integration)** valida e integra cambios de forma frecuente.

**CD** puede referirse a *Continuous Delivery* o *Continuous Deployment*:

- **Delivery:** el sistema deja una versión preparada para desplegar, normalmente con una aprobación.
- **Deployment:** la versión válida se despliega automáticamente.

En el proyecto final puedes usar aprobación manual para producción y despliegue automático en un entorno de pruebas.


## Relación con otras tecnologías

CI valida cada cambio. CD usa artefactos aprobados para desplegar entornos.

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

1. Diseña un pipeline que no construya imágenes si fallan las pruebas.
2. Explica por qué el orden importa.

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
  <a href="/docker/leccion53/">← 53 · Consumir imágenes publicadas</a>
  <a href="/docker/leccion55/">55 · Maven + Docker + CI →</a>
</div>
