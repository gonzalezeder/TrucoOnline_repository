package dtos;

public class CategoriaDTO {
	private int id;
	private String name;
	private int cantPartidas;
	private int puntaje;
	private float promedio;
	
	public CategoriaDTO(int id, String name, int cantPartidas, int puntaje, float promedio) {
		this.id = id;
		this.name = name;
		this.cantPartidas = cantPartidas;
		this.puntaje = puntaje;
		this.promedio = promedio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantPartidas() {
		return cantPartidas;
	}

	public void setCantPartidas(int cantPartidas) {
		this.cantPartidas = cantPartidas;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
