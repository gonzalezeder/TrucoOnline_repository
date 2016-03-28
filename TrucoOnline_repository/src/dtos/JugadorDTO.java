package dtos;

import java.io.Serializable;

public class JugadorDTO implements Serializable{
	private int numeroJugador;
	private String nombre;

	public JugadorDTO(int numeroJugador, String nombre) {
		this.setNumeroJugador(numeroJugador);
		this.setNombre(nombre);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(int numeroJugador) {
		this.numeroJugador = numeroJugador;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", numeroJugador=" + numeroJugador
				+ "]";
	}
}
