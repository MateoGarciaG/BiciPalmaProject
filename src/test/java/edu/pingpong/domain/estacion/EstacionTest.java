package edu.pingpong.domain.estacion;

import static org.junit.Assert.*;

import org.junit.*;

import edu.pingpong.domain.transport.Bicicleta;
import edu.pingpong.domain.transport.Movil;

public class EstacionTest {

    private Estacion estacion = null;
    private Movil bicicleta = null;
    private Autenticacion tarjetaUsuario = null;
    
    @Before
    public void setupEstacion() {
        this.estacion = new Estacion(1, "Manacor", 6);
        this.bicicleta = new Bicicleta(1);
        this.tarjetaUsuario = new TarjetaUsuario(1,true);
    }

    @Test
    public void constructorEstacion() {
        assertNotNull(this.estacion);
    }

    @Test
    public void anclajesLibresTest() {

        assertEquals("El resultado no es igual al esperado", 6, this.estacion.anclajesLibres());
    }

    @Test
    public void anclarBicicletaTest() {
        this.estacion.anclarBicicleta(this.bicicleta);

        assertEquals("El resultado no es igual al esperado", 5, this.estacion.anclajesLibres());

    }

    @Test
    public void leerTarjetaUsuarioTest() {

        assertEquals("No se pudo leer la Tarjeta de usuario", true, this.estacion.leerTarjetaUsuario(this.tarjetaUsuario));
    }

    
    @Test
    public void retirarBicicletaTest() {

        this.estacion.retirarBicicleta(this.tarjetaUsuario);

        assertEquals("El resultado no es igual al esperado", 6, this.estacion.anclajesLibres());
    }

    @Test void toStringTest() {

        assertEquals("El resultado no es igual al resultado esperado", "Estacion: id: 1 direccion: Manacor\nAnclajes: Numero de Anclajes: 6\nCada Anclaje: ocupado: false\nBici: null", this.estacion.toString());
    }

}
