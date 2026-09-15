---
layout: lesson
route: algoritmia
lesson_id: leccion19
lesson_number: "19"
title: Proyecto final de algoritmia
description: Integra toda la ruta diseñando, comprobando y documentando una solución algorítmica completa.
permalink: /algoritmia/leccion19/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: enunciado
    title: "Enunciado"
  - id: requisitos
    title: "Requisitos"
  - id: fase-1-analizar
    title: "Fase 1 · Analizar"
  - id: fase-2-diseñar-los-datos
    title: "Fase 2 · Diseñar los datos"
  - id: fase-3-descomponer
    title: "Fase 3 · Descomponer"
  - id: fase-4-diseñar-el-bucle
    title: "Fase 4 · Diseñar el bucle"
  - id: fase-5-máximo-y-mínimo
    title: "Fase 5 · Máximo y mínimo"
  - id: fase-6-pseudocódigo-orientativo
    title: "Fase 6 · Pseudocódigo orientativo"
  - id: fase-7-casos-de-prueba
    title: "Fase 7 · Casos de prueba"
  - id: fase-8-diagrama-de-flujo
    title: "Fase 8 · Diagrama de flujo"
  - id: entregables
    title: "Entregables"
  - id: comprobación-final
    title: "Comprobación final"
  - id: siguiente-paso
    title: "Siguiente paso"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Proyecto final de algoritmia

El proyecto final integra los conceptos de toda la ruta. Diseñarás un **analizador de notas de un grupo** sin depender todavía de un lenguaje de programación concreto.

## Qué vas a conseguir

- Analizar un problema de principio a fin.
- Diseñar una solución modular.
- Combinar entrada, decisiones, bucles, contadores y acumuladores.
- Elaborar diagrama de flujo y pseudocódigo.
- Definir casos de prueba y comprobar resultados.
- Preparar una solución lista para implementarse en Java.

## Enunciado

Debes diseñar un algoritmo que procese las notas de un grupo de estudiantes.

Primero se indica cuántas notas se van a introducir. Después se introducen una a una.

El algoritmo debe calcular:

```text
- media del grupo;
- número de aprobados;
- número de suspensos;
- nota más alta;
- nota más baja.
```

Además, cada nota debe encontrarse entre `0` y `10`.

## Requisitos

La solución debe utilizar:

- al menos un bucle;
- al menos una estructura condicional;
- un acumulador;
- dos o más contadores o variables de estado;
- al menos dos funciones o subalgoritmos;
- casos de prueba documentados.

## Fase 1 · Analizar

Identifica:

```text
Entrada:
cantidadNotas
cada nota

Proceso:
validar
acumular
contar aprobados y suspensos
actualizar máximo y mínimo
calcular media

Salida:
media
aprobados
suspensos
máximo
mínimo
```

No escribas todavía el pseudocódigo completo.

## Fase 2 · Diseñar los datos

Una posible lista de variables es:

```text
cantidadNotas
nota
sumaNotas
aprobados
suspensos
notaMaxima
notaMinima
media
```

Explica qué representa cada una y cómo debe inicializarse.

## Fase 3 · Descomponer

Puedes crear funciones como:

```text
esNotaValida(nota)
actualizarEstadisticas(...)
```

No existe una única descomposición correcta. Lo importante es que cada pieza tenga una responsabilidad comprensible.

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion19/mapa-proyecto.svg
Entrada de notas → Validación → Acumulación/contadores → Cálculo final → Informe. -->

## Fase 4 · Diseñar el bucle

El algoritmo debe procesar exactamente la cantidad prevista de notas válidas. Si decides permitir repetir una nota inválida, piensa si debe contar como una de las notas procesadas.

Esta decisión forma parte de los requisitos y debe quedar documentada.

## Fase 5 · Máximo y mínimo

Debes decidir cómo inicializar `notaMaxima` y `notaMinima`.

Una estrategia habitual consiste en utilizar la primera nota válida como valor inicial y procesar las siguientes comparándolas con ella.

Esto evita inventar valores artificiales.

## Fase 6 · Pseudocódigo orientativo

No copies esta estructura sin entenderla; úsala como referencia para comparar tu diseño.

```text
INICIO
    LEER cantidadNotas

    sumaNotas ← 0
    aprobados ← 0
    suspensos ← 0

    PARA i DESDE 1 HASTA cantidadNotas HACER
        LEER nota

        MIENTRAS NO esNotaValida(nota) HACER
            ESCRIBIR "Nota no válida"
            LEER nota
        FIN MIENTRAS

        sumaNotas ← sumaNotas + nota

        SI i = 1 ENTONCES
            notaMaxima ← nota
            notaMinima ← nota
        SINO
            SI nota > notaMaxima ENTONCES
                notaMaxima ← nota
            FIN SI
            SI nota < notaMinima ENTONCES
                notaMinima ← nota
            FIN SI
        FIN SI

        SI nota >= 5 ENTONCES
            aprobados ← aprobados + 1
        SINO
            suspensos ← suspensos + 1
        FIN SI
    FIN PARA

    media ← sumaNotas / cantidadNotas

    ESCRIBIR media
    ESCRIBIR aprobados
    ESCRIBIR suspensos
    ESCRIBIR notaMaxima
    ESCRIBIR notaMinima
FIN
```

Debes añadir una estrategia para el caso `cantidadNotas <= 0` antes de considerar terminada la solución.

## Fase 7 · Casos de prueba

Incluye como mínimo:

| Caso | Datos | Qué pretende comprobar |
|---|---|---|
| Normal | `5, 7, 8, 4` | Media, aprobados y suspensos |
| Todos aprobados | `6, 7, 9` | Contadores |
| Límites | `0, 10, 5` | Valores permitidos |
| Nota inválida | `11` o `-1` | Validación |
| Un solo dato | `8` | Máximo y mínimo iguales |

Calcula manualmente el resultado esperado de cada caso.

## Fase 8 · Diagrama de flujo

Construye un diagrama general. No intentes meter todo en una sola figura si pierde legibilidad. Puedes representar el proceso principal y utilizar subprocesos para las funciones.

Tu diagrama debería mostrar claramente:

```text
Inicio
  ↓
Leer cantidad
  ↓
Procesar notas en bucle
  ↓
Calcular media
  ↓
Mostrar estadísticas
  ↓
Fin
```

## Entregables

Entrega:

1. Análisis de entrada, proceso y salida.
2. Lista de variables y significado.
3. Diagrama de flujo.
4. Pseudocódigo completo.
5. Descripción de las funciones.
6. Tabla de al menos cinco casos de prueba.
7. Una breve reflexión sobre el error que más te costó resolver.

## Comprobación final

Antes de terminar, revisa:

```text
¿El algoritmo termina?
¿Todas las notas válidas se procesan una sola vez?
¿Una nota inválida altera las estadísticas?
¿La media utiliza solo notas válidas?
¿Máximo y mínimo funcionan con un único valor?
¿He probado 0, 5 y 10?
```

## Siguiente paso

Has recorrido desde la descripción de un problema hasta una solución estructurada y comprobable. El siguiente paso natural es implementar este proyecto en un lenguaje real.

<div class="cla-note"><strong>Continúa con Java</strong><p>Puedes utilizar este proyecto como ejercicio de transición hacia la <a href="/java/">ruta de Java</a>. Conserva el pseudocódigo y los casos de prueba: te servirán como especificación durante la implementación.</p></div>

## Qué debes recordar

Un buen proyecto algorítmico no se mide por la cantidad de símbolos o líneas de pseudocódigo, sino por la claridad de su razonamiento, la cobertura de los casos importantes y la facilidad con la que otra persona puede implementarlo y comprobarlo.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion18/">← Lección 18 · Ejercicios y retos de algoritmia</a>
  <a href="/java/">Continuar con Java →</a>
</div>
