---
layout: lesson
route: algoritmia
lesson_id: leccion08
lesson_number: "08"
title: Entrada y salida de datos
description: Diseña algoritmos que reciben información, la procesan y comunican resultados con claridad.
permalink: /algoritmia/leccion08/
lessons:
  - id: qué-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: datos-de-entrada
    title: "Datos de entrada"
  - id: salida-de-datos
    title: "Salida de datos"
  - id: pedir-datos-con-contexto
    title: "Pedir datos con contexto"
  - id: ejemplo-conversor-de-horas
    title: "Ejemplo: conversor de horas"
  - id: entrada-y-salida-en-diagramas
    title: "Entrada y salida en diagramas"
  - id: diseñar-una-interfaz-mínima
    title: "Diseñar una interfaz mínima"
  - id: ejemplo-datos-de-un-viaje
    title: "Ejemplo: datos de un viaje"
  - id: preparar-la-validación
    title: "Preparar la validación"
  - id: ejercicios
    title: "Ejercicios"
  - id: qué-debes-recordar
    title: "Qué debes recordar"
---

# Entrada y salida de datos

Un algoritmo útil suele comunicarse con el exterior: recibe datos, los procesa y produce resultados. En esta lección aprenderás a diseñar esa interacción de forma clara.

## Qué vas a conseguir

- Diferenciar datos de entrada y resultados de salida.
- Identificar qué información debe pedir un algoritmo.
- Diseñar mensajes comprensibles para el usuario.
- Evitar pedir datos innecesarios.
- Representar entrada y salida en diagramas y algoritmos.

## Punto de partida

El modelo que utilizamos desde el principio es:

```text
Entrada → Proceso → Salida
```

Ahora nos centraremos en los extremos del proceso.

## Datos de entrada

Una entrada es información que el algoritmo necesita para trabajar.

Para calcular una media:

```text
nota1
nota2
nota3
```

Para calcular el coste de una compra:

```text
precioUnidad
cantidad
```

No debemos pedir al usuario un dato que podamos calcular a partir de otros.

## Salida de datos

Una salida comunica un resultado.

```text
Mostrar totalCompra
Mostrar media
Mostrar "Acceso permitido"
```

Una salida debería indicar qué significa el valor. Mostrar únicamente `48` puede ser ambiguo; `Total: 48 €` es mucho más útil.

## Pedir datos con contexto

Compara:

```text
Introduzca un valor:
```

con:

```text
Introduzca la cantidad de unidades:
```

El segundo mensaje reduce errores porque explica qué espera el algoritmo.

## Ejemplo: conversor de horas

```text
Mostrar "Horas:"
Leer horas
minutos = horas * 60
Mostrar "Equivale a", minutos, "minutos"
```

Con `2.5` horas:

```text
Equivale a 150 minutos
```

<!-- IMAGEN SUGERIDA: /assets/images/algoritmia/leccion08/interaccion-usuario.svg
Usuario → Entrada → Algoritmo → Salida → Usuario. -->

## Entrada y salida en diagramas

En un diagrama de flujo, ambas operaciones utilizan el símbolo de entrada/salida.

```text
Inicio
  ↓
Leer radio
  ↓
area = PI * radio * radio
  ↓
Mostrar area
  ↓
Fin
```

Aunque comparten símbolo, el texto deja claro si estamos leyendo o mostrando.

## Diseñar una interfaz mínima

Incluso sin construir una interfaz gráfica podemos pensar en la experiencia del usuario.

Un algoritmo debería:

- pedir solo lo necesario;
- indicar unidades cuando sean relevantes;
- mostrar resultados con contexto;
- mantener un orden lógico de preguntas.

## Ejemplo: datos de un viaje

Queremos calcular el consumo total:

```text
Mostrar "Distancia en km:"
Leer distancia
Mostrar "Consumo en L/100 km:"
Leer consumo
litros = distancia * consumo / 100
Mostrar "Combustible estimado:", litros, "L"
```

Las unidades ayudan a evitar interpretaciones incorrectas.

## Preparar la validación

Más adelante aprenderemos a tomar decisiones. Entonces podremos comprobar, por ejemplo, que una cantidad no sea negativa.

De momento identifica posibles restricciones:

```text
edad: no debería ser negativa
cantidad: normalmente debe ser 0 o mayor
porcentaje: puede requerir un rango concreto
```

Pensar en esas reglas forma parte del análisis.

## Ejercicios

**Ejercicio 1.** Diseña las entradas y salidas de un conversor de euros a otra moneda usando un tipo de cambio dado.

**Ejercicio 2.** Mejora el mensaje `Introduzca valor:` para un algoritmo que calcula el área de un círculo.

**Ejercicio 3.** Indica qué datos pedirías para calcular el coste de un trayecto en taxi con precio por kilómetro.

**Reto.** Diseña el diálogo completo de un algoritmo que calcula el precio final de una compra con descuento. Incluye mensajes y unidades.

## Qué debes recordar

La entrada proporciona información al algoritmo y la salida comunica resultados. Pedir datos claros y mostrar resultados comprensibles forma parte de una buena solución. En la siguiente lección aprenderemos a **tomar decisiones** con esos datos.

<div class="cla-lesson-nav">
  <a href="/algoritmia/leccion07/">← Lección 07 · Variables, constantes y expresiones</a>
  <a href="/algoritmia/leccion09/">Lección 09 · Estructuras condicionales →</a>
</div>
