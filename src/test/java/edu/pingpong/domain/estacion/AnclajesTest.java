// Paquete:
package edu.pingpong.domain.estacion;

// Imports de  otros paquetes para importar Clases que necesitamos para
// realizar Casos Test
import edu.pingpong.domain.transport.Bicicleta;
import edu.pingpong.domain.transport.Movil;

// Junit
import static org.junit.Assert.*;
import org.junit.*;

import java.util.Arrays;
// Random number
import java.util.concurrent.ThreadLocalRandom;

public class AnclajesTest {
    
    private Anclajes anclajes = null;
    private Anclaje[] listaAnclajes;
    private int totalAnclajes;
    private Movil bicicleta = null;

    @Before
    public void setupAnclajes() {

        this.totalAnclajes = 6;
        this.anclajes = new Anclajes(this.totalAnclajes);

        // Total de elementos tipo Anclaje que tendrá el Array: listaAnclajes
        this.listaAnclajes = new Anclaje[this.totalAnclajes];
        for (int i = 0; i < this.listaAnclajes.length; i++) {
            this.listaAnclajes[i] = new Anclaje();
        }

        // Objeto Bicicleta para testear los métodos de Anclajes object
        this.bicicleta = new Bicicleta(1);

    }

    @Test
    public void constructorAnclajes() {

        assertNotNull(this.anclajes);
    }

    // @Test
    // public void crearAnclajesTest() {
    //     assertTrue(this.anclajes.anclajes() instanceof Anclaje[]);
    // }

    @Test
    public void anclajesArrayTest() {

        // assertArrayEquals("El array no es el mismo que el Array esperado", this.listaAnclajes, this.anclajes.anclajes());
        assertTrue(Arrays.equals(this.anclajes.anclajes(), this.anclajes.anclajes()));
        assertTrue(this.anclajes.anclajes() instanceof Anclaje[]);
        assertEquals(this.listaAnclajes.length, this.anclajes.numAnclajes());


    }

    @Test
    public void numAnclajesTest() {

        assertEquals("La cantidad de Anclajes no corresponde al esperado", this.totalAnclajes, this.anclajes.numAnclajes());
    }

    @Test
    public void ocuparAnclajeTest() {

        this.anclajes.ocuparAnclaje(2, this.bicicleta);

        /* He usado el método isAnclajeOcupado() para consultar
        si esa posición del array fue ocupada en la posición 2 con un objeto
        tipo Movil */
        assertEquals("El resultado no es igual al resultado esperado", true, this.anclajes.isAnclajeOcupado(2));

    }

    @Test
    public void isAnclajeOcupadoTest() {

        /* La posición 4 del Array con elementos tipo Anclaje
        no está ocupada */
        assertEquals("El resultado no es igual al resultado esperado", false, this.anclajes.isAnclajeOcupado(4));

        this.anclajes.ocuparAnclaje(1, this.bicicleta);
        /* La posición 1 del Array con elementos tipo Anclaje
        está ocupada */
        assertEquals("El resultado no es igual al resultado esperado", true, this.anclajes.isAnclajeOcupado(1));
    }

    @Test
    public void liberarAnclajeTest() {

        /* Ocupamos el Anclaje de la posición 5 
        donde este Anclaje va a tener un Objeto tipo Movil*/
        this.anclajes.ocuparAnclaje(5, this.bicicleta);

        /* Liberamos la bicicleta del Anclaje*/
        this.anclajes.liberarAnclaje(5);

        assertEquals("El resultado no es igual al resultado esperado", false, this.anclajes.isAnclajeOcupado(5));
    }

    @Test
    public void getBiciAtTest() {

        this.anclajes.ocuparAnclaje(3, this.bicicleta);

        assertEquals("El resultado del método isAnclajeOcupado() no es igual al resultado esperado", this.bicicleta, this.anclajes.getBiciAt(3));

    }

    // @Test
    // public void seleccionarAnclajeTest() {

    //     int idAnclaje = ThreadLocalRandom.current().nextInt(0, this.totalAnclajes);
    //     assertEquals("El resultado no es igual al resultado esperado", idAnclaje, this.anclajes.seleccionarAnclaje());
    // }

    @Test
    public void toStringTest() {

        assertEquals("El resultado no es igual al resultado esperado", "Numero de Anclajes: 6", this.anclajes.toString());
    }
}
