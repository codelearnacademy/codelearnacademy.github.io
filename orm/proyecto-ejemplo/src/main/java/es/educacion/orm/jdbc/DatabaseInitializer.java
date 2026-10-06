package es.educacion.orm.jdbc;

import es.educacion.orm.repository.RepositoryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseInitializer {

    private DatabaseInitializer() {
    }

    public static void createSchema(String url) {
        String producto = """
                CREATE TABLE IF NOT EXISTS producto (
                    id INTEGER PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    precio REAL NOT NULL
                )
                """;

        String vehiculo = """
                CREATE TABLE IF NOT EXISTS vehiculo (
                    matricula TEXT PRIMARY KEY,
                    marca TEXT NOT NULL,
                    modelo TEXT NOT NULL,
                    anio INTEGER NOT NULL
                )
                """;

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(producto);
            statement.execute(vehiculo);
        } catch (SQLException e) {
            throw new RepositoryException("Error creando el esquema", e);
        }
    }
}
