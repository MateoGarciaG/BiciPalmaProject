package edu.pingpong.domain.estacion;

import static org.junit.Assert.*;

import org.junit.*;

import edu.pingpong.domain.transport.Bicicleta;
import edu.pingpong.domain.transport.Movil;

public class AnclajeTest {
    
    private Anclaje anclaje = null;
    private Movil bicicleta = null;

    @Before
    public void setupAnclaje() {
        this.anclaje = new Anclaje();
        this.bicicleta = new Bicicleta(1);
    }

    @Test
    public void constructorAnclaje() {
        assertNotNull(this.anclaje);
    }

    @Test
    public void isOcupadoTest() {

        assertEquals("El resultado del método isOcupado() del objeto tipo Anclaje no es igual al esperado", false, this.anclaje.isOcupado());

        this.anclaje.anclarBici(this.bicicleta);

        assertEquals("El resultado del método isOcupado() del objeto tipo Anclaje no es igual al esperado", true, this.anclaje.isOcupado());
    }

    @Test
    public void getBiciTest() {

        assertEquals("El resultado del método getBici() no es igual al resultado esperado, el cual es NULL", null, this.anclaje.getBici());

        this.anclaje.anclarBici(this.bicicleta);

        assertEquals("El resultado del método getBici() no es igual al resultado esperado, el cual es el objeto tipo Movil", this.bicicleta, this.anclaje.getBici());
    }

    @Test
    public void anclarBiciTest() {

        this.anclaje.anclarBici(this.bicicleta);

        assertEquals("El resultado no es igual al esperado", true, this.anclaje.isOcupado());
    }

    @Test
    public void liberarBiciTest() {

        this.anclaje.liberarBici();

        assertEquals("El resultado no es igual al esperado", false, this.anclaje.isOcupado());
    }

    @Test
    public void toStringTest() {

        this.anclaje.anclarBici(this.bicicleta);
        assertEquals("El resultado del método ToString del objeto Anclaje no es igual al esperado", "ocupado: true\nBici: id: 1", this.anclaje.toString());

        this.anclaje.liberarBici();

        assertEquals("El resultado del método ToString del objeto Anclaje no es igual al esperado", "ocupado: false\nBici: null", this.anclaje.toString());
    }
}
