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
		crearManos();
	}
	
	
	private void crearManos() {
		ManoDTO manoA = new ManoDTO();
		ManoDTO manoB = new ManoDTO();
		ManoDTO manoC = new ManoDTO();
		manos.add(manoA);
		manos.add(manoB);
		manos.add(manoC);
		
	}
	
	
	public List<JugadorDTO> reordenarJugadores(List<JugadorDTO> jugadores) { //Devuelve los jugadores en el orden que van a jugar.
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

	public int verTurno() { //Esto va a devolver las cartas jugadas de la primer mano no finalizada
		int cartasJugadas = 0;
		for(ManoDTO m: manos){ 
			if(m.getEstado().getId()!=3){ //si es igual a 3, está finalizada y se saltea la mano
				cartasJugadas = m.calcularCartasJugadas();
				if(cartasJugadas != 4) //Este control es porque si ya se jugaron 4, debería buscar en la próxima mano.
					return cartasJugadas;
			}
		}
		return -1; //Si devuelve -1, no le toca a nadie.
	}

	public List<CartaDTO> verCartas(JugadorDTO jug) {
		for(ManoJugadorDTO mj: manosJugadores){
			if(mj.getJugador().getIdJugador()==jug.getIdJugador())
				return mj.verCartas();
		}
		return null;
	}

	public boolean jugarCarta(CartaDTO carta, JugadorDTO jug) {
		if(!cartaJugada(carta,jug)){
			ManoDTO mano = buscarManoEnCurso();
			if(mano != null){
				int i = manos.indexOf(mano);
				mano.jugar(jug, carta);
				if(mano.calcularCartasJugadas()== 4){
					mano.setEstado(new EstadoDTO(3,"Finalizada"));
				}
				else
					mano.setEstado(new EstadoDTO(2,"En Curso"));
				manos.set(i, mano);
				for(ManoJugadorDTO mj: manosJugadores)
					if(mj.getJugador().getIdJugador()== jug.getIdJugador()){
						mj.jugarCarta(carta);
						if(manos.get(0).getEstado().getId()==2) //Si la primer mano esta en curso, la baza esta en curso
							this.estado = new EstadoDTO(2, "En Curso");
						if(manos.get(2).getEstado().getId()==3){ //Si la ultima mano esta finalizada, la baza esta finalizada
							this.estado= new EstadoDTO(3,"Finalizada");
							anotarPuntos();
						}
						return true;
					}
			}
		}
			
		
		return false;
	}
	
	private void anotarPuntos() {
		int puntajeE1 = 0;
		int puntajeE2 = 0;
		for(ManoDTO m: manos){
			int parejaGanadora = m.getParejaGanadora();
			if(parejaGanadora==1)
				puntajeE1++;
			else
				if(parejaGanadora==2)
					puntajeE2++;		
		}
		TipoCantoDTO det = calcularTipoTruco();
		int punt = 1; //Si no se cantó truco, por defecto va 1 punto al q gane
		if(det!=null)
			punt = det.getPuntos(); //Si se cantó, asigno los puntos
		if(puntajeE1 > puntajeE2){//Sumo puntos del truco
			DetallePuntoDTO detalle = new DetallePuntoDTO(punt,det,1);
			puntos.add(detalle);
		}
		else
			if(puntajeE1 < puntajeE2){
				DetallePuntoDTO detalle = new DetallePuntoDTO(punt,det,2);
				puntos.add(detalle);
			}
				
		if(puntajeE1 == 0 && puntajeE2 == 0)//Empataron la baza
			return;
	}

	private TipoCantoDTO calcularTipoTruco() {
		for(ManoDTO m: manos){
			int i = 0;
			for(i = m.getMovimientos().size(); i>0; i--);{ //Empiezo de atras hacia adelante
				if(m.getMovimientos().get(i).getCanto()!=null //Busco el ultimo de canto del tipo truco que finalice (quiero, no quiero)
						&& m.getMovimientos().get(i).getCanto().getTipo()==1
						&& m.getMovimientos().get(i).getCanto().getFinalizaCanto()==1){  
					return m.getMovimientos().get(i).getCanto();
				}
					
			}
			
		}
			
		return null;
	}

	private boolean cartaJugada(CartaDTO carta, JugadorDTO jug) {
		for(ManoJugadorDTO mj: manosJugadores){
			if(mj.getJugador().getIdJugador()== jug.getIdJugador()){
				return mj.cartaJugada(carta);
			}
		}
		return false;
	}

	public ManoDTO buscarManoEnCurso(){
		for(ManoDTO mano: manos){
			if (mano.getEstado().getId()!=3)
				return mano;
		}
		return null;
		
	}

	public List<CartaDTO> verCartasJugables(JugadorDTO jug) {
		for(ManoJugadorDTO mj: manosJugadores){
			if(mj.getJugador().getIdJugador()==jug.getIdJugador())
				return mj.verCartasJugables();
		}
		return null;
	}

	public int getPuntaje(int i) {
		int puntaje = 0;
		for(DetallePuntoDTO det: puntos){
			if(det.getEquipo()==i)
				puntaje += det.getPuntos();
		}
		return puntaje;
	}
}
