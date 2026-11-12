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

Al terminar esta lección podrás:

- Explicar **Proyecto final · Plataforma de gestión de tareas** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Proyecto integrador.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

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


### Requisitos de arquitectura

Usa clases Java normales para los DTO y modelos. Separa `TaskEntity` (persistencia), `Task` (modelo), `TaskMapper` (conversión), `TaskRepository` (JPA), `TaskService` (reglas de negocio) y `TaskController` (HTTP). Cada operación debe documentar su tipo de retorno y el comportamiento ante ausencia de datos.

La evaluación se basará en resultados observables: listas vacías, operaciones CRUD, manejo de errores, pruebas de relaciones y persistencia, y documentación de la API.

## Relación con el resto de la ruta

El objetivo es conectar Java, Maven, Spring, PostgreSQL, Git, Docker, Angular y CI/CD como un único flujo reproducible.



## Ejemplo adicional: aplicación práctica

```bash
# Comprobación final del backend
./mvnw clean verify
./mvnw spring-boot:run
curl -i http://localhost:8080/api/tareas
# Comprobación de contenedores
docker compose config
docker compose up --build -d
```

Documenta los valores reales de los endpoints, variables y servicios de tu entrega.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Diseña las entidades, modelos, mappers, DTO, servicios, controladores y repositorios de la plataforma de tareas.
2. Implementa CRUD y filtros con pruebas unitarias, MVC y de integración; entrega datos y resultados esperados.
3. Prepara perfiles, migraciones, imágenes y un flujo CI que permita reproducir la aplicación desde cero.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Proyecto final · Plataforma de gestión de tareas** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion106/">← 106 · Spring MVC frente a WebFlux</a>
  <a href="/docker/">Continuar con Docker / despliegue →</a>
</div>
