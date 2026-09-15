---
layout: lesson
route: software
lesson_id: leccion01
lesson_file: 01-que-es-el-software
lesson_number: "01"
title: Qué es el software
description: Comprender qué es el software y por qué un producto software incluye código, datos, configuración y documentación.
permalink: /software/leccion01/
lessons:
  - id: qué-vas-a-conseguir
    title: Qué vas a conseguir
  - id: punto-de-partida
    title: Punto de partida
  - id: conceptos-clave
    title: Conceptos clave
  - id: desarrollo
    title: Desarrollo
  - id: ejemplo-guiado
    title: Ejemplo guiado
  - id: relación-con-otras-rutas
    title: Relación con otras rutas
  - id: ejercicios-propuestos
    title: Ejercicios propuestos
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# Qué es el software

## Qué vas a conseguir

Comprender qué es el software y por qué un producto software incluye código, datos, configuración y documentación.

## Punto de partida

CodeTasks es el caso ficticio de esta ruta: una aplicación para que estudiantes organicen tareas y fechas de entrega. Un archivo de código aislado no permite utilizarla ni mantenerla.

## Conceptos clave

- **Programa:** instrucciones que ejecuta un ordenador.
- **Datos:** información que el programa procesa.
- **Configuración:** valores que adaptan su funcionamiento al entorno.
- **Documentación:** información para utilizar, operar y modificar el sistema.

## Desarrollo

El software comprende programas y elementos asociados necesarios para su funcionamiento y mantenimiento. Conviene distinguir el programa del producto entregado: este puede incluir instaladores, configuración inicial, documentación y procedimientos de recuperación.

Los usuarios interactúan con el software, pero no son componentes del software. Tampoco lo son el ordenador o la red física: forman parte de su entorno. Esta distinción ayuda a localizar problemas: una aplicación puede estar bien programada y fallar porque utiliza una configuración equivocada.

## Ejemplo guiado

Para entregar CodeTasks identificamos cinco piezas: el programa que guarda tareas, los registros de tareas, la dirección de la base de datos, las instrucciones de instalación y las pruebas que comprueban el comportamiento. Los estudiantes son usuarios; el servidor es infraestructura. Si solo copiamos el programa y omitimos la configuración, la entrega puede no funcionar.

## Relación con otras rutas

Git permite versionar código y documentación; Ficheros permite trabajar con datos y configuración. No guardes contraseñas reales en el repositorio.

## Ejercicios propuestos

1. Clasifica un archivo de tareas, un manual, un portátil y una variable de configuración.
2. Prepara una lista de lo necesario para instalar CodeTasks en otro equipo.
3. Explica qué comprobarías si el programa funciona en tu equipo pero no en el de otra persona.

## Qué debes recordar

El programa es una parte de la entrega. Datos, configuración y documentación deben gestionarse junto con él; personas y equipos pertenecen al contexto.

<div class="cla-lesson-nav">
  <span></span>
  <a href="{{ '/software/leccion02/' | relative_url }}">02 · Tipos de software →</a>
</div>
