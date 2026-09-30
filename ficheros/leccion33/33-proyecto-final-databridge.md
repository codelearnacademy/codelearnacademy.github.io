---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion33"
lesson_file: "33-proyecto-final-databridge"
lesson_number: "33"
title: "Proyecto final: DataBridge"
description: "Proyecto final: DataBridge: ruta práctica de ficheros con Java 21."
permalink: "/ficheros/leccion33/"
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

# Proyecto final: DataBridge

## Qué vas a conseguir

- Integrar `.properties`, CSV, JSON y XML en una sola aplicación.
- Importar datos desde un formato y exportarlos a otro reutilizando el mismo modelo.

## Punto de partida

DataBridge combina todo lo aprendido: configuración, repositorios, modelo común y conversión entre formatos.

<div class="cla-note"><strong>Objetivo de la ruta</strong><p>Aprender el formato sin acoplar toda la aplicación a su parser o serializador.</p></div>

## Conceptos clave

- Un repositorio de entrada obtiene `Producto`.
- La lógica trabaja con objetos, no con sintaxis de fichero.
- Un repositorio de salida persiste el resultado en otro formato.

## Ejemplo guiado

```text
config.properties
  input.format=csv
  input.path=data/productos.csv
  output.format=json
  output.path=data/productos.json

CSV → List<Producto> → validación/transformación → JSON
```

```java
List<Producto> productos = input.findAll();
for (Producto p : productos) {
    if (output.findById(p.id()).isEmpty()) {
        output.create(p);
    }
}
```

## Relación con el resto de la ruta

Es la culminación de la ruta: cada formato queda reducido a un adaptador alrededor del mismo modelo y operaciones.

## Ejercicios propuestos

1. Permite las conversiones CSV→JSON, JSON→XML y XML→CSV.
2. Añade una opción de configuración para aplicar un descuento porcentual antes de exportar.
3. Evita sobrescribir el fichero de salida si ya existe salvo que `output.overwrite=true`.

## Qué debes recordar

- La lógica de transformación no debería depender del parser.
- El fichero `.properties` coordina; los repositorios leen y escriben; el modelo transporta los datos.

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion32/">← 32 · Configurar el programa con .properties</a>
  <a href="/ficheros/leccion34/">34 · Retos y ampliaciones →</a>
</div>

---

## Ampliación práctica: el mismo catálogo de productos

### Proyecto entregable: DataBridge sobre el catálogo real

El directorio `proyecto-maven/` incluye `Producto`, el contrato común, los tres repositorios y pruebas JUnit. Amplíalo para leer la configuración `.properties`, abrir un origen CSV/JSON/XML y exportar el resultado a un formato distinto sin duplicar el CRUD.

**Fases de entrega:** (1) compilar Java 21; (2) ejecutar pruebas existentes; (3) implementar selección por configuración; (4) leer el origen y construir el repositorio de destino; (5) guardar una copia sin sobrescribir el origen; (6) comprobar la equivalencia de productos con JUnit.

```bash
cd proyecto-maven
mvn clean test
mvn exec:java -Dexec.args=csv
mvn exec:java -Dexec.args=json
mvn exec:java -Dexec.args=xml
```

**Nota:** los comandos `exec:java` ilustran un formato por ejecución, no realizan todavía una migración entre formatos. La conversión de uno a otro es la actividad que deberá desarrollar el alumnado.
