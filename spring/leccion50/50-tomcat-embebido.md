---
layout: lesson
route: spring
lesson_id: leccion50
lesson_file: 50-tomcat-embebido
lesson_number: "50"
title: Tomcat embebido
description: Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.
permalink: /spring/leccion50/
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
# Tomcat embebido

Comprende el papel de Tomcat, el servidor embebido y el despliegue tradicional mediante WAR.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Tomcat embebido** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Tomcat y empaquetado.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Proceso Boot: Arranca desde main. Tomcat embebido: Se ejecuta en el mismo proceso. Cliente: Comprueba el puerto.]({{ "/assets/images/spring/47-tomcat-embebido.webp" | relative_url }})

## Ejemplo guiado

Con Boot MVC:

```text
java -jar app.jar
   ↓
Spring Boot inicia Tomcat embebido
   ↓
puerto 8080
```



## Relación con el resto de la ruta

Tomcat implementa el runtime Servlet. Docker puede contener un JAR Boot con Tomcat embebido o un WAR dentro de Tomcat externo.



## Ejemplo adicional: aplicación práctica

```properties
server.port=8090
server.servlet.context-path=/gestion
```

Comprueba ahora el recurso bajo /gestion/api/tareas.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Explica cómo interviene **Tomcat embebido** cuando arranca una aplicación Spring Boot.
2. Empaqueta la aplicación y comprueba si puede ejecutarse mediante `java -jar` o si necesita un contenedor externo.
3. Compara qué responsabilidad asume el servidor web y qué responsabilidad conserva Spring MVC.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Tomcat embebido** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion49/">← 49 · Qué es Tomcat</a>
  <a href="/spring/leccion51/">51 · ¿Quién arranca a quién? →</a>
</div>
