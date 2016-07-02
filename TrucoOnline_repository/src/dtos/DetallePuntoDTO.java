package dtos;



public class DetallePuntoDTO {

	private int idDetalle;
	private int puntos;
	private TipoCantoDTO tipo;
	private int equipo;
	
	public DetallePuntoDTO(int idDetalle, int puntos, TipoCantoDTO tipo,
			int equipo) {
		this.idDetalle = idDetalle;
		this.puntos = puntos;
		this.tipo = tipo;
		this.equipo = equipo;
	}
	
	
	public DetallePuntoDTO(int puntos, TipoCantoDTO tipo, int equipo) {
		this.puntos = puntos;
		this.tipo = tipo;
		this.equipo = equipo;
	}


	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public TipoCantoDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoCantoDTO tipo) {
		this.tipo = tipo;
	}
	public int getEquipo() {
		return equipo;
	}
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	
	
}
