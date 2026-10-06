# Proyecto de ejemplo de la ruta de ficheros

Este proyecto acompaña a las lecciones 11–33. Incluye los CRUD finales para Producto y Vehiculo en CSV, JSON y XML, junto con `RepositoryConfig` y los tests existentes.

## Arquitectura real incluida

- `IRepository<T, ID>`
- `IProductoRepository extends IRepository<Producto, Long>`
- `IVehiculoRepository extends IRepository<Vehiculo, String>`
- `AbstractFileRepository<T, ID>`
- `ProductoCsvRepository`, `ProductoJsonRepository`, `ProductoXmlRepository`
- `VehiculoCsvRepository`, `VehiculoJsonRepository`, `VehiculoXmlRepository`
- `RepositoryConfig`
- `RepositoryException`

No se incluyen factorías en esta versión. La selección por `repository.*.type` se trabaja en la ruta con un `switch` y puede extraerse a una factoría como ampliación.

Ejecutar tests:

```bash
mvn test
```
