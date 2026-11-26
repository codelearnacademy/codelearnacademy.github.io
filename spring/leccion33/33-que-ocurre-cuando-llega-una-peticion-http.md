---
layout: lesson
route: spring
lesson_id: leccion33
lesson_file: 33-que-ocurre-cuando-llega-una-peticion-http
lesson_number: "33"
title: Qué ocurre cuando llega una petición HTTP
description: Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.
permalink: /spring/leccion33/
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
  - id: qué-debes-recordar
    title: Qué debes recordar
---

<link rel="stylesheet" href='{{ "/assets/css/academy.css" | relative_url }}'>
# Qué ocurre cuando llega una petición HTTP

Construye APIs HTTP con Spring MVC comprendiendo el recorrido completo de una petición.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Qué ocurre cuando llega una petición HTTP** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Spring MVC y construcción de APIs REST.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Cliente: Envía HTTP. Spring MVC: Encuentra el controlador. Respuesta: Devuelve estado y cuerpo.]({{ "/assets/images/spring/33-que-ocurre-cuando-llega-una-peticion-http.webp" | relative_url }})

## Ejemplo guiado

```text
HTTP request
   ↓
Tomcat
   ↓
DispatcherServlet
   ↓
Controller
   ↓
Service
   ↓
Repository
```



## Relación con el resto de la ruta

Angular, JavaScript, apps móviles u otros clientes solo ven HTTP/JSON; el diseño del contrato API debe ser independiente del frontend.



## Ejemplo adicional: aplicación práctica

```http
GET /api/tareas/7 HTTP/1.1
Host: localhost:8080
Accept: application/json

HTTP/1.1 200 OK
Content-Type: application/json
```

Identifica la ruta, el verbo, el controlador y el cuerpo de la respuesta.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

<div class="cla-lesson-nav">
  <a href="{{ '/spring/leccion111/' | relative_url }}">111 · Diseño de servicios REST</a>
</div>

## Ejercicios propuestos

1. Implementa en una API de tareas un endpoint que demuestre **Qué ocurre cuando llega una petición HTTP**.
2. Prueba una petición correcta y otra incorrecta con `curl -i` y compara código HTTP y cuerpo de respuesta.
3. Añade una prueba de Spring MVC para validar el contrato HTTP sin depender de la base de datos.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Qué ocurre cuando llega una petición HTTP** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion32/">← 32 · Profiles</a>
  <a href="/spring/leccion34/">34 · @Controller frente a @RestController →</a>
</div>
