---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 07-jvm
lesson_number: "07"
title: JVM
description: Sigue el ciclo de ejecución dentro de la máquina virtual de Java.
---

# JVM

La Java Virtual Machine es la máquina virtual que carga y ejecuta bytecode. La especificación define el comportamiento que debe ofrecer una implementación; cada distribución concreta aporta su propia JVM.

## Flujo de ejecución

```text
Main.java -> javac -> Main.class -> class loader -> JVM -> ejecución
```

La JVM verifica clases, administra memoria, ejecuta instrucciones y puede optimizar código durante el funcionamiento mediante compilación Just-In-Time.

## Responsabilidades

- Cargar clases cuando son necesarias.
- Verificar que el bytecode es válido.
- Gestionar memoria y ejecutar el recolector de basura.
- Proporcionar hilos, excepciones y acceso controlado a recursos.

<div class="cla-note"><strong>Idea clave</strong><p>El programa Java no se ejecuta directamente desde el texto fuente. La JVM trabaja con bytecode y ofrece el entorno de ejecución.</p></div>

## Memoria y rendimiento

La JVM reserva memoria para objetos y ejecuta el recolector de basura cuando detecta objetos que ya no pueden alcanzarse. El programador no libera cada objeto manualmente, pero sí debe cerrar archivos, conexiones y otros recursos externos.

El compilador JIT puede optimizar rutas de código que se ejecutan muchas veces. Por eso una medición válida necesita un escenario repetible y no debe basarse solo en el tiempo de una primera ejecución.

## Qué observa un equipo

En producción no basta con saber que existe una JVM. Un equipo también observa memoria usada, pausas del recolector, tiempo de arranque, errores y consumo de CPU. Esas métricas ayudan a distinguir un problema de la aplicación de un problema de configuración del runtime.

Python, JavaScript y .NET tienen sus propios runtimes y recolectores o estrategias de memoria. La terminología cambia, pero la práctica es la misma: medir el comportamiento real antes de ajustar parámetros.