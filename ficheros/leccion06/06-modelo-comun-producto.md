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
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: punto-de-partida
    title: "Punto de partida"
  - id: conceptos-clave
    title: "Conceptos clave"
  - id: mapa-visual
    title: "Mapa visual"
  - id: ejemplo-guiado
    title: "Ejemplo guiado"
  - id: relacion-con-el-resto-de-la-ruta
    title: "Relación con el resto de la ruta"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: que-debes-recordar
    title: "Qué debes recordar"
  - id: microproyecto-validar-producto
    title: "Microproyecto · Validar Producto"
  - id: ampliacion-practica-el-mismo-catalogo-de-productos
    title: "Ampliación práctica: el mismo catálogo de productos"
---

# Modelo común Producto

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Definir un modelo común que reutilizarás en varios formatos.
- Separar el dominio de los detalles del fichero.

## Punto de partida
{: #punto-de-partida }

Si cada formato utiliza un modelo distinto, no podrás comparar fácilmente CSV, JSON y XML.

<div class="cla-note"><strong>Dominio común</strong><p><code>Producto</code> será estable durante CSV, JSON y XML. Eso permitirá observar qué cambia realmente cuando cambia el formato.</p></div>

## Conceptos clave
{: #conceptos-clave }

- Un `record` es apropiado para datos inmutables sencillos en Java 21.
- El identificador permite implementar operaciones CRUD.
- El modelo no debería contener lógica de lectura de ficheros.

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/06.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/06.webp' | relative_url }}" alt="Modelo de dominio. Un Producto reúne identidad, nombre y precio. El constructor comprueba que el estado es válido." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Ejemplo guiado
{: #ejemplo-guiado }

```java
public record Producto(long id, String nombre, double precio) {
    public Producto {
        if (id <= 0) {
            throw new IllegalArgumentException("id debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre obligatorio");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("precio no puede ser negativo");
        }
    }
}
```

## Relación con el resto de la ruta
{: #relacion-con-el-resto-de-la-ruta }

CSV, JSON y XML mapearán sus datos al mismo `Producto`, de modo que la lógica CRUD no tenga que reinventarse.

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Añade el campo `stock` al record y valida que no sea negativo.
2. Crea dos instancias válidas y prueba una inválida.

## Qué debes recordar
{: #que-debes-recordar }

- El modelo representa el dato, no el formato.
- Las invariantes sencillas pueden protegerse en el constructor del record.


## Microproyecto · Validar Producto
{: #microproyecto-validar-producto }

Devuelve id:nombre:precio para datos válidos. Exige id positivo, nombre no vacío y precio finito y no negativo.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F06-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F06-tarea-01.webp' | relative_url }}" alt="Validar Producto. Resultado esperado: 2:Ratón:5.0" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** 2:Ratón:5.0.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion06/F06-tarea-01.zip' | relative_url }}">Descargar F06-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion05/' | relative_url }}">← 5 · Maven y dependencias</a>
  <a href="{{ '/ficheros/leccion07/' | relative_url }}">7 · El formato CSV →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos
{: #ampliacion-practica-el-mismo-catalogo-de-productos }

El mismo modelo se comparte entre CSV, JSON y XML. No contiene código de persistencia ni anotaciones Jackson: la conversión queda en cada implementación.

**Archivo real: `model/Producto.java`**

```java
package es.educacion.ficheros.model;

/** Modelo de dominio compartido por los tres formatos. */
public record Producto(long id, String nombre, double precio) {
    public Producto {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser positivo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio debe ser finito y no negativo");
        }
    }
}
```

La arquitectura final seguirá utilizando exactamente este modelo. Al ser un `record`, sus accesores son `id()`, `nombre()` y `precio()`; no existen `getId()`, `getNombre()` o `getPrecio()`. En un `update` se sustituye el record completo por otro con el mismo identificador.
