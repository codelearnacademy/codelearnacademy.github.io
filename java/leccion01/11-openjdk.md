---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 11-openjdk
lesson_number: "11"
title: OpenJDK
description: Distingue la implementación abierta de Java de sus distribuciones.
lessons:
  - id: implementacion-y-distribucion
    title: "Implementación y distribución"
  - id: como-elegir-sin-confusiones
    title: "Cómo elegir sin confusiones"
  - id: autoevaluacion
    title: "Autoevaluación"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
---

# OpenJDK

OpenJDK es el proyecto abierto que contiene el código fuente y la implementación de referencia de buena parte de la plataforma Java. No es necesariamente el nombre del instalador que descargas.

## Implementación y distribución
{: #implementacion-y-distribucion }

Una distribución empaqueta un JDK listo para instalar, con binarios, actualizaciones y una política de soporte. Eclipse Temurin es una distribución conocida basada en OpenJDK y adecuada para esta ruta.
<figure class="cla-diagram cla-diagram--small">
  <img src="{{ '/assets/images/java/01-openjdk-distribuciones.webp' | relative_url }}" alt="Relación entre OpenJDK y distintas distribuciones de JDK" loading="lazy">
</figure>


Al elegir un JDK, revisa:

- Versión mayor y arquitectura.
- Sistema operativo compatible.
- Calendario de actualizaciones de seguridad.
- Licencia y condiciones de uso.
- Soporte disponible para tu equipo.

<div class="cla-note"><strong>Vocabulario</strong><p>OpenJDK describe el proyecto y la base de implementación; Temurin describe una distribución concreta de esa plataforma.</p></div>

## Cómo elegir sin confusiones
{: #como-elegir-sin-confusiones }

Compara distribuciones por soporte, frecuencia de parches, arquitectura disponible y licencia. Para un curso, lo importante es que todo el grupo use una versión compatible; para una empresa, además hay que documentar quién publica y mantiene los binarios.

La situación se parece a elegir una distribución de Python o una imagen base de Linux: el lenguaje o proyecto es común, pero el empaquetado y el ciclo de actualización influyen en el entorno real.
## Autoevaluación
{: #autoevaluacion }

Responde antes de desplegar la solución.

### 1. ¿Qué es OpenJDK?

- A) Un IDE
- B) Un ORM
- C) Una base de datos
- D) Una implementación abierta de la plataforma Java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: D.</strong> OpenJDK es la base abierta de referencia del ecosistema Java.</p>

</details>

### 2. ¿Existen distintas distribuciones basadas en OpenJDK?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Distintos proveedores ofrecen builds/distribuciones de OpenJDK.</p>

</details>

### 3. ¿Qué debes considerar al escoger una distribución?

- A) Versión, soporte y plataforma
- B) Solo el logotipo
- C) El color del terminal
- D) La extensión .java

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Esos factores afectan al uso real del JDK.</p>

</details>

### 4. ¿OpenJDK elimina la necesidad de indicar la versión del proyecto?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> La versión sigue siendo una decisión fundamental del proyecto.</p>

</details>

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Investiga qué distribución de OpenJDK utilizas y anota proveedor, versión y arquitectura.

