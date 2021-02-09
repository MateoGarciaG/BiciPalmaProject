package edu.pingpong.domain.estacion;

import static org.junit.Assert.*;

import org.junit.*;

import edu.pingpong.domain.tarjetausuario.Autenticacion;
import edu.pingpong.domain.tarjetausuario.TarjetaUsuario;
import edu.pingpong.domain.transport.Bicicleta;
import edu.pingpong.domain.transport.Movil;

public class EstacionTest {

    private Estacion estacion = null;
    private Movil bicicleta = null;
    private TarjetaUsuario tarjetaUsuario = null;
    
    @Before
    public void setupEstacion() {
        this.estacion = new Estacion(1, "Manacor", 6);
        this.bicicleta = new Bicicleta(1);
        this.tarjetaUsuario = new TarjetaUsuario("1",true);
    }

    // Métodos: anclajes(), numAnclajes() no se testean ya que son privados

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

        this.tarjetaUsuario.setActivada(false);

        assertEquals("No se pudo leer la Tarjeta de usuario", false, this.estacion.leerTarjetaUsuario(this.tarjetaUsuario));

        this.tarjetaUsuario.setActivada(true);

        assertEquals("No se pudo leer la Tarjeta de usuario", true, this.estacion.leerTarjetaUsuario(this.tarjetaUsuario));
    }

    
    @Test
    public void retirarBicicletaTest() {

        // Anclar una bicicleta
        this.estacion.anclarBicicleta(this.bicicleta);
        // Retirar una bicicleta
        this.estacion.retirarBicicleta(this.tarjetaUsuario);

        assertEquals("El resultado no es igual al esperado", 6, this.estacion.anclajesLibres());

        // Anclar dos bicicletas
        this.estacion.anclarBicicleta(this.bicicleta);
        this.estacion.anclarBicicleta(this.bicicleta);

        // Retirar una, por lo cual tendriamos 5 anclajes libres, ya que 1 anclaje aún está ocupado
        this.estacion.retirarBicicleta(this.tarjetaUsuario);

        assertEquals("El resultado no es igual al esperado", 5, this.estacion.anclajesLibres());
    }

    @Test 
    public void toStringTest() {

        assertEquals("El resultado no es igual al resultado esperado", "id: 1\ndireccion: Manacor\nnumeroAnclajes: 6", this.estacion.toString());
    }

}
