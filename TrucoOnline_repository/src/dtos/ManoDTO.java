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
	
	
}
