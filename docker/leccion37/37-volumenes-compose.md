---
layout: lesson
route: docker
lesson_id: leccion37
lesson_file: 37-volumenes-compose
lesson_number: "37"
title: Volúmenes con Compose
description: Declara persistencia de PostgreSQL de forma reproducible.
permalink: /docker/leccion37/
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
# Volúmenes con Compose

Declara persistencia de PostgreSQL de forma reproducible.

## Qué vas a conseguir

- Comprender **volumes**.
- Comprender **named volume**.
- Comprender **db data**.
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

- **volumes**
- **named volume**
- **db data**

## Ejemplo guiado

Guarda este ejemplo completo como `compose.yaml` en una carpeta de práctica. En este paso solo levantamos PostgreSQL; añadir backend y frontend requiere sus propios Dockerfiles y configuración de conexión.

```yaml
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_USER: tasks
      POSTGRES_DB: tasks
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD:?Define POSTGRES_PASSWORD}
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U tasks -d tasks"]
      interval: 5s
      timeout: 3s
      retries: 10
volumes:
  pgdata:
```

Define `POSTGRES_PASSWORD` en el entorno de tu terminal o en un `.env` local excluido de Git. Es necesaria para inicializar un volumen vacío; cambiarla después no modifica automáticamente la contraseña de una base existente. No se publica ningún puerto al host: las comprobaciones se ejecutan dentro del servicio.

```bash
docker compose config --quiet
docker compose up -d --wait
docker compose exec db psql -U tasks -d tasks -c 'SELECT current_database();'
```

La consulta debe devolver `tasks`. Para comprobar persistencia, crea un dato de prueba:

```bash
docker compose exec db psql -U tasks -d tasks -c "CREATE TABLE IF NOT EXISTS prueba (id integer PRIMARY KEY); INSERT INTO prueba VALUES (1) ON CONFLICT DO NOTHING;"
docker compose down
docker compose up -d --wait
docker compose exec db psql -U tasks -d tasks -c 'SELECT * FROM prueba;'
```

Debe conservarse la fila `1`. `down` conserva el volumen nombrado; `down -v` lo elimina y pierde sus datos, por lo que esta última variante se reserva a entornos desechables.

Referencia: [imagen oficial PostgreSQL](https://hub.docker.com/_/postgres/).


## Relación con otras tecnologías

La definición del volumen está versionada, pero los datos concretos no están en Git.

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

1. Añade un volumen a PostgreSQL.
2. Recrea servicios con `docker compose down` y comprueba los datos; después prueba `down -v` en un entorno desechable.

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
  <a href="/docker/leccion36/">← 36 · Variables de entorno</a>
  <a href="/docker/leccion38/">38 · Redes con Compose →</a>
</div>
