package dtos;

import java.util.ArrayList;
import java.util.List;


public class PartidaDTO {
	private int idPartida;
	private List<BazaDTO> bazas;
	private EstadoDTO estado;
	private ParejaDTO parejaGanadora;
	private List<JugadorDTO> orden;
	private List<JugadorDTO> ordenOriginal;
	
	
	public PartidaDTO(int idPartida, List<BazaDTO> bazas, EstadoDTO estado,
			ParejaDTO parejaGanadora, List<JugadorDTO> jugadores, List<JugadorDTO> original) {
		this.idPartida = idPartida;
		this.bazas = bazas;
		this.estado = estado;
		this.parejaGanadora = parejaGanadora;
		this.orden = jugadores;
		this.ordenOriginal = original;
	}
	
	public PartidaDTO(List<JugadorDTO> jugadores){
		this.bazas = new ArrayList <BazaDTO>();
		this.estado=new EstadoDTO(1,"Creada");
		this.orden = jugadores;
		this.ordenOriginal= jugadores;
		this.parejaGanadora = null;
	}


	public void repartirCartas(List <CartaDTO> cartas) {
		if(bazas.size() == 0 || bazas.get(bazas.size()-1).getEstado().getId()==3){ //Si la ultima baza está finalizada, se crea una
			int i = bazas.size(); //Obtengo la cantidad de bazas jugadas
			JugadorDTO mano = null;
			if(i==0)
				mano = ordenOriginal.get(i);
			else
				if(i <4) //Busco al jugador que le toca ser mano.
					mano = ordenOriginal.get(i);
				else{
				int resto = i%4;
				mano = ordenOriginal.get(resto);
			}
			
			
			// Creo la baza, indicando quién será mano (jugMano coincidirá con la posición)
			
			BazaDTO b = new BazaDTO(mano);	
			orden = b.reordenarJugadores(orden);
			b.repartirCartas(cartas, orden);
			bazas.add(b);
		}else
			System.out.println("Ya existe una baza pendiente");

	
}
	public BazaDTO buscarBazaEnCurso() {
		for(BazaDTO b: bazas){
			if(b.getEstado().getId()!=3)
				return b;
		}
		
		return null;
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

	public boolean esSuTurno(JugadorDTO jug) {
		BazaDTO b = buscarBazaEnCurso();
		int turno = 0;
		if(b!=null){
			turno = b.verTurno();
			if(turno == -1){
//				System.out.println("Error, se terminó la baza");
				return false; //Es un error, se terminó la baza
			}
			if(orden.get(turno).getIdJugador()==jug.getIdJugador()){
//				System.out.println("Es su turno");
				return true;
			}
		}
//		System.out.println("No es su turno");
		return false;
		
	}

	public List<CartaDTO> verCartas(JugadorDTO jug) {
		BazaDTO b = buscarBazaEnCurso();
		if(b!=null)
			return b.verCartas(jug);
		return null;
	}

	public boolean jugarCarta(CartaDTO carta, JugadorDTO jug) {
		BazaDTO b = buscarBazaEnCurso();
		if(b!=null){
			boolean res = b.jugarCarta(carta,jug);
			if(res){
				if(bazas.get(0).getEstado().getId()==2) //Si la primer baza esta en curso, la partida esta en curso
					this.estado = new EstadoDTO(2, "En Curso");
			}
			
			return res;
		}
		
		return false;
	}

	public int verificarResultado() {
		int equipo1 = 0;
		int equipo2 = 0;
		int ganador = 0;
		for(BazaDTO b: bazas){
			equipo1 += b.getPuntaje(1);
			equipo2 += b.getPuntaje(2);
		}
		if(equipo1>=30)
			ganador = 1;
		else
			if(equipo2 >=30)
				ganador = 2;
		if(ganador!=0)
			this.estado=new EstadoDTO(3, "Finalizada");
		return ganador;
		
	}

	public JugadorDTO verTurno() {
		BazaDTO b = buscarBazaEnCurso();
		if(b!=null){
			int turno = b.verTurno();
			if(turno != -1){
				return orden.get(turno);
			}
		}
			
		return null;
	}

	public List<CartaDTO> verCartasJugables(JugadorDTO jug) {
		BazaDTO b = buscarBazaEnCurso();
		if(b!=null)
			return b.verCartasJugables(jug);
		return null;
	}

	public List<JugadorDTO> getOrdenOriginal() {
		return ordenOriginal;
	}

	public void setOrdenOriginal(List<JugadorDTO> ordenOriginal) {
		this.ordenOriginal = ordenOriginal;
	}

}
