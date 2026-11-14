---
layout: lesson
route: spring
lesson_id: leccion98
lesson_file: 98-publicar-en-un-registry
lesson_number: "98"
title: Publicar en un registry
description: Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.
permalink: /spring/leccion98/
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
# Publicar en un registry

Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **Publicar en un registry** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Git, integración y despliegue continuos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Imagen: Etiqueta la versión. Registry: Recibe la publicación. Verificar: Comprueba la referencia.]({{ "/assets/images/spring/98-publicar-en-un-registry.webp" | relative_url }})

## Ejemplo guiado

Publica:

```text
ghcr.io/organizacion/tasks-api:1.0.0
```



## Relación con el resto de la ruta

Git conserva el cambio; CI lo verifica; un registry conserva la imagen; CD despliega una versión inmutable.



## Ejemplo adicional: aplicación práctica

```bash
docker tag gestor-tareas:local ejemplo/gestor-tareas:1.0.0
docker push ejemplo/gestor-tareas:1.0.0
```

Sustituye el namespace por el del registro real y autentícate previamente.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Incorpora **Publicar en un registry** a un flujo de construcción automatizado.
2. Ejecuta las pruebas y comprueba que un fallo provoca un estado de pipeline fallido.
3. Documenta cómo identificar la versión desplegada y cómo volver a una versión anterior.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **Publicar en un registry** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion97/">← 97 · Construcción de imagen</a>
  <a href="/spring/leccion99/">99 · CD: desplegar una versión →</a>
</div>
