# Persistencia relacional y ORM con Java + SQLite

Proyecto de referencia de la ruta `orm/`.

## Arquitectura

- Dominio: `Producto` y `Vehiculo` como `record`.
- Contratos: `IRepository<T,ID>`, `IProductoRepository`, `IVehiculoRepository`.
- JDBC: `ProductoJdbcRepository`.
- ORM: `ProductoOrmRepository`, `VehiculoOrmRepository`.
- Entidades JPA separadas del dominio.
- Configuración externa mediante `application.properties`.
- SQLite como base tanto para JDBC como para Hibernate.

## Ejecutar tests

```bash
mvn test
```

## Ejecutar la aplicación

Ejecuta `es.educacion.orm.app.Main` desde el IDE o configura `exec-maven-plugin` si quieres lanzarla desde Maven.
