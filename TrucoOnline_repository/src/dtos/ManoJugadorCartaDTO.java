package dtos;


public class ManoJugadorCartaDTO {

	private int idManoJugadorCarta;
	private boolean jugada;
	private CartaDTO carta;

	
	
	public ManoJugadorCartaDTO(int idManoJugadorCarta, boolean jugada,
			CartaDTO carta) {
		this.idManoJugadorCarta = idManoJugadorCarta;
		this.jugada = jugada;
		this.carta = carta;
	}

	public ManoJugadorCartaDTO(CartaDTO carta) {
		this.jugada = false;
		this.carta = carta;
		
	}

	public int getIdManoJugadorCarta() {
		return idManoJugadorCarta;
	}

	public void setIdManoJugadorCarta(int idManoJugadorCarta) {
		this.idManoJugadorCarta = idManoJugadorCarta;
	}

	public boolean isJugada() {
		return jugada;
	}

	public void setJugada(boolean jugada) {
		this.jugada = jugada;
	}

	public CartaDTO getCarta() {
		return carta;
	}

	public void setCarta(CartaDTO carta) {
		this.carta = carta;
	}
	
}
