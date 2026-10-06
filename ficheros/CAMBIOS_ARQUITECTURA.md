# Cambios de arquitectura aplicados a la ruta

La ruta parte de los CRUD monolíticos (`CsvCrudDemo`, `JsonCrudDemo`, `XmlCrudDemo`) y evoluciona hacia el proyecto de ejemplo.

## Secuencia

1. `Producto` como modelo común.
2. `CsvCrudDemo`: CRUD completo inicial.
3. Extracción de `IRepository<T, ID>` y `IProductoRepository`.
4. Extracción de `AbstractFileRepository<T, ID>`.
5. `ProductoCsvRepository` con `readAll()` / `writeAll()`.
6. `JsonCrudDemo` → `ProductoJsonRepository`.
7. `XmlCrudDemo` → `ProductoXmlRepository`.
8. `Vehiculo` + `IVehiculoRepository` para probar la generalización.
9. Repositorios de vehículos en CSV / JSON / XML.
10. `RepositoryConfig` y `application.properties`.

## Decisiones fijadas

- Las interfaces usan prefijo `I`.
- `IProductoRepository extends IRepository<Producto, Long>`.
- `IVehiculoRepository extends IRepository<Vehiculo, String>`.
- Las interfaces no declaran `IOException`.
- `AbstractFileRepository` tampoco maneja excepciones de E/S.
- Sus únicos métodos abstractos son `readAll()` y `writeAll()`.
- Cada implementación concreta controla sus excepciones y lanza `RepositoryException`.
- Cada repositorio concreto carga el fichero una sola vez con `entities = readAll()` en su constructor.
- El CRUD común trabaja sobre `entities` en memoria.
- La identidad se obtiene con `Function<T, ID>` (`Producto::id`, `Vehiculo::matricula`).
- `.properties` configura tipo y ruta, mediante `RepositoryConfig`.
