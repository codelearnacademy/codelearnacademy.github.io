---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion06"
lesson_file: "06-modelo-comun-producto"
lesson_number: "6"
title: "Modelo común Producto"
description: "Modelo común Producto: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion06/"
lessons:
  - id: "qué-vas-a-conseguir"
    title: "Qué vas a conseguir"
  - id: "punto-de-partida"
    title: "Punto de partida"
  - id: "conceptos-clave"
    title: "Conceptos clave"
  - id: "ejemplo-guiado"
    title: "Ejemplo guiado"
  - id: "relación-con-el-resto-de-la-ruta"
    title: "Relación con el resto de la ruta"
  - id: "ejercicios-propuestos"
    title: "Ejercicios propuestos"
  - id: "qué-debes-recordar"
    title: "Qué debes recordar"
---

# Modelo común Producto

## Qué vas a conseguir

- Definir un modelo común que reutilizarás en varios formatos.
- Separar el dominio de los detalles del fichero.

## Punto de partida

Si cada formato utiliza un modelo distinto, no podrás comparar fácilmente CSV, JSON y XML.

<div class="cla-note"><strong>Dominio común</strong><p><code>Producto</code> será estable durante CSV, JSON y XML. Eso permitirá observar qué cambia realmente cuando cambia el formato.</p></div>

## Conceptos clave

- Un `record` es apropiado para datos inmutables sencillos en Java 21.
- El identificador permite implementar operaciones CRUD.
- El modelo no debería contener lógica de lectura de ficheros.

## Ejemplo guiado

```java
public record Producto(long id, String nombre, double precio) {
    public Producto {
        if (id <= 0) throw new IllegalArgumentException("id debe ser positivo");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre obligatorio");
        if (precio < 0) throw new IllegalArgumentException("precio no puede ser negativo");
    }
}
```

## Relación con el resto de la ruta

CSV, JSON y XML mapearán sus datos al mismo `Producto`, de modo que la lógica CRUD no tenga que reinventarse.

## Ejercicios propuestos

1. Añade el campo `stock` al record y valida que no sea negativo.
2. Crea dos instancias válidas y prueba una inválida.

## Qué debes recordar

- El modelo representa el dato, no el formato.
- Las invariantes sencillas pueden protegerse en el constructor del record.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion05/">← 5 · Maven y dependencias</a>
  <a href="/ficheros/leccion07/">7 · El formato .properties →</a>
</div>
