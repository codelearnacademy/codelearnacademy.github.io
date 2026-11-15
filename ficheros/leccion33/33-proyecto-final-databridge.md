---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion33"
lesson_file: "33-proyecto-final-databridge"
lesson_number: "33"
title: "Proyecto final: repositorios de ficheros"
description: "Integrar los CRUD de partida con la arquitectura final para Producto y Vehiculo."
permalink: "/ficheros/leccion33/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: objetivo
    title: "Objetivo"
  - id: clases-que-debe-contener-la-solucion
    title: "Clases que debe contener la solución"
  - id: reglas-de-arquitectura
    title: "Reglas de arquitectura"
  - id: tests-minimos
    title: "Tests mínimos"
  - id: ejercicio-final
    title: "Ejercicio final"
  - id: antes-de-abrir-el-fichero
    title: "Antes de abrir el fichero"
  - id: microproyecto-migrar-catalogo-csv-a-json
    title: "Microproyecto · Migrar catálogo CSV a JSON"
---

# Proyecto final: de los CRUD a los repositorios

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/33.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/33.webp' | relative_url }}" alt="DataBridge. Lee el catálogo usando el repositorio de origen. Escribe el formato de destino y verifica sus IDs al releer." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## Objetivo
{: #objetivo }

El proyecto final no sustituye `CsvCrudDemo`, `JsonCrudDemo` y `XmlCrudDemo`: **explica cómo evolucionan** hasta una arquitectura reutilizable.

```text
CsvCrudDemo / JsonCrudDemo / XmlCrudDemo
                 ↓
       detectar CRUD repetido
                 ↓
          IRepository<T, ID>
                 ↓
 IProductoRepository / IVehiculoRepository
                 ↓
      AbstractFileRepository<T, ID>
        readAll() + writeAll()
                 ↓
 ┌───────────────┼────────────────┐
 CSV             JSON             XML
                 ↓
       RepositoryConfig (.properties)
```

## Clases que debe contener la solución
{: #clases-que-debe-contener-la-solucion }

### Modelo

```text
Producto
Vehiculo
```

### Contratos

```text
IRepository<T, ID>
IProductoRepository
IVehiculoRepository
```

### Infraestructura común

```text
AbstractFileRepository<T, ID>
RepositoryException
```

### CSV

```text
ProductoCsvRepository
VehiculoCsvRepository
```

### JSON

```text
ProductoJsonRepository
VehiculoJsonRepository
```

### XML

```text
ProductoXmlRepository
VehiculoXmlRepository
```

### Configuración

```text
RepositoryConfig
application.properties
```

## Reglas de arquitectura
{: #reglas-de-arquitectura }

1. Las interfaces no declaran `IOException`.
2. `AbstractFileRepository` tampoco controla excepciones de E/S.
3. Cada implementación de formato controla sus propias excepciones y lanza `RepositoryException`.
4. Los únicos métodos abstractos de la clase base son `readAll()` y `writeAll()`.
5. Cada repositorio concreto ejecuta `entities = readAll()` una sola vez en su constructor.
6. El CRUD común trabaja con la colección en memoria.
7. `writeAll()` persiste los cambios antes de sustituir el estado interno.
8. `Producto` se identifica con `Producto::id`.
9. `Vehiculo` se identifica con `Vehiculo::matricula`.
10. La configuración `.properties` contiene los tipos y rutas externas.

## Tests mínimos
{: #tests-minimos }

El proyecto debe incluir:

```text
CsvRepositoryTest
JsonRepositoryTest
XmlRepositoryTest
RepositoryConfigTest
```

Los tres primeros prueban CRUD completo de `Producto` y `Vehiculo`, y además reconstruyen el repositorio para verificar la persistencia real.

## Ejercicio final
{: #ejercicio-final }

Construye una pequeña aplicación que:

1. cargue `application.properties`;
2. cree un repositorio de productos según `repository.productos.type`;
3. cree un repositorio de vehículos según `repository.vehiculos.type`;
4. permita listar, buscar, crear, actualizar y eliminar;
5. cambie de CSV a JSON o XML modificando únicamente la configuración.


## Antes de abrir el fichero
{: #antes-de-abrir-el-fichero }

Anota el directorio de trabajo y la ruta absoluta normalizada. Comprueba si es un fichero regular, una carpeta o una ruta ausente. Trata los errores de acceso de forma separada. Si el archivo es una entrada obligatoria, informa de su ausencia. Si estás abriendo un repositorio nuevo, aplica el contrato de inicialización de la lección.

<div class="cla-lesson-nav">
  <a href="{{ '/ficheros/leccion02/#diagnostico-de-una-ruta-de-fichero' | relative_url }}">Ver cómo diagnosticar la ruta</a>
</div>


## Microproyecto · Migrar catálogo CSV a JSON
{: #microproyecto-migrar-catalogo-csv-a-json }

Lee id,nombre de CSV y exporta un array JSON de objetos con ambos campos. Devuelve la cantidad migrada.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F33-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F33-tarea-01.webp' | relative_url }}" alt="Migrar catálogo CSV a JSON. Resultado esperado: 2 productos y sus identificadores" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** 2 productos y sus identificadores.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion33/F33-tarea-01.zip' | relative_url }}">Descargar F33-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion32/' | relative_url }}">← 32 · .properties</a><a href="{{ '/ficheros/leccion34/' | relative_url }}">34 · Retos y ampliaciones →</a></div>
