package edu.pingpong.domain.estacion;

import java.util.concurrent.ThreadLocalRandom;

import edu.pingpong.domain.transport.Movil;

public class Anclajes {
    
    private Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        this.crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < this.anclajes.length; i++) {
            this.anclajes[i] = new Anclaje();
        }
    }

    Anclaje[] anclajes() {
        return this.anclajes;
    }

    int numAnclajes() {
        return this.anclajes.length;
    }

    void ocuparAnclaje(int posicionAnclaje, Movil bicicleta) {
        this.anclajes[posicionAnclaje].anclarBici(bicicleta);
    }

    boolean isAnclajeOcupado(int posicionAnclaje) {
        return this.anclajes[posicionAnclaje].isOcupado();
    }

    void liberarAnclaje(int posicionAnclaje) {
        this.anclajes[posicionAnclaje].liberarBici();
    }

    Movil getBiciAt(int posicionAnclaje) {
        return this.anclajes[posicionAnclaje].getBici();
    }

    int seleccionarAnclaje() {
        return ThreadLocalRandom.current().nextInt(0, this.numAnclajes());
    }

    @Override
    public String toString() {
        return "Número de Anclajes: " + Integer.toString(this.numAnclajes());
    }


}
