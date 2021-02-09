package edu.pingpong.domain.estacion;

import edu.pingpong.domain.transport.Movil;

public class Estacion {
    
    private final int id;
    private final String direccion;
    private Anclajes anclajes = null;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    private int getId() {
        return this.id;
    }

    private String getDireccion() {
        return this.direccion;
    }

    /*
    Acceso a Anclajes
    */

    private Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    private int numAnclajes() {
        return this.anclajes.numAnclajes();
    }

    /*
    Logica del objeto, imprimir estado del objeto Estación
    */

    public void consultarEstacion() {

        System.out.println(this);
    }

    public int anclajesLibres() {
        int totalAnclajesLibres = 0;
        
        for (Anclaje anclaje : this.anclajes()) {
            // Si el Anclaje no tiene bicicleta = null, entonces el Anclaje es libre
            totalAnclajesLibres = anclaje.isOcupado() ? totalAnclajesLibres : ++totalAnclajesLibres;
        }

        return totalAnclajesLibres;
    }

    public void anclarBicicleta(Movil bici) {
		// insertar el objeto bicicleta en el primer registro libre del array

        // Posición para el array Anclaje[]
        int posicion = 0;
        // Posición del anclaje actual que vería el usuario
		int numeroAnclaje = posicion + 1;

		for (Anclaje anclaje : this.anclajes()) {
			if (!anclaje.isOcupado()) { // leer anclaje
				anclajes.ocuparAnclaje(posicion, bici); // set anclaje
				this.mostrarAnclaje(bici, numeroAnclaje);
				break;
			} else {
                // Si está ocupado el Anclaje, avanza a la siguiente posición del anclaje
				posicion++;
            }
            // Independientemente de si está ocupado o no, avanza al siguiente anclaje
			numeroAnclaje++;
		}
    }
    
    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
		return tarjetaUsuario.isActivada();
	}

	public void retirarBicicleta(Autenticacion tarjetaUsuario) {

		if (this.leerTarjetaUsuario(tarjetaUsuario)) {

			boolean biciRetirada = false;

			while (!biciRetirada) {

                // genero un número de anclaje random = posicion en array,
                /* Esto es debido porque la intención es hacer conseguir todas
                las posiciones posibles para verificar si están ocupadas o no
                si alguna está libre de alguna posición random, directamente el bucle WHILE para despues de chequear que si estaba ocupada esa
                posición
                */
                int posicion = this.anclajes.seleccionarAnclaje();
                // Posición del anclaje actual que vería el usuario
				int numeroAnclaje = posicion + 1;

                // Si esta posición random resulta que dentro del Array Anclaje[]
                // Está libre, entonces llamamos al método de Estacion:
                // this.mostrarBicicleta(), que tiene un SOUT que señala
                // que la bicicleta ha sido retirada, pero este método en sí
                // no tiene ningún código que cambie algo
				if (this.anclajes.isAnclajeOcupado(posicion)) { // leer anclaje
                    this.mostrarBicicleta(this.anclajes.getBiciAt(posicion), numeroAnclaje);
                    // Liberamos el anclaje mediante la posición random que nos dió antes, colocando la bicicleta a NULL
                    anclajes.liberarAnclaje(posicion); // set anclaje
                    // Ahora que la bicicleta está retirada -> biciRetirada a true, lo cual parara el bucle While
					biciRetirada = true;
                }
                // Que en la siguiente iteración generamos nuevo número de anclaje;
			}

		} else {
			System.out.println("Tarjeta de usuario inactiva :(");
		}
	}

    // this.mostrarBicicleta(), que tiene un SOUT que señala
    // que la bicicleta ha sido retirada, pero este método en sí
    // no tiene ningún código que cambie algo
    // Este Método solo fue creado para usarse dentro del método retirarBicicleta()
	private void mostrarBicicleta(Movil bicicleta, int numeroAnclaje) {
		System.out.println("bicicleta retirada: " + bicicleta.getId() 
							+ " del anclaje: " + numeroAnclaje);
	}

	private void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
		System.out.println("bicicleta " + bicicleta.getId() 
							+ " anclada en el anclaje " + numeroAnclaje);
	}

	public void consultarAnclajes() {
		// Recorre el array anclajes y 
		// Muestra si está libre o el id de la bici anclada 


		int posicion = 0;
		int numeroAnclaje = 0;

		for (Anclaje anclaje : this.anclajes()) {
			numeroAnclaje = posicion + 1;
			if (anclaje.isOcupado()) {
				System.out.println("Anclaje " + numeroAnclaje + " " + anclaje.getBici().getId());
			} else {
				System.out.println("Anclaje " + numeroAnclaje + " " + " libre");
			}
			posicion++;
		}
    }
    
    @Override
	public String toString() {
		return 	"id: " + this.getId() + '\n' +
				"direccion: " + this.getDireccion() + '\n' +
				"numeroAnclajes: " + this.numAnclajes();
	}


}