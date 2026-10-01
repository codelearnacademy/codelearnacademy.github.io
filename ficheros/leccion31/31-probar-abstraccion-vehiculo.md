---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion31"
lesson_file: "31-probar-abstraccion-vehiculo"
lesson_number: "31"
title: "Probar la abstracción con Vehiculo"
description: "Uso de IRepository<Vehiculo, String> con CSV, JSON y XML sin cambiar la API CRUD."
permalink: "/ficheros/leccion31/"
---

# Probar la abstracción con otro modelo: `Vehiculo`

## Objetivo

Una abstracción se demuestra mejor cuando deja de utilizar el mismo modelo con el que fue creada.

Hasta ahora hemos trabajado con:

```java
IRepository<Producto, Long>
```

Ahora vamos a comprobar que la misma API también funciona con otro dominio y con otro tipo de identificador.

```java
public record Vehiculo(
        String matricula,
        String marca,
        String modelo,
        int anio
) {
}
```

En este caso:

- `T` es `Vehiculo`.
- `ID` es `String`.
- la matrícula actúa como identificador del vehículo.

Por tanto, el contrato genérico puede utilizarse como:

```java
IRepository<Vehiculo, String>
```

frente al caso anterior:

```java
IRepository<Producto, Long>
```

<div class="cla-note">
  <p>
    <strong>Qué estamos comprobando.</strong>
    La API CRUD no depende de <code>Producto</code> ni de un identificador
    <code>Long</code>. Puede reutilizarse con otros modelos y otros tipos
    de identificador.
  </p>
</div>

## Un contrato especializado para `Vehiculo`

Igual que hicimos con productos, podemos mantener un contrato específico:

```java
public interface IVehiculoRepository
        extends IRepository<Vehiculo, String> {
}
```

De esta forma, `IVehiculoRepository` conserva una intención de dominio clara,
pero reutiliza todas las operaciones definidas en `IRepository<T, ID>`.

## Implementaciones por formato

Cada implementación concreta fija los tipos `Vehiculo` y `String`.

### CSV

```java
public class VehiculoCsvRepository
        extends AbstractFileRepository<Vehiculo, String>
        implements IVehiculoRepository {

    // lectura y escritura específicas de CSV
}
```

### JSON

```java
public class VehiculoJsonRepository
        extends AbstractFileRepository<Vehiculo, String>
        implements IVehiculoRepository {

    // lectura y escritura específicas de JSON
}
```

### XML

```java
public class VehiculoXmlRepository
        extends AbstractFileRepository<Vehiculo, String>
        implements IVehiculoRepository {

    // lectura y escritura específicas de XML
}
```

## Tres ficheros equivalentes

La ruta incluye tres ficheros con los mismos datos:

- `data/vehiculos.csv`
- `data/vehiculos.json`
- `data/vehiculos.xml`

Los tres representan los mismos vehículos.

Lo que cambia es el formato de persistencia. La aplicación continúa trabajando
con objetos `Vehiculo` y con el mismo contrato CRUD.

## Instanciar cada implementación

### CSV

```java
IRepository<Vehiculo, String> repository =
        new VehiculoCsvRepository(
                Path.of("data", "vehiculos.csv")
        );
```

### JSON

```java
IRepository<Vehiculo, String> repository =
        new VehiculoJsonRepository(
                Path.of("data", "vehiculos.json")
        );
```

### XML

```java
IRepository<Vehiculo, String> repository =
        new VehiculoXmlRepository(
                Path.of("data", "vehiculos.xml")
        );
```

También podemos utilizar el contrato especializado:

```java
IVehiculoRepository repository =
        new VehiculoCsvRepository(
                Path.of("data", "vehiculos.csv")
        );
```

## El código consumidor prácticamente no cambia

Una vez creada la implementación, las operaciones utilizadas por la aplicación
son las mismas:

```java
repository.findAll();

repository.findById("1234ABC");

repository.create(vehiculo);

repository.update(vehiculo);

repository.delete("1234ABC");
```

La diferencia está en la implementación concreta utilizada para persistir los datos,
no en la API consumida por la aplicación.

```text
                    IRepository<T, ID>
                           ▲
             ┌─────────────┴─────────────┐
             │                           │
IProductoRepository            IVehiculoRepository
Producto, Long                 Vehiculo, String
```

<div class="cla-note">
  <p>
    <strong>Qué demuestra el ejemplo.</strong>
    No hemos abstraído únicamente el formato de persistencia: también hemos
    eliminado el acoplamiento del contrato CRUD a <code>Producto</code> y
    <code>Long</code>.
  </p>
</div>

<div class="cla-lesson-nav">
  <a href="/ficheros/leccion30/">← 30 · IRepository&lt;T, ID&gt;</a>
  <a href="/ficheros/leccion32/">32 · Configuración .properties →</a>
</div>
