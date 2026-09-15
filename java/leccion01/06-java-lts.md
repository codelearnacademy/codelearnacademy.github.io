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

## LTS no es “la más antigua”

Una LTS puede ser reciente y recibir actualizaciones con frecuencia. La ventaja está en el compromiso de mantenimiento, no en congelar el software. Una aplicación Java 21 debe seguir actualizando el JDK dentro de la misma línea cuando haya correcciones de seguridad.

En .NET existen ciclos de soporte similares, mientras que en Python la política se organiza por versión mayor y menor. El concepto es comparable, pero las fechas dependen de cada ecosistema.