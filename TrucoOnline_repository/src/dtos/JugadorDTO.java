package dtos;

import java.io.Serializable;

public class JugadorDTO implements Serializable {
	private int idJugador;
	private String apodo;
	private String mail;
	private String password;
	private String categoria;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public JugadorDTO(int numeroJugador, String apodo) {
		this.setNumeroJugador(numeroJugador);
		this.setApodo(apodo);

	}
	
	public JugadorDTO(int numeroJugador, String apodo, String categoria) {
		this.setNumeroJugador(numeroJugador);
		this.setApodo(apodo);
		this.setCategoria(categoria);
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String nombre) {
		this.apodo = nombre;
	}

	public int getNumeroJugador() {
		return idJugador;
	}

	public void setNumeroJugador(int numeroJugador) {
		this.idJugador = numeroJugador;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + apodo + ", numeroJugador=" + idJugador
				+ "]";
	}
}
