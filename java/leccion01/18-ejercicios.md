---
layout: lesson
route: java
lesson_id: leccion01
lesson_file: 18-ejercicios
lesson_number: "18"
title: Ejercicios
description: Consolida la instalación, el primer programa y el flujo de compilación.
---

# Ejercicios

Completa los ejercicios en orden y conserva las evidencias de cada resultado.

## 1. Comprueba el entorno

Ejecuta `java -version` y `javac -version`. Anota la versión mayor y la distribución del JDK. Si los comandos no existen, resuelve la instalación antes de continuar.

## 2. Personaliza el programa

Modifica `Main.java` para que imprima tu nombre, la versión de Java que estás usando y una segunda línea con el texto `Estoy listo para aprender`.

## 3. Compila y ejecuta

Genera el `.class` con `javac Main.java` y ejecuta la clase con `java Main`. Después elimina el `.class`, vuelve a compilar y verifica que el resultado se mantiene.

## 4. Diagnostica un fallo

Provoca uno de estos errores y explica el mensaje:

- Cambia el nombre de la clase pública sin renombrar el archivo.
- Ejecuta `java Main.class`.
- Borra `Main.class` e intenta ejecutar sin compilar.

<div class="cla-note"><strong>Entrega mínima</strong><p>Incluye los comandos ejecutados, la salida de las versiones, el código final y una explicación breve de cada error diagnosticado.</p></div>

## 5. Comparación opcional

Repite el programa mínimo en Python o JavaScript y anota tres diferencias de sintaxis, ejecución y tipado. No busques declarar un ganador: relaciona cada diferencia con el tipo de herramienta y runtime que utiliza.

## Criterios de revisión

- El archivo y la clase pública tienen el mismo nombre.
- La versión del JDK está identificada.
- La compilación y la ejecución son comandos separados.
- Los artefactos generados no se confunden con el código fuente.
- La explicación usa correctamente JDK, bytecode y JVM.

## Tabla de comparación para la entrega

| Criterio | Java | Python o JavaScript |
| --- | --- | --- |
| Archivo inicial | `Main.java` | `main.py` o `main.js` |
| Comprobación | `java -version` | `python --version` o `node --version` |
| Construcción | `javac Main.java` | Normalmente no hay una fase equivalente obligatoria |
| Ejecución | `java Main` | `python main.py` o `node main.js` |

Compara ambos flujos atendiendo a la sintaxis, las herramientas necesarias y el papel del runtime.
## Autoevaluación

Responde antes de desplegar la solución.

### 1. ¿Qué deberías hacer antes de consultar una solución?

- A) Intentar resolver el ejercicio y probar tu código
- B) Copiarla
- C) Omitir la ejecución
- D) Cambiar de tema

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> El intento propio es necesario para que el ejercicio tenga valor.</p>

</details>

### 2. ¿Qué evidencia confirma mejor que tu programa funciona?

- A) Compilarlo y ejecutarlo con casos de prueba
- B) Que el código sea largo
- C) Que tenga comentarios
- D) Que use muchas clases

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> La ejecución y las pruebas permiten comprobar el comportamiento.</p>

</details>

### 3. ¿Qué conviene hacer si aparece un error?

- A) Leer el mensaje y localizar la línea antes de modificar al azar
- B) Borrar todo
- C) Instalar otro SO
- D) Ignorarlo

<details>
<summary>Ver respuesta</summary>

<p><strong>Respuesta correcta: A.</strong> Diagnosticar el mensaje es una habilidad central de programación.</p>

</details>

## Ejercicios propuestos

1. Resuelve al menos seis ejercicios sin consultar la solución hasta haber compilado y probado tu intento.

