package es.educacion.ficheros;

import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.model.Vehiculo;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.IVehiculoRepository;
import es.educacion.ficheros.repository.xml.ProductoXmlRepository;
import es.educacion.ficheros.repository.xml.VehiculoXmlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class XmlRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void crudCompletoProductoXml() {
        Path file = tempDir.resolve("productos.xml");
        IProductoRepository repository = new ProductoXmlRepository(file);

        repository.create(new Producto(1, "Impresora", 120.0));
        repository.create(new Producto(2, "Escáner", 90.0));

        assertEquals(2, repository.findAll().size());
        assertEquals("Impresora", repository.findById(1L).orElseThrow().nombre());

        assertTrue(repository.update(new Producto(1, "Impresora láser", 180.0)));
        assertEquals(180.0, repository.findById(1L).orElseThrow().precio());

        assertTrue(repository.delete(2L));
        assertEquals(1, repository.findAll().size());

        IProductoRepository reloaded = new ProductoXmlRepository(file);
        assertEquals("Impresora láser", reloaded.findById(1L).orElseThrow().nombre());
    }

    @Test
    void crudCompletoVehiculoXml() {
        Path file = tempDir.resolve("vehiculos.xml");
        IVehiculoRepository repository = new VehiculoXmlRepository(file);

        repository.create(new Vehiculo("3333CCC", "Renault", "Clio", 2019));
        repository.create(new Vehiculo("4444DDD", "Peugeot", "308", 2020));

        assertEquals(2, repository.findAll().size());
        assertEquals("Renault", repository.findById("3333CCC").orElseThrow().marca());

        assertTrue(repository.update(new Vehiculo("3333CCC", "Renault", "Clio RS", 2020)));
        assertEquals("Clio RS", repository.findById("3333CCC").orElseThrow().modelo());

        assertTrue(repository.delete("4444DDD"));
        assertEquals(1, repository.findAll().size());

        IVehiculoRepository reloaded = new VehiculoXmlRepository(file);
        assertEquals(2020, reloaded.findById("3333CCC").orElseThrow().anio());
    }
}
