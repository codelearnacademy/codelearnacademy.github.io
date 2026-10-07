---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 02-que-es-java
lesson_number: "02"
title: ¿Qué es Java?
description: Diferencia el lenguaje Java de la plataforma que ejecuta sus programas.
---

# ¿Qué es Java?

Java es un lenguaje de programación de propósito general y, a la vez, el nombre habitual de una plataforma de ejecución. Su diseño favorece el tipado estático, la orientación a objetos, la portabilidad y una gestión automática de memoria.

## Lenguaje y plataforma

El lenguaje define la sintaxis, las reglas de tipos y la semántica del código. La plataforma añade herramientas y bibliotecas para compilar y ejecutar ese código. Por eso un proyecto Java no se reduce al archivo `.java`: también depende del JDK, la JVM y sus bibliotecas.

## La idea de portabilidad

El código fuente se compila a bytecode, un formato intermedio que puede ejecutarse en una JVM compatible. La portabilidad no significa que todo comportamiento sea idéntico en cualquier sistema: rutas, codificaciones, procesos y recursos externos deben tratarse explícitamente.
<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-portabilidad-jvm.png" alt="Portabilidad del bytecode mediante distintas JVM" loading="lazy">
</figure>


<div class="cla-note"><strong>Idea clave</strong><p>Java no elimina las diferencias entre sistemas operativos; concentra la ejecución del programa en una máquina virtual común.</p></div>

## Comparación rápida

| Lenguaje | Forma habitual de ejecución | Tipado |
| --- | --- | --- |
| Java | Bytecode sobre JVM | Estático |
| Python | Código interpretado o bytecode sobre un runtime | Dinámico |
| JavaScript | Motor del navegador o Node.js | Dinámico |
| C# | IL sobre .NET | Estático |

“Compilado” e “interpretado” no siempre son categorías excluyentes: los runtimes modernos pueden combinar compilación previa y optimización durante la ejecución.

## Cuándo elegir cada modelo

Java suele encajar bien en servicios que necesitan una plataforma estable, bibliotecas maduras y contratos de tipos claros. Python facilita automatización y prototipos; JavaScript domina la interacción web y también puede ejecutarse en servidores; C# ofrece una experiencia comparable sobre .NET; Go prioriza un toolchain compacto y binarios sencillos de distribuir.

La comparación no determina por sí sola qué lenguaje es mejor. Pregunta por el equipo, el tiempo de vida, el rendimiento esperado, el ecosistema y la facilidad de operación. En esta ruta aprenderás Java porque esas decisiones también forman parte de desarrollar software profesional.

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-java-plataforma.png" alt="01 java plataforma" loading="lazy">
</figure>

### Ejemplo guiado

Sigue el recorrido de una clase `Main.java`: identifica qué hace el compilador y qué hace la JVM.

### Ejercicio propuesto

Ordena `Main.java`, `javac`, `Main.class`, `java` y JVM y explica el papel de cada elemento.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué describe mejor a Java?

- A) Solo un compilador
- B) Un lenguaje y una plataforma de ejecución
- C) Una base de datos
- D) Un editor de código

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Java combina el lenguaje con una plataforma de ejecución basada en la JVM.</p>

</details>

### 2. ¿Qué permite que un mismo bytecode pueda ejecutarse en distintos sistemas?

- A) El navegador
- B) La JVM disponible para cada plataforma
- C) El IDE
- D) El fichero pom.xml

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Cada plataforma dispone de una JVM capaz de ejecutar el mismo bytecode.</p>

</details>

### 3. ¿Qué extensión tiene normalmente el código fuente Java?

- A) .class
- B) .java
- C) .jarx
- D) .jvm

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los fuentes Java se almacenan en ficheros .java.</p>

</details>

### 4. ¿Qué idea resume la portabilidad de Java?

- A) Cada SO exige reescribir el programa
- B) El bytecode se ejecuta mediante una JVM apropiada
- C) Java solo funciona en Linux
- D) El código Java no se compila

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La JVM separa el bytecode del sistema operativo concreto.</p>

</details>

## Ejercicios propuestos

1. Dibuja el recorrido de un programa desde `Main.java` hasta su ejecución y explica qué parte hace posible la portabilidad.

