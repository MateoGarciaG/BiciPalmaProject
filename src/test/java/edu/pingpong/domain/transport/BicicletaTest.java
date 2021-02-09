package edu.pingpong.domain.transport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class BicicletaTest {
    /*
    Casos test Setup Bicicleta
    */
    private Bicicleta bicicleta = null;

    @Before
    public void setupBicicleta() {
        this.bicicleta = new Bicicleta(1);
    }

    @Test
    public void constructorTest() {
        assertNotNull(this.bicicleta);
    }

    @Test
    public void getIdTest() {
        assertEquals("El ID no es igual al ID esperado",1, this.bicicleta.getId());
    }

    @Test
    public void toStringTest() {
        assertEquals("El resultado del método ToString del Objeto bicicleta no es igual al esperado", "id: 1", this.bicicleta.toString());
    }


}
