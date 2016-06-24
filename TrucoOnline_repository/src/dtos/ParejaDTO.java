package dtos;



public class ParejaDTO {
	private int idPareja;
	private JugadorDTO jugador1;
	private JugadorDTO jugador2;
	
	
	public ParejaDTO(JugadorDTO jugador1, JugadorDTO jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	public int getIdPareja() {
		return idPareja;
	}
	public void setIdPareja(int idPareja) {
		this.idPareja = idPareja;
	}
	public JugadorDTO getJugador1() {
		return jugador1;
	}
	public void setJugador1(JugadorDTO jugador1) {
		this.jugador1 = jugador1;
	}
	public JugadorDTO getJugador2() {
		return jugador2;
	}
	public void setJugador2(JugadorDTO jugador2) {
		this.jugador2 = jugador2;
	}
	
	
}
