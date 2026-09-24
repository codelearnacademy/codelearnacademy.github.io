---
layout: "lesson"
route: "ficheros"
lesson_id: "leccion17"
lesson_file: "17-ejercicio-catalogo-de-productos-csv-repositorios"
lesson_number: "17"
title: "Ejercicio: catálogo de productos CSV con repositorios"
description: "Refactorización de CsvCrudDemo hacia una arquitectura de repositorios reutilizable para CSV y preparada para JSON/XML."
permalink: "/ficheros/leccion17/"
---

# Ejercicio: catálogo de productos CSV con repositorios

## Qué vas a conseguir

En este ejercicio vas a partir del ejemplo `CsvCrudDemo.java` y lo vas a refactorizar para separar:

- el modelo de dominio;
- el contrato CRUD;
- los contratos específicos de cada entidad;
- la lógica común de los repositorios basados en ficheros;
- la lógica específica del formato CSV;
- la conversión entre una fila CSV y un objeto `Producto`.

La solución debe seguir funcionando con Apache Commons CSV y debe quedar preparada para que, en ejercicios posteriores, puedas añadir repositorios JSON y XML sin modificar el contrato de negocio ni duplicar el CRUD.

Además:

- las interfaces no declararán excepciones checked;
- las excepciones técnicas de entrada/salida quedarán encapsuladas dentro de la infraestructura;
- `Producto` no conocerá CSV, JSON ni XML;
- Apache Commons CSV seguirá siendo responsable del quoting y del escape de campos;
- se mantendrá UTF-8.

---

# Punto de partida

Partimos conceptualmente de una clase similar a `CsvCrudDemo.java`, donde una misma clase contiene:

- el modelo `Producto`;
- la ruta del fichero;
- el formato CSV;
- las operaciones `findAll`, `findById`, `create`, `update` y `delete`;
- la conversión CSV ↔ `Producto`;
- el método `main`.

Ese código funciona, pero tiene demasiadas responsabilidades.

El objetivo de este ejercicio es distribuir esas responsabilidades entre interfaces, clases abstractas e implementaciones concretas.

---

# Restricciones del ejercicio

Debes cumplir estas reglas:

1. Las interfaces `Repository` y `ProductoRepository` no deben declarar `throws IOException`.
2. El CRUD genérico debe implementarse una sola vez.
3. La lógica CSV debe estar separada de la lógica CRUD.
4. `Producto` no debe importar ninguna clase de Apache Commons CSV.
5. El repositorio concreto de productos solo debe conocer:
   - cómo obtener el identificador;
   - cómo convertir una fila CSV en `Producto`;
   - cómo convertir un `Producto` en una fila CSV.
6. Los errores técnicos de lectura/escritura deben transformarse en una excepción no comprobada propia, por ejemplo `RepositoryException`.
7. El diseño debe permitir añadir más adelante:
   - `AbstractJsonRepository`;
   - `AbstractXmlRepository`;
   - `ProductoJsonRepository`;
   - `ProductoXmlRepository`.
8. Debes mantener el comportamiento esperado del ejercicio:
   - listar;
   - buscar por id;
   - crear;
   - actualizar;
   - eliminar;
   - rechazar ids duplicados;
   - validar precio y stock;
   - conservar comas, caracteres UTF-8 y persistencia.

---

# Estructura propuesta del proyecto

Una posible estructura Maven es:

```text
src/
└── main/
    └── java/
        └── com/ejemplo/catalogo/
            ├── model/
            │   └── Producto.java
            │
            ├── repository/
            │   ├── Repository.java
            │   ├── ProductoRepository.java
            │   └── RepositoryException.java
            │
            ├── repository/file/
            │   ├── AbstractFileRepository.java
            │   │
            │   └── csv/
            │       ├── AbstractCsvRepository.java
            │       └── ProductoCsvRepository.java
            │
            └── Main.java

data/
└── productos.csv
```

---

# Árbol de dependencias

```text
                         Repository<T, ID>
                         <<interface>>
                               ▲
                               │ extends
                               │
                     ProductoRepository
                         <<interface>>
                               ▲
                               │ implements
                               │
                    ProductoCsvRepository
                               │
                               │ extends
                               ▼
                    AbstractCsvRepository
                               │
                               │ extends
                               ▼
                   AbstractFileRepository<T, ID>
                               │
                               │ implements
                               └──────────────► Repository<T, ID>
```

Dependencias con el modelo y la librería:

```text
ProductoCsvRepository ─────────────► Producto

AbstractCsvRepository ─────────────► Apache Commons CSV
                                     ├── CSVFormat
                                     ├── CSVParser
                                     ├── CSVPrinter
                                     └── CSVRecord
```

Preparación futura:

```text
                     AbstractFileRepository
                              ▲
             ┌────────────────┼────────────────┐
             │                │                │
             │                │                │
 AbstractCsvRepository AbstractJsonRepository AbstractXmlRepository
             ▲                ▲                ▲
             │                │                │
 ProductoCsvRepository ProductoJsonRepository ProductoXmlRepository
```

---

# Paso 1. Extraer el modelo `Producto`

El modelo debe estar completamente separado del formato de persistencia.

Una posible definición es:

```java
package com.ejemplo.catalogo.model;

public record Producto(
        long id,
        String nombre,
        double precio,
        int stock
) {
}
```

El modelo no debe conocer:

- `CSVRecord`;
- `CSVPrinter`;
- `ObjectMapper`;
- `XmlMapper`;
- rutas de fichero.

Su única responsabilidad es representar un producto.

---

# Paso 2. Crear el contrato genérico `Repository`

Crea una interfaz genérica para las operaciones CRUD:

```java
package com.ejemplo.catalogo.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    void create(T entity);

    boolean update(T entity);

    boolean delete(ID id);
}
```

Observa que no aparece:

```java
throws IOException
```

El contrato no debe depender del mecanismo de persistencia.

---

# Paso 3. Crear `ProductoRepository`

Crea un contrato específico para productos:

```java
package com.ejemplo.catalogo.repository;

import com.ejemplo.catalogo.model.Producto;

public interface ProductoRepository
        extends Repository<Producto, Long> {
}
```

Por ahora no añade métodos nuevos.

Más adelante podría incorporar operaciones propias del dominio, por ejemplo:

```java
List<Producto> findByNombre(String nombre);
```

o:

```java
List<Producto> findSinStock();
```

La ventaja es que el resto de la aplicación puede depender de `ProductoRepository` sin conocer si los datos están almacenados en CSV, JSON o XML.

---

# Paso 4. Crear `RepositoryException`

Las interfaces no exponen excepciones checked, pero las operaciones de fichero sí pueden producir errores.

Crea una excepción propia no comprobada:

```java
package com.ejemplo.catalogo.repository;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Esta excepción servirá como frontera entre:

```text
infraestructura técnica
        ↓
IOException
        ↓
RepositoryException
        ↓
aplicación
```

De esta forma, el resto del programa no necesita conocer `IOException`.

---

# Paso 5. Crear `AbstractFileRepository`

Esta clase debe contener la lógica CRUD común a cualquier repositorio basado en fichero.

Debe implementar:

- `findAll`;
- `findById`;
- `create`;
- `update`;
- `delete`.

Y debe dejar como operaciones abstractas únicamente aquello que depende de la forma concreta de almacenar los datos.

Una posible definición es:

```java
package com.ejemplo.catalogo.repository.file;

import com.ejemplo.catalogo.repository.Repository;
import com.ejemplo.catalogo.repository.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractFileRepository<T, ID>
        implements Repository<T, ID> {

    protected final Path path;

    protected AbstractFileRepository(Path path) {
        this.path = path;
    }

    protected abstract List<T> readAll() throws IOException;

    protected abstract void writeAll(List<T> entities)
            throws IOException;

    protected abstract ID getId(T entity);

    @Override
    public List<T> findAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try {
            return readAll();
        } catch (IOException e) {
            throw new RepositoryException(
                    "Error leyendo el fichero: " + path,
                    e
            );
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return findAll()
                .stream()
                .filter(entity -> getId(entity).equals(id))
                .findFirst();
    }

    @Override
    public void create(T entity) {
        List<T> entities = findAll();

        ID id = getId(entity);

        boolean exists = entities.stream()
                .anyMatch(
                        current -> getId(current).equals(id)
                );

        if (exists) {
            throw new IllegalArgumentException(
                    "Id duplicado: " + id
            );
        }

        entities.add(entity);
        saveAll(entities);
    }

    @Override
    public boolean update(T entity) {
        List<T> entities = findAll();

        ID id = getId(entity);

        for (int i = 0; i < entities.size(); i++) {
            if (getId(entities.get(i)).equals(id)) {
                entities.set(i, entity);
                saveAll(entities);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(ID id) {
        List<T> entities = findAll();

        boolean removed = entities.removeIf(
                entity -> getId(entity).equals(id)
        );

        if (removed) {
            saveAll(entities);
        }

        return removed;
    }

    private void saveAll(List<T> entities) {
        try {
            Path parent = path.getParent();

            if (parent != null) {
                Files.createDirectories(parent);
            }

            writeAll(entities);

        } catch (IOException e) {
            throw new RepositoryException(
                    "Error escribiendo el fichero: " + path,
                    e
            );
        }
    }
}
```

## Qué debes observar

`AbstractFileRepository` sabe hacer CRUD, pero no sabe:

- qué es CSV;
- qué es JSON;
- qué es XML;
- cómo se serializa un `Producto`.

Solo conoce dos operaciones de persistencia:

```java
readAll()
writeAll(...)
```

Este es el punto clave del diseño.

---

# Paso 6. Crear `AbstractCsvRepository`

Ahora crea una especialización para CSV.

Esta clase debe encargarse exclusivamente de:

- abrir el fichero con UTF-8;
- configurar Apache Commons CSV;
- leer registros;
- escribir registros;
- delegar la conversión de cada registro a la subclase.

Una posible implementación es:

```java
package com.ejemplo.catalogo.repository.file.csv;

import com.ejemplo.catalogo.repository.file.AbstractFileRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCsvRepository<T, ID>
        extends AbstractFileRepository<T, ID> {

    private final CSVFormat inputFormat;
    private final CSVFormat outputFormat;

    protected AbstractCsvRepository(
            Path path,
            String... headers
    ) {
        super(path);

        this.inputFormat = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .get();

        this.outputFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .get();
    }

    protected abstract T fromCsv(CSVRecord record);

    protected abstract Object[] toCsv(T entity);

    @Override
    protected List<T> readAll() throws IOException {

        List<T> result = new ArrayList<>();

        try (
                Reader reader =
                        Files.newBufferedReader(
                                path,
                                StandardCharsets.UTF_8
                        );

                CSVParser parser =
                        inputFormat.parse(reader)
        ) {
            for (CSVRecord record : parser) {
                result.add(fromCsv(record));
            }
        }

        return result;
    }

    @Override
    protected void writeAll(List<T> entities)
            throws IOException {

        try (
                Writer writer =
                        Files.newBufferedWriter(
                                path,
                                StandardCharsets.UTF_8
                        );

                CSVPrinter printer =
                        new CSVPrinter(writer, outputFormat)
        ) {
            for (T entity : entities) {
                printer.printRecord(toCsv(entity));
            }
        }
    }
}
```

Esta clase no conoce `Producto`.

---

# Paso 7. Crear `ProductoCsvRepository`

Ahora implementa la clase concreta de productos.

Su responsabilidad será únicamente adaptar:

```text
CSVRecord ↔ Producto
```

y proporcionar el identificador.

```java
package com.ejemplo.catalogo.repository.file.csv;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Path;

public class ProductoCsvRepository
        extends AbstractCsvRepository<Producto, Long>
        implements ProductoRepository {

    public ProductoCsvRepository(Path path) {
        super(
                path,
                "id",
                "nombre",
                "precio",
                "stock"
        );
    }

    @Override
    protected Producto fromCsv(CSVRecord record) {
        return new Producto(
                Long.parseLong(record.get("id")),
                record.get("nombre"),
                Double.parseDouble(record.get("precio")),
                Integer.parseInt(record.get("stock"))
        );
    }

    @Override
    protected Object[] toCsv(Producto producto) {
        return new Object[]{
                producto.id(),
                producto.nombre(),
                producto.precio(),
                producto.stock()
        };
    }

    @Override
    protected Long getId(Producto producto) {
        return producto.id();
    }
}
```

---

# Paso 8. Añadir validación del dominio

El ejercicio debe rechazar:

- identificadores duplicados;
- precios negativos;
- stock negativo.

La comprobación de id duplicado ya está en `AbstractFileRepository`.

La validación de precio y stock no debe mezclarse con Apache Commons CSV.

Una opción sencilla es validar el propio `Producto`:

```java
package com.ejemplo.catalogo.model;

public record Producto(
        long id,
        String nombre,
        double precio,
        int stock
) {

    public Producto {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "El id debe ser positivo"
            );
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre es obligatorio"
            );
        }

        if (precio < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo"
            );
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo"
            );
        }
    }
}
```

De esta manera la validación pertenece al dominio y no al código CSV.

---

# Paso 9. Crear el programa de prueba

El `main` debe trabajar contra `ProductoRepository`, no directamente contra la implementación concreta durante las operaciones.

```java
package com.ejemplo.catalogo;

import com.ejemplo.catalogo.model.Producto;
import com.ejemplo.catalogo.repository.ProductoRepository;
import com.ejemplo.catalogo.repository.file.csv.ProductoCsvRepository;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        ProductoRepository repository =
                new ProductoCsvRepository(
                        Path.of("data", "productos.csv")
                );

        repository.create(
                new Producto(
                        1,
                        "Teclado, mecánico",
                        49.99,
                        10
                )
        );

        repository.create(
                new Producto(
                        2,
                        "Ratón",
                        24.90,
                        25
                )
        );

        repository.create(
                new Producto(
                        3,
                        "Monitor",
                        189.00,
                        7
                )
        );

        repository.findAll()
                .forEach(System.out::println);
    }
}
```

El fichero resultante debe ser equivalente a:

```csv
id,nombre,precio,stock
1,"Teclado, mecánico",49.99,10
2,Ratón,24.9,25
3,Monitor,189.0,7
```

No debes añadir las comillas manualmente.

Apache Commons CSV debe encargarse del quoting.

---

# Paso 10. Comprobar el CRUD

Realiza las siguientes pruebas.

## 10.1 Listar

```java
repository.findAll()
        .forEach(System.out::println);
```

Debes obtener todos los productos persistidos.

## 10.2 Buscar por id

```java
repository.findById(2L)
        .ifPresent(System.out::println);
```

Debes obtener el producto con id `2`.

## 10.3 Actualizar

```java
repository.update(
        new Producto(
                2,
                "Ratón inalámbrico",
                34.90,
                20
        )
);
```

Comprueba que:

- el producto `2` cambia;
- `"Teclado, mecánico"` sigue siendo un único campo;
- el resto de productos permanece intacto.

## 10.4 Eliminar

```java
repository.delete(3L);
```

Comprueba que el producto `3` desaparece del fichero.

## 10.5 Crear

```java
repository.create(
        new Producto(
                4,
                "Cámara ñandú €",
                89.95,
                5
        )
);
```

Comprueba que los caracteres UTF-8 se mantienen correctamente.

---

# Paso 11. Comprobar id duplicado

Intenta ejecutar:

```java
repository.create(
        new Producto(
                1,
                "Otro producto",
                10.00,
                1
        )
);
```

Debe producir una excepción:

```text
IllegalArgumentException
```

con un mensaje similar a:

```text
Id duplicado: 1
```

---

# Paso 12. Comprobar validaciones

Prueba:

```java
new Producto(
        5,
        "Producto incorrecto",
        -10.0,
        3
);
```

Debe rechazarse.

También:

```java
new Producto(
        6,
        "Producto incorrecto",
        10.0,
        -1
);
```

Debe rechazarse.

Estas validaciones no deben encontrarse dentro de `ProductoCsvRepository`.

---

# Paso 13. Comprobar la persistencia real

Después de cada modificación:

1. finaliza el programa;
2. vuelve a ejecutarlo sin borrar el fichero;
3. utiliza `findAll`;
4. comprueba que los datos anteriores siguen presentes.

También puedes crear una nueva instancia:

```java
ProductoRepository otroRepository =
        new ProductoCsvRepository(
                Path.of("data", "productos.csv")
        );

otroRepository.findAll()
        .forEach(System.out::println);
```

La nueva instancia debe recuperar los datos escritos por la anterior.

---

# Paso 14. Atención al `main` y los ids duplicados

Si tu `main` contiene siempre:

```java
repository.create(
        new Producto(1, "Teclado, mecánico", 49.99, 10)
);
```

la segunda vez que ejecutes el programa el id `1` ya existirá.

Eso significa que la validación funciona correctamente.

Para una demostración repetible puedes:

- borrar manualmente `data/productos.csv` antes de ejecutar;
- crear un método de inicialización solo para pruebas;
- comprobar primero si el id existe antes de insertar.

No conviertas esa lógica de demostración en comportamiento normal del repositorio.

---

# Paso 15. Dependencia Maven

Incluye Apache Commons CSV en el `pom.xml`.

Ejemplo:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>${commons-csv.version}</version>
</dependency>
```

Puedes definir la versión en las propiedades del proyecto:

```xml
<properties>
    <maven.compiler.release>21</maven.compiler.release>
    <commons-csv.version>1.14.1</commons-csv.version>
</properties>
```

Si tu proyecto utiliza otra versión compatible de Commons CSV, mantén la versión definida por el proyecto.

---

# Paso 16. Qué queda preparado para JSON y XML

El objetivo de `AbstractFileRepository` es que el CRUD no dependa del formato.

Cuando llegues a JSON podrás crear:

```java
public abstract class AbstractJsonRepository<T, ID>
        extends AbstractFileRepository<T, ID> {
}
```

y para XML:

```java
public abstract class AbstractXmlRepository<T, ID>
        extends AbstractFileRepository<T, ID> {
}
```

Los repositorios concretos serán entonces:

```text
ProductoCsvRepository
ProductoJsonRepository
ProductoXmlRepository
```

pero los tres seguirán cumpliendo:

```java
ProductoRepository
```

Por tanto, una clase de servicio podrá declarar:

```java
private final ProductoRepository repository;
```

sin importar el formato real utilizado.

---

# Resultado arquitectónico esperado

Al terminar el ejercicio, debes poder explicar la responsabilidad de cada elemento:

```text
Producto
    Representa el dominio.

Repository<T, ID>
    Define el CRUD genérico.

ProductoRepository
    Define el contrato específico para productos.

RepositoryException
    Encapsula errores técnicos de persistencia.

AbstractFileRepository<T, ID>
    Implementa el CRUD común para repositorios basados en ficheros.

AbstractCsvRepository<T, ID>
    Implementa lectura y escritura mediante Apache Commons CSV.

ProductoCsvRepository
    Traduce entre Producto y CSV.
```

---

# Casos de prueba obligatorios

Comprueba como mínimo los siguientes casos:

1. Crear tres productos.
2. Listarlos.
3. Buscar uno por id.
4. Actualizar uno.
5. Eliminar uno.
6. Intentar insertar un id duplicado.
7. Intentar crear un producto con precio negativo.
8. Intentar crear un producto con stock negativo.
9. Utilizar un nombre que contenga una coma:
   `"Teclado, mecánico"`.
10. Utilizar caracteres UTF-8:
    `ñ`, `á`, `€`.
11. Volver a abrir el fichero después de cada modificación.
12. Verificar que las interfaces no contienen `throws IOException`.

---

# Preguntas de reflexión

Al finalizar, responde:

1. ¿Por qué `Repository` no debe depender de `IOException`?
2. ¿Qué responsabilidad tiene `AbstractFileRepository`?
3. ¿Qué responsabilidad tiene `AbstractCsvRepository`?
4. ¿Por qué `ProductoCsvRepository` no implementa directamente todo el CRUD?
5. ¿Qué ocurriría si mañana cambiamos CSV por JSON?
6. ¿Por qué `Producto` no debe conocer Apache Commons CSV?
7. ¿Qué ventaja aporta trabajar contra `ProductoRepository` en lugar de `ProductoCsvRepository`?
8. ¿Por qué no debemos utilizar `split(",")` para leer CSV?
9. ¿Quién debe encargarse del quoting?
10. ¿Dónde debe realizarse la validación de precio y stock?

---

# Qué debes recordar

- El CRUD opera sobre objetos del dominio, no sobre filas CSV.
- El contrato del repositorio no expone detalles técnicos de entrada/salida.
- Las excepciones técnicas quedan encapsuladas dentro de la infraestructura.
- `AbstractFileRepository` contiene el algoritmo CRUD común.
- `AbstractCsvRepository` contiene únicamente la lógica común del formato CSV.
- `ProductoCsvRepository` adapta `Producto` al formato CSV.
- Apache Commons CSV debe resolver quoting y escape.
- UTF-8 debe utilizarse explícitamente.
- El mismo modelo `Producto` podrá reutilizarse posteriormente con JSON y XML.
