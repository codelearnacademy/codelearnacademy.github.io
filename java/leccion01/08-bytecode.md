---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 08-bytecode
lesson_number: "08"
title: Bytecode
description: Identifica el formato intermedio que conecta el compilador con la JVM.
lessons:
  - id: por-que-importa
    title: "Por qué importa"
  - id: inspeccionarlo
    title: "Inspeccionarlo"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Bytecode

El bytecode es la representación intermedia que produce el compilador Java. Normalmente se almacena en archivos `.class` y contiene instrucciones para la JVM, no instrucciones nativas de un procesador concreto.

## Por qué importa
{: #por-que-importa }

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
{: #inspeccionarlo }

El JDK incluye `javap`, una herramienta útil para observar una clase compilada:
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-bytecode-inspeccion.webp' | relative_url }}" alt="Flujo para compilar e inspeccionar bytecode con javap" loading="lazy">
</figure>


```bash
javap -c Main
```

La salida ayuda a relacionar métodos Java con instrucciones de la máquina virtual. En C# existe una idea equivalente con el lenguaje intermedio de .NET; en C y Go el compilador suele producir código nativo para la arquitectura objetivo.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué genera javac a partir de un fuente Java?

- A) Un contenedor Docker
- B) Una imagen PNG
- C) Un fichero .class con bytecode
- D) Un fichero SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> javac compila el código fuente a bytecode.</p>

</details>

### 2. ¿El bytecode es normalmente código máquina nativo de un único sistema operativo?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> El bytecode está pensado para ser ejecutado por la JVM.</p>

</details>

### 3. ¿Qué herramienta permite inspeccionar bytecode de forma legible?

- A) git
- B) javadoc únicamente
- C) Scanner
- D) javap

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> javap puede desensamblar una clase y mostrar sus instrucciones.</p>

</details>

### 4. ¿Qué extensión suele contener bytecode Java?

- A) .class
- B) .java
- C) .db
- D) .json

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Los ficheros compilados usan normalmente .class.</p>

</details>

### 5. ¿Por qué es útil observar bytecode al aprender?

- A) Para escribir HTML
- B) Para entender que fuente y resultado compilado son representaciones distintas
- C) Para sustituir siempre Java por bytecode
- D) Para crear bases de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Ayuda a comprender el proceso real de compilación.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Compila un programa de dos métodos, inspecciónalo con `javap -c` e identifica qué cambia respecto al fuente.
2. Modifica una expresión aritmética, recompila y compara el bytecode.

