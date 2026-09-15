---
layout: lesson
route: docker
lesson_id: leccion02
lesson_file: 02-que-es-contenedor
lesson_number: "02"
title: Qué es un contenedor
description: Construye un modelo mental correcto de proceso, imagen y contenedor.
permalink: /docker/leccion02/
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
# Qué es un contenedor

Construye un modelo mental correcto de proceso, imagen y contenedor.

## Qué vas a conseguir

- Comprender **proceso aislado**.
- Comprender **filesystem**.
- Comprender **imagen**.
- Comprender **contenedor**.
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

- **proceso aislado**
- **filesystem**
- **imagen**
- **contenedor**

## Ejemplo guiado

```text
Imagen + configuración de ejecución
              ↓
          Contenedor
              ↓
           Proceso
```

Un contenedor no es un proyecto ni un servidor completo: es una forma aislada y reproducible de ejecutar uno o varios procesos previstos por la imagen.

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.



## Relación con otras tecnologías

Una imagen Docker se parece más a un artefacto desplegable que a una biblioteca. En Java puede contener un JAR o WAR; en Angular puede contener archivos estáticos; en PostgreSQL contiene el servidor de base de datos.

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

1. Explica con tus palabras la diferencia entre imagen y contenedor.
2. Indica qué parte es inmutable y qué parte existe durante la ejecución.

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
  <a href="/docker/leccion01/">← 01 · De una aplicación local a un entorno reproducible</a>
  <a href="/docker/leccion03/">03 · Contenedores frente a máquinas virtuales →</a>
</div>
