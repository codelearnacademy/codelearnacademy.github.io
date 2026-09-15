---
layout: lesson
route: docker
lesson_id: leccion13
lesson_file: 13-primer-dockerfile
lesson_number: "13"
title: Primer Dockerfile
description: Construye una imagen propia a partir de un artefacto Java.
permalink: /docker/leccion13/
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
# Primer Dockerfile

Construye una imagen propia a partir de un artefacto Java.

## Qué vas a conseguir

- Comprender **Dockerfile**.
- Comprender **FROM**.
- Comprender **COPY**.
- Comprender **CMD**.
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

- **Dockerfile**
- **FROM**
- **COPY**
- **CMD**
- **docker build**

## Ejemplo guiado

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/app.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

```bash
docker build -t codelearn/app:1.0.0 .
```

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.

## Práctica acumulativa

A partir de esta lección conserva un pequeño proyecto `docker-lab`. En cada lección añade un commit. Al llegar a Compose tendrás un historial que mostrará cómo ha evolucionado la infraestructura.


## Relación con otras tecnologías

Aquí conectamos Maven y Docker: Maven produce el JAR; Docker empaqueta el JAR con el runtime necesario para ejecutarlo.

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

1. Crea un Dockerfile equivalente para un JAR de tu proyecto.
2. Construye la imagen y ejecuta el contenedor.

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
  <a href="/docker/leccion12/">← 12 · Tags y versiones</a>
  <a href="/docker/leccion14/">14 · Anatomía de un Dockerfile →</a>
</div>
