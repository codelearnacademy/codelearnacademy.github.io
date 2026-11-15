---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 12-instalacion
lesson_number: "12"
title: Instalación
description: Instala un JDK 21 y verifica el entorno antes de escribir código.
lessons:
  - id: verificacion-minima
    title: "Verificación mínima"
  - id: diagnostico
    title: "Diagnóstico"
  - id: entorno-reproducible
    title: "Entorno reproducible"
  - id: lista-de-comprobacion
    title: "Lista de comprobación"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# Instalación

Instala un JDK 21 de una distribución compatible con tu sistema operativo. Después abre un terminal nuevo para que el sistema cargue las variables de entorno actualizadas.

## Verificación mínima
{: #verificacion-minima }

```bash
java -version
javac -version
```
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-instalacion-checklist.webp' | relative_url }}" alt="Pasos para comprobar una instalación de Java preparada para desarrollar" loading="lazy">
</figure>


Ambos comandos deben responder con la versión 21 o con la versión de JDK que hayas elegido explícitamente. Si `java` funciona pero `javac` no existe, probablemente tienes un runtime incompleto o el `PATH` apunta a otra instalación.

## Diagnóstico
{: #diagnostico }

```bash
which java
which javac
```

En Windows, utiliza `where java` y `where javac`. Cuando haya varias instalaciones, corrige el `PATH` o configura el JDK desde tu IDE y tu herramienta de build de forma explícita.

<div class="cla-note"><strong>Resultado esperado</strong><p>El terminal debe poder encontrar el compilador y el lanzador de Java sin depender de una ruta absoluta en cada comando.</p></div>

## Entorno reproducible
{: #entorno-reproducible }

Anota el sistema operativo, la arquitectura y el proveedor del JDK. En equipos profesionales conviene automatizar la selección de versión con la herramienta de build o un gestor de versiones, y comprobarla también en CI.

La idea es común a Node.js con `node --version`, Python con `python --version` y Go con `go version`: el comando de verificación debe formar parte del diagnóstico.

## Lista de comprobación
{: #lista-de-comprobacion }

1. Instala una distribución JDK 21 de 64 bits adecuada para tu sistema.
2. Abre un terminal nuevo y comprueba `java -version`.
3. Comprueba `javac -version` y confirma que el compilador pertenece a la misma instalación.
4. Ejecuta `which java` y `which javac` en macOS o Linux para detectar rutas mezcladas.
5. Guarda la información en el README del ejercicio.

Si trabajas con Windows, sustituye `which` por `where`. En un equipo, una captura aislada ayuda menos que comandos reproducibles y una salida que otra persona pueda contrastar.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué dos comandos conviene comprobar tras instalar un JDK?

- A) git status y git push
- B) sqlite3 y curl
- C) java -version y javac -version
- D) npm start y npm test

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> Verifican runtime y compilador.</p>

</details>

### 2. Si `java` funciona pero `javac` no, ¿qué sospecha es razonable?

- A) Java funciona perfectamente para desarrollo
- B) SQLite está roto
- C) Puede faltar un JDK completo o estar mal configurado PATH
- D) El código tiene un if incorrecto

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: C.</strong> javac forma parte de las herramientas de desarrollo del JDK.</p>

</details>

### 3. ¿Qué variable/configuración del sistema suele afectar a encontrar ejecutables Java?

- A) HTML
- B) PATH
- C) JSON
- D) SQL

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> PATH determina dónde busca el sistema los ejecutables.</p>

</details>

### 4. ¿Qué debes hacer después de instalar?

- A) Verificar versiones antes de empezar a programar
- B) Instalar todas las versiones existentes
- C) Borrar el JDK
- D) Asumir que funciona

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La comprobación evita diagnosticar después problemas de instalación como errores de código.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Documenta una instalación correcta con las salidas de `java -version` y `javac -version`.
2. Simula un problema de PATH y describe cómo lo diagnosticarías.

