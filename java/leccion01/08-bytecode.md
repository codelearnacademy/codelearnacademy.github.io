---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 08-bytecode
lesson_number: "08"
title: Bytecode
description: Identifica el formato intermedio que conecta el compilador con la JVM.
---

# Bytecode

El bytecode es la representación intermedia que produce el compilador Java. Normalmente se almacena en archivos `.class` y contiene instrucciones para la JVM, no instrucciones nativas de un procesador concreto.

## Por qué importa

El mismo bytecode puede ejecutarse en diferentes sistemas si existe una JVM compatible. Esto separa la compilación del código fuente de muchos detalles del sistema operativo.

```java
public class Main {
	public static void main(String[] args) {
		System.out.println("Hola");
	}
}
```

```text
javac Main.java  ->  Main.class
```

El bytecode no es código fuente ni un ejecutable nativo. La JVM lo valida y decide cómo ejecutarlo, interpretarlo u optimizarlo.

## Inspeccionarlo

El JDK incluye `javap`, una herramienta útil para observar una clase compilada:
<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-bytecode-inspeccion.png" alt="Flujo para compilar e inspeccionar bytecode con javap" loading="lazy">
</figure>


```bash
javap -c Main
```

La salida ayuda a relacionar métodos Java con instrucciones de la máquina virtual. En C# existe una idea equivalente con el lenguaje intermedio de .NET; en C y Go el compilador suele producir código nativo para la arquitectura objetivo.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué genera javac a partir de un fuente Java?

- A) Un fichero .class con bytecode
- B) Un fichero SQL
- C) Una imagen PNG
- D) Un contenedor Docker

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> javac compila el código fuente a bytecode.</p>

</details>

### 2. ¿El bytecode es normalmente código máquina nativo de un único sistema operativo?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El bytecode está pensado para ser ejecutado por la JVM.</p>

</details>

### 3. ¿Qué herramienta permite inspeccionar bytecode de forma legible?

- A) javap
- B) Scanner
- C) javadoc únicamente
- D) git

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> javap puede desensamblar una clase y mostrar sus instrucciones.</p>

</details>

### 4. ¿Qué extensión suele contener bytecode Java?

- A) .java
- B) .class
- C) .json
- D) .db

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Los ficheros compilados usan normalmente .class.</p>

</details>

### 5. ¿Por qué es útil observar bytecode al aprender?

- A) Para sustituir siempre Java por bytecode
- B) Para entender que fuente y resultado compilado son representaciones distintas
- C) Para escribir HTML
- D) Para crear bases de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Ayuda a comprender el proceso real de compilación.</p>

</details>

## Ejercicios propuestos

1. Compila un programa de dos métodos, inspecciónalo con `javap -c` e identifica qué cambia respecto al fuente.
2. Modifica una expresión aritmética, recompila y compara el bytecode.

