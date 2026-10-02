package es.ies.puerto.ides;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void mensajeCorrecto() {
        assertEquals("Hola, Java!", App.mensaje("Java"));
    }
}
