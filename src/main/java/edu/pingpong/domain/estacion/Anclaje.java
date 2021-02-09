package edu.pingpong.domain.estacion;
import edu.pingpong.domain.transport.Movil;

public class Anclaje {
    
    private boolean ocupado;
    private Movil bici = null;

    Anclaje() {}

    boolean isOcupado() {
        if(this.bici != null) {
            this.ocupado = true;
        } else {
            this.ocupado = false;
        }

        return this.ocupado;

    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bicicleta) {
        this.bici = bicicleta;
    }

    void liberarBici() {
        this.bici = null;
    }

    @Override
    public String toString() {

        String bicicleta = (this.bici == null) ? "null" : this.getBici().toString();
        return "ocupado: " + this.isOcupado() + "\n" + "Bici: " + bicicleta;

    }
}
