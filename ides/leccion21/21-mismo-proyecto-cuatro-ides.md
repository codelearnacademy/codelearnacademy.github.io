---
layout: lesson
route: ides
lesson_id: leccion21
lesson_file: 21-mismo-proyecto-cuatro-ides
lesson_number: "21"
title: El mismo proyecto en cuatro IDEs
description: "El mismo proyecto en cuatro IDEs: ruta práctica de IDEs Java sobre Debian 13.7.0 netinst."
permalink: /ides/leccion21/
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
  - id: qué-debes-recordar
    title: Qué debes recordar
---

# El mismo proyecto en cuatro IDEs

## Qué vas a conseguir

- Comparar los cuatro IDEs sobre el mismo proyecto.
- Detectar qué configuraciones son propias del IDE.
- Confirmar que Maven mantiene el proyecto portable.

## Punto de partida

`hola-ides` ya ha sido abierto en VS Code, IntelliJ IDEA, Eclipse y NetBeans.

## Conceptos clave

Una comparación útil debe mantener constantes:

- sistema operativo;
- JDK;
- proyecto;
- código fuente;
- pruebas;
- versión del repositorio.

Así, la variable que cambia es el IDE.

## Ejemplo guiado

Completa una tabla como esta:

| Comprobación | VS Code | IntelliJ | Eclipse | NetBeans |
|---|---|---|---|---|
| Detecta JDK 21 | | | | |
| Importa `pom.xml` | | | | |
| Ejecuta `main` | | | | |
| Ejecuta JUnit | | | | |
| Integra Git | | | | |
| Terminal integrada | | | | |
| Navegación de código | | | | |
| Tiempo de arranque percibido | | | | |

Después ejecuta una última vez:

```bash
mvn clean test
git status
```

## Relación con el resto de la ruta

La última lección convierte estas comprobaciones en una verificación final del laboratorio.

## Ejercicios propuestos

1. Completa la tabla.
2. Escribe dos diferencias objetivas entre cada pareja de IDEs.
3. Identifica qué archivos o directorios locales crea cada entorno.
4. No elijas un “ganador” sin explicar los criterios.

## Qué debes recordar

- Una preferencia personal no es una característica técnica.
- La portabilidad se comprueba fuera del IDE.


<div class="cla-lesson-nav">
  <a href="/ides/leccion20/">← 20 · Abrir y verificar el proyecto en NetBeans</a>
  <a href="/ides/leccion22/">22 · Comparación final y verificación del entorno →</a>
</div>
