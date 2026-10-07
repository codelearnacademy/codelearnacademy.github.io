---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 09-jdk
lesson_number: "09"
title: JDK
description: Conoce las herramientas que necesitas para desarrollar con Java.
---

# JDK

El Java Development Kit es el kit de desarrollo. Incluye la JVM y las herramientas necesarias para compilar, ejecutar, inspeccionar y documentar programas Java.

## Herramientas esenciales

| Comando | Uso |
| --- | --- |
| `java` | Inicia una aplicación sobre la JVM. |
| `javac` | Compila archivos fuente `.java`. |
| `jar` | Empaqueta clases y recursos. |
| `javadoc` | Genera documentación desde comentarios del código. |
| `jshell` | Permite probar expresiones de forma interactiva. |

Para desarrollar, el JDK es suficiente. La variable `PATH` debe permitir localizar sus ejecutables, y la configuración del proyecto debe usar el mismo JDK en local y en automatización.

<div class="cla-note"><strong>Regla práctica</strong><p>Si vas a compilar, necesitas un JDK. Tener solo un comando `java` disponible no demuestra que puedas construir el proyecto.</p></div>

## JDK frente a otros kits

El JDK cumple una función parecida al SDK de .NET o a un toolchain de Go: reúne compilador, runtime y utilidades para crear software. Python suele instalarse con su intérprete y módulos, pero sus herramientas de empaquetado pueden llegar por separado.

```bash
java -version
javac -version
```

## Refuerzo práctico

<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-jdk-jre-jvm.png" alt="01 jdk jre jvm" loading="lazy">
</figure>

### Ejemplo guiado

Ejecuta `java -version` y `javac -version`. Comprueba que tu instalación puede ejecutar y compilar.

### Ejercicio propuesto

Explica qué herramienta faltaría si pudieras ejecutar programas pero no compilar código fuente.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué contiene un JDK?

- A) Herramientas para desarrollar Java, incluido el compilador
- B) Solo un navegador
- C) Solo SQLite
- D) Únicamente Git

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El JDK incluye herramientas de desarrollo como javac y el runtime necesario.</p>

</details>

### 2. ¿Qué herramienta del JDK compila fuentes?

- A) java
- B) javac
- C) javap -version únicamente
- D) jvmc

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> javac es el compilador de Java.</p>

</details>

### 3. ¿Qué necesitas para desarrollar y compilar código Java?

- A) Un JDK
- B) Solo un .class
- C) Un servidor web
- D) Una base de datos

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Para desarrollo se instala normalmente un JDK.</p>

</details>

### 4. ¿JDK y JVM son exactamente lo mismo?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La JVM es una parte/concepto de ejecución; el JDK incorpora además herramientas de desarrollo.</p>

</details>

## Ejercicios propuestos

1. Localiza en tu instalación `java`, `javac` y `javap` y explica para qué sirve cada uno.

