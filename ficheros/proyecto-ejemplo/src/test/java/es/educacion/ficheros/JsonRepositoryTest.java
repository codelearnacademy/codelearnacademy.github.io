package es.educacion.ficheros;

import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.model.Vehiculo;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.IVehiculoRepository;
import es.educacion.ficheros.repository.json.ProductoJsonRepository;
import es.educacion.ficheros.repository.json.VehiculoJsonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class JsonRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void crudCompletoProductoJson() {
        Path file = tempDir.resolve("productos.json");
        IProductoRepository repository = new ProductoJsonRepository(file);

        repository.create(new Producto(1, "Monitor", 199.99));
        repository.create(new Producto(2, "Webcam", 49.99));

        assertEquals(2, repository.findAll().size());
        assertTrue(repository.findById(1L).isPresent());

        assertTrue(repository.update(new Producto(2, "Webcam HD", 59.99)));
        assertEquals("Webcam HD", repository.findById(2L).orElseThrow().nombre());

        assertTrue(repository.delete(1L));
        assertTrue(repository.findById(1L).isEmpty());

        IProductoRepository reloaded = new ProductoJsonRepository(file);
        assertEquals(1, reloaded.findAll().size());
        assertEquals(59.99, reloaded.findById(2L).orElseThrow().precio());
    }

    @Test
    void crudCompletoVehiculoJson() {
        Path file = tempDir.resolve("vehiculos.json");
        IVehiculoRepository repository = new VehiculoJsonRepository(file);

        repository.create(new Vehiculo("1111AAA", "Ford", "Focus", 2020));
        repository.create(new Vehiculo("2222BBB", "Honda", "Civic", 2022));

        assertEquals("Ford", repository.findById("1111AAA").orElseThrow().marca());

        assertTrue(repository.update(new Vehiculo("1111AAA", "Ford", "Focus ST", 2021)));
        assertEquals("Focus ST", repository.findById("1111AAA").orElseThrow().modelo());

        assertTrue(repository.delete("2222BBB"));
        assertEquals(1, repository.findAll().size());

        IVehiculoRepository reloaded = new VehiculoJsonRepository(file);
        assertEquals(1, reloaded.findAll().size());
        assertEquals(2021, reloaded.findById("1111AAA").orElseThrow().anio());
    }
}
