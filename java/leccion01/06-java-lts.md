---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 06-java-lts
lesson_number: "06"
title: Java LTS
description: Comprende qué aporta una versión con soporte a largo plazo.
---

# Java LTS

LTS significa Long-Term Support. Una versión LTS está pensada para organizaciones que necesitan mantener una plataforma durante años y planificar las actualizaciones con menos frecuencia.

## Qué aporta

- Un horizonte de mantenimiento más predecible.
- Más tiempo para actualizar bibliotecas y aplicaciones.
- Una base común para equipos, entornos y pipelines.
- Menor presión para adoptar cada versión intermedia.

LTS no significa que todas las bibliotecas de terceros mantengan el mismo soporte ni que una aplicación quede automáticamente actualizada. Hay que revisar vulnerabilidades, compatibilidad y fechas de fin de soporte de toda la cadena.

## Decisión recomendada

Para aprender, usa Java 21 y registra la versión en la documentación del proyecto. Para producción, combina la elección de la LTS con una política explícita de actualizaciones y pruebas de regresión.
<figure class="cla-diagram cla-diagram--small">
  <img src="/java/images/01-lts-decision.png" alt="Criterio didáctico para elegir una versión LTS de Java" loading="lazy">
</figure>


## LTS no es “la más antigua”

Una LTS puede ser reciente y recibir actualizaciones con frecuencia. La ventaja está en el compromiso de mantenimiento, no en congelar el software. Una aplicación Java 21 debe seguir actualizando el JDK dentro de la misma línea cuando haya correcciones de seguridad.

En .NET existen ciclos de soporte similares, mientras que en Python la política se organiza por versión mayor y menor. El concepto es comparable, pero las fechas dependen de cada ecosistema.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué criterio suele ser razonable para proyectos formativos y empresariales?

- A) Elegir siempre una versión obsoleta
- B) Usar una versión LTS compatible con el proyecto
- C) Cambiar de versión cada día
- D) Evitar declarar la versión

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> Una LTS suele facilitar estabilidad y soporte.</p>

</details>

### 2. ¿LTS significa que una versión sea la única válida?

- A) Sí
- B) No

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: B.</strong> También existen versiones no LTS; la elección depende del contexto.</p>

</details>

### 3. ¿Qué debe verificarse al elegir un JDK?

- A) Compatibilidad de herramientas y dependencias
- B) Solo el color del IDE
- C) La marca del monitor
- D) La extensión del README

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Build tools, librerías y despliegue deben ser compatibles con la versión escogida.</p>

</details>

### 4. ¿Qué es más importante que memorizar todas las versiones?

- A) Entender la política de soporte y la versión objetivo
- B) Saber sus logotipos
- C) Instalar todas a la vez
- D) No actualizar nunca

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La competencia práctica es saber elegir y declarar una versión adecuada.</p>

</details>

## Ejercicios propuestos

1. Compara dos versiones de Java que conozcas y justifica cuál escogerías para un curso de un año.

