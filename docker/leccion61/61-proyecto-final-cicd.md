---
layout: lesson
route: docker
lesson_id: leccion61
lesson_file: 61-proyecto-final-cicd
lesson_number: "61"
title: Proyecto final · Plataforma Java + Spring + Angular + PostgreSQL con CI/CD
description: Integra Docker, Maven, Git, Angular, Tomcat, PostgreSQL, registries y CI/CD en un sistema reproducible.
permalink: /docker/leccion61/
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
  - id: proyecto-integrador
    title: Proyecto integrador
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Proyecto final · Plataforma Java + Spring + Angular + PostgreSQL con CI/CD

Integra Docker, Maven, Git, Angular, Tomcat, PostgreSQL, registries y CI/CD en un sistema reproducible.

## Qué vas a conseguir

- Comprender **Spring WAR**.
- Comprender **Tomcat**.
- Comprender **PostgreSQL**.
- Comprender **Angular**.
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

- **Spring WAR**
- **Tomcat**
- **PostgreSQL**
- **Angular**
- **Nginx**
- **Docker Compose**
- **CI/CD**

## Ejemplo guiado

Arquitectura:

```text
Usuario
  ↓
Nginx + Angular
  ├── archivos estáticos
  └── /api → Tomcat + Spring WAR
                    ↓
                PostgreSQL
                    ↓
                 volumen
```

El pipeline construirá, probará y publicará imágenes; el proceso de CD desplegará una versión aprobada mediante Docker Compose.

### Comprobación

Después del ejemplo:

1. Consulta el estado con `docker ps -a` o el comando adecuado.
2. Revisa logs si existe un proceso en ejecución.
3. Comprueba qué recursos nuevos se han creado.
4. Explica qué parte sería necesario versionar en Git.
5. Si el ejercicio modifica infraestructura, intenta recrearla desde cero.


## Arquitectura objetivo

Construiremos una aplicación con cuatro responsabilidades separadas:

```text
                         Internet / navegador
                                │
                                ▼
                    ┌──────────────────────┐
                    │ frontend             │
                    │ Nginx + Angular      │
                    │ puerto 80/443        │
                    └──────────┬───────────┘
                               │ /api
                               ▼
                    ┌──────────────────────┐
                    │ backend              │
                    │ Tomcat + Spring WAR  │
                    │ Java 21              │
                    └──────────┬───────────┘
                               │ JDBC
                               ▼
                    ┌──────────────────────┐
                    │ db                   │
                    │ PostgreSQL           │
                    └──────────┬───────────┘
                               │
                               ▼
                         volumen pgdata
```

> Si tu aplicación Spring Boot usa Tomcat embebido, también es válido contenerizarla como JAR. En este proyecto utilizamos **WAR + Tomcat externo** para practicar explícitamente el servidor de aplicaciones.

## Estructura del repositorio

```text
codelearn-platform/
├── backend/
│   ├── pom.xml
│   ├── mvnw
│   ├── .mvn/
│   ├── Dockerfile
│   └── src/
├── frontend/
│   ├── package.json
│   ├── package-lock.json
│   ├── Dockerfile
│   ├── nginx.conf
│   └── src/
├── infra/
│   ├── compose.yml
│   ├── compose.prod.yml
│   └── .env.example
├── .github/workflows/
│   └── ci-cd.yml
├── .gitignore
├── .dockerignore
└── README.md
```

## Backend · Spring empaquetado como WAR

El `pom.xml` debe producir un WAR:

```xml
<packaging>war</packaging>
```

Para Spring Boot con Tomcat externo, el proyecto debe configurar el servlet initializer correspondiente y evitar empaquetar el servidor como runtime embebido cuando proceda.

La etapa de Docker puede separar build y runtime:

```dockerfile
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn clean verify package

FROM tomcat:10.1-jdk21-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /workspace/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
```

> Las etiquetas exactas disponibles de imágenes pueden cambiar con el tiempo; valida la variante del registry que uses en tu entorno.

## Frontend · Angular construido con Node y servido por Nginx

```dockerfile
FROM node:22-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/ /usr/share/nginx/html/
EXPOSE 80
```

El `nginx.conf` puede servir Angular y reenviar `/api`:

```nginx
server {
    listen 80;
    server_name _;

    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }

    location /api/ {
        proxy_pass http://backend:8080/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

Ajusta la ruta concreta de `dist/` según la versión/configuración de Angular.

## PostgreSQL

El servicio debe mantener los datos en un volumen y recibir la configuración desde variables:

```yaml
db:
  image: postgres:16
  environment:
    POSTGRES_DB: tasks
    POSTGRES_USER: tasks
    POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
  volumes:
    - pgdata:/var/lib/postgresql/data
  healthcheck:
    test: ["CMD-SHELL", "pg_isready -U tasks -d tasks"]
    interval: 10s
    timeout: 5s
    retries: 5
```

## Docker Compose

Una versión educativa del stack:

```yaml
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_DB: tasks
      POSTGRES_USER: tasks
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U tasks -d tasks"]
      interval: 10s
      timeout: 5s
      retries: 5

  backend:
    build: ../backend
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tasks
      SPRING_DATASOURCE_USERNAME: tasks
      SPRING_DATASOURCE_PASSWORD: ${POSTGRES_PASSWORD}
    depends_on:
      db:
        condition: service_healthy

  frontend:
    build: ../frontend
    ports:
      - "8080:80"
    depends_on:
      - backend

volumes:
  pgdata:
```

Con este diseño solo necesitamos publicar el frontend. Backend y PostgreSQL pueden permanecer en la red interna.

## Hito 1 · Desarrollo local reproducible

El alumno debe poder ejecutar:

```bash
cp infra/.env.example infra/.env
docker compose -f infra/compose.yml up --build
```

y acceder a:

```text
http://localhost:8080
```

sin instalar PostgreSQL, Tomcat o Nginx en el host.

## Hito 2 · Pruebas

Backend:

```bash
cd backend
./mvnw clean verify
```

Frontend:

```bash
cd frontend
npm ci
npm test -- --watch=false
npm run build
```

Adapta el comando de test a la configuración Angular utilizada.

## Hito 3 · Git

Trabaja mediante ramas:

```text
feature/backend-tasks
feature/frontend-tasks
feature/docker-backend
feature/docker-frontend
feature/postgres
feature/compose
feature/ci
feature/cd
```

Antes de fusionar una rama:

```text
tests → build → docker build → ejecución local
```

## Hito 4 · Integración continua

El pipeline debe:

```text
checkout
  ↓
test backend
  ↓
test/build frontend
  ↓
build imagen backend
  ↓
build imagen frontend
```

Ninguna imagen de release se publica si fallan las pruebas.

## Hito 5 · Registry

Al crear una release `v1.0.0`, publicar:

```text
registry.example/codelearn/tasks-backend:1.0.0
registry.example/codelearn/tasks-frontend:1.0.0
```

También puedes publicar un tag adicional controlado como `1.0` o `stable`.

## Hito 6 · Entrega continua / despliegue continuo

Para un entorno docente sencillo, el servidor de destino puede tener:

```text
Linux
Docker Engine
Docker Compose plugin
```

El CD puede conectarse por SSH o utilizar un runner instalado en el servidor. El proceso conceptual:

```text
release v1.0.0
    ↓
CI valida
    ↓
build + push imágenes
    ↓
servidor hace docker compose pull
    ↓
docker compose up -d
    ↓
healthchecks
```

No guardes claves SSH, contraseñas de PostgreSQL ni tokens del registry en Git. Utiliza secretos del sistema CI.

## Hito 7 · Despliegue usando imágenes publicadas

`compose.prod.yml` no construye código:

```yaml
services:
  db:
    image: postgres:16
    # ...

  backend:
    image: ${REGISTRY}/tasks-backend:${APP_VERSION}
    # ...

  frontend:
    image: ${REGISTRY}/tasks-frontend:${APP_VERSION}
    # ...
```

Esto separa correctamente:

```text
CI → construir una vez
CD → desplegar el mismo artefacto
```

## Hito 8 · Rollback básico

Si `1.1.0` falla, cambia:

```text
APP_VERSION=1.0.0
```

y vuelve a ejecutar:

```bash
docker compose -f infra/compose.prod.yml pull
docker compose -f infra/compose.prod.yml up -d
```

El objetivo es comprender que una versión anterior sigue disponible como imagen inmutable.

## Criterios de entrega

El proyecto se considera terminado cuando:

- el repositorio se puede clonar desde cero;
- backend supera `./mvnw clean verify`;
- frontend supera sus pruebas y build;
- `docker compose up --build` inicia el entorno completo;
- Angular consume la API Spring a través del proxy;
- Spring se conecta a PostgreSQL por nombre de servicio;
- PostgreSQL conserva datos tras recrear los contenedores;
- los secretos no están versionados;
- CI falla si fallan pruebas;
- una release publica imágenes versionadas;
- CD puede desplegar una versión concreta;
- existe un procedimiento documentado de rollback;
- el README explica arquitectura, build, ejecución y despliegue.


## Relación con otras tecnologías

El proyecto conecta todas las rutas: Git versiona; Maven construye Spring; npm construye Angular; Docker empaqueta; registry distribuye; CI valida; CD despliega.

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

1. Completa el proyecto siguiendo los hitos de la lección.
2. Realiza una release `v1.0.0`, despliega y demuestra persistencia, healthchecks y rollback básico.

### Ejercicio de diagnóstico

Escribe qué comando o evidencia utilizarías para responder:

- ¿el contenedor existe?
- ¿está ejecutándose?
- ¿qué imagen utiliza?
- ¿qué puertos publica?
- ¿qué logs ha producido?
- ¿qué configuración debería quedar en Git y cuál no?

## Proyecto integrador

Esta es la lección final. El proyecto combina todas las piezas de la ruta y debe entregarse como un repositorio reproducible y documentado.


## Qué debes recordar

- Una **imagen** describe un artefacto ejecutable; un **contenedor** es una instancia.
- La configuración que deba reproducirse debe quedar declarada, no aplicada manualmente.
- Los datos persistentes necesitan volúmenes o almacenamiento externo.
- Git conserva recetas y código; un registry conserva imágenes.
- CI valida y construye; CD promociona o despliega versiones.

<div class="cla-lesson-nav">
  <a href="/docker/leccion60/">← 60 · Docker y Kubernetes</a>
  <a href="/spring/">Continuar con Spring / despliegue →</a>
</div>
