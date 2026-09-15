---
layout: lesson
route: spring
lesson_id: leccion107
lesson_file: 107-proyecto-final-plataforma-de-gestion-de-tareas
lesson_number: "107"
title: Proyecto final · Plataforma de gestión de tareas
description: Integra Spring Boot, Tomcat, PostgreSQL, Angular, Docker, Git y CI/CD en una entrega reproducible.
permalink: /spring/leccion107/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-el-resto-de-la-ruta
    title: Relación con el resto de la ruta
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: proyecto-integrador
    title: Proyecto integrador
  - id: qué-debes-recordar
    title: Qué debes recordar
---
# Proyecto final · Plataforma de gestión de tareas

Integra Spring Boot, Tomcat, PostgreSQL, Angular, Docker, Git y CI/CD en una entrega reproducible.

## Qué vas a conseguir

- Comprender el concepto de **Proyecto final · Plataforma de gestión de tareas**.
- Aplicarlo sobre una aplicación Java/Spring pequeña.
- Relacionarlo con Maven, Tomcat, PostgreSQL, Git o Docker cuando corresponda.
- Diferenciar qué responsabilidad pertenece a Spring Framework y cuál a Spring Boot.

<div class="cla-note"><strong>Ruta de estudio</strong><p>La prioridad es comprender el modelo mental. No avances solo porque el proyecto compila: debes poder explicar quién crea los objetos, quién resuelve las bibliotecas, quién atiende HTTP y qué parte se ejecuta dentro del contenedor.</p></div>

## Punto de partida

Esta lección pertenece al bloque **Proyecto final**.

Mantén este mapa durante toda la ruta:

```text
Maven
  ↓ bibliotecas y build
Spring Framework
  ↓ objetos, IoC, MVC, transacciones...
Spring Boot
  ↓ auto-configuración + aplicación ejecutable
Tomcat
  ↓ runtime Servlet / HTTP
PostgreSQL
  ↓ persistencia
Docker
  ↓ entorno reproducible
Git + CI/CD
  ↓ versionado, verificación y entrega
```

## Conceptos clave

- **arquitectura**
- **Spring Boot**
- **Docker**
- **CI/CD**

## Ejemplo guiado

Proyecto integrador:

```text
Angular/Nginx
      ↓ REST
Spring Boot
Controller → Service → Repository
      ↓
PostgreSQL
      ↓
Flyway

Git → CI → imagen Docker → registry → CD
```


## Proyecto integrador

### Arquitectura

```text
Navegador
   ↓
Angular + Nginx
   ↓ /api
Spring Boot 4.1.x
   ├── Controller
   ├── DTO + Validation
   ├── Service
   ├── Security
   ├── Repository
   └── Actuator
          ↓
      PostgreSQL
          ↓
        Flyway
```

Infraestructura:

```text
Git
 ↓
Pull Request
 ↓
CI: backend + frontend
 ↓
Docker images
 ↓
Registry
 ↓
CD
 ↓
Docker Compose
```

### Requisitos funcionales

La aplicación permitirá:

1. Crear usuarios.
2. Crear tareas.
3. Listar tareas.
4. Filtrar por estado.
5. Completar tareas.
6. Eliminar tareas.
7. Organizar tareas por categoría.
8. Proteger operaciones según el usuario autenticado.

### Backend

Estructura recomendada:

```text
backend/
├── pom.xml
├── mvnw
├── .mvn/
└── src/
    ├── main/
    │   ├── java/com/codelearn/tasks/
    │   │   ├── api/
    │   │   ├── service/
    │   │   ├── persistence/
    │   │   ├── security/
    │   │   └── config/
    │   └── resources/
    │       └── db/migration/
    └── test/
```

### Dos formas de ejecutar Spring

Debes demostrar ambas:

```text
A) JAR Spring Boot
java -jar app.jar
→ Boot arranca Tomcat embebido

B) WAR tradicional
Tomcat externo
→ despliega ROOT.war
→ arranca Spring
```

### Persistencia

PostgreSQL debe ejecutarse en contenedor y el esquema debe evolucionar con Flyway:

```text
V1__create_users.sql
V2__create_tasks.sql
V3__create_categories.sql
```

No utilices `ddl-auto=create` como mecanismo de migración de producción.

### Testing

Incluye al menos:

- pruebas unitarias del Service;
- pruebas MVC;
- pruebas del Repository;
- una prueba de integración con PostgreSQL mediante Testcontainers.

### Docker

Debes proporcionar:

```text
Dockerfile.boot
Dockerfile.war
compose.yml
```

`compose.yml` debe levantar:

```text
frontend
backend
postgres
```

### CI

El pipeline debe ejecutar:

```bash
./mvnw clean verify
```

y las pruebas/build de Angular antes de construir imágenes.

### CD

Una release `v1.0.0` debe producir imágenes versionadas y permitir:

```bash
docker compose pull
docker compose up -d
```

en el servidor de destino.

### Criterio de finalización

Otra persona debe poder clonar el repositorio, configurar únicamente secretos/variables de entorno y reproducir el entorno sin instalar manualmente PostgreSQL o Tomcat.


## Relación con el resto de la ruta

El objetivo es conectar Java, Maven, Spring, PostgreSQL, Git, Docker, Angular y CI/CD como un único flujo reproducible.

Cuando utilices una anotación o dependencia, intenta responder siempre:

```text
¿Quién la proporciona?
¿Quién la interpreta?
¿Cuándo actúa?
¿Está relacionada con build, runtime, HTTP, datos o infraestructura?
```

## Ejercicios propuestos

1. Reproduce el ejemplo de **Proyecto final · Plataforma de gestión de tareas** y documenta qué cambia en el proyecto.
2. Introduce una variación controlada, predice el resultado antes de ejecutarla y comprueba si tu predicción era correcta.
3. Explica qué responsabilidad corresponde a Spring, cuál a Spring Boot y cuál a Maven/Git/Docker en este escenario.

### Ejercicio de explicación

Sin ejecutar código, explica a otra persona:

- qué problema resuelve esta lección;
- qué ocurriría si eliminases la configuración o dependencia principal;
- cómo comprobarías el comportamiento con una prueba;
- si el concepto pertenece a Spring Framework, Spring Boot o a otra herramienta.

## Qué debes recordar

- **Maven** resuelve dependencias y construye; no realiza inyección de objetos.
- **Spring Framework** contiene el contenedor IoC y los módulos fundamentales.
- **Spring Boot** se apoya en Spring Framework y reduce configuración repetitiva.
- **Tomcat** participa en el stack Servlet, embebido o como servidor externo.
- El código debe poder probarse y construirse antes de empaquetarlo con Docker.

<div class="cla-lesson-nav">
  <a href="/spring/leccion106/">← 106 · Spring MVC frente a WebFlux</a>
  <a href="/docker/">Continuar con Docker / despliegue →</a>
</div>
