package dtos;


public class MovimientoDTO {
	
	private int idMovimiento;
	private JugadorDTO jugador;
	private TipoCantoDTO canto;
	private CartaDTO carta;
	private int envido;
	
	public MovimientoDTO (JugadorDTO jug, TipoCantoDTO canto, CartaDTO carta,int envido){
		this.jugador = jug;
		this.canto = canto;
		this.carta=carta;
		this.envido=envido;
		
	}
	
	public MovimientoDTO(int idMovimiento, JugadorDTO jugador,
			TipoCantoDTO canto, CartaDTO carta, int envido) {
		this.idMovimiento = idMovimiento;
		this.jugador = jugador;
		this.canto = canto;
		this.carta = carta;
		this.envido = envido;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public JugadorDTO getJugador() {
		return jugador;
	}

	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
	}

	public TipoCantoDTO getCanto() {
		return canto;
	}

	public void setCanto(TipoCantoDTO canto) {
		this.canto = canto;
	}

	public CartaDTO getCarta() {
		return carta;
	}

	public void setCarta(CartaDTO carta) {
		this.carta = carta;
	}

	public int getEnvido() {
		return envido;
	}

	public void setEnvido(int envido) {
		this.envido = envido;
	}
	
	
}
