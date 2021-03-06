package dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;




public class JuegoDTO {

	private int idJuego;
	private Date fechaJuego;
	private ParejaDTO equipo1;
	private ParejaDTO equipo2;
	private EstadoDTO estado;
	private List<PartidaDTO> partidas = new ArrayList<PartidaDTO>();
	private ModalidadDTO modalidad;
	private static int ultNum=1;
	
	public JuegoDTO(ParejaDTO equipo1, ParejaDTO equipo2, ModalidadDTO modalidad) {
		//this.idJuego= getUltNum();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.modalidad = modalidad;
		this.estado = new EstadoDTO(1, "Creado");
		this.fechaJuego = new Date();
		this.partidas = new ArrayList<PartidaDTO>();
	}
	
	private int getUltNum() {
		return ultNum++;
	}

	public JuegoDTO(int idJuego, Date fechaJuego, ParejaDTO equipo1,
			ParejaDTO equipo2, EstadoDTO estado, List<PartidaDTO> partidas,
			 ModalidadDTO modalidad) {
		this.idJuego = idJuego;
		this.fechaJuego = fechaJuego;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.estado = estado;
		this.partidas = partidas;
		this.modalidad = modalidad;
	}
	
		public void repartirCartas(List<CartaDTO> cartas){
		
		PartidaDTO p = buscarPartidaEnCurso();
		if(p==null){ //no hay partida en curso. Se crea una.
			p = iniciarPartida();
			if (p==null)
				System.out.println("Ya se jugaron las tres partidas.");
			else{
				partidas.add(p);
				if(this.getEstado().getId()==1)
					this.setEstado(new EstadoDTO(2, "En curso"));
				p.repartirCartas(cartas);
			}
		}else{
			int i = partidas.indexOf(p);
			if(p.verificarResultado() == 0){
				p.repartirCartas(cartas);
				partidas.set(i,p);
			}else{
				p.setEstado(new EstadoDTO(3, "Finalizada"));
				partidas.set(i,p);
				p = iniciarPartida();
				if(p==null)
					System.out.println("Ya se jugaron las tres partidas.");
				else{
					p.repartirCartas(cartas);
				}
				
			}
		}
	}
	
		
	public PartidaDTO iniciarPartida() {
		if(partidas.size()>= 3)
			return null;
		else{
			PartidaDTO p = new PartidaDTO(getJugadoresOrdenados());
			this.partidas.add(p);
			return p;
		}
	}

	private PartidaDTO buscarPartidaEnCurso() {
		for(PartidaDTO p: partidas){
			if(p.getEstado().getId()!=3)
				return p;
		}
		return null;
	}
	private List<JugadorDTO> getJugadoresOrdenados(){
		 List<JugadorDTO> jugadores = new ArrayList<JugadorDTO>();
		 Random rand= new Random();
		 int numero = rand.nextInt((4-1)+1)+ 1;
		 switch(numero){
		 case 1:
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador2());
			 jugadores.add(equipo2.getJugador2());
			 break;
		 case 2:
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador2());
			 jugadores.add(equipo1.getJugador2());
			 break;
		 case 3:
			 jugadores.add(equipo1.getJugador2());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador2());
			 break;
		 case 4:
			 jugadores.add(equipo2.getJugador2());
			 jugadores.add(equipo1.getJugador1());
			 jugadores.add(equipo2.getJugador1());
			 jugadores.add(equipo1.getJugador2());
			 break;
		 }
		return jugadores;
	}

	public boolean validarTurno(JugadorDTO jug) {
		if(existeJug(jug))
			if(esSuTurno(jug))
				return true;
			else
				return false;
			
		else{
			return false;
		}
			
	}

	private boolean esSuTurno(JugadorDTO jug) {
		PartidaDTO p = buscarPartidaEnCurso();
		if(p!=null)
			return p.esSuTurno(jug);
		return false;
	}

	private boolean existeJug(JugadorDTO jug) {
		if(equipo1.getJugador1().getIdJugador()==jug.getIdJugador())
			return true;
		if(equipo1.getJugador2().getIdJugador()==jug.getIdJugador())
			return true;
		if(equipo2.getJugador1().getIdJugador()==jug.getIdJugador())
			return true;
		if(equipo2.getJugador2().getIdJugador()==jug.getIdJugador())
			return true;
		return false;
	}

	public List<CartaDTO> verCartas(JugadorDTO jug) {
		PartidaDTO p = buscarPartidaEnCurso();
		if(p!=null)
			return p.verCartas(jug);
		return null;
	}

	public boolean jugarCarta(CartaDTO carta, JugadorDTO jug) {
		PartidaDTO p = buscarPartidaEnCurso();
		if(p!=null)
			return p.jugarCarta(carta, jug);
		return false;
	
	}

	public JugadorDTO verTurno() {
		PartidaDTO p = buscarPartidaEnCurso();
		if(p!=null)
			return p.verTurno();
		return null;
		
	}

	public List<CartaDTO> verCartasJugables(JugadorDTO jug) {
		PartidaDTO p = buscarPartidaEnCurso();
		if(p!=null)
			return p.verCartasJugables(jug);
		return null;
	}

	public boolean Cantar(JugadorDTO jug, TipoCantoDTO canto) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public int getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}
	public Date getFechaJuego() {
		return fechaJuego;
	}
	public void setFechaJuego(Date fechaJuego) {
		this.fechaJuego = fechaJuego;
	}
	public ParejaDTO getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(ParejaDTO equipo1) {
		this.equipo1 = equipo1;
	}
	public ParejaDTO getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(ParejaDTO equipo2) {
		this.equipo2 = equipo2;
	}
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public List<PartidaDTO> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<PartidaDTO> partidas) {
		this.partidas = partidas;
	}
	
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}


}
