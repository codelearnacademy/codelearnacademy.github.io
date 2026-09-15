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