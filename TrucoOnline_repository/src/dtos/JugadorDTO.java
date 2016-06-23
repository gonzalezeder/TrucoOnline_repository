
package dtos;

import java.io.Serializable;

public class JugadorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7145588015062869981L;
	private int idJugador;
	private String apodo;
	private String mail;
	private String password;
	private CategoriaDTO categoria;
	private EstadisticaDTO estadistica;

	public JugadorDTO(int idJugador, String apodo, String mail,
			String password, CategoriaDTO categoria, EstadisticaDTO estadistica) {
		super();
		this.idJugador = idJugador;
		this.apodo = apodo;
		this.mail = mail;
		this.password = password;
		this.categoria = categoria;
		this.estadistica = estadistica;
	}

	public JugadorDTO(int i, String string) {
		super();
		this.idJugador = idJugador;
		this.apodo = apodo;
		}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public EstadisticaDTO getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(EstadisticaDTO estadistica) {
		this.estadistica = estadistica;
	}

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

	
	
}
