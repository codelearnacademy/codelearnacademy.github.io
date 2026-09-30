---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion23"
lesson_file: "23-ejercicio-inventario-json"
lesson_number: "23"
title: "Ejercicio: inventario JSON con repositorios"
description: "Ejercicio: inventario JSON: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion23/"
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

# Ejercicio: inventario JSON

## Qué vas a conseguir

- Resolver un inventario JSON de forma autónoma.
- Añadir una regla de negocio que no pertenece a Jackson.

## Punto de partida

El reto consiste en aplicar reglas de inventario sobre el mismo `Producto` utilizado en CSV y que después se reutilizará en XML.

<div class="cla-note"><strong>Inventario</strong><p>El mismo <code>Producto</code> puede incorporar reglas de stock sin que esas reglas dependan de Jackson.</p></div>

## Conceptos clave

- El repositorio persiste; el servicio aplica reglas como no permitir stock negativo.
- Buscar por id debe distinguir “no existe” de errores de lectura.
- La persistencia sigue reescribiendo el documento completo en este ejercicio.

## Ejemplo guiado

```json
[
  {"id":1,"nombre":"Teclado","precio":49.99,"stock":10},
  {"id":2,"nombre":"Ratón","precio":24.90,"stock":25}
]
```

## Relación con el resto de la ruta

Este ejercicio prepara el salto a XML demostrando que la lógica CRUD puede permanecer aunque cambie el serializador.

## Ejercicios propuestos

1. Reutiliza `Producto`, incluyendo su campo `stock`.
2. Implementa alta, consulta, cambio de precio, ajuste de stock y baja.
3. Impide ids duplicados y stock negativo.
4. Añade una operación `vender(id, cantidad)` que reduzca stock solo si hay unidades suficientes.

## Qué debes recordar

- Las reglas de inventario no deben esconderse dentro de `ObjectMapper`.
- Mantén separadas persistencia y reglas del dominio.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion22/">← 22 · CRUD con JSON</a>
  <a href="/ficheros/leccion24/">24 · El formato XML →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

### Ejercicio equivalente al catálogo CSV, ahora con JSON

Partiendo de la lección 17, **no modifiques** `Producto`, `Repository`, `ProductoRepository` ni el CRUD compartido. Incorpora `AbstractJsonRepository` y `ProductoJsonRepository` y utiliza `productos.json`.

**Archivo real: `repository/file/json/ProductoJsonRepository.java`**

```java
package com.ejemplo.catalogo.repository.file.json;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.util.List;

public class ProductoJsonRepository extends AbstractJsonRepository<Producto, Long> implements ProductoRepository {
    public ProductoJsonRepository(Path path) { this(path, new ObjectMapper()); }
    public ProductoJsonRepository(Path path, ObjectMapper mapper) {
        super(path, mapper, new TypeReference<List<Producto>>() {});
    }
    @Override protected Long getId(Producto producto) { return producto.id(); }
}
```

**Fichero de ejemplo `productos.json`**

```json
[
  {
    "id": 1,
    "nombre": "Teclado, mecanico",
    "precio": 29.99,
    "stock": 10
  },
  {
    "id": 2,
    "nombre": "Raton",
    "precio": 15.5,
    "stock": 25
  },
  {
    "id": 3,
    "nombre": "Monitor",
    "precio": 189.99,
    "stock": 4
  }
]
```

**Tareas:** 1) listar; 2) buscar el id 2 y uno inexistente; 3) crear el id 4; 4) rechazar un duplicado; 5) actualizar el stock del id 2; 6) eliminar el id 1; 7) crear otra instancia y verificar los resultados.

**Ejecuta:** `mvn test` en `proyecto-maven/`; también puedes ejecutar `mvn exec:java -Dexec.args=json`. Explica por qué `readAll` y `writeAll` pertenecen al repositorio de formato, mientras que `create` pertenece a la clase base.
