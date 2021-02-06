package edu.pingpong.domain.tarjetausuario;

public class TarjetaUsuario {
    
    private final String id;
    private boolean activada;

    public TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    public boolean isActivada() {
        return this.activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" + "activada: " + this.isActivada();
    }
}
