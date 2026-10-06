package es.educacion.ficheros;

import es.educacion.ficheros.model.Producto;
import es.educacion.ficheros.model.Vehiculo;
import es.educacion.ficheros.repository.IProductoRepository;
import es.educacion.ficheros.repository.IVehiculoRepository;
import es.educacion.ficheros.repository.csv.ProductoCsvRepository;
import es.educacion.ficheros.repository.csv.VehiculoCsvRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CsvRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void crudCompletoProductoCsv() {
        Path file = tempDir.resolve("productos.csv");
        IProductoRepository repository = new ProductoCsvRepository(file);

        assertTrue(repository.findAll().isEmpty());

        repository.create(new Producto(1, "Teclado", 30.0));
        repository.create(new Producto(2, "Ratón", 15.0));
        assertEquals(2, repository.findAll().size());
        assertEquals("Teclado", repository.findById(1L).orElseThrow().nombre());

        assertTrue(repository.update(new Producto(1, "Teclado mecánico", 45.0)));
        assertEquals(45.0, repository.findById(1L).orElseThrow().precio());
        assertFalse(repository.update(new Producto(99, "No existe", 1.0)));

        assertTrue(repository.delete(2L));
        assertFalse(repository.delete(2L));
        assertEquals(1, repository.findAll().size());

        IProductoRepository reloaded = new ProductoCsvRepository(file);
        assertEquals(1, reloaded.findAll().size());
        assertEquals("Teclado mecánico", reloaded.findById(1L).orElseThrow().nombre());
    }

    @Test
    void crudCompletoVehiculoCsv() {
        Path file = tempDir.resolve("vehiculos.csv");
        IVehiculoRepository repository = new VehiculoCsvRepository(file);

        repository.create(new Vehiculo("1234abc", "Toyota", "Corolla", 2022));
        repository.create(new Vehiculo("5678DEF", "Seat", "León", 2021));

        assertEquals(2, repository.findAll().size());
        assertEquals("1234ABC", repository.findById("1234ABC").orElseThrow().matricula());

        assertTrue(repository.update(new Vehiculo("1234ABC", "Toyota", "Corolla GR", 2023)));
        assertEquals("Corolla GR", repository.findById("1234ABC").orElseThrow().modelo());

        assertTrue(repository.delete("5678DEF"));
        assertEquals(1, repository.findAll().size());

        IVehiculoRepository reloaded = new VehiculoCsvRepository(file);
        assertEquals("Corolla GR", reloaded.findById("1234ABC").orElseThrow().modelo());
    }
}
