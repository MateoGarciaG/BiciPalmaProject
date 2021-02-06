package edu.pingpong.domain.tarjetausuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TarjetaUsuarioTest {
    /*
    Casos test Setup Tarjeta Usuario
    */
    private TarjetaUsuario tarjeta = null;

    @Before
    public void setupTarjetaUsuario() {
        this.tarjeta = new TarjetaUsuario("1", false);
    }

    @Test
    public void constructorTest() {
        assertNotNull(this.tarjeta);
    }

    @Test
    public void isActivadaTest() {

        assertEquals("EL resultado del método isActivada() no es igual al resultado esperado", false, this.tarjeta.isActivada());

    }

    @Test
    public void setActivadaTest() {

        this.tarjeta.setActivada(true);

        assertEquals("EL resultado del método isActivada() no es igual al resultado esperado", true, this.tarjeta.isActivada());

    }

    @Test
    public void toStringTest() {
        assertEquals("El resultado del método ToString del Objeto TarjetaUsuario no es igual al esperado", "id: 1\nactivada: true", this.tarjeta.toString());
    }

}
