package es.educacion.ficheros.repository.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import es.educacion.ficheros.model.Vehiculo;
import es.educacion.ficheros.repository.AbstractFileRepository;
import es.educacion.ficheros.repository.IVehiculoRepository;
import es.educacion.ficheros.repository.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VehiculoXmlRepository
        extends AbstractFileRepository<Vehiculo, String>
        implements IVehiculoRepository {

    private final XmlMapper mapper = XmlMapper.builder()
            .defaultUseWrapper(false)
            .build();

    public VehiculoXmlRepository(Path path) {
        super(path, Vehiculo::matricula);
        entities = readAll();
    }

    @Override
    protected List<Vehiculo> readAll() {
        if (Files.notExists(path)) {
            return new ArrayList<>();
        }

        try {
            if (Files.size(path) == 0) {
                return new ArrayList<>();
            }

            VehiculosXml data = mapper.readValue(path.toFile(), VehiculosXml.class);
            return data.getVehiculos() == null
                    ? new ArrayList<>()
                    : new ArrayList<>(data.getVehiculos());
        } catch (IOException | RuntimeException e) {
            throw new RepositoryException("Error leyendo vehículos desde XML: " + path, e);
        }
    }

    @Override
    protected void writeAll(List<Vehiculo> vehiculos) {
        try {
            createParentDirectories();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(path.toFile(), new VehiculosXml(vehiculos));
        } catch (IOException e) {
            throw new RepositoryException("Error escribiendo vehículos en XML: " + path, e);
        }
    }

    private void createParentDirectories() throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }

    @JacksonXmlRootElement(localName = "vehiculos")
    public static class VehiculosXml {

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "vehiculo")
        private List<Vehiculo> vehiculos = new ArrayList<>();

        public VehiculosXml() {
        }

        public VehiculosXml(List<Vehiculo> vehiculos) {
            this.vehiculos = vehiculos;
        }

        public List<Vehiculo> getVehiculos() {
            return vehiculos;
        }

        public void setVehiculos(List<Vehiculo> vehiculos) {
            this.vehiculos = vehiculos;
        }
    }
}
