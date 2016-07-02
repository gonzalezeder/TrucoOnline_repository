package dtos;

import java.util.ArrayList;
import java.util.List;


public class ManoDTO {

	private int idMano;
	private List<MovimientoDTO> movimientos = new ArrayList<MovimientoDTO>();
	private EstadoDTO estado; 

	public ManoDTO(){
		this.movimientos = new ArrayList<MovimientoDTO>();
		this.estado = new EstadoDTO(1,"Creada");
	}
	
	public int calcularCartasJugadas() {
		int cartasJugadas=0;
		for(MovimientoDTO m: movimientos){
			if(m.getCarta()!=null) //Si no es null significa que se jugó una carta
				cartasJugadas++; //Máximo van a haber 4 cartas jugadas por ronda.
				
		}
		return cartasJugadas; //Devuelvo la cantidad de cartas jugadas
	}

	public void jugar(JugadorDTO j, CartaDTO c) {
		MovimientoDTO m = new MovimientoDTO(j, null, c, -1);
		movimientos.add(m);
		
	}

	public ManoDTO(int idMano, List<MovimientoDTO> movimientos, EstadoDTO estado) {
		this.idMano = idMano;
		this.movimientos = movimientos;
		this.estado = estado;
	}

	public int getIdMano() {
		return idMano;
	}

	public void setIdMano(int idMano) {
		this.idMano = idMano;
	}

	public List<MovimientoDTO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoDTO> movimientos) {
		this.movimientos = movimientos;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public int getParejaGanadora() { //Que pareja gana la mano, o empate.
		int parejaGanadora = 0; //1 primer equipo, 2 segundo equipo,3 empate
		int cartaMasAltaE1 = 0;
		int cartaMasAltaE2 = 0;
		if(movimientos.get(0).getCarta().getValorTruco()>=
		movimientos.get(2).getCarta().getValorTruco())
			cartaMasAltaE1= 0;
		else
			cartaMasAltaE1=2;
		if(movimientos.get(1).getCarta().getValorTruco()>=
				movimientos.get(3).getCarta().getValorTruco())
					cartaMasAltaE2= 1;
				else
					cartaMasAltaE2=3;
		
		if(movimientos.get(cartaMasAltaE1).getCarta().getValorTruco()>
			movimientos.get(cartaMasAltaE2).getCarta().getValorTruco())
			parejaGanadora=1; // Equipo 1
		else
			if(movimientos.get(cartaMasAltaE1).getCarta().getValorTruco()<
			movimientos.get(cartaMasAltaE2).getCarta().getValorTruco())
				parejaGanadora =2; //Equipo 2
			else
				parejaGanadora = 3; //Empate
		
		return parejaGanadora;
	}
	
	
}
