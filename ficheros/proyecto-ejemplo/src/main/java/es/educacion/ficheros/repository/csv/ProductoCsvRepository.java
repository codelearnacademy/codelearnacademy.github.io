package es.educacion.ficheros.repository.csv;

import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.repository.AbstractFileRepository;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.RepositoryException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoCsvRepository
        extends AbstractFileRepository<Producto, Long>
        implements IProductoRepository {

    private static final CSVFormat READ_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader("id", "nombre", "precio")
            .setSkipHeaderRecord(true)
            .build();

    private static final CSVFormat WRITE_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader("id", "nombre", "precio")
            .build();

    public ProductoCsvRepository(Path path) {
        super(path, Producto::id);
        entities = readAll();
    }

    @Override
    protected List<Producto> readAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVParser parser = READ_FORMAT.parse(reader)) {

            List<Producto> productos = new ArrayList<>();

            for (CSVRecord record : parser) {
                if (record.size() == 0) {
                    continue;
                }
                productos.add(new Producto(
                        Long.parseLong(record.get("id")),
                        record.get("nombre"),
                        Double.parseDouble(record.get("precio"))
                ));
            }

            return productos;
        } catch (IOException | RuntimeException e) {
            throw new RepositoryException("Error leyendo productos desde CSV: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Producto> productos) {
        try {
            createParentDirectories();

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
                 CSVPrinter printer = new CSVPrinter(writer, WRITE_FORMAT)) {

                for (Producto producto : productos) {
                    printer.printRecord(producto.id(), producto.nombre(), producto.precio());
                }
            }
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo productos en CSV: " + path, e);
        }
    }

    private void createParentDirectories() throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}
