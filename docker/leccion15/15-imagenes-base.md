---
layout: lesson
route: docker
lesson_id: leccion15
lesson_file: 15-imagenes-base
lesson_number: "15"
title: Imágenes base
description: Selecciona imágenes base entendiendo compatibilidad, tamaño y responsabilidad.
permalink: /docker/leccion15/
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
# Imágenes base

Selecciona imágenes base entendiendo compatibilidad, tamaño y responsabilidad.

## Qué vas a conseguir

- Comprender **base image**.
- Comprender **JDK**.
- Comprender **JRE**.
- Comprender **distribución**.
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

- **base image**
- **JDK**
- **JRE**
- **distribución**
- **cadena de confianza**

## Ejemplo guiado

Compara una imagen de JDK con una de runtime:

```text
Build → necesita compilador
Runtime → normalmente solo necesita ejecutar
```

Usaremos JDK en una etapa de construcción y un runtime más pequeño en la etapa final.

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.



## Relación con otras tecnologías

Este principio se parece a separar `devDependencies` y runtime en Node o dependencias de desarrollo y producción en Python.

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

1. Explica por qué no siempre conviene ejecutar producción con una imagen de JDK completa.
2. Investiga qué runtime necesita tu aplicación concreta.

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
  <a href="/docker/leccion14/">← 14 · Anatomía de un Dockerfile</a>
  <a href="/docker/leccion16/">16 · COPY y contexto de construcción →</a>
</div>
