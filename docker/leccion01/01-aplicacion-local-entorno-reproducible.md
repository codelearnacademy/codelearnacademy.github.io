---
layout: lesson
route: docker
lesson_id: leccion01
lesson_file: 01-aplicacion-local-entorno-reproducible
lesson_number: "01"
title: De una aplicación local a un entorno reproducible
description: Comprende por qué los entornos diferentes provocan fallos y qué significa hacer reproducible una aplicación.
permalink: /docker/leccion01/
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
# De una aplicación local a un entorno reproducible

Comprende por qué los entornos diferentes provocan fallos y qué significa hacer reproducible una aplicación.

## Qué vas a conseguir

- Comprender **entorno de ejecución**.
- Comprender **dependencias del sistema**.
- Comprender **configuración**.
- Comprender **reproducibilidad**.
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

- **entorno de ejecución**
- **dependencias del sistema**
- **configuración**
- **reproducibilidad**

## Ejemplo guiado

Imagina una API Java que necesita Java 21 y PostgreSQL. En un equipo funciona, pero en otro hay Java 17 y PostgreSQL 14.

```text
Equipo A                  Equipo B
Java 21                   Java 17
PostgreSQL 16             PostgreSQL 14
configuración A           configuración B
```

Antes de usar Docker, anota exactamente qué tendría que instalar y configurar el segundo equipo.

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.



## Relación con otras tecnologías

Este problema aparece también con Node, Python, Go, .NET o PHP. Docker no depende del lenguaje: empaqueta el entorno necesario alrededor de cualquier proceso.

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

1. Enumera los requisitos de una aplicación Java + PostgreSQL que hayas usado.
2. Distingue qué requisitos pertenecen al código, al runtime, a la base de datos y a la configuración.

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
  <span></span>
  <a href="/docker/leccion02/">02 · Qué es un contenedor →</a>
</div>
