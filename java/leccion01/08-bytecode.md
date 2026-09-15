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

```bash
javap -c Main
```

La salida ayuda a relacionar métodos Java con instrucciones de la máquina virtual. En C# existe una idea equivalente con el lenguaje intermedio de .NET; en C y Go el compilador suele producir código nativo para la arquitectura objetivo.