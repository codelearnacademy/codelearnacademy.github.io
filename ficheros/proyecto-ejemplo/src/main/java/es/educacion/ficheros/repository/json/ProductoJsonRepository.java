package es.educacion.ficheros.repository.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.repository.AbstractFileRepository;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoJsonRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    private final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public ProductoJsonRepository(Path path) {
        super(path, Producto::id);
        entities = readAll();
    }

    @Override
    protected List<Producto> readAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try {
            if (Files.size(path) == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(path.toFile(), new TypeReference<List<Producto>>() {});
        } catch (IOException | RuntimeException e) {
            throw new RepositoryException("Error leyendo productos desde JSON: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Producto> productos) {
        try {
            createParentDirectories();
            mapper.writeValue(path.toFile(), productos);
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo productos en JSON: " + path, e);
        }
    }

    private void createParentDirectories() throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}
