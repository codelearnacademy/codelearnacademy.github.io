package es.educacion.ficheros.config;

import es.educacion.ficheros.repository.RepositoryException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class RepositoryConfig {

    private final Properties properties = new Properties();

    public RepositoryConfig(Path path) {
        try (InputStream input = Files.newInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RepositoryException("Error leyendo el fichero de configuración: " + path, e);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("No existe la propiedad: " + key);
        }
        return value;
    }

    public Path getPath(String key) {
        return Path.of(get(key));
    }
}
