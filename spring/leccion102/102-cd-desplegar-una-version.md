---
layout: lesson
route: spring
lesson_id: leccion102
lesson_file: 102-cd-desplegar-una-version
lesson_number: "102"
title: "CD: desplegar una versión"
description: Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.
permalink: /spring/leccion102/
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
# CD: desplegar una versión

Integra Spring con Git, Maven, imágenes Docker, registries y despliegues automatizados.

## Qué vas a conseguir

Al terminar esta lección podrás:

- Explicar **CD: desplegar una versión** y reconocer cuándo se aplica.
- Interpretar el ejemplo guiado y señalar el resultado esperado.
- Realizar una modificación controlada y comprobarla con una ejecución o prueba.

## Punto de partida

**Bloque:** Git, integración y despliegue continuos.

Antes de empezar, revisa el ejemplo de esta lección e identifica qué parte corresponde a la aplicación y qué parte proporciona el framework o la herramienta utilizada.

## Infografía

![Versión: Selecciona la etiqueta. Servidor: Descarga y ejecuta. Verificar: Comprueba salud y versión.]({{ "/assets/images/spring/99-cd-desplegar-una-version.webp" | relative_url }})

## Ejemplo guiado

```text
tag Git v1.0.0
 ↓
CI verde
 ↓
imagen :1.0.0
 ↓
registry
 ↓
docker compose pull
 ↓
deploy
```



## Relación con el resto de la ruta

Git conserva el cambio; CI lo verifica; un registry conserva la imagen; CD despliega una versión inmutable.



## Ejemplo adicional: aplicación práctica

```bash
docker compose pull
docker compose up -d
docker compose ps
```

Comprueba el estado de servicios y la salud de la aplicación tras desplegar.

**Comprueba:** identifica qué clase, anotación o propiedad se encarga del comportamiento descrito y realiza una modificación pequeña para observar su efecto.

## Ejercicios propuestos

1. Incorpora **CD: desplegar una versión** a un flujo de construcción automatizado.
2. Ejecuta las pruebas y comprueba que un fallo provoca un estado de pipeline fallido.
3. Documenta cómo identificar la versión desplegada y cómo volver a una versión anterior.

**Evidencia de aprendizaje:** entrega el código o configuración modificada, una prueba o comando de verificación y una breve explicación del resultado.

## Qué debes recordar

- **CD: desplegar una versión** tiene una responsabilidad concreta en el diseño o ejecución de la aplicación.
- Comprueba el resultado mediante una prueba, un comando o una petición según el contenido trabajado.
- Distingue entre código de negocio, configuración y servicios aportados por Spring.

<div class="cla-lesson-nav">
  <a href="/spring/leccion101/">← 101 · Publicar en un registry</a>
  <a href="/spring/leccion103/">103 · AOP →</a>
</div>
