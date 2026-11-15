---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 07-jvm
lesson_number: "07"
title: JVM
description: Sigue el ciclo de ejecución dentro de la máquina virtual de Java.
lessons:
  - id: flujo-de-ejecucion
    title: "Flujo de ejecución"
  - id: responsabilidades
    title: "Responsabilidades"
  - id: memoria-y-rendimiento
    title: "Memoria y rendimiento"
  - id: que-observa-un-equipo
    title: "Qué observa un equipo"
  - id: refuerzo-practico
    title: "Refuerzo práctico"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# JVM

La Java Virtual Machine es la máquina virtual que carga y ejecuta bytecode. La especificación define el comportamiento que debe ofrecer una implementación; cada distribución concreta aporta su propia JVM.

## Flujo de ejecución
{: #flujo-de-ejecucion }

```text
Main.java -> javac -> Main.class -> class loader -> JVM -> ejecución
```

La JVM verifica clases, administra memoria, ejecuta instrucciones y puede optimizar código durante el funcionamiento mediante compilación Just-In-Time.

## Responsabilidades
{: #responsabilidades }

- Cargar clases cuando son necesarias.
- Verificar que el bytecode es válido.
- Gestionar memoria y ejecutar el recolector de basura.
- Proporcionar hilos, excepciones y acceso controlado a recursos.

<div class="cla-note"><strong>Idea clave</strong><p>El programa Java no se ejecuta directamente desde el texto fuente. La JVM trabaja con bytecode y ofrece el entorno de ejecución.</p></div>

## Memoria y rendimiento
{: #memoria-y-rendimiento }


<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-jdk-jre-jvm.webp' | relative_url }}" alt="Relación entre JDK, runtime y JVM" loading="lazy">
</figure>

La JVM reserva memoria para objetos y ejecuta el recolector de basura cuando detecta objetos que ya no pueden alcanzarse. El programador no libera cada objeto manualmente, pero sí debe cerrar archivos, conexiones y otros recursos externos.

El compilador JIT puede optimizar rutas de código que se ejecutan muchas veces. Por eso una medición válida necesita un escenario repetible y no debe basarse solo en el tiempo de una primera ejecución.

## Qué observa un equipo
{: #que-observa-un-equipo }

En producción no basta con saber que existe una JVM. Un equipo también observa memoria usada, pausas del recolector, tiempo de arranque, errores y consumo de CPU. Esas métricas ayudan a distinguir un problema de la aplicación de un problema de configuración del runtime.

Python, JavaScript y .NET tienen sus propios runtimes y recolectores o estrategias de memoria. La terminología cambia, pero la práctica es la misma: medir el comportamiento real antes de ajustar parámetros.

## Refuerzo práctico
{: #refuerzo-practico }

<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-jvm-flujo.webp' | relative_url }}" alt="01 jvm flujo" loading="lazy">
</figure>

### Ejemplo guiado

Compila un programa mínimo y localiza el `.class`. Ejecuta después `javap -c Main` para observar que la JVM no recibe el fuente.

### Ejercicio propuesto

Dibuja de memoria el flujo de ejecución y explica dónde interviene el sistema operativo.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Cuál es la función principal de la JVM?

- A) Editar código
- B) Crear tablas SQL
- C) Resolver dependencias Maven
- D) Ejecutar bytecode Java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> La JVM ejecuta el bytecode generado por el compilador.</p>

</details>

### 2. ¿Qué recibe normalmente la JVM para ejecutar?

- A) CSS
- B) SQL puro
- C) Bytecode .class
- D) Código .java directamente como regla general

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> El resultado habitual de la compilación son clases en bytecode.</p>

</details>

### 3. ¿Qué papel tiene la JVM en la portabilidad?

- A) Sustituye al sistema operativo
- B) Ninguno
- C) Convierte Java en JavaScript
- D) Actúa como capa entre bytecode y plataforma concreta

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> Una JVM específica de la plataforma ejecuta el mismo bytecode.</p>

</details>

### 4. ¿Dónde viven conceptualmente muchos objetos creados durante la ejecución?

- A) Git
- B) Heap
- C) pom.xml
- D) Path

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El heap es la zona de memoria asociada a objetos en el modelo simplificado de la JVM.</p>

</details>

### 5. ¿Qué mecanismo ayuda a liberar objetos que ya no son alcanzables?

- A) Garbage Collector
- B) switch
- C) Scanner
- D) javap

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El recolector de basura gestiona automáticamente esa memoria.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Clasifica en un diagrama simplificado variables locales y objetos, y explica el papel del garbage collector.
2. Explica por qué una JVM diferente puede ejecutar el mismo `.class` en otro sistema.

