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

Cada símbolo aporta un significado concreto. Las formas pueden variar ligeramente según la norma utilizada, pero lo importante es mantener la misma convención en todo el diagrama.

<div class="cla-flow-symbols">
  <figure><img src="/assets/images/algoritmia/leccion05/01-terminador.svg" alt="Símbolo terminador con el ejemplo Inicio"><figcaption>Terminador</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/02-proceso.svg" alt="Símbolo proceso con el ejemplo total igual a precio por cantidad"><figcaption>Proceso</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/03-entrada-salida.svg" alt="Símbolo de entrada y salida con el ejemplo Leer edad"><figcaption>Entrada y salida</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/04-decision.svg" alt="Símbolo decisión con el ejemplo edad mayor o igual que 18"><figcaption>Decisión</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/05-flecha.svg" alt="Flecha que indica la dirección del flujo"><figcaption>Línea de flujo</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/06-conector.svg" alt="Conector en página identificado con la letra A"><figcaption>Conector en página</figcaption></figure>
</div>

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

## Símbolos adicionales

Estos símbolos amplían la notación básica cuando el diagrama representa funciones, documentos, almacenamiento o tareas que no son operaciones del algoritmo. No es necesario utilizarlos todos en un diagrama sencillo.

| Símbolo | Uso | Ejemplo |
|---|---|---|
| Subproceso | Llamar a una función o algoritmo | `CalcularArea()` |
| Conector fuera de página | Continuar en otro diagrama o página | `B` |
| Preparación | Inicializar o preparar valores | `contador = 0` |
| Unión de flujo | Reunir recorridos | Reunir ramas `Sí/No` |
| Documento | Generar un documento | `Informe` |
| Varios documentos | Generar varios documentos | `Facturas` |
| Base de datos | Guardar o consultar datos persistentes | `Clientes` |
| Almacenamiento interno | Guardar un dato temporalmente | `resultado` |
| Entrada manual | Introducir datos directamente | `Escribir nombre` |
| Visualización | Mostrar información en pantalla | `Mostrar total` |
| Operación manual | Tarea realizada por una persona | `Revisar solicitud` |
| Retardo | Esperar antes de continuar | `Esperar 5 segundos` |
| Anotación | Añadir una aclaración | `Regla de validación` |
| Extracto | Seleccionar una parte del flujo | `Solo pares` |
| Clasificación | Ordenar datos | `Ordenar por fecha` |

<div class="cla-flow-symbols">
  <figure><img src="/assets/images/algoritmia/leccion05/07-subproceso.svg" alt="Símbolo subproceso con el ejemplo CalcularArea"><figcaption>Subproceso</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/08-conector-fuera-pagina.svg" alt="Conector fuera de página identificado con la letra B"><figcaption>Conector fuera de página</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/09-preparacion.svg" alt="Símbolo preparación con el ejemplo contador igual a cero"><figcaption>Preparación</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/10-union-flujo.svg" alt="Símbolo de unión de flujo para reunir ramas"><figcaption>Unión de flujo</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/11-documento.svg" alt="Símbolo documento con el ejemplo Informe"><figcaption>Documento</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/12-varios-documentos.svg" alt="Símbolo de varios documentos con el ejemplo emitir facturas"><figcaption>Varios documentos</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/13-base-datos.svg" alt="Símbolo base de datos con el ejemplo guardar clientes"><figcaption>Base de datos</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/14-almacenamiento-interno.svg" alt="Símbolo almacenamiento interno con el ejemplo resultado"><figcaption>Almacenamiento interno</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/15-entrada-manual.svg" alt="Símbolo entrada manual con el ejemplo escribir nombre"><figcaption>Entrada manual</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/16-visualizacion.svg" alt="Símbolo visualización con el ejemplo mostrar total"><figcaption>Visualización</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/17-operacion-manual.svg" alt="Símbolo operación manual con el ejemplo revisar solicitud"><figcaption>Operación manual</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/18-retardo.svg" alt="Símbolo retardo con el ejemplo esperar cinco segundos"><figcaption>Retardo</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/19-anotacion.svg" alt="Símbolo anotación para aclarar una regla"><figcaption>Anotación</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/20-extracto.svg" alt="Símbolo extracto con el ejemplo seleccionar números pares"><figcaption>Extracto</figcaption></figure>
  <figure><img src="/assets/images/algoritmia/leccion05/21-clasificacion.svg" alt="Símbolo clasificación con el ejemplo ordenar por fecha"><figcaption>Clasificación</figcaption></figure>
</div>

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

Los siguientes ejercicios muestran el mismo problema en cuatro niveles. Primero se entiende la situación, después se ordenan los pasos con lenguaje natural, se resumen con acciones estructuradas y finalmente se traducen a símbolos.

### Ejercicio 1 resuelto. Calcular el precio de una compra

**Texto descriptivo.** Una tienda necesita calcular el importe de una compra. Se debe pedir el precio de un producto y la cantidad comprada, calcular el total y mostrarlo.

**Lenguaje natural.**

1. Pedir el precio.
2. Pedir la cantidad.
3. Multiplicar el precio por la cantidad.
4. Mostrar el total.

**Representación estructurada.**

```text
INICIO
Leer precio
Leer cantidad
Calcular total = precio * cantidad
Mostrar total
FIN
```

**Diagrama de flujo correspondiente.**

```text
Inicio
  ↓
Leer precio y cantidad
  ↓
total = precio * cantidad
  ↓
Mostrar total
  ↓
Fin
```

### Ejercicio 2. Comprobar si un número es positivo

**Texto descriptivo.** Una aplicación recibe un número y debe indicar si es positivo o no positivo. El cero se considera no positivo.

**Tarea.** Escribe el lenguaje natural, la representación estructurada y el diagrama de flujo correspondiente. Recuerda que la decisión debe tener las ramas `Sí` y `No`, y que ambas deben terminar en `Fin`.

### Ejercicio 3. Aplicar un descuento

**Texto descriptivo.** Una tienda aplica un descuento del 10 % cuando el importe de una compra es igual o superior a 100 euros. Hay que pedir el importe, decidir si corresponde el descuento, calcular el precio final y mostrarlo.

**Tarea.** Describe los pasos en lenguaje natural, escribe la representación estructurada y dibuja el diagrama de flujo. Comprueba que las dos ramas calculan un `precioFinal` y se reúnen antes de mostrarlo.

### Ejercicio 4. Encontrar el mayor de dos números

**Texto descriptivo.** Un programa debe pedir dos números, compararlos y mostrar cuál es el mayor. Si son iguales, debe indicarlo expresamente.

**Tarea.** Convierte el enunciado a lenguaje natural, representación estructurada y diagrama de flujo. Debes representar tres resultados posibles: primero mayor, segundo mayor o igualdad.

### Ejercicio 5. Clasificar una nota

**Texto descriptivo.** Un centro educativo quiere clasificar una nota numérica. Se debe leer la nota y mostrar «Suspenso» si es menor que 5, «Aprobado» si está entre 5 y 6.99, «Notable» si está entre 7 y 8.99 y «Sobresaliente» si es igual o superior a 9.

**Tarea.** Elabora las tres representaciones restantes: lenguaje natural, representación estructurada y diagrama de flujo. Ordena las decisiones de menor a mayor nota y etiqueta todas las ramas.

## Qué debes recordar

Los símbolos aportan significado y las flechas aportan orden. Un buen diagrama debe poder leerse sin explicaciones adicionales. A partir de ahora utilizaremos estas convenciones para construir algoritmos cada vez más completos.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion04/">← Lección 04 · Introducción a los diagramas de flujo</a>
  <a href="/algoritmia/leccion06/">Lección 06 · Algoritmos secuenciales →</a>
</div>
