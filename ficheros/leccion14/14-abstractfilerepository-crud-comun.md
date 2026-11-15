---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion14"
lesson_file: "14-abstractfilerepository-crud-comun"
lesson_number: "14"
title: "AbstractFileRepository: CRUD común en memoria"
description: "Extraer el CRUD común y dejar readAll/writeAll como únicos puntos dependientes del formato."
permalink: "/ficheros/leccion14/"
lessons:
  - id: mapa-visual
    title: "Mapa visual"
  - id: de-donde-sale
    title: "De dónde sale"
  - id: solo-dos-metodos-abstractos
    title: "Solo dos métodos abstractos"
  - id: el-fichero-se-carga-una-sola-vez
    title: "El fichero se carga una sola vez"
  - id: por-que-usamos-function-t-id
    title: "¿Por qué usamos Function<T, ID>?"
  - id: una-decision-importante-en-persist
    title: "Una decisión importante en persist"
  - id: microproyecto-guardar-antes-de-publicar
    title: "Microproyecto · Guardar antes de publicar"
---

# `AbstractFileRepository<T, ID>`

## Mapa visual
{: #mapa-visual }

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/conceptos/14.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/conceptos/14.webp' | relative_url }}" alt="Preparar → guardar → publicar. Prepara la modificación en una copia de la colección. Publica el estado en memoria cuando la escritura termina." loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

## De dónde sale
{: #de-donde-sale }

En `CsvCrudDemo`, `create`, `update`, `delete` y `findById` trabajan sobre una colección. El formato solo determina cómo convertir entre esa colección y el fichero.

La clase abstracta del proyecto final es:

```java
package es.educacion.ficheros.repository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbstractFileRepository<T, ID>
        implements IRepository<T, ID> {

    protected final Path path;
    protected List<T> entities;

    private final Function<T, ID> idExtractor;

    protected AbstractFileRepository(
            Path path,
            Function<T, ID> idExtractor) {

        this.path = path;
        this.idExtractor = idExtractor;
        this.entities = new ArrayList<>();
    }

    protected abstract List<T> readAll();

    protected abstract void writeAll(List<T> entities);

    @Override
    public List<T> findAll() {
        return List.copyOf(entities);
    }

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity -> Objects.equals(
                        idExtractor.apply(entity), id))
                .findFirst();
    }

    @Override
    public void create(T entity) {
        ID id = idExtractor.apply(entity);

        if (findById(id).isPresent()) {
            throw new IllegalArgumentException(
                    "Ya existe una entidad con identificador: " + id);
        }

        List<T> updated = new ArrayList<>(entities);
        updated.add(entity);
        persist(updated);
    }

    @Override
    public boolean update(T entity) {
        ID id = idExtractor.apply(entity);
        List<T> updated = new ArrayList<>(entities);

        for (int i = 0; i < updated.size(); i++) {
            if (Objects.equals(
                    idExtractor.apply(updated.get(i)), id)) {
                updated.set(i, entity);
                persist(updated);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(ID id) {
        List<T> updated = new ArrayList<>(entities);

        boolean removed = updated.removeIf(entity ->
                Objects.equals(idExtractor.apply(entity), id));

        if (removed) {
            persist(updated);
        }
        return removed;
    }

    private void persist(List<T> updated) {
        writeAll(updated);
        entities = new ArrayList<>(updated);
    }
}
```

## Solo dos métodos abstractos
{: #solo-dos-metodos-abstractos }

```java
protected abstract List<T> readAll();
protected abstract void writeAll(List<T> entities);
```

La clase abstracta **no declara ni captura `IOException`**. CSV, JSON y XML controlarán sus propias excepciones.

## El fichero se carga una sola vez
{: #el-fichero-se-carga-una-sola-vez }

`AbstractFileRepository` mantiene la colección `entities` en memoria. Cada repositorio concreto hará en su constructor:

```java
entities = readAll();
```

A partir de ahí:

```text
constructor → readAll() → entities
                       ↓
               CRUD sobre memoria
                       ↓
          writeAll() cuando hay cambios
```

## ¿Por qué usamos `Function<T, ID>`?
{: #por-que-usamos-function-t-id }

No todas las entidades tienen un método `getId()`:

```java
Producto::id
Vehiculo::matricula
```

El extractor permite definir qué campo identifica cada tipo sin imponer una interfaz al modelo.

## Una decisión importante en `persist`
{: #una-decision-importante-en-persist }

Primero se escribe la copia y después se sustituye el estado en memoria:

```java
writeAll(updated);
entities = new ArrayList<>(updated);
```

Si `writeAll` falla con `RepositoryException`, `entities` conserva el estado anterior.


## Microproyecto · Guardar antes de publicar
{: #microproyecto-guardar-antes-de-publicar }

Crea una copia con el ID añadido, entrega la copia a guardar y devuelve la copia únicamente si guardar termina. Nunca alteres la lista original.

<figure class="cla-diagram">
  <a href="{{ '/assets/images/ficheros/microproyectos/F14-tarea-01.webp' | relative_url }}"><img src="{{ '/assets/images/ficheros/microproyectos/F14-tarea-01.webp' | relative_url }}" alt="Guardar antes de publicar. Resultado esperado: Original intacto si falla guardar" loading="lazy" style="max-width:100%;height:auto"></a>
</figure>

**Resultado esperado:** Original intacto si falla guardar.

<div class="cla-lesson-nav">
  <a href="{{ '/assets/proyectos/ficheros/leccion14/F14-tarea-01.zip' | relative_url }}">Descargar F14-tarea-01</a>
</div>

<div class="cla-lesson-nav"><a href="{{ '/ficheros/leccion13/' | relative_url }}">← 13 · Contratos</a><a href="{{ '/ficheros/leccion15/' | relative_url }}">15 · ProductoCsvRepository →</a></div>
