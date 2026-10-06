package es.educacion.ficheros.repository.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.repository.AbstractFileRepository;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoXmlRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    private final XmlMapper mapper = XmlMapper.builder()
            .defaultUseWrapper(false)
            .build();

    public ProductoXmlRepository(Path path) {
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

            ProductosXml data = mapper.readValue(path.toFile(), ProductosXml.class);
            return data.getProductos() == null
                    ? new ArrayList<>()
                    : new ArrayList<>(data.getProductos());
        } catch (IOException | RuntimeException e) {
            throw new RepositoryException("Error leyendo productos desde XML: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Producto> productos) {
        try {
            createParentDirectories();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(path.toFile(), new ProductosXml(productos));
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo productos en XML: " + path, e);
        }
    }

    private void createParentDirectories() throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }

    @JacksonXmlRootElement(localName = "productos")
    public static class ProductosXml {

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "producto")
        private List<Producto> productos = new ArrayList<>();

        public ProductosXml() {
        }

        public ProductosXml(List<Producto> productos) {
            this.productos = productos;
        }

        public List<Producto> getProductos() {
            return productos;
        }

        public void setProductos(List<Producto> productos) {
            this.productos = productos;
        }
    }
}
