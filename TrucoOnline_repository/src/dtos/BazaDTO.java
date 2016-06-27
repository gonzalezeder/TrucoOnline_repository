package dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class BazaDTO {

	
	private int idBaza;
	private EstadoDTO estado;
	private List<ManoDTO> manos= new ArrayList<ManoDTO>();
	private List<DetallePuntoDTO> puntos = new ArrayList<DetallePuntoDTO>();
	//private List<TipoCanto> cantosRealizados;
	private List<ManoJugadorDTO> manosJugadores = new ArrayList<ManoJugadorDTO>();
	private JugadorDTO jugMano;
	private List<CartaDTO> cartas = new ArrayList<CartaDTO>();
	
	
	
	public BazaDTO(int idBaza, EstadoDTO estado, List<ManoDTO> manos,
			List<DetallePuntoDTO> puntos, List<ManoJugadorDTO> manosJugadores,
			JugadorDTO jugMano, List<CartaDTO> cartas) {
		this.idBaza = idBaza;
		this.estado = estado;
		this.manos = manos;
		this.puntos = puntos;
		this.manosJugadores = manosJugadores;
		this.jugMano = jugMano;
		this.cartas = cartas;
	}

	public BazaDTO(JugadorDTO jugMano) {
		this.jugMano = jugMano;
		this.estado = new EstadoDTO(1,"Creado");
		this.manos = new ArrayList<ManoDTO>();
		this.puntos = new ArrayList<DetallePuntoDTO>();
		this.manosJugadores= new ArrayList<ManoJugadorDTO>();
		this.cartas = new ArrayList<CartaDTO>();
	}
	
	public void mezclarMazo(){
		Collections.shuffle(cartas);
	}
	
	public void repartirCartas(List<CartaDTO> cartas, List <JugadorDTO> jugadores){
		jugadores = reordenarJugadores(jugadores);
		
		for(int i = 0; i < jugadores.size(); i++){ 
			List<CartaDTO> cartasJug = repartir(cartas,i);
			ManoJugadorDTO mano = new ManoJugadorDTO(jugadores.get(i), cartasJug, i+1); // el i+1 indica la posición del jugador en la mesa.
			manosJugadores.add(mano);
		}	
		//crearManos();
	}
	
	private List<JugadorDTO> reordenarJugadores(List<JugadorDTO> jugadores) { //Devuelve los jugadores en el orden que van a jugar.
		List<JugadorDTO> reordenados = new ArrayList<JugadorDTO>();
		int i = 0;
		while(reordenados.size()<1){ //se pone a la mano primero en la lista 
			if(jugadores.get(i).getIdJugador()==this.jugMano.getIdJugador()){
				reordenados.add(jugadores.get(i));
			}else
				i++;
		}
		switch(i){
			case 0:
				reordenados.add(jugadores.get(1));
				reordenados.add(jugadores.get(2));
				reordenados.add(jugadores.get(3));
				break;
			case 1:
				reordenados.add(jugadores.get(2));
				reordenados.add(jugadores.get(3));
				reordenados.add(jugadores.get(0));
				break;
			case 2:
				reordenados.add(jugadores.get(3));
				reordenados.add(jugadores.get(0));
				reordenados.add(jugadores.get(1));
				break;
			case 3:
				reordenados.add(jugadores.get(0));
				reordenados.add(jugadores.get(1));
				reordenados.add(jugadores.get(2));
				break;	
			}
		return reordenados;
	}

	private List<CartaDTO> repartir(List<CartaDTO> cartasMezcladas, int i) {
		this.cartas = cartasMezcladas;
		List<CartaDTO> cartasAux = new ArrayList<CartaDTO>();
		cartasAux.add(cartasMezcladas.get(i));
		cartasAux.add(cartasMezcladas.get(i+4));
		cartasAux.add(cartasMezcladas.get(i+8));
		return cartasAux;
	}
	
	
	
	
	
	
	public int getIdBaza() {
		return idBaza;
	}
	public void setIdBaza(int idBaza) {
		this.idBaza = idBaza;
	}
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public JugadorDTO getJugMano() {
		return jugMano;
	}
	public void setJugMano(JugadorDTO jugMano) {
		this.jugMano = jugMano;
	}








	public List<ManoDTO> getManos() {
		return manos;
	}








	public void setManos(List<ManoDTO> manos) {
		this.manos = manos;
	}








	public List<DetallePuntoDTO> getPuntos() {
		return puntos;
	}








	public void setPuntos(List<DetallePuntoDTO> puntos) {
		this.puntos = puntos;
	}








	public List<ManoJugadorDTO> getManosJugadores() {
		return manosJugadores;
	}








	public void setManosJugadores(List<ManoJugadorDTO> manosJugadores) {
		this.manosJugadores = manosJugadores;
	}








	public List<CartaDTO> getCartas() {
		return cartas;
	}








	public void setCartas(List<CartaDTO> cartas) {
		this.cartas = cartas;
	}
	
	
	
}
