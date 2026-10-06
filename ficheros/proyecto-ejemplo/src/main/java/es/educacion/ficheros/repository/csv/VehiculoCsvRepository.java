package es.educacion.ficheros.repository.csv;

import es.educacion.ficheros.model.Vehiculo;
import es.educacion.ficheros.repository.AbstractFileRepository;
import es.educacion.ficheros.repository.IVehiculoRepository;
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

public class VehiculoCsvRepository
        extends AbstractFileRepository<Vehiculo, String>
        implements IVehiculoRepository {

    private static final CSVFormat READ_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader("matricula", "marca", "modelo", "anio")
            .setSkipHeaderRecord(true)
            .build();

    private static final CSVFormat WRITE_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader("matricula", "marca", "modelo", "anio")
            .build();

    public VehiculoCsvRepository(Path path) {
        super(path, Vehiculo::matricula);
        entities = readAll();
    }

    @Override
    protected List<Vehiculo> readAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVParser parser = READ_FORMAT.parse(reader)) {

            List<Vehiculo> vehiculos = new ArrayList<>();

            for (CSVRecord record : parser) {
                vehiculos.add(new Vehiculo(
                        record.get("matricula"),
                        record.get("marca"),
                        record.get("modelo"),
                        Integer.parseInt(record.get("anio"))
                ));
            }

            return vehiculos;
        } catch (IOException | RuntimeException e) {
            throw new RepositoryException("Error leyendo vehículos desde CSV: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Vehiculo> vehiculos) {
        try {
            createParentDirectories();

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
                 CSVPrinter printer = new CSVPrinter(writer, WRITE_FORMAT)) {

                for (Vehiculo vehiculo : vehiculos) {
                    printer.printRecord(
                            vehiculo.matricula(),
                            vehiculo.marca(),
                            vehiculo.modelo(),
                            vehiculo.anio()
                    );
                }
            }
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo vehículos en CSV: " + path, e);
        }
    }

    private void createParentDirectories() throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}
