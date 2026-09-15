---
layout: lesson
route: docker
lesson_id: leccion40
lesson_file: 40-logs
lesson_number: "40"
title: Logs
description: Usa logs como primera fuente de diagnóstico de un contenedor.
permalink: /docker/leccion40/
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
# Logs

Usa logs como primera fuente de diagnóstico de un contenedor.

## Qué vas a conseguir

- Comprender **stdout**.
- Comprender **stderr**.
- Comprender **docker logs**.
- Comprender **compose logs**.
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

- **stdout**
- **stderr**
- **docker logs**
- **compose logs**

## Ejemplo guiado

```bash
docker logs -f backend
docker compose logs --tail=100 -f
```

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.

## Orden de diagnóstico recomendado

Cuando un servicio no funciona, evita empezar reconstruyendo todo. Primero pregunta:

```text
¿está running?
¿qué dicen los logs?
¿qué configuración recibió?
¿resuelve el nombre de servicio?
¿el puerto correcto está escuchando?
```


## Relación con otras tecnologías

En CI/CD los logs también son la primera evidencia cuando un build o despliegue falla.

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

1. Provoca un error de conexión a base de datos y localízalo en logs.
2. Distingue un fallo de aplicación de uno de Docker.

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
  <a href="/docker/leccion39/">← 39 · Operaciones con Compose</a>
  <a href="/docker/leccion41/">41 · Ejecutar comandos dentro de un contenedor →</a>
</div>
