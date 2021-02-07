package edu.pingpong.domain.transport;

public class Bicicleta implements Movil{
    
    private final int id;

    Bicicleta(int id) {
        this.id = id;
    }

    /*
    Al ser un método implementado por una interfaz,
    el modificador de acceso no puedo ser más privado
    que el que ya se definio en la interfaz Movil, es decir,
    si un método de la Interfaz es default/package, al momento
    de implementarse en una clase tiene que seguir siendo package/default
    o menos privado(es decir, public por ejemplo), no puede se privado.
    */
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + getId();
    }
}
