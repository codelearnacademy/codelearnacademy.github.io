---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion19"
lesson_file: "19-deserializar-json"
lesson_number: "19"
title: "Deserializar JSON"
description: "Lectura de productos y colecciones desde JSON con TypeReference."
permalink: "/ficheros/leccion19/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: que-vas-a-conseguir
    title: "Qué vas a conseguir"
  - id: por-que-typereference
    title: "Por qué TypeReference"
  - id: manejo-del-fichero-inexistente
    title: "Manejo del fichero inexistente"
  - id: ejercicios-propuestos
    title: "Ejercicios propuestos"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-importar-json-con-diagnostico
    title: "Microproyecto · Importar JSON con diagnóstico"
---

# Deserializar JSON

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/19.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/19.webp' | relative_url }}" alt="JSON → Java. Una lectura correcta produce datos utilizables por el programa. Una importación puede exigir que exista un documento válido." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Qué vas a conseguir
{: #que-vas-a-conseguir }

- Leer un objeto JSON.
- Leer `List<Producto>`.
- Distinguir el tipo genérico que Jackson necesita en ejecución.

```java
ObjectMapper mapper = new ObjectMapper();
Path path = Path.of("data/productos.json");

List<Producto> productos = mapper.readValue(
        path.toFile(),
        new TypeReference<List<Producto>>() {}
);
```

## Por qué `TypeReference`
{: #por-que-typereference }

`List<Producto>` contiene información genérica que no puede expresarse con `List.class`. `TypeReference` conserva el tipo de los elementos para Jackson.

## Manejo del fichero inexistente
{: #manejo-del-fichero-inexistente }

En un Demo puedes decidir que un fichero inexistente equivale a catálogo vacío:

```java
List<Producto> productos = Files.exists(path)
        ? mapper.readValue(path.toFile(), new TypeReference<>() {})
        : new ArrayList<>();
```

## Ejercicios propuestos
{: #ejercicios-propuestos }

1. Lee tres productos y muéstralos.
2. Cambia un nombre de propiedad y observa el comportamiento.
3. Prueba un número donde esperabas texto.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Importar JSON con diagnóstico
{: #microproyecto-importar-json-con-diagnostico }

Lee un array de objetos y devuelve sus nombres. Una importación requiere el fichero. Propaga IOException si falta o está mal formado.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F19-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F19-tarea-01.webp' | relative_url }}" alt="Importar JSON con diagnóstico. Resultado esperado: Nombres en orden o IOException" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Nombres en orden o IOException.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion19/F19-tarea-01.zip' | relative_url }}">Descargar F19-tarea-01</a>
</div>

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion18/' | relative_url }}">← 18 · Jackson Databind y ObjectMapper</a>
  <a href="{{ '/ficheros/leccion20/' | relative_url }}">20 · Serializar JSON →</a>
</div>
