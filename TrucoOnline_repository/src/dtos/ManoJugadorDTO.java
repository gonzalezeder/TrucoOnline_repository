package dtos;

import java.util.ArrayList;
import java.util.List;




public class ManoJugadorDTO {
	private int idManoJugador;
	private int posicionMesa; // 1 Sur, 2 Oeste, 3 Norte, 4 Este.
	private List<ManoJugadorCartaDTO> cartas;
	private JugadorDTO jugador;
	
	
	public ManoJugadorDTO(JugadorDTO j, List<CartaDTO> cartasJug, int posicionMesa){
		this.jugador = j;
		this.cartas = new ArrayList<ManoJugadorCartaDTO>();
		crearManoJugadorCartas(cartasJug);
		this.posicionMesa = posicionMesa;
	
	}

	public ManoJugadorDTO(int idManoJugador, int posicionMesa,
			List<ManoJugadorCartaDTO> cartas, JugadorDTO jugador) {
		this.idManoJugador = idManoJugador;
		this.posicionMesa = posicionMesa;
		this.cartas = cartas;
		this.jugador = jugador;
	}

	private void crearManoJugadorCartas(List<CartaDTO> cartasJugador) {
		for(CartaDTO c: cartasJugador)
			this.cartas.add(new ManoJugadorCartaDTO(c));
	}
	
	public boolean existeCarta(int carta) {
		for(ManoJugadorCartaDTO mjc: cartas)
			if(mjc.getCarta().getIdCarta()== carta)
				return true;
		return false;
	}

	public boolean cartaNoJugada(int carta) {
		for(ManoJugadorCartaDTO mjc: cartas)
			if(mjc.getCarta().getIdCarta()==carta && mjc.isJugada())
				return false;
		return true;
	}

	public List<CartaDTO> verCartas() {
		List<CartaDTO> c = new ArrayList<CartaDTO>();
		for(ManoJugadorCartaDTO mjc: cartas)
			c.add(mjc.getCarta());
		return c;
	}

	public CartaDTO jugarCarta(int carta) {
		for(ManoJugadorCartaDTO mjc: cartas)
			if(mjc.getCarta().getIdCarta()== carta){
				mjc.setJugada(true);
				return mjc.getCarta();
			}
		return null;
	}
	

	
	public int getIdManoJugador() {
		return idManoJugador;
	}


	public void setIdManoJugador(int idManoJugador) {
		this.idManoJugador = idManoJugador;
	}


	public int getPosicionMesa() {
		return posicionMesa;
	}


	public void setPosicionMesa(int posicionMesa) {
		this.posicionMesa = posicionMesa;
	}


	public List<ManoJugadorCartaDTO> getCartas() {
		return cartas;
	}


	public void setCartas(List<ManoJugadorCartaDTO> cartas) {
		this.cartas = cartas;
	}


	public JugadorDTO getJugador() {
		return jugador;
	}


	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
	}
	
}
