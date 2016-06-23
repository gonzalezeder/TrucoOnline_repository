package dtos;

public class EstadisticaDTO {
	private int idEstadistica;
	private int partidasJugadas;
	private int partidasGanadas;
	private int partidasPerdidas;
	private int puntaje;

	public EstadisticaDTO(int idEstadistica, int partidasJugadas,
			int partidasGanadas, int partidasPerdidas, int puntaje) {
		super();
		this.idEstadistica = idEstadistica;
		this.partidasJugadas = partidasJugadas;
		this.partidasGanadas = partidasGanadas;
		this.partidasPerdidas = partidasPerdidas;
		this.puntaje = puntaje;
	}

	public int getIdEstadistica() {
		return idEstadistica;
	}

	public void setIdEstadistica(int idEstadistica) {
		this.idEstadistica = idEstadistica;
	}

	public int getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}

	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}