package dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class JuegoDTO {

	private int idJuego;
	private Date fechaJuego;
	private ParejaDTO equipo1;
	private ParejaDTO equipo2;
	private EstadoDTO estado;
	private List<PartidaDTO> partidas;
	private MazoDTO mazo;
	private ModalidadDTO modalidad;
	
	
	
	public JuegoDTO(ParejaDTO equipo1, ParejaDTO equipo2, ModalidadDTO modalidad) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.modalidad = modalidad;
		this.estado = new EstadoDTO(1, "Creado");
		this.fechaJuego = new Date();
		this.partidas = new ArrayList<PartidaDTO>();
		this.mazo = new MazoDTO();
		
		
	}
	public JuegoDTO(int idJuego, Date fechaJuego, ParejaDTO equipo1,
			ParejaDTO equipo2, EstadoDTO estado, List<PartidaDTO> partidas,
			MazoDTO mazo, ModalidadDTO modalidad) {
		this.idJuego = idJuego;
		this.fechaJuego = fechaJuego;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.estado = estado;
		this.partidas = partidas;
		this.mazo = mazo;
		this.modalidad = modalidad;
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
	public MazoDTO getMazo() {
		return mazo;
	}
	public void setMazo(MazoDTO mazo) {
		this.mazo = mazo;
	}
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}
	
	

}
