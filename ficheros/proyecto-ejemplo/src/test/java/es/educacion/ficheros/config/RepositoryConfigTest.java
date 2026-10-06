package es.educacion.ficheros.config;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryConfigTest {

    @Test
    void debeLeerValoresYPathsDesdeProperties() {
        RepositoryConfig config = new RepositoryConfig(
                Path.of("src", "test", "resources", "test.properties")
        );

        assertEquals("csv", config.get("repository.productos.type"));
        assertEquals(
                Path.of("target", "test-data", "productos-test.csv"),
                config.getPath("repository.productos.path")
        );
    }

    @Test
    void debeFallarSiLaPropiedadNoExiste() {
        RepositoryConfig config = new RepositoryConfig(
                Path.of("src", "test", "resources", "test.properties")
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> config.get("propiedad.inexistente")
        );
    }
}
