package edu.pingpong.domain.estacion;

import edu.pingpong.bicipalma.BiciPalma;
import edu.pingpong.domain.transport.Bicicleta;

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
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bicicleta) {
        this.getBici() = bicicleta;
    }

    void liberarBici() {
        this.getBici() = null;
    }

    @Override
    public String toString() {
        return "ocupado: " + this.isOcupado() + "\n" + this.bici.toString();
    }
}
