package dtos;



public class LobbyDTO {
	
	private int id;
	private JugadorDTO jugador;
	private ModalidadDTO modalidad;
	private int jugando;

	public LobbyDTO(JugadorDTO jugador, ModalidadDTO modalidad) {
		this.jugador = jugador;
		this.modalidad = modalidad;
		this.setJugando(0);
	}
	
	public LobbyDTO(int id,JugadorDTO jugador, ModalidadDTO modalidad, int jugando) {
		this.id = id;
		this.jugador = jugador;
		this.modalidad = modalidad;
		this.setJugando(jugando);
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public JugadorDTO getJugador() {
		return jugador;
	}
	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
	}
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}
	public int getJugando() {
		return jugando;
	}
	public void setJugando(int jugando) {
		this.jugando = jugando;
	}

	public boolean estaAnotado(JugadorDTO j, ModalidadDTO m) {
		if(this.getJugador().getIdJugador()==j.getIdJugador() && this.getModalidad().getModalidad() == m.getModalidad() && this.jugando == 0)
			return true;
		return false;
	}
	
	
	
	
}
