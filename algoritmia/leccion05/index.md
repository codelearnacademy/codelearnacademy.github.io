---
layout: lesson
route: algoritmia
lesson_id: leccion05
lesson_number: "05"
title: Símbolos y reglas de los diagramas de flujo
description: Domina los símbolos básicos y las reglas que hacen legible y correcto un diagrama de flujo.
permalink: /algoritmia/leccion05/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: símbolos-principales
    title: "Símbolos principales"
  - id: inicio-y-fin
    title: "Inicio y fin"
  - id: proceso
    title: "Proceso"
  - id: entrada-y-salida
    title: "Entrada y salida"
  - id: decisión
    title: "Decisión"
  - id: reglas-de-dirección
    title: "Reglas de dirección"
  - id: evitar-cruces-innecesarios
    title: "Evitar cruces innecesarios"
  - id: ejemplo-mayoría-de-edad
    title: "Ejemplo: mayoría de edad"
  - id: buenas-prácticas
    title: "Buenas prácticas"
  - id: detectar-un-diagrama-incorrecto
    title: "Detectar un diagrama incorrecto"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Símbolos y reglas de los diagramas de flujo

Para que un diagrama pueda ser comprendido por otras personas, debemos utilizar símbolos con un significado consistente y seguir algunas reglas básicas de representación.

## Qué vas a conseguir

- Reconocer los símbolos principales de un diagrama de flujo.
- Utilizar cada símbolo para la acción adecuada.
- Etiquetar decisiones y recorridos con claridad.
- Aplicar reglas de dirección y conexión.
- Detectar errores de representación frecuentes.

## Punto de partida

En la lección anterior construimos diagramas conceptuales. Ahora formalizaremos su representación.

## Símbolos principales

| Símbolo | Uso | Ejemplo |
|---|---|---|
| Terminador | Inicio o fin | `Inicio`, `Fin` |
| Proceso | Operación o cálculo | `total = precio × cantidad` |
| Entrada/Salida | Leer o mostrar datos | `Leer edad`, `Mostrar total` |
| Decisión | Evaluar una condición | `edad >= 18?` |
| Flecha | Indicar el recorrido | Conectar símbolos |
| Conector | Continuar el flujo en otro punto | Evitar líneas excesivamente largas |

<!-- IMAGEN MUY RECOMENDADA: /assets/images/algoritmia/leccion05/simbolos-diagrama-flujo.svg
Mostrar óvalo, rectángulo, paralelogramo, rombo, flecha y conector con sus nombres. -->

## Inicio y fin

El terminador marca los límites del algoritmo. Un diagrama debe tener un punto de inicio claramente identificable y uno o varios finales comprensibles.

```text
(Inicio)
   ↓
...
   ↓
(Fin)
```

## Proceso

Un rectángulo representa una operación:

```text
area = base × altura
contador = contador + 1
precioFinal = precio - descuento
```

Agrupa operaciones solo cuando sigan siendo fáciles de entender.

## Entrada y salida

El paralelogramo representa información que entra o sale:

```text
Leer edad
Mostrar resultado
```

Esto permite distinguir datos externos de cálculos internos.

## Decisión

El rombo representa una pregunta cuyo resultado determina el camino.

```text
       ¿edad >= 18?
         /      \
       Sí        No
```

Las salidas deben etiquetarse, normalmente como `Sí/No` o `Verdadero/Falso`.

## Reglas de dirección

Mantén el flujo principal de arriba hacia abajo o de izquierda a derecha. Evita flechas que obliguen al lector a recorrer el diagrama en todas direcciones.

Cuando un algoritmo repite pasos, una flecha puede volver a un punto anterior; esa vuelta debe estar claramente justificada.

## Evitar cruces innecesarios

Si muchas flechas se cruzan, el diagrama deja de cumplir su objetivo. Reorganiza los símbolos o utiliza conectores.

```text
Mejor: recorrido claro y corto.
Peor: varias líneas cruzándose sin necesidad.
```

## Ejemplo: mayoría de edad

```text
Inicio
  ↓
Leer edad
  ↓
¿edad >= 18?
 /         \
Sí         No
↓           ↓
Mostrar     Mostrar
"Mayor"    "Menor"
 \         /
     Fin
```

Aquí aparecen entrada, decisión, dos salidas y reunión final.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion05/mayoria-edad.svg -->

## Buenas prácticas

Utiliza textos breves dentro de los símbolos, nombra las variables de forma comprensible, etiqueta siempre las ramas de una decisión y evita mezclar varias decisiones complejas en un único rombo.

<div class="cla-note"><strong>Prueba de legibilidad</strong><p>Entrega el diagrama a otra persona. Si puede explicar el algoritmo sin que tú lo aclares, la representación probablemente es suficientemente clara.</p></div>

## Detectar un diagrama incorrecto

Imagina un rombo con la pregunta `edad >= 18?` pero con dos flechas sin etiquetas. No sabemos qué camino corresponde a verdadero o falso.

Otro error sería utilizar un rectángulo para `Leer edad`: la lectura es una entrada, no un proceso.

## Ejercicios

**Ejercicio 1.** Indica qué símbolo utilizarías para: leer un nombre, calcular una suma, preguntar si un número es positivo, mostrar un mensaje y terminar.

**Ejercicio 2.** Dibuja un diagrama que indique si un número es positivo o no positivo.

**Ejercicio 3.** Revisa uno de tus diagramas anteriores y comprueba que entrada/salida y procesos utilizan símbolos diferentes.

**Reto.** Diseña un diagrama para indicar si una persona puede acceder a una actividad que exige tener al menos 16 años.

## Qué debes recordar

Los símbolos aportan significado y las flechas aportan orden. Un buen diagrama debe poder leerse sin explicaciones adicionales. A partir de ahora utilizaremos estas convenciones para construir algoritmos cada vez más completos.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion04/">← Lección 04 · Introducción a los diagramas de flujo</a>
  <a href="/algoritmia/leccion06/">Lección 06 · Algoritmos secuenciales →</a>
</div>
