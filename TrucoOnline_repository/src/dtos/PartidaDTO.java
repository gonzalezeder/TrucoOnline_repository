package dtos;

import java.util.ArrayList;
import java.util.List;

public class PartidaDTO {
	private int idPartida;
	private List<BazaDTO> bazas;
	private EstadoDTO estado;
	private ParejaDTO parejaGanadora;
	private List<JugadorDTO> orden;
	
	
	public PartidaDTO(int idPartida, List<BazaDTO> bazas, EstadoDTO estado,
			ParejaDTO parejaGanadora, List<JugadorDTO> jugadores) {
		this.idPartida = idPartida;
		this.bazas = bazas;
		this.estado = estado;
		this.parejaGanadora = parejaGanadora;
		this.orden = jugadores;
	}
	
	public PartidaDTO(List<JugadorDTO> jugadores){
		this.bazas = new ArrayList <BazaDTO>();
		this.estado=new EstadoDTO(1,"Creada");
		this.orden = jugadores;
		this.parejaGanadora = null;
	}


	public void repartirCartas(List <CartaDTO> cartas) {
	
		int i = bazas.size(); //Obtengo la cantidad de bazas jugadas
		JugadorDTO mano = null;
		if(i <4) //Busco al jugador que le toca ser mano.
				mano = orden.get(i+1);
		else{
			int resto = i%4;
			mano = orden.get(resto+1);
		}
		
		// Creo la baza, indicando quién será mano (jugMano coincidirá con la posición)
		
		BazaDTO b = new BazaDTO(mano);	
		b.repartirCartas(cartas, orden);
		bazas.add(b);

	
}
	
	
	
	public int getIdPartida() {
		return idPartida;
	}


	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}


	public List<BazaDTO> getBazas() {
		return bazas;
	}


	public void setBazas(List<BazaDTO> bazas) {
		this.bazas = bazas;
	}


	public EstadoDTO getEstado() {
		return estado;
	}


	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}


	public ParejaDTO getParejaGanadora() {
		return parejaGanadora;
	}


	public void setParejaGanadora(ParejaDTO parejaGanadora) {
		this.parejaGanadora = parejaGanadora;
	}

	public List<JugadorDTO> getOrden() {
		return orden;
	}

	public void setOrden(List<JugadorDTO> orden) {
		this.orden = orden;
	}



	
}
