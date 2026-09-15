---
layout: lesson
route: git
lesson_id: leccion05
lesson_number: "05"
title: "Commits y construcción del historial"
description: "Aprende a crear commits pequeños, escribir mensajes útiles y consultar el historial del proyecto."
permalink: /git/leccion05/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: mensajes-de-commit
    title: "Mensajes de commit"
  - id: commits-pequeños-y-coherentes
    title: "Commits pequeños y coherentes"
  - id: consultar-el-historial-de-forma-compacta
    title: "Consultar el historial de forma compacta"
  - id: inspeccionar-un-commit
    title: "Inspeccionar un commit"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Commits y construcción del historial

Los commits son las piezas con las que construimos la historia de un proyecto. Un buen historial explica la evolución del trabajo de forma comprensible.

## Qué vas a conseguir

- Crear commits coherentes y pequeños.
- Escribir mensajes descriptivos.
- Consultar `git log` y `git show`.
- Reconocer un identificador de commit.
- Diferenciar un cambio técnico de una versión significativa del proyecto.

## Punto de partida

Realiza un cambio en `README.md`, prepáralo y confirma:

```bash
git add README.md
git commit -m "Añadir objetivo del proyecto"
```

Consulta el historial:

```bash
git log
```

Cada commit contiene, entre otros datos, un identificador, autor, fecha y mensaje.

## Mensajes de commit

Un mensaje debe explicar qué cambio introduce.

Poco útil:

```text
cambios
```

Mejor:

```text
Añadir instrucciones de instalación
```

Otro ejemplo:

```text
Corregir enlace a documentación
```

## Commits pequeños y coherentes

Evita agrupar tareas sin relación:

```text
Añadir documentación + cambiar logo + corregir ejercicio + borrar pruebas
```

Es preferible separar cambios independientes en commits diferentes.

## Consultar el historial de forma compacta

```bash
git log --oneline
```

Ejemplo:

```text
f13a2d1 Añadir recursos recomendados
81bc440 Añadir normas del equipo
3f90af2 Crear README inicial
```

## Inspeccionar un commit

```bash
git show f13a2d1
```

Puedes utilizar el identificador abreviado mostrado por `--oneline`.

## Ejemplo guiado

Crea tres commits sucesivos:

```text
Crear README inicial
Añadir integrantes del equipo
Añadir enlaces de referencia
```

Después ejecuta:

```bash
git log --oneline
```

Comprueba que puedes explicar qué ocurrió leyendo solo el historial.

## Ejercicios propuestos

**Ejercicio 1.** Crea dos commits con cambios distintos y mensajes descriptivos.

**Ejercicio 2.** Utiliza `git show` para inspeccionar el último commit.

**Ejercicio 3.** Reescribe estos mensajes para que sean útiles: `cosas`, `update`, `final`, `arreglo`.

**Reto.** Revisa tus últimos cinco commits y decide si otra persona podría comprender la evolución del proyecto sin abrir los archivos.

## Qué debes recordar

Un commit debe representar una unidad de cambio comprensible. El historial es documentación técnica: cuanto más claro sea, más fácil será mantener y revisar el proyecto.

<div class="cla-lesson-nav">
  <a href="/git/leccion04/">← Lección 04 · El modelo de trabajo de Git</a>
  <a href="/git/leccion06/">Lección 06 · Seguimiento y revisión de cambios →</a>
</div>
